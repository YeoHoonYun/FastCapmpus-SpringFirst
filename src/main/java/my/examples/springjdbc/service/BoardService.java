package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.Board;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-25
 * Github : https://github.com/YeoHoonYun
 */
public interface BoardService {
    List<Board> selectLists(int p, String word);

    List<Board> selectLists(int p);
    Board selectOneBoard(Long id);

    void insertBoard(String title, Long userId, String nickname, String content, String path);
    void deleteBoard(Long id);
    void updateBoard(Long id, String title, String content, String file_path);
    void createGrp(String title, Long userId, String nickname, String content, Long groupno, int grpord, int depth);
    void updateGrp(Long groupno, int grpord);

    Long pre(Long id);

    Long before(Long id);

    Long selectView();
}
