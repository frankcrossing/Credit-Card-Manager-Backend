package com.jieandata.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis配置
 *
 * @author master.yang
 * @version $$Id: MybatisConfig, v 0.1 2018/8/2 下午2:50 master.yang Exp $$
 */
@MapperScan("com.jieandata.dal.dao")
@EnableTransactionManagement
@Configuration
public class MybatisConfig {
}
