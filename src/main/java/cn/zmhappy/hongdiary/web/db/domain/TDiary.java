package cn.zmhappy.hongdiary.web.db.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TDiary {

    private Integer id;

    private String userId;
    private String content;
    private String image;
    private String video;
    private Date createTime;
    private Date finishTime;
    private Integer isDeleted;
}
