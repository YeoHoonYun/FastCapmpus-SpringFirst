package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

import static my.examples.springjdbc.dao.query.UserDaoSql.*;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */

@Repository
public class UserDaoImpl implements UserDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
    public UserDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public List<User> selectAll() {
        return jdbc.query(SELECT_BY_PAGING, rowMapper);
    }

    @Override
    public String emailToPasswd(String email){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        String passwd = jdbc.queryForObject(SELECT_BY_EMAIL, paramMap, rowMapper).getPasswd();
        return passwd;
    }

    @Override
    public User emailToUser(String email){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        User user = jdbc.queryForObject(SELECT_BY_USER, paramMap, rowMapper);
        return user;
    }

    @Override
    public Long insertUser(String name, String nickname, String email, String passwd){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("nickname", nickname);
        paramMap.put("email", email);
        paramMap.put("passwd", passwd);
        paramMap.put("regdate", new Date());

//        jdbc.update(INSERT_BY_USER,paramMap);
        Long number = simpleJdbcInsert.executeAndReturnKey(paramMap).longValue();

        return number;
    }
}