<h2>About this project</h2>

This project was developed under Spring, Maven and Materialize.

<h2>Main target</h2>

This project tries to solve the following requirements:

This is a car renting business.


Classify by type of car (small, sport, SUV) and set a price depending on the type of car (40USD/day for small cars, 60USD/day for sport cars, 100USD/day for SUV cars).
Allow for a discount on weekdays (10%).
Allow for a discount for number of rental days (3 or more).
For 3 to 5 days 5%.
For 6 to 10 days 10%
11 or more 15%
Differentiate price for people subscribed to a membership plan (5%).
Generate an insurance policy and differentiate its price for people younger than 25 years old. (5USD a day for the small car, 7USD a day for the sport car, 10USD a day for the SUV with a 25% increase for younger people). No discount applies over the insurance total.
Make sure that the person renting the car is at least 18 years old.
Right now the business has the following available cars

Model: Dwarfy, Type: Small car
Model: Halfing, Type: Small car
Model: Eveo, Type: Sport car
Model: Cherato, Type: Sport car
Model: Vitoro, Type: SUV
Model: Exploring, Type: SUV
The sample input will be in JSON format including these keys:


"{"rentDates":["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"],"car":{"model":"Cherato","type":"sport"},"membership":false,"age":24}"

The expected output must be in JSON format including these keys:

"{"subtotal":350,"insuranceTotal":53,"discountPercentage":22.5,"totalPayment":324.25}"


However some of the Json entries were changed.

The expected entries are:


<img src="https://user-images.githubusercontent.com/29734970/30401114-b90bb0ce-989e-11e7-9c3d-c0097804792f.png"/>

The final form looks like:

<img src="https://user-images.githubusercontent.com/29734970/30401278-49bf6408-989f-11e7-835c-f1d31f91b5af.png"/>
