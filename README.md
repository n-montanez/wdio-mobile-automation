# WDIO Mobile Automation

This is an Appium + TestNG project for testing
the [WDIO Mobile](https://github.com/webdriverio/native-demo-app/releases) application.

## ⚙️ Used Technologies

- Java 21
- Maven 9
- Appium 2
- TestNG

## ℹ️ Test Cases

1. 🧭 Navigation using Navbar
2. 🔐 Authentication forms
3. ➡️ Swiping cards

## 💻 How to run this project?

### 1. Clone this repository

```bash
git clone https://github.com/n-montanez/wdio-mobile-automation

cd wdio-mobile-automation
```

### 2. Modify suite parameters
On the `suite.xml` file under `src/test/resources` modify the given device and appium server url:

```bash
    <parameter name="deviceName" value="${DEVICE_NAME}"/>
    <parameter name="appiumUrl" value="${APPIUM_URL}"/>
```

### 3. Compile and run the tests

```bash
mvn clean test
```

## 👓 Authors

- [@n-montanez](https://github.com/n-montanez)

## 📄 License

This project was developed under the [MIT License](https://choosealicense.com/licenses/mit/). Please reach to its
documentation to know how you could use and modify this software.