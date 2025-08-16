<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<table class = "left-menu-table">
    <sec:authorize access="hasAuthority('ADMIN')">
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/doctors"><p>List of doctors</p></p></a>
            </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/createDoctor"><p>Register a doctor</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/visitRecords"><p>View archive of doctors' records</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/admin/reviews"><p>View patients feedbacks</p></a>
             </td>
        </tr>
    </sec:authorize>

    <sec:authorize access="hasAuthority('PATIENT')">
        <tr>
             <td class = "left-menu-bar">
                <a href="/patient/doctors"><p>Make an appointment</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/patient/visits"><p>List of planned visits</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/patient/reviews"><p>Leave feedback</p></a>
             </td>
        </tr>
    </sec:authorize>
    <sec:authorize access="hasAuthority('DOCTOR')">
        <tr>
             <td class = "left-menu-bar">
                <a href="/doctor/today"><p>Schedule for today</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/doctor/timeTable"><p>Schedule</p></a>
             </td>
        </tr>
        <tr>
             <td class = "left-menu-bar">
                <a href="/doctor/visitRecords"><p>Viewing the archive of visits</p></a>
             </td>
        </tr>
    </sec:authorize>
</table>