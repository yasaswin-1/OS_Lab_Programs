read -p "Enter the marks of first subject :" s1
read -p "Enter the marks of second subject :" s2
read -p "Enter the marks of third subject :" s3
read -p "Enter the marks of fourth subject :" s4
read -p "Enter the marks of fifth subject :" s5
total=$[s1 + s2 + s3 + s4 + s5]
avg=$[total/5]
if [ $avg -ge 90 ];then 
echo "Grade : A+" 
elif [ $avg -ge 80 ];then 
echo "Grade: A" 
elif [ $avg -ge 70 ];then
echo "Grade : B" 
elif [ $avg -ge 60 ];then 
echo "Grade : C" 
elif [ $avg -ge 50 ];then 
echo "Grade : D" 
elif [ $avg -ge 35 ];then
echo "Grade : E" 
else 
echo "Result : Fail" 
fi 
