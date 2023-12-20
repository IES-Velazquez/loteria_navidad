window.onload = function () {
    console.log("onload");
    var results = document.getElementById("results");

    fetch('loteriaAPI')
        .then(response => {
            if (!response.ok) {
                console.error("HTTP error " + response.status);
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            data = JSON.parse(data);
            var table = document.createElement("table");
            var thead = document.createElement("thead");
            var tbody = document.createElement("tbody");
            var tr = document.createElement("tr");
            var th = document.createElement("th");
            th.textContent = "Numero";
            tr.appendChild(th);
            th = document.createElement("th");
            th.textContent = "Premio";
            tr.appendChild(th);
            thead.appendChild(tr);
            table.appendChild(thead);
            tr = document.createElement("tr");
            var td = document.createElement("td");
            console.log(data.numero);
            td.textContent = data.numero;
            tr.appendChild(td);
            td = document.createElement("td");
            console.log(data.premio);
            td.textContent = data.premio;
            tr.appendChild(td);
            tbody.appendChild(tr);
            table.appendChild(tbody);
            results.appendChild(table);
        })
        .catch(function () {
            results.textContent = "Error al cargar los datos";
        });
}