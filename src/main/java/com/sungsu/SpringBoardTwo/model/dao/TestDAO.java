package com.sungsu.SpringBoardTwo.model.dao;

import com.sungsu.SpringBoardTwo.model.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mapper.xml과 연결되어 있는 TestDAO 인터페이스
 */
@Mapper
public interface TestDAO {
    List<TestDTO> getTestData();
}
