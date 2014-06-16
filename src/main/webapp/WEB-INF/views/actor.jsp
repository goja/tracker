<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form:form action="save" method="post" modelAttribute="actor">
<div>
Name: <form:input path="name"/> <form:errors path="name" />
</div>
<form:button value="submit">Submit</form:button>
</form:form>

<table>

<c:forEach items="${actors }" var="actor">
  <tr>
    <td>${actor.name }</td>
    <td><a href="delete/${actor.id }">Delete</a></td>
  </tr>
</c:forEach>

</table>
