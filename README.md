### http://54.180.133.61:8080/myApp/ ↔  http://www.myportfolio.p-e.kr/
##### 2024.08.06 AM 09:00 ~ 현재 서버 실행중
##### OS : AWS EC2 - Windows Server 2022 Datacenter 21H2, AWS S3 : File Upload
##### AWS를 사용해 서버 실행중이며 다소 느린관계로 양해부탁드립니다.
##### 일부 페이지는 부트스트랩 템플릿을 활용하였고, 프론트에 관련된 기능(JS, CSS)은 W3Schools를 참고하였습니다.
##### 기본적인 회원가입, 게시판의 CRUD와 페이징처리, 검색기능을 구현하였으나, 최종적으로는 지속적으로 사용할 수 있는 일종의 가계부(+일기장) 같은 느낌의 프로젝트를 목표로 하고 있습니다.
##### 게시판 내에 프로젝트에 대한 개발 과정, 상세내역을 작성할 예정입니다.

<div style="background-color: white;">

<div> 
  <h2 style="color: #282d33;"> ✈️ 프로젝트 간략 소개 </h2>  
  <div style="font-weight: 700; font-size: 15px; color: #282d33;" align="center">
    <br>
  </div>
<br><br>
</div>
<h2 style="color: #282d33;"> 🗓️ 개발기간 및 일정 </h2>
2024.07.17 - 2024.08.06
<div align="center">  
</div>

<br><br>
<h2 style="color: #282d33;"> 🗂️ ERD 구조도 </h2>
<div align="center">
  <img style="width:70%" src="https://github.com/user-attachments/assets/4ad12a1a-6495-4109-9bb7-1a291af80d22">
</div>

<br><br>
<h2 style="color: #282d33;"> 📜 웹사이트 전체 구성 </h2>
<div align= "center">
</div>
  <br>
<br>
<div>
  <h2 style="color: #282d33;"> 🛠️ 사용기술 및 개발환경</h2>
</div>

<div align="center">
<h3>Programming Language</h3>
<div>
<div>
  <h4>BackEnd</h4>
