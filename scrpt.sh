#!/bin/sh

javac -sourcepath ./src -d bin src/javase01/t01/main/Main.java
java -classpath ./bin javase01.t01.main.Main
