@echo off
setlocal

cd %~dp0

set RUNTIME_LIB=.\classes
set RUNTIME_LIB=%RUNTIME_LIB%;.\lib\*

java -classpath %RUNTIME_LIB% jp.rhp.batch.MainBatch
