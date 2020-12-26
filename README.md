# OniLinker
Auto-generate oni.setting.json for oni bootstrap.

# Usage
```groovy
// (build.gradle)
dependencies{
    //...
    oniRuntime group: 'com.squareup.okhttp3', name: 'okhttp', version: '4.9.0'
    //It will be included by oni.setting.json in order to make this dependency download and loads when plugin was enabling.
}
oni{
    oniVersion = "..."
    bootstrapVersion = "..."
    //...
    // For the full details,see io.ib67.oni.OniSetting .
}
```