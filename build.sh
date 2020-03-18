#!/usr/bin/env bash
# mvn clean install -DskipTests -U -pl ../exchange-web-api -am
# mvn clean install -DskipTests -U

BUILD_CMD='mvn clean install -DskipTests -U -pl ..'
BUILD_ALL_MOUDLE='mvn clean install -DskipTests -U'

usage(){
    echo ""
    echo "usage:"
    echo ""
    echo $0" moudle_name"
    echo "  例如构建moudle:sh build.sh moudle_name"
    echo ""
     echo $0" all"
    echo "    构建所有模块:cmd is mvn clean install -DskipTests"
    echo ""
}


if [ "$1" == "gof" ]; then
        ${BUILD_CMD}/$1 -am
elif [ "$1" == "javapatterns" ]; then
        ${BUILD_CMD}/$1 -am
elif [ "$1" == "wiki" ]; then
        ${BUILD_CMD}/$1 -am
elif [ "$1" == "all" ]; then
        ${BUILD_ALL_MOUDLE}
else
    usage
fi