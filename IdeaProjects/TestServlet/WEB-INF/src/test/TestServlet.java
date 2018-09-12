package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Properties;
import java.util.Base64;

@WebServlet(name = "t", urlPatterns = {"/test/*"})
public class TestServlet extends HttpServlet {

  private static final String LOCATION = "/opt/tomcat/webapps/TestServlet/WEB-INF/config.conf";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "password";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {

    boolean success = checkAuth(request);
    if (success) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");
       } catch (Exception e) {
         e.printStackTrace(System.err);
       } finally {
         out.close();
      }
    } else {
      noAccess(response);
    }
   }

   private boolean checkAuth(HttpServletRequest request) {
     String authValue = request.getHeader("Authorization");
     if (authValue == null) {
       return false;
     } else {
       if (!authValue.toUpperCase().startsWith("BASIC ")) {
         return false;
       } else {
         String userPass = new String(Base64.getDecoder().decode(authValue.substring(6)));
         int count = userPass.indexOf(":");
         String observedUsername = userPass.substring(0, count);
         String observedPassword = userPass.substring(count + 1);
         if (observedUsername.equals(USERNAME) && observedPassword.equals(PASSWORD)) {
           return true;
         }
        }
     }
     return false;
   }

   private void noAccess(HttpServletResponse response) {
     try {
       response.sendError(401);
     } catch (Exception e) {
       e.printStackTrace(System.err);
     }
   }

   @Override
   public String getServletInfo() {
     return "This is a test servlet.";
   }

   @Override
   public void init() {
     try {
       Properties pr = new Properties();
       File conf = new File(LOCATION);
       if (conf.exists() && conf.canRead()) {
         System.out.println("Reading from configuration file: ");
         pr.load(new FileInputStream(conf));
         String username = pr.getProperty("dbusername");
         String password = pr.getProperty("dbpassword");
         System.out.println("User: " + username + " - Password " + password);
         } else {
           System.out.println("File did not found!");
         }
       } catch (Exception e) {
         e.printStackTrace(System.err);
       }
   }

   @Override
   public void destroy() {}
}
