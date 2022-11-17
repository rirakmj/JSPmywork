package com.addr.model;

import java.util.ArrayList;

public interface SAddrDAO {
	// 추가
	public void addrInsert(AddrDTO addr);
	
	// 전체보기 (검색 아님)
	public ArrayList<AddrDTO> addrList();
	
	// 개수 (검색 아님)
	public int addrCount(); 
	
	// 상세보기 
	public AddrDTO addrDetail(int num);
	
	// 수정 
	public void addrUpdate(AddrDTO addr); // return값 있어도 되고 없어도 되면 void
	
	// 삭제
	public void addrDelete(int num);
	
	// 검색 (전체 보기)
	public ArrayList<AddrDTO> addrSearchList(String field, String word);
	
	// 개수 (검색 아님) 
	public int addrSearchCount(String field, String word);
	
	// 우편번호
	public ArrayList<ZipDTO> addrZipRead(String dong);

}
