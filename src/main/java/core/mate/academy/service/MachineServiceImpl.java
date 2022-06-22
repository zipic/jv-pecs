package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        BulldozerProducer bulldozerProducer = new BulldozerProducer();
        ExcavatorProducer excavatorProducer = new ExcavatorProducer();
        TruckProducer truckProducer = new TruckProducer();
        if (type == Bulldozer.class) {
            return new ArrayList<>(bulldozerProducer.get());
        }
        if (type == Excavator.class) {
            return new ArrayList<>(excavatorProducer.get());
        }
        if (type == Truck.class) {
            return new ArrayList<>(truckProducer.get());
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
