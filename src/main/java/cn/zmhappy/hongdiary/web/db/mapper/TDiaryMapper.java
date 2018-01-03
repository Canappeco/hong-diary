package cn.zmhappy.hongdiary.web.db.mapper;

import cn.zmhappy.hongdiary.web.db.domain.TDiary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDiaryMapper {

    @Select("select * from t_diary where is_deleted = 0 order by create_time desc")
    List<TDiary> findList();


    @Insert("insert into t_diary(user_id, content, image, video, is_deleted) values (#{userId}, #{content}, #{image}, #{video}, 0)")
    void insertDiary(TDiary tDiary);



}
