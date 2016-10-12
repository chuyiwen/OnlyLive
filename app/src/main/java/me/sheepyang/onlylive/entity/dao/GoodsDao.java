package me.sheepyang.onlylive.entity.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import me.sheepyang.onlylive.entity.JoinOwnerToGoods;

import me.sheepyang.onlylive.entity.Goods;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GOODS".
*/
public class GoodsDao extends AbstractDao<Goods, Long> {

    public static final String TABLENAME = "GOODS";

    /**
     * Properties of entity Goods.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Price = new Property(2, int.class, "price", false, "PRICE");
        public final static Property Number = new Property(3, int.class, "number", false, "NUMBER");
    };

    private Query<Goods> player_GoodsListQuery;

    public GoodsDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GOODS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"PRICE\" INTEGER NOT NULL ," + // 2: price
                "\"NUMBER\" INTEGER NOT NULL );"); // 3: number
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GOODS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Goods entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getPrice());
        stmt.bindLong(4, entity.getNumber());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Goods entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getPrice());
        stmt.bindLong(4, entity.getNumber());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Goods readEntity(Cursor cursor, int offset) {
        Goods entity = new Goods( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // price
            cursor.getInt(offset + 3) // number
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Goods entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrice(cursor.getInt(offset + 2));
        entity.setNumber(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Goods entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Goods entity) {
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
    
    /** Internal query to resolve the "goodsList" to-many relationship of Player. */
    public List<Goods> _queryPlayer_GoodsList(long ownerId) {
        synchronized (this) {
            if (player_GoodsListQuery == null) {
                QueryBuilder<Goods> queryBuilder = queryBuilder();
                queryBuilder.join(JoinOwnerToGoods.class, JoinOwnerToGoodsDao.Properties.GoodsId)
                    .where(JoinOwnerToGoodsDao.Properties.OwnerId.eq(ownerId));
                player_GoodsListQuery = queryBuilder.build();
            }
        }
        Query<Goods> query = player_GoodsListQuery.forCurrentThread();
        query.setParameter(0, ownerId);
        return query.list();
    }

}
