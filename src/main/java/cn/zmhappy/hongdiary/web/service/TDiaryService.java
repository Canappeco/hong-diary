package cn.zmhappy.hongdiary.web.service;

import cn.zmhappy.hongdiary.web.db.domain.TDiary;

import java.util.List;

public interface TDiaryService {

    public List<TDiary> findList();

    public void insertDiary(TDiary tDiary);
}
