import subprocess

n = 297
for i in range(1,2):
    n = i*n
    process = subprocess.run(['shuf', '-n', str(n), 'original.txt'], capture_output = True, text = True)
    myFile = open('sample_' + str(i) + '.txt')
    myFile.writelines(process.stdout)
    myFile.close()
    subprocess.run(['java', 'Testing', 'sample_' + str(i)  + '.txt', 'result_' + str(i)  + '.csv'], capture_output =True)

'''    
myFile = open('sample_1.txt', 'r')
lines = myFile.readlines()

cases = [best, worst, valid, invalid]

with open('results.txt', 'w') as f:
    for k in cases:
        f.write([ j for j,v in locals().items() if v == k][0].capitalize() + ' case: \n')
        subprocess.run(['java', 'LSArrayApp ' + k], 
                        stdout=f, text=True)
f.close()'''
