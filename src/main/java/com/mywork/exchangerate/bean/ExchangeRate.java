package com.mywork.exchangerate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate implements Serializable {

	private static final long serialVersionUID = 6953551518006379195L;

	@Column(name = "exchange_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int exchange_rate_id;
	@Column(name = "country_code")
	private @NonNull String country_code;
	@Column(name = "exchange_rate")
	private @NonNull Double exchange_rate;
	@Column(name = "date")
	private @NonNull Date exchange_rate_date;
	@Column(name = "base_country_code")
	private @NonNull String base_country_code;

	public ExchangeRate(@NonNull String country_code, @NonNull Double exchange_rate, @NonNull Date exchange_rate_date,
			@NonNull String base_country_code) {
		super();
		this.country_code = country_code;
		this.exchange_rate = exchange_rate;
		this.exchange_rate_date = exchange_rate_date;
		this.base_country_code = base_country_code;
	}
}
