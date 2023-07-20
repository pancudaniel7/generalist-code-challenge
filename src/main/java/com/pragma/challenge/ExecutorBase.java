package com.pragma.challenge;

import java.util.concurrent.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

import com.pragma.challenge.service.impl.*;

import jakarta.annotation.*;

@Component
public class ExecutorBase {
  
  private final ScheduledExecutorService taskExecutor = Executors.newSingleThreadScheduledExecutor();
  @Autowired
  private ApplicationContext applicationContext;

  @EventListener(ApplicationReadyEvent.class)
  public void atStartup() {
    ParallelRatingsService parallelRatingsService = applicationContext.getBean(ParallelRatingsService.class);
    long period = 5000L;
    taskExecutor.scheduleAtFixedRate(parallelRatingsService, 0, period, TimeUnit.MILLISECONDS);
  }
  
  @PreDestroy
  public void destroy() {
    taskExecutor.shutdown();
  }
}