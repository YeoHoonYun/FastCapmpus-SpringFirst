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

import static my.examples.springjdbc.dao.query.BoardDaoSql.*;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-25
 * Github : https://github.com/YeoHoonYun
 */
@Repository
public class BoardDaoImpl implements BoardDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
    public BoardDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id");
    }
    // 내용 검색
    @Override
    public List<Board> selectLists(int startNum, int endNum, String word) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startNum", startNum);
        paramMap.put("endNum", endNum);
        paramMap.put("word", word);

        return jdbc.query(SELECT_BY_WORD, paramMap, rowMapper);
    }

    // 전체 리스트 검색
    @Override
    public List<Board> selectLists(int startNum, int endNum) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startNum", startNum);
        paramMap.put("endNum", endNum);

        return jdbc.query(SELECT_BY_PAGING, paramMap ,rowMapper);
    }

    @Override
    public Board selectOneBoard(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbc.queryForObject(SELECT_BY_ID, paramMap, rowMapper);
    }

    @Override
    public Long lastId(Long id) {
        return null;
    }

    @Override
    public void insertBoard(String title, Long userId, String nickname, String content, String path) {

    }

    @Override
    public void deleteBoard(Long id) {

    }

    @Override
    public void updateBoard(Long id, String title, String content, String file_path) {

    }

    @Override
    public void updateCount(Long id) {

    }

    @Override
    public void insertReBoard(String title, Long userId, String nickname, String content, Long groupno, int grpord, int depth) {

    }

    @Override
    public void updateGrp(Long groupno, int grpord) {

    }

    @Override
    public Long before(Long id) {
        return null;
    }

    @Override
    public Long pre(Long id) {
        return null;
    }

    @Override
    public Long selectView() {
        return null;
    }
}
