package com.tutorialspoint.xml;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTOCSV {
    public static void main(String[] args) {
        try {
            // Input XML file path
            String xmlFilePath = "coursedata.xml";
            // Output CSV file path
            String csvFilePath = "xmlConverted.csv";

            // Read XML file and get Document object
            Document xmlDoc = readXmlFile(xmlFilePath);

            // Get CSV header from XML document
            String csvHeader = getCsvHeader(xmlDoc);

            // Get CSV rows from XML document
            List<String> csvRows = getCsvRows(xmlDoc);

            // Write CSV file
            writeCsvFile(csvFilePath, csvHeader, csvRows);

            System.out.println("XML to CSV conversion completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



	public static Document readXmlFile(String filePath) throws Exception {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // Use DocumentBuilderFactory to create a DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the XML file and create a Document object
        return dBuilder.parse(new File(filePath));
    }

    public static String getCsvHeader(Document xmlDoc) {
        Element rowElement = (Element) xmlDoc.getElementsByTagName("row").item(0);
        NodeList elements = rowElement.getChildNodes();
        StringBuilder sb = new StringBuilder();

        // Extract the element names and append them to the CSV header string
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                sb.append(node.getNodeName()).append(",");
            }
        }
        // Remove the last comma
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    public static List<String> getCsvRows(Document xmlDoc) {
    	NodeList rowElements = xmlDoc.getElementsByTagName("row");
    	List<String> csvRows = new ArrayList<>();
    	
    	    for (int i = 0; i < rowElements.getLength(); i++) {
    	        Element rowElement = (Element) rowElements.item(i);
    	        NodeList elements = rowElement.getChildNodes();
    	        StringBuilder sb = new StringBuilder();

    	        // Extract the element values and append them to the CSV row string
    	        for (int j = 0; j < elements.getLength(); j++) {
    	            Node node = elements.item(j);
    	            if (node.getNodeType() == Node.ELEMENT_NODE) {
    	                sb.append(node.getTextContent()).append(",");
    	            }
    	        }
    	        // Remove the last comma
    	        sb.setLength(sb.length() - 1);

    	        // Add the row string to the list of CSV rows
    	        csvRows.add(sb.toString());
    	    }

    	    return csvRows;
    	}
    public static void writeCsvFile(String filePath, String csvHeader, List<String> csvRows) throws Exception {
        // Create a FileWriter
        FileWriter writer = new FileWriter(filePath);

        // Write the header to the CSV file
        writer.append(csvHeader);
        writer.append("\n");

        // Write the rows to the CSV file
        for (String row : csvRows) {
            writer.append(row);
            writer.append("\n");
        }

        // Close the FileWriter
        writer.flush();
        writer.close();
    }
    	}