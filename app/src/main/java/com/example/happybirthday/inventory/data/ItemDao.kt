package com.example.happybirthday.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    // Using Flow or LiveData as return type will ensure you get notified whenever the data in the database changes.
    // It is recommended to use Flow in the persistence layer. The Room keeps this Flow updated for you, which means you only need to explicitly get the data once.
    // You don't need to explicitly make it a suspend function and call inside a coroutine scope.
    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}