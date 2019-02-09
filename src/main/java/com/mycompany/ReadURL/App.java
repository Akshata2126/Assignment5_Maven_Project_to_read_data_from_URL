package com.mycompany.ReadURL;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
	
	 static String url ="https://dog.ceo/api/breeds/list/all" ;
	public static String readAll(Reader rd) throws IOException {
		
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
 
  @BeforeTest
		  public static JSONObject readJsonFromUrl() throws IOException, JSONException  {
	  // coded to open the URL
		    InputStream is = new URL(url).openStream();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    
		    }

  
		  @Test(priority=1)
		 public void PrintData() throws IOException, JSONException {
			  //storing the jsonobject from the URL
			    JSONObject jsonObject = readJsonFromUrl();
			    //getting values of message
			    JSONObject jFinalsonObject=jsonObject.getJSONObject("message");
			  
			    
			    Iterator keys = jFinalsonObject.keys();
			    //loop to print breed
			    while(keys.hasNext()) {
			      // loop to get the key
			      String currentKey = (String)keys.next();
			     System.out.println("---Breed---");
			      System.out.println(currentKey);
			      
			 
			      // get the value of the key(subtype)
			      JSONArray currentValue = jFinalsonObject.getJSONArray(currentKey);
			      			      
			      if(currentValue.length()>0) {
			     System.out.println("---Subtypes---");
			      for(int i=0;i<currentValue.length();i++) {
			    	  System.out.println(currentValue.get(i));
			      }
			    
			      }
			      
			    }
		  }
		  
		  @Test(priority=2)
		  public void TestOutput() throws IOException, JSONException
		  {
			  JSONObject jsonObject = readJsonFromUrl();
			    JSONObject jFinalsonObject=jsonObject.getJSONObject("message");
			    JSONObject jObj = new JSONObject("{\"affenpinscher\":[],\"african\":[],\"airedale\":[],\"akita\":[],\"appenzeller\":[],\"basenji\":[],\"beagle\":[],\"bluetick\":[],\"borzoi\":[],\"bouvier\":[],\"boxer\":[],\"brabancon\":[],\"briard\":[],\"bulldog\":[\"boston\",\"french\"],\"bullterrier\":[\"staffordshire\"],\"cairn\":[],\"cattledog\":[\"australian\"],\"chihuahua\":[],\"chow\":[],\"clumber\":[],\"cockapoo\":[],\"collie\":[\"border\"],\"coonhound\":[],\"corgi\":[\"cardigan\"],\"cotondetulear\":[],\"dachshund\":[],\"dalmatian\":[],\"dane\":[\"great\"],\"deerhound\":[\"scottish\"],\"dhole\":[],\"dingo\":[],\"doberman\":[],\"elkhound\":[\"norwegian\"],\"entlebucher\":[],\"eskimo\":[],\"frise\":[\"bichon\"],\"germanshepherd\":[],\"greyhound\":[\"italian\"],\"groenendael\":[],\"hound\":[\"afghan\",\"basset\",\"blood\",\"english\",\"ibizan\",\"walker\"],\"husky\":[],\"keeshond\":[],\"kelpie\":[],\"komondor\":[],\"kuvasz\":[],\"labrador\":[],\"leonberg\":[],\"lhasa\":[],\"malamute\":[],\"malinois\":[],\"maltese\":[],\"mastiff\":[\"bull\",\"english\",\"tibetan\"],\"mexicanhairless\":[],\"mix\":[],\"mountain\":[\"bernese\",\"swiss\"],\"newfoundland\":[],\"otterhound\":[],\"papillon\":[],\"pekinese\":[],\"pembroke\":[],\"pinscher\":[\"miniature\"],\"pointer\":[\"german\",\"germanlonghair\"],\"pomeranian\":[],\"poodle\":[\"miniature\",\"standard\",\"toy\"],\"pug\":[],\"puggle\":[],\"pyrenees\":[],\"redbone\":[],\"retriever\":[\"chesapeake\",\"curly\",\"flatcoated\",\"golden\"],\"ridgeback\":[\"rhodesian\"],\"rottweiler\":[],\"saluki\":[],\"samoyed\":[],\"schipperke\":[],\"schnauzer\":[\"giant\",\"miniature\"],\"setter\":[\"english\",\"gordon\",\"irish\"],\"sheepdog\":[\"english\",\"shetland\"],\"shiba\":[],\"shihtzu\":[],\"spaniel\":[\"blenheim\",\"brittany\",\"cocker\",\"irish\",\"japanese\",\"sussex\",\"welsh\"],\"springer\":[\"english\"],\"stbernard\":[],\"terrier\":[\"american\",\"australian\",\"bedlington\",\"border\",\"dandie\",\"fox\",\"irish\",\"kerryblue\",\"lakeland\",\"norfolk\",\"norwich\",\"patterdale\",\"russell\",\"scottish\",\"sealyham\",\"silky\",\"tibetan\",\"toy\",\"westhighland\",\"wheaten\",\"yorkshire\"],\"vizsla\":[],\"weimaraner\":[],\"whippet\":[],\"wolfhound\":[\"irish\"]}");
			   
			    //Converting object into String
			  String jsonText = jObj.toString();
			  String jsonText2 =jFinalsonObject.toString();

			    if(jsonText.equals(jsonText2))
			    	
			    {
			    	System.out.println("Output is correct");
			    }
			    else
			    {
			    	System.out.println("Output is incorrect");	
			    }
			    
		  }
	  
		  }
