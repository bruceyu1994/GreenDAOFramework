package wyyy.dao;

import android.content.Context;

import org.greenrobot.greendao.async.AsyncSession;

/**
 * Created by lvqiyao (amorfatilay@163.com).
 * 2016/7/31 16:39.
 * 类描述：
 */
public class DatabaseManager {
    private static DatabaseManager INSTANCE;
    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/27 10:58
     * 描述:单例获取instance
     */
    public static DatabaseManager getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseManager(context);
                }
            }
        }
        return INSTANCE;
    }
    private static final String DB_NAME = "MOBILE_NURSE_DB";
    private DaoSession daoSession;
    private AsyncSession asyncSession;
    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:50
     * 描述:构造函数
     */
    private DatabaseManager(Context context) {
        //通过DaoMaster的内部类DevOpenHelper,得到一个SQLiteOpenHelper
        DatabaseHelper helper = new DatabaseHelper(context, DB_NAME, null);
        //生成Session， 多个session指的是相同的数据库连接，所以只生成一个
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
//        asyncSession = daoSession.startAsyncSession();
    }
    public TaskDao getTasksDao() {
        return daoSession.getTaskDao();
    }
    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:44
     * 描述:返回一个AsyncSession实例，用于实现异步操作
     */
    public AsyncSession getAsyncSession() {
        return asyncSession;
    }
}