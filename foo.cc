#include <cstdlib>
#include <iostream>
#include "include/demo.h"
JNIEXPORT void JNICALL Java_com_zg_jni_demo_Demo_init
(JNIEnv * env, jobject obj, jbyteArray arr){
	jsize len = env->GetArrayLength(arr);
        jbyte* buff = static_cast<jbyte*>(malloc(sizeof(jbyte)*len));
	env->GetByteArrayRegion(arr,0,len,buff);

/*
	for(jsize i=0; i< len; ++i)
		std::cout << buff[i]; 
*/
	delete[] buff;
}
