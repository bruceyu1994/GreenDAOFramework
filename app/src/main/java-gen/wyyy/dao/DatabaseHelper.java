package wyyy.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lvqiyao (amorfatilay@163.com).
 * 2016/7/31 16:19.
 * 类描述：继承了DaoMaster.DevOpenHelper，用于创建数据库以及升级数据库
 */
public class DatabaseHelper extends DaoMaster.DevOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:27
     * 描述:重命名表
     */
    public void renameTable(SQLiteDatabase db, String oldName, String newName) {
        db.execSQL("ALTER TABLE " + oldName + " RENAME TO " + newName);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:24
     * 描述:删除某表, 或者调用表对应的DAO类的dropTable
     */
    public void dropTable(SQLiteDatabase db, String tableName) {
        db.execSQL("drop table if exists " +  tableName);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:33
     * 描述:请不要使用这个函数而是调用表对应的DAO类的createTable来建表
     */
    public void createTable() {
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:27
     * 描述:增加一列
     */
    public void addColumn(SQLiteDatabase db, String tableName, String colName, String colType) {
        db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN " + colName + " " + colType);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/30 12:58
     * 描述:删除若干字段，要操作的表的表名：tableName， 要保留的字段savingCols
     */
    public void delColumns(SQLiteDatabase db, String tableName, String[] savingCols) {
//        db.execSQL("ALTER TABLE " + tableName + " DROP COLUMN " + colName);
        String sql = "create table temp as select ";
        for (int i = 0; i < savingCols.length; i++) {
            sql += savingCols[i];
            sql += (i == (savingCols.length - 1)) ? " " : ",";
        }
        sql += "from " + tableName;
        db.execSQL(sql);
        dropTable(db, tableName);
        renameTable(db, "temp", tableName);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:23
     * 描述:获得某个表的所有列名
     */
    public String[] getColNames(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery("select * from " + tableName, null);
        String names[] = cursor.getColumnNames();
        cursor.close();
        return names;
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:23
     * 描述:修改列名，可一次修改多列！！这个还有问题
     */
    public void editColName(SQLiteDatabase db, String tableName, String[] newColNames, int[] editColIndex) {
        String[] cols = getColNames(db, tableName);
        if (newColNames.length == editColIndex.length) {
            for (int i = 0; i < editColIndex.length; i++) {
                cols[editColIndex[i]] += " as " + newColNames[i];
            }
        }
        String sql = "create table temp as select ";
        for (int i = 0; i < cols.length; i++) {
            sql += cols[i];
            sql += (i == (cols.length - 1)) ? " " : ",";
        }
        sql += "from " + tableName;
        db.execSQL(sql);
        dropTable(db, tableName);
        renameTable(db, "temp", tableName);
    }

    /**
     * Created by lvqiyao (amorfatilqy@163.com)
     * 2016/7/31 16:25
     * 描述:升级时会执行改函数，为了保证每个版本的操作都有执行，case后不要加break
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {

        }
    }
}
