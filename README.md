
# Automated Functional Web Tests

## Test Cases
1. User Login
2. User Registration
3. Search Functionality
4. Add to Cart

## Setup Instructions

1. Clone the repository
2. Build the Docker image:
    ```sh
    docker build -t web-tests .
    ```
3. Run the tests:
    ```sh
    docker run web-tests
    ```

## Dependencies
- Selenium WebDriver
- WebDriverManager
- JUnit

## CI/CD Integration:

Create a Jenkinsfile or GitHub Actions workflow to integrate the tests into a CI/CD pipeline.

```
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
```

