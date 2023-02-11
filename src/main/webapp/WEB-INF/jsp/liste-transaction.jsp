<%@ page import="com.bankok.bean.Client" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.bankok.bean.TransactionBancaire" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    Client client = new Client();
    if(request.getAttribute("client") != null) {
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
            <label><%= client.getNom() %></label>
            <label><%= client.getPrenom() %></label>
        </div>
    </header>

    <div class="main">
        <div class="list-transaction">
            <%
                if(request.getAttribute("transaction") != null) {
                    TransactionBancaire transactionBancaire = (TransactionBancaire) request.getAttribute("transaction");
                    Iterator<TransactionBancaire> iterator = transactionBancaire.getTransactionBancaires().iterator();

                    if(!iterator.hasNext()){
            %>
            <div>
                <h3>Pas de transaction</h3>
            </div>
            <%
                    }

                    while (iterator.hasNext()){
                        TransactionBancaire tb = iterator.next();
            %>
            <div class="transaction-item">
                <div class="user-info">
                    <label><%= client.getNom() %></label>
                    <label><%= client.getPrenom() %></label>
                </div>
                <div class="info-transaction">
                    <label>Compte de depart :<span><%= tb.getNumCompteDepart()%></span></label>
                    <label>Compte d'arriver :<span><%= tb.getNumCompteArrive()%></span></label>
                </div>
                <div class="montant">
                    <label>Montant :</label>
                    <label> <%= tb.getMontant()%></label>
                </div>
                <label class="date">Date: <%= tb.getDateTransaction()%></label>
                <label class="type-transaction">Type de transaction: <%= tb.getType()%></label>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>

</body>

</html>