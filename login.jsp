<HTML>
    <HEAD>
        <TITLE>Login using jsp</TITLE>
    </HEAD>

    <BODY>
        <center>
        <H1>LOGIN FORM</H1>
        <%
        String myname =  (String)session.getAttribute("username");
     
            %> 
            <form action="ValidateUser1" method=post>
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td> 
                    </tr>
                </table>
                <input type="submit" value="login" />
            </form>
           
    </center>    
    </BODY>
</HTML> 