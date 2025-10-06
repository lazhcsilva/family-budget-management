# 💰 Family Budget Management

> A work-in-progress system for **family budget management**, allowing users to record income and expenses, and track their financial health over time.

---

## 📘 About the Project

**Family Budget Management** is a system designed to help individuals or families manage their finances efficiently.  
The goal is to provide a simple, intuitive, and organized way to **track earnings and expenses**, supporting better financial planning.

This project is still in its early stages, but its foundation is being built with **Gradle** and clean project structure best practices.

---

## 🧱 Project Structure

```
family-budget-management/
├── gradle/
│   └── wrapper/
├── src/
│   └── (main source code)
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md
```

**Summary:**
- `gradle/` → Build automation scripts  
- `src/` → Main application source code  
- `build.gradle.kts` → Gradle configuration (Kotlin DSL)  
- `.gitignore` → Files and folders ignored by Git  

---

## ⚙️ Technologies Used

| Category | Tool |
|-----------|------|
| Main language | 🧩 _Kotlin_ *(or Java, depending on final implementation)* |
| Build Tool | ⚙️ Gradle (Kotlin DSL) |
| Database | 🗄️ (to be defined — e.g. H2, PostgreSQL, SQLite) |
| Frameworks | 🌱 Spring Boot, JPA/Hibernate |
| Testing | 🧪 JUnit, Mockito |
| Version Control | 🐙 Git / GitHub |

*(This list will be updated as development progresses.)*

---

## 🚀 How to Run the Project

1. **Clone the repository**
   ```bash
   git clone https://github.com/lazhcsilva/family-budget-management.git
   cd family-budget-management
   ```

2. **Build and run**
   ```bash
   ./gradlew clean build
   ./gradlew run
   ```
   or, on Windows:
   ```bat
   gradlew.bat clean build
   gradlew.bat run
   ```

3. **Access the system**
   ```
   http://localhost:8080
   ```
   *(Port and endpoints may change as the project evolves.)*

---

## 🧩 Features (Roadmap)

| Status | Feature |
|:------:|----------|
| ✅ | Project structure with Gradle |
| 🔄 | Base application setup |
| ⬜ | Income registration |
| ⬜ | Expense registration |
| ⬜ | Monthly summary dashboard |
| ⬜ | Filtering by period |
| ⬜ | Reports and exports |
| ⬜ | User authentication |
| ⬜ | Database persistence |
| ⬜ | Web interface / REST API |

---

## 🧱 Suggested Package Structure

```
src/main/java
  └── com/familybudget/
        ├── controller/
        ├── service/
        ├── repository/
        ├── model/
        └── dto/

src/test/java
  └── com/familybudget/
        └── (unit and integration tests)
```

---

## 🤝 Contributing

Contributions are **welcome**! 💬  
You can open issues, suggest improvements, or submit pull requests.

Before contributing:
- Ensure code is formatted and tested  
- Write clear commit messages  
- Describe changes clearly in the PR  

---

## 🧾 License

This project will be licensed under an open license (to be defined, e.g., MIT or Apache 2.0).

---

## 👨‍💻 Author

Developed by **[Lázaro Henrique Silva](https://github.com/lazhcsilva)**  
💡 *Software analyst and developer passionate about creating practical and organized solutions.*

---
