[![Build Status](https://travis-ci.org/cgiesche/ebikeconnect-api.svg?branch=master)](https://travis-ci.org/cgiesche/ebikeconnect-api) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.perdoctus/ebikeconnect-api/badge.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.perdoctus%22%20AND%20a%3A%22ebikeconnect-api%22) [![Dependency Status](https://www.versioneye.com/user/projects/57136231fcd19a00454411cd/badge.svg?style=flat)](https://www.versioneye.com/user/projects/57136231fcd19a00454411cd)

**JAX-RS client implementation for accessing Bosch ebike-connect webservices.**

This library allows you to (read-only) access Bosch ebike-connect HTTP services. It is currently in an early development state and therefore to be considered as *experimental* and *incomplete*.

If you are still brave enough to give it a try, here is how:

```java
// Create new service instance. It ist STATEFUL! Be sure to keep this instance.
EbikeConnectService service = new EbikeConnectService();

// Login: Throws LoginFailedException or returns response that contains user details.
EBCLoginResponse loginResponse = service.login("username", "p455w0rd");

// Retrieve header information about all recorded activities
EBCActivityHeadersResponse activities = service.getAllActivityHeaders();

// Retrieve details about a single activity. The startTime seems to be a kind of primary key for activities...
EBCActivityDetailsResponse actitiy = service.getActivityDetails(activities.get(0).getStartTime());

// Retrieve raw data of a single activity. Again, startTime is the "id"...
EBCRawActivityResponse rawActitiy = service.getRawActivity(activities.get(0).getStartTime());

// Finally log out
service.logout();
```