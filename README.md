# thescore-app-testng-appium-framework
follow the guideline below to run thescore android app automation framework on BrowserStack

![BrowserStack Logo](https://d98b8t1nnulk5.cloudfront.net/production/images/layout/logo-header.png?1469004780)

## Test Cases
- [Test Case File](TESTCASE.md)

## Test Execution Result Reference
You can view the previous test execution results below. 

- [result one](https://app-automate.browserstack.com/dashboard/v2/public-build/RURVeTFnbjU0M3h6bURtMXJ6N2o3MDFUdGovdkYrQ1p0ckFxQnpTb0cyU09qSThyYzZtb1FHTEhOTjhtb2hZWFVhMW11QWVabFFUeWx5MXlQOFZ1TVE9PS0tUkJ1MVdOWFltYjRBV0lhOGJlQ09GQT09--0e33550a411fc1fc2d4867719bf3f48d93f04d9a)
- [result two](https://app-automate.browserstack.com/dashboard/v2/public-build/Y0JDc0JSa281Z1VDanpackdpZXBGT2lrN2JKQTlFV09GQVFzNjJ3RzNCcVQwWmIxdGhmYVFONys4WlBzcXhxd3VoT0lDMmNhMXhFMytGNE1mdE1wVFE9PS0tRHdZZkVPQ2JGaW4zRmdsN3Y0eWRhUT09--d306a1fa72e55d4a1696f2d97b6fda6011cd8e8f)

## Setup

### Requirements

1. Java 11+

    - If Java is not installed, follow these instructions:
        - For Windows, download latest java version from [here](https://java.com/en/download/) and run the installer executable
        - For Mac and Linux, run `java -version` to see what java version is pre-installed. If you want a different version download from [here](https://java.com/en/download/)

2. Maven
   - If Maven is not downloaded, download it from [here](https://maven.apache.org/download.cgi)
   - For installation, follow the instructions [here](https://maven.apache.org/install.html)

### Install the dependencies

To install the dependencies for Android tests, run :
```sh
cd android/testng-framework
mvn clean
```

## Getting Started
To run the test on BrowserStack mobile device, you need to have a valid username and accesskey. 
Visit the [BrowserStack access key](https://www.browserstack.com/docs/iaam/security/manage-access-keys) documentation. 

**Note**: once you obtain your userName and accessKey on BrowserStack, replace the userName and accessKey values in the browserstack.yml file with your userName and accessKey.

### **Run thescore android app test :**

- Switch to the android folder
- Run the following maven command `mvn test -P thescore-test`

**Note**: this test does not run on your local machine at this time because you need the following resources installed and configured on your machine to run the test locally. 

- Android SDk
- Android Device Manager
- Appium Server

**Note**: Android SDK, Android Device Manager and Appium Server related documentation will be updated soon.


## Getting Help

If you are running into any issues related to BrowserStack, please check [Browserstack Support page](https://www.browserstack.com/support/app-automate).
