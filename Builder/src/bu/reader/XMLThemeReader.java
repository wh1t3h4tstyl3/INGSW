package bu.reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import bu.builders.ThemeBuilder;

public class XMLThemeReader {
	
	private ThemeBuilder themeBuilder;
	boolean titleSetted;
	boolean authorSetted;
	public XMLThemeReader() {
		titleSetted = false;
		authorSetted = false;
	}
	
	public void read(File file, ThemeBuilder themeBuilder) {
		this.themeBuilder = themeBuilder;
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element : " + doc.getDocumentElement().getNodeName() + "\n");
		
		if(doc.hasChildNodes())
			printNote(doc.getChildNodes());
	}
	
	private void printNote(NodeList nodeList) {
		String color = "";
		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("Node Name = " + tempNode.getNodeName() + " [OPEN]");

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
						
						if(node.getNodeName().equals("author") && !authorSetted) {
							themeBuilder.convertTitle(node.getNodeValue());
							authorSetted = true;
						}
						
						else if(node.getNodeName().equals("name") && !titleSetted) {
							themeBuilder.convertTitle(node.getNodeValue());
							titleSetted = true;
						}
						
						else if(node.getNodeName().equals("color")) {
							color = node.getNodeValue(); 
						}

					}

				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					System.out.println();
					printNote(tempNode.getChildNodes());

				}

				System.out.println("Node Name = " + tempNode.getNodeName() + " [CLOSE]\n");
				if(color.length() > 0)
					themeBuilder.convertContent(tempNode.getNodeName(), color);
			}

		}
	}
}
