import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
        List<String> list = List.of(Files.readString(Paths.get("alice30.txt")).split("\\PL+"));

        //Stream 1
        Stream<String> words = list.stream();

        Optional<String> optional = words.filter(w->w.length()>100).findFirst();
        System.out.println(optional.orElse("Soooooooo Long"));
        show("words",words);

        //Stream 2
        Stream<String> words2 = list.stream().filter(w->w.contains("red"));
        show("red words", words2);

        //Stream 3
        Stream<String> words3 = Stream.generate(()-> "Echo");
        Stream<Double> numbers = Stream.generate(Math::random);
        show("numbers", numbers);

        //Stream 4
        Stream<Integer> integer = Stream.iterate(1,x->x+1);
        show("integer", integer);
    }

    public static <T> void show(String title, Stream<T> stream) {
        System.out.print(title+":");
        stream.limit(10).collect(Collectors.toList()).forEach(w-> System.out.println(w+","));
  }
}
