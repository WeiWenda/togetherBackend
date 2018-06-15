<%--
  Created by IntelliJ IDEA.
  User: weiwenda
  Date: 2018/6/15
  Time: 下午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>socket</title>
    <script type="text/javascript" src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
welcome<br />
<input id="text" type="text"/>
<button onclick="sendMsg()">sendMsg</button>
<hr/>
<button onclick="closeWebSocket()">close WebSocketconnection</button>
<hr/>
<div id="message"></div>
</body>

<script type="text/javascript">
    var websocket = null;
    //判断浏览器是否支持websocket
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/together//hello");
    }else{
        $("#message").html("该浏览器不支持实时通信功能");
    }

    websocket.onopen= function() {
        console.log("websocket连接成功");
    }

    websocket.onclose= function() {
        console.log("websocket连接关闭");
    }

    websocket.onmessage= function(event) {
        console.log("接收消息");
        console.log(event);
        printMsg(event.data);
    }

    //打印消息
    function printMsg(msg) {
        $("#message").append(msg+ "<br/>");
    }

    function sendMsg() {
        var msg = $("#text").val();
        websocket.send(msg);
    }

    function closeWebSocket(){
        websocket.close();
    }
</script>
</html>