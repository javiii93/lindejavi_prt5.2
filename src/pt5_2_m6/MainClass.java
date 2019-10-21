package pt5_2_m6;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MainClass {
	static ArrayList<Alumne> listaAlumnes = new ArrayList<>();
	static ArrayList<Modul> listaModulos = new ArrayList<>();
	static ArrayList<Professors> profesores = new ArrayList<>();
	static ArrayList<String> uf = new ArrayList<>();

	public static void main(String[] args) {
		// creamos a los alumnos
		Alumne a1 = new Alumne("ABDELILLAH", "Hicham");
		listaAlumnes.add(a1);
		Alumne a2 = new Alumne("FERNANDEZ", "Ruben");
		listaAlumnes.add(a2);
		Alumne a3 = new Alumne("GARBETA", "Giulio");
		listaAlumnes.add(a3);
		Alumne a4 = new Alumne("GARCIA", "Elmer");
		listaAlumnes.add(a4);
		Alumne a5 = new Alumne("GONZALEZ", "Victor M");
		listaAlumnes.add(a5);
		Alumne a6 = new Alumne("JANSSEN", "Gerard");
		listaAlumnes.add(a6);
		Alumne a7 = new Alumne("LLOPART", "Sergi");
		listaAlumnes.add(a7);
		Alumne a8 = new Alumne("PELAEZ", "Eva");
		listaAlumnes.add(a8);
		Alumne a9 = new Alumne("TROLLANO", "Raul");
		listaAlumnes.add(a9);
		Professors p1 = new Professors("FUENTES", "Julian");
		Professors p2 = new Professors("MESTRE", "Manu");
		Professors p3 = new Professors("fuentes", "julian");
		Professors p4 = new Professors("vilaplana", "Angel");
		Professors p5 = new Professors("lara", "Francesc");
		Tutor t1=(Tutor) p5;
		uf.add("Installacio, configuracio i explotacio d'un SI");
		uf.add("Gestio de la informacio i de recursos en una xarxa");
		uf.add("Implantacio de programari especific");
		Modul m1=new Modul("M01", "Sistemes informatics", profesores, uf);
		listaModulos.add(m1);
		Curs c1 = new Curs("Ams2", t1, listaAlumnes, listaModulos);

		/*
		 * try { DocumentBuilderFactory dbFactory =
		 * DocumentBuilderFactory.newInstance(); DocumentBuilder dBuilder =
		 * dbFactory.newDocumentBuilder(); Document doc = dBuilder.newDocument(); //
		 * root element Element rootElement = doc.createElement("Personas");
		 * doc.appendChild(rootElement);
		 * 
		 * // definimos cada uno de los elementos y le asignamos un valor
		 * 
		 * for (int i = 0; i < cantidadPersonas; i++) { Element persona =
		 * doc.createElement("Persona"); rootElement.appendChild(persona); Persona aux =
		 * (Persona) ois.readObject(); System.out.println(aux.toString()); Attr attid =
		 * doc.createAttribute("id"); attid.setValue(String.valueOf(i+1));
		 * persona.setAttributeNode(attid);
		 * 
		 * Element eNombre = doc.createElement("nombre");
		 * eNombre.appendChild(doc.createTextNode(aux.getNombre()));
		 * persona.appendChild(eNombre);
		 * 
		 * Element eApellido = doc.createElement("apellido");
		 * eApellido.appendChild(doc.createTextNode(aux.getApellido()));
		 * persona.appendChild(eApellido);
		 * 
		 * Element eEdad = doc.createElement("edad");
		 * eEdad.appendChild(doc.createTextNode(String.valueOf(aux.getEdad())));
		 * persona.appendChild(eEdad); } ois.close(); // write the content into xml file
		 * TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 * Transformer transformer = transformerFactory.newTransformer(); DOMSource
		 * source = new DOMSource(doc); StreamResult result = new StreamResult(new
		 * File("Fichero.xml")); transformer.transform(source, result); // Output to
		 * console for testing StreamResult consoleResult = new
		 * StreamResult(System.out); transformer.transform(source, consoleResult); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
	}

}
