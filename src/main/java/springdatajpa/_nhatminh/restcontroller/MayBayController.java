package springdatajpa._nhatminh.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springdatajpa._nhatminh.entity.ChuyenBay;
import springdatajpa._nhatminh.entity.MayBay;
import springdatajpa._nhatminh.repository.ChuyenbayRepository;
import springdatajpa._nhatminh.repository.MayBayRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class MayBayController {
    @Autowired
    private MayBayRepository mayBays;

    @GetMapping("/cau2")
    public List<MayBay>  cau2() {
        return  mayBays.findMayBayTamBayHon10000() ;
    }
    @GetMapping("/cau7")
    public int  cau7() {
        return  mayBays.findSoMayBayBoeing() ;
    }
    @GetMapping("/cau11")
    public List<String> cau11() {
        return  mayBays.maMayBayNhanVienHoNGUYENLAI();
    }
    @GetMapping("/cau13")
    public List<String> cau13() {
        return  mayBays.maMayBayThucHienDuongBayVn280();
    }
    @GetMapping("/cau16")
    public List <HashMap<String, Object>> cau16() {
        List<Object[]> listObject= mayBays.findvoiMoiLoaimaybayChoBietMaSoAndLoaiAndSoPhiCongCoTheLai();
        List <HashMap<String,Object>> giaTriReturn =new ArrayList<>();
        for (Object[] obj : listObject){
            HashMap<String,Object> tempMap =new HashMap<>();
            tempMap.put("Mã số máy bay :",obj[0]);
            tempMap.put("Loại máy bay :",obj[1]);
            tempMap.put("Tổng số phi công lái được :",obj[2]);
            giaTriReturn.add(tempMap);
        }
        return giaTriReturn;
    }
}
