package src.main.java;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    public class SimpleHttpServlet extends HttpServlet {
        private static final long serialVersionUID = -1641096228274971485L;
        private Login loginChecker = new Login();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // set response headers
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            // create HTML form
            PrintWriter writer = response.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("		<head>\r\n")
                    .append("			<title>Form input</title>\r\n")
                    .append("		</head>\r\n")
                    .append("		<body>\r\n")
                    .append("			<form action=\"welcome\" method=\"POST\">\r\n")
                    .append("				Enter your login: \r\n")
                    .append("				<input type=\"text\" name=\"login\" />\r\n")
                    .append("				Enter your password: \r\n")
                    .append("				<input type=\"text\" name=\"password\" />\r\n")
                    .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                    .append("			</form>\r\n")
                    .append("		</body>\r\n")
                    .append("</html>\r\n");
        }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String recivedLogin = request.getParameter("login");
            String recivedPassword = request.getParameter("password");

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");


            PrintWriter writer = response.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("		<head>\r\n")
                    .append("			<title>Welcome message</title>\r\n")
                    .append("		</head>\r\n")
                    .append("		<body>\r\n");
            if (loginChecker.validate(recivedLogin, recivedPassword)) {
                writer.append("	Welcome " + recivedLogin + ".\r\n");
                writer.append("	You successfully logged in.\r\n");
            } else {
                writer.append("	Password and/or login is incorrect\r\n");
            }
            writer.append("		</body>\r\n")
                    .append("</html>\r\n");
        }

    }