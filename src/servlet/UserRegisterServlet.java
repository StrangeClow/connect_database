package servlet;

/**
 * User: zyx
 * Date: 2017/9/4 10:36
 */
        import java.io.IOException;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import dao.UserDao;
        import impl.UserDaoImpl;
        import po.User;

/**
 * 注册的servlet
 */
@WebServlet("/user/userregister")
public class UserRegisterServlet extends HttpServlet{

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
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");

        //获取register.jsp页面提交的账号和密码设置到实体类User中
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);

        //引入数据交互层
        UserDao dao=new UserDaoImpl();
        boolean flag=dao.register(user);
        if(flag){
            request.setAttribute("info", "注册成功");
        }else{
            request.setAttribute("info", "注册失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