<img src="https://img.shields.io/badge/Java 11-007396?style=flat&logo=data:image/svg%2bxml;base64,PCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4KDTwhLS0gVXBsb2FkZWQgdG86IFNWRyBSZXBvLCB3d3cuc3ZncmVwby5jb20sIFRyYW5zZm9ybWVkIGJ5OiBTVkcgUmVwbyBNaXhlciBUb29scyAtLT4KPHN2ZyB3aWR0aD0iMTUwcHgiIGhlaWdodD0iMTUwcHgiIHZpZXdCb3g9IjAgMCAzMi4wMCAzMi4wMCIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBmaWxsPSIjZmZmZmZmIiBzdHJva2U9IiNmZmZmZmYiIHN0cm9rZS13aWR0aD0iMC4yNTYiPgoNPGcgaWQ9IlNWR1JlcG9fYmdDYXJyaWVyIiBzdHJva2Utd2lkdGg9IjAiLz4KDTxnIGlkPSJTVkdSZXBvX3RyYWNlckNhcnJpZXIiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIvPgoNPGcgaWQ9IlNWR1JlcG9faWNvbkNhcnJpZXIiPiA8cGF0aCBmaWxsPSIjZmZmZmZmIiBkPSJNMTIuNTU3IDIzLjIyYzAgMC0wLjk4MiAwLjU3MSAwLjY5OSAwLjc2NSAyLjAzNyAwLjIzMiAzLjA3OSAwLjE5OSA1LjMyNC0wLjIyNiAwIDAgMC41OSAwLjM3IDEuNDE1IDAuNjkxLTUuMDMzIDIuMTU3LTExLjM5LTAuMTI1LTcuNDM3LTEuMjN6TTExLjk0MiAyMC40MDVjMCAwLTEuMTAyIDAuODE2IDAuNTgxIDAuOTkgMi4xNzYgMC4yMjQgMy44OTUgMC4yNDMgNi44NjktMC4zMyAwIDAgMC40MTEgMC40MTcgMS4wNTggMC42NDUtNi4wODUgMS43NzktMTIuODYzIDAuMTQtOC41MDgtMS4zMDV6TTE3LjEyNyAxNS42M2MxLjI0IDEuNDI4LTAuMzI2IDIuNzEzLTAuMzI2IDIuNzEzczMuMTQ5LTEuNjI1IDEuNzAzLTMuNjYxYy0xLjM1MS0xLjg5OC0yLjM4Ni0yLjg0MSAzLjIyMS02LjA5MyAwIDAtOC44MDEgMi4xOTgtNC41OTggNy4wNDJ6TTIzLjc4MyAyNS4zMDJjMCAwIDAuNzI3IDAuNTk5LTAuODAxIDEuMDYyLTIuOTA1IDAuODgtMTIuMDkxIDEuMTQ2LTE0LjY0MyAwLjAzNS0wLjkxNy0wLjM5OSAwLjgwMy0wLjk1MyAxLjM0NC0xLjA2OSAwLjU2NC0wLjEyMiAwLjg4Ny0wLjEgMC44ODctMC4xLTEuMDIwLTAuNzE5LTYuNTk0IDEuNDExLTIuODMxIDIuMDIxIDEwLjI2MiAxLjY2NCAxOC43MDYtMC43NDkgMTYuMDQ0LTEuOTV6TTEzLjAyOSAxNy40ODljMCAwLTQuNjczIDEuMTEtMS42NTUgMS41MTMgMS4yNzQgMC4xNzEgMy44MTQgMC4xMzIgNi4xODEtMC4wNjYgMS45MzQtMC4xNjMgMy44NzYtMC41MSAzLjg3Ni0wLjUxcy0wLjY4MiAwLjI5Mi0xLjE3NSAwLjYyOWMtNC43NDUgMS4yNDgtMTMuOTExIDAuNjY3LTExLjI3Mi0wLjYwOSAyLjIzMi0xLjA3OSA0LjA0Ni0wLjk1NiA0LjA0Ni0wLjk1NnpNMjEuNDEyIDIyLjE3NGM0LjgyNC0yLjUwNiAyLjU5My00LjkxNSAxLjAzNy00LjU5MS0wLjM4MiAwLjA3OS0wLjU1MiAwLjE0OC0wLjU1MiAwLjE0OHMwLjE0Mi0wLjIyMiAwLjQxMi0wLjMxOGMzLjA3OS0xLjA4MyA1LjQ0OCAzLjE5My0wLjk5NCA0Ljg4Ny0wIDAgMC4wNzUtMC4wNjcgMC4wOTctMC4xMjZ6TTE4LjUwMyAzLjMzN2MwIDAgMi42NzEgMi42NzItMi41MzQgNi43ODEtNC4xNzQgMy4yOTYtMC45NTIgNS4xNzYtMC4wMDIgNy4zMjMtMi40MzYtMi4xOTgtNC4yMjQtNC4xMzMtMy4wMjUtNS45MzQgMS43NjEtMi42NDQgNi42MzgtMy45MjUgNS41Ni04LjE3ek0xMy41MDMgMjguOTY2YzQuNjMgMC4yOTYgMTEuNzQtMC4xNjQgMTEuOTA4LTIuMzU1IDAgMC0wLjMyNCAwLjgzMS0zLjgyNiAxLjQ5LTMuOTUyIDAuNzQ0LTguODI2IDAuNjU3LTExLjcxNiAwLjE4IDAgMCAwLjU5MiAwLjQ5IDMuNjM1IDAuNjg1eiIvPiA8L2c+Cg08L3N2Zz4=">
<img src="https://img.shields.io/badge/Spring 5.3.37-6DB33F?style=Plastic&logo=Spring&logoColor=white">
</div>
<div>
  <h4>Database</h4>
  <img src="https://img.shields.io/badge/MySQL 8.0.38-4479A1?style=Plastic&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL Workbench 8.0CE-4479A1?style=Plastic&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/MyBatis 3.5.10-gray?style=flat&logo=data:image/png%2bxml;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAACXBIWXMAAAsTAAALEwEAmpwYAAADoklEQVR4nO2ZaYhOURjHf2MdY89kj0KyZBmSLJHsQpQvaBRKkeQDktDIlpSdwQd7lg92yZbQNCWKDyaR/YMIMwbTzBgzr079b51u8473Lu/Mq+6/TnPfe+855/mf8zz/57lnIEKECLWFKUAeMJr/HJuBGPAJmAcMA1rzH6IhcEVknFYB5AINSCGkASOAATW8Ux9YAlwE8oFSETL3UgaLZNQHYKzcpicwEVig5/OBLBEymKQ+j0khNAJuuVwnXnsDjAcy9bvINVYnYBVwUzFVDhQDL4EzWpCMZJJpAmzQhIUy+A5wBNgBHNU9Jz5m6LpK/ZsD+2T4vxajCFgml04q0uJMYnZuu4z5KRLmehDwIsEdjVnNLE69ZBN5BZzXyg20YsPgpMugMv39BlR6JLOOJCPPNeF34BowTWJQ7Hp+DkiXiw2Xmh0C7kpEquIQ+Q10q40kaLcfQHc9323d35uAi2QB7xRv2cBy4J76Hwwj0cVLaH2AA1IzE+R/ZADakbcy4kKCfr7TIv4eWKPSx6kYAsVKhvz6gSbKFgE7HuxAd9BG+WUP0DTBuUZJ7ewdLrdcrj8BcbMaFzLB+0S6vxaYq8zfOcDKPbPGNwn2kmvOmUGJzPeoMmYVnwK7PK5iqTXGEC2MuXdD97YEzSsmEX71kQNiktpcK1MPBsbEmed4Nf1viIBdNawHuvols84nEaddlWiY2HoOPAIWAi2tOdIVh0XaVSMSbV1ESiXjk/3uToa0PgiZpRprcTWGzQbax5n7sPX+WaALATEnIBGnCu5dwzsFckWTQ6YCvYDr1nPj4idUkAaCW0m8tF8ao5XP/svCrLtMfnjt05DPGsMp7722LEJGb5XxfgIeqZbXvuVSz9DRV2WEF2OM0hhs80EkP0zj2wEbgX763VHf54kYYgLYiY/vPoisDINAdxWHTuY15fkE6/k4iUBZnLhwgjRN8umVREUN0vxPtFBpcj/Od8IfkbNl0CS3kaq7nNrLqZwbA/t9BvllP0Fs9Pt2gt/VMWXh7aqNqoPJ1rNcBaHXEmeIVyK7fE7mtI8q981n7ildFwUc8xg+kKYTkViKtEIJCn7J5KQAiUp9HQZGto5z6orIakJED+BhHZDYRBJQT/8m+FILBKqAFSQZmTpIKEkSCXPiYhJrraGtzrO+hUSgTOdfzagjmKOf6TpFKfEprVuBDqQQGgFDVVOdVqXqnNjHFF8FqhhyVMaYg78IESJEiBAhAiHiL7qqAQdttdy6AAAAAElFTkSuQmCC">
