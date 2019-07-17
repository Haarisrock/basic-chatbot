<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bot.News" %>
<!DOCTYPE html>
<html>
<head>
	<title>ChatBot</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
			<%! int listSize;int i;String head=""; %>
            <%
                if (request.getAttribute("nList") != null) {
                    ArrayList result = (ArrayList) request.getAttribute("nList");
        		    listSize=result.size();

                    for(i=0;i<listSize;i++) {
                        head+=((News)result.get(i)).getHeadline()+"\n";
                        %>
                        <a></a>
                    <%}
            	    request.setAttribute("message", head);
				}
				else {
					head = "No Such Records found!";
					request.setAttribute("message",head);
				}
            %>
<script>
function updateUI(){
	var result = "<% request.getAttribute("message"); %>";
	document.getElementById("textSent").value = result;
}
</script>

<body>
<div>
<textarea rows="34" cols="165" disabled="1" id="textSent"></textarea>
<form action="./bot/Search" method="get">
<input type="text" name="msg" placeholder="Enter '!help' to know my Commands,then continue your way..." id="msg">
<button class="button" type="button" id="sendButton" onclick="updateUI()">Talk to Bot</button>
</form>
</div>
</body>
</html>
