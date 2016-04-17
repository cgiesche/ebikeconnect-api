[![Build Status](https://travis-ci.org/cgiesche/ebikeconnect-api.svg?branch=master)](https://travis-ci.org/cgiesche/ebikeconnect-api)

**JAX-RS client implementation for accessing ebike-connect services.**

This library allows you to access ebike-connect HTTP services. It is currently in an early development state and therefore to be considered as *experimental* and *incomplete*.

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

// Finally log out
service.logout();
```