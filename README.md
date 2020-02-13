# Spring Framework (Java library)

+ **개발환경**
<hr>   

1. **JAVA 8** -> JDK 1.8 : javac 포함
    - 자바 다운로드 : https://oracle.com
    - 기본 설치
    - 환경 설정 : JAVA_HOME, CLASSPATH   
    C:\Program Files\Java\jdk1.8.0_221   
    .;%JAVA_HOME%\lib\tools.jar;   
    path에 추가  
    ;%JAVA_HOME%\bin;
    - 환경설정 확인(명령프롬프트 운영을 위해) :   
    set JAVA_HOME, set CLASSPATH, path, java -version, javac -version   
    
2. **STS(Spring Tools Suite)** 다운로드 설치 -> 긴 파일명이 있으므로 (7zip, 반디집 이용)   
    - 작업 파일 한글 엔코딩 설정 : 기본 euc-kr -> utf-8   
    SpringToolSuite4.ini -> -Dfile.encoding=utf-8 추가   

3. **Tomcat** 다운 설치
    - tomcat.apache.org/download
    - 환경 설정 확인(운영을 위해) : CATALINA_HOME = C:\tomcat9, Path에 %CATALINA_HOME%\bin;
    - oraclexe가 실행되고 있는지 확인해 본다.   
    -> tomcat이 실행되는 포트 : 8080, oraclexe의 웹서비스 포트 : 8080이라 충돌함.
    - 확인 : set CATALINA_HOME, path, startup

4. **Oracle 11g XE** - DB server
    - SID : xe
    - 11g 이하 버전 : 사용자 - 이름
    - 12c 이상 버전 : 사용자 - C##이름
       
5. **SQL Developer** - DB 연결 : 클라이언트 프로그램
    - 다운로드 : https://oracle.com

6. **STS 실행**
    - Spring 3.XX. plugin해서 설치한다. -> 재실행 한다.
    - open perspective -> spring 으로 환경을 바꿔준다.
    - Spring Legacy Project를 만들어서 시작
    - pom.xml에서 java version 변경 1.6 -> 1.8
    - maven -> update project -> servers에서 tomcat등록 후 run server -> "Hello world"

7. **Spring version**변경
    - pom.xml에서 springframework-version을 5.0.7로 수정 -> Maven Dependencies에서 바뀐거 확인.
    - 서버를 돌려서 Hello world가 잘 나오는+지 확인해본다.
    - 문제가 생기는 경우 사용자 폴더에 .m2폴더의 내용을 삭제하고 다시 실행
    
8. **Lombok library**설치
    - DTO를 자동으로 생성해줘서 약간의 코드만으로도 필요한 클래스를 설계할 때 유용
    - Lombok 라이브러리 다운로드 - https://projectlombok.org/download
    - 다운로드 후에 다운로드된 경로에서 cmd로 java -jar lombok.jar 실행
    - 필요한 IDE 선택후 설치 -> IDE 실행위치에 lombok.jar가 들어가 있는지 확인
    - pom.xml에 dependency를 추가
    - sts를 재실행 -> Maven -> update Project
    - @Data -> setter / getter / toString() / 생성자 자동만들기
    - @Setter -> setter를 이용한 DI 적용 
    
9. **DI 테스트**
    - Lombok라이브러리를 추가하고 spring-test라이브러리를 이용해서 스프링 동작 테스트
    - root-context.xml에 context nampespace를 추가하고 component-scan코드 추가.
    - class를 만들고 src/test/java에서 테스트한다.
    - 자동생성되는 어노테이션 - @Controller, @Service, @Repository, @Component, @RestController
    - lombok 의 @Data @Setter, spring - @Autowired, java - @Inject 이용 
    - Rus As > Junit Test
<hr>

+ **스프링 MVC 설정**
<hr>

1. **한글처리**   
    - pom.xml에서 javax.servlet 버전은 3.1.0으로 바꾸고 web.xml의 web-app 속성을 바꿔준다.
    - 한글처리 : web.xml에 한글처리하는 필터를 추가한다.
    - filter-class : org.springframework.web.filter.CharacterEncodingFilter

2. **흐름**
    - -> web.xml의 DispatcherServlet(FrontController와 동일)   
      -> @Controller 어노테이션을 이용해서 jsp 주소를 가져오고   
      -> sevlet-context.xml 에서 주소를 조립해서 보여준다.

3. **화면 띄우기**
    - localhost/board/list.do(get) -> 게시판 리스트
    - controller 패키지 안에 BoardController 클래스를 만들고 @Controller 어노테이션으로 자동생성
    - RequestMapping(value = "/board/XXXX.do", method = RequestMethod.GET(POST))로 처리방식 설정해주고
    - return "board/XXXX" 로 url을 조합할 수 있게 넘겨서 XXXX.jsp를 띄운다.
      