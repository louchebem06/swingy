#!/bin/bash

find . -name "*.class" > removes.txt
xargs rm < removes.txt
rm removes.txt
