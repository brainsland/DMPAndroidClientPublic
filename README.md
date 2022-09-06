# DMPClient

DMPClient Android SDK

## Installation

### Android Archive (AAR)
```
implementation files('libs/dmpclient-release.aar')
```

### Manually
You can download and embed the [framework](https://github.com/brainsland/DMPAndroidClientPublic/blob/master/dmp/libs/dmpclient-release.aar) manually.

## Setup
Firstly, you need to configure DMPClient SDK by calling `setup` when the app is started, ideally at `Application`'s `onCreate` function:

```kotlin
DMP.setup(this, projectId = "usertest", url = "https://backend.com/api", language = "tr")
```

## Logging
You can enable developer mode to get detailed logs from SDK.

```kotlin
DMP.setup(this, ...., enableLogging = true)
```

## Tracking
SDK collects most of data automatically, like sent time, timezone, session identifier. Tracking requests through `DMP` instance are explained below. Any activity/fragment that use tracking, must call `pageView` function on its `onResume` function as explained below. This way, SDK can track page durations automatically and reuse page identifiers.

### Page View
Any page that is needed to be tracked, should use `pageView` function. PageView function returns unique page and page view identifiers which represents calling page. Initialy, when the view controller is **resumed**, this function will return the identifiers. **You must save that info on activity to pass it to the sdk, when the controller is resumed.**

```kotlin
override fun onResume() {
    super.onResume()
    val request = PageViewRequest(
        url = "https://example.com/",
        canonicalUrl = "",
        title = "",
        referrer = "r",
        infiniteScrollDepth = 0
    )
    DMP.pageView(this, request)
}
```

### Page Duration
Page durations are tracked through `pageView` requests automatically through saved `PageViewInfo`. Implementing `pageView` mentioned above will be enough to get necessary functionality.

### Breadcrumb
```kotlin
DMP.breadcrumb(breadcrumb1 = "b1", breadcrumb2 = "b2", breadcrumb3 = "b3", breadcrumb4 = "b4", breadcrumb5 = "b5")
```

### Scroll Position
```kotlin
DMP.scrollPosition(12)
```

### Track Zone
```kotlin
DMP.trackZone(type = "z1", value = "v1")
```

### Track User
```kotlin
DMP.trackUser(type = "u_gold", id = "123")
```

### Page Event
```kotlin
DMP.pageEvent(category = "c", action = "a", label = "l", value = "v")
```

### Article
```kotlin
DMP.newsArticle(
  NewsArticle(
    newsUrl = "",
    headline = "",
    description = "",
    section = "s",
    author1 = "a1",
    author2 = "",
    author3 = "",
    image1 = "i1",
    image2 = "",
    image3 = "",
    keywords = "ss,ss",
    info = "info",
    datePublished = Date(),
    dateModified = Date(),
    wordCount = 3
  )
)
```

### Gallery
```kotlin
DMP.gallery("https://backend.com/image.png", quantity = 10)
```

### Gallery View
```kotlin
DMP.galleryView("https://backend.com/image.png", index = 3)
```
