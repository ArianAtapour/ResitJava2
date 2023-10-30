# StartDocument for Bicycle Rental

Startdocument of **Arian Atapour**. Student number **5088453**.

## Problem Description

From Java 2 modulebook:

**6. Bicycle rental**

The NS Group wants new software to track the rental of their bicycles. The
software should track how many bicycles are still available for rental. There are
three types of bikes: a regular one, mountain bike and electrical bike. A
customer can hire a bicycle for a certain amount of time. The end time will be
registered when the customer returns the bike. In every bicycle is a GPStracker. The tracker tracks the distance the
customer has travelled with the
bicycle. When the customers starts renting he has to pay deposit from €20,-.
The customer has to pay money per kilometre. This is:

- €0,20 for a regular bike;
- €0,25 for a mountain bike;
- €0,50 for a electrical bike.

Per hour the customer has to pay €2,-. When the customer returns the bike,
the customer has to pay. For maintenance purposes the company wants to
know the total distance the bike has been used.

### Input & Output

In this section the in- and output of the application will be described.

#### Input

In the table below all the input (that the user has to input in order to make the application work) are described.

| Case                                       | Type            | Conditions    |
|--------------------------------------------|-----------------|---------------|
| Name of customer                           | `String`        | not empty     |
| Addition of bike to store                  | `Bike`          | not empty     |
| Rental of bike                             | `Hashmap<Bike>` | not empty     |
| Setting the kilometres on the bike         | `double`        | `number` > 0  |
| Setting the start time of rental of bike   | `integer`       | `number` >= 0 |
| Setting the end time of rental of the bike | `integer`       | `number` >= 0 |

#### Output

| Case                                                  | Type            |
|-------------------------------------------------------|-----------------|
| Bikes from the store                                  | `Hashmap<Bike>` |
| Returning the bike to the store and getting the total | `String`        |
| Bikes available in the store for rental               | `String`        |
| Name of the customer                                  | `String`        |
| Kilometres of the bike                                | `double`        |
| Total distance traveled by the bike                   | `String`        |
| Cost of the bike ride                                 | `String`        |

#### Calculations

| Case                  | Calculation                                                                                                                         |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| Cost of the bike ride | The deposit of 20 euros added to the multiplication of the bike type cost and kilometres done as well as the hours multiplied by 2. |  

## Class Diagram

![Class Diagram image](classDiagram.png)

### Test Data

In the following table you'll find all the data that is needed for testing.

#### Bike

| ID              | Input  | Code                  |
|-----------------|--------|-----------------------|
| `bRegular`      | id: 1  | `new Regular(1)`      |
| `bike2`         | id: -2 | `new Regular(-2)`     |
| `bMountainBike` | id:2   | `new MountainBine(2)` |
| `bElectric`     | id:3   | `new Electric(3)`     |

#### Distance for bike

| ID          | Input    | Code               |
|-------------|----------|--------------------|
| `distance1` | km: 8.5  | `bike.setKm(8.5)`  |
| `distance2` | km: 20.5 | `bike.setKm(20.5)` |
| `distance3` | km:20    | `bike.setKm(20)`   |

#### Time for bike

| ID      | Input                      | Code                                                |
|---------|----------------------------|-----------------------------------------------------|
| `time1` | start:12:00<br/>end: 14:00 | `bike.setStartTime(12,0)<br/>bike.setEndTime(14,0)` |

#### Customer

| ID      | Input          | Code                       |
|---------|----------------|----------------------------|
| `john`  | name: Jonh Doe | `new Customer("John Doe")` |
| `empty` | name:""        | `new Customer("")`         |

#### Ns

| ID   | Input | Code       |
|------|-------|------------|
| `Ns` |       | `new Ns()` |

### Test cases

In this section the testcases will be described. Every test case should be executed with the test data as starting
point.

#### #1 Negative ID

Checking if IllegalArgumentException is thrown when trying to input a negative Id for the bicycle.

| Step | Input | Action            | Expected output            |
|------|-------|-------------------|----------------------------|
| 1    | `-2`  | `new Regular(-2)` | `IllegalArgumentException` |

#### #2 Checking ID

Checking if the ID given is the same in the output.

| Step | Input | Action    | Expected output |
|------|-------|-----------|-----------------|
| 1    | `1`   | `getId()` | 1               |

#### #3 Negative kilometres

Checking if IllegalArgumentException is thrown when trying to input negative kilometres for the bicycle.

| Step | Input  | Action        | Expected output          |
|------|--------|---------------|--------------------------|
| 1    | `-2.5` | `setKm(-2.5)` | IllegalArgumentException |

#### #4 Checking kilometres

Checking if the kilometres given are the same in the output.

