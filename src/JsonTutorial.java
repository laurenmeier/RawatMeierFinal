import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTutorial {

	public static void main(String[] args) {
		try {
			JSONParser parser = new JSONParser();
			String inputData = readJSONString("https://data.sfgov.org/api/views/w969-5mn4/rows.json?accessType=DOWNLOAD");
			JSONObject obj = (JSONObject) parser.parse(inputData);
			JSONArray data = (JSONArray)obj.get("data");
			
			for (Object key : data) {
				System.out.println(key);
			}
			
			//JSONArray array = (JSONArray) obj;
//			System.out.println(array.toString());
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
