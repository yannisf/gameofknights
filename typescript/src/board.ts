import { Knight } from "./knight";

export class Board {
    
  private knights: Knight[] = [];

  constructor() {
    for (let i = 0; i < 100; i++) {
      this.knights.push(new Knight("Knight_" + i, 10));
    }
  }

  removeKnightByIndex(index: number) {
    this.knights.splice(index, 1);
  }

  findNextIndex(currentIndex: number) {
    return currentIndex == this.knights.length - 1 ? 0 : currentIndex + 1;
  }

  battleFinished() {
    if (this.knights.length == 1) {
      console.log(`${this.knights[0]} stands victorious with ${this.knights[0].kills} kills`);
      return true;
    } else {
      return false;
    }
  }

  battle() {
    let currentKnightIndex = 0;
    while (!this.battleFinished()) {
      let currentKnight = this.knights[currentKnightIndex];
      let nextKnightIndex = this.findNextIndex(currentKnightIndex);
      let nextKnight = this.knights[nextKnightIndex];
      let nextKnightSurvives = currentKnight.attack(nextKnight);
      if (nextKnightSurvives) {
        currentKnightIndex = nextKnightIndex;
      } else {
        this.removeKnightByIndex(nextKnightIndex);
        currentKnightIndex = this.knights.indexOf(currentKnight);
        nextKnightIndex = this.findNextIndex(currentKnightIndex);
        currentKnightIndex = nextKnightIndex;
      }
    }
  }
}
