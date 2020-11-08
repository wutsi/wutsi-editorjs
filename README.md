Kotlin library for [Editorjs](https://editorjs.io/) for read/writing editorjs documents.

![](https://github.com/wutsi/wutsi-editorjs/workflows/build/badge.svg)
![](https://img.shields.io/badge/jdk-1.8-brightgreen.svg)
![](https://img.shields.io/badge/language-kotlin-blue.svg)

# Prerequisites
- JDK 1.8
- Maven 3.6+ 

# Usage
```xml
<dependency>
    <groupId>com.wutsi</groupId>
    <artifactId>wutsi-editorjs</artifactId>
    <version>[LATEST VERSION]</version>
</dependency>
```

Package available [here](https://github.com/wutsi/wutsi-editorjs/packages)

# Features
- [EJSDocument](https://github.com/wutsi/wutsi-editorjs/blob/master/src/main/kotlin/com/wutsi/editorjs/dom/EJSDocument.kt) 
support EditorJS DOM structure
- [EJSJsonReader](https://github.com/wutsi/wutsi-editorjs/blob/master/src/main/kotlin/com/wutsi/editorjs/json/EJSJsonReader.kt)
converts a JSON string to a `EJSDocument` 
- [EJSJsonWriter](https://github.com/wutsi/wutsi-editorjs/blob/master/src/main/kotlin/com/wutsi/editorjs/json/EJSJsonWriter.kt)
converts a `EJSDocument` to a JSON string. 
- [EJSHtmlReader](https://github.com/wutsi/wutsi-editorjs/blob/master/src/main/kotlin/com/wutsi/editorjs/html/EJSHtmlReader.kt)
converts a HTML string to a `EJSDocument` 
- [EJSHtmlWriter](https://github.com/wutsi/wutsi-editorjs/blob/master/src/main/kotlin/com/wutsi/editorjs/html/EJSHtmlWriter.kt)
converts a `EJSDocument` to a HTML string. 
