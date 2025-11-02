# MyTodoz - Application Android de Gestion de Tâches

## Description
MyTodoz est une application Android de gestion de tâches développée dans le cadre du cours Android à l'ESGI. Cette application est conçue pour démontrer les meilleures pratiques de développement Android en utilisant les technologies et architectures modernes.

## Structure du Projet

```
MyTodoz/
└── app/
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── example/
            │           └── mytodoz/
            │               ├── MainActivity.kt           # Point d'entrée de l'application
            │               │
            │               ├── data/
            │               │   ├── mapper/              # Convertisseurs de modèles
            │               │   ├── remote/              # Sources de données distantes
            │               │   └── repository/          # Implémentations des repositories
            │               │
            │               ├── domain/
            │               │   ├── models/
            │               │   │   └── Note.kt          # Modèle de domaine pour les notes
            │               │   ├── repository/          # Interfaces des repositories
            │               │   └── usecase/             # Cas d'utilisation
            │               │
            │               ├── ui/
            │               │   ├── components/          # Composants UI réutilisables
            │               │   ├── navigation/          # Configuration de la navigation
            │               │   ├── screens/
            │               │   │   ├── HomeScreen.kt    # Écran d'accueil
            │               │   │   ├── NoteDetailScreen.kt  # Détails d'une note
            │               │   │   └── SettingScreen.kt    # Écran des paramètres
            │               │   └── theme/               # Thèmes et styles de l'app
            │               │
            │               └── viewmodels/             # ViewModels (à implémenter)
            │
            ├── res/
            │   ├── layout/      # Layouts XML (si utilisé)
            │   ├── values/      # Ressources (strings, colors, etc.)
            │   └── drawable/    # Images et icônes
            │
            └── AndroidManifest.xml
```

## Technologies Utilisées
- **Langage**: Kotlin
- **Build System**: Gradle avec Kotlin DSL
- **Version Minimale Android**: 28
- **Architecture**: Clean Architecture (en cours d'implémentation)

## Architecture

L'application suit les principes de la Clean Architecture, qui sera implémentée progressivement au fil des séances. Cette architecture se compose de plusieurs couches :

```
                    UI (Presentation Layer)
                            ↑
                    ViewModels Layer
                            ↑
                    Use Cases Layer
                            ↑
                    Repository Layer
                            ↑
                Data Sources (Local/Remote)
```

### Évolutions Prévues

Dans les prochaines séances, nous allons enrichir l'application avec :

1. **Persistence des données**
   - Intégration de Room Database pour le stockage local
   - Implementation de DataStore pour les préférences utilisateur

2. **Injection de Dépendances**
   - Mise en place de Koin pour une gestion efficace des dépendances
   - Organisation modulaire du code

3. **Tests**
   - Tests unitaires avec JUnit
   - Tests d'intégration
   - Tests UI avec Espresso

4. **Fonctionnalités à venir**
   - CRUD complet des tâches
   - Catégorisation des tâches
   - Notifications pour les rappels
   - Synchronisation des données (optionnel)

## Clean Architecture

La Clean Architecture nous permettra de :
- Séparer les résponsabilités (Separation of Concerns)
- Rendre le code plus testable
- Faciliter la maintenance et l'évolution de l'application
- Minimiser les dépendances entre les modules

### Couches de l'Architecture

1. **Presentation Layer (UI)**
   - Activities/Fragments
   - Composables (si utilisation de Jetpack Compose)
   - ViewModels
   - States UI

2. **Domain Layer**
   - Use Cases
   - Modèles de domaine
   - Interfaces des repositories

3. **Data Layer**
   - Implémentations des repositories
   - Sources de données (Room, API, DataStore)
   - Modèles de données

## Comment Exécuter le Projet
1. Cloner le repository
2. Ouvrir le projet dans Android Studio
3. Synchroniser le projet avec Gradle
4. Exécuter l'application sur un émulateur ou un appareil physique

## Contribution
Ce projet est développé dans un cadre éducatif. Les contributions et suggestions sont les bienvenues via les issues et pull requests.
