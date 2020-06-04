package com.dc.appx.quote.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dc.appx.quote.model.EodQuote;

@Repository
public interface EodQuoteRepository extends CrudRepository<EodQuote, String>{

}
