# dodona-api-java

![Java](https://github.com/thepieterdc/dodona-api-java/workflows/Java/badge.svg)
![Java](https://github.com/thepieterdc/dodona-api-java/workflows/Integration/badge.svg)
[![codecov](https://codecov.io/gh/thepieterdc/dodona-api-java/branch/master/graph/badge.svg)](https://codecov.io/gh/thepieterdc/dodona-api-java)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4a532059319a41279261932ea9543692)](https://www.codacy.com/manual/thepieterdc/dodona-api-java)

Java binding for the Dodona API.

## Installation

### Gradle
GitHub packages require a personal access token to be downloaded. The readme below contains an access token that can only be used to download public packages, so you can use this if you don't want to use your own token.
```gradle
plugins {
    id 'java'
}

group 'org.example'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()

    maven {
        url = "https://maven.pkg.github.com/thepieterdc/dodona-api-java"
        credentials {
            username = "PublicToken"
            password = "\u0064\u0064\u0066\u0039\u0036\u0065\u0030\u0063\u0061\u0032\u0066\u0065\u0032\u0039\u0033\u0033\u0036\u0030\u0035\u0062\u0031\u0033\u0031\u0035\u0038\u0063\u0061\u0064\u0061\u0033\u0030\u0031\u0030\u0035\u0062\u0037\u0035\u0032\u0066\u0061"
        }
    }
}

dependencies {
    compile group: 'io.github.thepieterdc.dodona', name: 'dodona-api-interface', version: '1.9.3'
    runtime group: 'io.github.thepieterdc.dodona', name: 'dodona-api-impl', version: '1.9.3'
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

## Releasing
This process is automated via GitHub Actions. In order to make a new release, publish a commit to the `release` branch.

## Credits
This library was created by [Pieter De Clercq](https://thepieterdc.github.io/) and [Tobiah Lissens](https://github.com/darktilrisen).
