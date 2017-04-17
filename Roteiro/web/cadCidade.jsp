<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Nova Cidade</h1>

<form method="POST" action="central">
    <input type="hidden" name="op" value="gravaCidade" />
    nome: <input type="text" name="cpNome" value="" /><br />
    distrito: <input type="text" name="cpDistrito" value="" /><br />
    população <input type="text" name="cpPopulacao" value="" /><br />
    Pais: 
    
    <select name="cpPais">
        <c:forEach items="${requestScope.paises}" var="p">
            <option value="${p.code}">${p.name}</option>            
        </c:forEach>
    </select>
    
    <br />
    <br />
    <input type="submit" value="Gravar" />
</form>