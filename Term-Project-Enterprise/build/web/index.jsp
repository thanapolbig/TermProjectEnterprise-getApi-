<%-- 
    Document   : index
    Created on : May 3, 2021, 11:49:34 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>

<body>
    <h3> API จาก OPENAPI </h3>

    <form action="api" method="post">

    <h4> Choose API: </h4>
         <input type=radio name="status" value="1">จำนวนเลขหมายโทรศัพท์เคลื่อนที่ที่ได้รับการจดทะเบียน <br><br>
         <input type=radio name="status" value="2">ปริมาณการใช้งานเฉลี่ยจากบริการโทรศัพท์เคลื่อนที่ (นาที/เลขหมาย/เดือน) <p>

       &nbsp &nbsp <input type=submit value="Submit">
     </form>
</body>
</html>

