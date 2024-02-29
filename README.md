# Activity Manager - hidden activity launcher

Discover activities of installed applications, run them, and create shortcuts

This branch uses the BadParcel vulnerability (CVE-2023-20963) to launch all activities without root access.

Credits https://github.com/davinci1010/pinduoduo_backdoor/

This is only for use for legal activities! Use at your own risk.

Features:
----------
* Launch all activities without ROOT
* Create custom shortcuts for activities
* Set any shortcut icon from the storage or use from built-in Material icons
* Create and start any custom intents using Intent Builder
* Explore an app details with Manifest Viewer
* Light/Dark theme support

Screenshots:
----------
<div style="display:flex;">
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/1_apps_list.png"
        alt="Screenshot" width="30%" />
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/2_activities_list.png"
        alt="Screenshot" width="30%" />
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/3_create_shortcut.png"
        alt="Screenshot" width="30%" />
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/4_pick_shortcut_icon.png"
        alt="Screenshot" width="30%" />
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/5_intent_builder.png"
        alt="Screenshot" width="30%" />
    <img
        src="https://raw.githubusercontent.com/sdex/ActivityManager/master/metadata/en-US/images/phoneScreenshots/6_manifest_viewer.png"
        alt="Screenshot" width="30%" />
</div>

Build from the repo directly:
```
./gradlew assemble
```

Contributing to the project:
----------
[![Crowdin](https://badges.crowdin.net/activity-manager/localized.svg)](https://crowdin.com/project/activity-manager) \
[Translate the app on Crowdin](https://crowdin.com/project/activity-manager)

Support development:
----------
https://sdex.dev/donate/

License:
----------
**Activity Manager** is distributed under the terms of the Apache License (Version 2.0). \
See the [license](LICENSE) for more information.
