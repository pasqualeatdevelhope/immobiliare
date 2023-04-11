package org.example.controllers.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GetAcquistoListResponse {

	List<GetAcquistoResponse> response;

	public List<GetAcquistoResponse> getResponse() {
		return response;
	}

	public void setResponse(List<GetAcquistoResponse> response) {
		this.response = response;
	}

	public static class GetAcquistoResponse {
		private LocalDateTime date;
		private String address;
		private String venditore;
		private Integer piani;
		private Integer mq;
		private BigDecimal prezzo;

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getVenditore() {
			return venditore;
		}

		public void setVenditore(String venditore) {
			this.venditore = venditore;
		}

		public Integer getPiani() {
			return piani;
		}

		public void setPiani(Integer piani) {
			this.piani = piani;
		}

		public Integer getMq() {
			return mq;
		}

		public void setMq(Integer mq) {
			this.mq = mq;
		}

		public BigDecimal getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(BigDecimal prezzo) {
			this.prezzo = prezzo;
		}

	}

}
