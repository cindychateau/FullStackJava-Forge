/* PROMESA  */
function muestraPerrito(){
    fetch("https://dog.ceo/api/breeds/image/random")
        .then(response => response.json())
        .then(data => {
            /*
            data = {
                "message": "url/img.jpg",
                "status": "success"
            };
            */

            //data.message = data["message"]
            var imagen_perrito = `<img alt="perrito" src="${data.message}" >`;

            document.querySelector('.imagen-perro').innerHTML = imagen_perrito;

            console.log(data);
        })
}

/* ASYNC/AWAIT */
async function muestraPerritoAsync() {
    var response = await fetch("https://dog.ceo/api/breeds/image/random");
    var data = await response.json();
    var imagen_perrito = `<img alt="perrito" src="${data.message}" >`;
    document.querySelector('.imagen-perro').innerHTML = imagen_perrito;
}