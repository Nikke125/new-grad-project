package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.enums.ErrorMsg;
import com.second.hand.trading.server.service.FileService;
import com.second.hand.trading.server.utils.IdFactoryUtil;
import com.second.hand.trading.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
@CrossOrigin
@RestController
public class FileController {

    @Value("${userFilePath}")
    private String userFilePath;

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public ResultVo uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println("multipartFile: "+multipartFile.getOriginalFilename());
        String uuid="file"+ IdFactoryUtil.getFileId();
        String fileName= uuid+ multipartFile.getOriginalFilename();
        try {
            if (fileService.uploadFile(multipartFile,fileName)) {
                return ResultVo.success(baseUrl+"/image?imageName="+fileName);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
        }
        return ResultVo.fail(ErrorMsg.FILE_UPLOAD_ERROR);
    }

   @GetMapping("/image")
    public void getImage(@RequestParam("imageName") String imageName,
                         HttpServletResponse response) throws IOException {
        File fileDir = new File(userFilePath);
        File image=new File(fileDir.getAbsolutePath() +"/"+imageName);
        
        // 🚨【新增的侦察兵代码】在控制台打印出它真实去找的路径！
        System.out.println("==============================================");
        System.out.println("小程序正在请求图片: " + imageName);
        System.out.println("后端实际去寻找的路径: " + image.getAbsolutePath());
        System.out.println("这个文件真的存在吗？: " + image.exists());
        System.out.println("==============================================");

        if (image.exists()){
            // 🚨【修复缺陷】必须告诉浏览器/小程序，这是一张图片，不是纯文本！
            response.setContentType("image/jpeg"); 
            
            FileInputStream fileInputStream=new FileInputStream(image);
            byte[] bytes=new byte[fileInputStream.available()];
            if (fileInputStream.read(bytes)>0){
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
            }
            fileInputStream.close();
        } else {
            System.err.println("⚠️ 警告：后端根本找不到这张图片！");
        }
    }

}
