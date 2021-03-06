package com.fbs.currrencyConverter.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExchangeRateService(
        private val restTemplate: RestTemplate,
        @Value("\${url.api.exchange.rates}") private val url: String ) {

    fun fetchRates(): HashMap<String, Double>? {
        var ratesMap = restTemplate.getForObject(url, HashMap<String, Double>()::class.java)
        //ratesMap!!["USD"] = (1).toDouble()
        return ratesMap
    }
}