package com.example.service;

import com.example.domain.Member;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MemberService {
    Boolean insert(Member member);
    Boolean update(Member member);
    String delete(String studentId);
    String[] deleteSelected(List<String> studentIds);
    Member selectById(String studentId);
    List<Member> selectAll();
}
