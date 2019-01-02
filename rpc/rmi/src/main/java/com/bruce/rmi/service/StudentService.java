package com.bruce.rmi.service;

import com.bruce.rmi.entity.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {
    List<Student> getList() throws RemoteException;

    String val(String a,int b,Student student) throws RemoteException;
}
