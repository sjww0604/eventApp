package com.eventapp.repository;

import com.eventapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    /* 데이터 접근을 통해 어떻게 가져올지에 대해 정의
    * 전체 목록(List)를 작성자 기준으로 정렬
    * findBy : SELECT 시작
    * WriterName : WHERE 조건 컬럼
    * OrderBy : 정렬 시작 키워드
    * ModifiedAt : 정렬 대상 컬럼
    * Desc : 내림차순 정렬*/
    List<Event> findByWriterNameOrderByModifiedAtDesc(String writerName);
}
