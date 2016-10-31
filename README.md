# PasswordManager

This is an example application showcasing the main features of the brand new Realm Mobile Platform.

The example consists of two flavors, free an pro. The *free version* is a *fully functional* password manager limited to offline usage only. The *pro version* adds protected cloud backup and realtime sync functionality.

Realm's features demonstrated:
- free: models, relationships, queries, transactions, auto-updates
- pro: user creation, authentication, synchronizazion

For more information check the [slides](https://speakerdeck.com/a11n/hands-on-realm-mobile-platform).

##Setup

Server
- [Download and install](https://realm.io/docs/realm-object-server/#install-realm-object-server) Realm Mobile Platform
- start Realm Object Server

Client
- when running on Android Emulator on the same machine as the Realm Object Server nothing needs to be changed
- otherwise go to `build.gradle` and adapt the following line to your Realm Object Server's IP address and port

```groovy
buildConfigField "String", "REALM", "\"10.0.2.2:9080\""
```

![](gdg-password-manager.png)

##Credits
[Social media icons](http://www.flaticon.com/packs/social-media-logos-2) designed by [Freepik](http://www.freepik.com) and distributed by [Flaticon](http://www.flaticon.com).
