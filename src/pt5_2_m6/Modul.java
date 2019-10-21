package pt5_2_m6;

import java.util.ArrayList;

public class Modul {
String modulid,titol;
ArrayList<Professors>profesores=new ArrayList<>();
ArrayList<String>uf=new ArrayList<>();
public Modul(String modulid, String titol, ArrayList<Professors> profesores, ArrayList<String> uf) {
	super();
	this.modulid = modulid;
	this.titol = titol;
	this.profesores = profesores;
	this.uf = uf;
}


}
