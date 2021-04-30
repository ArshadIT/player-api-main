package com.bestseller.codingchallenge.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class AsyncUtil {
  private AsyncUtil() {
  }

  private static final Executor rootExecutor = Executors.newCachedThreadPool();

  public static <T> CompletableFuture<T> execute(Supplier<T> supplier) {
    return CompletableFuture.supplyAsync(supplier, rootExecutor);
  }
}
