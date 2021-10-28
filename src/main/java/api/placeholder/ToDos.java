package api.placeholder;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ToDos {
    @EqualsAndHashCode.Exclude
    private int userId;
    private int id;
    @EqualsAndHashCode.Exclude
    private String title;
    @EqualsAndHashCode.Exclude
    private boolean completed;
}
