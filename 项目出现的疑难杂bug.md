**2022/12/2**
Mapped Statements collection already contains value for.....
出现原因：在mapper的java文件里面已经写了sql语句的注解了，但是在xml文件里面又写了一次sql语句





**Cause: org.apache.ibatis.binding.BindingException: Parameter 'condition' not found. Available parame**

出现原因：在mapper里面的注解sql函数，变量名@param里面的和传入的不一致

![image-20221202145107197](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202145107197.png)

**There is no getter for property named 'condition' in 'class com.calmkin.pojo.Condition'**

检查发现并不是getter和setter的问题

解决方案：在condition加上注解（我以为condition对象算是单参，可以不用加注解，仔细想一下好像有多个成员变量，于是加上去试了一下，果然可以）![image-20221202152553999](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202152553999.png)

而且，#{}里面的属性名称要和对象的属性名称完全一致，否则也会报这个错误









因为![image-20221202163422794](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202163422794.png)

实际显示出来的很丑，全都在一行

所以决定用表格来放用户个人信息

但是因为查询的是单个用户的信息，所以后端返回的是一个用户对象User

所以我用一个对象绑定到Form上就报错了，类型检查不正确，大概意思就是本来要求的是数组类型，结果得到的是对象

所以只能把用户信息变成数组类型

但是同一个用户的多次查询又会导致重复信息显示

所以每次查询之前，先把用户信息的数组清空

![image-20221202163334503](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202163334503.png)

![image-20221202163324970](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202163324970.png)







Error querying database.  Cause: org.apache.ibatis.binding.BindingException: Parameter 'bgein' not found. Available parameters are [pageSize, begin, param1, param2]

![image-20221202190917912](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202190917912.png)

单词拼错了，所以mybatis找不到我的参数





如果pojo里面的对象没有定义的话

就算sql里面是select *  

前端得到的也只是pojo对象里面有的属性

没有定义的属性，得到的对象模型里面也不会有







实现添加记录的时候

如果id是主键，但是sql里面不填上id属性的话是不行的

当时是填了null，然后数据库进行id自增

**前提是sql里面要加上auto_increament这个属性**

否则not null约束会限制插入null属性







![image-20221202203411428](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202203411428.png)

前端的访问url配置错误，有可能是端口号写错了（比如我把服务器默认端口号改成了9999，那么url里面的端口号也要进行相应修改）





只显示了一部分数据

![image-20221202203813389](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221202203813389.png)

mapper里面没有将所有的属性进行映射，没有映射而且对象属性名和表中的属性名不一致的时候，就会出现这种情况









**2022/12/3**

**Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'subs_num = 999**

网上说什么缺少关键字。。字段不一致等

其实都不是，是多个if之间少了逗号..........

![image-20221203101526617](C:\Users\86158\AppData\Roaming\Typora\typora-user-images\image-20221203101526617.png)