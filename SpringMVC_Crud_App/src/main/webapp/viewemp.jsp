<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#523215">
    <h1>List of Employees</h1>
    <table border="2" align="center"   width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Phone No</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}">
    <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.salary}</td>
    <td>${emp.designation}</td>
     <td>${emp.phoneno}</td>
     <td>${emp.email}</td>
   
    <td><a href="editemp/${emp.id}">ModifyEmployee</a></td>
    <td><a href="deleteemp/${emp.id}">DeleteEmployee</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="empform">Add New Employee</a>
    </body>
    </html>