set ANT_HOME=c:\ant\apache-ant-1.8.2
set JAVA_HOME=C:\Progra~1\Java\jdk1.6.0_18
set PATH=%ANT_HOME%\bin;%JAVA_HOME%\bin;%path%
set MYPATH=C:\Documents and Settings\Administrator\Desktop\padmaraj\demo\mediclinic\workspace\with search\work1\mediApp\WEB-INF\lib
set CLASSPATH=%MYPATH%;%CLASSPATH%
pushd C:\Program Files\Apache Software Foundation\Tomcat 6.0\bin\
java -jar bootstrap.jar stop
popd
call ant
pushd C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps
rmdir /S /Q appment
del /S /Q appment.war
popd
xcopy appment.war "C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps"
pushd C:\Program Files\Apache Software Foundation\Tomcat 6.0\logs
del /S /Q *.log
popd
rem pushd C:\Program Files\Apache Software Foundation\Tomcat 6.0\bin\
rem java -jar bootstrap.jar start
rem popd
rem pause

