/**
 * 
 */
package vpatlidzanovic;

/**
 * Eine Liste aller Gegenst�nde.
 * @author Viktor Patlidzanovic
 *
 */
public enum Gegenstand {
	AM("Angewandte Mathematik"),
	E("Englisch"),
	D("Deutsch"),
	SYT("Systemtechnik"),
	SEW("Softwareentwicklung"),
	INSY("Informationstechnische Systeme"),
	INFI("Informationstechnische Systeme"),
	NW("Naturwissenschaften"),
	ITP("Informationstechnische Projekte"),
	MEDT("Medientechnik"),
	RK("Religion"),
	GGP("Geschichte"),
	NWT("Netzwerktechnik"),
	BESP("Bewegung und Sport");
	
	
	private String langname;
	
	/**
	 * Initilsiert das Attribut Langanme.
	 * @param langname
	 */
	private Gegenstand(String langname) {
		this.langname = langname;
	}
	
	/**
	 * Gibt den Wert des Attributs Langname zur�ck.
	 * @return gibt den Wert zur�ck
	 */
	public String getLangname() {
		return this.langname;
	}
}
