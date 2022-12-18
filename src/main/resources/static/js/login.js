// Call the dataTables jQuery plugin
$(document).ready(function () {

});


async function login() {
    let datos = {};
    datos.email = document.getElementById("Email").value;
    datos.password = document.getElementById("Password").value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const response = await request.text();
    if (response === "true") {
        window.location.href = "/users.html";
    }else {
        alert("Usuario o contraseña incorrectos");
    }



}

