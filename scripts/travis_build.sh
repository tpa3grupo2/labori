#!/bin/bash

# download libs
./scripts/prepare_dependencies.sh

_PWD=`pwd`

$LIBS_DIR=modules

CopyLibs=$_PWD/$LIBS_DIR/org-netbeans-modules-java-j2seproject-copylibstask.jar
HibernateLibs=`echo $_PWD/$LIBS_DIR/hibernate-support/*.jar | tr ' ' ':'`
DerbyClientLib="$_PWD/$LIBS_DIR/derbyclient.jar"

CLASSPATH=$CLASSPATH:$_PWD/$LIBS_DIR/ant-contrib-1.0b3.jar:$CopyLibs

export CLASSPATH
echo "CLASSPATH:"$CLASSPATH

echo " "
echo "Compiling these projects:"
for i in * ; do
  if [ -d "$i" ] && [ ! "$i" = "$LIBS_DIR" ] && [ ! "$i" = "scripts" ]; then
    cd "$i"

    if [ -f "manifest.mf" ]; then
        TARGET=jar
    else
        TARGET=dist
    fi
    TARGET=""

    echo " "
    echo "----- $i -----"
    ant -lib $GeneralLibs \
        -Dlibs.CopyLibs.classpath="$CopyLibs" \
        -Dlibs.hibernate-support.classpath="$HibernateLibs" \
        -Dfile.reference.derbyclient.jar="$DerbyClientLib" \
        -Dj2ee.server.home="$_PWD" $TARGET
    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    echo " "
    cd ..
  fi
done

