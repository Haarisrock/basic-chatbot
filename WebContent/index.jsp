<%@ page import="bot.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<title>Example</title>
</head>
<body>
	<textarea rows="35" cols="165">
		<%! int listSize;int i;String head=""; %>
            <%
                if (request.getAttribute("nList") != null) {
                    ArrayList<News> result = (ArrayList<News>)request.getAttribute("nList");
        		    listSize=result.size();

                    for(i=0;i<listSize;i++) {
                        head+=((News)result.get(i)).getHeadline()+"\n";
                    }
            	    request.setAttribute("message", head);
				}
				else {
					head = "No Such Records found!";
					request.setAttribute("message",head);
				}
            
            %>
            <%= head  %>
    
	</textarea>
</body>
</html>
