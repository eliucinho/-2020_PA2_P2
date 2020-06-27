        //alert("hola mundo") 
        /*
            Comentarios largos
        */
        //alert("hola")
        console.log("hola desde la consola")

        var mensaje="hola mundo" //Al definirlo el lo detecta como un string
        
        //alert(mensaje)

        mensaje='hola con comimllas simples' //tambien es string

        //alert(mensaje)

        mensaje='hola con "doble comilla" '

        //alert(mensaje)

        mensaje="hola con 'doble comilla' "

        //alert(mensaje)

        var a=5
        var b=6
        mensaje=a+b      

        //alert(mensaje)  //11

        const SALUDO_DEFAULT ='Buen dia!! '

        mensaje=a+b+SALUDO_DEFAULT

        //alert(mensaje)  //11Buen dia!!

        var c='4'

        mensaje=a+b+c

        //alert(mensaje) 

        mensaje=c+a+b

        //alert(mensaje)  

        mensaje=c+(a+b)

        //alert(mensaje) 

        mensaje=c+(parseInt(a)+parseInt(b))

        //alert(mensaje) // 411

        //Es un procedimiento por que no tiene un return
        function saludar(){
            alert("hola desde la funcion")
        }

        //saludar()

        function saludar2(mensajeParametro){
            alert(mensajeParametro)
        }

        //saludar2("hola desde la funcion con el parametro")

        function getSuma(p1,p2){
            return p1+p2;
            //return parseInt(p1)+parseInt(p2); //De esta manera siempre me hace el calculo
        }

        //saludar2(getSuma(10,20)) //30

        //saludar2(getSuma('10','20')) //1020

        //saludar2(getSuma(10,'20')) //1020

        function calcularFormularioSuma(){
            var a=document.getElementById("a").value;
            var b=document.getElementById("b").value;
            
            var resultado=parseInt(a)+parseInt(b)
            //alert(parseInt(a)+parseInt(b))

            document.getElementById("resultado").value=resultado;
        }

        function getResultadoAAndB(){
            var a=document.getElementById("a").value;
            var b=document.getElementById("b").value;
            
            return parseInt(a)+parseInt(b)
        }

        var arregloString=['a','b','c']

        //alert(arregloString[2])

        for (let index = 0; index < arregloString.length; index++) {
            console.log
            (arregloString[index]);
        }

        console.log('forma de recorrer el arreglo')

        arregloString.forEach(imprimirEtiquetas);

        function imprimirEtiquetas(valor){
            console.log('hola desde el forEach '+valor)
        }

        var i=0;
        while (i<arregloString.length) {
            console.log('hola desde el while '+arregloString[i])
            i++

            
            let variableAlcanceCorto="hola let"; 
            var variableAlcanceLargo="hola var";

            //alert("se definieron las variables")
        }

        function validadorFormualario(){
            let a=document.forms["formularioCalculos"]["a"].value

            if (a=="") {
                document.getElementById("mensajesError").innerHTML="el valor de a es requerido";
                return false
            }else{
                document.getElementById("mensajesExito").innerHTML="todo bien con a";
            }

        }
        //alert(variableAlcanceCorto)
        //alert(variableAlcanceLargo)

        function cambiarImagenCarita(){
            let caritas=["amor.png","comida.png","pensante.png","risa.png","sonriente.png"]
            let indexRamdon=Math.floor(Math.random()*caritas.length) // lenght 5 -> el rando es de 0 a 4

            document.getElementById("imagenCarita").src="../imagenes/"+caritas[indexRamdon]
        }

        function inyectarImagen(){
            document.getElementById("portalInyeccion").innerHTML='<img src="../imagenes/UTHFondo.jpeg" style="height: 100px;" >'

        }

        let varianbleMuchosTipos=4
        console.log('muchos tipos '+varianbleMuchosTipos)
        varianbleMuchosTipos='hola'
        console.log('muchos tipos '+varianbleMuchosTipos)