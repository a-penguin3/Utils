package com.example.demo.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.example.demo.config.ResponseResult;
import com.example.demo.model.TestVo;
import com.example.demo.model.UploadDeviceData;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @PostMapping("/test/excel")
    public void testExcel(@RequestBody MultipartFile file) throws IOException {
        List<UploadDeviceData> list = EasyExcelFactory.read(file.getInputStream()).head(UploadDeviceData.class).sheet().doReadSync();
        for (UploadDeviceData uploadDeviceData : list){
            System.out.println(uploadDeviceData.toString());
        }
    }

}
