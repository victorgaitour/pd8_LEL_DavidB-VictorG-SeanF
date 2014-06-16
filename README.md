pd8_LEL_DavidB-VictorG-SeanF 
======================
The Project:
---------
Our project is a data visualizer.  It begins with command line interface, where you can choose to enter the data from a csv file or from the command line.  By following the specific format that this project requires, the user is actually inputing their data into and ArrayList.  Once the data has been entered, the user can choose between a host of data structures to visualize his or her data.  The user can also choose to see the data in either a bar graph or a pie chart (we used jfreechart here).

**Compiling/running:**

At first try:
javac -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL.java
java -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL

If that doesn’t work, you need to download jcommon version 1.0.22 and jfreechart 1.0.17 for this.  Once you download the .zip files, you need to unpack them.  If you have Linux or Unix, while in the directory of the downloaded zip file, enter "tar xvzf jfreechart-1.0.17.zip" into the terminal.  Then enter "tar xvzf jcommon-1.0.22.zip" to unpack jcommon.  If you have Windows, enter "jar -xvf jfreechart-1.0.13.zip" to unpack jfreechart, then enter "jar -xvf jcommon-1.0.22.zip" to unpack jcommon.

Once you have unpacked these two files, you should see a folder for each of them, one titled "jfreechart-1.0.17" the other titled "jcommon-1.0.22".  Move both of these files into the pd8_LEL_DavidB-VictorG-SeanF directory, or whatever directory you have for this project.  Next, enter the jfreechart-1.0.17 folder and find a folder called "lib".  Take this folder and also place it into the pd8_LEL_DavidB-VictorG-SeanF directory.

Now you have all the .jar files in place for this project.  Some files use jfreechart, others don't, but this command should work to compile any (NOTE: if you have Windows, replace the colons in the following statement with semicolons):

javac -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL.java

*To run:*

java -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar:." LEL

If, for some reason, this doesn't work, it technically only affects the chart making.  By entering LEL.java (the driver file) and commenting out any import statement the begins with "org.jfree." and the entirety of the "else if (choice2 == 8)" block, the code should work with limited functionality.

