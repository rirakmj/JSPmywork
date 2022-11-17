package com.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
    // �߰�
	public void memberJoin(SMemberDTO member);
	
	// ��ü����
	public ArrayList<SMemberDTO> getMember();
	
	// ����
	public int memberDelete(String userid);
	
	// ����
	public int memberUpdate(SMemberDTO member);
	
	// �󼼺���
	public SMemberDTO findById(String userid);
	
	// ȸ����
	public int memberCount();
	
	// ���̵� �ߺ�Ȯ��
	public String memberIdCheck(String userid);
	
	// �α���
	public SMemberDTO memberLoginCheck(String userid, String pwd);
}
