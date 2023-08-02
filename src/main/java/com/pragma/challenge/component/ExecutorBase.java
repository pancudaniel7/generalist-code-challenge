package com.pragma.challenge.component;

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
  private static final long PERIOD=5000L;
  
  private final ScheduledExecutorService taskExecutor = Executors.newSingleThreadScheduledExecutor();
  @Autowired
  private ParallelRatingsService parallelRatingsService;

  @EventListener(ApplicationReadyEvent.class)
  public void atStartup() {
    taskExecutor.scheduleAtFixedRate(parallelRatingsService, 0, PERIOD, TimeUnit.MILLISECONDS);
  }
  
  @PreDestroy
  public void destroy() {
    taskExecutor.shutdown();
  }
}