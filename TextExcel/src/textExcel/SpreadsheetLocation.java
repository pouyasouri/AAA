package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	static String Input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	 public SpreadsheetLocation(int rowp, int colp) {
	        row = rowp;
	        col = colp;
	    }
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return col;
    }
    public static int CCTI(char character) {
    	return Input.indexOf(Character.toUpperCase(character));
    }
    
    public static char CITC (int idx) {
    	return Input.charAt(idx);
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	col = Character.toUpperCase(cellName.charAt(0)) - 'A';
    	row = cellName.indexOf(1);
    }

}
