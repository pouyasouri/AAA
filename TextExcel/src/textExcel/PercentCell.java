package textExcel;

public class PercentCell extends ValueCell
{
	
	private String value;	
	public PercentCell(String value) {
		super(value);
		this.value = value;
	}
	
	@Override
	public String abbreviatedCellText() {
		
		String s = value;
		if(value.contains("."))
		    s = value.substring(0, value.indexOf("."));
		s += "%";
		for(int i = s.length(); i < 10; i++) {
			s += " ";
		}
		
		return s;
	}
	
	public String fullCellText() {
		double n = Double.parseDouble(value);
		n /= 100;
	    String s = Double.toString(n);
		return s;
	}
}
