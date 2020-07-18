import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = Files.readString(Paths.get("alice30.txt"));
        String[] arr = contents.split("\\PL+");

        List<String> words = List.of(arr);
        long count = 0;
        for (String w:words){
            if(w.length()>12){
                count++;
                System.out.println(w);
            }
        }
        System.out.println("Cách 1:" + count);

        //Sử dụng Stream
        count = words.stream().filter(w->w.length()>12).count();
        System.out.println("Cách 2:" + count);


        //Sử dụng parallelStream song song
        count = words.parallelStream().filter(w->w.length()>12).count();
        System.out.println("Cách 3:" + count);
    }
}
