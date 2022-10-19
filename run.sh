#!/bin/bash

find . -name "*.class" > removes.txt
xargs rm < removes.txt
rm removes.txt
find . -name "*.java" > source.txt
javac -Xlint @source.txt
rm -rf source.txt
java com.school42.swingy.game.Game $@
