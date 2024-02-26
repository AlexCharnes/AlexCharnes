package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeCli {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.chucknorris.io/jokes/random?category=dev";
        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);

        /*
            Before this line is just to display the results
         */
        System.out.print("Categories: ");
        for (String cat : response.getCategories()) {
            System.out.print( cat + " ");
        }
        System.out.println();
        System.out.println(response.getUrl());
        System.out.println(response.getValue());


    }
}
