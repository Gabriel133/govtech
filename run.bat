@echo off
pushd %~dp0src
cmd /k java -cp .;antlr-3.2.jar Main .\..\target-search-dir