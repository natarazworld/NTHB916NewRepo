<%@ page  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
   <c:when test="${!empty pageData}">
          <h1 sytle="color:red">Report Data is</h1>
       <table border="1" align="center" bgcolor="cyan">
          <c:forEach var="actor" items="${pageData}">
             <tr>
                <td>${actor.actorId}  </td>
                <td>${actor.actorName}  </td>
                <td>${actor.actorAddrs}  </td>
                <td>${actor.mobileNo} </td>
           </tr>
          </c:forEach>
       </table> <br>
       <p style="text-align:center">
         <c:forEach  var="i" begin="1" end="${pagesCount}" step="1">
                [<a href="controller?pageNo=${i}&s1=link">${i}</a>       ]  &nbsp;&nbsp;&nbsp;
         </c:forEach>
         </p>
   
   </c:when>
   
   <c:otherwise>
           <h1 style="color:red;text-align:center">Records not found </h1>
   </c:otherwise>
  
</c:choose>

  <br>
  <a href="index.jsp">home</a>