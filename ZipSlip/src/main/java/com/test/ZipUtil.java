package com.test;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {


    /**
     * 解压缩zip包
     *
     * @param zipFilePath
     *              - zip文件路径
     * @param targetPath
     *              - 解压缩到的位置, 如果为null或空字符串则默认解压缩到跟zip包目录下
     * @throws IOException
     */
    public static void unzip(String zipFilePath, String targetPath) throws IOException {
        OutputStream os = null;
        InputStream is = null;
        ZipFile zipFile = null;

        try {
            zipFile = new ZipFile(zipFilePath);
            String directoryPath;
            if (StringUtils.isBlank(targetPath)) {
                directoryPath = zipFilePath.substring(0, zipFilePath.lastIndexOf("."));
            } else {
                directoryPath = targetPath;
            }
            new File(directoryPath).mkdirs();
            Enumeration<?> entryEnum = zipFile.entries();
            if (entryEnum != null) {
                ZipEntry zipEntry;
                while (entryEnum.hasMoreElements()) {
                    zipEntry = (ZipEntry) entryEnum.nextElement();
                    if (zipEntry.isDirectory()) {
                        buildFile(directoryPath + File.separator + zipEntry.getName(), true);
                        continue;
                    }
                    if (zipEntry.getSize() > 0) {
                        File targetFile = buildFile(directoryPath + File.separator + zipEntry.getName(), false);
                        os = new BufferedOutputStream(new FileOutputStream(targetFile));
                        is = zipFile.getInputStream(zipEntry);
                        int buffSize = 4096;
                        byte[] buffer = new byte[buffSize];
                        int readLen;
                        while ((readLen = is.read(buffer, 0, buffSize)) >= 0) {
                            os.write(buffer, 0, readLen);
                        }
                        os.flush();
                        os.close();
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File buildFile(String fileName, boolean isDirectory) {
        File target = new File(fileName);
        if (isDirectory) {
            target.mkdirs();
        } else {
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
            }
        }
        return target;
    }

    public static void main(String[] args) throws IOException {
        unzip("./malicious.zip","/tmp/test/unzip");
    }

}
