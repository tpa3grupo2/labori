#!/bin/sh

_PWD=`pwd`

LIBS_DIR=$_PWD/lib
mkdir -p $LIBS_DIR

wget https://dl.dropbox.com/u/12910711/labori-libs.tar.gz -P $LIBS_DIR/
tar xzvf labori-libs.tar.gz

# LIBS_DIR=../web/WEB-INF/lib

# mkdir -p $LIBS_DIR
# cd $LIBS_DIR
# echo Downloading omnifaces...
# curl http://omnifaces.googlecode.com/files/omnifaces-1.1.jar -O
# echo DONE.
