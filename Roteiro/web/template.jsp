<%-- 
    Document   : template
    Created on : 12/04/2017, 14:38:21
    Author     : viniciuspeixoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <header></header>

    <corpo>

        <div id="page"> 
            <!-- begin container -->  
            <div id="container"> 
                <!--  content -->  
                <div id="content">

                    <c:if test="${param.page == null}">
                        <jsp:include page="pg/home.jsp" /> 
                    </c:if>
                    <c:if test="${param.page != null}">
                        <c:set var="pg" value="pg/${param.page}.jsp" /> 
                        <jsp:include page="${pg}" />
                    </c:if>

                    <div class="clear" style="height:40px"></div> 
                </div>  
                <!-- end content --> 
            </div>  
            <!-- end container --> 
        </div>

    </corpo>

    <foote></foote>

</body>
</html>
