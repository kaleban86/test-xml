package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class CreateXmlFIle {




    public void createXml(List<Integer> num) throws ParserConfigurationException, TransformerException {


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();

        Document document = dbuilder.newDocument();

        Element entries = document.createElement("entries");
        document.appendChild(entries);


        Element user = document.createElement("entry");
        entries.appendChild(user);

        Element field = document.createElement("field");

        field.appendChild(  document.createTextNode( num + " field"));
        user.appendChild(field);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(new File("D:\\1.xml"));
        transformer.transform(source, result);

        System.out.println("File created successfully");
    }
}
