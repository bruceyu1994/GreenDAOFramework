package com.greendao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDAOGenerator {
    private static int version = 1;    //数据库版本号
    private static String beanPackage = "wyyy.bean";  //bean包名
    private static String daoPackage = "wyyy.dao";  //DAO 类包名

    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        //你也可以分别指定生成的 Bean 与 DAO 类所在的目录
        Schema schema = new Schema(version, beanPackage);
        schema.setDefaultJavaPackageDao(daoPackage);

        // 模式（Schema）同时也拥有两个默认的 flags，分别用来标示 entity 是否是 activie 以及是否使用 keep sections。
        schema.enableActiveEntitiesByDefault();   //使能实体的增删改查
        schema.enableKeepSectionsByDefault();  //添加自己的信息后，进行重新生成，不会消失

        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        addTasks(schema);

        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。

        //args参数在build.gradle中已经run中已经配置好了，不过要在gradle面板中双击run才有效；
        // 直接选中“GreenDAOGGenerator”类，右击选择Run运行,会报args数组越界的异常
        new DaoGenerator().generateAll(schema, args[0]);

    }

    public static void addTasks(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Tasks」（既类名）
        Entity tasks = schema.addEntity("Tasks");
        // 你也可以重新给表命名
        // tasks.setTableName("NODE");
        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        //主键ID
        tasks.addIdProperty();
        // 病区ID
        tasks.addLongProperty("BQID");
        // 责任护士ID
        tasks.addLongProperty("USERID");
        // 任务类型 1:输血； 2：皮试； 3：静滴； 4：静注； 5：化验； 6：其他药品
        tasks.addIntProperty("RWLX");
        // 任务名
        tasks.addStringProperty("RWM");
        // 住院号
        tasks.addStringProperty("ZYH");
        // 任务内容
        tasks.addStringProperty("RWNR");
        // 任务条码
        tasks.addStringProperty("TXM");
        // 任务时间
        tasks.addDateProperty("YZSJ");
        // 任务显示时间差
        tasks.addDateProperty("RWXSSJC");
        // 任务状态: 有哪些？
        tasks.addStringProperty("RWZT");
        // 任务级别:似乎跟任务类型相似
        tasks.addIntProperty("RWJB");
        // 任务停止flag(状态标志)
        tasks.addBooleanProperty("RRTZ");
        // 执行人
        tasks.addStringProperty("ZZR");
        // 执行时间
        tasks.addDateProperty("ZZSJ");
        // 执行结果
        tasks.addStringProperty("ZZJG");
        // 审核人
        tasks.addStringProperty("SHR");
        // 审核时间
        tasks.addDateProperty("SHSJ");
        // 审核结果
        tasks.addStringProperty("SHJG");
        // 病人姓名
        tasks.addStringProperty("BRXM");
        // 病人性别
        tasks.addStringProperty("BRXB");
        // 病人年龄
        tasks.addIntProperty("BRNL");
        // 提交状态  0：未提交； 1:已提交
        tasks.addIntProperty("TJZT");
    }
}
