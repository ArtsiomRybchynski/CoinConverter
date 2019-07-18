package com.example.testproject.database.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.testproject.entity.coin.Coin;

import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public final class CoinDao_Impl extends CoinDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCoin;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCoin;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCoins;

  public CoinDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCoin = new EntityInsertionAdapter<Coin>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `coins`(`price`,`isNotShown`,`id`,`imageUrl`,`name`,`fullName`,`algorithm`) VALUES (?,?,nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Coin value) {
        if (value.getPrice() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPrice());
        }
        final int _tmp;
        _tmp = value.isNotShown() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        stmt.bindLong(3, value.getId());
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFullName());
        }
        if (value.getAlgorithm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAlgorithm());
        }
      }
    };
    this.__updateAdapterOfCoin = new EntityDeletionOrUpdateAdapter<Coin>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `coins` SET `price` = ?,`isNotShown` = ?,`id` = ?,`imageUrl` = ?,`name` = ?,`fullName` = ?,`algorithm` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Coin value) {
        if (value.getPrice() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPrice());
        }
        final int _tmp;
        _tmp = value.isNotShown() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        stmt.bindLong(3, value.getId());
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFullName());
        }
        if (value.getAlgorithm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAlgorithm());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllCoins = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM coins";
        return _query;
      }
    };
  }

  @Override
  public void insertCoins(final List<Coin> coins) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCoin.insert(coins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCoins(final List<Coin> coins) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCoin.handleMultiple(coins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCoinTable(final List<Coin> coins) {
    __db.beginTransaction();
    try {
      super.updateCoinTable(coins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllCoins() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCoins.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllCoins.release(_stmt);
    }
  }

  @Override
  public Single<List<Coin>> getAllCoins() {
    final String _sql = "SELECT * FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<Coin>>() {
      @Override
      public List<Coin> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfPrice = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfIsNotShown = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "isNotShown");
          final int _cursorIndexOfId = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfFullName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfAlgorithm = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "algorithm");
          final java.util.List<Coin> _result = new java.util.ArrayList<Coin>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Coin _item;
            _item = new Coin();
            final java.lang.String _tmpPrice;
            _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            _item.setPrice(_tmpPrice);
            final boolean _tmpIsNotShown;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNotShown);
            _tmpIsNotShown = _tmp != 0;
            _item.setNotShown(_tmpIsNotShown);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final java.lang.String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _item.setImageUrl(_tmpImageUrl);
            final java.lang.String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final java.lang.String _tmpFullName;
            _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            _item.setFullName(_tmpFullName);
            final java.lang.String _tmpAlgorithm;
            _tmpAlgorithm = _cursor.getString(_cursorIndexOfAlgorithm);
            _item.setAlgorithm(_tmpAlgorithm);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<Coin> getCoinById(final int id) {
    final String _sql = "SELECT * FROM coins WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return Single.fromCallable(new Callable<Coin>() {
      @Override
      public Coin call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfPrice = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfIsNotShown = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "isNotShown");
          final int _cursorIndexOfId = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfFullName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfAlgorithm = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "algorithm");
          final Coin _result;
          if(_cursor.moveToFirst()) {
            _result = new Coin();
            final java.lang.String _tmpPrice;
            _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            _result.setPrice(_tmpPrice);
            final boolean _tmpIsNotShown;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNotShown);
            _tmpIsNotShown = _tmp != 0;
            _result.setNotShown(_tmpIsNotShown);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
            final java.lang.String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _result.setImageUrl(_tmpImageUrl);
            final java.lang.String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final java.lang.String _tmpFullName;
            _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            _result.setFullName(_tmpFullName);
            final java.lang.String _tmpAlgorithm;
            _tmpAlgorithm = _cursor.getString(_cursorIndexOfAlgorithm);
            _result.setAlgorithm(_tmpAlgorithm);
          } else {
            _result = null;
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<Coin>> getFilterCoins() {
    final String _sql = "SELECT * FROM coins WHERE isNotShown = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<Coin>>() {
      @Override
      public List<Coin> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfPrice = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfIsNotShown = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "isNotShown");
          final int _cursorIndexOfId = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfFullName = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfAlgorithm = androidx.room.util.CursorUtil.getColumnIndexOrThrow(_cursor, "algorithm");
          final java.util.List<Coin> _result = new java.util.ArrayList<Coin>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Coin _item;
            _item = new Coin();
            final java.lang.String _tmpPrice;
            _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            _item.setPrice(_tmpPrice);
            final boolean _tmpIsNotShown;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNotShown);
            _tmpIsNotShown = _tmp != 0;
            _item.setNotShown(_tmpIsNotShown);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final java.lang.String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _item.setImageUrl(_tmpImageUrl);
            final java.lang.String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final java.lang.String _tmpFullName;
            _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            _item.setFullName(_tmpFullName);
            final java.lang.String _tmpAlgorithm;
            _tmpAlgorithm = _cursor.getString(_cursorIndexOfAlgorithm);
            _item.setAlgorithm(_tmpAlgorithm);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
