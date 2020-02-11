# Spring Framework
+ **개발환경**
1. **JAVA 8** -> JDK 1.8 : javac 포함
    - 자바 다운로드 : oracle.com
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
    - 다운로드 : oracle.com

6. **STS 실행**
    - Spring 3.XX. plugin해서 설치한다. -> 재실행 한다.
    - open perspective -> spring 으로 환경을 바꿔준다.
    - Spring Legacy Project를 만들어서 시작
    
    