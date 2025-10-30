import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DSBook {
    ArrayList<book> dsbook=new ArrayList<>();
    public ArrayList<book> getDsbook(){
        return this.dsbook;
    }
    public void setDsbook(ArrayList<book> dsbook){
        this.dsbook=dsbook;
    }
    public DSBook(){
        super();
        this.dsbook=new ArrayList<>();
    }
    public void ReadXML() throws ParserConfigurationException, SAXException, IOException{
        File xmlFile=new File("dsBook.xml");
        DocumentBuilderFactory dbFatory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder=dbFatory.newDocumentBuilder();
        Document doc=dbBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root "+doc.getDocumentElement().getNodeName());
        NodeList nodeList=doc.getElementsByTagName("book");
        System.out.println("--------------------");
        for(int i=0;i<nodeList.getLength();i++){
            book book = new book();
            Node node=nodeList.item(i);
            if(node.getNodeType()==node.ELEMENT_NODE){
                Element element=(Element) node;
                book.setId(element.getElementsByTagName("id").item(0).getTextContent());
                book.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
                book.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                book.setPrice(Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent()));
            }
            dsbook.add(book);
        }
    }
    public void printdsBook(){
        for(book book:dsbook){
            System.out.println("Id "+book.getId());
            System.out.println("Author "+book.getAuthor());
            System.out.println("Title "+book.getTitle());
            System.out.println("Price "+book.getPrice());
            System.out.println("-----------------");
        }
    }
    public void SortList() {
        Collections.sort(dsbook, book.BookPrice);
        printdsBook();
    }
}
