package com.endryha.aws;

import com.martensigwart.fakeload.FakeLoad;
import com.martensigwart.fakeload.FakeLoadExecutor;
import com.martensigwart.fakeload.FakeLoads;
import com.martensigwart.fakeload.MemoryUnit;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class LoadController {
    private final FakeLoadExecutor fakeLoadExecutor;

    public LoadController(FakeLoadExecutor fakeLoadExecutor) {
        this.fakeLoadExecutor = fakeLoadExecutor;
    }

    @PutMapping("/load")
    public void setLoad(@RequestParam("cpu") int cpu,
                        @RequestParam("memory") int memory,
                        @RequestParam("duration") int duration) {
        FakeLoad fakeload = FakeLoads.create()
                .lasting(duration, TimeUnit.SECONDS)
                .withCpu(cpu)
                .withMemory(memory, MemoryUnit.MB);
        fakeLoadExecutor.executeAsync(fakeload);
    }
}
