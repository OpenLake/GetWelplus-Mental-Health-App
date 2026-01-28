# GetWell+

GetWell+ is an Android mental wellness app built with Jetpack Compose. It includes stress analysis tools, mood tracking, guided relaxation flows, and a Gemini-powered chatbot, with Firebase for auth/data and other services.

This repo is organized as a multi‑module Android project, with a feature‑first structure and shared core modules for common UI/data. Each feature is isolated in `feature/*`, while app‑wide types live in `core/*`.

## Features
- Stress assessment, quizzes, and tracking
- Mood journaling and analytics
- Guided relaxation (breathing, meditation, imagery)
- Gemini AI chatbot and recommendations
- Firebase Auth, Firestore, Storage, Messaging, Crashlytics, Performance

## Tech Stack
- Kotlin + Jetpack Compose
- Firebase (Auth, Firestore, Storage, Messaging, Crashlytics, Perf)
- Google AI Gemini SDK
- Stream Chat (chat UI)
- CameraX + ML Kit (face detection)
- Retrofit + OkHttp
- WorkManager (background reminders)
- Paging (resource feeds)

## Getting Started

### Prerequisites
- Android Studio Otter or newer
- JDK 17
- Android SDK + Build tools (set in `local.properties` or Android Studio SDK Manager)
- A Firebase project (required for Auth/Firestore/Storage/Crashlytics)
- (Optional) Google AI Studio key (Gemini)
- (Optional) Stream Chat API key

### 1) Clone and open
Open the project in Android Studio and let Gradle sync once.
If Gradle fails due to SDK path issues, ensure `sdk.dir` is set in `local.properties`.

Recommended Android Studio setup:
- Gradle JDK = 17
- Android SDK: install Platform + Build‑Tools for the target compile SDK
- Kotlin plugin is bundled with Android Studio

### 2) Firebase setup (required)
1. Create a Firebase project.
2. Add an Android app with package name `com.example.getwell`.
3. Download `google-services.json` and place it in `app/`.
4. Enable the Firebase products your build uses (Auth, Firestore, Storage, Messaging, Crashlytics, Performance).
5. For Google Sign-In, add your SHA-1/256 fingerprint(s) in Firebase (debug and release if needed).
6. Download a fresh `google-services.json` after adding SHA fingerprints.

To get the debug SHA:
```
./gradlew signingReport
```
Use the `SHA1` shown under the `debug` variant of the `app` module.

### 3) Secrets configuration (Gemini, Stream Chat, Facebook, etc.)
Secrets are loaded from `local.properties` and injected into string resources at build time.

Copy `local.properties.example` to `local.properties` and fill in the values:

```
sdk.dir=/path/to/Android/Sdk
GEMINI_API_KEY=your_gemini_api_key
STREAM_CHAT_API_KEY=your_stream_chat_api_key
GOOGLE_WEB_CLIENT_ID=your_google_web_client_id.apps.googleusercontent.com
```

Notes:
- `GOOGLE_WEB_CLIENT_ID` must match the OAuth client configured in Google Cloud.
- If you don’t use a provider, leave it blank. Related features won’t work.
- These values are compiled into `BuildConfig`/resources at build time. Do not commit `local.properties`.

### 4) Build & run
- Sync Gradle
- Run the `app` configuration on an emulator or device
- CLI build:
  - `./gradlew assembleDebug`
  - `./gradlew test`
- Install to a connected device:
  - `./gradlew installDebug`
  - `adb shell am start -n com.example.getwell/.MainActivity`

### 5) Verify integrations (optional but recommended)
- Google Sign‑In: verify OAuth consent screen + SHA fingerprints
- Gemini: verify your API key in `local.properties`
- Stream Chat: verify API key and test chat screen

## Architecture Overview
The app follows a feature‑first modular structure with shared core modules:
- **app**: entry point (Activities, NavigationGraph, DI root, manifests)
- **core/common**: shared models, navigation routes, cross-feature types
- **core/data**: repositories/providers, domain utilities, shared data sources
- **core/ui**: theme + shared UI components and common assets

### Data flow (typical)
UI (Compose screen) → ViewModel → Repository/Provider → Firebase/Network/Local → UI state

### Navigation
- Navigation routes are defined in `core/common`.
- The root `NavigationGraph` lives in `app` and wires callbacks to avoid feature→app dependencies.

