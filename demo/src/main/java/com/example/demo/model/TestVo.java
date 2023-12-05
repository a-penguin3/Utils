package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "测试vo")
public class TestVo {
    @Schema(title = "测试",description = "测试名称")
    private String name;
    @Schema(title = "type",description = "测试类型")
    private String type;
}
