package cn.zmhappy.hongdiary.web.db.dao;

import cn.zmhappy.hongdiary.web.db.domain.TDiary;
import cn.zmhappy.hongdiary.web.db.mapper.TDiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TDiaryDao {

    @Autowired
    private TDiaryMapper tDiaryMapper;

    public List<TDiary> findList() {
        return tDiaryMapper.findList();
    }

    public void insertDiary(TDiary tDiary) {
        tDiaryMapper.insertDiary(tDiary);
    }

}
