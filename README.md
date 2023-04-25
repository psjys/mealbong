## 📍 프로젝트명

#### 밀키트 쇼핑몰 < MealBong >

<img src="https://user-images.githubusercontent.com/110727837/234338732-8eb48541-e742-41f2-94ef-29fc24e6f899.png">

<br>

## 🖇 프로젝트 정보
1. **팀원** : 박규민 (팀장) , 엄상호, 하서연, 송강현 
2. **프로젝트 기획 의도** : <br>
코로나 이후 밀키트의 시장 규모가 급성장했고, MZ세대 중심의 캠핑 시장에서 밀키트 수요가 증가함에 따라 <br>
최근 트렌드와 시장 경쟁력을 갖추고 있는 밀키트 판매 쇼핑몰을 주제로 선정

<br>

## 💻 기술 스택
#### 1️⃣ IDE
<div>
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
<img src="https://img.shields.io/badge/visualstudiocode-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white">
</div>

#### 2️⃣ Front-End
<div>
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
</div>

#### 3️⃣ Back-End
<div>
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
</div>

#### 4️⃣ Tools
<div>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/notion-181717?style=for-the-badge&logo=notion&logoColor=white">
</div>

<br>

## 📹 시연 영상
https://youtu.be/jM11wI_K89Y

<br>

## 🔗 Notion 주소
http://bit.ly/mealbong

<br>

## 🗂 아키텍쳐

```
mealbong
    ├── build
    │   ├── classes
    │   │   └── java
    │   │       └── main
    │   │           └── com
    │   │               └── project
    │   │                   └── mealbong
    │   │                       ├── admin
    │   │                       ├── board
    │   │                       ├── config
    │   │                       ├── critest
    │   │                       ├── delivery
    │   │                       ├── faq
    │   │                       ├── home
    │   │                       ├── myPage
    │   │                       ├── notice
    │   │                       ├── order
    │   │                       ├── product
    │   │                       ├── user
    │   │                       └── wish
    │   ├── generated
    │   │   └── sources
    │   │       ├── annotationProcessor
    │   │       │   └── java
    │   │       │       └── main
    │   │       └── headers
    │   │           └── java
    │   │               └── main
    │   ├── resources
    │   │   └── main
    │   │       ├── mybatis
    │   │       │   └── mapper
    │   │       │       ├── board
    │   │       │       ├── delivery
    │   │       │       ├── faq
    │   │       │       ├── notice
    │   │       │       ├── order
    │   │       │       ├── product
    │   │       │       ├── user
    │   │       │       └── wish
    │   │       ├── static
    │   │       │   ├── admin
    │   │       │   │   ├── css
    │   │       │   │   └── js
    │   │       │   ├── board
    │   │       │   │   ├── css
    │   │       │   │   └── js
    │   │       │   ├── common
    │   │       │   │   ├── css
    │   │       │   │   └── js
    │   │       │   ├── image
    │   │       │   │   ├── Asian
    │   │       │   │   ├── Chinese
    │   │       │   │   ├── Japanese
    │   │       │   │   ├── Korean
    │   │       │   │   ├── LateNight
    │   │       │   │   ├── Notice
    │   │       │   │   └── Western
    │   │       │   ├── myPage
    │   │       │   │   └── js
    │   │       │   ├── order
    │   │       │   │   ├── css
    │   │       │   │   └── js
    │   │       │   ├── product
    │   │       │   │   ├── css
    │   │       │   │   └── js
    │   │       │   └── user
    │   │       │       ├── css
    │   │       │       └── js
    │   │       └── templates
    │   │           ├── fragments
    │   │           └── html
    │   │               ├── admin
    │   │               ├── footer
    │   │               ├── menu_list
    │   │               ├── my_page
    │   │               ├── order
    │   │               ├── search
    │   │               ├── service_page
    │   │               │   └── inquiry
    │   │               └── user
    │   └── tmp
    │       └── compileJava
    │           └── compileTransaction
    │               ├── annotation-output
    │               ├── compile-output
    │               │   └── com
    │               │       └── project
    │               │           └── mealbong
    │               │               ├── admin
    │               │               ├── board
    │               │               ├── critest
    │               │               ├── delivery
    │               │               ├── faq
    │               │               ├── home
    │               │               ├── myPage
    │               │               ├── notice
    │               │               ├── order
    │               │               ├── product
    │               │               ├── user
    │               │               └── wish
    │               ├── header-output
    │               └── stash-dir
    ├── gradle
    │   └── wrapper
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── project
        │   │           └── mealbong
        │   │               ├── admin
        │   │               ├── board
        │   │               ├── config
        │   │               ├── critest
        │   │               ├── delivery
        │   │               ├── faq
        │   │               ├── home
        │   │               ├── myPage
        │   │               ├── notice
        │   │               ├── order
        │   │               ├── product
        │   │               ├── user
        │   │               └── wish
        │   └── resources
        │       ├── mybatis
        │       │   └── mapper
        │       │       ├── board
        │       │       ├── delivery
        │       │       ├── faq
        │       │       ├── notice
        │       │       ├── order
        │       │       ├── product
        │       │       ├── user
        │       │       └── wish
        │       ├── static
        │       │   ├── admin
        │       │   │   ├── css
        │       │   │   └── js
        │       │   ├── board
        │       │   │   ├── css
        │       │   │   └── js
        │       │   ├── common
        │       │   │   ├── css
        │       │   │   └── js
        │       │   ├── image
        │       │   │   ├── Asian
        │       │   │   ├── Chinese
        │       │   │   ├── Japanese
        │       │   │   ├── Korean
        │       │   │   ├── LateNight
        │       │   │   ├── Notice
        │       │   │   └── Western
        │       │   ├── myPage
        │       │   │   └── js
        │       │   ├── order
        │       │   │   ├── css
        │       │   │   └── js
        │       │   ├── product
        │       │   │   ├── css
        │       │   │   └── js
        │       │   └── user
        │       │       ├── css
        │       │       └── js
        │       └── templates
        │           ├── fragments
        │           └── html
        │               ├── admin
        │               ├── footer
        │               ├── menu_list
        │               ├── my_page
        │               ├── order
        │               ├── search
        │               ├── service_page
        │               │   └── inquiry
        │               └── user
        └── test
            └── java
                └── com
                    └── project
                        └── mealbong

183 directories
```
