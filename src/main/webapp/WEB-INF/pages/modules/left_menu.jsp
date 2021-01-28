<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<table class = "left-menu-table">
    <sec:authorize access="hasAuthority('ADMIN')">
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/doctors"><p>Список докторов</p></p></a>
            </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/createDoctor"><p>Зерегистрировать врача</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/visitRecords"><p>Просмотр архива записей врачей</p></a>
             </td>
        </tr>
    </sec:authorize>

    <sec:authorize access="hasAuthority('PATIENT')">
        <tr>
             <td class = "left-menu-bar">
                <a href="#"><p>Записатся на прием</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="#"><p>Список запланированных посешений</p></a>
             </td>
        </tr>
    </sec:authorize>
    <sec:authorize access="hasAuthority('DOCTOR')">
        <tr>
             <td class = "left-menu-bar">
                <a href="#"><p>Приемы сегодня</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="#"><p>Мое расписание</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="#"><p>Просмотр архива посешений</p></a>
             </td>
        </tr>
    </sec:authorize>
</table>