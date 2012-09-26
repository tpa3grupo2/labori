#!/bin/bash

# download .jar dependencies
./scripts/prepare_dependencies.sh

_PWD=`pwd`

CopyLibs=$_PWD/lib/org-netbeans-modules-java-j2seproject-copylibstask.jar

HibernateLibs="$_PWD/lib/hibernate-support/antlr-2.7.6.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/asm.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/asm-attrs.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/cglib-2.1.3.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/commons-collections-2.1.1.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/dom4j-1.6.1.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/ehcache-1.2.3.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/jdbc2_0-stdext.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/jta.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/hibernate3.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/hibernate-tools.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/hibernate-annotations.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/hibernate-commons-annotations.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/hibernate-entitymanager.jar"
HibernateLibs="$HibernateLibs;$_PWD/lib/hibernate-support/javassist.jar"

DerbyClient="$_PWD/lib/derbyclient.jar"

CLASSPATH=$CLASSPATH:$_PWD/lib/ant-contrib-1.0b3.jar:$CopyLibs:$HibernateLibs:$DerbyClient
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
        -Dfile.reference.derbyclient.jar="$DerbyClient" \
        -Dj2ee.server.home="$_PWD" $TARGET
    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    echo " "
    cd ..
  fi
done

