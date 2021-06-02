package com.liugddx.web;

import com.liugddx.client.FileClient;
import feign.Response;
import java.io.IOException;
import java.io.InputStream;
import javax.websocket.server.PathParam;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@ClassName DemoController</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/26 15:07
 */
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final FileClient fileClient;
    @Data
    static class Param{
        private String test;
    }

    @PostMapping("/test")
    public String testRule(@RequestBody Param param){

        return param.getTest();
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id){
        return id;
    }

    @PostMapping("/postRule")
    public String postRule(@PathParam("test") String test){

        return test;
    }

    @GetMapping("/none")
    public String none(){
        return "none";
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> download(){
        ResponseEntity<byte[]> result = null;
        InputStream inputStream = null;
        try {
            // feign文件下载
            Response response = fileClient.download();
            Response.Body body = response.body();
            inputStream = body.asInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            HttpHeaders heads = new HttpHeaders();
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=lr.xls");
            heads.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

            result = new ResponseEntity<byte[]>(b, heads, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
