package services;

import java.util.List;
import models.Villa;
import repositories.VillaRepository;

public class VillaService {
    private VillaRepository villaRepo = new VillaRepository();

    public List<Villa> getAllVillas() {
        return villaRepo.getAllVillas();
    }

    public Villa getVillaById(int id) {
        return villaRepo.getVillaById(id);
    }

    public List<Villa> getAvailableVillas(String checkinDate, String checkoutDate) {
        return villaRepo.getAvailableVillas(checkinDate, checkoutDate);
    }

    public boolean createVilla(Villa villa) {
    return villaRepo.insertVilla(villa);
    }


}
