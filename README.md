# **INTRODUCTION**

_**Library_For_You**_ is an Open Source Android library that allows developers to easily get all data from rss news pages, all video on youtube from key-search, and several image processing algorithms. <br>
Besides, We support 133 kinds of screens, help you in multi-screen design from 120dp to 1440dp. <br>
Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app. Support Sdk Version 16 to lastest. <br>

# **FEATURE**
* Currently supporting data from 6 major Vietnam news sites and 4 international famous news sites: VNExpress, Dan Tri, 24H, Tuoi Tre, Vietnam.net, Stars, The New York Times, Mail Online, HuffPost, WSJ (The Wall Street Journal)
* Only 2 lines of code retrieve all related videos via keywords.
* Make sure the data retrieval speed is the fastest
* Image processing: Dividing the bitmap into a 2-dimensional array, increasing or decreasing the three major RGB colors

# **HOW TO USE**
![image](https://user-images.githubusercontent.com/40598538/50790196-d8303600-12f0-11e9-8e34-cbfa6faaebbe.png)

## **_Get all data from RSS news page:_**


**TypePage typePage = new TypePage();** <br>
**typePage.getPageVnExpress(urlRSS);** <br>
**typePage.getPageNytimes(urlRSS);** <br>

## **Get all video on youtube from key-search:** 
**GetItemYoutube getItemYoutube = new GetItemYoutube();** <br>
**getItemYoutube.LoadJSON(key,key_search,10,SearchYoutubeActivity.this,listVideo);** <br>
String key: key api Youtube_v3 <br>
String key_search: key_search <br>
int 10: number of videos taken <br>
SearchYoutubeActivity.this: context or activity contain listview <br>
listVideo: listView to contain data <br>

## **Image Processing**
**ImageProcessing.doGreyscale(bitmap);** <br>
Input: bitmap <br>
Output: bitmap is processed <br>

Others: ImageProcessing.decreaseColorDepth, ImageProcessing.doBrightness, ImageProcessing.doGreyscale, ImageProcessing.doInvert, ImageProcessing.createContrast, ImageProcessing.createSepiaToningEffect, ImageProcessing.doGamma, ImageProcessing.rotate, ImageProcessing.engrave, ImageProcessing.boost, ImageProcessing.applyFleaEffect, ImageProcessing.applyBlackFilter, ImageProcessing.applyGaussianBlur, ImageProcessing.applyMeanRemoval, ImageProcessing.applyReflection, ImageProcessing.applySnowEffect.

## **SDP multi-screen design**
When designing replace dp to sdp

## 
