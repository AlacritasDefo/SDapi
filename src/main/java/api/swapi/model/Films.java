package api.swapi.model;


import lombok.Data;

import java.util.List;

@Data
public class Films {
    private int count;
    private String next;
    private String previous;
    private List<String> results;
}
