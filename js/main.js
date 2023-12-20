function comprobarBoleto(){
    var faltaDato = document.createElement("p");
    let texto = document.createElement;
    let numBoleto = document.getElementById("inputComprobar").value;
    let divComprobar = document.getElementById("comprobacionNumero");


    if(numBoleto == ""){
        texto = "Este campo no puede estar vacío";
        faltaDato.appendChild(texto);
    } else if(numBoleto.length<5){
        texto = "El numero no esta completo";
        faltaDato.appendChild(texto)
    }

    divComprobar.appendChild(faltaDato);
    
}

function validarNumeros(evt){
    var code = evt.keyCode;
    
     if((code>=48 && code<=57)&& document.getElementById("inputComprobar").value.length<5) {
      return true;
    } else{
      return false;
    }
}

function confirmar(){
    
}


window.onload = function(){
    document.getElementById("btComprobar").addEventListener("click",comprobarBoleto);



    document.getElementById("btConfirmar").onclick = confirmar;
    document.getElementById("inputComprobar").onclick = () => {
        validarNumeros();
    }
}