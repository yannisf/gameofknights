package example

import scala.annotation.tailrec
import scala.util.Random

object GameOfKnights extends App {

  val numberOfKnights = 3
  val initialHealth = 6

  case class Knight(name: String, health: Int = initialHealth) {
    def attack(): Int = Random.nextInt(6) + 1
    def isDead: Boolean = health <= 0
  }

  val knights = (1 to numberOfKnights).map(i => Knight(s"Knight_$i")) //Initialize knights

  @tailrec
  private def fight(knights: Seq[Knight] = knights): Seq[Knight] = knights match {
    case Seq(_) => knights //Termination condition
    case Seq(attacker, defender, tail@_*) => //Pattern match decomposes list to its elements
      val newDefender = defender.copy(health = defender.health - attacker.attack())
      println(s"${attacker.name} deals ${defender.health - newDefender.health} damage to ${defender.name}")
      if (newDefender.isDead) {
        println(s"${newDefender.name} has died...")
        fight(tail :+ attacker) //Defender is removed, the attacker is moved to the end, and let the next round begin
      } else fight(newDefender +: tail :+ attacker) //Defender takes head, attacker is moved to the end, and let the next round begin
  }

  println(s"${fight().head.name} stands victorious!")

}

