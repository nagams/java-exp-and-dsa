package com.dipendit.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExamples {
    public static void main(String[] args) {

        //Handling error or success from CompletableFuture aysnc calls

        //Case #1: Use handle for both result and exception handling
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) throw new RuntimeException("Something went wrong!");
            return "Success";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Error occurred: " + ex.getMessage());
                return "Default Value";
            } else {
                return result;
            }
        });

        System.out.println(future.join());

        //Case #2: Use exceptionally() for Exception Handling
        CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Failed");
        }).exceptionally(ex -> {
            System.out.println("Handled exception: " + ex.getMessage());
            return "Fallback Value";
        });
        System.out.println(future1.join());

        //Case #3: Use whenComplete() for Side-Effect Handling
        // Useful when you need to perform a side effect regardless of success or failure. Does not modify result
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) throw new RuntimeException("Error!");
            return "Hello";
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error happened: " + ex.getMessage());
            } else {
                System.out.println("Result: " + result);
            }
        });

        //Case #4: Use completeExceptionally() for Explicit Failure
        //Useful when wrapping non-future based APIs
        CompletableFuture<String> future3 = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                throw new RuntimeException("Something had happened");
            } catch (Exception e) {
                future3.completeExceptionally(e);
            }
        }).start();

        future3.exceptionally(ex -> {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }).join();

        //Case #5: Combine with thenApply() or thenCompose() for Chaining
        // combine exception handing with chaining, Keeps error handling localized. Supports chaining without disrupting the pipeline
        CompletableFuture.supplyAsync(() -> {
           return 10 / 0; //throws ArithmeticException
        })
          .thenApply(result -> result * 2)
          .exceptionally(ex -> {
               System.out.println("Handled exception: " + ex.getMessage());
               return 0;
          })
          .thenAccept(System.out::println);

        //Case #6: thenCompose example. Used to flatten two CompletableFutures
        // Ideal for dependent asynchronous calls
        CompletableFuture<String> future4 = getUser()
                .thenCompose(CompletableFutureExamples::getOrders)
                .thenApply(orders -> "Orders fetched: " + orders)
                .exceptionally(ex -> "Error: " + ex.getMessage());
        // Blocking call to get the result for demonstration
        System.out.println(future4.join());

    }

    // Simulate fetching user data (Async)
    public static CompletableFuture<String> getUser() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user...");
            mySleep(1);
            return "User123";
        });
    }

    // Simulate fetching orders for the user (Async)
    public static CompletableFuture<String> getOrders(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching orders for user: " + userId);
            mySleep(1);
            return "Order1, Order2, Order3";
        });
    }

    private static void mySleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
