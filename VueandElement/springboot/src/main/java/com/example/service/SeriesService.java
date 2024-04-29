package com.example.service;

import com.example.domain.InputRegister;
import com.example.domain.OutputRegister;

public interface SeriesService {
    OutputRegister calculate(InputRegister inputRegister);
}
