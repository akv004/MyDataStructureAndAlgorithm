package my.service.common;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParallelProcessingService<U,R> {
 public Function<U, R> processResource;

    ParallelProcessingService(Function<U, R> processResource) {
        this.processResource = processResource
    }

    List<R> getListOfResultsAsynchronously(List<U> requestOptionsList) {
        List<CompletableFuture<R>> compFut = requestOptionsList
                .stream()
                .map { requestOptions -> return processResourceAsync(requestOptions) }
                .collect(Collectors.toList());

        return compFut.stream()
                .map { compFutureItem -> compFutureItem.join() }
                .filter { res -> res != null }
                .collect(Collectors.toList());
    }

    public CompletableFuture<R> processResourceAsync(U requestOptions) {
        return CompletableFuture.supplyAsync(
                { -> processResource.apply(requestOptions) }
        ).orTimeout(4, TimeUnit.MINUTES);
    }

    List<R> getListOfResultsParallelStream(List<U> requestOptionsList) {
        List<R> compFut = requestOptionsList
                .parallelStream()
                .map { requestOptions -> return processResource.apply(requestOptions) }
                .filter { res -> res != null }
                .collect(Collectors.toList());
        return compFut
    }

    List<R> getListOfResultsAsynchronously(List<U> requestOptionsList, ExecutorService executor) {
        List<CompletableFuture<R>> compFut = requestOptionsList
                .stream()
                .map { requestOptions -> return processResourceAsync(requestOptions, executor) }
                .collect(Collectors.toList());

        return compFut.stream()
                .map { compFutureItem -> compFutureItem.join() }
                .filter { res -> res != null }
                .collect(Collectors.toList());
    }

    public CompletableFuture<R> processResourceAsync(U requestOptions, ExecutorService executor) {
        return CompletableFuture.supplyAsync(
                { -> processResource.apply(requestOptions) },
                executor
        ).orTimeout(4, TimeUnit.MINUTES);
    }
}
