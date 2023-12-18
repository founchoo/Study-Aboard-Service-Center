package com.wt6.sasc.service.impl;

import com.wt6.sasc.entity.University;
import com.wt6.sasc.mapper.UniversityMapper;
import com.wt6.sasc.service.UniversityService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Resource
    private UniversityMapper universityMapper;

    @Async("asyncTaskExecutor")
    @Override
    public List<University> getAllUniversity() {
        return universityMapper.getAllUniversity();
    }

    @Override
    public void addUniversity(University university) {
        universityMapper.addUniversity(university);
    }

    @Override
    public void updateUniversity(int id, double ielts, int toefl) {
        universityMapper.updateUniversity(id, ielts, toefl);
    }

    @Override
    public University getUniversityById(int id) {
        return universityMapper.getUniversityById(id);
    }

    @Override
    public List<University> getUniversityByPageIndex(int pageIndex, int pageSize) {
        return universityMapper.getUniversityByPageIndex(pageIndex, pageSize);
    }
}