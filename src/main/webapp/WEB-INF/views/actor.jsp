<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3><spring:message code="actor.header" /></h3>

<form:form action="save" method="post" modelAttribute="actor">
<div>
<spring:message code="label.name" />: <form:input path="name"/> <form:errors path="name" />
</div>
<form:button value="submit"><spring:message code="label.submit" /></form:button>
</form:form>

<table>

<c:forEach items="${actors }" var="actor">
  <tr>
    <td>${actor.name }</td>
    <td><a href="delete/${actor.id }"><spring:message code="label.delete" /></a></td>
  </tr>
</c:forEach>

</table>
