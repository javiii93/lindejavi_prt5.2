package pt5_2_m6;

import java.util.ArrayList;

public class Curs {
String cursId;
Tutor tutorCurs;
ArrayList<Alumne>listaAlumnes=new ArrayList<>();
ArrayList<Modul>listaModulos=new ArrayList<>();
public Curs(String cursId, Tutor tutorCurs, ArrayList<Alumne> listaAlumnes, ArrayList<Modul> listaModulos) {
	super();
	this.cursId = cursId.toUpperCase();
	this.tutorCurs = tutorCurs;
	this.listaAlumnes = listaAlumnes;
	this.listaModulos = listaModulos;
}

}
