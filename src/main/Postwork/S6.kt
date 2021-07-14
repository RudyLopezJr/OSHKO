package Postwork

//SESIÓN 6 "GETTERS Y SETTERS"

/*
class Product(var name1: String,  var price: Float , discount: Float) {

    */
/*
    init {
        println("El producto $name1 tiene un precio de: $price")
    }
     *//*


    var discount = discount
        set(value) {
            println("Digite el nuevo descuento en decimales: ")
            val aux = readLine()?.toFloat()!!
            field = aux
        }
    var discountInString : String = ""
        get() = "${(discount * 100).toInt()}%"


    val finalPrice
        get() = price - discount * price

}*/
