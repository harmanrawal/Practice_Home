import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing 
{
public static void main(String...s) throws IOException, NoSuchFieldException, SecurityException
{
	File file = new File("C:\\Users\\B0213658\\Desktop\\jsonForIR.java");

	 BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  String st; 
	  String st1="";
	  while ((st = br.readLine()) != null) 
	  {//	    System.out.println(st); 
		  st1=st1+st;
	  }
	  System.out.println(st1);
	  br.close();
	  
	  JSONObject jObj = new JSONObject(st1);
	  JSONObject gtscasrm=jObj.getJSONObject("getCustomerAccountSummaryResMsg");
	  //System.out.println(gtscasrm);
	  JSONObject dataarea=gtscasrm.getJSONObject("dataArea");
	  //System.out.println(dataarea);

	  JSONObject gcasr=dataarea.getJSONObject("getCustomerAccountSummaryResponse");
	  System.out.println(gcasr);
	  JSONArray jsonChildObject = gcasr.getJSONArray("logicalResource");
	  System.out.println(jsonChildObject);
	  String value="" , type="IMSI";
	  String type1="";
	  for(Object jb : jsonChildObject)
	  {
		  JSONObject jb1 = (JSONObject)jb;
		  JSONObject identification = (JSONObject)jb1.get("identification");
		  System.out.println(identification);
		  type1 = identification.getString("type");
		  if(type1.equals(type))
		  {
			  value = identification.getString("id");
			  break;
		  }
	  }
	  System.out.println("Type : "+type1+" Value : "+value);
}

}