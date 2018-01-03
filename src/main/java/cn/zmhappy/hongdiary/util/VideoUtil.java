package cn.zmhappy.hongdiary.util;

import cn.zmhappy.hongdiary.web.vo.ResultVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class VideoUtil {

    private static final String dataUrl = "src/main/resources/static/video/";

    public static ResultVO uploadVideo(MultipartFile file) {

        InputStream is = null;
        try {
            JSONObject result = new JSONObject();
            is = file.getInputStream();
            String fileName = CommonUtil.getUniqueFileName() + "." + file.getContentType().split("/")[1];
            String saveUrl = dataUrl + fileName;
            FileUtils.copyInputStreamToFile(is, new File(saveUrl));
            result.put("url", "video/" + fileName);
            return ResultVOUtil.success(result);

        } catch (IOException e) {
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
