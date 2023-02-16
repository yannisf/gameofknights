package example

import scala.annotation.tailrec
import scala.util.Random

object GameOfKnights extends App {

  val numberOfKnights = 3
  val initialHealth = 6

  case class Knight(name: String, health: Int = initialHealth)

  val initialKnights = (1 to numberOfKnights).map(i => Knight(s"Knight_$i")) //Initialize knights

  @tailrec
  private def fight(knights: Seq[Knight] = initialKnights): Seq[Knight] = knights match {
    case Seq(_) => knights //Termination condition: Sequence has just one member
    case Seq(attacker, defender, tail@_*) => //Pattern matching decomposes list to its elements
      val updatedKnight = defender.copy(health = defender.health - (Random.nextInt(6) + 1))
      println(s"${attacker.name} deals ${defender.health - updatedKnight.health} damage to ${defender.name}")
      updatedKnight match {
        case Knight(name, health) if health <= 0 => //Knight has died (health <= 0)
          println(s"$name has died...")
          fight(tail :+ attacker) //Defender is removed, the attacker is moved to the end, and let the next round begin
        case _ => fight(updatedKnight +: tail :+ attacker) //Defender takes head, attacker is moved to the end, and let the next round begin
      }
  }

  println(s"${fight().head.name} stands victorious!")

}
