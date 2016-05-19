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
			String inputData = readJSONString("https://data.sfgov.org/resource/bbb8-hzi6.json");
			Object obj = parser.parse(inputData);
			JSONArray array = (JSONArray) obj;
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj2 = (JSONObject) array.get(i);
				System.out.println("applicant: " + obj2.get("applicant"));
				for (Object key: obj2.keySet()) {
					if (!key.equals("applicant")) System.out.println(key + ": " + obj2.get(key));
				}
				System.out.println();
			}
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
