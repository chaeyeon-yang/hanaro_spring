package com.hana.app.service;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.AddrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  AddrService implements HanaService<Integer, AddrDto> {
    final AddrRepository addrRepository;

    @Override
    public int add(AddrDto addrDto) throws Exception {
        return addrRepository.insert(addrDto);
    }

    @Override
    public int del(Integer id) throws Exception {
        return addrRepository.delete(id);
    }

    @Override
    public int modify(AddrDto addrDto) throws Exception {
        return addrRepository.update(addrDto);
    }

    @Override
    public AddrDto get(Integer id) throws Exception {
        return addrRepository.selectOne(id);
    }

    @Override
    public List<AddrDto> get() throws Exception {
        return addrRepository.select();
    }

    // 내 주소 id 리스트 받기
    public List<AddrDto> getAddr(String id) throws Exception {
        return addrRepository.selectAddr(id);
    }
}
