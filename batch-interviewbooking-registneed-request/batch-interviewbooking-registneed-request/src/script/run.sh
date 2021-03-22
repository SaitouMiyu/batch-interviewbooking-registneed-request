#!/bin/sh

FULL_PATH=`readlink -f $0`
cd `dirname $FULL_PATH`

RUNTIME_LIB=./classes
RUNTIME_LIB=$RUNTIME_LIB:./lib/*

java -classpath $RUNTIME_LIB jp.rhp.batch.MainBatch
