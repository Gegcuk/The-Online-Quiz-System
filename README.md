# Online Quiz System

## Introduction

The Online Quiz System is designed to allow users to take quizzes on various topics, manage quizzes and questions, and view their performance through detailed analytics.

## Technologies and Patterns

- **Java SE:** Core programming
- **Spring Boot:** For building the web application
- **Thymeleaf:** For creating dynamic web pages
- **Hibernate:** For ORM to manage database operations
- **H2 Database:** For in-memory database during development
- **JUnit:** For unit testing
- **RESTful APIs:** To create endpoints for quizzes and questions
- **Docker:** To containerize the application
- **Bootstrap:** For responsive UI design
- **Design Patterns:** Builder, Singleton, Strategy

## Features

### User Roles and Permissions

#### Admin
- Create, edit, and delete quizzes and questions
- Manage user accounts
- View detailed quiz analytics

#### User
- Register and log in
- Take quizzes
- View quiz results and progress

### Core Features

- **User Management**
  - User Registration
  - User Login
  - User Profile
  - Admin Roles

- **Quiz Management**
  - Create, Edit, Delete Quiz
  - List Quizzes

- **Question Management**
  - Create, Edit, Delete Question
  - Attach Questions to Quizzes

- **Taking Quizzes**
  - Start Quiz
  - Timer
  - Submit Quiz
  - View Results
  - Retake Quiz

- **UX Features**
  - Search and Filter
  - User Feedback
  - Responsive Design
  - Navigation and Accessibility

- **Reporting and Analytics**
  - User Progress
  - Leaderboard
  - Quiz Statistics

- **Notifications**
  - Quiz Reminders
  - Score Notifications
  - Admin Notifications

### Optional Features (Future Enhancements)

- Rate Quiz
- Leave Comments
- Leaderboard
- Advanced Reporting and Analytics
- Quiz Categories
- Difficulty Levels
- Tagging
- Quiz Import/Export
- Multi-language Support
- Special Quiz Types Support (Jeopardy, Millionaire, Crosswords, Pub Quizzes)

## Database Schema

- **Users Table**
- **Quizzes Table**
- **Questions Table**
- **Answers Table**
- **QuizAttempts Table**
- **AttemptAnswers Table**
- **Categories Table**
- **Ratings Table**
- **Notifications Table**
- **Lifelines Table**
- **CrosswordGrids Table**
- **CrosswordHints Table**
- **Teams Table**
- **TeamMembers Table**
- **Rounds Table**
