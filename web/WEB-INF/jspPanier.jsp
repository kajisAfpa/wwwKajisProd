<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${panierVide}">Panier vide !</c:if>
<c:if test="${!panierVide}"><c:forEach var="i" items="${items}">
${i.ref}/${i.qty}
<a href="controller?section=calculPanier&add=${i.ref}">+</a>
<a href="controller?section=calculPanier&dec=${i.ref}">-</a>
<a href="controller?section=calculPanier&del=${i.ref}">X</a>
<br>       
</c:forEach>
<a href="controller?section=calculPanier&vider">Vider le panier</a>
</c:if>
