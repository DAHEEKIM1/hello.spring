# [섹션2] 스프링 웹 개발 기초


## 정적 컨텐츠
![image](https://github.com/DAHEEKIM1/hello.spring/assets/66730012/570eb500-4428-46e0-b70f-510cf2ddc5b1)
- Controller에 hello-index.html이 없기 때문에 resources에서 찾아서 반환

  
## MVC와 템플릿 엔진
MVC: Model, View, Controller


![image](https://github.com/DAHEEKIM1/hello.spring/assets/66730012/070978da-68e6-4da9-9c4d-fe4dbf17ff4a)
- hellocontroller의 컨트롤러를 호출함, name을 입력받아서 view에 전달

```
    @GetMapping("hello-mvc")//Requestparam:외부에서 값을 입력받음
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);//파라미터로 넘어온 데이터의 속성, name= spring으로 입력을 받으면, 이 컨트롤러의 name이 모두 spring으로 인식
        return "hello-template";
    }
```



## API
@ResponseBody를 사용하여 http의 body에 내용을 직접 넣어준다
- 단순 문자의 경우 StringConverter가 호출되고, 메서드의 경우 객체 JsonConverter{name:spring}과 같은 형태가 호출된다

  
![image](https://github.com/DAHEEKIM1/hello.spring/assets/66730012/b3a8ac86-f282-4918-a04b-c2d5df265a51)


- @ResponseBody를 사용하면
- HTTP의 Body에 문자 내용을 직접 반환
- ViewResolver 대신에 HttpMessageConverter가 동작
- 기본 문자처리: StringHttpMessageConverter
- 기본 객체처리: MappingJackson2HttpConverter
```

```


# [섹션3] 회원 관리 예제- 백엔드 개발
## 회원 리포지토리 테스트 케이스 작성
- 개발한 기능을 실행해서 테스트할 때 자바의 메인 메서드를 통해서 실행하거나 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고 반복실행이 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다.
- -> 자바는 Junit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.

나머지는 코드로 구현



# [섹션4] 스프링 빈과 의존관계
- 스프링 빈: 스프링에 의하여 생성되고 관리되는 자바 객체


## 컴포넌트 스캔 방식
- @Controller, @Component와 같이 annotation이 있으면 스프링 컨테이너에 스프링 빈으로 자동 등록된다.
-  @Autowired: 생성자에 사용하면 객체 생성 시점에 스프링 컨테이너에서 생성자에 필요한 스프링 빈을 자동으로 찾아 주입함. 


## 코드를 통한 직접 등록
- 직접 설정 파일을 등록하여 스프링 컨테이너에 스프링 빈을 등록함. 


## DI(Dependency Injection)
1. 필드 주입: @Autowired를 생성자가 아닌 인스턴스 앞에 붙이는 것
2. setter 주입: setter 메서드를 설정해 스프링 컨테이너가 호출하게 하는것. 
3. 생성자 주입



# [섹션5] 회원 관리 예제 - 웹 MVC 개발

회원 등록 및 전체 회원 조회 - 코드 


# [섹션6] 스프링 DB 접근 기술
1. H2 데이터베이스
   - H2 데이터베이스 설치 후 Member table 생성하기
2. JDBC connection(JdbcMemberRepository)
3. 스프링 통합 테스트- 컨테이너와 DB를 통합해서 테스트 하는것
   - @SpringBootTest: 스프링 컨테이너와 테스트 함께 실행
   - @Transactional: 테스트시작전 트랜잭션을 시작하고, 완료 후 롤백한다. -> DB에 데이터가 남지않아 다음 테스트에 영향을 주지 않음.

4. JdbcTemplate
   - MyBatis와 비슷함. sql문은 직접 작성해야한다.
   - SimpleJdbcInsert를 사용하면 tablename과 key만 있으면 만들어진다.
   - jdbcTemplate으로 query날리고 memberRowMapper로 매핑
  
5. JPA
   - SQL은 직접 개발자가 작성해야하는 번거로움을 처리해준다.
   - SQL과 데이터 중심 설계에서 객체지향 설계로 전환이 가능하다.
   - build.gradle에 spring-boot-starter-data-jpa를 추가하면된다.

6. 스프링 데이터 JPA
   - 개발에서 반복이 줄어들고 생산성이 증가한다.
   - 리포지토리에 구현 클래스 없이 인터페이스 만으로 개발이 가능하며 CRUD 기능도 제공한다.
  
# [섹션7] AOP(Aspect-Oriented Programming)
## AOP란 핵심 로직과 부가 기능을 분리하여 애플리케이션 전체에 걸쳐 사용되는 부가 기능을 모듈화 하여 재사용할 수 있도록 지원하는 것을 말함. 

### AOP의 적용방식
1. 컴파일 시점
- .java 파일을 컴파일러를 통해 .class를 만드는 시점에 부가 기능 로직을 추가하는 방식으로 모든 지점에 적용 가능
- AspectJ가 제공하는 특별한 컴파일러를 사용해야 하기 때문에 특별할 컴파일러가 필요한 점과 복잡하다는 단점
2. 클래스 로딩 시점
- .class 파일을 JVM 내부의 클래스 로더에 보관하기 전에 조작하여 부가 기능 로직 추가하는 방식으로 모든 지점에 적용 가능
- 특별한 옵션과 클래스 로더 조작기를 지정해야하므로 운영하기 어려움
3. 런타임 시점
- 스프링이 사용하는 방식으로 컴파일이 끝나고 클래스 로더에 이미 다 올라가 자바가 실행된 다음에 동작하는 런타임 방식
- 실제 대상 코드는 그대로 유지되고 프록시를 통해 부가 기능이 적용된다
- 프록시는 메서드 오버라이딩 개념으로 동작하기 때문에 메서드에만 적용 가능 -> 스프링 빈에만 AOP를 적용 가능
- 특별한 컴파일러나, 복잡한 옵션, 클래스 로더 조작기를 사용하지 않아도 스프링만 있으면 AOP를 적용할 수 있기 때문에 스프링 AOP는 런타임 방식을 사용

  ### AOP 용어
  - join point
  - pointcut
  - target
  - advice
  - aspect
  - advisor
  - weaving
  - 프록시

  AOP의 동작 원리
- 스프링 빈들 앞에 proxy를 만들어주고, 스프링 컨테이너는 의존성 주입때 proxy빈을 넣어준다.
- 실제 빈을 실행할때 proxy빈이 수행되고 joinpoint가 각각의 메서드들이 실행될 때 개입해 시간을 체크해주는 방식으로 작동한다.
- ![image](https://github.com/DAHEEKIM1/hello.spring/assets/66730012/842d69f9-e650-44b4-8ef4-8dc6fcc71f9d)

### @Around
- 시간측정로직을 적용하고 싶은 부분에 써준다.

### @Aespect
- 메서드가 AOP 기능을 할 수 있게한다. 

![image](https://github.com/DAHEEKIM1/hello.spring/assets/66730012/1c04644c-df92-40f5-867a-0d160a7bf637)
