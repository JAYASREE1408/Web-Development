import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class DomParser {
    public String[] searchStudent(String search){
        String[] s = new String[5];
        try {
            File inputFile = new File("\\input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("---------------------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Current Element"+nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement =(Element)nNode;
                    if(eElement.getAttribute("rollno").equals(search)){
                        s[0]=eElement.getAttribute("rollno");
                        s[1]=eElement.getElementsByTagName("firstname").item(0).getTextContent();
                        s[2]=eElement.getElementsByTagName("lastname").item(0).getTextContent();
                        s[3]=eElement.getElementsByTagName("yearofstudy").item(0).getTextContent();
                        s[4]=eElement.getElementsByTagName("cgpa").item(0).getTextContent();
                        return s;
                    }
                }
            } 
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }return null;
    }
}
