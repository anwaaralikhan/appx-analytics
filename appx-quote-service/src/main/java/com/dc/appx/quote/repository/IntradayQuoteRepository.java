package com.dc.appx.quote.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dc.appx.quote.model.IntradayQuote;

@Repository
public interface IntradayQuoteRepository extends CrudRepository<IntradayQuote, String>{

}
