## Name of application
Wildlife tracker

## Developed by:
Carolyne Milgo

## Technologies Used
Language: java
Resources: Velocity templates for Spark integration
Database: Postgresql

## Specifications
1. The application tracks two kinds of animals: endangered species and those that are not endangered
2. Animals not endangered are captured by name only
3. Endangered animals are captured by name, age and health
4. The application allows rangers to register sightings which must include name of ranger, location and id of animal or endangered species

## Instructions
1. Create database using postgresql called wildlife_tracker and populate with tables called sightings and animals
2. Populate table sightings with these columns: rangerName, location, animalId and seen.
3. Populate table animals with these columns: id, name, age, health and type.
4. Fork or clone the project from the github repo:
5. Launch program on localhost:4567
