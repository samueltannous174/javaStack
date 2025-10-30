import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();

        trackList.put("track1", "hello......");
        trackList.put("track2", "hello2......");
        trackList.put("track3", "hello3......");
        trackList.put("track4", "hello4......");

        String trackTitle = "track3";
        String lyrics = trackList.get(trackTitle);

        System.out.println(trackTitle + ": " + lyrics);
        System.out.println();

        System.out.println("All Tracks:");
        for (String title : trackList.keySet()) {
            System.out.println(title + ": " + trackList.get(title));
        }
    }
}
