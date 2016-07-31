package wyyy.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import wyyy.bean.Tasks;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TASKS".
*/
public class TasksDao extends AbstractDao<Tasks, Long> {

    public static final String TABLENAME = "TASKS";

    /**
     * Properties of entity Tasks.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BQID = new Property(1, Long.class, "BQID", false, "BQID");
        public final static Property USERID = new Property(2, Long.class, "USERID", false, "USERID");
        public final static Property RWLX = new Property(3, Integer.class, "RWLX", false, "RWLX");
        public final static Property RWM = new Property(4, String.class, "RWM", false, "RWM");
        public final static Property ZYH = new Property(5, String.class, "ZYH", false, "ZYH");
        public final static Property RWNR = new Property(6, String.class, "RWNR", false, "RWNR");
        public final static Property TXM = new Property(7, String.class, "TXM", false, "TXM");
        public final static Property YZSJ = new Property(8, java.util.Date.class, "YZSJ", false, "YZSJ");
        public final static Property RWXSSJC = new Property(9, java.util.Date.class, "RWXSSJC", false, "RWXSSJC");
        public final static Property RWZT = new Property(10, String.class, "RWZT", false, "RWZT");
        public final static Property RWJB = new Property(11, Integer.class, "RWJB", false, "RWJB");
        public final static Property RRTZ = new Property(12, Boolean.class, "RRTZ", false, "RRTZ");
        public final static Property ZZR = new Property(13, String.class, "ZZR", false, "ZZR");
        public final static Property ZZSJ = new Property(14, java.util.Date.class, "ZZSJ", false, "ZZSJ");
        public final static Property ZZJG = new Property(15, String.class, "ZZJG", false, "ZZJG");
        public final static Property SHR = new Property(16, String.class, "SHR", false, "SHR");
        public final static Property SHSJ = new Property(17, java.util.Date.class, "SHSJ", false, "SHSJ");
        public final static Property SHJG = new Property(18, String.class, "SHJG", false, "SHJG");
        public final static Property BRXM = new Property(19, String.class, "BRXM", false, "BRXM");
        public final static Property BRXB = new Property(20, String.class, "BRXB", false, "BRXB");
        public final static Property BRNL = new Property(21, Integer.class, "BRNL", false, "BRNL");
        public final static Property TJZT = new Property(22, Integer.class, "TJZT", false, "TJZT");
    };

    private DaoSession daoSession;


    public TasksDao(DaoConfig config) {
        super(config);
    }
    
    public TasksDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TASKS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"BQID\" INTEGER," + // 1: BQID
                "\"USERID\" INTEGER," + // 2: USERID
                "\"RWLX\" INTEGER," + // 3: RWLX
                "\"RWM\" TEXT," + // 4: RWM
                "\"ZYH\" TEXT," + // 5: ZYH
                "\"RWNR\" TEXT," + // 6: RWNR
                "\"TXM\" TEXT," + // 7: TXM
                "\"YZSJ\" INTEGER," + // 8: YZSJ
                "\"RWXSSJC\" INTEGER," + // 9: RWXSSJC
                "\"RWZT\" TEXT," + // 10: RWZT
                "\"RWJB\" INTEGER," + // 11: RWJB
                "\"RRTZ\" INTEGER," + // 12: RRTZ
                "\"ZZR\" TEXT," + // 13: ZZR
                "\"ZZSJ\" INTEGER," + // 14: ZZSJ
                "\"ZZJG\" TEXT," + // 15: ZZJG
                "\"SHR\" TEXT," + // 16: SHR
                "\"SHSJ\" INTEGER," + // 17: SHSJ
                "\"SHJG\" TEXT," + // 18: SHJG
                "\"BRXM\" TEXT," + // 19: BRXM
                "\"BRXB\" TEXT," + // 20: BRXB
                "\"BRNL\" INTEGER," + // 21: BRNL
                "\"TJZT\" INTEGER);"); // 22: TJZT
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TASKS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Tasks entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long BQID = entity.getBQID();
        if (BQID != null) {
            stmt.bindLong(2, BQID);
        }
 
        Long USERID = entity.getUSERID();
        if (USERID != null) {
            stmt.bindLong(3, USERID);
        }
 
        Integer RWLX = entity.getRWLX();
        if (RWLX != null) {
            stmt.bindLong(4, RWLX);
        }
 
        String RWM = entity.getRWM();
        if (RWM != null) {
            stmt.bindString(5, RWM);
        }
 
        String ZYH = entity.getZYH();
        if (ZYH != null) {
            stmt.bindString(6, ZYH);
        }
 
        String RWNR = entity.getRWNR();
        if (RWNR != null) {
            stmt.bindString(7, RWNR);
        }
 
        String TXM = entity.getTXM();
        if (TXM != null) {
            stmt.bindString(8, TXM);
        }
 
        java.util.Date YZSJ = entity.getYZSJ();
        if (YZSJ != null) {
            stmt.bindLong(9, YZSJ.getTime());
        }
 
        java.util.Date RWXSSJC = entity.getRWXSSJC();
        if (RWXSSJC != null) {
            stmt.bindLong(10, RWXSSJC.getTime());
        }
 
        String RWZT = entity.getRWZT();
        if (RWZT != null) {
            stmt.bindString(11, RWZT);
        }
 
        Integer RWJB = entity.getRWJB();
        if (RWJB != null) {
            stmt.bindLong(12, RWJB);
        }
 
        Boolean RRTZ = entity.getRRTZ();
        if (RRTZ != null) {
            stmt.bindLong(13, RRTZ ? 1L: 0L);
        }
 
        String ZZR = entity.getZZR();
        if (ZZR != null) {
            stmt.bindString(14, ZZR);
        }
 
        java.util.Date ZZSJ = entity.getZZSJ();
        if (ZZSJ != null) {
            stmt.bindLong(15, ZZSJ.getTime());
        }
 
        String ZZJG = entity.getZZJG();
        if (ZZJG != null) {
            stmt.bindString(16, ZZJG);
        }
 
        String SHR = entity.getSHR();
        if (SHR != null) {
            stmt.bindString(17, SHR);
        }
 
        java.util.Date SHSJ = entity.getSHSJ();
        if (SHSJ != null) {
            stmt.bindLong(18, SHSJ.getTime());
        }
 
        String SHJG = entity.getSHJG();
        if (SHJG != null) {
            stmt.bindString(19, SHJG);
        }
 
        String BRXM = entity.getBRXM();
        if (BRXM != null) {
            stmt.bindString(20, BRXM);
        }
 
        String BRXB = entity.getBRXB();
        if (BRXB != null) {
            stmt.bindString(21, BRXB);
        }
 
        Integer BRNL = entity.getBRNL();
        if (BRNL != null) {
            stmt.bindLong(22, BRNL);
        }
 
        Integer TJZT = entity.getTJZT();
        if (TJZT != null) {
            stmt.bindLong(23, TJZT);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Tasks entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long BQID = entity.getBQID();
        if (BQID != null) {
            stmt.bindLong(2, BQID);
        }
 
        Long USERID = entity.getUSERID();
        if (USERID != null) {
            stmt.bindLong(3, USERID);
        }
 
        Integer RWLX = entity.getRWLX();
        if (RWLX != null) {
            stmt.bindLong(4, RWLX);
        }
 
        String RWM = entity.getRWM();
        if (RWM != null) {
            stmt.bindString(5, RWM);
        }
 
        String ZYH = entity.getZYH();
        if (ZYH != null) {
            stmt.bindString(6, ZYH);
        }
 
        String RWNR = entity.getRWNR();
        if (RWNR != null) {
            stmt.bindString(7, RWNR);
        }
 
        String TXM = entity.getTXM();
        if (TXM != null) {
            stmt.bindString(8, TXM);
        }
 
        java.util.Date YZSJ = entity.getYZSJ();
        if (YZSJ != null) {
            stmt.bindLong(9, YZSJ.getTime());
        }
 
        java.util.Date RWXSSJC = entity.getRWXSSJC();
        if (RWXSSJC != null) {
            stmt.bindLong(10, RWXSSJC.getTime());
        }
 
        String RWZT = entity.getRWZT();
        if (RWZT != null) {
            stmt.bindString(11, RWZT);
        }
 
        Integer RWJB = entity.getRWJB();
        if (RWJB != null) {
            stmt.bindLong(12, RWJB);
        }
 
        Boolean RRTZ = entity.getRRTZ();
        if (RRTZ != null) {
            stmt.bindLong(13, RRTZ ? 1L: 0L);
        }
 
        String ZZR = entity.getZZR();
        if (ZZR != null) {
            stmt.bindString(14, ZZR);
        }
 
        java.util.Date ZZSJ = entity.getZZSJ();
        if (ZZSJ != null) {
            stmt.bindLong(15, ZZSJ.getTime());
        }
 
        String ZZJG = entity.getZZJG();
        if (ZZJG != null) {
            stmt.bindString(16, ZZJG);
        }
 
        String SHR = entity.getSHR();
        if (SHR != null) {
            stmt.bindString(17, SHR);
        }
 
        java.util.Date SHSJ = entity.getSHSJ();
        if (SHSJ != null) {
            stmt.bindLong(18, SHSJ.getTime());
        }
 
        String SHJG = entity.getSHJG();
        if (SHJG != null) {
            stmt.bindString(19, SHJG);
        }
 
        String BRXM = entity.getBRXM();
        if (BRXM != null) {
            stmt.bindString(20, BRXM);
        }
 
        String BRXB = entity.getBRXB();
        if (BRXB != null) {
            stmt.bindString(21, BRXB);
        }
 
        Integer BRNL = entity.getBRNL();
        if (BRNL != null) {
            stmt.bindLong(22, BRNL);
        }
 
        Integer TJZT = entity.getTJZT();
        if (TJZT != null) {
            stmt.bindLong(23, TJZT);
        }
    }

    @Override
    protected final void attachEntity(Tasks entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Tasks readEntity(Cursor cursor, int offset) {
        Tasks entity = new Tasks( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // BQID
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // USERID
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // RWLX
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // RWM
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // ZYH
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // RWNR
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // TXM
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)), // YZSJ
            cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)), // RWXSSJC
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // RWZT
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // RWJB
            cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0, // RRTZ
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // ZZR
            cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)), // ZZSJ
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // ZZJG
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // SHR
            cursor.isNull(offset + 17) ? null : new java.util.Date(cursor.getLong(offset + 17)), // SHSJ
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // SHJG
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // BRXM
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // BRXB
            cursor.isNull(offset + 21) ? null : cursor.getInt(offset + 21), // BRNL
            cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22) // TJZT
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Tasks entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBQID(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUSERID(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setRWLX(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setRWM(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setZYH(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRWNR(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTXM(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setYZSJ(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
        entity.setRWXSSJC(cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)));
        entity.setRWZT(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRWJB(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setRRTZ(cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0);
        entity.setZZR(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setZZSJ(cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)));
        entity.setZZJG(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setSHR(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setSHSJ(cursor.isNull(offset + 17) ? null : new java.util.Date(cursor.getLong(offset + 17)));
        entity.setSHJG(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setBRXM(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setBRXB(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setBRNL(cursor.isNull(offset + 21) ? null : cursor.getInt(offset + 21));
        entity.setTJZT(cursor.isNull(offset + 22) ? null : cursor.getInt(offset + 22));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Tasks entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Tasks entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
