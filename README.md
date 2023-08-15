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


