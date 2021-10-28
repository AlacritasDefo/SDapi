import api.placeholder.ToDos;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ToDosApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Wpisz numer zadania: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://jsonplaceholder.typicode.com/todos/"+id))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            final ToDos toDos = mapper.readValue(response.body(), ToDos.class);
            System.out.println(toDos);
        } else {
            System.out.println("Niepoprawny numer zadania!");
        }
    }
}
