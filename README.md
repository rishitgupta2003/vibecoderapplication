# Vibecoder

An AI-powered collaborative code editor and project management platform built with Spring Boot.

**Status**: 🚧 Under Development

---

## What is Vibecoder?

Vibecoder is a backend platform that enables teams to collaborate on coding projects with AI assistance. It provides infrastructure for:

- **User Authentication**: Secure user registration and login
- **Project Management**: Create and manage coding projects with team members
- **File Storage**: Store and organize project files
- **AI Chat Integration**: LLM-powered assistance within projects
- **Subscription Billing**: Tiered subscription plans with usage limits
- **Usage Tracking**: Monitor token consumption and activity
- **Preview System**: Container-based previews for project demonstrations

---

## Problems It Solves

1. **Team Collaboration** - Enable multiple developers to work on the same project with role-based access control
2. **AI-Assisted Development** - Integrate LLM assistance directly into the development workflow for code suggestions and explanations
3. **Usage Management** - Track and limit AI token consumption based on subscription plans
4. **File Organization** - Centralized file management with versioning and audit trails
5. **Project Sharing** - Public/private project sharing with fine-grained permissions
6. **Scalability** - Built on Spring Boot with PostgreSQL for handling growing user base and projects

---

## Technology Stack

- **Java 25** - Latest Java features
- **Spring Boot 4.0.4** - Backend framework
- **PostgreSQL** - Database
- **Lombok** - Reduce boilerplate code
- **Maven** - Build tool
- **Stripe API** - Payment processing (planned)
- **MinIO** - File storage (planned)
- **Kubernetes** - Container previews (planned)

---

## Current State

The project currently has:
- ✅ Database schema design with entities for users, projects, files, chat, subscriptions, etc.
- ✅ Spring Boot project structure
- ✅ Controller and service scaffolds
- ✅ JPA repository setup
- 🚧 Service implementations and API endpoints (in progress)

---

## Getting Started

### Prerequisites
- Java 25+
- Maven 3.8.0+
- PostgreSQL 12+

### Build & Run
```bash
./mvnw clean package
./mvnw spring-boot:run
```

Application starts on `http://localhost:8080`

---

## Roadmap

- [ ] Authentication implementation
- [ ] Project CRUD operations
- [ ] File upload/download
- [ ] Chat integration with LLM
- [ ] Stripe billing integration
- [ ] Kubernetes preview system
- [ ] Comprehensive API documentation
- [ ] Frontend application

---

**Last Updated**: March 22, 2026

