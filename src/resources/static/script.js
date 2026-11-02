
const btnNuevo = document.getElementById("btn-nuevo");
const panel = document.getElementById("panel-registro");

// Obtener los campos del formulario
const campos = panel.querySelectorAll("input");

btnNuevo.addEventListener("click", () => {

    panel.hidden = !panel.hidden;

    if (panel.hidden) {

        // Limpiar los campos al cerrar
        campos.forEach(campo => {
            campo.value = "";
        });

        btnNuevo.textContent = "Nuevo alumno";

    } else {

        btnNuevo.textContent = "Cerrar formulario";

    }

});
