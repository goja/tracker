<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3><spring:message code="ticket.header" /></h3>
[<a href="/tracker/ticket/findAll">create new</a>]

<form:form action="/tracker/ticket/save" method="post" modelAttribute="ticket">

<div>
<spring:message code="ticket.priority" />: 
<form:select path="priority" items="${priority }" />
</div>

<div>
<spring:message code="ticket.status" />: 
<form:select path="status" items="${status }" />
</div>

<div>
<spring:message code="ticket.reporter" />: 
<form:select path="reporter" items="${actors }" itemValue="id" />
</div>

<div>
<spring:message code="ticket.assignee" />: 
<form:select path="assignee" items="${actors }" itemValue="id" />
</div>

<div>
<spring:message code="ticket.summary" />:
<form:input path="summary"/>
</div>

<div>
<spring:message code="ticket.note" />:
<input type="text" name="note">
</div>

<div>
<spring:message code="ticket.due" />:
<input type="text" name="due">
</div>

<form:hidden path="id"/>
<form:hidden path="created"/>
<form:hidden path="modified"/>
<form:hidden path="version"/>

<form:button value="submit"><spring:message code="label.submit" /></form:button>
</form:form>

<table>

<c:forEach items="${tickets }" var="ticket">
  <tr>
    <td>${ticket.id} &nbsp; ${ticket.created} &nbsp; ${ticket.status} &nbsp; ${ticket.priority} &nbsp;
    ${ticket.reporter.userName} &nbsp; ${ticket.assignee.userName} &nbsp; ${ticket.summary }</td>
    <td><a href="/tracker/ticket/update/${ticket.id }"><spring:message code="label.update" /></a></td>
    <td><a href="/tracker/ticket/delete/${ticket.id }"><spring:message code="label.delete" /></a></td>
  </tr>
</c:forEach>

</table>
