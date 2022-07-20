package com.sungsu.SpringBoardTwo.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Java 기반 MySql과 mybatis 연결 설정
 */

@Configuration
//매퍼로 지정될 인터페이스 패키지명을 MapperScan에 기입
@MapperScan("com.sungsu.SpringBoardTwo.model.dao")
public class MySQLConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);

        //sql 문을 작성할 SqlMapper.xml을 맵핑하기 위해 선언
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(
                resolver.getResource("classpath:mybatis/mapper/*.xml"));

        //mybatis의 camelcase 기능등을 사용하기 위해 선언한 mybatis-config.xml 사용
        Resource myBatisConfig = new PathMatchingResourcePatternResolver()
                .getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(myBatisConfig);

        //mapper의 result, parameterType 패키지 경로를 클래스만 작성 할 수 있도록 선언
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.sungsu.SpringBoardTwo.model");
        return sqlSessionFactoryBean.getObject();
    }
}
