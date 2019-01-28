package my.examples.springjdbc.dao.query;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
public class UserDaoSql {
    public static final String SELECT_BY_PAGING =
            "select id, name, nickname, email, regdate from user;";
    public static final String INSERT_BY_USER =
            "insert into user(name, nickname, email, passwd, regdate) values (:name, :nickname, :email, :passwd, now())";
    public static final String SELECT_BY_EMAIL = "SELECT passwd FROM user WHERE email = :email";
    public static final String SELECT_BY_USER = "SELECT id, name, nickname, email, passwd FROM user WHERE email = :email";

    //DOTO
    public static final String UPDATE_USER_ID =
            "UPDATE user set groupno = INSERT_LAST_ID WHERE id = :id ";

}
