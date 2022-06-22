package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Entities.ListsEntity
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Mappers.ListsEntityMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket.ListSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.ListsRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import io.socket.client.Socket

class ListsRepositoryImpl(private val listsDao: ListsDao): ListsRepository
{
    private lateinit var listSocket: ListSocket
    private val listEntityMapper = ListsEntityMapper()

    override fun addLocalLists(dataLists: ArrayList<DataList?>?)
    {
        val listEntities: ArrayList<ListsEntity?>? = ArrayList()
        if (dataLists != null)
        {
            for(i in dataLists)
            {listEntities?.add(listEntityMapper.mapFromTToK(i))}
            listsDao.insertAllLists(listEntities)
        }
    }

    override fun getLocalLists(): ArrayList<DataList?>?
    {
        val lists: ArrayList<DataList?>? = ArrayList()
        if(listsDao.getAllLists() != null)
        {
            for (i in listsDao.getAllLists()!!)
            {lists?.add(listEntityMapper.mapFromKTOT(i))}
        }
        return lists
    }

    override fun addLocalList(dataList: DataList?)
    {
        listsDao.insertList(listEntityMapper.mapFromTToK(dataList))
    }

    override fun updateLocalList(dataList: DataList?)
    {
        listsDao.updateList(listEntityMapper.mapFromTToK(dataList))
    }

    override fun deleteLocalList(dataList: DataList?)
    {
        listsDao.deleteList(listEntityMapper.mapFromTToK(dataList))
    }

    override fun getLocalList(dataList: DataList?): DataList?
    {
        val listId: String? = dataList?.id
        return listEntityMapper.mapFromKTOT(listsDao.getList(listId))
    }

    //Socket's Methods

    override fun socketInit(mSocket: Socket)
    {
        listSocket = ListSocket(mSocket)
    }

    override fun addList(name: String)
    {
        listSocket.addList(name)
    }

    override fun updateList(id: String,newName: String)
    {
        listSocket.updateList(id, newName)
    }

    override fun deleteList(id: String)
    {
        listSocket.deleteList(id)
    }

    override fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        listSocket.getList(listSocketCallbackInterface)
    }

}