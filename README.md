#### http://www.myportfolio.p-e.kr/
##### 2024.08.06 AM 09:00 ~ ~~현재 서버 실행중~~
###### 2024.09.24 PM 13:24 서버 종료
<br>
<div style="background-color: white;">
<div> 
  <h2 style="color: #282d33;"> ✈️ 프로젝트 개요</h2>  
  <div style="font-weight: 700; font-size: 15px; color: #282d33;">
    <h5>기초지만 중요한 내용을 다시 한번 환경 설정부터 배포까지 직접 해보며 이후 부하 테스트와 성능 개선까지 목표로 한 개인프로젝트</h5>
    <br>
  </div>
</div>
<h2 style="color: #282d33;"> 🗓️ 개발기간 및 일정 </h2>
<h4>2024.07.17 - 2024.08.06 1차</h4>
  <h6>
1. 기본적인 CRUD 다시 한번 체크 및 재정리<br>
2. 기존에 사용 해보지 않았던 DB 사용(기존 : Oracle → MySQL)<br>
3. 페이지네이션 및 검색 기능 구현(쿼리) 다시 한번 복습<br>
4. 테스트 툴 활용하기 → Junit4, Postman<br>
5. DB 트랜잭션 적용 및 확인(servlet-context.xml에서 aop 및 트랜잭션 설정, @Transactional로 적용 및 확인)<br>
6. 별도의 서버 구축 및 파일업로드 활용(Amazon EC2 & S3, Vultr)<br>
7. 특정 기능 Rest API 구현(댓글기능, 건의사항기능, JWT 토큰 요청 부분)<br>
8. Validation 서버단 유효성 검증(가입시 유효성 검증)<br>
</h6>
  <h4>
2024.09.01 - 2024.09.24 2차
</h4>
<h6>
1. 스프링 시큐리티 기반의 JWT를 사용한 OAuth2.0 인증 로그인 구현 <br>
2. 부하테스트를 통한 성능 측정(nGrinder)<br>
3. 캐시(Ehcache)을 적용하여 페이징 성능 개선 및 시스템 최적화
</h6>
<div align="center">  
</div>
<br>
<h2 style="color: #282d33;"> 🗂️ ERD </h2>
<div align="center">
  <img style="width:70%" src="https://github.com/user-attachments/assets/63785c64-387f-4cf3-935b-fa6f7b3962a8">
</div>
  <br>
<br><br><br>
<div>
  <h2 style="color: #282d33;"> 🛠️ 사용기술 및 개발환경</h2>
</div>

<div align="">
<div>
<div>
  <h4>Back-end</h4>
