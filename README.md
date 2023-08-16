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



#[섹션5] 회원 관리 예제 - 웹 MVC 개발

회원 등록 및 전체 회원 조회 - 코드 
