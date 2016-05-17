import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class JsonTutorial {
	
	public static void main(String[] args) {
		try {
			String inputData = readJSONString("https://data.sfgov.org/api/views/w969-5mn4/rows.json?accessType=DOWNLOAD");
			JSONObject data = new JSONObject(inputData);
			System.out.println(data.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static String readJSONString(String url) {
		try {
			URL dataUrl = new URL(url);
			InputStream urlInputStream = dataUrl.openConnection().getInputStream();
			
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(urlInputStream, "UTF-8")); 
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
			    responseStrBuilder.append(inputStr);
			return responseStrBuilder.toString();
		} catch (Exception e) {
			System.err.println(e);
		}
		return "";
	}
}
