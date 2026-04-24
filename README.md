Hack or Myth?

An engaging Android flashcard quiz app that challenges users to decide whether everyday “life hacks” are real or just urban myths.
It’s designed to make critical thinking fun by turning misinformation awareness into a fast-paced quiz game.

About the App

In a world full of viral tips and online advice, it’s easy to believe things without questioning them.
Hack or Myth? helps users:
•	Think critically about common claims 
•	Learn fun facts vs misconceptions 
•	Improve knowledge through interactive gameplay 

Features

•	Flashcard-based quiz (12 curated questions per session) 
•	Randomized questions every playthrough 
•	Instant feedback with animations and color cues 
•	Live score tracking and progress indicator 
•	Tiered result system based on performance 
•	Detailed answer review with explanations 
•	Repayable gameplay with reshuffled questions 
•	State-safe (handles screen rotation) 
•	Modern Material Design 3 dark theme 
•	CI/CD pipeline with GitHub Actions 

How the Quiz Works

•	Questions are loaded from a predefined dataset 
•	A current Index tracks progress through the flashcards 
•	Each tap moves to the next question 
•	At the end, the app calculates and displays a final score 
•	Results are categorized into performance tiers 


Score System

Score	Level	Message
7+	🏆 High	Master Hacker!
4–6	👍 Medium	Great job! Keep it up!
0–3	📚 Low	Stay Safe Online! Keep practising!

Tech Stack

•	Kotlin 
•	Android SDK (API 24+) 
•	Material Design 3 
•	View-based XML UI 
•	GitHub Actions (CI/CD) 
•	Gradle Kotlin DSL 

Project Structure

app/
├── data/                 # Flashcard models & data
├── adapters/            # RecyclerView adapters
├── ui/
│   ├── WelcomeActivity
│   ├── QuestionActivity
│   ├── ScoreActivity
│   └── ReviewActivity
├── res/
│   ├── layout/
│   ├── values/
│   ├── drawable/
│   └── anim/
└── test/                # Unit tests




Running the Project

Prerequisites
•	Android Studio Hedgehog+ 
•	JDK 17 
•	Android SDK 34 

Steps:
git clone https://github.com/EvelynAkeyo/Hack-or-Myth.git
cd Hack-or-Myth
Then:
•	Open in Android Studio 
•	Let Gradle sync finish 
•	Click ▶ Run

Testing
Run unit tests:
./gradlew test
CI/CD Pipeline
Every push triggers:
•	Automatic build (APK generation) 
•	Unit test execution 
•	Artifact upload 

Demo

https://www.youtube.com/shorts/ZM1v5wYhtpM

Author

Evelyn Akeyo
GitHub: https://github.com/EvelynAkeyo 

Note

This project was developed as part of an educational assignment focused on Android development, UI design and testing practices.


