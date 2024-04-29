package com.example.service.impl;

import com.example.dao.MemberDao;
import com.example.domain.Member;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Boolean insert(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public Boolean update(Member member) {
        return memberDao.update(member);
    }

    @Override
    public String delete(String studentId) {
        return memberDao.delete(studentId);
    }

    @Override
    public String[] deleteSelected(List<String> studentIds) {
        return memberDao.deleteSelected(studentIds);
    }

    @Override
    public Member selectById(String studentId) {
        return memberDao.selectById(studentId);
    }

    @Override
    public List<Member> selectAll() {
        return memberDao.selectAll();
    }
}
