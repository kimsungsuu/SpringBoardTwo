package com.sungsu.SpringBoardTwo.controller;

import com.sungsu.SpringBoardTwo.model.dao.TestDAO;
import com.sungsu.SpringBoardTwo.model.dto.TestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/test")
@AllArgsConstructor
public class TestController {
    private TestDAO testDAO;

    @GetMapping("/hello")
    public List<TestDTO> HelloWorld(){
        return testDAO.getTestData();
    }
}
