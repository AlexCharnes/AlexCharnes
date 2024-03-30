import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {

    players:  [
        {
            "playerId": 1,
            "firstName": "Derek",
            "lastName": "Jibberish",
            "jerseyNumber": 2,
            "salary": 220000.0,
            "positions": [
                "Pitcher"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190470/1_cxwinb.webp",
            "fullName": "Derek Jibberish"
        },
        {
            "playerId": 2,
            "firstName": "Baxter",
            "lastName": "Bubbleworth",
            "jerseyNumber": 42,
            "salary": 150000.0,
            "positions": [
                "Catcher"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/2_hqe0ky.webp",
            "fullName": "Baxter Bubbleworth"
        },
        {
            "playerId": 3,
            "firstName": "Jasper",
            "lastName": "Jollyjinks",
            "jerseyNumber": 13,
            "salary": 250000.0,
            "positions": [
                "First Baseman"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/3_mgphn7.webp",
            "fullName": "Jasper Jollyjinks"
        },
        {
            "playerId": 4,
            "firstName": "Ziggy",
            "lastName": "Zipperton",
            "jerseyNumber": 3,
            "salary": 10000.0,
            "positions": [
                "Second Baseman"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/4_ec3vzk.webp",
            "fullName": "Ziggy Zipperton"
        },
        {
            "playerId": 5,
            "firstName": "Fiona",
            "lastName": "Fumblefizz",
            "jerseyNumber": 4,
            "salary": 430000.0,
            "positions": [
                "Shortstop"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/5_dm97cw.webp",
            "fullName": "Fiona Fumblefizz"
        },
        {
            "playerId": 6,
            "firstName": "Dexter",
            "lastName": "Doodlehatch",
            "jerseyNumber": 14,
            "salary": 84300.0,
            "positions": [
                "Pitcher"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/6_mdkfoj.webp",
            "fullName": "Dexter Doodlehatch"
        },
        {
            "playerId": 7,
            "firstName": "Judy",
            "lastName": "Wipsprocket",
            "jerseyNumber": 19,
            "salary": 230000.0,
            "positions": [
                "Shortstop"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/7_omvz9t.webp",
            "fullName": "Judy Wipsprocket"
        },
        {
            "playerId": 8,
            "firstName": "Gilbert",
            "lastName": "Gigglesnort",
            "jerseyNumber": 29,
            "salary": 130000.0,
            "positions": [
                "Shortstop"
            ],
            "teamId": 1,
            "imageURL": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190470/8_sbqriz.webp",
            "fullName": "Gilbert Gigglesnort"
        }
    ]
    
    
    },
    mutations: {

    },
    actions: {},
    modules: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  });
}
