/*
Función: bloque de código al cual nombrarmos y al que podemos invocar
*/
//function nombre_funcion(parametros1, parametros2...) {}
function saludo() {
    console.log("Hola");
    console.log("¿Cómo estás?");
}

saludo(); //Llamando a la función
saludo();
saludo();
saludo();
saludo();

//nombre = "Juana"
function saludo_nombre(nombre) {
    console.log(`Hola ${nombre}!`);
}

saludo_nombre("Elena");
saludo_nombre("Juana");

//nombre = "Elena". apellido = "De Troya"
function saludo_nombre_apellido(nombre, apellido) {
    console.log(`¡Hola ${nombre} ${apellido}!`); //Imprime
}

saludo_nombre_apellido("Elena", "De Troya");

//num1 = 11. num2 = 20
function sumatoria(num1, num2) {
    console.log("Dentro de función:"+num1); //Imprime
    var suma = num1+num2; //Regresa el valor
    return suma;
}

var resultado = sumatoria(11, 20); //31 RETURN
console.log('El resultado es:'+resultado);

/*Crea un función que reciba dos arreglos del mismo tamaño y regrese un arreglo con sus sumas
EJ:
arr1 = [1, 2, 3, 4]
arr2 = [1, 2, 3, 4]
return [2, 4, 6, 8]
*/
function suma_arreglos(arr1, arr2) {

    return ;
}

var resultado_arreglo = suma_arreglos([1, 2, 3, 4], [1, 2, 3, 4]);
