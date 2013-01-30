import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Process extends HttpServlet
{


	public void init(ServletConfig config) throws ServletException
	      {

	      super.init(config);

	      }


	  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{

	     doPost(req,res);

	      }

	 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	      {
	     res.setContentType("text/html");
	     PrintWriter Out = res.getWriter();

	        String getName = (String)req.getAttribute("name");

	        System.out.println("getName value is "+getName);

	         String filename = "/WEB-INF/"+getName+".txt";


		     String strLine=null;

		     ServletContext context = getServletContext();

		     InputStream inp = context.getResourceAsStream(filename);


             if(inp != null) {

				try
       				{


						InputStreamReader isr = new InputStreamReader(inp);

						BufferedReader br1 = new BufferedReader(isr);

             			strLine = br1.readLine();

             			System.out.println("strLine value in Process servlet is  "+strLine);

             			 req.setAttribute("name1",getName);

             			 req.setAttribute("amount",strLine);

             			RequestDispatcher rd = req.getRequestDispatcher("/display.jsp");
   					    rd.forward(req, res);










	   } catch(Exception e){Out.println("Exception has occured");}


			 }


}

}