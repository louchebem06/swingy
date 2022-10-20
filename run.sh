#!/bin/bash

cd src
find . -name "*.java" > source.txt
javac -Xlint @source.txt
rm -rf source.txt
java main.Game $@
