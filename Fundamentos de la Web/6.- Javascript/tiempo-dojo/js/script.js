function alerta(elemento){
    //elemento = <a href="#" onclick="alerta(this)">Berlin</a>

    alert(`Cargando informe meteorológico...${elemento.innerText}`);
    //"Textto"+variable
    //`Texto ${variable} `

    //document.getElementById('ciudad')
    var elemento_ciudad = document.querySelector('#ciudad');
    elemento_ciudad.innerText = elemento.innerText;

}

function eliminar_cookies() {
    var cookie = document.querySelector('.cookie');

    //cookie.remove();
    cookie.style.display = "none";
    var info = document.querySelector('.info');
    info.style.display = "block";
}