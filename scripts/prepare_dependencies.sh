#!/bin/sh

_PWD=`pwd`

LIBS_DIR=$_PWD/lib
mkdir -p $LIBS_DIR

echo ==============
echo Downloading labori libs package...
wget https://dl.dropbox.com/u/12910711/labori/labori-libs.tar.gz -P $LIBS_DIR/
tar xzvf $LIBS_DIR/labori-libs.tar.gz -C $LIBS_DIR
