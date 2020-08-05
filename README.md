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
* Web Browser
* (Only if you desire to run the mySQL and API PHP on a local machine) LAMP stack such as MAMP

### Installing and running relevant files

For running the Android Application on Android Studio:

1. Open the Android File as a project on Android Studio.
2. Ensure that on Android Studio that you have installed a AVD. This application has been optimised for Pixel 2, API 29.
3. Press the play button or type "^R".

For running the Android Application on an Android device:

1. Use the .apk file to run the app on an Android device.
2. Follow the instructions within this link - https://www.lifewire.com/install-apk-on-android-4177185.


For Testing the API:

1. Open a web browser of your choice.
2. Decide on the API call that you want to test, here is a following list of relevant API calls;

- getproductsknowingproduct; Returns a list of product information with productsearchterm being the only parameter being entered in (Parameters: productsearchterm).
- getproductsknowingdepartment; Returns a list of products with departmentsearchterm being the only parameter being entered in (Parameters: departmentsearchterm).
- getproductsknowingstores; Returns a list of products with storesearchterm being the only parameter being entered in (Parameters: storesearchterm).
- getproductsknowingproductanddepartment; Returns a list of products with productsearchterm and departmentsearchterm being the only parameters being entered in (Parameters: departmentsearchterm, productsearchterm).
- getproductsknowingproductandstores; Returns a list of products with productsearchterm and storesearchterm being the only parameters being entered in (Parameters: storesearchterm, productsearchterm).
- getproductsknowingdepartmentandstores; Returns a list of products with departmentsearchterm and storesearchterm being the only parameters being entered in (Parameters: storesearchterm, departmentsearchterm).
- getproductsknowingproductanddepartmentandstores; Returns a list of products with productsearchterm, departmentsearchterm and storesearchterm being all entered (Parameters: storesearchterm, productsearchterm, departmentsearchterm).

3. To write the relevant URL for the API call, follow  this format; http://group5hngdatabase.000webhostapp.com/Api.php?apicall=(chosen API CALL)%(parameter name)=(search term)

```
http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproduct&productsearchterm=Ever
```

(For more than one parameter, seperate parameters with the "&")

```
http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproductanddepartment&productsearchterm=Ever&departmentsearchterm=Concretors
```

And repeat

```
until finished
```

4. Put your URL into a JSON viewer such as the one at https://codebeautify.org/jsonviewer.


## Built With

* [MySQL] - The web framework used
* [PHP] - Used for the API
* [Java] - Used for the Android app

## Contributers for this project

* **Hans Magnaye** - [jellomarr](https://github.com/jellomarr)
* **Leanne Tran** - [jellomarr](https://github.com/jellomarr)
* **Wei (William) Quan** - [jellomarr](https://github.com/jellomarr)
* **Sylvia Huang** - [jellomarr](https://github.com/jellomarr)
* **Kenzo Jeanson** - [jellomarr](https://github.com/jellomarr)


## Acknowledgments

* Special thanks to Hardware & General for giving us this opportunity.
* Thank you to Yenni Tim and Sandeep Mysore Seshadrinath for their guidence thoughout the project
* Thank you to Belal Khan at www.simplifiedcoding.net for providing the starter code for the PHP API
