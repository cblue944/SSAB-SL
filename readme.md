# Welcome to the top 10 "longest" buss lines in Stockholm 
This repository contains sample api that will call a public API from SL and TrafikLab that contains information about the buss, ferry and subway lines in Stockholm.
From this information the top 10 lines with the most stops will be calculated and presented in a json rest end-point.

# Configuration
Before running the web application you will need to update the `config.properties` file with:
1. the API key for accessing the TrafikLab api. You can get one at https://developer.trafiklab.se/
you can find the `config.properties` under `src/main/resources`
2. The cache length can be changed if a longer or short cache period before the data are recaptured from the TrafikLab api.
# Local testing

## Build & run the code
For testing the application locally, follow the next steps:
1. Install `Java > 18` and `Maven`.
2. Install the Maven dependencies and compile the application by running `mvn clean install`.
3. Start the local server by running `mvn cargo:run`

## Try the API out
The web application can be accessed and tested via [http://localhost:800/ssabsl/](http://localhost:800/ssabsl/).
Here you will find a link to the rest end point with top ten buss lines with the most stops. [Top 10 Buss lines](http://localhost:800/ssabsl//api/v1/lines/).

