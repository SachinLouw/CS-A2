'
Test Script for LSArray/LSBST apps
lwxsac001
'

num1 = 1 + RANDOM % 8
num2 = 1 + RANDOM % 28
num3 = RANDOM % 23

'
while read line
do
  array+=("$line")
done < names
'
for value in {1..3}
do 

#        head -$(($value+1)) Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt|cat>Load_Shedding_All_Areas_Schedule_and_Map.clean.final2.txt
        printf "$value `java LSBSTApp "${array[$(($num1))]}"`\n" 
        #`java LSArrayApp "${array[$(($num1))]}"`\n"

done
