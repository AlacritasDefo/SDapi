package api.placeholder;

import lombok.*;




    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    @EqualsAndHashCode

    public class Comments {
        @EqualsAndHashCode.Exclude
        private int postId;
        private int id;
        @EqualsAndHashCode.Exclude
        private String name;
        @EqualsAndHashCode.Exclude
        private String email;
        @EqualsAndHashCode.Exclude
        private String body;


    }
