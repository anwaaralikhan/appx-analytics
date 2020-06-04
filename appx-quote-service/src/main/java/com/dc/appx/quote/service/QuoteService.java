package com.dc.appx.quote.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.appx.quote.model.EodQuote;
import com.dc.appx.quote.model.IntradayQuote;
import com.dc.appx.quote.repository.EodQuoteRepository;
import com.dc.appx.quote.repository.IntradayQuoteRepository;

@Service
public class QuoteService {
	private static final Logger LOG = LoggerFactory.getLogger(QuoteService.class.getSimpleName());

	@Autowired
	private EodQuoteRepository eodRepository;
	
	@Autowired
	private IntradayQuoteRepository intradayRepository;
	

	public Optional<IntradayQuote> getIntradayQuoteFor(String symbol) {
		return this.intradayRepository.findById(symbol);
	}

	public Optional<EodQuote> getEodQuoteFor(String symbol) {
		return this.eodRepository.findById(symbol);
	}

	public List<EodQuote> getEodQuotes() {
		List<EodQuote> result = new ArrayList<>();
		eodRepository.findAll().forEach(result::add);
		LOG.info("Eod count -> {}" , result.size());
		return result;
	}

	public List<IntradayQuote> getIntradayQuotes() {
		List<IntradayQuote> result = new ArrayList<>();
		intradayRepository.findAll().forEach(result::add);
		LOG.info("Intraday count -> {}" , result.size());
		return result;
	}

}
