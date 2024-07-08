package com.easycar.controller;

import com.easycar.annotation.GlobalInterceptor;
import com.easycar.entity.config.AppConfig;
import com.easycar.entity.constants.Constants;
import com.easycar.entity.enums.DateTimePatternEnum;
import com.easycar.entity.enums.FileUploadTypeEnum;
import com.easycar.entity.enums.ImportTemplateTypeEnum;
import com.easycar.entity.enums.ResponseCodeEnum;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.exception.BusinessException;
import com.easycar.utils.DateUtil;
import com.easycar.utils.ScaleFilter;
import com.easycar.utils.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Description 文件上传
 * @Author 程序员老罗
 * @Date 2023/9/17 21:43
 * @ClassName
 * @MethodName
 * @Params
 */
@RestController("fileController")
@RequestMapping("/file")
public class FileController extends ABaseController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private AppConfig appConfig;

    @RequestMapping("/uploadFile")
    public ResponseVO uploadFile(MultipartFile file) {
        FileUploadTypeEnum uploadTypeEnum = FileUploadTypeEnum.getType(2);
        String month = DateUtil.format(new Date(), DateTimePatternEnum.YYYYMM.getPattern());
        String folderName = appConfig.getProjectFolder() + month;
        System.out.println(folderName);
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileSuffix = StringTools.getFileSuffix(file.getOriginalFilename());
        String realFileName = StringTools.getRandomString(Constants.LENGTH_30) + fileSuffix;
        String realFilePath = month + "/" + realFileName;
        File localFile = new File(appConfig.getProjectFolder() + realFilePath);
        try {
            file.transferTo(localFile);
            //裁剪图片
            if (uploadTypeEnum != null) {
                ScaleFilter.createThumbnail(localFile, uploadTypeEnum.getMaxWidth(), uploadTypeEnum.getMaxWidth(), localFile);
            }
        } catch (IOException e) {
            logger.error("文件上传失败", e);
            throw new BusinessException("文件上传失败");
        }
        return getSuccessResponseVO(realFilePath);
    }

    @RequestMapping("/getImage/{imageFolder}/{imageName}")
    @GlobalInterceptor
    public void getImage(HttpServletResponse response,
                         @PathVariable("imageFolder") String imageFolder,
                         @PathVariable("imageName") String imageName) {
        readImage(response, imageFolder, imageName);
    }

    private void readImage(HttpServletResponse response, String imageFolder, String imageName) {
        if (StringTools.isEmpty(imageFolder) || StringUtils.isBlank(imageName)) {
            return;
        }
        String imageSuffix = StringTools.getFileSuffix(imageName);
        String filePath = appConfig.getProjectFolder() + imageFolder + "/" + imageName;
        imageSuffix = imageSuffix.replace(".", "");
        String contentType = "image/" + imageSuffix;
        response.setContentType(contentType);
        response.setHeader("Cache-Control", "max-age=2592000");
        readFile(response, filePath);
    }

    protected void readFile(HttpServletResponse response, String filePath) {
        if (!StringTools.pathIsOk(filePath)) {
            return;
        }
        OutputStream out = null;
        FileInputStream in = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }
            in = new FileInputStream(file);
            byte[] byteData = new byte[1024];
            out = response.getOutputStream();
            int len = 0;
            while ((len = in.read(byteData)) != -1) {
                out.write(byteData, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            logger.error("读取文件异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("IO异常", e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("IO异常", e);
                }
            }
        }
    }


    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response, HttpServletRequest request, Integer type) {
        ImportTemplateTypeEnum templateTypeEnum = ImportTemplateTypeEnum.getByType(type);
        if (null == templateTypeEnum) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        OutputStream out = null;
        InputStream in = null;
        try {
            String fileName = templateTypeEnum.getTemplateName();
            response.setContentType("application/x-msdownload; charset=UTF-8");
            if (request.getHeader("User-Agent").toLowerCase().indexOf("msie") > 0) {//IE浏览器
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
            //读取文件
            ClassPathResource classPathResource = new ClassPathResource(templateTypeEnum.getTemplatePath());
            in = classPathResource.getInputStream();
            byte[] byteData = new byte[1024];
            out = response.getOutputStream();
            int len = 0;
            while ((len = in.read(byteData)) != -1) {
                out.write(byteData, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            logger.error("读取文件异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("IO异常", e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("IO异常", e);
                }
            }
        }
    }
}
