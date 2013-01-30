<%@page import="java.io.*" %>



<HTML>
    <HEAD>
        <TITLE>Page 2</TITLE>
        <script type="text/javascript">
	function displaytext()
	{
	
		
		var d=document.getElementById("div");
		d.innerHTML+="<p><input type='text' name='add' value=''>";
		d.innerHTML+="<p><input type='Submit' name='but' value='Submit'>";
		
	
		
	
	}
	
	function displaytextt()
	{
	var d=document.getElementById("div");
	d.innerHTML+="<p><input type='text' name='sub' value=''>";
	d.innerHTML+="<p><input type='Submit' name='but' value='Submit'>";
	
	
	
	}
	
	
	
	
	
	</script>
        
        
        
    </HEAD>

    <BODY>
    <%
    
    String abc = (String)request.getAttribute("name1");
    
    String amt = (String)request.getAttribute("amount");
    
    session.setAttribute("name", abc);
  
   %><h1><% out.println("Welcome "+abc); %></h1>
    
   
       
       <b>Current Bank Balance : <%=amt%> </b>
       <form id="form1" name="form1" method="post" action=ProcessResult?user1=<%=(String)request.getAttribute("name1")%>>
 	   <table>
	                <tr>
	                <div id="div"></div>
	                
	                <td><input type="Button" value="Add Money" onclick="displaytext()" /></td> <td><input type="Button" value="Remove Money" onclick="displaytextt()" /></td>
	                
	                </tr>
	                
         </table>
        
         <% request.setAttribute("new_name",abc);%>
        
       </form>   
    
         
    
    </BODY>
</HTML> 


        