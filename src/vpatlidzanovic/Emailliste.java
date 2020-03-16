/**
 * 
 */
package vpatlidzanovic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Speichert alle Emails-Adressen eines Sch�lers.
 * @author Viktor Patlidzanovic
 *
 */
public class Emailliste {
	private TreeMap<Sch�ler, HashSet<String>> emails;
	
	/**
	 * Initialisiert das Attribut emails.
	 */
	public Emailliste() {
		this.emails = new TreeMap<>();
	}
	
	/**
	 * F�gt eine Email der bereits bestehenden Liste eines Sch�lers hinzu.
	 * Falls noch kein Eintrag dieses Sch�lers vorhanden ist wird ein neuer erstellt.
	 * @param s der Sch�ler, dem die Email gespeicher werden soll
	 * @param email die Email, die gespeichert werden soll
	 */
	void addEmail(Sch�ler s, String email) {
		if (this.emails.get(s) == null) {
			HashSet<String> set = new HashSet<>();
			set.add(email);
			this.emails.put(s, set);
		} else {
			this.emails.get(s).add(email);
		}
	}
	
	/**
	 * Gibt ein String-Array mit allen Emails des �bergebenen Sch�lers zur�ck.
	 * @param s der Sch�ler, dessen Emails verwendet werden sollen
	 * @return das String-Array
	 */
	public String[] searchEmail(Sch�ler s) {
		String[] cache = null;
		if (this.emails.get(s) != null) {
			HashSet<String> set = this.emails.get(s);
			cache = new String[set.size()];
			set.toArray(cache);
		}
		return cache;
	}
	
	/**
	 * L�scht den Eintrag eines Sch�lers aus dem Attribut emails.
	 * @param s der Sch�ler, der gel�scht werden soll
	 */
	public void removeSch�ler(Sch�ler s) {
		if (this.emails.get(s) != null) this.emails.remove(s);
	}
	
	/**
	 * L�scht eine Email eines Sch�lers aus dem Attribut emails.
	 * @param s der Sch�ler, dessen Email gel�scht werden soll
	 * @param email die Email, die gel�scht werden soll
	 */
	public void removeEmail(Sch�ler s, String email) {
		if (this.emails.get(s) != null) this.emails.get(s).remove(email);
	}
	
	/**
	 * Wandelt das Attribut emails in ein String um. In diesem werden
	 * die Sch�lernamen und -Nachnamen gefolgt von ihren Emails
	 * zur�ckgegeben.
	 */
	public String toString() {
		StringBuilder cache = new StringBuilder();
		Set<Sch�ler> set = emails.keySet();
		for (Sch�ler s: set) {
			cache.append(s.getVorname() + " " + s.getNachname() + ": ");
			String[] emails = searchEmail(s);
			for (int i = 0; i < emails.length; i++) {
				if (i != emails.length - 1) {
					cache.append(emails[i] + ", ");
				} else {
					cache.append(emails[i]);
				}
			}
			cache.append("\n");
		}
		return cache.toString();
	}
}