<img src="https://img.shields.io/badge/Java 11-007396?style=flat&logo=data:image/svg%2bxml;base64,PCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4KDTwhLS0gVXBsb2FkZWQgdG86IFNWRyBSZXBvLCB3d3cuc3ZncmVwby5jb20sIFRyYW5zZm9ybWVkIGJ5OiBTVkcgUmVwbyBNaXhlciBUb29scyAtLT4KPHN2ZyB3aWR0aD0iMTUwcHgiIGhlaWdodD0iMTUwcHgiIHZpZXdCb3g9IjAgMCAzMi4wMCAzMi4wMCIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBmaWxsPSIjZmZmZmZmIiBzdHJva2U9IiNmZmZmZmYiIHN0cm9rZS13aWR0aD0iMC4yNTYiPgoNPGcgaWQ9IlNWR1JlcG9fYmdDYXJyaWVyIiBzdHJva2Utd2lkdGg9IjAiLz4KDTxnIGlkPSJTVkdSZXBvX3RyYWNlckNhcnJpZXIiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIvPgoNPGcgaWQ9IlNWR1JlcG9faWNvbkNhcnJpZXIiPiA8cGF0aCBmaWxsPSIjZmZmZmZmIiBkPSJNMTIuNTU3IDIzLjIyYzAgMC0wLjk4MiAwLjU3MSAwLjY5OSAwLjc2NSAyLjAzNyAwLjIzMiAzLjA3OSAwLjE5OSA1LjMyNC0wLjIyNiAwIDAgMC41OSAwLjM3IDEuNDE1IDAuNjkxLTUuMDMzIDIuMTU3LTExLjM5LTAuMTI1LTcuNDM3LTEuMjN6TTExLjk0MiAyMC40MDVjMCAwLTEuMTAyIDAuODE2IDAuNTgxIDAuOTkgMi4xNzYgMC4yMjQgMy44OTUgMC4yNDMgNi44NjktMC4zMyAwIDAgMC40MTEgMC40MTcgMS4wNTggMC42NDUtNi4wODUgMS43NzktMTIuODYzIDAuMTQtOC41MDgtMS4zMDV6TTE3LjEyNyAxNS42M2MxLjI0IDEuNDI4LTAuMzI2IDIuNzEzLTAuMzI2IDIuNzEzczMuMTQ5LTEuNjI1IDEuNzAzLTMuNjYxYy0xLjM1MS0xLjg5OC0yLjM4Ni0yLjg0MSAzLjIyMS02LjA5MyAwIDAtOC44MDEgMi4xOTgtNC41OTggNy4wNDJ6TTIzLjc4MyAyNS4zMDJjMCAwIDAuNzI3IDAuNTk5LTAuODAxIDEuMDYyLTIuOTA1IDAuODgtMTIuMDkxIDEuMTQ2LTE0LjY0MyAwLjAzNS0wLjkxNy0wLjM5OSAwLjgwMy0wLjk1MyAxLjM0NC0xLjA2OSAwLjU2NC0wLjEyMiAwLjg4Ny0wLjEgMC44ODctMC4xLTEuMDIwLTAuNzE5LTYuNTk0IDEuNDExLTIuODMxIDIuMDIxIDEwLjI2MiAxLjY2NCAxOC43MDYtMC43NDkgMTYuMDQ0LTEuOTV6TTEzLjAyOSAxNy40ODljMCAwLTQuNjczIDEuMTEtMS42NTUgMS41MTMgMS4yNzQgMC4xNzEgMy44MTQgMC4xMzIgNi4xODEtMC4wNjYgMS45MzQtMC4xNjMgMy44NzYtMC41MSAzLjg3Ni0wLjUxcy0wLjY4MiAwLjI5Mi0xLjE3NSAwLjYyOWMtNC43NDUgMS4yNDgtMTMuOTExIDAuNjY3LTExLjI3Mi0wLjYwOSAyLjIzMi0xLjA3OSA0LjA0Ni0wLjk1NiA0LjA0Ni0wLjk1NnpNMjEuNDEyIDIyLjE3NGM0LjgyNC0yLjUwNiAyLjU5My00LjkxNSAxLjAzNy00LjU5MS0wLjM4MiAwLjA3OS0wLjU1MiAwLjE0OC0wLjU1MiAwLjE0OHMwLjE0Mi0wLjIyMiAwLjQxMi0wLjMxOGMzLjA3OS0xLjA4MyA1LjQ0OCAzLjE5My0wLjk5NCA0Ljg4Ny0wIDAgMC4wNzUtMC4wNjcgMC4wOTctMC4xMjZ6TTE4LjUwMyAzLjMzN2MwIDAgMi42NzEgMi42NzItMi41MzQgNi43ODEtNC4xNzQgMy4yOTYtMC45NTIgNS4xNzYtMC4wMDIgNy4zMjMtMi40MzYtMi4xOTgtNC4yMjQtNC4xMzMtMy4wMjUtNS45MzQgMS43NjEtMi42NDQgNi42MzgtMy45MjUgNS41Ni04LjE3ek0xMy41MDMgMjguOTY2YzQuNjMgMC4yOTYgMTEuNzQtMC4xNjQgMTEuOTA4LTIuMzU1IDAgMC0wLjMyNCAwLjgzMS0zLjgyNiAxLjQ5LTMuOTUyIDAuNzQ0LTguODI2IDAuNjU3LTExLjcxNiAwLjE4IDAgMCAwLjU5MiAwLjQ5IDMuNjM1IDAuNjg1eiIvPiA8L2c+Cg08L3N2Zz4=">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=Plastic&logo=Spring&logoColor=white">
</div>
<div>
  <h4>Database</h4>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=Plastic&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/MyBatis-gray?style=flat&logo=data:image/png%2bxml;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAACXBIWXMAAAsTAAALEwEAmpwYAAADoklEQVR4nO2ZaYhOURjHf2MdY89kj0KyZBmSLJHsQpQvaBRKkeQDktDIlpSdwQd7lg92yZbQNCWKDyaR/YMIMwbTzBgzr079b51u8473Lu/Mq+6/TnPfe+855/mf8zz/57lnIEKECLWFKUAeMJr/HJuBGPAJmAcMA1rzH6IhcEVknFYB5AINSCGkASOAATW8Ux9YAlwE8oFSETL3UgaLZNQHYKzcpicwEVig5/OBLBEymKQ+j0khNAJuuVwnXnsDjAcy9bvINVYnYBVwUzFVDhQDL4EzWpCMZJJpAmzQhIUy+A5wBNgBHNU9Jz5m6LpK/ZsD+2T4vxajCFgml04q0uJMYnZuu4z5KRLmehDwIsEdjVnNLE69ZBN5BZzXyg20YsPgpMugMv39BlR6JLOOJCPPNeF34BowTWJQ7Hp+DkiXiw2Xmh0C7kpEquIQ+Q10q40kaLcfQHc9323d35uAi2QB7xRv2cBy4J76Hwwj0cVLaH2AA1IzE+R/ZADakbcy4kKCfr7TIv4eWKPSx6kYAsVKhvz6gSbKFgE7HuxAd9BG+WUP0DTBuUZJ7ewdLrdcrj8BcbMaFzLB+0S6vxaYq8zfOcDKPbPGNwn2kmvOmUGJzPeoMmYVnwK7PK5iqTXGEC2MuXdD97YEzSsmEX71kQNiktpcK1MPBsbEmed4Nf1viIBdNawHuvols84nEaddlWiY2HoOPAIWAi2tOdIVh0XaVSMSbV1ESiXjk/3uToa0PgiZpRprcTWGzQbax5n7sPX+WaALATEnIBGnCu5dwzsFckWTQ6YCvYDr1nPj4idUkAaCW0m8tF8ao5XP/svCrLtMfnjt05DPGsMp7722LEJGb5XxfgIeqZbXvuVSz9DRV2WEF2OM0hhs80EkP0zj2wEbgX763VHf54kYYgLYiY/vPoisDINAdxWHTuY15fkE6/k4iUBZnLhwgjRN8umVREUN0vxPtFBpcj/Od8IfkbNl0CS3kaq7nNrLqZwbA/t9BvllP0Fs9Pt2gt/VMWXh7aqNqoPJ1rNcBaHXEmeIVyK7fE7mtI8q981n7ildFwUc8xg+kKYTkViKtEIJCn7J5KQAiUp9HQZGto5z6orIakJED+BhHZDYRBJQT/8m+FILBKqAFSQZmTpIKEkSCXPiYhJrraGtzrO+hUSgTOdfzagjmKOf6TpFKfEprVuBDqQQGgFDVVOdVqXqnNjHFF8FqhhyVMaYg78IESJEiBAhAiHiL7qqAQdttdy6AAAAAElFTkSuQmCC">
