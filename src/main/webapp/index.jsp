<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="org.drublip.fooddelivery.models.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://code.iconify.design/iconify-icon/2.1.0/iconify-icon.min.js"></script>
</head>
<body>
<%@ include file="header.html"%>
<br/>
<div>
    <div class="grid grid-cols-4 gap-3 px-8">
        <c:forEach items="${restaurants}" var="res">
            <a href="/food-delivery/restaurant/${res.id}">
                <div class="flex flex-col rounded-md border-2 p-2 cursor-pointer gap-3">
                    <p class="text-xl font-bold">${res.name}</p>
                    <div class="flex flex-col gap-2">
                        <p class="flex items-center">
                            <iconify-icon icon="mdi:location" width="24" height="24"
                                          style="color: #ff3838"></iconify-icon>
                            ${res.address},${res.location}
                        </p>
                        <div class="flex items-center gap-2">
                            <c:forEach items="${res.cuisineList}" var="cuisine">
                                <p class="bg-black text-white rounded p-1">${cuisine}</p>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
</html>
