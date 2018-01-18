package textExcel;

public class RealCell implements Cell
{
	private String stringValue;
	
	public RealCell(String value) {
		stringValue = value;
	}
	
	public String abbreviatedCellText()
	{
		 return Spreadsheet.truncateOrPad(String.valueOf(getDoubleValue()));
	}
	
	public double getDoubleValue()
	{
		return 0;
	}

	
	public String fullCellText() {
		return stringValue;
	}
	
}
