package pt5_2_m6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.SAXException;

import java.io.File;


public class Main {
	static Scanner sc;
	static String curso,alumno;
	static File fXmlFile;
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("cursos");
			doc.appendChild(rootElement);

			// definimos cada uno de los elementos y le asignamos un valor

				Element curso = doc.createElement("curs");
				rootElement.appendChild(curso);
				Attr attid = doc.createAttribute("id");
				attid.setValue("AMS2");
				curso.setAttributeNode(attid);
				Element eTutor = doc.createElement("tutor");
				eTutor.appendChild(doc.createTextNode("LARA,Francesc"));
				curso.appendChild(eTutor);
				Element eAlumnos = doc.createElement("alumnes");
				Element eAlumnos1 = doc.createElement("alumne");
				eAlumnos1.appendChild(doc.createTextNode("ALVAREZ, Tomas"));
				eAlumnos.appendChild(eAlumnos1);
				Element eAlumnos2 = doc.createElement("alumne");
				eAlumnos2.appendChild(doc.createTextNode("CAMACHO, David"));
				eAlumnos.appendChild(eAlumnos2);
				Element eAlumnos3 = doc.createElement("alumne");
				eAlumnos3.appendChild(doc.createTextNode("CASTRO, Joaquin"));
				eAlumnos.appendChild(eAlumnos3);
				Element eAlumnos4 = doc.createElement("alumne");
				eAlumnos4.appendChild(doc.createTextNode("DE LA CRUZ, Sergio"));
				eAlumnos.appendChild(eAlumnos4);
				Element eAlumnos5 = doc.createElement("alumne");
				eAlumnos5.appendChild(doc.createTextNode("DIAZ, Jose"));
				eAlumnos.appendChild(eAlumnos5);
				Element eAlumnos6 = doc.createElement("alumne");
				eAlumnos6.appendChild(doc.createTextNode("FERNANDEZ, Jose M"));
				eAlumnos.appendChild(eAlumnos6);
				curso.appendChild(eAlumnos);
				Element eModuls = doc.createElement("moduls");
				Attr attid2 = doc.createAttribute("id");
				attid2.setValue("M06");
				eModuls.setAttributeNode(attid2);
				Element eTitol = doc.createElement("titol");
				eTitol.appendChild(doc.createTextNode("Acces a dades"));
				eModuls.appendChild(eTitol);
				Element eProfes=doc.createElement("profes");
				Element eProfes1=doc.createElement("profe");
				eProfes1.appendChild(doc.createTextNode("Fuentes, Julian"));
				eProfes.appendChild(eProfes1);
				eModuls.appendChild(eProfes);
				Element eUfs=doc.createElement("ufs");
				Element eUf0=doc.createElement("uf");
				eUf0.appendChild(doc.createTextNode("Persistencia en fitxers"));
				eUf0.setAttribute("n","1");
				eUfs.appendChild(eUf0);
				Element eUf1=doc.createElement("uf");
				eUf1.appendChild(doc.createTextNode("Persistencia en BDR-BDOR-BDOO"));
				eUf1.setAttribute("n","2");
				eUfs.appendChild(eUf1);
				Element eUf2=doc.createElement("uf");
				eUf2.appendChild(doc.createTextNode("Persistencia en BD natives XML"));
				eUf2.setAttribute("n","3");
				eUfs.appendChild(eUf2);
				Element eUf3=doc.createElement("uf");
				eUf3.appendChild(doc.createTextNode("Components d'acces a dades"));
				eUf3.setAttribute("n","4");
				eUfs.appendChild(eUf3);
				eModuls.appendChild(eUfs);
				
				
				
				
				curso.appendChild(eModuls);
				
		
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Fichero.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(introducirCurso());
		System.out.println(introducirNombreAlumno());
		

	}
	static public boolean introducirCurso() throws ParserConfigurationException, SAXException, IOException {
		
		fXmlFile = new File("Fichero.xml");
		
		sc=new Scanner(System.in);
		System.out.println("\nIntroduce el nombre del curso: ");
		curso=sc.next().toUpperCase();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList = doc.getElementsByTagName("curs");
		for(int i=0;i<nList.getLength();i++) {
			Node nNode=nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eEl = (Element) nNode;

				if(eEl.getAttribute("id")==curso) {
					return true;
				}

			}
		}sc.next();
		return false;
	}
	@SuppressWarnings("unlikely-arg-type")
	static public boolean introducirNombreAlumno() throws ParserConfigurationException, SAXException, IOException {
		if(curso=="") {
			System.out.println("Primero introduzca un curso para añadir o eliminar un alumno");
			return false;
		}
		fXmlFile = new File("Fichero.xml");
		
		sc=new Scanner(System.in);
		System.out.println("\nIntroduce el nombre del alumno de la siguiente manera: ");
		System.out.println("APELLIDO, Nombre");
		System.out.println("El apellido en mayusculas y en el nombre con la primera en mayusculas");
		alumno=sc.next().toUpperCase();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList = doc.getElementsByTagName("curs");
		for(int i=0;i<nList.getLength();i++) {
			Node nNode=nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eEl = (Element) nNode;

				if(eEl.getAttribute("id")==curso) {
					NodeList nList2 = doc.getElementsByTagName("alumnes");
					
					for(int j=0;j<nList2.getLength();j++) {
						Node nNode2=nList2.item(j);
						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							Element eEl2 = (Element) nNode;
							if(eEl2.getElementsByTagName("alumne").equals(alumno)) {
								sc.next();
								return true;
							}
						}
					}
				}

			}
		}sc.next();
		return false;
		
		
		
		
	}
	static public void eliminarAlumno() throws ParserConfigurationException, SAXException, IOException {
		while(!introducirCurso()) {
			System.out.println("El curso no existe o no se ha reconocido vuelva a introducirlo");
		}
		
		
	}static public void añadirAlumno() {
		
		
	}
	}

