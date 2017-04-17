<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Lista de Cidades</h1>

<form action="homeCentral">
    <input type="hidden" name="op" value="novoCadCidade" />
    <input type="submit" value="Nova Cidade" />
</form>

<a href="homeCentral?op=novoCadCidade">Nova Cidade</a>
<br />
<c:if test="${requestScope.msg != null}">
    ${requestScope.msg}
</c:if>

<table border="1">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Pais</th>
            <th>População</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${requestScope.lista}" var="c" >
            <tr>
                <td>${c.name}</td>
                <td>${c.countryCode.name}</td>
                <td>${c.population}</td>
            </tr>
        </c:forEach>

    </tbody>
</table>
