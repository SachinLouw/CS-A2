
import random

myFile = open('original.txt', 'r')
lines = myFile.readlines()
'''
Creates subsets from the original loadshedding data file 
by taking random lines from the original file
'''
for i in range(1,11):
    output = []
    for j in range(297*i):
        a = random.randint(0,2975)
        output.append(lines[a])
    outFile = open('sample_'+str(i)+'.txt', 'w')
    for line in output:
        outFile.write(line)
'''
Creates subsets from the original loadshedding data file 
by taking random lines from the original file
'''
for i in range(10,0,-1):
    output = []
    for j in range(297*i,0,-1):
        output.append(lines[j])
    outFile = open('sortedsample_'+str(i)+'.txt', 'w')
    output.sort(key=None, reverse=True)
    for line in output:
        outFile.write(line)