package model;

public class GruppenKurs extends Kurs {

	private double preisPauschal;

	// ------------------------- Konstruktoren ------------

	public GruppenKurs(int dauer, double preisPauschal) throws TanzschuleException  {
		super(dauer);
		setPreisPauschal(preisPauschal);
	}

	public GruppenKurs(String line) throws TanzschuleException {
		super(line);
		String[] lineParts = line.trim().split(";");
		if (lineParts.length < 3) {
			throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
		}
		try {
			setPreisPauschal(Double.parseDouble(lineParts[2]));
		} catch (NumberFormatException e) {
			throw new TanzschuleException("Fehler bei Kurs mit Preis pauschal " + lineParts[2] + ", ist keine Zahl");
		}
	}
	
	// -------------------------- getter -------------------
	public double getPreisPauschal() {
		return preisPauschal;
	}
	
	// -------------------- setter ---------------------	
	public void setPreisPauschal(double preisPauschal) throws TanzschuleException  {
		if (preisPauschal > 0.0)
			this.preisPauschal = preisPauschal;
		else {
			throw new TanzschuleException("Fehler bei setPreisPauschal(): preisPauschal muss groesser als 0 sein (" + preisPauschal + ")");
		}
	}
	
	// ------------------------ weitere ------------------------

	@Override
	public double preis() {
		return preisPauschal;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		GruppenKurs that = (GruppenKurs) o;
		return Double.compare(preisPauschal, that.preisPauschal) == 0;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + Double.hashCode(preisPauschal);
		return result;
	}

	// ----------------------- toString ------------------------
	public String toString() {
		return super.toString() + ", Preis pauschal: " + preisPauschal + " EUR";
	} // Neu

	public String toCsvString() {
		return super.toCsvString() + ";" + preisPauschal;
	}
}
