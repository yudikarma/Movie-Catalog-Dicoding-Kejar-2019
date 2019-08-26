# Movie-Catalog-Dicoding-Kejar-2019
# ZONAPETS
[![API](https://img.shields.io/badge/platform-Android-green.svg?style=flat)](https://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://developer.android.com/index.html) 

Zonapets is android Application social media for user who loves pets and want to share about her pets with other users and have fun with thats

# New Features!

  - Post image with 1.1 ratio
  - loves pets
  - comment on post
  - likes post
  - and many more


You can also:
  - post your pets activity image from galery or use include camera application
  - loves any pets
  - comment and likes post
  
### Featured

 - Upload and Play video
 - chats
 - show post in global zona by nearby location
 - and many more


the application is build by  [107 Company]
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

Project Tree
```sh
\---ZONAPETS
    |   \---src
    |       +---main
    |       |   |   AndroidManifest.xml
    |       |   |   
    |       |   +---assets
    |       |   |       dog_loading.json
    |       |   |       hamster_roll.json
    |       |   |       
    |       |   +---java
    |       |   |   \---ex
    |       |   |       \---hyrax
    |       |   |           \---zonapets
    |       |   |               |   ZonapetsApp.kt
    |       |   |               |   
    |       |   |               +---data
    |       |   |               |   |   Repository.kt
    |       |   |               |   |   
    |       |   |               |   +---database
    |       |   |               |   |   |   AppDatabase.kt
    |       |   |               |   |   |   
    |       |   |               |   |   +---dao
    |       |   |               |   |   |       PostCommentDao.kt
    |       |   |               |   |   |       PostLikeDao.kt
    |       |   |               |   |   |       
    |       |   |               |   |   \---room
    |       |   |               |   |           PostComment.kt
    |       |   |               |   |           PostLike.kt
    |       |   |               |   |           
    |       |   |               |   +---local
    |       |   |               |   |       EventBusModel.kt
    |       |   |               |   |       
    |       |   |               |   +---network
    |       |   |               |   |   |   NetworkState.kt
    |       |   |               |   |   |   
    |       |   |               |   |   +---client
    |       |   |               |   |   |       ApiHeader.kt
    |       |   |               |   |   |       ApiHeaderInterceptor.kt
    |       |   |               |   |   |       ApiHelper.kt
    |       |   |               |   |   |       ApiNetwork.kt
    |       |   |               |   |   |       ApiRetrofitCallback.kt
    |       |   |               |   |   |       AppApiHelper.kt
    |       |   |               |   |   |       
    |       |   |               |   |   \---model
    |       |   |               |   |       |   AnimalType.kt
    |       |   |               |   |       |   
    |       |   |               |   |       +---animal
    |       |   |               |   |       |       AnimalSubtype.kt
    |       |   |               |   |       |       AnimalType.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---check_email
    |       |   |               |   |       |       CheckEmail.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---common
    |       |   |               |   |       |       Author.kt
    |       |   |               |   |       |       Common.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---finduser
    |       |   |               |   |       |       FindUser.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---find_user_byname
    |       |   |               |   |       |       FindUserByNameResponse.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---follow
    |       |   |               |   |       |       FollowResponse.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---forgot_password
    |       |   |               |   |       |       ForgotPassword.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---login
    |       |   |               |   |       |       LoginResponse.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---logout
    |       |   |               |   |       |       LogoutResponse.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---notification
    |       |   |               |   |       |       Notification.kt
    |       |   |               |   |       |       NotificationDataSourceFactory.kt
    |       |   |               |   |       |       NotificationPagedKeyedDataSource.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---original_photo_profil
    |       |   |               |   |       |       PhotoProfilResponse.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---paging
    |       |   |               |   |       |       Listing.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---post
    |       |   |               |   |       |   |   InsertPostResponse.kt
    |       |   |               |   |       |   |   Like.kt
    |       |   |               |   |       |   |   Post.kt
    |       |   |               |   |       |   |   
    |       |   |               |   |       |   +---globalzona
    |       |   |               |   |       |   |       PostGlobalDataSourceFactory.kt
    |       |   |               |   |       |   |       PostGlobalPagedKeyedDataSource.kt
    |       |   |               |   |       |   |       
    |       |   |               |   |       |   \---myzona
    |       |   |               |   |       |           PostDataSourceFactory.kt
    |       |   |               |   |       |           PostPagedKeyedDataSource.kt
    |       |   |               |   |       |           
    |       |   |               |   |       +---post_detail
    |       |   |               |   |       |       PostDetail.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---registrasi
    |       |   |               |   |       |   \---private_user
    |       |   |               |   |       |           User.kt
    |       |   |               |   |       |           UserResponse.kt
    |       |   |               |   |       |           
    |       |   |               |   |       \---show_data_users
    |       |   |               |   |               ProfilePostListDataSourceFactory.kt
    |       |   |               |   |               ProfilePostListPagedKeyedDataSource.kt
    |       |   |               |   |               ProfilePostTagDataSourceFactory.kt
    |       |   |               |   |               ProfilePostTagPagedKeyedDataSource.kt
    |       |   |               |   |               ShowDataUserResponse.kt
    |       |   |               |   |               UsersFull.kt
    |       |   |               |   |               
    |       |   |               |   \---preference
    |       |   |               |           AppPreferenceHelper.kt
    |       |   |               |           PreferenceHelper.kt
    |       |   |               |           
    |       |   |               +---di
    |       |   |               |   |   ApiKeyInfo.kt
    |       |   |               |   |   PreferenceInfo.kt
    |       |   |               |   |   
    |       |   |               |   +---builder
    |       |   |               |   |       ActivityBuilder.kt
    |       |   |               |   |       ServiceBuilder.kt
    |       |   |               |   |       
    |       |   |               |   +---component
    |       |   |               |   |       AppComponent.kt
    |       |   |               |   |       
    |       |   |               |   \---module
    |       |   |               |           AppModule.kt
    |       |   |               |           ViewModelFactory.kt
    |       |   |               |           ViewModelKey.java
    |       |   |               |           ViewModelModule.kt
    |       |   |               |           
    |       |   |               +---helper
    |       |   |               |       ArrayHelper.java
    |       |   |               |       AutoFitTextureView.kt
    |       |   |               |       DelayAutoCompleteTextView.kt
    |       |   |               |       FabHideOnScroll.kt
    |       |   |               |       MyNestedScrollView.java
    |       |   |               |       ScrollAwareFABBehavior.kt
    |       |   |               |       SpannedGridLayoutManager.java
    |       |   |               |       WrapContentHeightViewPager.java
    |       |   |               |       
    |       |   |               +---service
    |       |   |               |       FirebaseNotification.kt
    |       |   |               |       
    |       |   |               +---ui
    |       |   |               |   |   SplashActivity.kt
    |       |   |               |   |   SplashActivityViewModel.kt
    |       |   |               |   |   
    |       |   |               |   +---base
    |       |   |               |   |       BaseActivity.kt
    |       |   |               |   |       BaseActivityHasFragment.kt
    |       |   |               |   |       BaseActivityViewModel.kt
    |       |   |               |   |       BaseFragment.kt
    |       |   |               |   |       BaseViewModel.kt
    |       |   |               |   |       
    |       |   |               |   +---camera
    |       |   |               |   |       ActivityCamera.kt
    |       |   |               |   |       ActivityCamera1API.kt
    |       |   |               |   |       ActivityCamera2API.kt
    |       |   |               |   |       ActivityGalery.kt
    |       |   |               |   |       ActivityGaleryAdapter.kt
    |       |   |               |   |       PhotoViewModel.kt
    |       |   |               |   |       
    |       |   |               |   +---crop
    |       |   |               |   |       CropPhotoActivity.kt
    |       |   |               |   |       
    |       |   |               |   +---dialog
    |       |   |               |   |   \---comment
    |       |   |               |   |           InsertCommentDialog.kt
    |       |   |               |   |           InsertCommentListener.kt
    |       |   |               |   |           InsertCommentProviders.kt
    |       |   |               |   |           InsertCommentViewModel.kt
    |       |   |               |   |           
    |       |   |               |   +---forgot_password
    |       |   |               |   |   |   ForgotPasswordActivity.kt
    |       |   |               |   |   |   TypeForgotPasswordFragment.kt
    |       |   |               |   |   |   
    |       |   |               |   |   +---forgot_via_email
    |       |   |               |   |   |   +---confirm_email
    |       |   |               |   |   |   |       ConfirmationEmailFragment.kt
    |       |   |               |   |   |   |       ConfirmationEmailFragmentProvider.kt
    |       |   |               |   |   |   |       ConfirmationEmailFragmentViewModel.kt
    |       |   |               |   |   |   |       
    |       |   |               |   |   |   +---insert_email
    |       |   |               |   |   |   |       ForgotPasswordEmailFragment.kt
    |       |   |               |   |   |   |       ForgotPasswordEmailFragmentProvider.kt
    |       |   |               |   |   |   |       ForgotPasswordEmailFragmentViewModel.kt
    |       |   |               |   |   |   |       
    |       |   |               |   |   |   \---reset_password
    |       |   |               |   |   |           ResetPasswordFromLinkFragment.kt
    |       |   |               |   |   |           
    |       |   |               |   |   +---forgot_via_phone
    |       |   |               |   |   |   \---insert_phone
    |       |   |               |   |   |           ForgotPasswordNumberphoneFragment.kt
    |       |   |               |   |   |           
    |       |   |               |   |   +---reset_password
    |       |   |               |   |   |       ResetPasswordFragment.kt
    |       |   |               |   |   |       ResetPasswordFragmentProvider.kt
    |       |   |               |   |   |       ResetPasswordFragmentViewModel.kt
    |       |   |               |   |   |       
    |       |   |               |   |   \---verify_pin
    |       |   |               |   |           VerifyPinFragment.kt
    |       |   |               |   |           VerifyPinFragmentProvider.kt
    |       |   |               |   |           VerifyPinFragmentViewModel.kt
    |       |   |               |   |           
    |       |   |               |   +---login
    |       |   |               |   |       LoginActivity.kt
    |       |   |               |   |       LoginModel.kt
    |       |   |               |   |       LoginViewModel.kt
    |       |   |               |   |       
    |       |   |               |   +---registrasi
    |       |   |               |   |   |   TypeAccountActivity.kt
    |       |   |               |   |   |   
    |       |   |               |   |   \---registrasi_private_user
    |       |   |               |   |       |   PrivateRegisterActivity.kt
    |       |   |               |   |       |   
    |       |   |               |   |       +---private_choose_animal
    |       |   |               |   |       |       PrivateChooseAnimalFragment.kt
    |       |   |               |   |       |       PrivateChooseAnimalFragmentAdapter.kt
    |       |   |               |   |       |       PrivateChooseAnimalFragmentProvider.kt
    |       |   |               |   |       |       PrivateChooseAnimalFragmentViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_animal
    |       |   |               |   |       |       PrivateInsertAnimalFragment.kt
    |       |   |               |   |       |       PrivateInsertAnimalFragmentAdapter.kt
    |       |   |               |   |       |       PrivateInsertAnimalFragmentProvider.kt
    |       |   |               |   |       |       PrivateInsertAnimalFragmentViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_birth
    |       |   |               |   |       |       PrivateInsertBirthFragment.kt
    |       |   |               |   |       |       PrivateInsertBirthFragmentModule.kt
    |       |   |               |   |       |       PrivateInsertBirthFragmentProvider.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_email
    |       |   |               |   |       |       PrivateInsertEmailFragment.kt
    |       |   |               |   |       |       PrivateInsertEmailFragmentProvider.kt
    |       |   |               |   |       |       PrivateInsertEmailFragmentViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_gender
    |       |   |               |   |       |       PrivateInsertGenderFragment.kt
    |       |   |               |   |       |       PrivateInsertGenderFragmentModule.kt
    |       |   |               |   |       |       PrivateInsertGenderFragmentProvider.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_name
    |       |   |               |   |       |       PrivateInsertNameFragment.kt
    |       |   |               |   |       |       PrivateInsertNameFragmentModule.kt
    |       |   |               |   |       |       PrivateInsertNameFragmentProvider.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_number
    |       |   |               |   |       |       PrivateInsertNumberFragment.kt
    |       |   |               |   |       |       PrivateInsertNumberProvider.kt
    |       |   |               |   |       |       PrivateInsertNumberViewModels.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_insert_password
    |       |   |               |   |       |       PrivateInsertPasswordFragment.kt
    |       |   |               |   |       |       PrivateInsertPasswordProviders.kt
    |       |   |               |   |       |       PrivateInsertPasswordViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_photo_profil
    |       |   |               |   |       |       PrivateProfilActivity.kt
    |       |   |               |   |       |       PrivateProfilViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       +---private_verify
    |       |   |               |   |       |       PrivateVerifyFragment.kt
    |       |   |               |   |       |       PrivateVerifyProviders.kt
    |       |   |               |   |       |       PrivateVerifyViewModel.kt
    |       |   |               |   |       |       
    |       |   |               |   |       \---welcome_activity
    |       |   |               |   |               PrivateWelcomeActivity.kt
    |       |   |               |   |               PrivateWelcomeViewModel.kt
    |       |   |               |   |               
    |       |   |               |   +---settings
    |       |   |               |   |   |   DashboardSettingsFragment.kt
    |       |   |               |   |   |   DashboardSettingsFragmentModule.kt
    |       |   |               |   |   |   DashboardSettingsFragmentProvider.kt
    |       |   |               |   |   |   
    |       |   |               |   |   +---acount_settings
    |       |   |               |   |   |   |   AccountSettingsFragment.kt
    |       |   |               |   |   |   |   AccountSettingsProvider.kt
    |       |   |               |   |   |   |   
    |       |   |               |   |   |   +---acount_privacy
    |       |   |               |   |   |   |       SettingAccountPrivacyFragment.kt
    |       |   |               |   |   |   |       SettingAccountPrivacyFragmentModule.kt
    |       |   |               |   |   |   |       SettingAccountPrivacyFragmentprovider.kt
    |       |   |               |   |   |   |       
    |       |   |               |   |   |   +---change_password
    |       |   |               |   |   |   |       ChangePasswordFragment.kt
    |       |   |               |   |   |   |       ChangePasswordFragmentModule.kt
    |       |   |               |   |   |   |       ChangePasswordFragmentProvider.kt
    |       |   |               |   |   |   |       ChangePasswordViewModel.kt
    |       |   |               |   |   |   |       
    |       |   |               |   |   |   \---language
    |       |   |               |   |   |           SettingLanguageAdapter.kt
    |       |   |               |   |   |           SettingLanguageFragment.kt
    |       |   |               |   |   |           SettingLanguageFragmentModule.kt
    |       |   |               |   |   |           SettingLanguageFragmentProvider.kt
    |       |   |               |   |   |           SettingLanguageModel.kt
    |       |   |               |   |   |           
    |       |   |               |   |   +---notification
    |       |   |               |   |   |       NotificationSettingsFragment.kt
    |       |   |               |   |   |       
    |       |   |               |   |   \---privacy_policy
    |       |   |               |   |           PrivacyPolicyFragment.kt
    |       |   |               |   |           
    |       |   |               |   \---user_private
    |       |   |               |       |   MainPrivateActivity.kt
    |       |   |               |       |   MainPrivateActivityViewModel.kt
    |       |   |               |       |   SearchSuggestionAdapter.kt
    |       |   |               |       |   
    |       |   |               |       +---comment
    |       |   |               |       |       FeedPostShowCommentActivity.kt
    |       |   |               |       |       
    |       |   |               |       +---home
    |       |   |               |       |   |   DashboardHomeFragmentAdapter.kt
    |       |   |               |       |   |   DashboarHomeFragment.kt
    |       |   |               |       |   |   DashboarHomeProviders.kt
    |       |   |               |       |   |   DashboarHomeViewModel.kt
    |       |   |               |       |   |   
    |       |   |               |       |   +---dashboard_global_zona
    |       |   |               |       |   |       GlobalZonaFragment.kt
    |       |   |               |       |   |       GlobalZonaFragmentAdapter.kt
    |       |   |               |       |   |       GlobalZonaFragmentProvider.kt
    |       |   |               |       |   |       GlobalZonaFragmentViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   \---dashboard_my_zona
    |       |   |               |       |           MyZonaFragment.kt
    |       |   |               |       |           MyZonaFragmentAdapter.kt
    |       |   |               |       |           MyZonaFragmentProvider.kt
    |       |   |               |       |           MyZonaFragmentViewModel.kt
    |       |   |               |       |           
    |       |   |               |       +---message
    |       |   |               |       |       ComingSoonMessage.kt
    |       |   |               |       |       
    |       |   |               |       +---notification
    |       |   |               |       |   |   NotificationActivity.kt
    |       |   |               |       |   |   NotificationActivityAdapter.kt
    |       |   |               |       |   |   NotificationAdapter.kt
    |       |   |               |       |   |   NotificationViewModel.kt
    |       |   |               |       |   |   
    |       |   |               |       |   \---tabs_notification
    |       |   |               |       |           GlobalNotificationListFragment.kt
    |       |   |               |       |           MyNotificationListFragment.kt
    |       |   |               |       |           
    |       |   |               |       +---other_user_profil
    |       |   |               |       |   |   OtherUserProfilActivity.kt
    |       |   |               |       |   |   OtherUserProfileSharedViewModels.kt
    |       |   |               |       |   |   OtherUserProfilProviders.kt
    |       |   |               |       |   |   OtherUserProfilViewModel.kt
    |       |   |               |       |   |   
    |       |   |               |       |   +---avatar_detail_user
    |       |   |               |       |   |       AvatarDetailUserActivity.kt
    |       |   |               |       |   |       AvatarDetailUserViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   +---lovers_users
    |       |   |               |       |   |       SearchLoversUsersActivity.kt
    |       |   |               |       |   |       
    |       |   |               |       |   +---lovings_users
    |       |   |               |       |   |       SearchLovingsUsersActivity.kt
    |       |   |               |       |   |       
    |       |   |               |       |   \---tabs_other_user_profil
    |       |   |               |       |       |   ListOtherUserFeedViewModel.kt
    |       |   |               |       |       |   
    |       |   |               |       |       +---grid_feed
    |       |   |               |       |       |       GridOtherUserFeedAdapter.kt
    |       |   |               |       |       |       GridOtherUserFeedFragment.kt
    |       |   |               |       |       |       GridOtherUserFeedProviders.kt
    |       |   |               |       |       |       
    |       |   |               |       |       +---list_feed
    |       |   |               |       |       |       ListOtherUserFeedAdapter.kt
    |       |   |               |       |       |       ListOtherUserFeedFragment.kt
    |       |   |               |       |       |       ListOtherUserFeedProviders.kt
    |       |   |               |       |       |       
    |       |   |               |       |       \---tag_feed
    |       |   |               |       |               TagOtherUserFeedAdapter.kt
    |       |   |               |       |               TagOtherUserFeedFragment.kt
    |       |   |               |       |               TagOtherUserFeedProviders.kt
    |       |   |               |       |               TagOtherUserFeedViewModel.kt
    |       |   |               |       |               
    |       |   |               |       +---post
    |       |   |               |       |   +---edit_post
    |       |   |               |       |   |       EditPostActivity.kt
    |       |   |               |       |   |       EditPostViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   +---insert_post
    |       |   |               |       |   |   |   InsertPostActivity.kt
    |       |   |               |       |   |   |   InsertPostActivityAdapter.kt
    |       |   |               |       |   |   |   InsertPostActivityModel.kt
    |       |   |               |       |   |   |   
    |       |   |               |       |   |   +---camera_fragment
    |       |   |               |       |   |   |       CameraFragment.kt
    |       |   |               |       |   |   |       CameraProviders.kt
    |       |   |               |       |   |   |       
    |       |   |               |       |   |   +---galery_fragment
    |       |   |               |       |   |   |       GaleryFragment.kt
    |       |   |               |       |   |   |       GaleryFragmentAdapter.kt
    |       |   |               |       |   |   |       GaleryFragmentDiffCallback.kt
    |       |   |               |       |   |   |       GaleryFragmentModel.kt
    |       |   |               |       |   |   |       GaleryProviders.kt
    |       |   |               |       |   |   |       GaleryViewModel.kt
    |       |   |               |       |   |   |       
    |       |   |               |       |   |   \---insert_caption_post
    |       |   |               |       |   |           AutoCompleteAdapter.kt
    |       |   |               |       |   |           InsertCaptionPostActivity.kt
    |       |   |               |       |   |           InsertCaptionPostViewModel.kt
    |       |   |               |       |   |           
    |       |   |               |       |   +---list_user_like_post
    |       |   |               |       |   |       ListUserLikesPostActivity.kt
    |       |   |               |       |   |       ListUserLikesPostActivityAdapter.kt
    |       |   |               |       |   |       ListUserLikesPostActivityViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   \---show_post
    |       |   |               |       |           FeedPostDetailActivity.kt
    |       |   |               |       |           FeedPostDetailCommentAdapter.kt
    |       |   |               |       |           FeedPostDetailViewModel.kt
    |       |   |               |       |           
    |       |   |               |       +---profil
    |       |   |               |       |   |   ProfilFragment.kt
    |       |   |               |       |   |   ProfilProviders.kt
    |       |   |               |       |   |   ProfilViewModel.kt
    |       |   |               |       |   |   
    |       |   |               |       |   +---edit_profil
    |       |   |               |       |   |       EditProfilActivity.kt
    |       |   |               |       |   |       EditprofilViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   +---lover_user
    |       |   |               |       |   |       SearchLoversActivity.kt
    |       |   |               |       |   |       SearchLoversActivityAdapter.kt
    |       |   |               |       |   |       SearchLoversActivityViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   +---loving_user
    |       |   |               |       |   |       SearchLovingActivity.kt
    |       |   |               |       |   |       SearchLovingActivityAdapter.kt
    |       |   |               |       |   |       SearchLovingActivityViewModel.kt
    |       |   |               |       |   |       
    |       |   |               |       |   \---tabs_profil_fragment
    |       |   |               |       |       |   ListFeedProfilViewModel.kt
    |       |   |               |       |       |   
    |       |   |               |       |       +---grid_my_feed
    |       |   |               |       |       |       GridFeedProfilAdapter.kt
    |       |   |               |       |       |       GridFeedProfilFragment.kt
    |       |   |               |       |       |       GridFeedProfilProviders.kt
    |       |   |               |       |       |       
    |       |   |               |       |       +---list_my_feed
    |       |   |               |       |       |       ListFeedProfilAdapter.kt
    |       |   |               |       |       |       ListFeedProfilFragment.kt
    |       |   |               |       |       |       ListFeedProfilProviders.kt
    |       |   |               |       |       |       
    |       |   |               |       |       \---tag_feed
    |       |   |               |       |               TagFeedProfilAdapter.kt
    |       |   |               |       |               TagFeedProfilFragment.kt
    |       |   |               |       |               TagFeedProfilProviders.kt
    |       |   |               |       |               TagFeedProfilViewModel.kt
    |       |   |               |       |               
    |       |   |               |       \---search
    |       |   |               |               SearchUserActivity.kt
    |       |   |               |               
    |       |   |               \---utils
    |       |   |                   |   AppConstants.kt
    |       |   |                   |   BindingAdapters.kt
    |       |   |                   |   CameraSetting.kt
    |       |   |                   |   ConnectionLiveData.kt
    |       |   |                   |   ConnectionModel.kt
    |       |   |                   |   CustomeProgressDialog.kt
    |       |   |                   |   Executors.kt
    |       |   |                   |   FragmentTabCallback.kt
    |       |   |                   |   GridDividerDecoration.java
    |       |   |                   |   ListItemClickListener.kt
    |       |   |                   |   Permissions.kt
    |       |   |                   |   PostUtils.kt
    |       |   |                   |   SharedViewModels.kt
    |       |   |                   |   ShowLoadingDialog.kt
    |       |   |                   |   SuccesDialog.kt
    |       |   |                   |   Validation.kt
    |       |   |                   |   Version.kt
    |       |   |                   |   
    |       |   |                   +---extension
    |       |   |                   |       EditText.kt
    |       |   |                   |       ImageView.kt
    |       |   |                   |       Retrofit.kt
    |       |   |                   |       
    |       |   |                   +---listener
    |       |   |                   |       ItemClickSupport.java
    |       |   |                   |       OnDoubleClickListener.java
    |       |   |                   |       
    |       |   |                   \---paging
    |       |   |                           LoadMoreViewHolder.kt
    |       |   |                           NoMoreDataViewHolder.kt
    |       |   |                           PagedListFromArray.kt
    |       |   |                           TypeDataSource.kt
    |       |   |                           TypeListProvider.kt
    |       |   |                           
    |       |   \---res
    |       |       +---anim
    |       |       |       slide_in_left.xml
    |       |       |       slide_in_right.xml
    |       |       |       slide_out_left.xml
    |       |       |       slide_out_right.xml
    |       |       |       
    |       |       +---color
    |       |       |       pin_line_colors.xml
    |       |       |       text_colors.xml
    |       |       |       
    |       |       +---drawable
    |       |       |       acount_settings.png
    |       |       |       at_16.png
    |       |       |       avatar_profil.png
    |       |       |       avatar_profil2.png
    |       |       |       background_btn_capture.xml
    |       |       |       background_gradient_img.png
    |       |       |       background_notification.xml
    |       |       |       background_rectangle.xml
    |       |       |       background_rectangle_black.xml
    |       |       |       background_rectangle_green_bigradius.xml
    |       |       |       background_rectangle_in_green.xml
    |       |       |       background_search.xml
    |       |       |       background_spinner.xml
    |       |       |       backgrund_gradients.xml
    |       |       |       badge_background.xml
    |       |       |       btn_rounded_circle_white.xml
    |       |       |       button_shape_rectangle.xml
    |       |       |       camera_switch_white.png
    |       |       |       card_edge.xml
    |       |       |       checkbox_checked.xml
    |       |       |       checkbox_rounded.xml
    |       |       |       checkbox_unchecked.xml
    |       |       |       circle_shape.xml
    |       |       |       circle_shape_grey.xml
    |       |       |       circle_shape_grey_unselected_photo.xml
    |       |       |       circle_shape_no_border.xml
    |       |       |       circle_shape_shimmer.xml
    |       |       |       default_avatar.png
    |       |       |       egg.png
    |       |       |       fire.png
    |       |       |       gallery_white.png
    |       |       |       gender_man.xml
    |       |       |       gender_woman.xml
    |       |       |       group.png
    |       |       |       group_520.png
    |       |       |       icon_response.png
    |       |       |       ic_add_green_24dp.xml
    |       |       |       ic_angry.xml
    |       |       |       ic_arrow_back_black_24dp.xml
    |       |       |       ic_arrow_drop_down_black_24dp.xml
    |       |       |       ic_arrow_drop_down_white.xml
    |       |       |       ic_check_white_24dp.xml
    |       |       |       ic_close_black_24dp.xml
    |       |       |       ic_close_white_24dp.xml
    |       |       |       ic_cool.xml
    |       |       |       ic_edit.xml
    |       |       |       ic_edit_grey.xml
    |       |       |       ic_embarrassed.xml
    |       |       |       ic_expand_more_black_24dp.xml
    |       |       |       ic_favorite_black_24dp.xml
    |       |       |       ic_favorite_border_black_24dp.xml
    |       |       |       ic_favorite_mini.xml
    |       |       |       ic_favorite_white_24dp.xml
    |       |       |       ic_gallery.xml
    |       |       |       ic_grid_on_black_24dp.xml
    |       |       |       ic_happy.xml
    |       |       |       ic_heart.xml
    |       |       |       ic_heartbroken.xml
    |       |       |       ic_in_love.xml
    |       |       |       ic_kissing.xml
    |       |       |       ic_launcher_background.xml
    |       |       |       ic_left.xml
    |       |       |       ic_location_city_black_24dp.xml
    |       |       |       ic_location_on_black_24dp.xml
    |       |       |       ic_lock_black_24dp.xml
    |       |       |       ic_mail_black_24dp.xml
    |       |       |       ic_person_black_24dp.xml
    |       |       |       ic_person_white_24dp.xml
    |       |       |       ic_photo_camera.xml
    |       |       |       ic_photo_camera_black_24dp.xml
    |       |       |       ic_photo_galery_32dp.xml
    |       |       |       ic_sad.xml
    |       |       |       ic_search_green_24dp.xml
    |       |       |       ic_send.xml
    |       |       |       ic_sick.xml
    |       |       |       ic_smart.xml
    |       |       |       ic_smiling_emoticon_square_face.xml
    |       |       |       ic_star_gold_24dp.xml
    |       |       |       ic_surprised.xml
    |       |       |       ic_switch_24dp.xml
    |       |       |       ic_tag.xml
    |       |       |       ic_tag_news.xml
    |       |       |       ic_tick.xml
    |       |       |       ic_tongue_out.xml
    |       |       |       ic_turned_in_not_black_24dp.xml
    |       |       |       ic_unhappy.xml
    |       |       |       ic_view_list_black_24dp.xml
    |       |       |       img_shot.png
    |       |       |       invertebrates.png
    |       |       |       kick.png
    |       |       |       kick2.png
    |       |       |       kick3.png
    |       |       |       main_logo_zonapets.png
    |       |       |       more_button.png
    |       |       |       notif.png
    |       |       |       notif_flat.png
    |       |       |       sample_kelinci.jpg
    |       |       |       settings.png
    |       |       |       setting_background.png
    |       |       |       shadow.xml
    |       |       |       welcome_to.png
    |       |       |       welcome_to_mini.png
    |       |       |       zonapets_logo.png
    |       |       |       zona_shop_logo.png
    |       |       |       
    |       |       +---drawable-hdpi
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       comment_icon_backup.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       likee_backup.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       translate.png
    |       |       |       
    |       |       +---drawable-ldpi
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       to.png
    |       |       |       translate.png
    |       |       |       
    |       |       +---drawable-mdpi
    |       |       |       ac.png
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       to.png
    |       |       |       translate.png
    |       |       |       
    |       |       +---drawable-v24
    |       |       |       circle_shape_red.xml
    |       |       |       ic_edit_grey_mini.xml
    |       |       |       ic_launcher_foreground.xml
    |       |       |       other_message_shape.xml
    |       |       |       
    |       |       +---drawable-xhdpi
    |       |       |       ac.png
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       comment_icon_backup.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       likee_backup.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       to.png
    |       |       |       translate.png
    |       |       |       
    |       |       +---drawable-xxhdpi
    |       |       |       ac.png
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       comment_icon_backup.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       likee_backup.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       to.png
    |       |       |       translate.png
    |       |       |       
    |       |       +---drawable-xxxhdpi
    |       |       |       ac.png
    |       |       |       camera_switch_white.png
    |       |       |       comment_icon.png
    |       |       |       comment_icon_backup.png
    |       |       |       home.png
    |       |       |       ic_image_empty.png
    |       |       |       ic_notif_grey.png
    |       |       |       ic_settings.png
    |       |       |       likee.png
    |       |       |       likee_backup.png
    |       |       |       logout.png
    |       |       |       pet_shield.png
    |       |       |       privacy_policy.png
    |       |       |       search.png
    |       |       |       settaccount.png
    |       |       |       to.png
    |       |       |       translate.png
    |       |       |       welcome_to.png
    |       |       |       zonapets_logo.png
    |       |       |       
    |       |       +---layout
    |       |       |       actionbar_notification.xml
    |       |       |       activity_avatar_detail_user.xml
    |       |       |       activity_camera.xml
    |       |       |       activity_camera1_api.xml
    |       |       |       activity_camera2_api.xml
    |       |       |       activity_coming_soon_message.xml
    |       |       |       activity_crop_photo.xml
    |       |       |       activity_edit_post.xml
    |       |       |       activity_edit_profil.xml
    |       |       |       activity_feed_post_detail.xml
    |       |       |       activity_feed_post_show_comment.xml
    |       |       |       activity_forgot_password.xml
    |       |       |       activity_forgot_password_email.xml
    |       |       |       activity_forgot_password_numberphone.xml
    |       |       |       activity_galery.xml
    |       |       |       activity_insert_caption_post.xml
    |       |       |       activity_insert_post.xml
    |       |       |       activity_list_user_likes_post.xml
    |       |       |       activity_login.xml
    |       |       |       activity_main.xml
    |       |       |       activity_notification.xml
    |       |       |       activity_other_user_profil.xml
    |       |       |       activity_private_register.xml
    |       |       |       activity_reset_password.xml
    |       |       |       activity_search_lovers.xml
    |       |       |       activity_search_lovers_users.xml
    |       |       |       activity_search_loving.xml
    |       |       |       activity_search_lovings_users.xml
    |       |       |       activity_search_shop.xml
    |       |       |       activity_search_user.xml
    |       |       |       activity_search_user_business_medic.xml
    |       |       |       activity_splash.xml
    |       |       |       activity_terms_and_policies.xml
    |       |       |       activity_type_account.xml
    |       |       |       activity_verify_pin.xml
    |       |       |       app_bar_main.xml
    |       |       |       card_activity_galery.xml
    |       |       |       card_private_insert_animal.xml
    |       |       |       content_event.xml
    |       |       |       dialog_confirm_photo.xml
    |       |       |       dialog_delete.xml
    |       |       |       dialog_emoji_sticker.xml
    |       |       |       dialog_progress.xml
    |       |       |       dialog_rating_zona_hotel.xml
    |       |       |       dialog_show_permission.xml
    |       |       |       dialog_success.xml
    |       |       |       dialog_thank_you_assessment.xml
    |       |       |       dialog_time_picker.xml
    |       |       |       end_of_file.xml
    |       |       |       fragments_setting_account_privacy.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_camera.xml
    |       |       |       fragment_change_password.xml
    |       |       |       fragment_comfirmasi_email.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_dashboar_home.xml
    |       |       |       fragment_forgot_password_email.xml
    |       |       |       fragment_galery.xml
    |       |       |       fragment_global_notification_list.xml
    |       |       |       fragment_global_zona.xml
    |       |       |       fragment_grid_feed_profil.xml
    |       |       |       fragment_grid_other_user_feed.xml
    |       |       |       fragment_list_feed_profil.xml
    |       |       |       fragment_list_other_user_feed.xml
    |       |       |       fragment_my_notification_list.xml
    |       |       |       fragment_my_zona.xml
    |       |       |       fragment_notification_setting.xml
    |       |       |       fragment_privacy_policy.xml
    |       |       |       fragment_private_choose_animal.xml
    |       |       |       fragment_private_insert_animal.xml
    |       |       |       fragment_private_insert_birth.xml
    |       |       |       fragment_private_insert_email.xml
    |       |       |       fragment_private_insert_gender.xml
    |       |       |       fragment_private_insert_name.xml
    |       |       |       fragment_private_insert_number.xml
    |       |       |       fragment_private_insert_password.xml
    |       |       |       fragment_private_profil.xml
    |       |       |       fragment_private_verify_password.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       fragment_profil.xml
    |       |       |       fragment_reset_password_from_link.xml
    |       |       |       fragment_setting_language.xml
    |       |       |       fragment_show_loading_dialog.xml
    |       |       |       fragment_tag_feed_profil.xml
    |       |       |       fragment_tag_other_user_feed.xml
    |       |       |       fragment_type_forgot_password.xml
    |       |       |       include_layout_comment.xml
    |       |       |       include_profil_bio.xml
    |       |       |       include_profil_bio_shimmer.xml
    |       |       |       inlude_profil_followers.xml
    |       |       |       itemchooseanimal.xml
    |       |       |       item_animal.xml
    |       |       |       item_drawer_image_list.xml
    |       |       |       item_facility.xml
    |       |       |       item_feed_detail.xml
    |       |       |       item_feed_home.xml
    |       |       |       item_feed_home_for_shimmer.xml
    |       |       |       item_gallery_zona_hotel.xml
    |       |       |       item_grid_feed_home.xml
    |       |       |       item_grid_globalzona.xml
    |       |       |       item_group.xml
    |       |       |       item_header_drawer_bussines.xml
    |       |       |       item_header_drawer_private.xml
    |       |       |       item_image_galery.xml
    |       |       |       item_image_galery_choose_foto.xml
    |       |       |       item_image_galery_delete_foto.xml
    |       |       |       item_inside_fab_layout.xml
    |       |       |       item_list_comment.xml
    |       |       |       item_list_group.xml
    |       |       |       item_list_language.xml
    |       |       |       item_list_user.xml
    |       |       |       item_list_user_likes.xml
    |       |       |       item_list_user_lovers.xml
    |       |       |       item_list_user_lovers_shimmer.xml
    |       |       |       item_list_user_search.xml
    |       |       |       item_notification_admin.xml
    |       |       |       item_notification_list.xml
    |       |       |       item_notification_list_shimmer.xml
    |       |       |       item_product_admin.xml
    |       |       |       item_product_assessment.xml
    |       |       |       item_rating_admin.xml
    |       |       |       item_zona_hotel.xml
    |       |       |       layout_connection.xml
    |       |       |       network_state_item.xml
    |       |       |       switch_to_medic.xml
    |       |       |       toolbar.xml
    |       |       |       
    |       |       +---layout-hdpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---layout-ldpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---layout-mdpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---layout-xhdpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---layout-xxhdpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---layout-xxxhdpi
    |       |       |       activity_login.xml
    |       |       |       fragment_account_settings.xml
    |       |       |       fragment_dashboard_settings.xml
    |       |       |       fragment_private_welcome.xml
    |       |       |       
    |       |       +---menu
    |       |       |       detail_product_menu.xml
    |       |       |       drawer_private_menu.xml
    |       |       |       drawe_bussines_menu.xml
    |       |       |       edit_profil.xml
    |       |       |       gender_menu.xml
    |       |       |       group_menu.xml
    |       |       |       material_search.xml
    |       |       |       menu_detail.xml
    |       |       |       menu_detail_gallery.xml
    |       |       |       menu_hotel.xml
    |       |       |       menu_medic.xml
    |       |       |       menu_report.xml
    |       |       |       menu_shop.xml
    |       |       |       notification_menu.xml
    |       |       |       user_menu.xml
    |       |       |       
    |       |       +---mipmap-anydpi-v26
    |       |       |       ic_launcher.xml
    |       |       |       ic_launcher_round.xml
    |       |       |       
    |       |       +---mipmap-hdpi
    |       |       |       ic_launcher.png
    |       |       |       ic_launcher_round.png
    |       |       |       
    |       |       +---mipmap-mdpi
    |       |       |       ic_launcher.png
    |       |       |       ic_launcher_round.png
    |       |       |       
    |       |       +---mipmap-xhdpi
    |       |       |       ic_launcher.png
    |       |       |       ic_launcher_round.png
    |       |       |       
    |       |       +---mipmap-xxhdpi
    |       |       |       ic_launcher.png
    |       |       |       ic_launcher_round.png
    |       |       |       
    |       |       +---mipmap-xxxhdpi
    |       |       |       ic_launcher.png
    |       |       |       ic_launcher_round.png
    |       |       |       
    |       |       +---navigation
    |       |       |       navigation_forgot_password.xml
    |       |       |       navigation_home_private.xml
    |       |       |       navigation_register_private.xml
    |       |       |       
    |       |       +---values
    |       |       |       anim.xml
    |       |       |       attrs.xml
    |       |       |       colors.xml
    |       |       |       dimens.xml
    |       |       |       ids.xml
    |       |       |       strings.xml
    |       |       |       styles.xml
    |       |       |       
    |       |       +---values-in
    |       |       |       strings.xml
    |       |       |       
    |       |       +---values-xxhdpi
    |       |       \---xml
    |       |               file_paths.xml
```


License
----


** 107 company**

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

