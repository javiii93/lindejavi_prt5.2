package pt5_2_m6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
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

import java.io.File;


public class Main {

	public static void main(String[] args) {
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
				Element eUfs1=doc.createElement("Persistencia en fitxers");
				eUfs1.setAttribute("n","1");
				eUfs0.appendChild(eUfs1);
				eUfs.appendChild(eUfs0);
				/*
				Element eUfs2=doc.createElement("Persistencia en BDR-BDOR-BDOO");
				Attr at1=doc.createAttribute("n");
				at1.setValue("2");
				eUfs2.setAttributeNode(at1);
				eUfs.appendChild(eUfs2);
				Element eUfs3=doc.createElement("Persistencia en BD natives XML");
				Attr at2=doc.createAttribute("n");
				at2.setValue("3");
				eUfs3.setAttributeNode(at2);
				eUfs.appendChild(eUfs3);
				Element eUfs4=doc.createElement("Components d'acces a dades");
				Attr at4=doc.createAttribute("n");
				at4.setValue("4");
				eUfs4.setAttributeNode(at4);
				eUfs.appendChild(eUfs4);
				*/
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

	}
	}

