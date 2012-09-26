#!/bin/bash

# download .jar dependencies
./scripts/prepare_dependencies.sh

_PWD=`pwd`

CopyLibs=$_PWD/lib/org-netbeans-modules-java-j2seproject-copylibstask.jar

HibernateLibs=\
    $_PWD/hibernate-support/antlr-2.7.6.jar;\
    $_PWD/hibernate-support/asm.jar;\
    $_PWD/hibernate-support/asm-attrs.jar;\
    $_PWD/hibernate-support/cglib-2.1.3.jar;\
    $_PWD/hibernate-support/commons-collections-2.1.1.jar;\
    $_PWD/hibernate-support/org-apache-commons-logging.jar;\
    $_PWD/hibernate-support/dom4j-1.6.1.jar;\
    $_PWD/hibernate-support/ehcache-1.2.3.jar;\
    $_PWD/hibernate-support/jdbc2_0-stdext.jar;\
    $_PWD/hibernate-support/jta.jar;\
    $_PWD/hibernate-support/hibernate3.jar;\
    $_PWD/hibernate-support/hibernate-tools.jar;\
    $_PWD/hibernate-support/hibernate-annotations.jar;\
    $_PWD/hibernate-support/hibernate-commons-annotations.jar;\
    $_PWD/hibernate-support/hibernate-entitymanager.jar;\
    $_PWD/hibernate-support/javassist.jar

CLASSPATH=$CLASSPATH:$_PWD/lib/ant-contrib-1.0b3.jar:$CopyLibs:$HibernateLibs
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
        -Dlibs.hibernate-support.classpath="$HibernateLibs" \
        -Dj2ee.server.home="$_PWD" $TARGET
    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    echo " "
    cd ..
  fi
done

