package example

import scala.annotation.tailrec
import scala.util.Random

object GameOfKnights extends App {

  val numberOfKnights = 5
  val initialHealth = 10

  val knights = (1 to numberOfKnights).map(i => Knight(s"Knight_$i")) //Initialize knights

  case class Knight(name: String, health: Int = initialHealth) {
    def attack(): Int = Random.nextInt(6) + 1
    def isDead: Boolean = health <= 0
  }

  @tailrec
  private def fight(knights: Seq[Knight]): Seq[Knight] = {
    if (knights.size == 1) knights //Termination condition
    else {
      val newKnights = knights match {
        case Seq(attacker, defender, tail@_*) => //Pattern match decomposes list to its elements
          val attackPoints = attacker.attack()
          val newDefender = defender.copy(health = defender.health - attackPoints)
          println(s"${attacker.name} deals $attackPoints damage to ${defender.name}")
          if (newDefender.isDead) {
            println(s"${newDefender.name} has died...")
            tail :+ attacker //Defender is removed from the list, the attacker, is moved to the end
          } else (newDefender +: tail) :+ attacker //Defender takes head, attacher is moved to the end
      }
      Thread.sleep(100L)
      fight(newKnights)
    }
  }

  println(s"${fight(knights).head.name} stands victorious!")

}

