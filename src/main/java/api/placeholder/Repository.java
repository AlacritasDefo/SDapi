package api.placeholder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Repository {

    private HttpClient client = HttpClient.newHttpClient();
    private URIGenerator generator = new URIGenerator();
    private ObjectMapper mapper = new ObjectMapper();

    public List<Post> findAllPosts() {
        try {
            final HttpResponse<String> res = getHttpResponse(generator, Resources.POSTS, client);
            final Post[] posts = mapper.readValue(res.body(), Post[].class);
            return Arrays.asList(posts);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

       return Collections.emptyList();
    }

    private HttpResponse<String> getHttpResponse(URIGenerator generator, Resources posts, HttpClient client) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(this.generator.getForAll(Resources.POSTS))
                .build();
        final HttpResponse<String> res = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        return res;
    }

    public List<ToDos> findAllToDos(){
        try{
            final HttpResponse<String> response = getStringHttpResponse();
            final ToDos[] toDos = mapper.readValue(response.body(), ToDos[].class);
            return Arrays.asList(toDos);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private HttpResponse<String> getStringHttpResponse() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(generator.getForAll(Resources.TODOS))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Comments> findAllComments(){
        try {
            extracted();
            final HttpResponse<String> response = getStringHttpResponse();
            final Comments[] comments = mapper.readValue(response.body(), Comments[].class);
            return Arrays.asList(comments);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private void extracted() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(this.generator.getForAll(Resources.COMMENTS))
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }



}