| Step | Input | Action    | Expected output |
|------|-------|-----------|-----------------|
| 1    | `8.5` | `gpsTracker()` | 8.5             |

#### #5 Negative Start Hour

Checking if IllegalArgumentException is thrown when trying to input a negative start hour for the bicycle.

| Step | Input   | Action                | Expected output          |
|------|---------|-----------------------|--------------------------|
| 1    | `-8,30` | `setStartTime(-8,30)` | IllegalArgumentException |

#### #6 Negative End Minute

Checking if IllegalArgumentException is thrown when trying to input a negative start minute for the bicycle.

| Step | Input   | Action              | Expected output          |
|------|---------|---------------------|--------------------------|
| 1    | `9,-50` | `setEndTime(9,-50)` | IllegalArgumentException |

#### #7 Reset time

Checking if resetting the time does not affect getting the hours or throwing other errors.

| Step | Input  | Action               | Expected output |
|------|--------|----------------------|-----------------|
| 1    | `10,0` | `setStartTime(10,0)` |                 |
| 2    | `11,0` | `setEndTime(11,0)`   |                 |
| 3    |        | `resetTime()`        |                 |
| 4    |        | `getHours()`         | 0               |

#### #8 Reset kilometres

Checking if resetting the kilometres does not affect getting the kilometres or throwing other errors.

| Step | Input | Action      | Expected output |
|------|-------|-------------|-----------------|
| 1    | `20`  | `setKm(20)` |                 |
| 2    |       | `resetKm()` |                 |
| 3    |       | `gpsTracker()`   | 0.0             |

#### #9 Getting the duration in hours

Checking if the correct duration in hours is displayed.

| Step | Input  | Action               | Expected output |
|------|--------|----------------------|-----------------|
| 1    | `12,0` | `setStartTime(12,0)` |                 |
| 2    | `14,0` | `setEndTime(14,0)`   |                 |
| 3    |        | `getHours()`         | 2               |

#### #10 Checking if the expected rental status is outputted

Checking if the expected rental status is outputted.

| Step | Input  | Action            | Expected output |
|------|--------|-------------------|-----------------|
| 1    | `true` | `setRented(true)` |                 |
| 2    |        | `isRented()`      | true            |

#### #11 Check if the total distance is registered correctly

Checking if the total distance is registered correctly and if it is made of the sum of distances registered.

| Step | Input  | Action             | Expected output |
|------|--------|--------------------|-----------------|
| 1    | `20.5` | `setKm(20.5)`      |                 |
| 2    | `20`   | `setKm(20)`        |                 |
| 3    |        | `getTotalDistance` | 40.5            |

#### #12 Checking if the price for the regular bike is the expected one

Checking if the regular bike displays the correct cost.

| Step | Input | Action              | Expected output |
|------|-------|---------------------|-----------------|
| 1    |       | `REGULAR.getCost()` | 0.20            |

#### #13 Checking if the price for the mountain bike is the expected one

Checking if the mountain bike bike displays the correct cost.

| Step | Input | Action                   | Expected output |
|------|-------|--------------------------|-----------------|
| 1    |       | `MOUNTAINBIKE.getCost()` | 0.25            |

#### #14 Checking if the price for the electric bike is the expected one

Checking if the electric bike displays the correct cost.

| Step | Input | Action               | Expected output |
|------|-------|----------------------|-----------------|
| 1    |       | `ELECTRIC.getCost()` | 0.50            |

#### #15 Checking if the output of the customer name is the expected one

Checking if the output of the customer name is the expected one.

| Step | Input | Action      | Expected output |
|------|-------|-------------|-----------------|
| 1    |       | `getName()` | "John Doe"      |

#### #16 Checking if exception is thrown when an empty string is inputted

Checking if exception is thrown when an empty string is inputted.

| Step | Input | Action             | Expected output          |
|------|-------|--------------------|--------------------------|
| 1    | `""`  | `new Customer("")` | IllegalArgumentException |

#### #17 Checking if the value (customer) of the key (bike) added into the hashmap is null.

Checking if the value (customer) of the key (bike) added into the hashmap is null.

| Step | Input      | Action                     | Expected output |
|------|------------|----------------------------|-----------------|
| 1    | `bRegular` | `getBikes().get(bRegular)` | null            |

#### #18 Checking if the rental status of the bike changes upon being rented.

Checking if the rental status of the bike changes upon being rented.

| Step | Input                     | Action                             | Expected output |
|------|---------------------------|------------------------------------|-----------------|
| 1    | `bRegular`                | `ns.addBike(bRegular)`             |                 |
| 2    | `customer`<br/>`bRegular` | `ns.rentBike(customer, bRegular);` |                 |
| 3    |                           | `bRegular.isRented()`              | true            |

#### #19 Checking if exception is thrown when the customer wants to rent a bike that's not in the Ns rental.

