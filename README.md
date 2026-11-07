# Custom plugin repository

This branch only hosts `updatePlugins.xml`, an IntelliJ custom plugin repository index.
Plugin sources live on the `gwt` branch; zips are attached to GitHub Releases.

In IntelliJ IDEA: **Settings → Plugins → ⚙ → Manage Plugin Repositories…**, add:

```
https://raw.githubusercontent.com/abeloin/intellij-obsolete-plugins/plugin-repository/updatePlugins.xml
```

To publish a new version: run the release workflow on `gwt`, then bump `version` and `url`
(and `since-build` if needed) for the plugin entry here.
