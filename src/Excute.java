import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Excute {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // TODO Auto-generated method stub
        DSBook dsBook=new DSBook();
        dsBook.ReadXML();
        dsBook.printdsBook();
    }
}
