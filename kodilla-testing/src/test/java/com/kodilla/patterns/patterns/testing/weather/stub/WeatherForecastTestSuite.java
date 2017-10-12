package com.kodilla.patterns.patterns.testing.weather.stub;

import org.junit.Assert;
import org.junit.Test;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub() {
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        int quantityOfSensor = weatherForecast.calculateForecast().size();

        Assert.assertEquals(5, quantityOfSensor);
    }
}
