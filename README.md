# ProductDirectory

The following files and folders contain everything that makes up the Hardware & General Product Directory, created as part of the assessment requirements of INFS3605, the capstone course of Information Systems at the University of New South Wales. The files within this project include;

* .apk - which allows people to run the app on any Android device.
* 3605-final - This contains the source code for the Android app written in Java
* API files - This contains the files that make up the API, which was written in PHP, which are hosted on http://group5hngdatabase.000webhostapp.com.
* SQL dump - This contains the SQL dump of the MySQL database that is hosted on http://group5hngdatabase.000webhostapp.com.

The way that the API, MySQL database and Android app work together is that when a search is requested from the Android app, the Android app calls the relevant API call on this web address "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=" giving the web address relevant parameters e.g. http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproduct&productsearchterm=Ever. The web address then returns a JSON string based on the parameters fed to it, and the Android app receives this JSON string and processes it for display on the Android application.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Android Studio
* (Only if you desire to run the mySQL and API PHP on a local machine) LAMP stack such as MAMP

### Installing

For the Android Application:

For testing the API


A step by step series of examples that tell you how to get a development env running



```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

For the API:

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributers

* **Hans Magnaye** - *Initial work* - [jellomarr](https://github.com/PurpleBooth)

## Authors

* **Hans Magnaye** - *Initial work* - [jellomarr](https://github.com/jellomarr)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## Acknowledgments

* Special thanks to Hardware & General for giving us this opportunity.
* Thank you to Yenni Tim and Sandeep Mysore Seshadrinath for their guidence.
* etc
