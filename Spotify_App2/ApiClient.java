import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    static ArrayList<SongModel> songList = new ArrayList<>();

    public static ArrayList<SongModel> getSongList() {
        getSongsFromApi();
        return songList;
    }

    static void getSongsFromApi() {
        String address = "https://itunes.apple.com/search?term=arijit+singh&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();
        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (res.statusCode() == 200) {
                extractSongData(res.body());
            } else {
                System.out.println("Some error Occured");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void extractSongData(String completeData) {
        JSONObject dataObject = new JSONObject(completeData);
        JSONArray dataArray = dataObject.getJSONArray("results");
        for (int i = 0; i < dataArray.length(); i++) {
            SongModel song;
            JSONObject singleSong = dataArray.getJSONObject(i);
            song = new SongModel(
                    singleSong.getString("trackName"),
                    singleSong.getString("artistName"),
                    singleSong.getString("artworkUrl100"),
                    singleSong.has("previewUrl") ? singleSong.getString("previewUrl") : "NO data Found");
            songList.add(song);
        }
    }
}