<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "com.mani.util.Mappings" %>

<html>
<head>
    <title>To-Do List</title>
</head>
<body>
    <div align="center">
        <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
        <a href="${addUrl}">Add New Item</a>

        <table border="1" cellpadding="5">
            <caption><h2>ToDo-List</h2></caption>

            <tr>
                <th>Title</th>
                <th>DeadLine</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="item" items="${toDoData.items}">
                <c:url var="viewUrl" value="${Mappings.VIEW_ITEM}" >
                    <c:param name = "id" value = "${item.id}" />
                </c:url>

                <c:url var="editUrl" value="${Mappings.ADD_ITEM}" >
                    <c:param name = "id" value = "${item.id}" />
                </c:url>

                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}" >
                    <c:param name = "id" value = "${item.id}" />
                </c:url>

                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${viewUrl}">View</a></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>

            </c:forEach>
        </table>
    </div>
</body>
</html>