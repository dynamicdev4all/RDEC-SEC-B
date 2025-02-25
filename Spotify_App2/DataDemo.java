import org.json.JSONArray;
import org.json.JSONObject;

public class DataDemo {
    public static void main(String[] args) {
        String data = """
                        {
                "ans":[{"songName":"295","singerName":"SMW"},

                        {"songName":"Last Ride","singerName":"SMW"},

                        {"songName":"Believer","singerName":"Imagine Dragons"},


                        {"songName":"Payal","singerName":"Honey Singh"},

                        {"songName":"Water","singerName":"Diljit Dosanjh"},

                        ]}
                        """;

        JSONObject dataObject = new JSONObject(data);
        JSONArray dataArray = dataObject.getJSONArray("ans");

        // System.out.println(dataArray.length());

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject singleObject = dataArray.getJSONObject(i);

            System.out.println(singleObject.getString("songName"));
            System.out.println(singleObject.getString("singerName"));
        }
    }
}
