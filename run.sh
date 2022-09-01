#!/bin/bash

if (( $# < 1 ))
then
	exit;
fi

find . -name "*.class" > removes.txt
xargs rm < removes.txt
rm removes.txt
find . -name "*.java" > source.txt
javac @source.txt
rm -rf source.txt
java com.school42.swingy.game.Game $@