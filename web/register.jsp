<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/4
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册的页面</title>
    <style type="text/css">
        h1{text-align:center;}
        h4{text-align:right;color:red;}
        body{background:url("/WEB-INF/image/s.jpg")}
    </style>

    <script src="https://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            //alert("测试jQuery是否能用");
            $("#form1").submit(function(){
                var name=$("#name").val();//获取提交的值
                if(name.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                    //alert("aa");//测试使用
                    $("#nameError").html("账号不能为空");
                    return false;
                }

                //密码进行验证不能为空
                var password=$("#password").val();//获取提交的密码的值
                if(password.length==0){
                    $("#passwordError").html("密码不能为空");
                    return false;
                }

                //确认密码进行验证
                var relpassword=$("#relpassword").val();//获取提交的确认密码的值
                if(relpassword.length==0){
                    $("#relpasswordError").html("确认密码不能为空哦");
                    return false;
                }

                if(password!=relpassword){
                    $("#relpasswordError").html("确认密码输入不正确，请重新输入");
                    return false;
                }
            });

        });
    </script>
</head>
<body>
<form action="user/userregister" method="post" id="form1">
    <h1>用户注册页面</h1>
    <h4>装饰中......</h4>
    <hr/>
    <table align="center">
        <tr>
            <td>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
            <td>
                <input type="text" name="name" id="name"/>
                <div id="nameError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td>
                <input type="password" name="password" id="password">
                <div id="passwordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input type="password" name="relpassword" id="relpassword">
                <div id="relpasswordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input type="text" name="phone" id="phone"></td>
        </tr>
        <tr>
            <td>电子邮件：</td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/>
                <a href="index.jsp" target="_blank">登陆</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
