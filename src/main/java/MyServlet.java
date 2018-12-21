import DB.VO.City;
import d.CityBusiness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyServlet",urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String 姓 = request.getParameter("姓");
        String 名 = request.getParameter("名");
        String 出生年份 = request.getParameter("出生年份");
        String 所在学院 = request.getParameter("所在学院");
        String 性别 = request.getParameter("性别");
        String 兴趣爱好[] = request.getParameterValues("兴趣爱好");
        String 手机号码 = request.getParameter("手机号码");
        String 电子邮箱 = request.getParameter("电子邮箱");
        String 自我评价 = request.getParameter("自我评价");

        City city = new City();
        city.setName(getServletName());
        List<City> citys = new ArrayList<City>();
        Connectmysql c = new Connectmysql();
        try {
            c.insert(City);
            City = c.search();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<City> city = CityBusiness.Business(request);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for(City  c :City)
            out.println("<H2>"+c.toString()+"</H2>");
        out.println("</body></html>");
        out.close();

        out = response.getWriter();
        out.println("<html><body>");
        out.println("<H1> Hello World!+</H1><br>");
        out.println("姓:"+(姓!=null?姓:"") + "<br>");
        out.println("名:"+(名!=null?名:"") + "<br>");
        out.println("手机号码:"+(手机号码!=null?手机号码:"") + "<br>");
        out.println("电子邮箱:"+(电子邮箱!=null?电子邮箱:"") + "<br>");
        out.println("出生年份:"+(出生年份!=null?出生年份:"") + "<br>");
        out.println("所在学院:"+(所在学院!=null?所在学院:"") + "<br>");
        out.println("性别:"+(性别!=null?性别:"") + "<br>");
        out.print("兴趣爱好:"+ "<br>");
        for(int i=0;兴趣爱好 != null && i<兴趣爱好.length;i++)
            out.println(兴趣爱好[i]+ "<br>");
        out.println("description:"+ "<br>"+自我评价+ "<br>");
        out.println("</body></html>");
        out.close();

    }
}
