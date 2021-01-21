set projectLocation=.
cd %projectLocation% 
set classpath=%projectLocation%\lib\*;%projectLocation%\bin; 
java org.testng.TestNG %projectLocation%\testngParllel.xml 
pause 