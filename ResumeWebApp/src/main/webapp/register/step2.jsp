<%@ page import="com.company.model.User" %>
<%@ page import="com.company.model.City" %>
<%@ page import="com.company.main.Context" %>
<%@ page import="com.company.dao.inter.CityDAOInter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.dao.inter.UserDAOInter" %>
<%@ page import="com.company.model.ContactDetail" %>
<%@ page import="com.company.dao.inter.ContactDetailDAOInter" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/2/2022
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/9227f672bd.js" crossorigin="anonymous"></script>
    <title>Title</title>
    <style>
        .buttons{
            display: inline-flex;
            margin-top: 20px;
            margin-left: 5px;
        }
        .action_btn{
            margin-left: 10px;
        }
        .steps{
            margin-top: 5px;
            margin-left: 25px;
        }
    </style>
</head>
<body>
<%User u = (User) session.getAttribute("loggedInUser");
    ContactDetailDAOInter cd = Context.instanceContactDetailDAO();
    List<ContactDetail> currentDetail = cd.getContactDetailById(u);
    if(currentDetail.isEmpty()){
        ContactDetail contactDetail = new ContactDetail(null,null,null,new City(1),new User(u.getId()));
        currentDetail.add(cd.addContactDetail(contactDetail));
    }

%>
<%CityDAOInter city = Context.instanceCityDAO();
List<City> cities = city.getAll();
%>
<div class="container">
    <div class="buttons">
        <form action="step1" method="get">
            <input type="hidden" name="userId" value="<%=u.getId()%>">

            <button class="btn btn-danger action_btn" name="previous" value="Previous">
                Previous
            </button>
        </form>
        <form action="step3" method="get">
            <input type="hidden" name="userId" value="<%=u.getId()%>">
            <button class="btn btn-primary action_btn" name="next" value="Next">
                Next
            </button>
        </form>
        <p class="steps">2/5 Addım</p>
        <div style="padding-left: 700px">
            <form action="logout" method="post">
                <input type="hidden" name="userId" value="<%=u.getId()%>">
                <button class="btn btn-primary action_btn" name="logout" value="Logout">
                    Logout
                </button>
            </form>
        </div>
    </div>

    <center>
        <h2>Əlaqə məlumatlar</h2>
        <hr>
    </center>

    <form action="step2" method="post">
        <%for(int i=0;i<currentDetail.size();i++){%>
        <div class="col-4 container">
            <input type="hidden" name="userId" value="<%=u.getId()%>">
           <%if(currentDetail.get(i).getPhoneNumber()==null){%>
                <div class="form-group">
                    <label>Telefon nömrəsi</label>
                    <input required type="text" class="form-control" placeholder="(000) 000 00 00" name="phone"  >
                </div>
            <%}else{%>
            <div class="form-group">
                <label>Telefon nömrəsi</label>
                <input required type="text" class="form-control" value="<%=currentDetail.get(i).getPhoneNumber()%>" name="phone"  >
            </div>
            <%}%>

            <%if(currentDetail.get(i).getRegAddress().getId()==1){%>
            <div class="form-group">
                <label>Qeydiyyat ünvanı</label><br>
                <select class="form-control" name="cityId">
                    <%for (int j = 1; j < cities.size(); j++) {%>
                         <option value="<%=j+1%>"><%=cities.get(j)%></option>
                    <%}%>
                </select>
            </div>
            <%}else{%>
            <div class="form-group">
                <label>Qeydiyyat ünvanı</label><br>
                <select class="form-control" name="cityId">
                    <%for (int z = 1; z < cities.size(); z++) {%>
                        <%if(currentDetail.get(i).getRegAddress().getId() == cities.get(z).getId()){%>
                             <option selected value="<%=z+1%>"><%=cities.get(z)%></option>
                        <%}else{%>
                             <option value="<%=z+1%>"><%=cities.get(z)%></option>
                        <%}}%>
                </select>
            </div>
            <%}%>

            <%if(currentDetail.get(i).getActualAddress() == null){%>
            <div class="form-group">
                <label>Faktiki ünvan</label>
                <input required type="text" class="form-control" placeholder="Faktiki ünvanı daxil edin" name="actualAddress"  >

            </div>
            <%}else{%>
                <div class="form-group">
                    <label>Faktiki ünvan</label>
                    <input required type="text" class="form-control" value="<%=currentDetail.get(i).getActualAddress()%>" name="actualAddress"  >
                </div>
            <%}}%>
            <button type="submit" class="btn btn-danger" name="step2">Növbəti addım</button>
        </div>
    </form>

</div>
</body>
</html>
