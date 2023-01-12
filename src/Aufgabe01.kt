fun main() {
    var drache: MutableMap<String, Any> = mutableMapOf(
        "Id" to 1,
        "Angriff" to 50,
        "Verteidigung" to 0.35, //Je niedriger dieser Wert desto größer die Verteidigungskraft
        "HP" to 250.0
    )

    var held: MutableMap<String, Any> = mutableMapOf(
        "Id" to 2,
        "Angriff" to 40,
        "Verteidigung" to 0.2, //Je niedriger dieser Wert desto größer die Verteidigungskraft
        "HP" to 100.0
    )

    while(drache.get("HP").toString().toDouble() > 0.0 && held.get("HP").toString().toDouble() > 0.0){
        if((0..1).random() == 0){
           angriff(drache, held)
        }else{
            angriff(held, drache)
            angriff(held, drache)
        }
    }

    println("\nDas Spiel ist zu Ende!")

    if(drache.get("HP").toString().toDouble() <= 0.0){
        println("Gewonnen hat der Held")
    }else if(held.get("HP").toString().toDouble() <= 0.0){
        println("Gewonnen hat der Drache")
    }

    println("\nDrache-HP: ${drache.get("HP")}")
    println("Held-HP: ${held.get("HP")}")
}

fun angriff(angreifer: MutableMap<String, Any>, opfer: MutableMap<String, Any>){
    var effekt: List<Double> = listOf(1.0, 1.5)

    if(angreifer.get("Id") == 1){
        println("Angreifer: Drache")
        println("HP-Held: ${opfer.get("HP")}")
        var angriffswert: Double = (angreifer.get("Angriff").toString().toInt() * opfer.get("Verteidigung").toString().toDouble())
        println("Angriffswert Drache: $angriffswert")
        opfer.set("HP", opfer.get("HP").toString().toDouble() - angriffswert.toDouble())
        println("Der Held hat einen Schaden von $angriffswert erhalten")
        println("Sein neuer HP: ${opfer.get("HP")}")
        println()
    }else if(angreifer.get("Id") == 2){
        println("Angreifer: Held")
        println("HP-Held: ${opfer.get("HP")}")
        var angriffswert: Double = (angreifer.get("Angriff").toString().toInt() * opfer.get("Verteidigung").toString().toDouble()) * effekt.random()
        println("Angriffswert Held: $angriffswert")
        opfer.set("HP", opfer.get("HP").toString().toDouble() - angriffswert.toDouble())
        println("Der Drache hat einen Schaden von $angriffswert erhalten")
        println("Sein neuer HP: ${opfer.get("HP")}")
        println()
    }
}

