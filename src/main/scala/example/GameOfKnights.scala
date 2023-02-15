package example

import scala.annotation.tailrec
import scala.util.Random

object GameOfKnights extends App {

  val numberOfKnights = 5
  val initialHealth = 10

  val knights = (1 to numberOfKnights).map(i => Knight(s"Knight_${i}"))

  case class Knight(name: String, health: Int = initialHealth) {
    def attack() = Random.nextInt(6) + 1
    def isDead = health <= 0
  }

  @tailrec
  def recurse(knights: Seq[Knight]): Seq[Knight] = {
    if (knights.size == 1) knights
    else {
      val newKnights = knights match {
        case Seq(attacker, defender, tail @ _*) =>
          val attackPoints = attacker.attack()
          val newDefender = defender.copy(health = defender.health - attackPoints)
          println(s"${attacker.name} deals $attackPoints damage to ${defender.name}")
          if (newDefender.isDead) {
            println(s"Knight ${newDefender.name} has died...")
            tail ++ Seq(attacker)
          } else {
            Seq(newDefender) ++ tail ++ Seq (attacker)
          }
      }
      Thread.sleep(100L)
      recurse(newKnights)
    }
  }

  println(s"${recurse(knights).head.name} stands victorious!")

}

