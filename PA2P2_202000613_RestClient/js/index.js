
function cargarDatos() {
    let contador=0
    const LIMITE_POKEMON_BLOQUE=4
    let bloqueContenedor=document.createElement("div")
    bloqueContenedor.classList.add("bloque")

    fetch('https://pokeapi.co/api/v2/pokemon?limit=100')
        .then(function (response) {
            return response.json();
        })
        .then(function (listaPokemones) {
            listaPokemones.results.forEach(
                function (pokemon) {
                    if (contador==LIMITE_POKEMON_BLOQUE) {
                        bloqueContenedor=document.createElement("div")
                        bloqueContenedor.classList.add("bloque")
                        contador=0;
                    }
                    CargarDetalle(pokemon,bloqueContenedor);
                    contador++
                }
            );
        });
}

function CargarDetalle(pokemon,bloqueContenedor){
    fetch(pokemon.url)
    .then(response=>response.json())
    .then(function (pokemonDetalle) {
        let contenedorPrincipal=document.getElementById("contenidoPrincipal")
        
        bloqueContenedor.append(crearTarjeta(pokemonDetalle))
        contenedorPrincipal.appendChild(bloqueContenedor)
    });
}

function crearTarjeta(pokemon){
    let tarjeta=document.createElement("div")
    tarjeta.classList.add("tarjeta-pokemon")

    let imagenPokemon=document.createElement("img")
    imagenPokemon.srcset="https://pokeres.bastionbot.org/images/pokemon/"+pokemon.id+".png"
    imagenPokemon.style.cssText="width:100%;"

    let titulo=document.createElement("h2")
    titulo.innerText=pokemon.id+".- "+pokemon.name

    let subTituloMovimientos=document.createElement("h3")
    subTituloMovimientos.innerText="Movimientos"

    let listaMovimeintos=document.createElement("ul")
    pokemon.moves.forEach(
        function(movimiento){
            let elementoLista=document.createElement("li")
            elementoLista.innerText=movimiento['move']['name']
            listaMovimeintos.append(elementoLista)
        }
    )
    cargarEvoluciones(pokemon)
    tarjeta.append(imagenPokemon,titulo,subTituloMovimientos,listaMovimeintos)

    //tarjeta.addEventListener("click",hacerSonido)
    tarjeta.addEventListener("mouseout",hacerSonido)
    return tarjeta;
    
}

function cargarEvoluciones(pokemon){
    let url="https://pokeapi.co/api/v2/evolution-chain/"+pokemon.id+"/"

    fetch(url)
    .then(response=>response.json())
    .then(function (evolucionDetalle) {
        let evolucion1=evolucionDetalle.chain.evolves_to[0].species.name
        let evolucion2=evolucionDetalle.chain.evolves_to[0].evolves_to[0].species.name
        console.log(pokemon.name+": "+evolucion1+","+evolucion2)
    });
}

//Inicializa la carga
cargarDatos();



function hacerSonido(){
    var sonido=new Audio("recursos/notificacion.mp3")
    sonido.play()
}