package com.binaryphoenixstudios.maas.dao;

import com.binaryphoenixstudios.maas.bean.TokenSourceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TokenSourceTypeDAO extends CrudRepository<TokenSourceType, Long>
{
	List<TokenSourceType> findAll();

	TokenSourceType findByName(String name);
}
