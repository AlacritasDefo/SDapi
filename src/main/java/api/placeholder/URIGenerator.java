package api.placeholder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

public class URIGenerator {
    private static final String URI_HOST = "https://jsonplaceholder.typicode.com/";
    public URI getForAll(Resources resources) throws URISyntaxException {
        return new URI(String.format("%s%s", URI_HOST, resources.toString().toLowerCase()));
    }

    public URI getById(Resources resources, int id) throws URISyntaxException {
        return new URI(String.format("%s%s/%d", URI_HOST, resources.toString().toLowerCase(), id));
    }

}
