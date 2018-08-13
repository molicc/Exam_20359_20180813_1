- 程序通过Tomcat配置无误并启动后，从入口/index.jsp进入，点击登录并无误后可进入FilmList界面，对Film信息进行增删查改。未通过Filter登录校验均会返回登录界面并提示相关错误信息。
- 本项目使用MySQL+mybatis+bootstrap进行实现，其中通过mybatis实现数据库的交互。为了使得配置文件能够正确加载需要在maven的构建文件中加入<resources>标签并进行资源目录的配置。
- 数据库配置放于/src/main/resources/database.properties中，mybatis配置文件放于/src/main/resources/mybatis-config.xml中
- 本项目共有两个实体类分别是com.exam.entity.Customer以及com.exam.entity.Film。
- 数据访问对象为com.exam.dao.CustomerMapper以及com.exam.dao.FilmMapper分别对应相应的配置文件com/exam/dao/CustomerMapper.xml以及com/exam/dao/FilmMapper.xml。其中对数据库的操作均在xml中实现。
- 为了方便业务逻辑的处理，对数据库连接操作封装成工具类，位于com.exam.util.MyBatisUtil。
- 在com.exam.service.FilmServerImpl以及com.exam.service.LoginCheckingImpl实现了对Film和Customer增删查改的业务逻辑，
- web.xml中实现了url和servlet的绑定<br>
在过滤器的基础上,对除了index.jsp,login.jsp,login.action外的所有url进行登录校验<br>
从index.jsp进入选择登录跳转login.jsp，点击登录触发LoginServlet对其进行登录校验，成功则触发FilmListServlet显示所有信息<br>
并在FilmList.jsp点击不同按钮对数据进行相应的增删查改操作，每次完成相应操作均重定向到Filmlist.action进行结果展示。
- GitHub: