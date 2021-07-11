import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

const val lengthOfMaxElement = 15

suspend fun main(){

    //Se registran los productos
    val fresa = Product("Fresa", 48.0f, 0.0f)
    val manzanas = Product("Manzanas", 32.0f, 0.1f)

    val pesa = Product("pesa", 240.0f, 0.2f)
    val balon = Product("balon", 132.0f, 0.0f)

    val pc= Product("pc", 16000.0f, 0.3f)
    val mouse=Product("mouse", 120.0f, 0.4f)

    val shampoo= Product("shampoo", 48.0f, 0.6f)
    val bloqueador= Product("bloqueador", 52.0f, 0.0f)

    val myProducts: MutableList<Product> = mutableListOf(fresa, manzanas, pesa, balon, pc, mouse, shampoo, bloqueador)
    val myWallet:  MutableList<Product> = mutableListOf()

    val lola18 = User("Lola18"," lolainthesky@gmail.com", null,  "lolita18" )
    val marioRamirez = User("Mario Ramírez"," m.ramirez12@hotmail.com", null,  "1010mramram" )
    val claudiaV = User("Claudia V"," clau_valdez@gmail.com", null, "spike1123" )
    val miguelAngel = User("Miguel Angel"," miguelitochamoy@gmail.com","5511223344", "mikemiguelmigu3lo" )
    val lazyCat = User("a"," sussiegomezm@hotmail.com","5512345678", "a" )

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
                auxUser = readOptionString("Escribe tu usuario: ")

                auxContrasenia = readOptionString("Contraseña: ")

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
                    aux2 = readOptionIntMenu("Digite el número del producto: ", myProducts.size)
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
                            terminatingProcess("Se está haciendo el pago", "La compra se ha realizado con éxito :D")
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


                            aux3 = readOptionIntMenu("Digite el número del producto a eliminar: ", myWallet.size)

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

suspend fun registerUser(): User {

    val auxUsername: String = readOptionString("Escriba su usuario: ")

    val auxEmail: String = readOptionString("Escriba su correo: ")

    val auxPassword: String = readOptionString("Escriba su contraseña: ")


    terminatingProcess("Se está registrando el usuario", "El usuario se ha registrado con éxito :D")

    print("Escriba su celular: ")
    val auxCel: String = readLine().toString()

    return User(auxUsername, auxEmail, auxCel, auxPassword)
}

suspend fun registerProduct(): Product {

    val auxName: String = readOptionString("Escriba el nombre del producto: ")

    val auxPrice: Float = readOptionFloatMenu("Escriba el precio del producto: ")

    val auxDiscount: Float = readOptionFloatMenu("Escriba el descuento del del producto: ")

    terminatingProcess("Se está registrando el producto ", "El producto se ha registrado con éxito")

    return Product(auxName, auxPrice, auxDiscount)
}

suspend fun login(user1: String, pass:String, userList: MutableList<User>): Boolean{

    for(auxUser in userList){
        if( (user1 == auxUser.username || user1 == auxUser.email) && pass == auxUser.password){
            terminatingProcess("Iniciando sesión", "Sesión iniciada con exito")
            return true
        }
    }

    println("email o contraseña incorrecto")
    return false

}

fun printMenu(names: ArrayList<String>): Int {
    val n = names.size
    for (i in 1..n) {
        println("${i}. ${names[i - 1]}")
    }

    return readOptionIntMenu("Digite su opción: ", n)
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
    val lineOfTable = arrayListOf("Numero", "Nombre", "Precio Inicial" , "Descuento" , "Precio Final" )
    printLinesOfTable(lineOfTable)

    val amountOfElements = lineOfTable.size
    printLine(amountOfElements*lengthOfMaxElement + amountOfElements)

    var counter = 1
    for(product in myProducts){
        arrayListOf(counter.toString(), product.name1, "${product.price}", product.discountInString, "${product.finalPrice}").apply {
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


fun readOptionIntMenu( phrase: String, limit: Int) : Int{

    var checker = false
    var aux  = 0


    do{
        print(phrase)
        try{
            readLine()?.toInt()!!.also { aux = it }
            checker = true
        }
        catch (e : NumberFormatException){
            println("Favor de ingresar una opción")
        }
        if(aux > limit){
            println("Ingrese una opción correcta")
            checker = false
        }

    } while(!checker)


    return aux
}

fun readOptionFloatMenu( phrase: String) : Float{

    var checker = false
    var aux  = 0f


    do{
        print(phrase)
        try{
            readLine()?.toFloat()!!.also { aux = it }
            checker = true
        }
        catch (e : NumberFormatException){
            println("Favor de ingresar una opción")
        }

    } while(!checker)


    return aux
}


fun readOptionString(phrase: String): String {

    var checker = false
    var aux = " "
    var aux2: String?

    do{
        print(phrase)
        aux2 = readLine().toString()
        if(aux2 == ""){
            println("Favor de ingresar un valor")
        }
        else{
            aux = aux2
            checker = true
        }
    } while(!checker)


    return aux
}

suspend fun terminatingProcess(phrase: String, phrase2 : String ) = runBlocking{
    println(phrase + "...")
    delay(2_000)
    println(phrase2)
    println("Regresando... ")
    delay(2_000)

}