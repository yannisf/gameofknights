import random

knights = []
for i in range(5):
    knights.append((f'Knight_{i}', 6))

def findNextIndex(currentIndex):
    return 0 if currentIndex == len(knights)-1 else currentIndex + 1

currentIndex = 0
while (len(knights) > 1):
    nextIndex = findNextIndex(currentIndex)
    currentKnight = knights[currentIndex]
    nextKnight = knights[nextIndex]
    attackPower = random.randint(1, 6)
    print(f'{currentKnight[0]} deals {attackPower} to {nextKnight[0]}.')
    nextKnight = (nextKnight[0], nextKnight[1]-attackPower)
    if (nextKnight[1] <= 0):
        print(f'{nextKnight[0]} dies.')
        knights.remove(knights[nextIndex])
        currentIndex = knights.index(currentKnight)
        nextIndex = findNextIndex(currentIndex)
    else:
        knights[nextIndex] = nextKnight
    currentIndex = nextIndex

print(f'{knights[0][0]} stands victorious.')
