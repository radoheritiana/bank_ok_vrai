<%@ page import="com.bankok.bean.Client" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    Client client = new Client();
    if(request.getAttribute("client") != null){
        client = (Client) request.getAttribute("client");
    }
%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/res/style.css">
    <title>Bank_ok | <%= client.getNom() %></title>
</head>

<body>
    <header>
        <div class="logo">
            <label for="">Bank_<span>ok</span></label>
        </div>
        <div class="user-compte">
            <label></label>
            <label></label>
        </div>
    </header>

    <div class="main">
        <div class="list-transaction">
            <div class="transaction-item">
                <div class="user-info">
                    <label><%= client.getNom() %></label>
                    <label><%= client.getPrenom() %></label>
                </div>
                <div class="info-transaction">
                    <label>Addresse <span><%= client.getAdresse() %></span></label>
                    <label>Numero de telephone<span><%= client.getTelephone() %></span></label>
                    <label>CIN<span><%= client.getNumero_cin() %></span></label>
                </div>
                <div class="montant">
                    <label>est verifié : <%= client.isEst_verifie() %></label>
                    <label>Id charger clientele : <%=client.getId_charger_clientele() %></label>
                </div>

                <div class="btn-approuver">
                    <form method="post" action="<%=request.getContextPath()%>/index.php">
                        <input type="hidden" name="id_client" value="<%= client.getId_client() %>"/>
                        <button type="submit" class="aprouver">Approuver</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>