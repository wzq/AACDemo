# AACDemo
Android Architecture Components Demo

***app***

***dependencies***
```groovy
    kapt 'androidx.room:room-compiler:2.0.0'
    kapt "com.github.bumptech.glide:compiler:4.8.0"

    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"

    implementation 'androidx.appcompat:appcompat:1.0.0'
    implementation "androidx.recyclerview:recyclerview:1.0.0"
    implementation "com.google.android.material:material:1.0.0"
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

    implementation "android.arch.navigation:navigation-fragment-ktx:1.0.0-alpha07"
    implementation "android.arch.navigation:navigation-ui-ktx:1.0.0-alpha07"

    implementation "androidx.core:core-ktx:1.0.0"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
    implementation "androidx.room:room-runtime:2.0.0"
    implementation "android.arch.work:work-runtime-ktx:1.0.0-alpha10"

    implementation "com.google.code.gson:gson:2.8.2"
    implementation "com.github.bumptech.glide:glide:4.8.0"

    implementation 'com.squareup.okhttp3:okhttp:3.10.0'
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
//    compile 'com.squareup.retrofit2:converter-scalars:2.1.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.9.0'
```



## **11.06 note** ## 
  
* 引入`navigation`库，用于页面导航

## **10.31 note** ## 
  
* 用 `livedata`+`viewmodel`+`repository` 的结构，结合retrofit实现了一个简单页面
* 已测试使用 `work` 库，管理后台任务
* 将要引入`navigation`库，做页面路由

## **10.18 note** ## 
  
* 最新的构建库 已迁移到 `androidx` 包下，老项目可使用 Studio-> Refactor -> Migrate to AndroidX 功能迁移
* 使用 [kapt](http://kotlinlang.org/docs/reference/kapt.html) 来支持 `Annotation Processor`
