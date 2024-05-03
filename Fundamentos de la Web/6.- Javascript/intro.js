var num = 1;
let texto = "Este es un texto"; //Solo existe en el bloque en el que se declara
const password = "NoVaACambiar"; //No puede ser alterada
var decimal = 1.11;
var bool = true; //true o false

console.log("¡Hola mundo!");
console.log(texto); //Imprime: "Este es un texto"

var despues; //por defecto si no tiene valor va a ser undefined
console.log(despues);
despues = "Texto colocado después";
console.log(despues);

var num1 = 1;
var num2 = 2;
var suma = num1 + num2; //1 + 2 = 3

var nombre = "Elena de Troya";"texto" 
var mensaje = "Mi nombre es:";
console.log(mensaje+nombre); //"Mi nombre es:Elena de Troya"

var otro_nombre = "Juana de Arco";
var edad = 18;
var otro_mensaje = "Mi nombre es: "+otro_nombre+" ¿cómo estás? Tengo "+edad+" años"; //Concatenación
var tercer_mensaje = `Mi nombre es: ${otro_nombre} ¿cómo estás? Tengo ${edad} años`; //Interpolación
console.log(otro_mensaje);
console.log(tercer_mensaje);

var apodo = "Chuy";
var texto_saludar = " ¡Hola! A mi me dicen '"+apodo+"' ";
var texto_saludar2 = ` ¡Hola A mi me dicen '${apodo}' `;

//camelCase PascalCase

var combinamosTexto = "ABC";
console.log(combinamosTexto + num1); //ABC1
console.log(combinamosTexto + num1 + num2); //ABC12
console.log(num1 + num2 + combinamosTexto); //3ABC
console.log(combinamosTexto + (num1 + num2)); //ABC3

var orden = 10 + 20 / 6;
console.log(orden); // 1.- (), 2.- /*%, 3.- -+

var n = 14;
n -= 4; //n = n - 4; + - * / %

var nombre_completo = "Pablo";
nombre_completo += " Picasso";
console.log(nombre_completo);