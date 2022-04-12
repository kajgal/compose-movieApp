package com.example.movieapp.data

import com.example.movieapp.models.MovieItem
import com.google.gson.Gson

object MoviesSource {

    private val filmsJSON = "[\n" +
            "  {\n" +
            "    \"Title\": \"Avatar\",\n" +
            "    \"Year\": \"2009\",\n" +
            "    \"Rated\": \"PG-13\",\n" +
            "    \"Released\": \"18 Dec 2009\",\n" +
            "    \"Runtime\": \"162 min\",\n" +
            "    \"Genre\": \"Action, Adventure, Fantasy\",\n" +
            "    \"Director\": \"James Cameron\",\n" +
            "    \"Writer\": \"James Cameron\",\n" +
            "    \"Actors\": \"Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang\",\n" +
            "    \"Plot\": \"A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.\",\n" +
            "    \"Language\": \"English, Spanish\",\n" +
            "    \"Country\": \"USA, UK\",\n" +
            "    \"Awards\": \"Won 3 Oscars. Another 80 wins & 121 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"83\",\n" +
            "    \"imdbRating\": \"7.9\",\n" +
            "    \"imdbVotes\": \"890,617\",\n" +
            "    \"imdbID\": \"tt0499549\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2ODQ3NjMyMl5BMl5BanBnXkFtZTcwODg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxOTEwNDcxN15BMl5BanBnXkFtZTcwOTg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMDg1Nzk1MV5BMl5BanBnXkFtZTcwMDk0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"I Am Legend\",\n" +
            "    \"Year\": \"2007\",\n" +
            "    \"Rated\": \"PG-13\",\n" +
            "    \"Released\": \"14 Dec 2007\",\n" +
            "    \"Runtime\": \"101 min\",\n" +
            "    \"Genre\": \"Drama, Horror, Sci-Fi\",\n" +
            "    \"Director\": \"Francis Lawrence\",\n" +
            "    \"Writer\": \"Mark Protosevich (screenplay), Akiva Goldsman (screenplay), Richard Matheson (novel), John William Corrington, Joyce Hooper Corrington\",\n" +
            "    \"Actors\": \"Will Smith, Alice Braga, Charlie Tahan, Salli Richardson-Whitfield\",\n" +
            "    \"Plot\": \"Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"9 wins & 21 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTU4NzMyNDk1OV5BMl5BanBnXkFtZTcwOTEwMzU1MQ@@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"65\",\n" +
            "    \"imdbRating\": \"7.2\",\n" +
            "    \"imdbVotes\": \"533,874\",\n" +
            "    \"imdbID\": \"tt0480249\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTI0NTI4NjE3NV5BMl5BanBnXkFtZTYwMDA0Nzc4._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTIwMDg2MDU4M15BMl5BanBnXkFtZTYwMTA0Nzc4._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MDM1OTU5OV5BMl5BanBnXkFtZTYwMjA0Nzc4._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0MTI2NjMzMzFeQTJeQWpwZ15BbWU2MDMwNDc3OA@@._V1_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"300\",\n" +
            "    \"Year\": \"2006\",\n" +
            "    \"Rated\": \"R\",\n" +
            "    \"Released\": \"09 Mar 2007\",\n" +
            "    \"Runtime\": \"117 min\",\n" +
            "    \"Genre\": \"Action, Drama, Fantasy\",\n" +
            "    \"Director\": \"Zack Snyder\",\n" +
            "    \"Writer\": \"Zack Snyder (screenplay), Kurt Johnstad (screenplay), Michael Gordon (screenplay), Frank Miller (graphic novel), Lynn Varley (graphic novel)\",\n" +
            "    \"Actors\": \"Gerard Butler, Lena Headey, Dominic West, David Wenham\",\n" +
            "    \"Plot\": \"King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"16 wins & 42 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMjAzNTkzNjcxNl5BMl5BanBnXkFtZTYwNDA4NjE3._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"52\",\n" +
            "    \"imdbRating\": \"7.7\",\n" +
            "    \"imdbVotes\": \"611,046\",\n" +
            "    \"imdbID\": \"tt0416449\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMwNTg5MzMwMV5BMl5BanBnXkFtZTcwMzA2NTIyMw@@._V1_SX1777_CR0,0,1777,937_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQwNTgyNTMzNF5BMl5BanBnXkFtZTcwNDA2NTIyMw@@._V1_SX1777_CR0,0,1777,935_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MjQzOTEwMV5BMl5BanBnXkFtZTcwMzE2NTIyMw@@._V1_SX1777_CR0,0,1777,947_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"The Avengers\",\n" +
            "    \"Year\": \"2012\",\n" +
            "    \"Rated\": \"PG-13\",\n" +
            "    \"Released\": \"04 May 2012\",\n" +
            "    \"Runtime\": \"143 min\",\n" +
            "    \"Genre\": \"Action, Sci-Fi, Thriller\",\n" +
            "    \"Director\": \"Joss Whedon\",\n" +
            "    \"Writer\": \"Joss Whedon (screenplay), Zak Penn (story), Joss Whedon (story)\",\n" +
            "    \"Actors\": \"Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth\",\n" +
            "    \"Plot\": \"Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.\",\n" +
            "    \"Language\": \"English, Russian\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Nominated for 1 Oscar. Another 34 wins & 75 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"69\",\n" +
            "    \"imdbRating\": \"8.1\",\n" +
            "    \"imdbVotes\": \"1,003,301\",\n" +
            "    \"imdbID\": \"tt0848228\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "     \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjE1MzEzMjcyM15BMl5BanBnXkFtZTcwNDM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMwMzM2MTg1M15BMl5BanBnXkFtZTcwNjM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4NzM2Mjc5MV5BMl5BanBnXkFtZTcwMTkwOTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3MzQ3NjA5N15BMl5BanBnXkFtZTcwMzY5OTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"The Wolf of Wall Street\",\n" +
            "    \"Year\": \"2013\",\n" +
            "    \"Rated\": \"R\",\n" +
            "    \"Released\": \"25 Dec 2013\",\n" +
            "    \"Runtime\": \"180 min\",\n" +
            "    \"Genre\": \"Biography, Comedy, Crime\",\n" +
            "    \"Director\": \"Martin Scorsese\",\n" +
            "    \"Writer\": \"Terence Winter (screenplay), Jordan Belfort (book)\",\n" +
            "    \"Actors\": \"Leonardo DiCaprio, Jonah Hill, Margot Robbie, Matthew McConaughey\",\n" +
            "    \"Plot\": \"Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.\",\n" +
            "    \"Language\": \"English, French\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Nominated for 5 Oscars. Another 35 wins & 154 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"75\",\n" +
            "    \"imdbRating\": \"8.2\",\n" +
            "    \"imdbVotes\": \"786,985\",\n" +
            "    \"imdbID\": \"tt0993846\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNDIwMDIxNzk3Ml5BMl5BanBnXkFtZTgwMTg0MzQ4MDE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0NzAxODAyMl5BMl5BanBnXkFtZTgwMDg0MzQ4MDE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTExMDk1MDE4NzVeQTJeQWpwZ15BbWU4MDM4NDM0ODAx._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg3MTY4NDk4Nl5BMl5BanBnXkFtZTgwNjc0MzQ4MDE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTgzMTg4MDI0Ml5BMl5BanBnXkFtZTgwOTY0MzQ4MDE@._V1_SY1000_CR0,0,1553,1000_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Interstellar\",\n" +
            "    \"Year\": \"2014\",\n" +
            "    \"Rated\": \"PG-13\",\n" +
            "    \"Released\": \"07 Nov 2014\",\n" +
            "    \"Runtime\": \"169 min\",\n" +
            "    \"Genre\": \"Adventure, Drama, Sci-Fi\",\n" +
            "    \"Director\": \"Christopher Nolan\",\n" +
            "    \"Writer\": \"Jonathan Nolan, Christopher Nolan\",\n" +
            "    \"Actors\": \"Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow\",\n" +
            "    \"Plot\": \"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA, UK\",\n" +
            "    \"Awards\": \"Won 1 Oscar. Another 39 wins & 134 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"74\",\n" +
            "    \"imdbRating\": \"8.6\",\n" +
            "    \"imdbVotes\": \"937,412\",\n" +
            "    \"imdbID\": \"tt0816692\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3NTEwOTMxMV5BMl5BanBnXkFtZTgwMjMyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMzQ5ODE2MzEwM15BMl5BanBnXkFtZTgwMTMyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg4Njk4MzY0Nl5BMl5BanBnXkFtZTgwMzIyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMzE3MTM0MTc3Ml5BMl5BanBnXkFtZTgwMDIyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNjYzNjE2NDk3N15BMl5BanBnXkFtZTgwNzEyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Game of Thrones\",\n" +
            "    \"Year\": \"2011–\",\n" +
            "    \"Rated\": \"TV-MA\",\n" +
            "    \"Released\": \"17 Apr 2011\",\n" +
            "    \"Runtime\": \"56 min\",\n" +
            "    \"Genre\": \"Adventure, Drama, Fantasy\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"David Benioff, D.B. Weiss\",\n" +
            "    \"Actors\": \"Peter Dinklage, Lena Headey, Emilia Clarke, Kit Harington\",\n" +
            "    \"Plot\": \"While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA, UK\",\n" +
            "    \"Awards\": \"Won 1 Golden Globe. Another 185 wins & 334 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMjM5OTQ1MTY5Nl5BMl5BanBnXkFtZTgwMjM3NzMxODE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"9.5\",\n" +
            "    \"imdbVotes\": \"1,046,830\",\n" +
            "    \"imdbID\": \"tt0944947\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"7\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNDc1MGUyNzItNWRkOC00MjM1LWJjNjMtZTZlYWIxMGRmYzVlXkEyXkFqcGdeQXVyMzU3MDEyNjk@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BZjZkN2M5ODgtMjQ2OC00ZjAxLWE1MjMtZDE0OTNmNGM0NWEwXkEyXkFqcGdeQXVyNjUxNzgwNTE@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMDk4Y2Y1MDAtNGVmMC00ZTlhLTlmMmQtYjcyN2VkNzUzZjg2XkEyXkFqcGdeQXVyNjUxNzgwNTE@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNjZjNWIzMzQtZWZjYy00ZTkwLWJiMTYtOWRkZDBhNWJhY2JmXkEyXkFqcGdeQXVyMjk3NTUyOTc@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNTMyMTRjZWEtM2UxMS00ZjU5LWIxMTYtZDA5YmJhZmRjYTc4XkEyXkFqcGdeQXVyMjk3NTUyOTc@._V1_SX1777_CR0,0,1777,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Vikings\",\n" +
            "    \"Year\": \"2013–\",\n" +
            "    \"Rated\": \"TV-14\",\n" +
            "    \"Released\": \"03 Mar 2013\",\n" +
            "    \"Runtime\": \"44 min\",\n" +
            "    \"Genre\": \"Action, Drama, History\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Michael Hirst\",\n" +
            "    \"Actors\": \"Travis Fimmel, Clive Standen, Gustaf Skarsgård, Katheryn Winnick\",\n" +
            "    \"Plot\": \"The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.\",\n" +
            "    \"Language\": \"English, Old English, Norse, Old, Latin\",\n" +
            "    \"Country\": \"Ireland, Canada\",\n" +
            "    \"Awards\": \"Nominated for 7 Primetime Emmys. Another 17 wins & 49 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BOTEzNzI3MDc0N15BMl5BanBnXkFtZTgwMzk1MzA5NzE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"8.6\",\n" +
            "    \"imdbVotes\": \"198,041\",\n" +
            "    \"imdbID\": \"tt2306299\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"5\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjM5MTM1ODUxNV5BMl5BanBnXkFtZTgwNTAzOTI2ODE@._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNzU2NDcxODMyOF5BMl5BanBnXkFtZTgwNDAzOTI2ODE@._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMzMzIzOTU2M15BMl5BanBnXkFtZTgwODMzMTkyODE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ2NTQ2MDA3NF5BMl5BanBnXkFtZTgwODkxMDUxODE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTcxOTQ3NTA5N15BMl5BanBnXkFtZTgwMzExMDUxODE@._V1_SY1000_SX1500_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Gotham\",\n" +
            "    \"Year\": \"2014–\",\n" +
            "    \"Rated\": \"TV-14\",\n" +
            "    \"Released\": \"01 Aug 2014\",\n" +
            "    \"Runtime\": \"42 min\",\n" +
            "    \"Genre\": \"Action, Crime, Drama\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Bruno Heller\",\n" +
            "    \"Actors\": \"Ben McKenzie, Donal Logue, David Mazouz, Sean Pertwee\",\n" +
            "    \"Plot\": \"The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Nominated for 4 Primetime Emmys. Another 3 wins & 22 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTY2MjMwNDE4OV5BMl5BanBnXkFtZTgwNjI1NjU0OTE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"8.0\",\n" +
            "    \"imdbVotes\": \"133,375\",\n" +
            "    \"imdbID\": \"tt3749900\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"3\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNDI3ODYyODY4OV5BMl5BanBnXkFtZTgwNjE5NDMwMDI@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5OTExMTIwNF5BMl5BanBnXkFtZTgwMjI5NDMwMDI@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTA3MDY2NjA3MzBeQTJeQWpwZ15BbWU4MDU0MDkzODgx._V1_SX1499_CR0,0,1499,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjM3MzYzNDgzOV5BMl5BanBnXkFtZTgwMjQwOTM4ODE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODAyNjk0NF5BMl5BanBnXkFtZTgwODU4MzMyODE@._V1_SY1000_CR0,0,1500,1000_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Power\",\n" +
            "    \"Year\": \"2014–\",\n" +
            "    \"Rated\": \"TV-MA\",\n" +
            "    \"Released\": \"N/A\",\n" +
            "    \"Runtime\": \"50 min\",\n" +
            "    \"Genre\": \"Crime, Drama\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Courtney Kemp Agboh\",\n" +
            "    \"Actors\": \"Omari Hardwick, Joseph Sikora, Andy Bean, Lela Loren\",\n" +
            "    \"Plot\": \"James \\\"Ghost\\\" St. Patrick, a wealthy New York night club owner who has it all, catering for the city's elite and dreaming big, lives a double life as a drug kingpin.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"1 win & 6 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BOTA4NTkzMjUzOF5BMl5BanBnXkFtZTgwNzg5ODkxOTE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"8.0\",\n" +
            "    \"imdbVotes\": \"14,770\",\n" +
            "    \"imdbID\": \"tt3281796\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"3\",\n" +
            "    \"Response\": \"True\",\n" +
            "     \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc2ODg0MzMzM15BMl5BanBnXkFtZTgwODYxODA5NTE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyMjA0MzczNV5BMl5BanBnXkFtZTgwNTIyODA5NTE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTk0MTI0NzQ2NV5BMl5BanBnXkFtZTgwMDkxODA5NTE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4Mzk1ODcxM15BMl5BanBnXkFtZTgwNDQyODA5NTE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwNTE0NDI1M15BMl5BanBnXkFtZTgwMDQyODA5NTE@._V1_SY1000_SX1500_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Narcos\",\n" +
            "    \"Year\": \"2015–\",\n" +
            "    \"Rated\": \"TV-MA\",\n" +
            "    \"Released\": \"28 Aug 2015\",\n" +
            "    \"Runtime\": \"49 min\",\n" +
            "    \"Genre\": \"Biography, Crime, Drama\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Carlo Bernard, Chris Brancato, Doug Miro, Paul Eckstein\",\n" +
            "    \"Actors\": \"Wagner Moura, Boyd Holbrook, Pedro Pascal, Joanna Christie\",\n" +
            "    \"Plot\": \"A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.\",\n" +
            "    \"Language\": \"English, Spanish\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Nominated for 2 Golden Globes. Another 4 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTU0ODQ4NDg2OF5BMl5BanBnXkFtZTgwNzczNTE4OTE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"8.9\",\n" +
            "    \"imdbVotes\": \"118,680\",\n" +
            "    \"imdbID\": \"tt2707408\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"2\",\n" +
            "    \"Response\": \"True\",\n" +
            "     \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTk2MDMzMTc0MF5BMl5BanBnXkFtZTgwMTAyMzA1OTE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjIxMDkyOTEyNV5BMl5BanBnXkFtZTgwNjY3Mjc3OTE@._V1_SY1000_SX1500_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA2NDUwMTU2NV5BMl5BanBnXkFtZTgwNTI1Mzc3OTE@._V1_SY1000_CR0,0,1499,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BODA1NjAyMTQ3Ml5BMl5BanBnXkFtZTgwNjI1Mzc3OTE@._V1_SY1000_CR0,0,1499,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTU0NzQ0OTAwNl5BMl5BanBnXkFtZTgwMDAyMzA1OTE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Title\": \"Breaking Bad\",\n" +
            "    \"Year\": \"2008–2013\",\n" +
            "    \"Rated\": \"TV-14\",\n" +
            "    \"Released\": \"20 Jan 2008\",\n" +
            "    \"Runtime\": \"49 min\",\n" +
            "    \"Genre\": \"Crime, Drama, Thriller\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Vince Gilligan\",\n" +
            "    \"Actors\": \"Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris\",\n" +
            "    \"Plot\": \"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's financial future.\",\n" +
            "    \"Language\": \"English, Spanish\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Won 2 Golden Globes. Another 132 wins & 218 nominations.\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTQ0ODYzODc0OV5BMl5BanBnXkFtZTgwMDk3OTcyMDE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"9.5\",\n" +
            "    \"imdbVotes\": \"889,883\",\n" +
            "    \"imdbID\": \"tt0903747\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"5\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTgyMzI5NDc5Nl5BMl5BanBnXkFtZTgwMjM0MTI2MDE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ2NDkwNDk5NV5BMl5BanBnXkFtZTgwNDM0MTI2MDE@._V1_SY1000_CR0,0,1495,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTM4NDcyNDMzMF5BMl5BanBnXkFtZTgwOTI0MTI2MDE@._V1_SY1000_CR0,0,1495,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTAzMTczMjM3NjFeQTJeQWpwZ15BbWU4MDc1MTI1MzAx._V1_SY1000_CR0,0,1495,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5MTE3MTgwMF5BMl5BanBnXkFtZTgwOTQxMjUzMDE@._V1_SX1500_CR0,0,1500,999_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ComingSoon\": true,\n" +
            "    \"Title\": \"Doctor Strange\",\n" +
            "    \"Year\": \"2016\",\n" +
            "    \"Rated\": \"N/A\",\n" +
            "    \"Released\": \"04 Nov 2016\",\n" +
            "    \"Runtime\": \"N/A\",\n" +
            "    \"Genre\": \"Action, Adventure, Fantasy\",\n" +
            "    \"Director\": \"Scott Derrickson\",\n" +
            "    \"Writer\": \"Scott Derrickson (screenplay), C. Robert Cargill (screenplay), Jon Spaihts (story by), Scott Derrickson (story by), C. Robert Cargill (story by), Steve Ditko (comic book)\",\n" +
            "    \"Actors\": \"Rachel McAdams, Benedict Cumberbatch, Mads Mikkelsen, Tilda Swinton\",\n" +
            "    \"Plot\": \"After his career is destroyed, a brilliant but arrogant and conceited surgeon gets a new lease on life when a sorcerer takes him under her wing and trains him to defend the world against evil.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"N/A\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"N/A\",\n" +
            "    \"imdbVotes\": \"N/A\",\n" +
            "    \"imdbID\": \"tt1211837\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjM3ODc1ODI5Ml5BMl5BanBnXkFtZTgwODMzMDY3OTE@._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTgxNTAyNTU0NV5BMl5BanBnXkFtZTgwNzMzMDY3OTE@._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjE5NDc5NzUwNV5BMl5BanBnXkFtZTgwMDM3MDM2NzE@._V1_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ComingSoon\": true,\n" +
            "    \"Title\": \"Rogue One: A Star Wars Story\",\n" +
            "    \"Year\": \"2016\",\n" +
            "    \"Rated\": \"N/A\",\n" +
            "    \"Released\": \"16 Dec 2016\",\n" +
            "    \"Runtime\": \"N/A\",\n" +
            "    \"Genre\": \"Action, Adventure, Sci-Fi\",\n" +
            "    \"Director\": \"Gareth Edwards\",\n" +
            "    \"Writer\": \"Chris Weitz (screenplay), Tony Gilroy (screenplay), John Knoll (story), Gary Whitta (story), George Lucas (characters)\",\n" +
            "    \"Actors\": \"Felicity Jones, Riz Ahmed, Mads Mikkelsen, Ben Mendelsohn\",\n" +
            "    \"Plot\": \"The Rebellion makes a risky move to steal the plans to the Death Star, setting up the epic saga to follow.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"1 nomination.\",\n" +
            "    \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjQyMzI2OTA3OF5BMl5BanBnXkFtZTgwNDg5NjQ0OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"N/A\",\n" +
            "    \"imdbVotes\": \"N/A\",\n" +
            "    \"imdbID\": \"tt3748528\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjE3MzA4Nzk3NV5BMl5BanBnXkFtZTgwNjAxMTc1ODE@._V1_SX1777_CR0,0,1777,744_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNDMxMTQzMjQxM15BMl5BanBnXkFtZTgwNzAxMTc1ODE@._V1_SX1777_CR0,0,1777,744_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTUyNjkxOTk5NV5BMl5BanBnXkFtZTgwODAxMTc1ODE@._V1_SX1777_CR0,0,1777,744_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BNjM4MzExNDAyNl5BMl5BanBnXkFtZTgwOTAxMTc1ODE@._V1_SX1777_CR0,0,1777,744_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjE3NTgxMDcyNV5BMl5BanBnXkFtZTgwMDExMTc1ODE@._V1_SX1777_CR0,0,1777,744_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ComingSoon\": true,\n" +
            "    \"Title\": \"Assassin's Creed\",\n" +
            "    \"Year\": \"2016\",\n" +
            "    \"Rated\": \"N/A\",\n" +
            "    \"Released\": \"21 Dec 2016\",\n" +
            "    \"Runtime\": \"N/A\",\n" +
            "    \"Genre\": \"Action, Adventure, Fantasy\",\n" +
            "    \"Director\": \"Justin Kurzel\",\n" +
            "    \"Writer\": \"Bill Collage (screenplay), Adam Cooper (screenplay), Michael Lesslie (screenplay)\",\n" +
            "    \"Actors\": \"Michael Fassbender, Michael Kenneth Williams, Marion Cotillard, Jeremy Irons\",\n" +
            "    \"Plot\": \"When Callum Lynch explores the memories of his ancestor Aguilar and gains the skills of a Master Assassin, he discovers he is a descendant of the secret Assassins society.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"UK, France, USA, Hong Kong\",\n" +
            "    \"Awards\": \"N/A\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTU2MTQwMjU1OF5BMl5BanBnXkFtZTgwMDA5NjU5ODE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"N/A\",\n" +
            "    \"imdbVotes\": \"N/A\",\n" +
            "    \"imdbID\": \"tt2094766\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BN2EyYzgyOWEtNTY2NS00NjRjLWJiNDYtMWViMjg5MWZjYjgzXkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYwOWYzOTctOTc4My00ZmJkLTgzMTctMmUxNDI5ODQzYzNjXkEyXkFqcGdeQXVyNDAyODU1Njc@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BZTY5ZGUxMTAtYTU0OC00NGQ2LTkzNzgtZGZmNjlmNjY3MGU0XkEyXkFqcGdeQXVyNTY0MTkxMTg@._V1_SY1000_CR0,0,1500,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0MWYwZTEtYzc5Yi00NGM2LTg1YTctNjY2YzQ0NDJhZDAwXkEyXkFqcGdeQXVyNDAyODU1Njc@._V1_SY1000_CR0,0,1499,1000_AL_.jpg\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ComingSoon\": true,\n" +
            "    \"Title\": \"Luke Cage\",\n" +
            "    \"Year\": \"2016–\",\n" +
            "    \"Rated\": \"TV-MA\",\n" +
            "    \"Released\": \"30 Sep 2016\",\n" +
            "    \"Runtime\": \"55 min\",\n" +
            "    \"Genre\": \"Action, Crime, Drama\",\n" +
            "    \"Director\": \"N/A\",\n" +
            "    \"Writer\": \"Cheo Hodari Coker\",\n" +
            "    \"Actors\": \"Mahershala Ali, Mike Colter, Frankie Faison, Erik LaRay Harvey\",\n" +
            "    \"Plot\": \"Given superstrength and durability by a sabotaged experiment, a wrongly accused man escapes prison to become a superhero for hire.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"N/A\",\n" +
            "    \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BMTcyMzc1MjI5MF5BMl5BanBnXkFtZTgwMzE4ODY2OTE@._V1_SX300.jpg\",\n" +
            "    \"Metascore\": \"N/A\",\n" +
            "    \"imdbRating\": \"N/A\",\n" +
            "    \"imdbVotes\": \"N/A\",\n" +
            "    \"imdbID\": \"tt3322314\",\n" +
            "    \"Type\": \"series\",\n" +
            "    \"totalSeasons\": \"1\",\n" +
            "    \"Response\": \"True\",\n" +
            "    \"Images\": [\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxNjc1NjI0NV5BMl5BanBnXkFtZTgwNzA0NzY0ODE@._V1_SY1000_CR0,0,1497,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MDg3NjY2OF5BMl5BanBnXkFtZTgwNDE1NDU4OTE@._V1_SY1000_CR0,0,1497,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BOTYzOTQyNDYxNl5BMl5BanBnXkFtZTgwNzA1NDU4OTE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTgxMjA3MTQ5Ml5BMl5BanBnXkFtZTgwOTA1NDU4OTE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg\",\n" +
            "      \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMyNjg5ODYwNF5BMl5BanBnXkFtZTgwMTE1NDU4OTE@._V1_SY1000_CR0,0,1477,1000_AL_.jpg\"\n" +
            "    ]\n" +
            "  }\n" +
            "]"

    fun getMoviesList(): List<MovieItem> {
        val gson = Gson()
        return gson.fromJson(filmsJSON, Array<MovieItem>::class.java).asList()
    }
}