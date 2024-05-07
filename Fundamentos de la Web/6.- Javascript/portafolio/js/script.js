console.log("¡Entramos a la página!");

function alerta() {
    alert("Hiciste click");
    console.log("Hizo click en el continuar leyendo");
}

function cambia_texto(elemento_h3) {
    /*elemento_h3 = <h3 onclick="cambia_texto(this)" >La Mode</h3> */
    console.log(elemento_h3);
    
    //contiene el texto interno del elemento
    var texto = elemento_h3.innerText;

    if(texto == "Otro Proyecto" ) {
        elemento_h3.innerText = "La Mode";
    } else {
        elemento_h3.innerText = "Otro Proyecto";
    }

    //elemento_h3.innerText = "Otro Proyecto";
}

function cambia_imagen(imagen_original) {
    imagen_original.src = "Portfolio_images/angular.png";
}

function regresa_imagen(imagen_cambiada) {
    imagen_cambiada.src = "Portfolio_images/ajax.png";
}

function eliminar(elemento) {
    elemento.remove();
}

var contador = 0;
function hizo_click(boton)  {
    contador++;
    var mensaje = "";
    if(contador == 1) {
        mensaje = `Haz hecho click: ${contador} vez`;
    } else if(contador > 15) {
        mensaje = `Haz hecho click: ${contador} veces. Los humanos nos entretenemos con tan poco`;
    } else {
        mensaje = `Haz hecho click: ${contador} veces`;
    }

    alert(mensaje);

    // alert(`Haz hecho click: ${contador} veces`); //Interpolación

    // alert("Haz hecho click: "+contador+" veces"); //Concatenación

    //background-color: blue;
    //boton.style.backgroundColor = "red";
    if(contador % 2 == 0) {
        boton.style.backgroundColor = "red";
    } else {
        boton.style.backgroundColor = "green";
    }

}