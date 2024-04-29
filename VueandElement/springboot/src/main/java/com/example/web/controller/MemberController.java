package com.example.web.controller;

import com.example.domain.Member;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 添加成员
     * @param member
     * @return
     */
    @PostMapping
    public Result insert(@RequestBody Member member){
        Boolean res = memberService.insert(member);
        return new Result(res?Code.INSERT_OK:Code.INSERT_ERR, res);
    }

    /**
     * 修改成员
     * @param member
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Member member){
        Boolean res = memberService.update(member);
        return new Result(res?Code.UPDATE_OK:Code.UPDATE_ERR, res);
    }

    /**
     * 删除成员
     * @param studentId
     * @return
     */
    @DeleteMapping("/{studentId}")
    public Result delete(@PathVariable String studentId){
        System.out.println(studentId);
        String res = memberService.delete(studentId);
        Integer code = res != null ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = res != null ? "" : "删除数据失败，请重试";
        return new Result(code,res,msg);
    }

    /**
     * 删除选中
     * @param studentIds
     * @return
     */
    @DeleteMapping()
    public Result deleteSelected(@RequestBody List<String> studentIds){
        String[] res = memberService.deleteSelected(studentIds);
        Integer code = res != null ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = res != null ? "" : "删除所选数据失败，请重试";
        return new Result(code,res,msg);
    }

    /**
     * 通过id查询
     * @param studentId
     * @return
     */
    @GetMapping("/{studentId}")
    public Result selectById(@PathVariable String studentId){
        Member res = memberService.selectById(studentId);
        Integer code = res != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = res != null ? "" : "查询数据失败，请重试";
        return new Result(code,res,msg);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping()
    public Result selectAll(){
        List<Member> res = memberService.selectAll();
        Integer code = res != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = res != null ? "" : "查询所有数据失败，请重试";
        return new Result(code,res,msg);
    }
}
