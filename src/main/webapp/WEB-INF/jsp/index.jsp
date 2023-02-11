<%@ page import="com.bankok.bean.Client" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/res/style.css">
    <title>Bank_ok | Dashboard</title>
</head>

<body>
    <header>
        <div class="logo">
            <label for="logo">Bank_<span id="logo">ok</span></label>
        </div>
    </header>
    <div class="main">
        <div class="header">
            <ul class="menu">
                <li class="demande-compte li li-active">Nouveaux Clients</li>
                <li class="list-compte li " aria-selected="true">Mes clients </li>
            </ul>
        </div>
        <div class="alert">
            <% if(request.getSession().getAttribute("success_message") != null) {
                %>
            <div class="alert-success">
                <%= request.getSession().getAttribute("success_message") %>
            </div>
                <%
            }
            %>
        </div>
        <div class="client-container">
            <%
                if(request.getAttribute("client_not_verified") != null ) {
                    Client my_client = (Client) request.getAttribute("client_not_verified");
                    Iterator<Client> iterator_of_client_charged_by_me = my_client.getClients().iterator();
                    if(!iterator_of_client_charged_by_me.hasNext()){
            %>
            <tr>
                <td colspan="7"><h3 class="text-center">Pas de nouveau client</h3></td>
            </tr>
            <%
                }
                while(iterator_of_client_charged_by_me.hasNext()){
                    Client client = iterator_of_client_charged_by_me.next();
            %>
            <div class="client-item">
                <div class="client-nom">
                    <label> <span>Nom:  <%= client.getNom() %></span></label>
                    <label> <span>Prenoms:  <%= client.getPrenom() %></span></label>
                </div>
                <div class="client-info">
                    <label> <span>Addresse:  <%= client.getAdresse() %></span></label>
                    <label> <span>Email:  <%= client.getEmail() %></span></label>
                </div>
                <a href="<%= request.getContextPath() %>/view_client.php?id_client=<%= client.getId_client() %>"
                   class="aprouver">Voir détails
                </a>
            </div>
            <%
                    }
                }
            %>

        </div>

        <div class="list-client-container contenair-not-active">

            <%
                if(request.getAttribute("my_clients") != null ) {
                    Client client_not_verified = (Client) request.getAttribute("my_clients");
                    Iterator<Client> iterator_of_client_not_verified = client_not_verified.getClients().iterator();
                    if(!iterator_of_client_not_verified.hasNext()){
            %>
                        <tr>
                            <td colspan="7"><h3 class="text-center">Pas de client</h3></td>
                        </tr>
            <%
                    }
                    while(iterator_of_client_not_verified.hasNext()){
                        Client client = iterator_of_client_not_verified.next();
            %>

            <div class="client-list">
                <div class="client-nom">
                    <label> <span>Nom:  <%= client.getNom() %></span></label>
                    <label> <span>Prenoms:  <%= client.getPrenom() %></span></label>
                </div>
                <div class="client-info">
                    <label> <span>Addresse:  <%= client.getAdresse() %></span></label>
                    <label> <span>Email:  <%= client.getEmail() %></span></label>
                </div>
                <a href="<%= request.getContextPath() %>/transaction.php?id_client=<%= client.getId_client() %>" class="aprouver">Transaction</a>
            </div>

            <%
                    }
                }
            %>

        </div>
    </div>

    <script type="text/javascript" src="<%= request.getContextPath() %>/res/main.js"></script>
</body>

</html>