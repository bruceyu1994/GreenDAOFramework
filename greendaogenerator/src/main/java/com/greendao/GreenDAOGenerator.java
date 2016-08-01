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
        Entity task = schema.addEntity("Task");

        //为实体添加注解
        task.setJavaDoc("任务类，对应数据库中的一张任务表，存储护士的任务列表");
//        task.setCodeBeforeClass("@Awesome");
//        task.addIntProperty("counter")
//                .codeBeforeField("@SerializedName(\"the-number-of-things\")")
//                .javaDocGetterAndSetter("The total count");

        // 你也可以重新给表命名
        // tasks.setTableName("NODE");
        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        //主键ID
        task.addIdProperty();
        // 病区ID
        task.addLongProperty("BQID").codeBeforeField("//病区ID").javaDocGetter("获取病区ID")
                .javaDocSetter("设置病区ID");
        // 责任护士ID
        task.addLongProperty("USERID").codeBeforeField("//责任护士ID")
                .javaDocSetter("设置责任护士ID").javaDocGetter("获取责任护士ID");
        // 任务类型 :输血；皮试；静滴；静注；化验；其他药品
        task.addIntProperty("RWLX")
                .codeBeforeField("//任务类型 :输血；皮试；静滴；静注；化验；其他药品")
            .javaDocGetter("获取任务类型").javaDocSetter("设置任务类型");
        // 任务名
        task.addStringProperty("RWM").codeBeforeField("//任务名")
                .javaDocGetter("获取任务名")
                .javaDocSetter("设置任务名");
        // 住院号
        task.addStringProperty("ZYH").codeBeforeField("//住院号")
                .javaDocGetter("获取住院号")
            .javaDocSetter("设置住院号");
        // 任务内容
        task.addStringProperty("RWNR").codeBeforeField("//任务内容")
                .javaDocGetter("获取任务内容")
                .javaDocSetter("设置任务内容");
        // 任务条码
        task.addStringProperty("TXM").codeBeforeField("//任务条码")
                .javaDocGetter("获取任务条码")
                .javaDocSetter("设置任务条码");
        // 任务时间
        task.addDateProperty("YZSJ").codeBeforeField("//任务时间")
                .javaDocGetter("获取任务时间")
                .javaDocSetter("设置任务时间");
        // 任务显示时间差
        task.addDateProperty("RWXSSJC").codeBeforeField("//任务显示时间差")
                .javaDocGetter("获取任务显示时间差")
                .javaDocSetter("设置任务显示时间差");
        // 任务状态: 有哪些？
        task.addStringProperty("RWZT").codeBeforeField("//任务状态: 有哪些？")
                .javaDocGetter("获取任务状态")
                .javaDocSetter("设置任务状态");
        // 任务级别:似乎跟任务类型相似
        task.addIntProperty("RWJB").codeBeforeField("//任务级别:似乎跟任务类型相似")
                .javaDocGetter("获取任务级别")
                .javaDocSetter("设置任务级别");
        // 任务停止flag(状态标志)
        task.addBooleanProperty("RRTZ").codeBeforeField("//任务停止flag(状态标志)")
                .javaDocGetter("获取状态标志")
                .javaDocSetter("设置状态标志");
        // 执行人
        task.addStringProperty("ZZR").codeBeforeField("//执行人")
                .javaDocGetter("获取住院号")
                .javaDocSetter("设置住院号");
        // 执行时间
        task.addDateProperty("ZZSJ").codeBeforeField("//执行时间")
                .javaDocGetter("获取执行人")
                .javaDocSetter("设置执行人");
        // 执行结果
        task.addStringProperty("ZZJG").codeBeforeField("//执行结果")
                .javaDocGetter("获取执行结果")
                .javaDocSetter("设置执行结果");
        // 审核人
        task.addStringProperty("SHR").codeBeforeField("//审核人")
                .javaDocGetter("获取审核人")
                .javaDocSetter("设置审核人");
        // 审核时间
        task.addDateProperty("SHSJ").codeBeforeField("//审核时间")
                .javaDocGetter("获取审核时间")
                .javaDocSetter("设置审核时间");
        // 审核结果
        task.addStringProperty("SHJG").codeBeforeField("//审核结果")
                .javaDocGetter("获取审核结果")
                .javaDocSetter("设置审核结果");
        // 病人姓名
        task.addStringProperty("BRXM").codeBeforeField("//病人姓名")
                .javaDocGetter("获取病人姓名")
                .javaDocSetter("设置病人姓名");
        // 病人性别
        task.addStringProperty("BRXB").codeBeforeField("//病人性别")
                .javaDocGetter("获取病人性别")
                .javaDocSetter("设置病人性别");
        // 病人年龄
        task.addIntProperty("BRNL").codeBeforeField("//病人年龄")
                .javaDocGetter("获取病人年龄")
                .javaDocSetter("设置病人年龄");
        // 提交状态  0：未提交； 1:已提交
        task.addIntProperty("TJZT").codeBeforeField("//提交状态  0：未提交； 1:已提交")
                .javaDocGetter("获取提交状态")
                .javaDocSetter("设置提交状态");
    }
}
