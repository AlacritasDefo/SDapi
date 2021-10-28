import api.placeholder.Post;
import api.placeholder.Repository;

import java.util.List;

public class NewPostApp {
    static Repository repository = new Repository();
    public static void main(String[] args) {
        List<Post> postList = repository.findAllPosts();
//        System.out.println(postList);
        int userId = 4;
        postList.stream().filter(post -> post.getUserId() == userId).forEach(System.out::println);
    }
}
