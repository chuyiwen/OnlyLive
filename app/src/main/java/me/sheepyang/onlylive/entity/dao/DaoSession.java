package me.sheepyang.onlylive.entity.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import me.sheepyang.onlylive.entity.Event;
import me.sheepyang.onlylive.entity.EventGoods;
import me.sheepyang.onlylive.entity.Goods;
import me.sheepyang.onlylive.entity.JoinEventGoodsToEvent;
import me.sheepyang.onlylive.entity.JoinPlayerGoodsToPlayer;
import me.sheepyang.onlylive.entity.Number;
import me.sheepyang.onlylive.entity.Player;
import me.sheepyang.onlylive.entity.PlayerGoods;

import me.sheepyang.onlylive.entity.dao.EventDao;
import me.sheepyang.onlylive.entity.dao.EventGoodsDao;
import me.sheepyang.onlylive.entity.dao.GoodsDao;
import me.sheepyang.onlylive.entity.dao.JoinEventGoodsToEventDao;
import me.sheepyang.onlylive.entity.dao.JoinPlayerGoodsToPlayerDao;
import me.sheepyang.onlylive.entity.dao.NumberDao;
import me.sheepyang.onlylive.entity.dao.PlayerDao;
import me.sheepyang.onlylive.entity.dao.PlayerGoodsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig eventDaoConfig;
    private final DaoConfig eventGoodsDaoConfig;
    private final DaoConfig goodsDaoConfig;
    private final DaoConfig joinEventGoodsToEventDaoConfig;
    private final DaoConfig joinPlayerGoodsToPlayerDaoConfig;
    private final DaoConfig numberDaoConfig;
    private final DaoConfig playerDaoConfig;
    private final DaoConfig playerGoodsDaoConfig;

    private final EventDao eventDao;
    private final EventGoodsDao eventGoodsDao;
    private final GoodsDao goodsDao;
    private final JoinEventGoodsToEventDao joinEventGoodsToEventDao;
    private final JoinPlayerGoodsToPlayerDao joinPlayerGoodsToPlayerDao;
    private final NumberDao numberDao;
    private final PlayerDao playerDao;
    private final PlayerGoodsDao playerGoodsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        eventDaoConfig = daoConfigMap.get(EventDao.class).clone();
        eventDaoConfig.initIdentityScope(type);

        eventGoodsDaoConfig = daoConfigMap.get(EventGoodsDao.class).clone();
        eventGoodsDaoConfig.initIdentityScope(type);

        goodsDaoConfig = daoConfigMap.get(GoodsDao.class).clone();
        goodsDaoConfig.initIdentityScope(type);

        joinEventGoodsToEventDaoConfig = daoConfigMap.get(JoinEventGoodsToEventDao.class).clone();
        joinEventGoodsToEventDaoConfig.initIdentityScope(type);

        joinPlayerGoodsToPlayerDaoConfig = daoConfigMap.get(JoinPlayerGoodsToPlayerDao.class).clone();
        joinPlayerGoodsToPlayerDaoConfig.initIdentityScope(type);

        numberDaoConfig = daoConfigMap.get(NumberDao.class).clone();
        numberDaoConfig.initIdentityScope(type);

        playerDaoConfig = daoConfigMap.get(PlayerDao.class).clone();
        playerDaoConfig.initIdentityScope(type);

        playerGoodsDaoConfig = daoConfigMap.get(PlayerGoodsDao.class).clone();
        playerGoodsDaoConfig.initIdentityScope(type);

        eventDao = new EventDao(eventDaoConfig, this);
        eventGoodsDao = new EventGoodsDao(eventGoodsDaoConfig, this);
        goodsDao = new GoodsDao(goodsDaoConfig, this);
        joinEventGoodsToEventDao = new JoinEventGoodsToEventDao(joinEventGoodsToEventDaoConfig, this);
        joinPlayerGoodsToPlayerDao = new JoinPlayerGoodsToPlayerDao(joinPlayerGoodsToPlayerDaoConfig, this);
        numberDao = new NumberDao(numberDaoConfig, this);
        playerDao = new PlayerDao(playerDaoConfig, this);
        playerGoodsDao = new PlayerGoodsDao(playerGoodsDaoConfig, this);

        registerDao(Event.class, eventDao);
        registerDao(EventGoods.class, eventGoodsDao);
        registerDao(Goods.class, goodsDao);
        registerDao(JoinEventGoodsToEvent.class, joinEventGoodsToEventDao);
        registerDao(JoinPlayerGoodsToPlayer.class, joinPlayerGoodsToPlayerDao);
        registerDao(Number.class, numberDao);
        registerDao(Player.class, playerDao);
        registerDao(PlayerGoods.class, playerGoodsDao);
    }
    
    public void clear() {
        eventDaoConfig.getIdentityScope().clear();
        eventGoodsDaoConfig.getIdentityScope().clear();
        goodsDaoConfig.getIdentityScope().clear();
        joinEventGoodsToEventDaoConfig.getIdentityScope().clear();
        joinPlayerGoodsToPlayerDaoConfig.getIdentityScope().clear();
        numberDaoConfig.getIdentityScope().clear();
        playerDaoConfig.getIdentityScope().clear();
        playerGoodsDaoConfig.getIdentityScope().clear();
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public EventGoodsDao getEventGoodsDao() {
        return eventGoodsDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public JoinEventGoodsToEventDao getJoinEventGoodsToEventDao() {
        return joinEventGoodsToEventDao;
    }

    public JoinPlayerGoodsToPlayerDao getJoinPlayerGoodsToPlayerDao() {
        return joinPlayerGoodsToPlayerDao;
    }

    public NumberDao getNumberDao() {
        return numberDao;
    }

    public PlayerDao getPlayerDao() {
        return playerDao;
    }

    public PlayerGoodsDao getPlayerGoodsDao() {
        return playerGoodsDao;
    }

}
