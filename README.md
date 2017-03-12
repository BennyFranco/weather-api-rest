# Weather Rest API

[![Build Status][travis-badge]][travis-badge-url]

This project is part of my Thesis named "Development of a software architecture for an agrometeorological network".
The idea of this module is provide the rest api service to persist and get information from a NoSql data base, for my
study case, we use MongoDB.

The objective of the Thesis is create an architectural model of software focused on the management of agrometeorological data that allows the scalability, that is to say, to add characteristics, climatic stations and maintenance, without the need to modify the established model, by applying software patterns, which together made the appropriate architectural model.


## Installation

### Requirements

The project was created using the next tools:
* SpringBoot Framework
* Java
* IntelliJ Idea like IDE
* Maven
* MongoDB

### Build

* Run `./mvnw compile` to build the project. 
* Run `./mvnw install`, this tells Maven to build all the modules, and to install it in the local repository. The local repository is created in your home directory (or alternative location that you created it), and is the location that all downloaded binaries and the projects you built are stored.

### Running unit tests

* Run `./mvnw verify` to execute the unit tests.

### Development server
* After compule run `java java -jar target/weather-api-rest-x.x.x-SNAPSHOT.jar` to execute the compiled jar

## Usage

The project server is at http://localhost:8080 by default

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## License

MIT License

Copyright (c) 2017 Benny Franco Dennis

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[travis-badge]: https://travis-ci.org/BennyFranco/weather-api-rest.svg?branch=master
[travis-badge-url]: https://travis-ci.org/BennyFranco/weather-api-rest