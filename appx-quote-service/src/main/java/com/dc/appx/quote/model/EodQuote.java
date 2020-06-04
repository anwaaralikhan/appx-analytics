package com.dc.appx.quote.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name="QUOTE_EOD")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EodQuote implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SYMBOL")
	@JsonProperty("symbol")
	private String symbol;
	
	@Column(name="PRICE")
	@JsonProperty("price")
	private String price;
	
	@Column(name="REGION")
	@JsonProperty("region")
	private String region;
	
	@Column(name="REGION_TIME")
	@JsonProperty("region_time")
	private LocalDateTime region_time;
	
}
