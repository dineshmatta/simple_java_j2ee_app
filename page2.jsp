<HTML>
    <HEAD>
        <TITLE>Page 2</TITLE>
    </HEAD>

    <BODY>
    <%
    
    String abc = (String)request.getAttribute("name1");
    
   String amt = (String)request.getAttribute("amount");
    
   
    out.println("Welcome "+abc);
    
    
    
    %>
        
       
       <b>Current Bank Balance : <%out.println(amt)</b>
 	<table>
             <tr>
             
             <td><input type="submit" value="Add Money" /></td> <td><input type="submit" value="Remove Money" /></td>
             
             </tr>
             
         </table>
      
    
    </BODY>
</HTML> 