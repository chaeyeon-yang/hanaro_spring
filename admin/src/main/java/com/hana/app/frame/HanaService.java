package com.hana.app.frame;


import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;

public interface HanaService<K, V> {
    @Transactional(rollbackFor = FileNotFoundException.class)
    int add(V v) throws Exception;
    @Transactional(rollbackFor = FileNotFoundException.class)
    int del(K k) throws Exception;
    @Transactional(rollbackFor = FileNotFoundException.class)
    int modify(V v) throws Exception;
    V get(K k) throws Exception;
    List<V> get() throws Exception;
}
