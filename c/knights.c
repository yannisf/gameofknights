#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct Knight {
    char name[20];
    int health;
    struct Knight *nextKnight;
} Knight;

Knight *setup(int numberOfKnights, int initialHealth) {
    const char knight_name_prefix[] = "Knight_";
    Knight *firstKnight = NULL;
    Knight *previousKnight = NULL;

    int i;
    for (i = 0; i < numberOfKnights; i++) {
        Knight *tempKnight = malloc(sizeof(Knight));
        sprintf(tempKnight->name, "%s%d", knight_name_prefix, i);
        tempKnight->health = initialHealth;
        if (firstKnight == NULL) {
            firstKnight = tempKnight;
        }
        if (previousKnight != NULL) {
            previousKnight->nextKnight = tempKnight;
        }
        previousKnight = tempKnight;
    }
    previousKnight->nextKnight = firstKnight;

    return firstKnight;
}

Knight *attack(Knight *attackingKnight) {
    Knight *defendingKnight = attackingKnight->nextKnight;
    int force = (rand() % 6) + 1;
    defendingKnight->health -= force;
     printf("%s deals %d damage to %s.\n", attackingKnight->name, force, defendingKnight->name);
    if (defendingKnight->health < 1) {
         printf("%s dies...\n", defendingKnight->name);
        attackingKnight->nextKnight = defendingKnight->nextKnight;
        free(defendingKnight);
    }
    return attackingKnight->nextKnight;
}

int main() {
    srand(time(NULL));
    Knight *attackingKnight = setup(3, 6);
    while (attackingKnight->nextKnight != attackingKnight) {
        attackingKnight = attack(attackingKnight);
    }
    printf("%s stands victorious!!!\n", attackingKnight->name);

    return 0;
}