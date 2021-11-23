# Movie App
Simple news app written in Kotlin and using MVVM architecture that consults the public news API.

## Screenshots
<p float="left">
<img src="https://github.com/micaelagimenez/newsApp/blob/main/screenshots/main.jpg" width="250" height="450">
<img src="https://github.com/micaelagimenez/newsApp/blob/main/screenshots/detail.jpg" width="250" height="450"><br>
<img src="https://github.com/micaelagimenez/newsApp/blob/main/screenshots/fav.jpg" width="250" height="450">
</p>

## Structure
### Main Activity
Displays a list of the latest popular news with their titles and images. News can be selected to access their details in a new fragment.
### News details
Fragment that shows the clicked news on main activity's details.
### Favorite news
Fragment that shows the user's favorite news that are kept in a room database.

 ## Libraries Used
 <ul>
 <li> <a href="https://developer.android.com/topic/libraries/data-binding/">Data Binding</a> </li>
 <li> <a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a> </li>
 <li> <a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a> </li>
 <li> <a href="http://square.github.io/retrofit/">Retrofit</a> </li>
 <li> <a href="http://square.github.io/picasso/">Picasso</a> </li>
 <li> <a href="http://square.github.io/okhttp/">OkHttp3</a> </li>
 <li> <a href="https://github.com/zhanghai/MaterialRatingBar">MaterialRatingBar</a> </li>
 <li> <a href="https://developer.android.com/training/data-storage/room">Room</a> </li>
 </ul>