</div>
<div>
  <h4>FrontEnd</h4>
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=Plastic&logo=HTML5&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=Plastic&logo=CSS3&logoColor=white" />
  <img src="https://img.shields.io/badge/Bootstrap5-7952B3?style=Plastic&logo=Bootstrap&logoColor=white" />
  <img src="https://img.shields.io/badge/jQuery 3.7.1-0769AD?style=Plastic&logo=jQuery&logoColor=white" />
  <img src="https://img.shields.io/badge/Javascript ES6-F7DF1E?style=Plastic&logo=Javascript&logoColor=white" />
  <br>
</div>

<h3>Tools & ETC </h3>

<img src="https://img.shields.io/badge/IntelliJ IDEA IDE 2024.1.4-000000?style=Plastic&logo=intellijidea&logoColor=white" />
<img src="https://img.shields.io/badge/AmazonS3-569A31?style=Plastic&logo=amazons3&logoColor=white" />
<img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=Plastic&logo=amazonec2&logoColor=white" />
<br>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=Plastic&logo=postman&logoColor=white" />
<img src="https://img.shields.io/badge/JUnit4-25A162?style=Plastic&logo=junit5&logoColor=white" />
<img src="https://img.shields.io/badge/Git-F05032?style=Plastic&logo=git&logoColor=white" />
<img src="https://img.shields.io/badge/Github-181717?style=Plastic&logo=github&logoColor=white" />
<br>
<img src="https://img.shields.io/badge/Apache Tomcat 9.0.93-F8DC75?style=Plastic&logo=apachetomcat&logoColor=white" />
<img src="https://img.shields.io/badge/Apache Maven-C71A36?style=Plastic&logo=apachemaven&logoColor=white" />
</div>
</div>
<br>

<br>
<div>
<h2 style="color: #282d33;"> 🧑‍💻 Contact Me..</h2>
</div>
  <div align="center">
<a href="http://www.myportfolio.p-e.kr/">
  <img src="https://img.shields.io/badge/Portfolio : Personal Mini Project-F44336?style=flat&logo=Task&logoColor=white" alt="Portfolio" />
</a>
  <img src="https://img.shields.io/badge/Gmail-30B980?style=flat&logo=Gmail&logoColor=white" />
</div>
</div>
</div>
