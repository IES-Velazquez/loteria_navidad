//Administracion
var url = "http://localhost:8081/loteria_navidad_war/rest/json/users_list";
const options = {
    method: "get",
};
pFetch(url, options, muestraDatos);

const pFetch = (url, options, callback = null) => {
    options.method = options.method.toUpperCase()
    fetch(url, options)
        .then(response => response.json())
        .then(data => callback(data))
}

const muestraDatos = (datos) => {
    var tbody = document.getElementById("cuerpoUsuarios");
    var tr, td, texto, a;

    tbody.innerHTML = "";

    var arrayOrdenado = [];
    datos.forEach(element => {
        var objeto = new Object({
            usuario: element.USUARIO,
            nombre: element.NOMBRE,
            borrar: ""
        });
        arrayOrdenado.push(objeto);
    });

    var fila;
    arrayOrdenado.forEach(element => {
        fila = crearFila(element);
        tbody.appendChild(fila);
    });
}
function crearFila(obj) {
    var fila = document.createElement("tr")
    var col; var cont;
    for (var valor in obj) {

        col = document.createElement("td");
        cont = obj[valor];
        if (valor == "usuario") {
            var detail = document.createElement("details");
            var summary = document.createElement("summary");
            summary.className = "nameUser";
            summary.textContent = "Información del usuario";
            var div = document.createElement("div");




            col.appendChild(document.createTextNode(cont));
        } else if (valor == "borrar") {
            var boton = document.createElement("button");
            boton.textContent = "Borrar";

            boton.dataset.usuario = obj.usuario;
            boton.addEventListener("click", function (e) {
                //borrarPersona(e);
            });
            col.appendChild(boton);
        }
        fila.appendChild(col);
    }
    return fila;
}





















function comprobarBoleto() {
    var faltaDato = document.createElement("p");
    let nodoTexto;
    let numBoleto = document.getElementById("inputComprobar").value;
    let divComprobar = document.getElementById("comprobacionNumero");


    if (numBoleto == "") {
        faltaDato.textContent = "Este campo no puede estar vacío";
    } else if (numBoleto.length < 5) {
        faltaDato.textContent = "El numero no esta completo";
    }

    divComprobar.appendChild(faltaDato);

}

function validarNumeros(evt) {
    var code = evt.keyCode;

    if ((code >= 48 && code <= 57) && document.getElementById("inputComprobar").value.length < 5) {
        return true;
    } else {
        return false;
    }
}

function confirmar() {

}


window.onload = function () {
    document.getElementById("btComprobar").addEventListener("click", comprobarBoleto);



    document.getElementById("btConfirmar").onclick = confirmar;
    document.getElementById("inputComprobar").onclick = () => {
        validarNumeros();
    }
}