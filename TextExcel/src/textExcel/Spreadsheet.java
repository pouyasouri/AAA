package textExcel;

import sun.invoke.empty.Empty;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cell;
	
	public Spreadsheet(){
		cell = new Cell [12][20];
		for (int i=0; i < 12; i++){
			for (int j=0; j < 20; j++){
				cell[i][j] = new EmptyCell();
			}
		}
		
	}

	@Override
	public String processCommand(String command)
	{
		if(command.equals(""))
			return "";
		if(command.length() <= 3)
		    return inspect(command);
		if(command.contains("="))
			return assignment(command);
		if(command.toLowerCase().contains("clear") && command.length() > 5)
			return clearOne(command);
		else
			return clear();
	}
	public String inspect(String command) {
		SpreadsheetLocation Cell = new SpreadsheetLocation(command);
		int row = Cell.getRow();
		int col = Cell.getCol();
		cell[row][col] = getCell(Cell);
		String s = cell[row][col].fullCellText();
		return s;
		
	}
	
    public String assignment(String command) {
    	int equalIndex = command.indexOf("=");
		String word = command.substring(equalIndex + 2);
		String numWord = command.substring(equalIndex + 2);
		String percentWord = numWord.substring(0, numWord.length() - 1);
		String cellName = command.substring(0 , equalIndex - 1);
		
		SpreadsheetLocation Cell = new SpreadsheetLocation(cellName);
		int row = Cell.getRow();
		int col = Cell.getCol();
			
		if(command.contains("\""))
		    cell[row][col] = new TextCell(word.substring(0, word.length()));
		
		if(command.indexOf("%") == -1 && command.indexOf("\"") == -1)
			cell[row][col] = new ValueCell(numWord);
		
		if(command.contains("%"))
			cell[row][col] = new PercentCell(percentWord);
		
		return getGridText();
	}
	public boolean setCell(SpreadsheetLocation location, Cell value) {
		if (location == null || value == null) {
			return false;
		}
		if (location.getRow() < 0 || location.getRow() >= getRows()) {
			return false;
		}
		if (location.getCol() < 0 || location.getCol() >= getCols()) {
			return false;
		}
		cell[location.getRow()][location.getCol()] = value;
		return true;
	}

	@Override
	public int getRows()
	{
		return cell.length;
	}

	@Override
	public int getCols()
	{
		return cell[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cell[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String sheet = "   |A         |B         |C         |D         |E         |F         |"
				+ "G         |H         |I         |J         |K         |L         |";
		
		
		for(int i = 0; i < cell.length; i++) {
			if(i < 9)
			    sheet += "\n" + (i+1) + "  |";
			if(i >= 9)
				sheet += "\n" + (i+1) + " |";
			for(int j = 0; j < cell[i].length; j++) {
				sheet += cell[i][j].abbreviatedCellText() + "|";	
			}
		}
		sheet += "\n";
		
		return sheet;
	}
	
	public static String truncateOrPad(String value, int length) {
		String format = "%-" + length + "." + length + "s";
		return String.format(format, value);
	}

	public static String truncateOrPad(String value) {
		return truncateOrPad(value, 10);
	}
	
	public String clear() {
    	for(int i = 0; i < cell.length; i++) {
			for(int j = 0; j < cell[j].length; j++) {
				cell[i][j] = new EmptyCell();
			}
		}
    	return getGridText();
    }
    
    public String clearOne(String command) {
    	String cellName = command.substring(6);
    	
    	SpreadsheetLocation Cell = new SpreadsheetLocation(cellName);
		int row = Cell.getRow();
		int col = Cell.getCol();
		
		cell[row][col] = new EmptyCell();
		return getGridText();
    }

	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}

	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
}
