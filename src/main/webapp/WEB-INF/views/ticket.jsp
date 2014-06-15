<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form:form action="save" method="post" modelAttribute="ticket">

<div>
Priority: 
<form:select path="priority" items="${priority }" />
</div>

<div>
Status: 
<form:select path="status" items="${status }" />
</div>

<div>
Reporter: 
<form:select path="reporter.id" items="${users }" itemValue="id" />
</div>

<div>
Assignee: 
<form:select path="assignee.id" items="${users }" itemValue="id" />
</div>

<div>
Summary:
<form:input path="summary"/>
</div>

<div>
Note:
<input type="text" name="note">
</div>

<form:button value="submit">Submit</form:button>
</form:form>

<table>

<c:forEach items="${tickets }" var="ticket">
  <tr>
    <td>${ticket.id} &nbsp; ${ticket.created} &nbsp; ${ticket.status} &nbsp; ${ticket.priority} &nbsp;
    ${ticket.reporter.name} &nbsp; ${ticket.assignee.name} &nbsp; ${ticket.summary }</td>
  </tr>
</c:forEach>

</table>
