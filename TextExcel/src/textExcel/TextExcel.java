package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet sheet = new Spreadsheet();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (!input.equals ("quit")) {
			System.out.print(sheet.processCommand(input));
			input = scanner.nextLine();
		}
	}
}

