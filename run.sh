#!/bin/sh

FILE=target/game-of-multiples-1.0.0.jar
if [ ! -f "$FILE" ]; then
    mvn clean verify
    echo
fi

read -p "Do you want to start the game? " -n 1 -r
echo
if [[ ! $REPLY =~ ^[Yy]$ ]]
then
    exit 1
fi

java -jar $FILE