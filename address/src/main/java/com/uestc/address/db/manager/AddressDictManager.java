package com.uestc.address.db.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uestc.address.bean.Address;
import com.uestc.address.db.AssetsDatabaseManager;
import com.uestc.address.db.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghaojie on 2016/10/19.
 * 对地址库的增删改查
 */

public class AddressDictManager {
    private static final String TAG = "AddressDictManager";
    private SQLiteDatabase db;
    public AddressDictManager(Context context){

        // 初始化，只需要调用一次
        AssetsDatabaseManager.initManager(context);
        // 获取管理对象，因为数据库需要通过管理对象才能够获取
        AssetsDatabaseManager mg = AssetsDatabaseManager.getManager();
        // 通过管理对象获取数据库
        db = mg.getDatabase("address.db");
    }

    /**
     * 增加一个地址
     * @param adress
     */
    public void inserddress(Address adress){
        if(adress !=null){
            db.beginTransaction();//手动设置开启事务
            try{
                ContentValues values = new ContentValues();
                db.insert(TableField.TABLE_NAME,null,values);
                db.setTransactionSuccessful(); //设置事务处理成功
            }catch (Exception e){
            }finally {
                db.endTransaction(); //事务终止
            }
        }
    }
    /**
     * 增加地址集合
     * @param list
     */
    public void insertAddress(List<Address> list){
        if(list !=null){
            db.beginTransaction();//手动设置开启事务
            try{
                for (Address adress:list) {
                    ContentValues values = new ContentValues();
                    db.insert(TableField.TABLE_NAME,null,values);
                }
                db.setTransactionSuccessful(); //设置事务处理成功
            }catch (Exception e){
            }finally {
                db.endTransaction(); //事务终止
            }
        }
    }
    //更新地址
    public void updateAddressInfo(Address adress){
        if(adress !=null){
            db.beginTransaction();//手动设置开启事务
            try{
                ContentValues values = new ContentValues();
//                values.put(ADDRESS_DICT_FIELD_CODE,adress.code);
//                values.put(TableField.ADDRESS_DICT_FIELD_NAME,adress.name);
//                values.put(ADDRESS_DICT_FIELD_PARENTID,adress.parentId);
//                values.put(TableField.ADDRESS_DICT_FIELD_ID,adress.id);
//                String[] args = {String.valueOf(adress.id)};
//                db.update(TableField.TABLE_NAME,values,TableField.FIELD_ID+ "=?",args);
                db.setTransactionSuccessful(); //设置事务处理成功
            }catch (Exception e){
            }finally {
                db.endTransaction(); //事务终止
            }
        }
    }

    /**
     * 查找 地址 数据
     * @return
     */
    public List<Address> getAddressList(){
        List<Address> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+ TableField.TABLE_NAME+" order by sort asc", null);
        while (cursor.moveToNext()){
//            Address adressInfo =  new Address();
//            adressInfo.id = cursor.getInt(cursor.getColumnIndex(TableField.FIELD_ID));
//            adressInfo.parentId = cursor.getInt(cursor.getColumnIndex(ADDRESS_DICT_FIELD_PARENTID));
//            adressInfo.code = cursor.getString(cursor.getColumnIndex(ADDRESS_DICT_FIELD_CODE));
//            adressInfo.name = cursor.getString(cursor.getColumnIndex(TableField.ADDRESS_DICT_FIELD_NAME));
//            list.add(adressInfo);
        }
        cursor.close();
        return list;
    }

    /**
     * 获取省份列表
     * @return
     */
    public List<Address> getProvinceList(){
        List<Address> provinceList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TableField.TABLE_NAME+" where "+ TableField.PID+"=?", new String[]{String.valueOf(100000)});
        while (cursor.moveToNext()){
            Address province =  new Address();
            constructAddress(province, cursor);
            provinceList.add(province);
        }
        cursor.close();

        return provinceList;
    }

    /**
     * 获取省份对应的城市列表
     * @return
     */
    public List<Address> getCityList(String addressId){
        List<Address> cityList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TableField.TABLE_NAME+" where "+ TableField.PID+"=?", new String[]{String.valueOf(addressId)});
        while (cursor.moveToNext()){
            Address city =  new Address();
            constructAddress(city, cursor);
            cityList.add(city);
        }
        cursor.close();
        return cityList;
    }

    /**
     * 获取地址
     * @return
     * @param addressId
     */
    public String getAddress(String addressId){
        Cursor cursor = db.rawQuery("select * from " + TableField.TABLE_NAME+" where "+ TableField.ID+"=?", new String[]{addressId});
        if(cursor!=null && cursor.moveToFirst()){
            Address address =  new Address();
            constructAddress(address, cursor);
            cursor.close();
            return address.name;
        }else{
            return "";
        }
    }
    /**
     * 获取地址
     * @return
     * @param addressId
     */
    public Address getAddressBean(String addressId){
        Cursor cursor = db.rawQuery("select * from " + TableField.TABLE_NAME+" where "+ TableField.ID+"=?", new String[]{addressId});
        if(cursor!=null && cursor.moveToFirst()){
            Address address =  new Address();
            constructAddress(address, cursor);
            cursor.close();
            return address;
        }else{
            return null;
        }
    }

    /**
     * 查找消息临时列表中是否存在这一条记录
     * @param bannerInfo banner数据
     * @return
     */
    public int isExist(Address bannerInfo){
        int count = 0;
        Cursor cursor = db.rawQuery("select count(*) from " + TableField.TABLE_NAME+" where "+TableField.ID+"=?", new String[]{String.valueOf(bannerInfo.id)});
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }

    private void constructAddress(Address address, Cursor cursor) {
        address.id = cursor.getString(cursor.getColumnIndex(TableField.ID));
        address.name = cursor.getString(cursor.getColumnIndex(TableField.NAME));
        address.pId = cursor.getString(cursor.getColumnIndex(TableField.PID));
        address.shortName = cursor.getString(cursor.getColumnIndex(TableField.SHORT_NAME));
        address.level = cursor.getString(cursor.getColumnIndex(TableField.LEVEL));
        address.cityCode = cursor.getString(cursor.getColumnIndex(TableField.CITY_CODE));
        address.zipCode = cursor.getString(cursor.getColumnIndex(TableField.ZIP_CODE));
        address.mergerName = cursor.getString(cursor.getColumnIndex(TableField.MERGER_NAME));
        address.lng = cursor.getString(cursor.getColumnIndex(TableField.LNG));
        address.lat = cursor.getString(cursor.getColumnIndex(TableField.LAT));
        address.pinyin = cursor.getString(cursor.getColumnIndex(TableField.PINYIN));
        address.firstChar = cursor.getString(cursor.getColumnIndex(TableField.FIRST_CHAR));
        address.shortHand = cursor.getString(cursor.getColumnIndex(TableField.SHORT_HAND));
        address.createBy = cursor.getString(cursor.getColumnIndex(TableField.CREATE_BY));
        address.createDate = cursor.getString(cursor.getColumnIndex(TableField.CREATE_DATE));
        address.updateBy = cursor.getString(cursor.getColumnIndex(TableField.UPDATE_BY));
        address.updateDate = cursor.getString(cursor.getColumnIndex(TableField.UPDATE_DATE));
        address.delFlag = cursor.getString(cursor.getColumnIndex(TableField.DEL_FLAG));
    }

}
