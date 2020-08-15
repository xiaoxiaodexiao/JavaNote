import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User1 {
    private String name;
    private Integer uid;

    public User1(String name, int id) {
        this.name = name;
        this.uid = id;
    }
}
