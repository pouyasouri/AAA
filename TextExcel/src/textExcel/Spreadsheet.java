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
		return "";
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
		// TODO Auto-generated method stub
		return cell[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		 String grid = "";
	        for (int i = 0; i < cell[0].length; i++) {
	            grid += String.format("|%-10c", (char) (i + 'A'));
	        }
	        grid += "|\n";
	        for (int i = 0; i < cell.length; i++) {
	            grid += String.format("%-3d", i + 1) + formatRow(cell[i]);
	        }
	        return grid;
	}
	 public String formatCellText(Cell cell) {
	        return "|" + cell.abbreviatedCellText();
	    }

	    public String formatRow(Cell[] cells) {
	        String row = "";
	        for (Cell cell : cells) {
	            row += formatCellText(cell);
	        }
	        row += "|\n";
	        return row;
	    }
	
	public static String truncateOrPad(String value, int length) {
		String format = "%-" + length + "." + length + "s";
		return String.format(format, value);
	}

	public static String truncateOrPad(String value) {
		return truncateOrPad(value, 10);
	}
	
	public boolean clearCell(SpreadsheetLocation loc) {
		return setCell(loc, new EmptyCell());
	}
	
	public void clearAll() {
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 12; col++) {
				cell[row][col] = new EmptyCell();
			}
		}
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
