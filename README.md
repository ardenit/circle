Тестовое задание на проект "Разработка средств визуализации данных на Kotlin".

Клонирование репозитория:
```
git clone https://github.com/ardenit/circle
```
Сборка и запуск приложения:
```
./gradlew run
```
Сборка JAR-файла приложения (JAR файл можно распространять отдельно от приложения, все необходимые ресурсы находятся внутри него):
```
./gradlew shadowJar
```
JAR-файл будет находиться по пути `build/libs/Circle.jar`. Его можно запустить с помощью Java:
```
cd ./build/libs
java -jar ./Circle.jar
```