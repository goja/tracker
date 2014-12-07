<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3><spring:message code="actor.header" /></h3>
[<a href="/tracker/actor/findAll">create new</a>]

<form:form action="/tracker/actor/save" method="post" modelAttribute="actor">

<div>
<spring:message code="actor.userName" />: <form:input path="userName"/> <form:errors path="userName" />
</div>
<div>
<spring:message code="actor.firstName" />: <form:input path="firstName"/> <form:errors path="firstName" />
</div>
<div>
<spring:message code="actor.lastName" />: <form:input path="lastName"/> <form:errors path="lastName" />
</div>
<div>
<spring:message code="actor.email" />: <form:input path="email"/> <form:errors path="email" />
</div>

<form:hidden path="id"/>
<form:hidden path="created"/>
<form:hidden path="modified"/>
<form:hidden path="version"/>

<form:button value="submit"><spring:message code="label.submit" /></form:button>
</form:form>

<table>

<c:forEach items="${actors }" var="actor">
  <tr>
    <td>${actor.userName }</td>
    <td>${actor.firstName }</td>
    <td>${actor.lastName }</td>
    <td>${actor.email }</td>
    <td><a href="/tracker/actor/update/${actor.id }"><spring:message code="label.update" /></a></td>
    <td><a href="/tracker/actor/delete/${actor.id }"><spring:message code="label.delete" /></a></td>
  </tr>
</c:forEach>

</table>
