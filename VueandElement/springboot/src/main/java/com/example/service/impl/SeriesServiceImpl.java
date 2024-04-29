package com.example.service.impl;

import com.example.domain.InputRegister;
import com.example.domain.OutputRegister;
import com.example.exception.BusinessException;
import com.example.service.SeriesService;
import com.example.web.controller.Code;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Service
public class SeriesServiceImpl implements SeriesService {
    @Override
    public OutputRegister calculate(InputRegister inputRegister) {
        // 通过socket给python服务器发送请求json，python计算出m序列返回，
        // 转换成对象返回

        // 根据本原多项式的次数order获得本原多项式的系数，并转换为数组
        String coefficient = Code.coefficientMap.get(inputRegister.getOrder());
        OutputRegister output;
        // 根据初始状态origin，转换为数组，发给python，计算出输出m序列
        try {
            Socket socket = new Socket("172.25.131.103", 9000);
            // 发给python初始状态 系数 和 origin
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),1024);
            bufferedWriter.write(coefficient+","+inputRegister.getOrigin());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            // 告诉python发送结束
            socket.shutdownOutput();

            // 接收python的回复
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8), 1024);
            String m_series = bufferedReader.readLine();

            // 将系数和python计算出m序列封装成对象，返回
            output = new OutputRegister(coefficient, m_series);

            // 关闭连接
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            throw new BusinessException(Code.BUSINESS_ERR, "java端的创建ServerSocket对象异常", e);
        }

        return output;
    }
}
