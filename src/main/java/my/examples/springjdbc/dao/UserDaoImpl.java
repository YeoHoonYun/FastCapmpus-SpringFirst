package my.examples.springjdbc.dao;

import com.sun.javafx.collections.MappingChange;
import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.dto.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

import static my.examples.springjdbc.dao.UserDaoSql.*;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */

@Repository
public class UserDaoImpl implements UserDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
    // 스프링 컨테이너는 인스턴스를 생성하려고 생성자를 호출한다.
    // 생성자를 호출하는데, DataSource를 주입한다. (생성자 주입)
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
    public Long insertUser(String name, String nickname, String email, String passwd){
        //"insert into user(name, nickname, email, passwd, regdate) values (:name, :nickname, :email, :passwd, now())";
//        Long id = null;

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