### Dependency Injection
- Hilt is used for DI. The application entry is `StressApp` in `app/`.
- Feature modules provide their own Hilt modules when needed.

## Project Structure
This project is modularized by feature, with shared core modules:

```
app/                    # Application module: activities, navigation graph, DI root, manifests
core/
  common/               # App-wide models, navigation routes, shared types
  data/                 # Repositories/providers, data sources, domain utilities
  ui/                   # Shared UI (theme, common components, shared drawables/fonts)
feature/
  auth/                 # Auth flows (sign-in/sign-up/reset)
  onboarding/           # Onboarding screens
  home/                 # Home dashboard
  relax/                # Relaxation flows, games, meditation, daily reflection
  stress/               # Stress quizzes, AI stress analysis, recommendations
  resources/            # Educational/practical resources and wellness centers
  profile/              # Profile and analytics
  settings/             # Settings and account management
  chatbot/              # Gemini chatbot UI and data layer
```

### Package layout (high‑level)
```
com.example.getwell/
  data/                 # Shared routes/models in core/common
  screens/              # Compose screens (mostly feature modules)
  di/                   # Hilt modules (module‑specific)
  viewmodel/            # ViewModels and UI state
```

### Feature‑to‑module mapping
- Auth flows → `feature/auth`
- Onboarding → `feature/onboarding`
- Home dashboard + entry cards → `feature/home`
- Relaxation (breathing/meditation/games) → `feature/relax`
- Stress quiz + analysis → `feature/stress`
- Resources + guides + centers → `feature/resources`
- Profile + analytics → `feature/profile`
- Settings → `feature/settings`
- Gemini chatbot → `feature/chatbot`

### Module boundaries (high-level)
- Feature modules should not depend on `app` (use callbacks from `NavigationGraph`).
- Shared UI/resources live in `core/ui`.
- Shared data/domain logic lives in `core/data` and `core/common`.

### Key entry points
- App entry: `app/src/main/java/com/example/getwell/MainActivity.kt`
- Navigation: `app/src/main/java/com/example/getwell/screens/NavigationGraph.kt`
- Shared routes: `core/common/src/main/java/com/example/getwell/data/Screen.kt`

### Build config & secrets injection
- Secrets are read from `local.properties` at build time.
- They are exposed as `BuildConfig` fields or string resources.
- Keep secrets out of source control (see `.gitignore`).

## Configuration & Build Variants
- **Debug** is used for local development.
- Release builds require signing config and release SHA‑1/256 in Firebase if using Google Sign‑In.

## Testing
- Unit tests: `./gradlew test`
- Build verification: `./gradlew assembleDebug`
- Lint: `./gradlew lint`

## Contributor workflow
1. Pick the feature module you’ll work on (`feature/*`).
2. Keep shared UI in `core/ui` and shared data in `core/data` or `core/common`.
3. Run `./gradlew test` after each significant change.
4. For UI changes, build `./gradlew assembleDebug` and smoke‑test the relevant screens.

## Contributing
Contributions are welcome! Please open an issue or PR with a clear description.

### Setup guidelines for contributors
1. **Sync & verify**  
   - Open in Android Studio and let Gradle sync.  
   - Run `./gradlew test` to confirm baseline.
2. **Local secrets**  
   - Copy `local.properties.example` → `local.properties` and fill required values.
3. **Firebase**  
   - Ensure `google-services.json` is present in `app/` and Firebase products are enabled.
4. **Feature work**  
   - Keep changes contained within the relevant feature module.  
   - Shared UI goes to `core/ui`, shared data to `core/data` or `core/common`.
5. **Testing**  
   - Run `./gradlew test` after each significant change.  
   - For UI changes, also run `./gradlew assembleDebug` and smoke test the affected screens.

### Common commands
```
./gradlew test
./gradlew assembleDebug
./gradlew lint
```

## Setup checklist (quick)
- [ ] Android Studio syncs with JDK 17
- [ ] `sdk.dir` set in `local.properties`
- [ ] `google-services.json` in `app/`
- [ ] Firebase products enabled
- [ ] SHA‑1/256 set in Firebase
- [ ] `local.properties` contains required secrets
- [ ] `./gradlew test` passes
- [ ] `./gradlew assembleDebug` builds



## Security
- Do not commit `local.properties` or `google-services.json`.
- Never commit API keys or keystores.



## License
TBD
