package springdatajpa._nhatminh.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springdatajpa._nhatminh.entity.ChuyenBay;
import springdatajpa._nhatminh.repository.ChuyenbayRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ChuyenBayController {
    @Autowired
    private ChuyenbayRepository chuyenbayRepository;

    @GetMapping("/cau1")
    public List<ChuyenBay> cau1() {
        return chuyenbayRepository.findChuyenBayDiDaLat("DAD");
    }
    @GetMapping("/cau4")
    public List<ChuyenBay> cau4() {
        return chuyenbayRepository.findChuyenBayDoDaiHon8000andNhoHon10000();
    }
    @GetMapping("/cau5")
    public List<ChuyenBay> cau5() {
        return chuyenbayRepository.findChuyenBayCau5("SGN","BMV");
    }
    @GetMapping("/cau6")
    public int cau6() {
        return chuyenbayRepository.sochuyenBayXuatPhatSaiGon("SGN");
    }
    @GetMapping("/cau14")
    public List<String> cau14() {
        return chuyenbayRepository.chuyenbaythuchienByAirbusA320();
    }
    @GetMapping("/cau17")
    public List<ChuyenBay> cau17() {
        return chuyenbayRepository.chuyenbayADenBVaQuayVeA();
    }
    @GetMapping("/cau18")
    public List <HashMap<String, Object>> cau18() {
        List<Object[]> listObject= chuyenbayRepository.sochuyenbayxuatphatTheoTungGA();
        List <HashMap<String,Object>> giaTriReturn =new ArrayList<>();
        for (Object[] obj : listObject){
            HashMap<String,Object> tempMap =new HashMap<>();
            tempMap.put("Ga xuất phát :",obj[0]);
            tempMap.put("Số chuyến bay :",obj[1]);
            giaTriReturn.add(tempMap);
        }
        return giaTriReturn;
    }
    @GetMapping("/cau19")
    public List <HashMap<String, Object>> cau19() {
        List<Object[]> listObject= chuyenbayRepository.tongchiphiphaitraPhiCongCuaTungChuyenBay();
        List <HashMap<String,Object>> giaTriReturn =new ArrayList<>();
        for (Object[] obj : listObject){
            HashMap<String,Object> tempMap =new HashMap<>();
            tempMap.put("Ga xuất phát :",obj[0]);
            tempMap.put("Tổng chi phí phải trả :",obj[1]);
            giaTriReturn.add(tempMap);
        }
        return giaTriReturn;
    }
    @GetMapping("/cau20")
    public List<String> cau20() {
        return chuyenbayRepository.danhsachChuyenBayKhoiHanhTruoc12h();
    }
    @GetMapping("/cau21")
    public List <HashMap<String, Object>> cau21() {
        List<Object[]> listObject= chuyenbayRepository.cau21();
        List <HashMap<String,Object>> giaTriReturn =new ArrayList<>();
        for (Object[] obj : listObject){
            HashMap<String,Object> tempMap =new HashMap<>();
            tempMap.put("Ga xuất phát :",obj[0]);
            tempMap.put("số lượng chuyến bay khởi hành trước 12h:",obj[1]);
            giaTriReturn.add(tempMap);
        }
        return giaTriReturn;
    }
    @GetMapping("/cau28")
    public List<ChuyenBay> cau28() {
        return chuyenbayRepository.cau28();
    }
}
