#!/bin/sh
set +v
LIBS_DIR=../web/WEB-INF/lib

mkdir -p $LIBS_DIR
cd $LIBS_DIR
echo Downloading omnifaces...
curl http://omnifaces.googlecode.com/files/omnifaces-1.1.jar -O
echo DONE.
