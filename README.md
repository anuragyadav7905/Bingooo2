# 🎲 Bingooo

**Play. Compete. Win!**

A real-time multiplayer Bingo game with matchmaking, trophies, and a friend system. Challenge random players or compete with friends — all from your phone.

> **Web Version** — Built by [@Prateekbh111](https://github.com/Prateekbh111)
> **Android App** — Built by Anurag Yadav

---

## 📱 Screenshots

<p align="center">
  <img src="screenshots/splash.png" width="200" alt="Splash Screen"/>
  <img src="screenshots/home.png" width="200" alt="Home Screen"/>
  <img src="screenshots/friends.png" width="200" alt="Add Friend"/>
  <img src="screenshots/matchmaking.png" width="200" alt="Matchmaking"/>
</p>
<img width="1080" height="2400" alt="Screenshot_20250826_024931" src="https://github.com/user-attachments/assets/af4ac7f1-666f-40ef-9dd6-77ae26157622" />


---

## ✨ Features

- **Join Random Game** — Instant matchmaking with online players
- **Play with Trophies** — Ranked matches where you wager trophies (start with 100)
- **Friend System** — Add friends by username and challenge them directly
- **Google Sign-In** — Quick and secure authentication
- **Real-time Multiplayer** — Live Bingo gameplay with another player
- **Deep Link Support** — Seamless login redirect back into the app

---

## 🏗️ Architecture

The project has two parts:

| Component | Tech | Repo |
|-----------|------|------|
| **Web App** (game logic, backend, UI) | Hosted at [bingooo.site](https://bingooo.site) | [Prateekbh111/Bingo](https://github.com/Prateekbh111/Bingo) |
| **Android App** (native wrapper) | Java, WebView, Android SDK | This repo |

The Android app is a native shell that wraps the web app using a `WebView`. It handles:

- **Splash screen** with branding and loading indicator
- **Google login flow** via deep links (`https://bingooo.site/dashboard`)
- **Session persistence** using `SharedPreferences` — stays logged in across app restarts
- **WebView configuration** — JavaScript enabled, DOM storage, custom user agent

---

## 🛠️ Tech Stack

- **Language:** Java
- **Min SDK:** 21 (Android 5.0 Lollipop)
- **Target SDK:** 35 (Android 15)
- **Build System:** Gradle (Kotlin DSL)
- **Dependencies:** AndroidX AppCompat, Material Design, ConstraintLayout, AndroidX Browser

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Arctic Fox or later)
- JDK 17
- An Android device or emulator (API 21+)

### Build & Run

1. Clone the repo:
   ```bash
   git clone https://github.com/Prateekbh111/Bingo.git
   cd Bingo
   ```

2. Open the project in Android Studio.

3. Sync Gradle and run on your device/emulator.

### Adding Screenshots to Repo

Create a `screenshots/` folder in the root and add the app screenshots:

```
screenshots/
├── splash.png
├── home.png
├── friends.png
└── matchmaking.png
```

---

## 📂 Project Structure

```
app/src/main/
├── java/com/bingooo/game/
│   ├── SplashActivity.java      # Splash screen + deep link handler
│   └── WebViewActivity.java     # WebView to load the game
├── res/
│   ├── layout/
│   │   ├── activity_splash.xml  # Splash UI (logo + tagline + spinner)
│   │   └── activity_webview.xml # Full-screen WebView
│   ├── values/
│   │   ├── themes.xml           # Dark theme with black status bar
│   │   └── colors.xml
│   └── drawable/                # App icons and launcher assets
└── AndroidManifest.xml          # Permissions, activities, deep links
```

---

## 🔗 Deep Link Flow

```
User taps "Sign in with Google"
    → Opens browser for OAuth
    → Google redirects to https://bingooo.site/dashboard
    → Android intercepts via intent-filter
    → SplashActivity saves login state
    → WebViewActivity loads dashboard
```

---

## 📋 Version

| Field | Value |
|-------|-------|
| **Version Name** | 1.0 |
| **Version Code** | 1 |
| **Package** | `com.bingooo.game` |
| **Status** | Initial Release |

---

## 🔮 Roadmap

- [ ] Push notifications for friend requests and game invites
- [ ] In-app game sounds and haptic feedback
- [ ] Offline mode / practice with bots
- [ ] Leaderboard screen
- [ ] Custom Bingo themes

---

## 🤝 Credits

- **Web App & Backend** — [Prateek Bhardwaj (@Prateekbh111)](https://github.com/Prateekbh111)
- **Android App** — Anurag Yadav

---

## 📄 License

This project is open source. See the repository for license details.
