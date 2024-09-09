<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Restaurant</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://code.iconify.design/iconify-icon/2.1.0/iconify-icon.min.js"></script>
</head>
<body>
<%@ include file="header.html"%>
<br/>
<div >
    <h1 class="text-3xl font-bold text-center mb-4">${data.restaurant.name}</h1>
    <div class="flex flex-col items-center gap-3">
        <c:forEach items="${data.menu.menuItemList}" var="menuItem">
            <div class="w-[800px] flex items-center justify-between rounded-md border-2 p-2 gap-3">
                <div class="flex flex-col gap-1">
                    <h1 class="font-bold">${menuItem.name}</h1>
                    <p class="text-gray-500">${menuItem.description}</p>
                    <p class="flex items-center">
                        <iconify-icon icon="mdi:rupee" width="24" height="24"></iconify-icon>
                        ${menuItem.price}
                    </p>
                </div>
                <div>
                    <button class="bg-white border text-black p-3 w-[100px] text-center  hover:bg-black hover:text-white">Add</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
