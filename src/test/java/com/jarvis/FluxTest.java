package com.jarvis;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {

  @Test
  void firstFlux() {
    Flux.just("A", "B", "C")
      .log().subscribe();
  }
  
  @Test
  void fluxFromIterable() {
    Flux.fromIterable(Arrays.asList("A", "B", "C"))
      .log().subscribe();
  }
  
  @Test
  void fluxFromRange() {
    Flux.range(10, 5)
      .log().subscribe();
  }
  
  @Test
  void fluxFromInterval() throws Exception {
    Flux.interval(Duration.ofSeconds(1))
      .log()
      .take(2)
      .subscribe();
    Thread.sleep(5000);
  }
  
  @Test
  void fluxRequest() {
    Flux.range(1, 5).log()
      .subscribe(null, null, null, s -> s.request(3));
  }
  
  @Test
  void fluxLimitRate() {
    Flux.range(1, 5).log()
      .limitRate(3).subscribe();
  }
}









