# SampleBank App
An example of a fictional banking App that utilizes some of the hotest stuff on Android/Kotlin for this moment.

# Description
I worked on this App to implement Android's new architecture features for building Android mobile Apps and improve my skills and self-confidence along the way.

# Requirements
*   [Android Studio 2020.3.1 Patch 3](https://developer.android.com/studio) and above.
*   Android minSdkVersion 21.
*   Kotlin

# Features
*   Implementation of android [MVVM Architecture Pattern](https://developer.android.com/jetpack/guide).
*   Data single source of truth implementation and google suggested practice for code separation using Repository Architecture.
*   Functional programming implementation by observing to data changes with [LiveData](https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/index.html#5).
*   Using [ViewModel](https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/index.html#8) to serve as the bridge between datasource and UI. ViewModel implementation also makes sure data is not lost during configurations changes as its lifecycle aware.
*   Data persistance with [Room](https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/index.html#6).
*   Managing of asynchronous calls using [Kotlin Coroutines](https://codelabs.developers.google.com/codelabs/kotlin-coroutines/#0).
*   Display list with [RecyclerView](https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view/index.html#0) and data binding.


# Testing
TBA

## Screenshots
 <table>
  <tr>
     <td>Login Screen</td>
     <td>Main Screen</td>
  </tr>
  <tr>
    <td><img src="https://raw.githubusercontent.com/bielfernandezb/SampleBankApp/main/screenshots/Screenshot_1639076158.png" width=250 height=480></td>
    <td><img src="https://raw.githubusercontent.com/bielfernandezb/SampleBankApp/main/screenshots/Screenshot_1639076164.png" width=250 height=480></td>
  </tr>
 </table>
