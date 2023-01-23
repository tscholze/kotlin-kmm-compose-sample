# Sample for KMM with shared Compose UI

## tl;dr
This is currently a playground to get to know with [Kotlin Mobile Multiplatform](https://kotlinlang.org/lp/mobile/) in combination with a shared Jetpack Compose UI.

## Build status

|Service|Status|
|-------|------|
|-|-|

## Feature roadmap

### Setup
- [x] Setup shared ui `:shared:commonMain` to contain Jetpack Compose ui
- [x] Setup `:shared:androidMain` to containerizes and use `:shared:commonMain` ui
- [x] Setup `:shared:iOSMain` to containerizes and use `:shared:commonMain` ui
- [x] Setup a new `:desktopApp` that must use shared ui
- [x] Strip down `:androidApp` to use shared ui
- [x] Strip down `:iOSApp` app to use shared ui
- [x] Get rid of `:iOSApp` build log flodding

### UI
- [ ] Create a fake but real world example of an app ui
- [ ] Evaluate how the translation from Android JPC controls like `BottomBar` works in iOS
- [ ] Evaluate how it would be possible to create "custom" ui for each platform but use it in `:shared:commonMain`

### Shared functionality
- [ ] Evaluate how to use features like pushes
- [ ] Evaluate best practices for logging and crash statistics

### Instruments
- [ ] Check how's the memory consumption
- [ ] Check if there is no memory leakage

## Version overview

### 0.0.2
**Main feature**

- Added `ResourceReader` as `actual` and `expected` implementation
- Added CSV parsing for German license plate names
- Added more "complex" UI with keyboard events

**UI**

![Version 0.0.2](https://github.com/tscholze/kotlin-kmm-compose-sample/blob/main/docs/v002-min.png?raw=true "Version 0.0.2")

### 0.0.1
**Main feature**

Project setup and basic Jetpack Compose UI sharing between `:androidApp`, `:iosApp` and `:shared`

**UI**

![Version 0.0.1](https://github.com/tscholze/kotlin-kmm-compose-sample/blob/main/docs/v001-min.png?raw=true "Version 0.0.1")

## Special thanks to
- [David Herman](https://github.com/bitspittle) for helping me with all Kotlin
- [Adrian Witaszak](https://github.com/charlee-dev) for helping me to get started with KMM and shared ui

## Get in touch
If you wanna talk about Kotlin, KMM, Shared Compose UI, Jetpack Compose pr Jetpack Compose for Web, I would highly recommend to join David's tiny but [awesome Discord server](https://discord.com/invite/5NZ2GKV5Cs) for his awesome CfW-enhancing web framework called [Kobweb](https://kobweb.varabyte.com). I never meet such brilliant folks that are not too "good" to help beginners.


## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
Dependencies or assets maybe licensed differently.
