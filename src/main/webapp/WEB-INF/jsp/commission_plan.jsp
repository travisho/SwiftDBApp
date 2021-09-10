<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Commission Plan</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<input type="checkbox" id="check">
<header>
    <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
    </label>
    <div class="left">
        <h1><img src="https://pics.harstatic.com/office/986021.png" width="66" height="54" class="company_logo">Yun Global LLC</h1>
    </div>
</header>
    <div class="sidebar">
        <div class="sidebar-header">
            <center>
            </center>
        </div>
        <ul class="list-unstyled components">
            <li>
                <a href="/">Home</a>
            </li>
            <li>
                <a href="#agent-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Agent Info</a>
                <ul class="collapse list-unstyled" id="agent-submenu">
                    <li>
                        <a href="/AgentData">Agent</a>
                    </li>
                    <li>
                        <a href="/Agent_EmailData">Agent Email</a>
                    </li>
                    <li>
                        <a href="/Agent_Phone_NumberData">Agent Phone Number</a>
                    </li>
                    <li>
                        <a href="/PaycheckData">Paycheck</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#client-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Client Info</a>
                <ul class="collapse list-unstyled" id="client-submenu">
                    <li>
                        <a href="/ClientData">Client</a>
                    </li>
                    <li>
                        <a href="/Client_EmailData">Client Email</a>
                    </li>
                    <li>
                        <a href="/Client_Phone_NumberData">Client Phone Number</a>
                    </li>
                    <li>
                        <a href="/ContractData">Contract</a>
                    </li>
                    <li>
                        <a href="/AppointmentData">Appointment</a>
                    </li>
                    <li>
                        <a href="/DiscussionData">Discussion</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#broker-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Broker Info</a>
                <ul class="collapse list-unstyled" id="broker-submenu">
                    <li>
                        <a href="/BrokerData">Broker</a>
                    </li>
                    <li>
                        <a href="/Broker_EmailData">Broker Email</a>
                    </li>
                    <li>
                        <a href="/Broker_Phone_NumberData">Broker Phone Number</a>
                    </li>
                    <li>
                        <a href="/Commission_PlanData">Commission Plan</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#property-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Property Info</a>
                <ul class="collapse list-unstyled" id="property-submenu">
                    <li>
                        <a href="/PropertyData">Property</a>
                    </li>
                    <li>
                        <a href="/Property_RemodelData">Property Remodel</a>
                    </li>
                    <li>
                        <a href="/Title_OwnerData">Title Owner</a>
                    </li>
                    <li>
                        <a href="/Top_FeatureData">Top Feature</a>
                    </li>
                    <li>
                        <a href="/Floor_PlanData">Floor Plan</a>
                    </li>
                    <li>
                        <a href="/RoomData">Room</a>
                    </li>
                    <li>
                        <a href="/BathroomData">Bathroom</a>
                    </li>
                    <li>
                        <a href="/Heating_UnitData">Heating Unit</a>
                    </li>
                    <li>
                        <a href="/AC_UnitData">AC Unit</a>
                    </li>
                    <li>
                        <a href="/GarageData">Garage</a>
                    </li>
                    <li>
                        <a href="/OutdoorData">Outdoor</a>
                    </li>
                    <li>
                        <a href="/Home_AppraisalData">Home Appraisal</a>
                    </li>
                    <li>
                        <a href="/Open_House_SessionData">Open House Session</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#property-finance-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Property Finance</a>
                <ul class="collapse list-unstyled" id="property-finance-submenu">
                    <li>
                        <a href="/Property_FinanceData">Property Finance</a>
                    </li>
                    <li>
                        <a href="/Utility_BillData">Utility Bill</a>
                    </li>
                    <li>
                        <a href="/Homeowner_AssociationData">Homeowner Association</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
<div class="content">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <body>

        <h2>Commission Plan</h2>

        <!-- Table starts here --------------------------------->
        <table>
            <tr>
                <th>Total Commission</th>
                <th>Yun Global %</th>
                <th>Broker</th>
                <th>Broker %</th>
                <th>Contract</th>
                <th colspan="2">Actions</th>
            </tr>

            <tr class="filterBG">
                <form action="/Commission_PlanFilter">
                    <td><input type="text" name="totalCom"></td>
                    <td><input type="text" name="YunCom"></td>

                    <!-- Broker Dropdown Start -->
                    <td>
                        <select name="broker">
                            <option value=""/>
                            <c:forEach var="itema" items="${brokerRepo.findAll()}">
                                <option value="${itema.getBroker_ID()}">
                                    ${itema.getBroker_Name()}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <!-- Broker Dropdown End -->

                    <td><input type="text" name="brokerCom"></td>
                          <td>
                             <select name="contract">
                                 <option value=""/>
                                 <c:forEach var="itemb" items="${contractRepo.findAll()}">
                                     <option value="${itemb.getContract_ID()}">
                                         ${propertyRepo.findById(itemb.getProperty_ID()).get().getStreet_Address()}
                                          for ${clientRepo.findById(itemb.getClient_ID()).get().getClient_First_Name()}
                                          ${clientRepo.findById(itemb.getClient_ID()).get().getClient_Last_Name()}
                                     </option>
                                 </c:forEach>
                             <select>
                         </td>

                    <td><button class="btn"><i class="fa fa-search" style="color:white;"></i></button></td>
                </form>

                <td>
                <form action="/Commission_PlanRedirect">
                    <button>New</button>
                </form>
                </td>

            </tr>

            <c:forEach var="item" items="${commission_planList}">
                <tr id="tableData">
                    <td>$${item.getTotal_Commission()}0</td>
                    <td>${item.getYun_Global_Commission_Percent()}</td>
                    <td>${brokerRepo.findById(item.getBroker_ID()).get().getBroker_Name()}</td>
                    <td>${item.getBroker_Commission_Percent()}</td>
                    <td>${propertyRepo.findById(contractRepo.findById(item.getContract_ID()).get().getProperty_ID()).get().getStreet_Address()}
                    for ${clientRepo.findById(contractRepo.findById(item.getContract_ID()).get().getClient_ID()).get().getClient_First_Name()}
                    ${clientRepo.findById(contractRepo.findById(item.getContract_ID()).get().getClient_ID()).get().getClient_Last_Name()}



                    <td>
                        <form action="/Commission_PlanEdit/${item.getCommission_Plan_ID()}">
                            <button type="submit" value="Edit">
                                <i class="fas fa-edit"></i>
                            </button>
                        </form>
                    </td>
                    <td>
                        <form action="/Commission_PlanDelete/${item.getCommission_Plan_ID()}">
                            <button type="submit" value="Delete">
                                <i class="fas fa-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>