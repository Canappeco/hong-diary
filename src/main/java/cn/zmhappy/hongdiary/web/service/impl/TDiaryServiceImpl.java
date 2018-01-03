package cn.zmhappy.hongdiary.web.service.impl;

import cn.zmhappy.hongdiary.web.db.dao.TDiaryDao;
import cn.zmhappy.hongdiary.web.db.domain.TDiary;
import cn.zmhappy.hongdiary.web.service.TDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDiaryServiceImpl implements TDiaryService {

    @Autowired
    private TDiaryDao tDiaryDao;

    @Override
    public List<TDiary> findList() {
        return tDiaryDao.findList();
    }

    @Override
    public void insertDiary(TDiary tDiary) {
        tDiaryDao.insertDiary(tDiary);
    }
}
