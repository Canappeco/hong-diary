package cn.zmhappy.hongdiary.web.controller;

import cn.zmhappy.hongdiary.util.ImageUtil;
import cn.zmhappy.hongdiary.util.ResultVOUtil;
import cn.zmhappy.hongdiary.util.VideoUtil;
import cn.zmhappy.hongdiary.web.db.domain.TDiary;
import cn.zmhappy.hongdiary.web.service.TDiaryService;
import cn.zmhappy.hongdiary.web.vo.ResultVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/diary")
@Slf4j
public class TDiaryController {

    @Autowired
    private TDiaryService tDiaryService;

    @RequestMapping("/findList")
    public ResultVO findList(HttpServletRequest request) {
        try {
            return ResultVOUtil.success(tDiaryService.findList());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultVOUtil.error(0, "内部错误");
        }
    }

    /**
     * 上传
     * @param files 图片文件流
     * @param request content : 文字内容
     *
     * @return
     */
    @RequestMapping("/upload")
    public ResultVO uploadImg(@RequestParam(value = "img", required = false)MultipartFile[] files,
                              @RequestParam(value = "video", required = false)MultipartFile video,
                              @RequestParam(value = "circleContent", required = false)String content) {
        try {
            JSONObject jsonObject = new JSONObject();
            TDiary tDiary = new TDiary();
            if (content == null) {
                log.error("content is null");
            } else {
                log.info("content is "+content);
            }
            tDiary.setContent(content);
            tDiary.setUserId("test");
            int count = 0;
            if (files != null) {
                for (MultipartFile file : files) {
                    ResultVO result = ImageUtil.uploadImg(file);
                    jsonObject.put(count+"", result.getData().toString());
                    count++;
                }
                tDiary.setImage(jsonObject.toJSONString());
            }
            if (video != null) {
                ResultVO result = VideoUtil.uploadVideo(video);
                tDiary.setVideo(result.getData().toString());
            }

            tDiaryService.insertDiary(tDiary);

            return ResultVOUtil.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultVOUtil.error(0, "内部错误");
        }


    }


}
