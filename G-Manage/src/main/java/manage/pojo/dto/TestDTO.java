package manage.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestDTO {

    @ApiModelProperty(value="测试", name="name", required=false)
    private String name;
}
