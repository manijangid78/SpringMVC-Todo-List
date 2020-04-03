<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "com.mani.util.AttributesName" %>

<html>
<head>
    <title>View Item</title>
</head>
<body>
    <div align="center">

           <table>
                   <tr>
                       <td><label>ID</label></td>
                       <td><c:out value="${toDoItem.id}" /></td>
                   </tr>
                   <tr>
                       <td><label>Title</label></td>
                       <td><c:out value="${toDoItem.title}" /></td>
                   </tr>
                   <tr>
                       <td><label>Deadline</label></td>
                       <td><c:out value="${toDoItem.deadline}" /></td>
                   </tr>
                   <tr>
                       <td><label>Details</label></td>
                       <td><c:out value="${toDoItem.details}" /></td>
                   </tr>
            </table>

            <c:url var = "itemUrl" value="items" />
            <a href="${itemUrl}">Show Tables</a>

    </div>
</body>
</html>