package Postwork

// SESIÓN 2 "COLECCIONES, FUNCIONES, BUCLES Y CONDICIONALES"
//En este documento vemos las funciones, bucles y condicionales de nuestro proyecto

//1.FUNCIONES

/*fun imprimirNombre(){
    println("El nombre es: $name1")
}

fun imprimirNombre(){
    println("El usuario es: $username")
}*/


//2.BUCLES

/*fun printLine(largeOfLine: Int){
    for(i in 1..largeOfLine){
        print("-")
    }
    println()
}

fun printProducts( myProducts: MutableList<Product>) {
    val lineOfTable = arrayListOf("Numero", "Nombre", "Precio Inicial" )
    printLinesOfTable(lineOfTable)

    val amountOfElements = lineOfTable.size
    printLine(amountOfElements*lengthOfMaxElement + amountOfElements)

    var counter = 1
    for(product in myProducts){
        arrayListOf(counter.toString(), product.name1, "${product.price}").apply {
            printLinesOfTable(this)
        }
        counter += 1
    }
}

fun getPrice(myProducts: MutableList<Product>) : Float {
    var acum = 0f
    for(product in myProducts){
        acum += product.price
    }
    return acum
}*/


// 3.CONDICIONALES

/*do{

    checker = false

    //Se llama a la función printMenu, que muestra las opciones del arrayList
    val menu1 =  arrayListOf("Iniciar sesión", "Registrarse", "Salir")
    aux = printMenu(menu1)

    when(aux) {
        1 -> {
            print("Escribe tu usuario: ")
            auxUser = readLine().toString()

            print("Contraseña: ")
            auxContrasenia = readLine().toString()

            checker = login(auxUser,auxContrasenia, myUsers )
        }
        2 -> {
            myUsers += registerUser()
        }
        else -> return
    }

} while(!checker)

do{
    checker = false

    val menu1 =  arrayListOf("Mostrar productos", "Ir al carrito ", "Salir")
    aux = printMenu(menu1)

    when(aux) {
        1 -> {
            printProducts(myProducts)
            checker2 = false

            println("A continuación seleccione los productos que desee agregar al carrito")
            println("Presione 0 para salir")
            do{
                aux2 = readLine()?.toInt()!!
                when(aux2){
                    0 -> checker2 = true
                    else -> {
                        myWallet += myProducts[aux2-1]
                        println("Se ha agregado el producto $aux2 con exito")
                    }
                }

            } while(!checker2)
        }
        2 -> {
            checker2 = false
            do{
                val menu2 =  arrayListOf("Proceder a la compra", "Mostrar productos ", "Eliminar productos", "Salir")
                aux2 = printMenu(menu2)

                when(aux2){
                    1 -> {
                        println("Se ha hecho el pago con exito :D ")
                        checker2 = true
                    }
                    2 -> {
                        println("Sus productos son: ")
                        printProducts(myWallet)
                        acum1 = getPrice(myWallet)
                        println("Precio acumulado: $acum1")

                    }

                    3 -> {
                        println("Sus productos son: ")
                        printProducts(myWallet)
                        acum1 = getPrice(myWallet)
                        println("Precio acumulado: $acum1")

                        print("Digite el número del producto a eliminar: ")
                        aux3 = readLine()?.toInt()!!

                        myWallet.removeAt(aux3 - 1)
                        println("Se ha eliminado el producto $aux3")

                    }
                    else -> {
                        checker2 = true
                    }
                }

            }while(!checker2)
        }
        else -> return
    }

} while(!checker)


}*/
