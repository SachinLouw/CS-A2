import random

myFile = open('original.txt', 'r')
lines = myFile.readlines()

for i in range(10,11):
    output = []
    for j in range(297*i):
        a = random.randint(0,2975)
        output.append(lines[a])
    outFile = open('sample_'+str(i)+'.txt', 'w')
    for line in output:
        outFile.write(line)