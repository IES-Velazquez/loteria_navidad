<%--
  Created by IntelliJ IDEA.
  User: josan
  Date: 12/18/23
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
  function AjaxPeticion(url, methType, call, params){
    const cab ={
      method: methType,
        headers: {
            // 'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
      body: JSON.stringify(params)
    }
    fetch(url, cab)
            .then(r=>r.json())
            .then(response=>call(response))
  }


  function llamadaservidorUser(){
    var url = "http://localhost:8081/loteria_navidad_war/rest/json/user_boletos"
    var method = "POST"
    var params = {user: "user"}
    var call = recibeServidor
    AjaxPeticion(url, method, call, params)
  }
  function llamadaservidorBoleto(){
      var url = "http://localhost:8081/loteria_navidad_war/rest/json/boletos_avaliable"
      var method = "POST"
      var params = {bol_num: "234234", position: 0, premio: 0.0}
      var call = recibeServidor
      AjaxPeticion(url, method, call, params)
  }

  function recibeServidor(obj){
    console.log(obj)
  }
  window.onload = ()=>{
     // llamadaservidorUser()
      llamadaservidorBoleto()
  }
</script>
<body>

</body>
</html>
