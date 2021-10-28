package api.placeholder;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class URIGeneratorTest {
    @Test
    public void shouldReturnValidURIForPosts() throws URISyntaxException {
        //given
        URIGenerator gen = new URIGenerator();
        //when
        final URI uri = gen.getForAll(Resources.POSTS);
        //then
        assertEquals("https://jsonplaceholder.typicode.com/posts", uri.toASCIIString());


    }

    @Test
    public void shouldReturnValidURIForID() throws URISyntaxException {
        //given
        URIGenerator gen2 = new URIGenerator();
        //when
        final URI uri2 = gen2.getById(Resources.POSTS, 3);
        //then
        assertEquals("https://jsonplaceholder.typicode.com/posts/3", uri2.toASCIIString());
    }

}