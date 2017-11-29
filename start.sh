#!/bin/bash


cd /home/bartoszpieczara/IdeaProjects/GameForDemo
git clone https://github.com/brrt2/TicTacToeOOP2.git
cd /home/bartoszpieczara/IdeaProjects/GameForDemo/TicTacToeOOP2
mvn install
java -jar target/TicTacToeOOP-1.0-SNAPSHOT.jar