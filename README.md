프로젝트 개요

이 프로젝트는 Spring Framework를 기반으로 한 웹 애플리케이션으로, 인증, 사용자 관리, 댓글, 작업(To-Do) 등의 도메인을 처리하도록 설계되었습니다. JWT 기반 보안, 예외 처리, 확장성과 유지 보수를 고려한 계층적 아키텍처를 특징으로 합니다.

디렉토리 구조

설정 파일

AuthUserArgumentResolver.java: 인증을 위한 커스텀 인자 해결을 처리합니다.

CustomPasswordEncoder.java: 비밀번호 인코딩 유틸리티를 제공합니다.

GlobalExceptionHandler.java: 중앙 집중식 예외 처리를 수행합니다.

JwtAuthenticationFilter.java: 들어오는 요청에 대한 JWT 인증을 처리합니다.

JwtUtil.java: JWT 토큰 관리를 위한 유틸리티 클래스입니다.

PersistenceConfig.java: 데이터베이스 영속성 구성을 처리합니다.

QuerydslConfig.java: 고급 쿼리 기능을 위한 QueryDSL을 설정합니다.

SecurityConfig.java: Spring Security 구성을 처리합니다.

WebConfig.java: 웹 관련 구성을 처리합니다.

도메인 모듈

인증(Authentication)

컨트롤러: 로그인 및 회원가입과 같은 인증 엔드포인트를 관리합니다.

DTO: 인증 요청 및 응답을 위한 데이터 전송 객체.

서비스: 인증 비즈니스 로직을 처리합니다.

예외: 인증 오류에 대한 커스텀 예외.

사용자 관리(User Management)

컨트롤러: 사용자 계정 및 역할 관리를 위한 엔드포인트.

DTO: 사용자 관련 요청 및 응답을 위한 데이터 객체.

엔티티: 사용자 엔티티 정의.

리포지토리: 사용자 관련 데이터베이스 작업.

서비스: 사용자 관련 비즈니스 로직.

댓글 관리(Comments)

컨트롤러: 댓글 관리를 위한 엔드포인트.

DTO: 댓글 작업을 위한 데이터 객체.

엔티티: 댓글 엔티티 정의.

리포지토리: 댓글 관련 데이터베이스 작업.

서비스: 댓글 관련 비즈니스 로직.

작업 관리(To-Do Management)

컨트롤러: To-Do 엔드포인트를 관리합니다.

DTO: To-Do 작업을 위한 데이터 전송 객체.

엔티티: To-Do 엔티티 정의.

리포지토리: 커스텀 구현을 포함합니다.

서비스: To-Do 관련 비즈니스 로직.

관리자(Manager)

컨트롤러: 관리자 관련 작업 엔드포인트.

DTO: 관리자 관련 요청 및 응답 데이터 객체.

엔티티: 관리자 엔티티 정의.

리포지토리: 관리자 관련 데이터베이스 작업.

서비스: 관리자 비즈니스 로직.

기타 모듈

AOP: 관리자 액세스 로깅을 위한 Aspect.

클라이언트: 외부 API 통합을 위한 WeatherClient 포함.

공통(Common): 애너테이션, 예외, 유틸리티 클래스와 같은 공유 리소스.

주요 기능

인증: API 접근 보안을 위한 JWT 기반 인증.

사용자 관리: 역할 기반 사용자 접근 및 비밀번호 관리.

댓글 시스템: 댓글 추가, 보기 및 관리.

To-Do 관리: 작업 생성, 보기 및 추적.

관리자 로깅: 관리자 작업 로깅을 위한 AOP 기반 로깅.

날씨 클라이언트: 외부 날씨 API 통합 예제.

사용 기술

Java: 주요 프로그래밍 언어.

Spring Boot: 애플리케이션 개발을 위한 프레임워크.

JWT: 안전한 인증을 위한 JSON Web Tokens.

QueryDSL: 고급 쿼리 기능.

AOP: 로깅을 위한 관점 지향 프로그래밍.

시작하기

저장소 클론:

git clone <repository-url>

프로젝트 빌드:

./mvnw clean install

애플리케이션 실행:

./mvnw spring-boot:run

애플리케이션 접속: 브라우저에서 http://localhost:8080으로 접속합니다.

기여

저장소를 포크하고 개선 사항이나 버그 수정을 위한 풀 리퀘스트를 제출해 주세요.
