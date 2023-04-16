package com.aiite.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileRead {

	public static void main(String[] args) throws ParseException, IOException {
		
		System.out.println(System.getProperty("user.dir"));
		FileReader reader = new FileReader(new File(System.getProperty("user.dir")+"/src/test/resources/JsonTest.json"));
		JSONParser parser = new JSONParser();
		Object parse = parser.parse(reader);
		JSONObject object = (JSONObject)parse;
		System.out.println(object.get("insuteName"));
		JSONObject trainerDetails = (JSONObject)object.get("trainersDetails");
		System.out.println(trainerDetails.get("javaTrainer"));
		System.out.println(trainerDetails.get("seleniumTrainer"));
		System.out.println(trainerDetails.get("projectTrainer"));
		JSONArray studentDetails = (JSONArray)object.get("StudentDetails");
		System.out.println(studentDetails);
		
		for (Object object2 : studentDetails) {
			System.out.println(object2);
		}
		for (int i = 0; i < studentDetails.size(); i++) {
			studentDetails.get(i);
		}
	}

}
