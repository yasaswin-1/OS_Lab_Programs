echo "Enter basic salary"
read sal
if [ $sal -lt 1500 ];then
gsal=$[$sal+(($sal*10)/100)+(($sal*90)/100)]
elif [ $sal -ge 1500 ];then
gsal=$[$sal+500+(($sal*98)/100)]
fi
echo "Gross Salary is $gsal"
