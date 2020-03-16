/**
 * 
 */
package vpatlidzanovic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Viktor Patlidzanovic
 *
 */
public class Schüler implements Comparable<Schüler>, Serializable {
	private static final long serialVersionUID = 42L;
	
	private int katalognummer;
	private String vorname;
	private String nachname;
	private String gruppe;
	private HashMap<Gegenstand, Integer> notenListe;
	
	/**
	 * Initalisiert alle Attribute.
	 * @param katalognummer die Katalognummer, die gespeichert werden soll
	 * @param vorname der Vorname, der gespeichert werden soll
	 * @param nachname der Nachname, der gespeichert werden soll
	 * @param gruppe die Gruppe, die gespeichert werden soll
	 */
	public Schüler(int katalognummer, String vorname, String nachname, String gruppe) {
		this.katalognummer = katalognummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gruppe = gruppe;
		this.notenListe = new HashMap<>();
	}

	/**
	 * Gibt das Attribut katalognummer zurück.
	 * @return den im Attribut katalognummer gespeicherten Wert
	 */
	public int getKatalognummer() {
		return this.katalognummer;
	}

	/**
	 * Setzt den Wert des Attributs katalognummer.
	 * @param katalognummer die Katalognummer, die gespeichert werden soll
	 */
	public void setKatalognummer(int katalognummer) {
		if (katalognummer >= 0) this.katalognummer = katalognummer;
	}

	/**
	 * Gibt das Attribut vorname zurück.
	 * @return den im Attribut vorname gespeicherten Wert
	 */
	public String getVorname() {
		return this.vorname;
	}

	/**
	 * Setzt den Wert des Attributs vorname.
	 * @param vorname der Vorname, der gespeichert werden soll
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Gibt das Attribut nachname zurück.
	 * @return den im Attribut nachname gespeicherten Wert
	 */
	public String getNachname() {
		return this.nachname;
	}

	/**
	 * Setzt den Wert des Attributs nachname.
	 * @param nachname der Nachname, der gespeichert werden soll
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Gibt das Attribut gruppe zurück.
	 * @return den im Attribut gruppe gespeicherten Wert
	 */
	public String getGruppe() {
		return this.gruppe;
	}

	/**
	 * Setzt den Wert des Attributs gruppe.
	 * @param gruppe die Gruppe, die gespeichert werden soll
	 */
	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schüler other = (Schüler) obj;
		if (katalognummer != other.katalognummer)
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false; 
		} else if (!vorname.equals(other.vorname))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false; 
		} else if (!nachname.equals(other.nachname))
			return false;
		if (gruppe == null) {
			if (other.gruppe != null)
				return false; 
		} else if (!gruppe.equals(other.gruppe))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + katalognummer;
		result = prime * result * ((vorname == null) ? 0 : vorname.hashCode());
		result = prime * result * ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result * ((gruppe == null) ? 0 : gruppe.hashCode());
		return result;
	}

	@Override
	public int compareTo(Schüler o) {
		if(o == null)
			return -1;
		if(this.equals(o))
			return 0;
		int ret = this.katalognummer - o.katalognummer;
		if(ret != 0)
			return ret;
		ret = this.vorname.compareTo(o.vorname);
		if(ret != 0)
			return ret;
		ret = this.nachname.compareTo(o.nachname);
		if(ret != 0)
			return ret;
		ret = this.gruppe.compareTo(o.gruppe);
		if(ret != 0)
			return ret;
		return 0;
	}
	
	/**
	 * Gibt eine liste aller Gegenstände mit den zugehörigen Noten als String zurück.
	 * @return eine Liste aller Gegenstände mit Noten als String
	 */
	public String notenListe() {
		StringBuilder cache = new StringBuilder();
		Set<Gegenstand> set = this.notenListe.keySet();
		for (Gegenstand g: set) {
			cache.append(g + "(" + g.getLangname() + "): " + this.notenListe.get(g)+ ", ");
		}
		return cache.toString();
	}
	
	/**
	 * Gibt die note des übergebenen Gegestandes zurück. Wenn keine Note vorhanden ist
	 * wird -1 zurückgegeben.
	 * @param g der Gegenstand, dessen Note zurückgegeben werden soll
	 * @return die Note
	 */
	public int note(Gegenstand g) {
		if (this.notenListe.get(g) != null) return this.notenListe.get(g);
		return -1;
	}
	
	/**
	 * Fügt eine Note eines Gegenstandes zur Liste hinzu.
	 * @param g der Gegenstand, dessen Note hinzugefügt werden soll
	 * @param note die Note, die hizugefügt werden soll
	 */
	public void noteHinzu(Gegenstand g, int note) {
		this.notenListe.put(g, note);
	}
}
