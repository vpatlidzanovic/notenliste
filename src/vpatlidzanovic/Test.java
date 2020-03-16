/**
 * 
 */
package vpatlidzanovic;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Testet das Programm.
 * @author Viktor Patlidzanovic
 *
 */
public class Test {

	/**
	 * Testet das Programm.
	 * @param args
	 */
	public static void main(String[] args) {
		//Testet Klasse Schüler
		System.out.println("Klasse Schüler:");
		SortedSet<Schüler> s = new TreeSet<>();
		s.add(new Schüler(19, "Viktor", "Patlidzanovic", "B"));
		
		System.out.println("Equals:");
		System.out.println(s.first().equals(new Schüler(19, "Viktor", "Patlidzanovic", "B")));
		
		System.out.println("\nHashCode:");
		System.out.println(s.first().hashCode());
		
		System.out.println("\nCompareTo:");
		System.out.println(s.first().compareTo(new Schüler(20, "Viktor", "Patlidzanovic", "B")));
		
		System.out.println("\nNoten:");
		s.first().noteHinzu(Gegenstand.AM, 1);
		s.first().noteHinzu(Gegenstand.E, 3);
		System.out.println(s.first().notenListe());
		
		System.out.println("\nNote von Gegenstand AM:");
		System.out.println(s.first().note(Gegenstand.AM));
		
		
		System.out.println("\n--------------\n");
		
		
		//Testet Klasse Emailliste
		System.out.println("Klasse Emailliste:");
		Emailliste e = new Emailliste();
		Schüler viktor = new Schüler(19, "Viktor", "Patlidzanovic", "B");
		e.addEmail(viktor, "vpatlidzanovic@student.tgm.ac.at");
		e.addEmail(viktor, "max.mustermann@gmail.com");
		
		System.out.println("Hinzugefügte Emails:");
		System.out.println(e.toString());
		
		e.removeEmail(viktor, "max.mustermann@gmail.com");
		System.out.println("\nLöschen von Email max.mustermann@gmail.com:");
		System.out.println(e.toString());
		
		e.removeSchüler(viktor);
		System.out.println("\nLöschen von Schüler Viktor:");
		System.out.println(e.toString());
	}

}
