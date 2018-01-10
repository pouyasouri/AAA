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
		return null;
	}

	@Override
	public String getGridText()
	{
		String outcome = "";
		return null;
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
