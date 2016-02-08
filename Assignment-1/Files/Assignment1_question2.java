import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Assignment1_question2 {
	public static void main(String args[]) {

		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("local");
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db_1 = mongoClient.getDatabase("local");// Reinput your
																// database's
																// name if it's
																// different.
		DBCollection collection = db.getCollection("movies");
		CountGenres(collection, db_1);
	}

	public static void CountGenres(DBCollection collection, MongoDatabase db_1) {
		DBCursor cursor = collection.find();
		TreeSet<String> ts = new TreeSet<String>();
		String[] genres;
		while (cursor.hasNext()) {
			genres = ((BasicDBObject) cursor.next()).get("Genres").toString().split("\\|");
			for (int i = 0; i < genres.length; i++) {
				String temp=genres[i];
				if (ts.contains(temp)) {
					continue;
				} else {
					ts.add(temp);
				}
			}
		}
		int count = 0;
		String temp = null;
		LinkedList<String> fList=new LinkedList<String>();
		ArrayList<Integer> countList=new ArrayList<Integer>();
		for (String f : ts) {
			DBCursor cursor_2 = collection.find();
			while (cursor_2.hasNext()) {
				temp = ((BasicDBObject) cursor_2.next()).getString("Genres");
				if (temp.contains(f))
					count++;
			}
			fList.add(f);
			countList.add(count);
			System.out.println(f + "' total number is :" + count);
			count = 0;
		}
		System.out.println("******************************************************");
		int max=Integer.MIN_VALUE;
		int resultIndex=0;
		for (int i = 0; i < countList.size(); i++) {
			max=Math.max(max, countList.get(i));
		}
		for (int i = 0; i < countList.size(); i++) {
			if (countList.get(i)==max) {
				resultIndex=i;
			}
		}
		System.out.println(fList.get(resultIndex)+" 'total number is : "+countList.get(resultIndex)+" ,which has the most movies.");
	}
}
