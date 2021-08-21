package com.david.mybatis;

import com.david.mybatis.dal.UserEntity;
import com.david.mybatis.dal.UserMapper;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author fanzunying
 * @date 2021/8/11 17:05
 */
public class DemoTest {
    public static void main(String[] args) {
        //使用new 方式
        PooledDataSource source = new PooledDataSource();
        source.setDriver("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true");
        source.setUsername("root");
        source.setPassword("Fzy@130725");
        //使用工厂方式，mybatis通过配置文件解析，使用工厂方式创建连接池
        PooledDataSourceFactory factory = new PooledDataSourceFactory();
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql://localhost:3306/test_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true");
        properties.setProperty("username", "root");
        properties.setProperty("password", "Fzy@130725");
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        factory.setProperties(properties);
        DataSource dataSource = factory.getDataSource();
        //事务
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建环境
        Environment environment = new Environment("development", transactionFactory, source);
//        Environment environment = new Environment("development", transactionFactory, dataSource);
        //创建配置对象
        Configuration configuration = new Configuration(environment);
        //加入映射器
        //这里需要注意的是，该mapper需要和对应的.xml文件 路径名一致，否则会导致扫描不到对应的sql语句。
        configuration.addMapper(UserMapper.class);

        //使用builder模式创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserEntity userEntity = mapper.selectUserById((long) 1);
        System.out.println("userEntity = " + userEntity);

    }
}
