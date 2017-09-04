package servlet;

/**
 * User: zyx
 * Date: 2017/9/4 9:27
 */
        import java.io.IOException;
        import java.lang.String;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import dao.UserDao;
        import impl.UserDaoImpl;
        import po.User;

@WebServlet("/user/userlogin")
public class UserLoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user=new User();
        //获取login.jsp页面提交的账号和密码
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        //测试数据
        System.out.println(name+" "+password);
        //获取login.jsp页面提交的账号和密码设置到实体类User中
        user.setName(name);
        user.setPassword(password);

        //引入数据交互层
        UserDao dao=new UserDaoImpl();
        User us=dao.login(user);
        //测试返回的值
        System.out.println(us);
        if(us!=null){
            request.setAttribute("info", "登陆成功");
        }else{
            request.setAttribute("info", "登录失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }



}