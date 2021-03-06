package com.megagigasolusindo.movie.dataproviders;

import java.util.Arrays;
import java.util.List;

public class MovieDataProvider {

    private String[] genreArray = {
            "Action",
            "Adventure",
            "Animation",
            "Biography",
            "Comedy",
            "Crime",
            "Documentary",
            "Drama",
            "Erotic",
            "Family",
            "Fantasy",
            "Historical",
            "Horror",
            "Musical",
            "Mystery",
            "Political",
            "Romance",
            "SF",
            "Sport",
            "Thriller",
            "War",
            "Western"
    };

    private String[] countryArrayMain = {
            "Australia",
            "Austria",
            "Belgium",
            "Brazil",
            "Bulgaria",
            "Canada",
            "China",
            "Denmark",
            "France",
            "Germany",
            "Greece",
            "Hungary",
            "India",
            "Italy",
            "Japan",
            "Mexico",
            "Norway",
            "Poland",
            "Portugal",
            "Russia",
            "Spain",
            "Sweden",
            "United Kingdom",
            "USA",
    };

    private String[] countryArrayOther = {
            "Afghanistan",
            "Albania",
            "Algeria",
            "Argentina",
            "Armenia",
            "Azerbaijan",
            "Belarus",
            "Bolivia",
            "Bosnia and Herzegowina",
            "Botswana",
            "Cambodia",
            "Cameroon",
            "Chile",
            "Colombia",
            "Congo",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czech Republic",
            "Dominican Republic",
            "Ecuador",
            "Egypt",
            "Estonia",
            "Finland",
            "Georgia",
            "Greece",
            "Haiti",
            "Honduras",
            "Hong Kong",
            "Iceland",
            "Indonesia",
            "Iran",
            "Iraq",
            "Ireland",
            "Israel",
            "Jamaica",
            "Kazakhstan",
            "Kenya",
            "South Korea",
            "North Korea",
            "Kuwait",
            "Kyrgyzstan",
            "Latvia",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macedonia",
            "Madagascar",
            "Malaysia",
            "Malta",
            "Monaco",
            "Mongolia",
            "Morocco",
            "Mozambique",
            "Namibia",
            "Nepal",
            "Netherlands",
            "New Zealand",
            "Nicaragua",
            "Pakistan",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Puerto Rico",
            "Qatar",
            "Romania",
            "San Marino",
            "Saudi Arabia",
            "Senegal",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "South Africa",
            "Sri Lanka",
            "Switzerland",
            "Taiwan",
            "Thailand",
            "Tunisia",
            "Turkey",
            "Ukraine",
            "United Arab Emirates",
            "Uruguay",
            "Uzbekistan",
            "Venezuela",
            "Vietnam",
            "Yugoslavia"
    };

    public List<String> getGenreList() {
        return Arrays.asList(genreArray);
    }

    public List<String> getCountryListMain() {
        return Arrays.asList(countryArrayMain);
    }

    public List<String> getCountryListOther() {
        return Arrays.asList(countryArrayOther);
    }

}
