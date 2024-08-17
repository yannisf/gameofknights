import * as _ from 'lodash';

export class Knight {
  readonly name: string;
  health: number;
  kills: number = 0;

  constructor(name: string, health: number) {
    this.name = name;
    this.health = health;
  }

  attack(knight: Knight): boolean {
    const attackPower = _.random(1, 6);
    console.log(`${this.name} deals [${attackPower}] to ${knight.name}`);
    let survives = knight.receive(attackPower);
    if (!survives) {
      this.kills++;
    }
    return survives;
  }

  private receive(attackPower: number): boolean {
    this.health -= attackPower;
    if (this.health <= 0) {
      console.log(`${this.name} has died.`);
      return false;
    } else {
      console.log(`${this.name} has now health ${this.health}`);
      return true;
    }
  }

  toString(): string {
    return `${this.name}[${this.health}]`;
  }
}
