import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private String name;
    private Integer id;
    private Date EndTime;

    public User(String name, int id,Date endTime) {
        this.name = name;
        this.id = id;
        this.EndTime=endTime;
    }
}
