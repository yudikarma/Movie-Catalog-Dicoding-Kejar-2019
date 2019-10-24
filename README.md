# Movie-Catalog-Dicoding-Kejar-2019
[![API](https://img.shields.io/badge/platform-Android-green.svg?style=flat)](https://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://developer.android.com/index.html) 

Zonapets is android Application social media for user who loves pets and want to share about her pets with other users and have fun with thats


### Learn Refrence
> https://developer.android.com/jetpack
> https://blog.mindorks.com/
> https://codingwithmitch.com/blog/


### Basic Explained
```sh
/ architecture              / Description
/-------------------------------------------
/ Model              / Response or entity
/ View               / Fragment or Activity (UI)
/ ViewModel          / Busines Logic
/ Repository         / Door to get data (from network or local database or prefrence)
```

### Basec Rules
```sh
> - Ui just Acces repository via ViewModels
> - every UI (activity or Fragment) should have ViewModel or androidViewmodel
> - do not edit Base Class (*BaseActivity *BaseFragment *BaseViewmodel)
> - whats should i do if wanna add news activity or fragment ??
>     1. if your activity need Inject module (need repository or viewmodel) 
>       - dont forget add your activity in ActivityBuilder
>       - if need viewmodel. please this activity extend : BaseAcitivytyViewModel.kt
>       - if this activity has fragment. please change extends to : BaseActivityhasFragment.kt
>       - if just need inject. only need to extends : BaseActivity.kt
>     2. if you fragment need inject module (need repository or viewmodel use network request)
>       - dont forget to create your FragmentProviders and add your fragment providers to Youractivity module in ActivityBuilder.kt
>       - if need to inject and need viewmodel ? extends : BaseFragment.kt
> - whats shoud i do if wanna add news ViewModel ?
>     1. if your viewmodel need inject module (repository and other)
>        - add inject constructor to viewmodel > see sample at my viewmodel
>        - extends : BaseViewmodel.kt
>        - add your viewmodel to ViewModelModule.kt 
> - what should i do if wanna add news WorkManager class ?
>       - dont forget add your register to Worker Module 
>       - put your workmanager class in package "utils/worker"
> - put Model class in Model Package at Data. local for model local and network for model response   
> - if your class need Serialize or deserialize JSON GSON. dont forget add keep your class in proguard-Rules.pro
> - whats should i do if wanna add news Service ? 
>     - if your service need inject ? dont forget add your service class in ServiceBuilder.kt
> - if you wanna add news Library. please check for proguard rules that library and dont forger to Proguard-rules.pro    
```

### Explained Structur Package

```sh
/ Package       / description
/--------------------------------
/ DATA          / all class about need Data (model,api client,room,Prefrence helper,dll
/ DI            / Depedencies Injection Package
/ UI            / All about UI, like activity or fragment
/ Utils         / Common class, like Helper class,object, ekstension, custom class and more
----------------------------------------------------------------------------------------------
```
                      
### Libraries

Zonapets uses a number of open source projects to work properly:

* [Glide] - An image loading and caching library for Android focused on smooth scrolling 
* [Android Jetpack Architecture Components] - Jetpack is a suite of libraries, tools, and guidance to help developers write high-quality apps easier
* [Retrofit] /[OkHttp] - MA type-safe HTTP client for Android and Java
* [Gson] - A Java serialization/deserialization library to convert Java Objects into JSON and back
* [Dagger 2] - Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.
* [Timber] - A logger with a small, extensible API which provides utility on top of Android's normal Log class.
* [Crashlytics] - Firebase Crashlytics helps you track, prioritize, and fix stability issues that erode app quality, in realtime. Spend less time 
* [Anko] - Pleasant Android application development
* [Coroutines] - Library support for Kotlin coroutines with multiplatform support. This is a companion version for Kotlin
* [Espresso] - for UI tests
* [code picker] - Country Code Picker (CCP) is an android library which provides an easy way to search and select country or international phone code. Also supports Android EditText phone mask and international phone validation.
* [android-cropview] - An Android library that lets you implement image crop. ImageCropView crops image by moving image under fixed crop area like instagram
* [tap target view] - An implementation of tap targets from the Material Design guidelines for feature discovery
* [shimmer] - An easy, flexible way to add a shimmering effect to any view in an Android app. 
* [guava] - Google core libraries for Java
* [pin entry edittext] - An EditText that looks like a pin entry field. It is highly customisable and even animated text.
* [lottie] - Render After Effects animations natively on Android and iOS, Web, and React Native 
* [eventbus] - Event bus for Android and Java that simplifies communication between Activities, Fragments, Threads, Services, etc. Less code, better quality. 
* [compressor] - An android image compression library.
* [hawk] - ✔️ Secure, simple key-value storage for Android
* [material search view] - Cute library to implement SearchView in a Material Design Approach 
* [circle imageview] - A circular ImageView for Android



[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)




  
   [Android Jetpack Architecture Components]: <https://developer.android.com/topic/libraries/architecture>
   [Retrofit]: <https://square.github.io/retrofit/>
   [OkHttp]: <https://square.github.io/okhttp/>
   [Gson]: <https://github.com/google/gson>
   [Dagger 2]: <https://dagger.dev//>
   [Timber]: <https://github.com/JakeWharton/timber>
   [Crashlytics]: <https://firebase.google.com/products/crashlytics?utm_source=crashlytics_marketing&utm_medium=redirect&utm_campaign=crashlytics_redirect>
   [Glide]: <https://github.com/bumptech/glide>
   [Anko]: <https://github.com/Kotlin/anko>
   [Coroutines]: <https://github.com/Kotlin/kotlinx.coroutines>
   [Espresso]: <https://github.com/googlesamples/android-testing>
   [code picker]: <https://github.com/hbb20/CountryCodePickerProject>
   [android-cropview]: <https://github.com/naver/android-imagecropview>
   [tap target view]: <https://github.com/KeepSafe/TapTargetView>
   [shimmer]: <https://github.com/facebook/shimmer-android>
   [guava]: <https://github.com/google/guava>
   [pin entry edittext]: <https://github.com/alphamu/PinEntryEditText>
   [lottie]: <https://github.com/airbnb/lottie-android>
   [eventbus]: <https://github.com/greenrobot/EventBus>
  [compressor]: <https://github.com/zetbaitsu/Compressor>
  [hawk]: <https://github.com/orhanobut/hawk>
  [material search view]: <https://github.com/MiguelCatalan/MaterialSearchView>
  [circle imageview]: <https://github.com/hdodenhof/CircleImageView>
  [107 Company]:<http://107.co.id/>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>

