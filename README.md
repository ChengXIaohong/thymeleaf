# thymeleaf
## thymeleaf入门demo
1.该项目以springboot为依赖，写了thymeleaf的基本取值策略和JS取值方法
2.链接类型为redirect时，如果向前端注入模板数据 依赖RedirectAttributes对象(风险-参数暴露)
3.thymeleaf基本语法
流程：
##### 流程
######  1：pom添加依赖   
                          <dependency>
                              <groupId>org.springframework.boot</groupId>
                              <artifactId>spring-boot-starter-thymeleaf</artifactId>
                              <version>1.0.2.RELEASE</version>
                          </dependency>
                          <properties>
                                  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                          
                                  <!--引入thymeleaf-->
                                  <thymeleaf.version> 3.0.2.RELEASE </thymeleaf.version>
                                  <thymeleaf-layout-dialect.version> 2.1.1 </thymeleaf-layout-dialect.version>
                          </properties> 
######  2：配置thymeleaf参数 
                            server:
                              port: 8009
                            spring:
                              thymeleaf:
                                mode: HTML5
                                cache: false #不开启缓存 这样可以修改html模版文件直接刷新页面看结果
                                suffix: .html #模板文件后缀
                                content-type: text/html #模板文件类型
                                prefix: classpath:/templates/ #模板路径 Controller层返回文件路径在此路径之后
######  3：页面引入thymeleaf
                     <!DOCTYPE HTML>
                     <html xmlns:th="http://www.thymeleaf.org"
#####  细则
    1.引入URL  <link th:href="@{https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css}" rel="stylesheet"/> <a th:href="@{/dispatcher}">model</a>
    2.获取变量值 <span th:text="${singlePerson.name}"></span>
    3.JS获取对象值（会被格式化为JSON字符串） var person = [[${people}]];
    4.条件判断：<span class="label label-danger" th:if ="${person.age} le 17" >未成年</span>
               <span class="label label-warning" th:if ="${person.age} le 22 and ${person.age} gt 18" >已成年</span>
               <span class="label label-warning" th:if ="${person.age} le 32 and ${person.age} gt 22" >青壮年</span>
               <span class="label label-warning" th:if ="${person.age} le 40 and ${person.age} gt 32" >老年初期</span>
    5.dom元素传值给JS 
        单个值：<button class="btn" th:onclick="'getName(\''+${person.name}+'\');'">获得名字</button>
        多个值：<button class="btn" th:onclick="'say(\''+${person.name}+'\',\''+${person.age}+'\');'">简单介绍</button>
    6.迭代
        <li class="list-group-item" th:each="person : ${people}">
                            <span th:text="${person.name}"></span>
                            <span th:text="${person.age}" ></span>
                            <button class="btn" th:text="${person.sex}"></button>
                            <button class="btn" th:onclick="'getName(\''+${person.name}+'\');'">获得名字</button>
                            <button class="btn" th:onclick="'say(\''+${person.name}+'\',\''+${person.age}+'\');'">简单介绍</button>
                        </li>
            

                  
                                
