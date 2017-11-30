#!/bin/bash


cd /home/bartoszpieczara/IdeaProjects/GameForDemo
git clone https://github.com/brrt2/TicTacToeOOP2Final.git
cd /home/bartoszpieczara/IdeaProjects/GameForDemo/TicTacToeOOP2Final
mvn install
java -jar target/TicTacToeOOP-1.0-SNAPSHOT.jar