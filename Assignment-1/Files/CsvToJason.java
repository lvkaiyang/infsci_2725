package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CsvToJason {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// tags first
		System.out.println("Start with transfering tags.dat to tags.json");
		String csvFileToRead = "/Users/weiyituo/Desktop/Data analytic/project1/Mongo_assignment_1_25_16/tags.dat";
		BufferedReader br = null;
		String line = "";
		String splitBy = "::";
		PrintWriter writer = new PrintWriter("/Users/weiyituo/Desktop/Data analytic/project1/tags.json", "UTF-8");
		try {
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(splitBy);
				writer.println("{ \"UserID\": " + row[0] + ", \"MovieID\": " + row[1] + ", \"Tag\": \"" + row[2]
						+ "\", \"Timestamp\": " + row[3] + " },");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		writer.close();
		System.out.println("Done with transfering tags.dat to tags.json");
		// Rating second
		System.out.println("Start with transfering ratings.dat to rating.json");
		csvFileToRead = "/Users/weiyituo/Desktop/Data analytic/project1/Mongo_assignment_1_25_16/ratings.dat";
		br = null;
		line = "";
		splitBy = "::";
		writer = new PrintWriter("/Users/weiyituo/Desktop/Data analytic/project1/rating.json", "UTF-8");
		try {
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(splitBy);
				writer.println("{ \"UserID\": " + row[0] + ", \"MovieID\": " + row[1] + ", \"Rating\": " + row[2]
						+ ", \"Timestamp\": " + row[3] + " },");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		writer.close();
		System.out.println("Done with transfering ratings.dat to ratings.json");
		// Movie at the end
		System.out.println("Start with transfering movies.dat to movies.json");
		csvFileToRead = "/Users/weiyituo/Desktop/Data analytic/project1/Mongo_assignment_1_25_16/movies.dat";
		br = null;
		line = "";
		splitBy = "::";
		writer = new PrintWriter("/Users/weiyituo/Desktop/Data analytic/project1/movies.json", "UTF-8");
		try {
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(splitBy);
				writer.print("{ \"MovieID\": " + row[0] + ", \"Title\": \"" + row[1] + "\", \"Genres\": [");
				int length = row.length;
				for (int i = 2; i < length; i++) {
					writer.print("\"" + row[i] + "\"");
					if (i < length - 1)
						writer.print(", ");
				}
				writer.println("] },");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		writer.close();
		System.out.println("Done with transfering movies.dat to movies.json");
	}

}
