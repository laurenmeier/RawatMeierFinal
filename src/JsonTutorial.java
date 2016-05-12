import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class JsonTutorial {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.sfgov.org/api/views/w969-5mn4/rows.json?accessType=DOWNLOAD");
			InputStream urlInputStream = url.openConnection().getInputStream();
			
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(urlInputStream, "UTF-8")); 
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
			    responseStrBuilder.append(inputStr);
			JSONObject data = new JSONObject(responseStrBuilder.toString());
			System.out.println(data.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
