let knights = [];
for (let i = 0; i < 3; i++) {
  knights.push({ name: "Knight_" + i, health: 6 })
}

function findNextIndex(currentIndex) {
  return currentIndex == knights.length - 1 ? 0 : currentIndex + 1
}

let currentIndex = 0
while(knights.length>1) {
    let nextIndex = findNextIndex(currentIndex)
    let currentKnight = knights[currentIndex]
    let nextKnight = knights[nextIndex]
    let attackPower = Math.floor(Math.random() * 6) + 1
    console.log(`${currentKnight.name} deals ${attackPower} to ${nextKnight.name}.`)
    nextKnight.health -= attackPower
    if (nextKnight.health <= 0) {
        console.log(`${nextKnight.name} dies.`)
        knights.splice(nextIndex,1)        
        currentIndex = knights.indexOf(currentKnight)
        nextIndex = findNextIndex(currentIndex)
    } 
    currentIndex = nextIndex
}

console.log(`${knights[0].name} stands victorious.`)