package agh.ics.oop.model;

import agh.ics.oop.Simulation;

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

    public void runAsync(){
        for(Simulation simulation: simulations){
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
//        for(Thread thread: threads){
//            thread.join();
//        }

//        executorService.shutdown();

        if(!executorService.awaitTermination(2, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        }
    }

    public void runAsyncInThreadPool(){
        for(Simulation simulation: simulations){
            executorService.execute(simulation);
        }
    }

}
