[![](https://jitpack.io/v/dangnhat99/Android-GetEmailDialog.svg)](https://jitpack.io/#dangnhat99/Android-GetEmailDialog)

`Android GetEmailDialog` is an easy IntroScene UI implement library for `Android`.

Screenshot
---

![Demo](scrshots/scr1.jpg)
![Demo](scrshots/scr2.jpg)

How do I use it?
---

### Setup

## Prerequisites
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```


##### Dependencies
Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):
```groovy
dependencies {
   implementation 'com.github.dangnhat99:Android-GetEmailDialog:1.0'
}
```

### Functions

**In activity**

```java
            //show GetEmail Dialog
            GetEmailDialog emailDialog = new GetEmailDialog(new GetEmailDialog.GetEmailCallback() {

            @Override
            public void onYesButtonClick(String email) {
                Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoButtonClick() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });

        emailDialog.show(getSupportFragmentManager(), "YOUR_TAG");
```


**In fragment**  
```java
// from View
       //show intro scene
        GetEmailDialog emailDialog = new GetEmailDialog(new GetEmailDialog.GetEmailCallback() {

            @Override
            public void onYesButtonClick(String email) {
                Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoButtonClick() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });

        emailDialog.show(getChildFragmentManager(), "YOUR_TAG");
```

**GetEmailDialog Options**

- emailDialog.setTitle(String title)
- emailDialog.setSubTitle(String subTitle)
- emailDialog.setYesTitle(String yesTitle)
- emailDialog.setNoTitle(String noTitle)


Developed By
-------
Dmnhat 
