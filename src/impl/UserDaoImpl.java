package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import po.User;
import utils.BaseDao;


public class UserDaoImpl implements UserDao{

    @Override
    public User login(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from user where name=? and password=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();//5:执行sql语句
            User users=null;
            if(rs.next()){
                users=new User();
                //从数据库中获取值设置到实体类的setter方法中
                users.setId(rs.getLong("id"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));
                users.setEmail(rs.getString("email"));
                users.setPhone(rs.getString("phone"));

                return user;
            }else{
                return null;
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 插入的方法，即注册
     */
    @Override
    public boolean register(User user) {
        String sql="insert into user values(0,?,?,?,?) ";
        List<Object> list=new ArrayList<Object>();
        list.add(user.getName());
        list.add(user.getPassword());
        list.add(user.getEmail());
        list.add(user.getPhone());

        boolean flag=BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else{
            return false;
        }
    }


}