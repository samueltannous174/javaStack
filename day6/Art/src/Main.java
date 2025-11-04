import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Painting painting = new Painting("p1","samuel", "newwwwwwwwwwwwwwwwwwwww");
        Painting painting2 = new Painting("p2","samuel2", "newwwwwwwwwwwwwwwwwwwww2");
        painting.viewArt();
        ArrayList <Art> museum = new ArrayList <Art>();
        museum.add(painting);
        museum.add(painting2);
        System.out.println(museum);

    }
}