在本工程中使用了以下开源技术，为避免忘记，统一做个说明：
1. lombok
lombok是在编译期间自动生成代码，好处是使代码更加简洁；坏处是确定某一个类的方法在什么地方调用相对困难（实际在eclipse中还是可以通过outline找到对应的setter和getter方法，并找到对应调用的地方），以及对于提供jar包给其它工程调用时，其它工程也不得不使用lombok而不论开发者是否愿意；
下面对主要注解做一个说明
@ToString：作用于类，覆盖默认的toString()方法，可以通过of属性限定显示某些字段，通过exclude属性排除某些字段。
@EqualsAndHashCode：作用于类，覆盖默认的equals和hashCode
@NonNull：主要作用于成员变量和参数中，标识不能为空，否则抛出空指针异常。
@NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor：作用于类上，用于生成构造函数。有staticName、access等属性。
	staticName属性一旦设定，将采用静态方法的方式生成实例，access属性可以限定访问权限。
	@NoArgsConstructor：生成无参构造器；
	@RequiredArgsConstructor：生成包含final和@NonNull注解的成员变量的构造器；
	@AllArgsConstructor：生成全参构造器
@Data：作用于类上，是以下注解的集合：@ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor
@Builder：作用于类上，将类转变为建造者模式
@Log：作用于类上，生成日志变量。针对不同的日志实现产品，有不同的注解：

其他重要注解：
@Cleanup：自动关闭资源，针对实现了java.io.Closeable接口的对象有效，如：典型的IO流对象
@SneakyThrows：可以对受检异常进行捕捉并抛出
@Synchronized：作用于方法级别，可以替换synchronize关键字或lock锁，用处不大.
@Accessors：
	fluent
	fluent的中文含义是流畅的，设置为true，则getter和setter方法的方法名都是基础属性名，且setter方法返回当前对象。
	chain
	chain的中文含义是链式的，设置为true，则setter方法返回当前对象。
	@Data
	@Accessors(fluent = true, chain=true)
	public class User {
	    private Long id;
	    private String name;
	    // 生成的getter和setter方法如下，方法体略
	    public Long id() {}
	    public User id(Long id) {}
	    public String name() {}
	    public User name(String name) {}
	}
	prefix
	prefix的中文含义是前缀，用于生成getter和setter方法的字段名会忽视指定前缀（遵守驼峰命名）


	
	
	
