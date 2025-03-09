package org.codenova.tolkhub.model.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostsLikes {
    private int id;
    private String userId;
    private int postsId;
}
