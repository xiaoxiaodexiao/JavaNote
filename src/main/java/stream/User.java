package stream;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
    private String name;
    private Integer uid;

    public User(String name, int id) {
        this.name = name;
        this.uid = id;
    }
}
