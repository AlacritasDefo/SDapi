import api.placeholder.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

public class PostApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Wpisz numer zasobu: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            System.out.println("Wpisz nazwę zasobu: ");
            Arrays.asList(Resources.values()).forEach(System.out::println); // wyświetlanie wszystkich zasobów
            String resource = scanner.next().toUpperCase(); // wczytywanie nazwy zasobu
            Resources resources = Resources.valueOf(resource); // zwracamy stałą zasobu na podstawie jej nazwy
            URIGenerator gen = new URIGenerator();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(gen.getById(resources, id))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            switch (resources){
                case POSTS:
                    final Post post = mapper.readValue(response.body(), Post.class);
                    System.out.println(post);
                    break;
                case TODOS:
                    final ToDos toDos = mapper.readValue(response.body(), ToDos.class);
                    System.out.println(toDos);
                    break;
                case COMMENTS:
                    final Comments comments = mapper.readValue(response.body(), Comments.class);
                    System.out.println(comments);
                    break;
            }
//            final api.placeholder.Post post = mapper.readValue(response.body(), api.placeholder.Post.class);
//            System.out.println(post);
        } else {
            System.out.println("Niepoprawny numer zasobu!");
        }
    }
}
