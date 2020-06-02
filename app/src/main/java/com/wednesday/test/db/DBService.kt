package com.wednesday.test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wednesday.test.model.Result

@Dao
interface DBService {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeSearchList(result: List<Result>);

//    @Query(value = "SELECT * FROM SearchItem WHERE ((trackId+artistName+collectionName+trackName+collectionArtistName+collectionCensoredName+trackCensoredName) LIKE '%' || :search || '%') ")
//    suspend fun fetchSearchList(search: String): MutableList<Result>;

    @Query(value = "SELECT * FROM SearchItem WHERE (trackId LIKE '%'|| :search || '%') or (artistName LIKE '%'|| :search || '%') or (collectionName LIKE '%'|| :search || '%') or (trackName LIKE '%'|| :search || '%') or (collectionArtistName LIKE '%'|| :search || '%') or (collectionCensoredName LIKE '%'|| :search || '%') or (trackCensoredName LIKE '%'|| :search || '%') ")
    suspend fun fetchSearchList(search: String): MutableList<Result>;
}