/**
 * 
 */
package vpatlidzanovic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Speichert alle Emails-Adressen eines Schülers.
 * @author Viktor Patlidzanovic
 *
 */
public class Emailliste {
	private TreeMap<Schüler, HashSet<String>> emails;
	
	/**
	 * Initialisiert das Attribut emails.
	 */
	public Emailliste() {
		this.emails = new TreeMap<>();
	}
	
	/**
	 * Fügt eine Email der bereits bestehenden Liste eines Schülers hinzu.
	 * Falls noch kein Eintrag dieses Schülers vorhanden ist wird ein neuer erstellt.
	 * @param s der Schüler, dem die Email gespeicher werden soll
	 * @param email die Email, die gespeichert werden soll
	 */
	void addEmail(Schüler s, String email) {
		if (this.emails.get(s) == null) {
			HashSet<String> set = new HashSet<>();
			set.add(email);
			this.emails.put(s, set);
		} else {
			this.emails.get(s).add(email);
		}
	}
	
	/**
	 * Gibt ein String-Array mit allen Emails des übergebenen Schülers zurück.
	 * @param s der Schüler, dessen Emails verwendet werden sollen
	 * @return das String-Array
	 */
	public String[] searchEmail(Schüler s) {
		String[] cache = null;
		if (this.emails.get(s) != null) {
			HashSet<String> set = this.emails.get(s);
			cache = new String[set.size()];
			set.toArray(cache);
		}
		return cache;
	}
	
	/**
	 * Löscht den Eintrag eines Schülers aus dem Attribut emails.
	 * @param s der Schüler, der gelöscht werden soll
	 */
	public void removeSchüler(Schüler s) {
		if (this.emails.get(s) != null) this.emails.remove(s);
	}
	
	/**
	 * Löscht eine Email eines Schülers aus dem Attribut emails.
	 * @param s der Schüler, dessen Email gelöscht werden soll
	 * @param email die Email, die gelöscht werden soll
	 */
	public void removeEmail(Schüler s, String email) {
		if (this.emails.get(s) != null) this.emails.get(s).remove(email);
	}
	
	/**
	 * Wandelt das Attribut emails in ein String um. In diesem werden
	 * die Schülernamen und -Nachnamen gefolgt von ihren Emails
	 * zurückgegeben.
	 */
	public String toString() {
		StringBuilder cache = new StringBuilder();
		Set<Schüler> set = emails.keySet();
		for (Schüler s: set) {
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
