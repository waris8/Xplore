# Xplore - Event Management Platform

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0+-6DB33F.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Xplore is a comprehensive event management platform that connects event organizers with attendees. Built with Spring Boot, it provides a robust backend for discovering, managing, and participating in various types of events.

## ✨ Features

### User Management
- User profiles with contact information
- Multiple user types (Regular, Organizer, etc.)
- Profile verification system
- User authentication and authorization

### Event Management
- Create and manage public/private events
- Detailed event information including:
  - Event descriptions and categories
  - Venue details with address mapping
  - Date, time, and duration
  - Age and gender restrictions
  - Capacity management
  - Event images gallery

### Media Handling
- Photo upload and retrieval
- Cloud storage integration
- Image processing capabilities

### Interactive Features
- Virtual rooms for events
- Real-time event updates
- User engagement metrics

## 🛠️ Technical Stack

- **Backend Framework**: Spring Boot 3.0+
- **Java Version**: 17+
- **Build Tool**: Maven
- **Database**: Relational Database (JPA/Hibernate)
- **API**: RESTful web services
- **File Storage**: Configurable (Local/Cloud)

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.3 or higher
- MySQL/PostgreSQL (or your preferred RDBMS)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/xplore.git
   cd xplore
   ```

2. **Configure the database**
   - Update `application.properties` with your database credentials
   - Create a new database schema

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```