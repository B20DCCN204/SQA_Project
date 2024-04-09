package dbclpm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dbclpm.dto.KhachHangDTO;
import dbclpm.entity.KhachHang;
import dbclpm.entity.Xa;
import dbclpm.repository.HuyenRepo;
import dbclpm.repository.KhachHangRepo;
import dbclpm.repository.XaRepo;
import dbclpm.ultilities.tien_dien.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dbclpm.entity.LuongDienTieuThu;
import dbclpm.repository.LuongDienTieuThuRepo;
import dbclpm.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{

	@Autowired
	private LuongDienTieuThuRepo ldttRe;
	@Autowired
	private KhachHangRepo khachHangRepo;
	@Autowired
	private XaRepo xaRepo;
	@Autowired
	private HuyenRepo huyenRepo;
	@Autowired
	private ObjectUtil objectUtil;

	public KhachHangServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<KhachHang> getAllKhachHang() {
		return khachHangRepo.findAll();
	}

	@Override
	public List<LuongDienTieuThu> getListKhPayment() {
		
        List<LuongDienTieuThu> ob = ldttRe.getKhachHangctt();
        
        
		return ob;
	}

	@Override
	public List<KhachHang> findByXaOrHuyenOrTinh(Map<String, Object> params) {
		Object xaId = params.get("xaId");
		Object huyenId = params.get("huyenId");
		Object tinhId = params.get("tinhId");

		if(objectUtil.checkObject(xaId)){
			List<KhachHang> khachHangs = khachHangRepo.findByXaId(Long.valueOf(xaId.toString()));
			return khachHangs;
		}else if(objectUtil.checkObject(huyenId)){
//			List<KhachHang> result = new ArrayList<>();
//			List<Xa> xas = xaRepo.findByHuyenId((Long) huyenId);
//			for(Xa xa : xas){
//				List<KhachHang> khs = khachHangRepo.findKhachHangsByXaId(xa.getId());
//				result.addAll(khs);
//			}
//			return result;
			List<KhachHang> khachHangs = khachHangRepo.findByHuyenId(Long.valueOf(huyenId.toString()));
			return khachHangs;
		}else if(objectUtil.checkObject(tinhId)){
			List<KhachHang> khachHangs = khachHangRepo.findByTinhId(Long.valueOf(tinhId.toString()));
			return khachHangs;
		}
		return null;
	}


}
