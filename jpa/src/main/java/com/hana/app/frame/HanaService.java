package com.hana.app.frame;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface HanaService<V, K> {
    // 예외에 대해 항상 엄두해둘 것!!!
    @Transactional
    public V insert(V v);
    @Transactional
    public Boolean delete(K k);
    @Transactional
    public V update(V v);
    public Optional<V> get(K k); // null point exception 방지
    public List<V> get();
}
