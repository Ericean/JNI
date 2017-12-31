#!/bin/bash
 g++ -c -fPIC -I$JAVA_HOME/include -I$JAVA_HOME/include/linux foo.cc
 g++ -shared -o libfoo.so  -I$JAVA_HOME/include -I$JAVA_HOME/include/linux foo.o
 dd if=/dev/zero of=tensorflow_inception_graph.pb bs=24k count=3
 javac com/zg/jni/demo/Demo.java 
 export LD_LIBRARY_PATH=.
 java com.zg.jni.demo.Demo 