</div>
<div>
  <h4>Front-end</h4>
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=Plastic&logo=HTML5&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=Plastic&logo=CSS3&logoColor=white" />
  <img src="https://img.shields.io/badge/Bootstrap5-7952B3?style=Plastic&logo=Bootstrap&logoColor=white" />
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=Plastic&logo=jQuery&logoColor=white" />
  <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=Plastic&logo=Javascript&logoColor=white" />
  <br>
</div>
<h4>Tools & ETC </h4>
<img src="https://img.shields.io/badge/IntelliJ IDEA IDE-000000?style=Plastic&logo=intellijidea&logoColor=white" />
<img src="https://img.shields.io/badge/AmazonS3-569A31?style=Plastic&logo=amazons3&logoColor=white" />
<img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=Plastic&logo=amazonec2&logoColor=white" />
<br>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=Plastic&logo=postman&logoColor=white" />
<img src="https://img.shields.io/badge/JUnit4-25A162?style=Plastic&logo=junit5&logoColor=white" />
<img src="https://img.shields.io/badge/Github-181717?style=Plastic&logo=github&logoColor=white" />
</div>
</div>
<br><br>
<h2 style="color: #282d33;"> 🔎 주요 문제 상황 및 해결 과정 </h2>

<h3>Spring Security 기반 OAuth2.0 인증 로그인(JWT 사용)</h3>

#### 개요
- Spring Security로 보안을 강화하고, JWT로 Stateless한 서비스 확장을 구현.
- OAuth2.0 소셜 로그인으로 가입 및 로그인 인증을 간소화, 일반 로그인에도 JWT를 적용.

#### 보안 대책
1. **다중 토큰 발급**  
   - Access/Refresh 토큰 발급.  
   - Access 토큰 만료 시 Refresh 토큰으로 재발급 후 기존 Refresh 토큰 무효화.

