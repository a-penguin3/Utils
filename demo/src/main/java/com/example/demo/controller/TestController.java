package com.example.demo.controller;

import com.example.demo.config.ResponseResult;
import com.example.demo.model.TestVo;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@ResponseResult
@Tag(
        name = "test",
        description = "测试接口",
        externalDocs = @ExternalDocumentation(
                description = "这是一个接口文档介绍",
                url = "https://www.cnblogs.com/antLaddie/")
)
public class TestController {

    @Operation(
            summary = "测试接口",
            description = "测试"
//            parameters = {
//                    @Parameter(name = "id", description = "学生ID", required = true, example = "1")
//            },
//            responses = {
//                    @ApiResponse(
//                            responseCode = "200",
//                            description = "响应成功",
//                            content = @Content(
//                                    mediaType = "application/json",
//                                    schema = @Schema(
//                                            title = "AjaxResul和StudentVO组合模型",
//                                            description = "返回实体，AjaxResult内data为StudentVO模型",
//                                            anyOf = {AjaxResult.class, StudentVO.class})
//                            )
//                    ),
//                    @ApiResponse(
//                            responseCode = "500",
//                            description = "响应失败",
//                            content = @Content(
//                                    mediaType = "application/json",
//                                    schema = @Schema(
//                                            title = "AjaxResul模型",
//                                            description = "返回实体，AjaxResult内data为空",
//                                            implementation = AjaxResult.class)
//                            )
//                    )
//            }
    )
    @GetMapping("/success")
    public Object getSuccess(){
        return "success";
    }

    @GetMapping("/test")
    public TestVo test(){
        TestVo vo = new TestVo();
        vo.setName("123");
        vo.setType("321");
        return vo;
    }

}
