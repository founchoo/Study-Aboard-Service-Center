package com.wt6.sasc.mapper;

import com.wt6.sasc.entity.University;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityMapper {

    List<University> getAllUniversity();

    void addUniversity(University university);

    void updateUniversity(int id, double ielts, int toefl);

    University getUniversityById(int id);

    List<University> getUniversityByPageIndex(int pageIndex, int pageSize);
}