* Build a Spring Boot Web application __(lab03-app)__ that takes the name of the movie as input

* The movie name is pushed to a Queue __q-movie-input__

* Another service(__lab03-movie-service__) will continuously poll for new entries in the Queue __q-movie__ and pass them on to __**http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=<moviename>**__ (Read the documentation for JSON response you get) and fetch the star cast and directors information
* For example go to __http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=Dabangg__

* The movie output is stored in another Queue say __q-movie-output__
* If you get an error while talking to the OmdbApi or get a response like this
```
{
 Response: "False",
 Error: "Movie not found!"
}
```

* Post the movie to another Queue say __q-movie-error__

* __(lab03-app)__ listens to __q-movie-output__ collects the details and maintains it in a local cache
* It has an endpoint (__/details__) that displays all the movie details you have requested so far. Everytime you hit the endpoint __/details__ it displays list of all movies and their details
* An endpoint __/errorlist__ will display the list of errors of the movies

* Design a topic exchange with the following routing keys
* __movie__, __movie.details__, __movie.error__
