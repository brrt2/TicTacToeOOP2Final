#!/bin/bash


cd /home/bartoszpieczara/IdeaProjects/GameForDemo
git clone https://github.com/brrt2/ForDemo.git
cd /home/bartoszpieczara/IdeaProjects/GameForDemo/ForDemo
mvn install
java -jar target/TicTacToeOOP-1.0-SNAPSHOT.jar