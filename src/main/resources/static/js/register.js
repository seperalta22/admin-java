// Call the dataTables jQuery plugin
$(document).ready(function () {

});


async function registerUser() {
    let datos = {};
        datos.name = document.getElementById("name").value;
        datos.last_name = document.getElementById("lastName").value;
        datos.email = document.getElementById("email").value;
        datos.phone = document.getElementById("phone").value;
        datos.password = document.getElementById("password").value;


    let repeatPassword = document.getElementById("repeatPassword").value;

    if (datos.password !== repeatPassword) {
        alert("Las contraseñas no coinciden");
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
        });

    const response = await request.json();



}

