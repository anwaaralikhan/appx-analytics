package com.dc.appx.quote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dc.appx.quote.model.EodQuote;
import com.dc.appx.quote.service.QuoteService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Quote Service")
@RequestMapping("/quote/eod")
public class EodQuoteController {
	
	@Autowired
	private QuoteService eodQuoteService;
	
	@GetMapping("/v1/{symbol}")
	public ResponseEntity<?> getEodQuote(@PathVariable String symbol) {
		Optional<EodQuote> quoteValue = eodQuoteService.getEodQuoteFor(symbol);
		return getResponse(symbol, quoteValue);
	}

	@GetMapping("/v1")
	public ResponseEntity<?> getIntradayQuote() {
		List<EodQuote> quotes = eodQuoteService.getEodQuotes();
		return ResponseEntity.status(HttpStatus.OK).body(quotes);
	}
	
	private ResponseEntity<?> getResponse(String symbol, Optional<EodQuote> quoteValue) {
		if(quoteValue.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(quoteValue);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Eod quote not available for "+symbol);
		}
	}
}
