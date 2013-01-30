import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser1 extends HttpServlet
{

//String filename = "/WEB-INF/classes/password.txt";

String filename = "/WEB-INF/password.txt";
//File file=new File(filename);


String strLine=null;
//boolean exists = file.exists(); //return true if password file exist
String delimiter = " ";
String[] tokens = null;
int flag = 0;

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

     ServletContext context = getServletContext();
    // HttpSession session = req.getSession(true);
     InputStream inp = context.getResourceAsStream(filename);
    /* if (inp != null) {
	 		      InputStreamReader isr = new InputStreamReader(inp);
	               BufferedReader br1 = new BufferedReader(isr);
      	      strLine = br1.readLine();
      	      Out.println("strLine value is "+strLine);
		  }*/

     //if (inp != null) {
	// InputStreamReader isr = new InputStreamReader(inp);
     // BufferedReader reader = new BufferedReader(isr);



    // Out.println("exist value is "+exists);
    if(inp != null) {
     try
       {
		    System.out.println("I am in tr.."+inp);

		    String username = req.getParameter("username");
            String password = req.getParameter("password");


         //  FileInputStream fs = new FileInputStream(filename);
        //   DataInputStream in = new DataInputStream(fs);
      	//   BufferedReader br1 = new BufferedReader(new InputStreamReader(in));

		      InputStreamReader isr = new InputStreamReader(inp);
              BufferedReader br1 = new BufferedReader(isr);
      	      strLine = br1.readLine();


      	    Pattern p1 = Pattern.compile(delimiter);
      	    Matcher matcher = p1.matcher(strLine);

       if(!strLine.equals(null)) {
             InputStream inp1 = context.getResourceAsStream(filename);
		     InputStreamReader isr1 = new InputStreamReader(inp1);
              BufferedReader br2 = new BufferedReader(isr1);

		   while(matcher.find()) {
					while ((strLine = br2.readLine()) != null) {

										tokens = strLine.split("\\s");
										//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
										//System.out.println("Printing tokens");
										//for(int i=0;i<=tokens.length-1;i++)
						           		//Out.println("tokens "+i+" "+tokens[i]);
						                //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
						                if(tokens[0].equals(username) && tokens[1].equals(password)) {

                 req.setAttribute("name",username);

				RequestDispatcher rd = req.getRequestDispatcher("/Process");
   				rd.forward(req,res);

										System.out.println("Login successfulls");
										flag = 1;

										}//else{Out.println("Login Unsuccessfulls");}


										}

									}

									if(flag==0){ Out.println("Login Unsuccessfulls"); }


							  }



						}catch(Exception e){Out.println("Exception has occured");}

} else{Out.println("No file found...");}


}

}














