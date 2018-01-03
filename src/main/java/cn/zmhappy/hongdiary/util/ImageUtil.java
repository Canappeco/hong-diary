package cn.zmhappy.hongdiary.util;


import cn.zmhappy.hongdiary.web.vo.ResultVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ImageUtil {

    private static final String dataUrl = "static/image/";

    public static ResultVO uploadImg(MultipartFile file) {

        log.info(file.getContentType());
        InputStream is = null;
        try {
            JSONObject result = new JSONObject();
            is = file.getInputStream();
            BufferedImage image = ImageIO.read(is);
            result.put("width", image.getWidth());
            result.put("height", image.getHeight());
            is = file.getInputStream();
            String name = CommonUtil.getUniqueFileName();
            log.info("filename -- " + name);
            log.info("type -- "+ file.getContentType());
            if (is == null) {
                log.error("error", "file is null");
            } else {
                log.info("file is not null");
            }
//            String fileName = CommonUtil.getUniqueFileName() + "." + file.getContentType().split("/")[1];
            String fileName = CommonUtil.getUniqueFileName() + ".jpg";
            String saveUrl = dataUrl + fileName;
            FileUtils.copyInputStreamToFile(is, new File(saveUrl));
            result.put("url", "image/" + fileName);
            return ResultVOUtil.success(result);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultVOUtil.error(0, "io错误");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                log.error(e.toString());
            }
        }
    }

}
