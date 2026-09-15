# Kahoot! Kids Premium Unlock Morphe Patch

Standard Morphe patch repository for Kahoot! Kids (`com.kahoot.kids` v1.3.4), built from the official [morphe-patches-template](https://github.com/morpheapp/morphe-patches-template).

## Project Structure

```
kahoot-kids-morphe-patch/
├── gradle/
│   ├── libs.versions.toml       # Gradle Version Catalog
│   └── wrapper/                 # Gradle Wrapper binaries
├── patches/
│   ├── build.gradle.kts         # Subproject patch build configuration
│   └── src/main/kotlin/
│       ├── app/kahoot/patches/kahootkids/
│       │   ├── premium/
│       │   │   ├── Fingerprints.kt        # AccountManager method fingerprints
│       │   │   └── UnlockPremiumPatch.kt  # Bytecode patch implementation
│       │   └── shared/
│       │       └── Constants.kt          # Compatibility constants
│       └── util/
│           └── PatchListGenerator.kt     # Registry descriptor generator
├── gradle.properties            # JDK 17 & GitHub Packages token configuration
├── gradlew                      # Linux/macOS Gradle wrapper
├── gradlew.bat                  # Windows Gradle wrapper
├── patches-bundle.json          # Morphe app bundle descriptor
├── patches-list.json            # Auto-generated patch registry
├── settings.gradle.kts          # Root settings & Morphe plugin declaration
└── README.md                    # Project documentation
```

## How to Build

### 1. Configure GitHub Packages Authentication
Open `gradle.properties` and add your GitHub username and Personal Access Token (PAT with `read:packages` scope):

```properties
gpr.user=YOUR_GITHUB_USERNAME
gpr.key=ghp_YOUR_PERSONAL_ACCESS_TOKEN
```

### 2. Build the `.mpp` Archive
Run the build script:

```cmd
gradlew.bat build
```

This generates `patches/build/libs/patches-1.0.0.mpp`.

### 3. Generate `patches-list.json`
Run the list generator:

```cmd
gradlew.bat generatePatchesList
```

### 4. Deploy to Morphe
1. Commit and push to GitHub.
2. Create a GitHub Release `v1.0.0` and attach `patches-1.0.0.mpp`.
3. Add the repo URL as a patch source in the Morphe app!
