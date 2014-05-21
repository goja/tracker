<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form:form action="save" method="post" modelAttribute="user">
<div>
Name: <form:input path="name"/> <form:errors path="name" />
</div>
<form:button value="submit">Submit</form:button>
</form:form>

<table>

<c:forEach items="${users }" var="user">
  <tr>
    <td>${user.name }</td>
    <td><a href="delete/${user.id }">Delete</a></td>
  </tr>
</c:forEach>

</table>
