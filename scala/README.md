# Game of Knights

To recurse is divine... Of course there was an elegant recursive solution!

## Build and Run

You just need `sbt` (the scala build tool)

      $ sbt run

## Sample output

```
Knight_1 deals 3 damage to Knight_2
Knight_2 deals 2 damage to Knight_3
Knight_3 deals 1 damage to Knight_4
Knight_4 deals 2 damage to Knight_5
Knight_5 deals 3 damage to Knight_1
Knight_1 deals 2 damage to Knight_2
Knight_2 deals 2 damage to Knight_3
Knight_3 deals 1 damage to Knight_4
Knight_4 deals 2 damage to Knight_5
Knight_5 deals 5 damage to Knight_1
Knight_1 deals 1 damage to Knight_2
Knight_2 deals 6 damage to Knight_3
Knight_3 has died...
Knight_4 deals 2 damage to Knight_5
Knight_5 deals 6 damage to Knight_1
Knight_1 has died...
Knight_2 deals 3 damage to Knight_4
Knight_4 deals 4 damage to Knight_5
Knight_5 has died...
Knight_2 deals 2 damage to Knight_4
Knight_4 deals 5 damage to Knight_2
Knight_2 has died...
Knight_4 stands victorious!
```
