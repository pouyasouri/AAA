package textExcel;

public class ValueCell extends RealCell
{
	private double doubleValue;
	public ValueCell(String stringValue) {
		super(stringValue);
		this.doubleValue = Double.valueOf(stringValue);
	}

	
	public double getDoubleValue() {
		return doubleValue;
	}

	
	public String cellType() {
		return "ValueCell";
	}
}
