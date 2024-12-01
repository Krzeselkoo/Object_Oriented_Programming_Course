package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> threads;
    private final ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
        this.threads = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void runSync(){
        for(Simulation simulation: simulations){
            simulation.run();
        }
    }

    public void runAsync(){
        for(Simulation simulation: simulations){
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void runAsyncInThreadPool(){
        for(Simulation simulation: simulations){
            executorService.submit(simulation);
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }

}
