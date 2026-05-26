package model;

public class PrivatKurs extends Kurs {

	private double preisProTag;
	
	// ------------------------- Konstruktoren ------------	
	public PrivatKurs(int dauer, double preisProTag) throws TanzschuleException  {
		super(dauer);
		setPreisProTag(preisProTag);
	}

	public PrivatKurs(String line) throws TanzschuleException {
		super(line);
		String[] lineParts = line.trim().split(";");
		if (lineParts.length < 3) {
			throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
		}
		try {
			setPreisProTag(Double.parseDouble(lineParts[2]));
		} catch (NumberFormatException e) {
			throw new TanzschuleException("Fehler bei Kurs mit Preis pro Tag " + lineParts[2] + ", ist keine Zahl");
		}
	}

	// -------------------------- getter -------------------
	public double getPreisProTag() {
		return preisProTag;
	}

	// -------------------- setter ---------------------	
	public void setPreisProTag(double preisProTag) throws TanzschuleException  {
		if (preisProTag > 0.0)
			this.preisProTag = preisProTag;
		else {
			throw new TanzschuleException("Fehler bei setPreisProTag(): preisProTag muss groesser als 0 sein (" + preisProTag + ")");
		}
	}

	// ------------------------ weitere ------------------------

	@Override
	public double preis() {
		return getDauer() * preisProTag;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		PrivatKurs that = (PrivatKurs) o;
		return Double.compare(preisProTag, that.preisProTag) == 0;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + Double.hashCode(preisProTag);
		return result;
	}

	// ----------------------- toString ------------------------
	public String toString() {
		return super.toString() + ", Preis pro Tag: " + preisProTag + " EUR";
	}

	public String toCsvString() {
		return super.toCsvString()+ ";" + preisProTag;
	}
}
