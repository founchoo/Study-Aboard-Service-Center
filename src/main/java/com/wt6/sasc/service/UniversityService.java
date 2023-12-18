package com.wt6.sasc.service;

import com.wt6.sasc.entity.University;

import java.util.List;

public interface UniversityService {

    List<University> getAllUniversity();

    void addUniversity(University university);

    void updateUniversity(int id, double ielts, int toefl);

    University getUniversityById(int id);

    List<University> getUniversityByPageIndex(int pageIndex, int pageSize);
}