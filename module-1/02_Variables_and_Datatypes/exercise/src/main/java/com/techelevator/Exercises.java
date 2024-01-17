package com.techelevator;

public class Exercises {

    /**
     * For the purposes of this exercise, the following naming rules are tested:
     *
     * Variable names:
     *  - must start with a lowercase character a-z.
     *  - underscore ('_') characters are not allowed.
     *  - dollar sign ('$') characters are not allowed.
     *  - must be at least two characters in length.
     *  - You are encouraged to create descriptive names and are required to camel case them as appropriate.
     *
     * Constant names:
     *  - must start with an uppercase character A-Z.
     *  - dollar sign ('$') characters are not allowed.
     *  - must be at least two characters in length.
     *  - You are encouraged to create descriptive names and are required to upper case them as appropriate.
     *
     * Due to practical limitations, camel case and pascal case are not tested other than checking the first
     * character of the name is lower case for variables and upper case for constants. Your instructor will
     * manually review your solution checking for the correct casing.
     */

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsPlayingInTheWoods = 3;
		int raccoonsLeavingToEatDinner = 2;
		int raccoonsLeftInTheWoods =  raccoonsPlayingInTheWoods - raccoonsLeavingToEatDinner;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int amountOfFlowers = 5;
		int amountOfBees = 3;
		int amountOfBeesLessThanFlowers = amountOfFlowers - amountOfBees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int additionalPigeonsComingToEat = 1;
		int totalAmountOfPigeonsEatingBreadcrumbs = lonelyPigeon + additionalPigeonsComingToEat;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int amountOfOwlsSittingOnFence = 3;
		int amountOfOwlsJoining = 2;
		int totalOwlsOnFence = amountOfOwlsSittingOnFence + amountOfOwlsJoining;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkingOnHome = 2;
		int beaversGoingForSwim = 1;
		int amountOfBeaversStillWorking = beaversWorkingOnHome - beaversGoingForSwim;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSittingOnTreeLimb = 2;
		int toucansJoiningToSitOnTreeLimb = 1;
		int totalAmountOfToucansOnTreeLimb = toucansSittingOnTreeLimb + toucansJoiningToSitOnTreeLimb;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsInTree = 4;
		int nutsHeldBySquirrels = 2;
		int amountOfSquirrelsOverNuts = squirrelsInTree - nutsHeldBySquirrels;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .1;
		double nickels = .1;
		double totalAmountOfMoneyFound = dime + nickels + quarter;

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int mrsBriersMuffinTotal = 18;
		int mrsMacAdamsMuffinTotal = 20;
		int mrsFlannerysMuffinTotal = 17;
		int firstGradeClassMuffinTotal = mrsBriersMuffinTotal + mrsFlannerysMuffinTotal + mrsMacAdamsMuffinTotal;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyoCost = .24;
		double whistleCost = .14;
		double mrsHiltsTotalCost = yoyoCost + whistleCost;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallowsUsed = 8;
		int miniMarshmallowsUsed = 10;
		int totalMarshmallowsUsed = largeMarshmallowsUsed + miniMarshmallowsUsed;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowAtMrsHiltsHouse = 29;
		int snowAtBrecknock = 17;
		int amountOfMoreSnowAtMrsHiltsHouse = snowAtMrsHiltsHouse - snowAtBrecknock;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double mrsHiltsTotalMoney = 10;
		double costOfToyTruck = 3;
		double costOfPencil = 2.50;
		double mrsHiltsRemainingMoney = mrsHiltsTotalMoney - costOfToyTruck - costOfPencil;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int originalAmountInMarbleCollection = 16;
		int amountOfMarblesLost = 7;
		int remainingMarbles = originalAmountInMarbleCollection - amountOfMarblesLost;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int shellsMeganHas = 19;
		int goalOfShells = 25;
		int amountOfShellsNeededFound = goalOfShells - shellsMeganHas;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int totalRedBalloons = 8;
		int amountOfGreenBalloons = totalBalloons - totalRedBalloons;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int startingAmountOfBooksOnShelf = 38;
		int amountOfBooksAdded = 10;
		int totalAmountOfBooksOnShelf = startingAmountOfBooksOnShelf + amountOfBooksAdded;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs = 6;
		int totalBees = 8;
		int totalAmountOfBeeLegs = beeLegs * totalBees;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double priceOfIceCreamCone = .99;
		double costOfTwoIceCreamCones = priceOfIceCreamCone * 2;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocksNeededForBorder = 125;
		int mrsHiltsRocks = 64;
		int rocksStillNeeded = totalRocksNeededForBorder - mrsHiltsRocks;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int mrsHiltsMarbles = 38;
		int marblesLost = 15;
		int mrsHiltsRemainingMarbles = mrsHiltsMarbles - marblesLost;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesToConcert = 78;
		int milesDroveBeforeGasRefill = 32;
		int milesDroveAfterRefill = milesToConcert - milesDroveBeforeGasRefill;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int saturdayMorningShovelingMinutes = 90;
		int saturdayAfternoonShovelingMinutes = 45;
		int totalShovelingTime = saturdayAfternoonShovelingMinutes + saturdayMorningShovelingMinutes;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hotDogsPurchased = 6;
		double hotDogPrice = .5;
		double totalSpentOnHotDogs = hotDogPrice * hotDogsPurchased;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int mrsHiltsMoney = 50;
		int costOfAPencil = 7;
		int amountOfPencilsPurchasable = mrsHiltsMoney / costOfAPencil;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int butterFliesSeen = 33;
		int amountOfOrangeButterfliesSeen = 20;
		int amountOfRedButterfliesSeen = butterFliesSeen - amountOfOrangeButterfliesSeen;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double amountGivenForPurchase = 1.00;
		double costOfCandy = .54;
		double changeReturned = amountGivenForPurchase - costOfCandy;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int currentTreesInBackYard = 13;
		int treesPlanted = 12;
		int newTotalOfTrees = currentTreesInBackYard + treesPlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInDay = 24;
		int daysToSeeGrandma = 2;
		int hoursToSeeGrandma = hoursInDay * daysToSeeGrandma;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimCousinsAmount = 4;
		int piecesOfGumPerCousin = 5;
		int totalGumNeeded = kimCousinsAmount * piecesOfGumPerCousin;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dansDollars = 3.00;
		double candyBarPrice = 1.00;
		double dansMoneyLeftAfterPurchase = dansDollars - candyBarPrice;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInLake = 5;
		int peoplePerBoat = 3;
		int peopleOnLake = boatsInLake * peoplePerBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenLegoCount = 380;
		int ellenLostLegos = 57;
		int ellenRemainingLegos = ellenLegoCount - ellenLostLegos;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int currentBakedMuffins = 35;
		int muffinAmountGoal = 83;
		int additionalMuffinsNeeded = muffinAmountGoal - currentBakedMuffins;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayonCount = 1400;
		int lucyCrayonCount = 290;
		int differenceOfCrayons = willyCrayonCount - lucyCrayonCount;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int pagesInStickerBook = 22;
		int totalStickerInBook = stickersPerPage * pagesInStickerBook;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalAmountOfCupcakes = 100.0;
		int children = 8;
		double cupcakesPerChild = totalAmountOfCupcakes / children;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int totalGingerBreadCookies = 47;
		int cookiesPerJar = 6;
		int cookiesLeftOver = totalGingerBreadCookies % cookiesPerJar;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int preparedCroissants = 59;
		int amountOfNeighbors = 8;
		int croissantsLeftOver = preparedCroissants % amountOfNeighbors;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalCookieCount = 276;
		int cookiesPerTray = 12;
		int traysNeeded = totalCookieCount / cookiesPerTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalBiteSizedPretzels = 480;
		int pretzelServingSize = 12;
		int totalServingsOfBiteSizedPretzels = totalBiteSizedPretzels / pretzelServingSize;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupCakesTakenToOrphanage = 51;
		int lemonCupCakesPerBox = 3;
		int totalLemonCupCakeBoxesGivenAway = lemonCupCakesTakenToOrphanage / lemonCupCakesPerBox;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int amountOfCarrotSticksForBreakfast = 74;
		int amountOfPeopleEatingCarrotSticks = 12;
		int carrotSticksLeftUneaten = amountOfCarrotSticksForBreakfast % amountOfPeopleEatingCarrotSticks;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalAmountOfTeddyBears = 98;
		int maxTeddyBearsPerShelf = 7;
		int amountOfShelvesFilledWithTeddyBears = totalAmountOfTeddyBears / maxTeddyBearsPerShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalAmountOfFamilyPictures = 480;
		int maxPicturesPerAlbum = 20;
		int amountOfAlbumsNeeded = totalAmountOfFamilyPictures / maxPicturesPerAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int joesTradingCardTotal = 94;
		int cardsNeededToFillBox = 8;
		int totalBoxesFilledWithCards = joesTradingCardTotal / cardsNeededToFillBox;
		int leftOverCardsInUnfilledBox = joesTradingCardTotal % cardsNeededToFillBox;

