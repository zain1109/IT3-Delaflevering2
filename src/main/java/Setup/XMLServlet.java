package Setup;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "XMLServlet",
        urlPatterns = "/api"
)
public class XMLServlet extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Ahoy!");
        writer.close();
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = req.getParameter("ID");
        String pwd = req.getParameter("PW");

        if (uid.toLowerCase().equals("hans") && pwd.equals("Secret") ) {
            resp.addCookie(new Cookie("session", uid));
            PrintWriter writer = resp.getWriter();
            writer.print("Congratulations, "+uid+", you got in!");
            writer.close();
        } else {
            resp.sendRedirect("index.html");
        }
    }

}
