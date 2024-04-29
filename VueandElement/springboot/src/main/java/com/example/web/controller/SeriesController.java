package com.example.web.controller;

import com.example.domain.InputRegister;
import com.example.domain.OutputRegister;
import com.example.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    /**
     * 发送输入条件，接收输出结果
     * @param register
     * @return
     */
    @PostMapping
    public Result insert(@RequestBody InputRegister register){
        // System.out.println("被访问到了");
        OutputRegister res = seriesService.calculate(register);
        return new Result(res!=null ? Code.INSERT_OK: Code.INSERT_ERR, res);
    }
}
