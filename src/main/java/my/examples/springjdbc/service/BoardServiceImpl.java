package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.BoardDaoImpl;
import my.examples.springjdbc.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-25
 * Github : https://github.com/YeoHoonYun
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public List<Board> selectLists(int p, String word) {
        return null;
    }

    @Override
    public List<Board> selectLists(int p) {
        return null;
    }

    @Override
    public Board selectOneBoard(Long id) {
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
    public void createGrp(String title, Long userId, String nickname, String content, Long groupno, int grpord, int depth) {

    }

    @Override
    public void updateGrp(Long groupno, int grpord) {

    }

    @Override
    public Long pre(Long id) {
        return null;
    }

    @Override
    public Long before(Long id) {
        return null;
    }

    @Override
    public Long selectView() {
        return null;
    }
}
