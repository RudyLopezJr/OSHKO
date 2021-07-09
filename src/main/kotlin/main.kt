const val lengthOfMaxElement = 15

fun main(){

    val fresa = Product("Fresa", 48.0f)
    val manzanas = Product("Manzanas", 32.0f)

    val pesa = Product("pesa", 240.0f)
    val balon = Product("balon", 132.0f)

    val pc= Product("pc", 16000.0f)
    val mouse=Product("mouse", 120.0f)

    val shampoo= Product("shampoo", 48.0f)
    val bloqueador= Product("bloqueador", 52.0f)

    val myProducts: MutableList<Product> = mutableListOf(fresa, manzanas, pesa, balon, pc, mouse, shampoo, bloqueador)
    val myWallet:  MutableList<Product> = mutableListOf()

    val lola18 = User("Lola18"," lolainthesky@gmail.com", "lolita18" )
    val marioRamirez = User("Mario Ramírez"," m.ramirez12@hotmail.com", "1010mramram" )
    val claudiaV = User("Claudia V"," clau_valdez@gmail.com", "spike1123" )
    val miguelAngel = User("Miguel Angel"," miguelitochamoy@gmail.com", "mikemiguelmigu3lo" )
    val lazyCat = User("a"," sussiegomezm@hotmail.com", "a" )

    val myUsers: MutableList<User> = mutableListOf(lola18, marioRamirez, claudiaV, miguelAngel, lazyCat)


    var checker : Boolean
    var aux: Int

    var auxUser: String
    var auxContrasenia: String

    var checker2: Boolean
    var aux2: Int

    var acum1: Float
    var aux3: Int



    do{

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


}

fun registerUser(): User {

    print("Escriba su usuario: ")
    val auxUsername: String = readLine().toString()
    print("Escriba su correo: ")
    val auxEmail: String = readLine().toString()

    print("Escriba su contraseña: ")
    val auxPassword: String = readLine().toString()

    return User(auxUsername, auxEmail, auxPassword)
}

fun registerProduct(): Product {

    print("Escriba el nombre del producto: ")
    val auxName: String = readLine().toString()
    print("Escriba el precio del producto: ")
    val auxPrice: Float = readLine()?.toFloat()!!

    return Product(auxName, auxPrice)
}

fun login(user1: String, pass:String, userList: MutableList<User>): Boolean{

    for(auxUser in userList){
        if( (user1 == auxUser.username || user1 == auxUser.email) && pass == auxUser.password){
            println("Inicio de sesión exitoso")
            return true
        }
    }

    println("email o contraseña incorrecto")
    return false

}

fun printMenu(names: ArrayList<String>) : Int {
    val n = names.size
    for(i in 1..n){
        println("${i}. ${names[i-1]}")
    }
    print("Digite su opcion: ")

    val aux = readLine()?.toInt()!!

    return aux
}

fun printLinesOfTable(names: ArrayList<String>){

    val n = names.size
    var aux1: Int
    var aux2: Int

    var spaces : String? = ""
    var spaces2 : String? = ""

    for(i in 0 until n){
        val n2 = names[i].length
        if(n2 <= lengthOfMaxElement){
            aux1 = lengthOfMaxElement - n2

            aux2 = aux1 / 2
            spaces = ""
            for(j in 1..aux2){
                spaces += " "
            }
            aux2 = aux1 - aux2

            spaces2 = ""
            for(j in 1..aux2){
                spaces2 += " "
            }
        }
        val finalWord : String = spaces + names[i] + spaces2 + "|"
        print(finalWord)
    }
    println()
}

fun printLine(largeOfLine: Int){
    for(i in 1..largeOfLine){
        print("-")
    }
    println()
}

fun printProducts( myProducts: MutableList<Product>) {
    val lineOfTable = arrayListOf("Numero", "Nombre", "Precio Inicial", "Descuento" )
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
}
