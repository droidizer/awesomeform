# Awesome Form

## Introduction

## Table of contents

* [Introduction](#introduction)

* [How to install](#how-to-install)
	* [Gradle](#how-to-install#gradle)
	* [Adb](#how-to-install#adb)
* [How to run](#how-to-install)
	* [Gradle](#how-to-run#gradle)
	* [Adb](#how-to-run#adb)
* [How to build](#how-to-build)
	* [Gradle](#how-to-build#gradle)
	* [Adb](#how-to-build#adb)
* [Backend](#backend)
* [Contact](#contact)

## Known Issues

We strongly recommend using following guidelines:

1. Missing fab menu icon

2. Unimplemented Validation

3. Missing styles and some resource values are not extracted into the res files like dimensions and strings in layouts

4. Missing dynamic UI based on the validation form

## How to install

### HockeyApp

Download build here: https://rink.hockeyapp.net/apps/5935a969ed07402e933e845f1ddc1708

### Gradle

	gradle installDebug

## How to build
    
    gradle clean build 
	
## Backend

[Github Backend API](https://0523aec2.ngrok.io/)

## Contributor

* [Sowmya Guru](mailto:sowmyasguru@gmail.com)

# Additional Installation Notes

1. Install Homebrew

        ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
     
2. Install Java with cask

        brew tap caskroom/versions
        brew cask install java7      
       
3. (Optional) use set jdk script in [˜/.bash_profile](https://gist.github.com/kibotu/bee00e5876a3bc134f43)                

4. Install android sdk
    
        brew install android-sdk

5. Set android home

        export ANDROID_HOME="/usr/local/opt/android-sdk"
         
6. Install android api level and extras

        android sdk 
    
7. (Bonus) updates in the future:
        
        brew update
        brew upgrade
        
8. Setup recommended [˜/gradle.properties](https://gist.github.com/kibotu/2e9601e92fac05cff72b)