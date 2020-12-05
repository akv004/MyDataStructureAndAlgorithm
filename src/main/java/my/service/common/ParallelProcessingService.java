package my.service.common;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParallelProcessingService<U,R> {
public Function<U, R> processingResource;

ParallelProcessingService(Function<U,R> processingResource){
    this.processingResource = processingResource;
}

List<R> getListOfResultsAsynchronously(List<U> requestOptionList){
    List<ComparableFuture<R>> compFut = requestOptionList
            .stream()
            .map(requestOptions -> processResourceAsynch(requestOptionList))
            .collect(Collectors.toList());
    return compFut.stream()
            .map(compFutureItem -> compFutureItem.join())
            .collec(Collectors.toList());
}

public CompletableFuture<R> processResourceAsynch(U requestOptions){
    return CompletableFuture.supplyAsync({ -> processingResource.apply(requestOptions)})
            .orTimeout(4, TimeUnit.MINUTES);
}

}
