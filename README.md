<div>
<!-- 排版来自 https://github.com/v2fly/v2ray-core -->
  <img width="190" height="210" align="left" src="https://i.loli.net/2020/12/27/wZx2XOPEIYQh5KT.png" alt="Logo"/>
  <br>
  <h1><a href="https://github.com/saltedfishclub/Oni">Oni</a></h1>
  <p>Oni is a set of bukkit tools that focus on speed-up development and reduce redundant codes, and it has many advanced features and flexible modules, too.<br>
    <img src="https://img.shields.io/github/license/saltedfishclub/Oni"> <img src="https://img.shields.io/github/workflow/status/saltedfishclub/Oni/Java%20CI%20with%20Gradle"> <img src="https://img.shields.io/discord/612522451200638991"> <img src="https://img.shields.io/tokei/lines/github/saltedfishclub/Oni">
  </p>
</div>



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