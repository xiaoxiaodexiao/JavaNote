import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class SysProcedure {
    private Long id;
    @Getter
    @Setter
    private Integer type;

    private String departmentIds;

    private Date createTime;

    private Long operatorId;

    public SysProcedure(Long id, Integer type, String departmentIds, Long operatorId) {
        this.id = id;
        this.type = type;
        this.departmentIds = departmentIds;
        this.operatorId = operatorId;
    }
}