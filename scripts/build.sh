#!/bin/bash

# download .jar dependencies
./scripts/prepare_dependencies.sh

_PWD=`pwd`

CopyLibs=$_PWD/lib/org-netbeans-modules-java-j2seproject-copylibstask.jar

CLASSPATH=$CLASSPATH:$_PWD/lib/ant-contrib-1.0b3.jar:$CopyLibs
export CLASSPATH
echo "CLASSPATH:"$CLASSPATH

echo " "
echo "Compiling these projects:"
for i in * ; do
  if [ -d "$i" ] && [ ! "$i" = "lib" ]; then
    cd "$i"

    if [ -f "manifest.mf" ]; then
        TARGET=jar
    else
        TARGET=dist
    fi
    TARGET=""

    echo " "
    echo "----- $i -----"
    ant -Dlibs.CopyLibs.classpath="$CopyLibs" \
        -Dj2ee.server.home="$_PWD" $TARGET
    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    echo " "
    cd ..
  fi
done

