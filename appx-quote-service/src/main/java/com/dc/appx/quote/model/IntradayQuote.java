package com.dc.appx.quote.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="QUOTE_INTRADAY")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class IntradayQuote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SYMBOL")
	@JsonProperty("symbol")
	private String symbol;
	
	@Column(name="PRICE")
	@JsonProperty("price")
	private String price;
}
