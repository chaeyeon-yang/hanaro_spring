package com.hana.app.service;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Dao;
import com.hana.app.frame.Service;
import com.hana.app.repository.CustDao;

import java.util.List;

public class CustService implements Service<String, CustDto> {

    Dao<String, CustDto> dao;

    // 일반적으로 자바에서 사용하는 방식
    public CustService(){
        dao = new CustDao();
    }


    @Override
    public int add(CustDto custDto) throws DuplicatedIdException {
        System.out.println("Start TR....");
        try {
            dao.insert(custDto);
            System.out.println("COMMIT....");
        }catch(DuplicatedIdException e){
            System.out.println("ROLLBACK....");
            throw e;
        }finally {
            System.out.println("End TR....");
        }

        // SMS ..
        System.out.println("Send SMS ....");
        return 0;
    }

    @Override
    public int del(String s) throws Exception {
        try {
            dao.delete(s);
        } catch (Exception e) {
            System.out.println("ID Not Found ...");
        }


        return 0;
    }

    @Override
    public int modify(CustDto custDto) throws Exception {
        dao.update(custDto);
        return 0;
    }

    @Override
    public CustDto get(String s) throws Exception {
        return dao.select(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return dao.select();
    }


}
