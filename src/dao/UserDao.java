package dao;

import po.User;

/**
 *
 * 创建一个接口用于声明用户登陆注册的方法
 */
public interface UserDao {

    /***
     * 用户登陆的方法声明
     * @param user
     * @return
     */
    public User login(User user);

    /***
     * 用户注册的方法声明
     * @param user
     * @return
     */
    public boolean register(User user);
}