2. **토큰 저장 위치 관리**  
   - **Access 토큰**: 로컬 스토리지 (짧은 수명).  
   - **Refresh 토큰**: 쿠키 저장 (HttpOnly 설정, 긴 수명).  

3. **Refresh 토큰 서버 관리**  
   - 발급된 Refresh 토큰을 서버에 저장하고 무효화 처리해 재사용 방지

#### 추가 보안 대책
- **HTTPS** 적용 (TLS 프로토콜).  
- **XSS 방지**: <code>&lt;c:out&gt;</code> 태그 사용, <code>Script</code> 코드 검사, <code>XSS Filter</code>로 사용자 입력 검증
- **CSRF 방지**: 쿠키에 Secure 옵션 설정
- **IP 인증 강화**: 의심스러운 접속 시 추가 인증 및 토큰 무효화

  <div align="center">
         <h6>소셜 로그인시 로그인 까지의 인증 및 시큐리티 필터 동작 과정</h6>
  <img style="width:100%" src="https://github.com/user-attachments/assets/009c5583-2580-4206-b9c9-41798dc7dae5">
    </div>
  </details>
<br>
<h3>대용량 트래픽 대비 부하 테스트 및 페이지네이션 성능 개선</h3>

<h4>1. 배경 및 목표</h4>
<ul>
  <li>실무 경험 부족을 보완하고자 <strong>500만 건의 더미 데이터</strong>를 생성 후 성능 및 부하 테스트 수행</li>
  <li>대용량 트래픽 환경에서 <strong>쿼리 최적화와 캐싱</strong>을 통해 페이지네이션 성능 개선 목표</li>
</ul>

<h4>2. 성능 측정 및 개선 시도</h4>
<ul>
  <li><strong>기존 쿼리 성능 측정</strong>:
    <ul>
      <li>마지막 <strong>50개 데이터 조회 쿼리</strong>를 <strong>500회</strong> 측정한 결과, 평균 응답 시간 <strong>3.267초</strong></li>
      <li><strong>인덱스 및 복합 인덱스</strong>를 추가했으나 성능 개선 효과가 미미하고, 오히려 성능이 저하되는 경우도 발생</li>
      <li><strong>LIKE 검색</strong>에서 <code>%</code> 위치에 따라 인덱스 효과가 제한됨을 확인</li>
    </ul>
  </li>
  <li><strong>해결방안</strong>: 인덱스 최적화 외에 <strong>Ehcache</strong>를 도입해 메모리 기반 캐싱 사용</li>
</ul>

<h4>3. 캐시 전략 및 결과</h4>
<ul>
  <li>1. <strong>전체 데이터 수</strong>만 캐싱</li>
  <li>2. <strong>page</strong>와 <strong>pageSize</strong>를 캐시 키로 사용</li>
  <li>3. <strong>전체 데이터 수와 page, pageSize</strong> 모두 캐싱</li>
</ul>
<p><strong>결과</strong>: 3번 전략에서 <strong>94% 응답 시간 개선</strong>을 확인</p>

<h4>4. 부하 테스트 및 모니터링</h4>
<ul>
  <li><strong>테스트 도구</strong>: nGrinder(부하 테스트), Scouter(모니터링).</li>
  <li><strong>환경 구성</strong>: Vultr 서버 내에서 <strong>100명 가상 사용자</strong>가 <strong>1분간 10회 요청</strong>.</li>
  <li><strong>결과 요약</strong>:
    <ul>
      <li><strong>캐시 미적용 시</strong>: CPU 사용량 <strong>100% 초과</strong>, 다수의 요청 오류 발생.</li>
      <li><strong>1번(전체 데이터 수 캐싱) 적용 시</strong>: 성능 소폭 개선되었으나 CPU 부하 여전히 높음.</li>
      <li><strong>2번, 3번(전체 데이터 수와 page,pageSize 캐싱)적용 시</strong>: CPU 사용량 감소, 오류 빈도 대폭 감소.</li>
    </ul>
  </li>
</ul>
<h5>성능 측정 및 부하 테스트 결과</h5>
  <img style="width:60%" src="https://github.com/user-attachments/assets/ffca29d6-7dfa-4019-82e6-d69d873c812c">
<div>
<h5>테스트 서버 사양 및 성능지표 용어</h5>
  <img style="width:60%" src="https://github.com/user-attachments/assets/00e8f9b4-1258-494e-8b84-1d20a9cf04d0">
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
