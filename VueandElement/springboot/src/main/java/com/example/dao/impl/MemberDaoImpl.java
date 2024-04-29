package com.example.dao.impl;

import com.example.dao.MemberDao;
import com.example.domain.Member;
import com.example.exception.BusinessException;
import com.example.web.controller.Code;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
本工程使用的是redis数据库，所以不能使用mybatis代理开发，下面是自己实现的增删改查业务接口的

 */

@Repository
public class MemberDaoImpl implements MemberDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 添加数据
     *
     * @param member
     * @return
     */
    @Override
    public Boolean insert(Member member) {
        // 手动序列化
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(member);
        } catch (JsonProcessingException e) {
            throw new BusinessException(Code.INSERT_ERR, "添加-Member对象Json序列化异常", e);
        }
        // 添加数据
        return stringRedisTemplate.opsForValue().setIfAbsent(member.getStudentId(), jsonString);
    }

    /**
     * 修改数据
     *
     * @param member
     * @return
     */
    @Override
    public Boolean update(Member member) {
        // 手动序列化
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(member);
        } catch (JsonProcessingException e) {
            throw new BusinessException(Code.UPDATE_ERR, "修改-Member对象序列化为Json异常", e);
        }
        // 修改数据
        return stringRedisTemplate.opsForValue().setIfPresent(member.getStudentId(), jsonString);
    }

    /**
     * 删除数据
     *
     * @param studentId
     * @return
     */
    @Override
    public String delete(String studentId) {
        return stringRedisTemplate.opsForValue().getAndDelete(studentId);
    }

    /**
     * 批量删除数据
     *
     * @param studentIds
     * @return
     */
    @Override
    public String[] deleteSelected(List<String> studentIds) {
        String[] deleteStudentIds = new String[studentIds.size()];
        for (int i = 0; i < studentIds.size(); i++) {
            // 删除数据并返回
            String temp = stringRedisTemplate.opsForValue().getAndDelete(studentIds.get(i));
            deleteStudentIds[i] = temp;
        }
        return deleteStudentIds;
    }

    /**
     * 通过studentId查询数据
     *
     * @param studentId
     * @return
     */
    @Override
    public Member selectById(String studentId) {
        // 获取数据
        String jsonMember = stringRedisTemplate.opsForValue().get(studentId);
        // 反序列化成对象
        try {
            return mapper.readValue(jsonMember, Member.class);
        } catch (JsonProcessingException e) {
            throw new BusinessException(Code.SELECT_ERR, "查询ById-Json反序列化为Member对象异常", e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public List<Member> selectAll() {
        // 获取所有的键
        Set<String> studentIds = stringRedisTemplate.keys("*");

        //获取数据
        List<Member> memberList = new ArrayList<>();
        if (studentIds != null) {
            for (String studentId : studentIds) {
                String jsonMember = stringRedisTemplate.opsForValue().get(studentId);
                // 反序列化成对象
                Member member = null;
                try {
                    member = mapper.readValue(jsonMember, Member.class);
                } catch (JsonProcessingException e) {
                    throw new BusinessException(Code.SELECT_ERR, "查询All-Json反序列化为Member对象异常", e);
                }
                memberList.add(member);
            }

        }
        return memberList;
    }
}
