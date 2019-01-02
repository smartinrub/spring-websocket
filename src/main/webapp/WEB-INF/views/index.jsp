<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello World</title>
    <script type="text/javascript">
        var url = 'ws://' + window.location.host + '/spring_websocket_war/socketHandler';
        var webSocket = new WebSocket(url);

        webSocket.onopen = function () {
            console.log('WebSocket OPEN');
            sayHello();
        };

        webSocket.onmessage = function (messageEvent) {
            var wsMsg = messageEvent.data;
            console.log("Received message: " + wsMsg);
            if (wsMsg.indexOf("error") > 0) {
                document.getElementById("incomingMsgOutput").value += "error: " + wsMsg.error + "\r\n";
            } else {
                document.getElementById("incomingMsgOutput").value += "message: " + wsMsg + "\r\n";
            }
        };

        webSocket.onclose = function () {
            console.log('WebSocket CLOSE');
        };

        function sayHello(message) {
            console.log('Sending Message!');
            webSocket.send(message);
        }

        function onSubmit() {
            var msg = document.getElementById("message").value;
            sayHello(msg);
        }

    </script>
</head>
<body>
<h1>WebSocket Client</h1>
<table>
    <tr>
        <td width="200px">Say Hello</td>
        <td><label for="message">Message</label>
            <input type="text" id="message"/></td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input id="submit" type="button" value="Send Message" onclick="onSubmit()">
        </td>
    </tr>
</table>
<br/>
<label for="incomingMsgOutput">Response</label>
<textarea id="incomingMsgOutput" rows="10" cols="20" disabled="disabled"></textarea>
</body>
</html>
