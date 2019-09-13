# dodona-api-java

[![Build Status](https://travis-ci.org/thepieterdc/dodona-api-java.svg?branch=master)](https://travis-ci.org/thepieterdc/dodona-api-java)
[![codecov](https://codecov.io/gh/thepieterdc/dodona-api-java/branch/master/graph/badge.svg)](https://codecov.io/gh/thepieterdc/dodona-api-java)
[![Download](https://api.bintray.com/packages/thepieterdc/dodona-api-java/dodona-api-java/images/download.svg) ](https://bintray.com/thepieterdc/dodona-api-java/dodona-api-java/_latestVersion)


Java binding for the Dodona API.

## Installation

### Gradle
```
repositories {
    maven {
        url  "https://dl.bintray.com/thepieterdc/dodona-api-java"
    }
}

dependencies {
    compile group: 'io.github.thepieterdc.dodona', name: 'dodona-api-interface', version: '1.4.3'
    runtime group: 'io.github.thepieterdc.dodona', name: 'dodona-api-impl', version: '1.4.3'
}
```

## Usage
```java
public class ApiApplication {
    public static void main(String[] args) {
		final DodonaClient dodona = DodonaBuilder.builder()
			.authenticate("myToken")
			.setHost("https://dodona.ugent.be")
			.build();
		
		System.out.println("My name is " + dodona.me().getFirstName());
    }
}
```

## Documentation
You can find the API documentation at [https://thepieterdc.github.io/dodona-api-java/](https://thepieterdc.github.io/dodona-api-java/).

## Credits
This library was created by [Pieter De Clercq](https://thepieterdc.github.io/) and [Tobiah Lissens](https://github.com/darktilrisen).
