// Erweitern Sie diese Basisklasse der Angabe entsprechend

package model;


import java.io.Serializable;
import java.text.ParseException;

public abstract class Kurs implements Serializable
{
	private int dauer;
// ------------------------- Konstruktoren ------------
	public Kurs(int dauer) throws TanzschuleException {
		setDauer(dauer);
	}

	public Kurs(String line) throws TanzschuleException {
		if (line == null) {
			throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", ist kein Kurs");
		}
		String[] lineParts = line.trim().split(";");
		if (lineParts.length < 2) {
			throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
		}
		try {
			setDauer(Integer.parseInt(lineParts[1]));
		} catch (NumberFormatException e) {
			throw new TanzschuleException("Fehler bei Kurs mit Dauer " + lineParts[1] + ", ist keine Zahl");
		}
	}

	// -------------------------- getter -------------------
	public int getDauer() {
		return dauer;
	}
	// -------------------- setter ---------------------
	public void setDauer(int dauer) throws TanzschuleException {
		if (dauer > 0)
			this.dauer = dauer;
		else {
			throw new TanzschuleException("Fehler bei setDauer(): dauer muss groesser 0 sein (" + dauer + ")");
		}
	}

	// ------------------------ weitere ------------------------

	public abstract double preis();

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Kurs kurs = (Kurs) o;
		return dauer == kurs.dauer;
	}

	@Override
	public int hashCode() {
		return dauer;
	}


	// ----------------------- toString ------------------------

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getSimpleName()).append(": "); // neu
		sb.append("Dauer: ").append(dauer);
		return sb.toString();
	}

	public String toCsvString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getSimpleName()).append(";");
		sb.append(dauer);
		return sb.toString();
	}
}
