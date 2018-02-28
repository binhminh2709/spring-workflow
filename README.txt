
===========================================
= Running the Examples                    =
===========================================

The API discussed here is bundled as the main source code under the src/java directory.   
Three unit tests exist in the src/testdirectory including 
SimpleSequenceTestCase,  RateDropTestCase and PoolingTestCase.  
To run all the tests type "maven test" in a command shell and Maven will download 
all the necessary jar files before compiling and running.  To see all output in the console, 
set maven.junit.usefile=false in the build.properties file.  Otherwise, use all JUnit test
output will be logged to the files under the target/test-reports dirctory.
Actual XSL transforms will take place for two of the tests with results piped to output via log4j.  
After successful execution of the test suite, you may wish to run the tests individually and watch 
output real time.  Try using "maven test:ui" to pull up the graphical test 
runer, the select the test you want to run and watch the output in the console.



===========================================
= USING WITH ECLIPSE                      =
===========================================

1. Make sure you have your MAVEN_REPO class path variable set in eclipse
2. run "maven eclipse" 
3. in Eclipse, use the import tool to "import an existing project"
4. import the iocwf java project.
