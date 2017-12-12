# Flood Alert System
This project is about early warning system which warns people about the possible floods whenever water level rises to a specific point so that they can take precautions. Basically, data flows from the sensors that are installed at water bodies and rivers to the server where we already have the list of concerned rivers and sensors installed in the system. The server then decides the trend of each station whether the water level is rising, falling or steady. And then it generates push notifications to warn the people if the reading of water level exceeds the pre-specified value. 
The overall system was a team work and the reference to the implementation of sensor and mobile application is given below.

#Sensor application in Python( Client side implementation)
Author - Shelby LeBlanc
Link - Coming soon..

#Mobile application in Android( Client side implementation)
Language - A
Author - Sagun Pandey
Link - Coming soon..

#Prerequisites
1. Oracle Java Development Kit 8
2. Spring framework
3. MySQL server 

#Setting-up development environment
1. Copy the project to local workspace.
2. Create database named ‘fas’ in MySQL.
3. Edit application.properties file as necessary (Database username/password, port for running service, etc.)
4. Change the value of the property ‘spring.jpa.hibernate.ddl-auto’ to ‘create’ if running for the first time. This will    initialize the database and populate the created tables with default data. Set it to ‘none’ when the database is initialized.

#License
This project is licensed under the MIT License - see the LICENSE.md file for details.