Checking if exception is thrown when the customer wants to rent a bike that's not in the Hashmap.

| Step | Input                     | Action                             | Expected output          |
|------|---------------------------|------------------------------------|--------------------------|
| 1    | `customer`<br/>`bRegular` | `ns.rentBike(customer, bRegular);` | IllegalArgumentException |

#### #20 Check if returned regular bike displays the correct price and renter, as well if the bike's rental status is switched to false.

Check if returned bike displays the correct price and renter, as well if the bike's rental status is switched to false.

| Step | Input                     | Action                            | Expected output                    |
|------|---------------------------|-----------------------------------|------------------------------------|
| 1    | `bRegular`                | `ns.addBike(bRegular)`            |                                    |
| 2    | `John Doe`                | `new Customer("John Doe")`        |                                    |
| 2    | `customer`<br/>`bRegular` | `ns.rentBike(customer, bRegular)` |                                    |
| 3    | `10,0`                    | `bRegular.setStartTime(10, 0)`    |                                    |
| 4    | `12,0`                    | `bRegular.setEndTime(12, 0)`      |                                    |
| 5    | `10`                      | `bRegular.setKm(10);`             |                                    |
| 6    |                           | `ns.returnBike(bRegular)`         | "Renter: John Doe has to pay: 26 € |

#### #21 Check if returned mountain bike displays the correct price and renter, as well if the bike's rental status is switched to false.

Check if returned bike displays the correct price and renter, as well if the bike's rental status is switched to false.

| Step | Input                          | Action                                 | Expected output                      |
|------|--------------------------------|----------------------------------------|--------------------------------------|
| 1    | `bMountainBike`                | `ns.addBike(bMountainBike)`            |                                      |
| 2    | `John Doe`                     | `new Customer("John Doe")`             |                                      |
| 2    | `customer`<br/>`bMountainBike` | `ns.rentBike(customer, bMountainBike)` |                                      |
| 3    | `10,0`                         | `bMountainBike.setStartTime(10, 0)`    |                                      |
| 4    | `12,0`                         | `bMountainBike.setEndTime(12, 0)`      |                                      |
| 5    | `10`                           | `bMountainBike.setKm(10)`              |                                      |
| 6    |                                | `ns.returnBike(bMountainBike)`         | "Renter: John Doe has to pay: 26.5 € |

#### #22 Check if returned electric bike displays the correct price and renter, as well if the bike's rental status is switched to false.

Check if returned bike displays the correct price and renter, as well if the bike's rental status is switched to false.

| Step | Input                      | Action                             | Expected output                    |
|------|----------------------------|------------------------------------|------------------------------------|
| 1    | `bElectric`                | `ns.addBike(bElectric)`            |                                    |
| 2    | `John Doe`                 | `new Customer("John Doe")`         |                                    |
| 2    | `customer`<br/>`bElectric` | `ns.rentBike(customer, bElectric)` |                                    |
| 3    | `10,0`                     | `bElectric.setStartTime(10, 0)`    |                                    |
| 4    | `12,0`                     | `bElectric.setEndTime(12, 0)`      |                                    |
| 5    | `10`                       | `bElectric.setKm(10)`              |                                    |
| 6    |                            | `ns.returnBike(bElectric)`         | "Renter: John Doe has to pay: 29 € |

#### #23 Check when the bike that is returned it's not in the Ns rental

Check when the bike that is returned it's not in the Hashmap throws an IllegalArgumentException.

| Step | Input | Action                    | Expected output          |
|------|-------|---------------------------|--------------------------|
| 1    |       | `ns.returnBike(bRegular)` | IllegalArgumentException |

#### #24 Get the initial available bikes

Check if the initial bike availability is 0.

| Step | Input | Action                   | Expected output      |
|------|-------|--------------------------|----------------------|
| 1    |       | `ns.getAvailableBikes()` | "Available bikes: 0" |

#### #25 Get the count of available bikes after they have been added.

Get the count of available bikes after they have been added.

| Step | Input                                          | Action                   | Expected output      |
|------|------------------------------------------------|--------------------------|----------------------|
| 1    | `bRegular`<br/>`bMountainBike`</br>`bElectric` | `ns.getAvailableBikes()` | "Available bikes: 3" |

#### #25 Get the count of available bikes after one has been rented.

Get the count of available bikes after they have been added.

| Step | Input                                          | Action                            | Expected output      |
|------|------------------------------------------------|-----------------------------------|----------------------|
| 1    | `customer`<br/>`bRegular`                      | `ns.rentBike(customer, bRegular)` |                      |
| 2    | `bRegular`<br/>`bMountainBike`</br>`bElectric` | `ns.getAvailableBikes()`          | "Available bikes: 2" |