        /* Exercise 49
        49. The Milky Way galaxy contains 300 billion stars. The Andromeda galaxy
        contains 1 trillion stars. How many stars do the two galaxies contain combined?
        */
		long starsInMilkyWayInBillions = 300;
		long starsInAndromedaGalaxyInBillions = 1000;
		long totalStarsInBothGalaxiesByBillions = (starsInAndromedaGalaxyInBillions + starsInMilkyWayInBillions) * 1000000000;


        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int totalBakedCroissants = 17;
		int amountOfGuests = 7;
		double bakedCroissantsPerGuest = (double)totalBakedCroissants / amountOfGuests;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double billsRoomPaintedPerHour = 1/2.15;
		double jillsRoomPaintedPerHour = 1/1.90;
		double amountOfRoomsBeingPainted = 5;
		double timeToPaintAllRooms = amountOfRoomsBeingPainted / (billsRoomPaintedPerHour + jillsRoomPaintedPerHour) ;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace ";
		String lastName = "Hopper, ";
		String middleInitial = "B.";
		String fullName = lastName + firstName + middleInitial;
		System.out.println(fullName);
	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double milesFromNewYorkToChicago = 800;
		double milesTravelledByTrain = 537;
		double amountOfTripCompleted = (milesTravelledByTrain / milesFromNewYorkToChicago);
		int percentageOfDistanceTravelled = (int)(amountOfTripCompleted * 100);
	}

}
