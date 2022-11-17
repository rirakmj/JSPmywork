package com.addr.model;

import java.util.ArrayList;

public interface SAddrDAO {
	// �߰�
	public void addrInsert(AddrDTO addr);
	
	// ��ü���� (�˻� �ƴ�)
	public ArrayList<AddrDTO> addrList();
	
	// ���� (�˻� �ƴ�)
	public int addrCount(); 
	
	// �󼼺��� 
	public AddrDTO addrDetail(int num);
	
	// ���� 
	public void addrUpdate(AddrDTO addr); // return�� �־ �ǰ� ��� �Ǹ� void
	
	// ����
	public void addrDelete(int num);
	
	// �˻� (��ü ����)
	public ArrayList<AddrDTO> addrSearchList(String field, String word);
	
	// ���� (�˻� �ƴ�) 
	public int addrSearchCount(String field, String word);
	
	// �����ȣ
	public ArrayList<ZipDTO> addrZipRead(String dong);

}
