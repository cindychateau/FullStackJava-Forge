const API_KEY = "9d6694e3855549bdb32d90553e1d56eb";

async function buscarNoticias() {
    //https://newsapi.org/v2/everything?q=gato&apiKey=API_KEY

    let termino = document.querySelector('#termino').value; //Valor que usuario ingresó

    let response = await fetch(`https://newsapi.org/v2/everything?q=${termino}&apiKey=${API_KEY}`);

    let data = await response.json();

    console.log(data);


}