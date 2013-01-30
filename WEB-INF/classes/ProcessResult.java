import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessResult extends HttpServlet
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

	     // String getName = (String)req.getAttribute("name");

	      // String getName = (String)session.getAttribute("name");

	       String add = req.getParameter("add");

	       String sub = req.getParameter("sub");

	  String getName =  req.getParameter("user1");

	 /// String getName5 =  req.getParameter("flagx");

	 // String getName1 =  req.getParameter("add");

	 //  String getName2 =  req.getParameter("sub");

//System.out.println("getName1  "+getName1);

//System.out.println("getName5  "+getName5);

		 	        System.out.println("Amount to be added is  "+add);

		 	        System.out.println("Amount to be subtracted is  "+sub);

		 	         System.out.println("File name is  "+getName);

		 	         String filename = "/WEB-INF/"+getName+".txt";


		 		     String strLine=null;

		 		     String strLine1=null;

		 		     String strLine2=null;

		 		     String strLinea=null;


		 		     ServletContext context = getServletContext();

		 		     InputStream inp = context.getResourceAsStream(filename);

                     Writer writer = null;

		              if(inp != null && add!=null&&sub==null) {

		 				try
		        				{

					InputStreamReader isr = new InputStreamReader(inp);

					 BufferedReader br1 = new BufferedReader(isr);

					 strLine = br1.readLine();



		              			 int i = Integer.parseInt(strLine.trim());

		              			 int j = Integer.parseInt(add.trim());

		              			 int final1 = i+j;



		              			 System.out.println("Total amount = "+final1);

								//File file = new File("dinesh.txt");

								//OutputStream fcheck = null;
								//fcheck = new FileOutputStream(filename);
								// fcheck.write(final1);

							//File file = new File("eeee");
		              		// FileWriter fstream = new FileWriter("\\WEB-INF\\"+getName+".txt",true);
								// BufferedWriter out = new BufferedWriter(fstream);
								 //   out.write("final1");
								  //  out.close();

								//  String filename1 = "aaaa.txt";
								              //File file = new File("write1.txt");
								//  FileWriter fstream = new FileWriter(filename1);
								// BufferedWriter out = new BufferedWriter(fstream);
								//  out.write("final2");
			 					  //out.close();

			 					/*  Writer output = null;

			 					  File file = new File("write.txt");
								    output = new BufferedWriter(new FileWriter(file));
								    output.write(aString);
    								output.close();*/
    								String aString = Integer.toString(final1);

    						//		File file = new File(filename);
					    		//    String absolutePathOfFirstFile = file.getAbsolutePath();
								//System.out.println("absolutePath:" + file.getAbsolutePath());
					    	//	//    String fff = file.getPath();
							//System.out.println("Path:" + file.getPath());

    				//String filename1 = "c:\\"+getName+".txt";
    				//String filename1 = "\\WEB-INF\\"+getName+".txt";
    				FileWriter fw = new FileWriter(context.getRealPath(filename));
    				fw.write(aString);
    				fw.flush();
      				fw.close();


					    //System.out.println(" The absolute path in first form is "+ absolutePathOfFirstFile);


		              			// File file = new File("eeee");

		              			// writer = new BufferedWriter(new FileWriter(file));

		              			// writer.write("final1");
		              			// writer.close();


 						InputStream inp1 = context.getResourceAsStream(filename);
						InputStreamReader isr1 = new InputStreamReader(inp1);
              			BufferedReader br2 = new BufferedReader(isr1);


						strLine1 = br2.readLine();
						System.out.println("yyyyyy"+strLine1);




		              			  req.setAttribute("name1",getName);

             			 		  req.setAttribute("amount",aString);

		              			    RequestDispatcher rd = req.getRequestDispatcher("/display.jsp");
		    					    rd.forward(req, res);










		 	   } catch(Exception e){

				   System.out.println("Error occured in ProcessResult");
				   e.printStackTrace();


				   }

		 	  /* finally
			           {
			               try
			               {
			                   if (writer != null)
			                   {
			                       writer.close();
			                   }
			               } catch (IOException e)
			               {
			                   e.printStackTrace();
			               }
        }*/


		 			 } else if(add==null && sub!=null) {

							try
		        				{

				InputStreamReader isra = new InputStreamReader(inp);

				 BufferedReader bra = new BufferedReader(isra);

				 strLinea = bra.readLine();

			int i1 = Integer.parseInt(strLinea.trim());

		   	int j1 = Integer.parseInt(sub.trim());

		   	int finala = i1-j1;


			System.out.println("Subtracted amount is  = "+finala);

			String bString = Integer.toString(finala);

			FileWriter fw1 = new FileWriter(context.getRealPath(filename));
			    				fw1.write(bString);
			    				fw1.flush();
			      				fw1.close();






 		InputStream inpb = context.getResourceAsStream(filename);
		InputStreamReader isrb = new InputStreamReader(inpb);
        BufferedReader brb = new BufferedReader(isrb);


			strLine2 = brb.readLine();
			System.out.println("yyyyyy"+strLine2);




		            req.setAttribute("name1",getName);

             		req.setAttribute("amount",bString);

		               RequestDispatcher rd = req.getRequestDispatcher("/display.jsp");
		    		   rd.forward(req, res);




			} catch(Exception e){

				   System.out.println("Error occured in ProcessResult");
				   e.printStackTrace();













					 }


		 }
}
}

