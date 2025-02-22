import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {
    static ArrayList<SongModel> songList;

    static ArrayList<SongModel> getSongList() {
        return songList;
    }

    public static void main(String[] args) {
        String address = "https://itunes.apple.com/search?term=jack+johnson&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();

        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (res.statusCode() == 200) {
                String completeData = res.body();

                JSONObject dataObject = new JSONObject(completeData);

                JSONArray dataArray = dataObject.getJSONArray("results");

                songList = new ArrayList<>();
                SongModel song;
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject songObject = dataArray.getJSONObject(i);
                    song = new SongModel(
                            songObject.getString("trackName"),
                            songObject.getString("artistName"),
                            songObject.getString("artworkUrl100"),
                            songObject.getString("previewUrl"),
                            Float.parseFloat(songObject.getString("trackPrice"))

                    );

                    songList.add(song);
                    // System.out.println(songObject.getString("trackName"));
                }

                System.out.println(songList.get(0).songImageUrl);
            } else {
                System.out.println("Some error occured");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}