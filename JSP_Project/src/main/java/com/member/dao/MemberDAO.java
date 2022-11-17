package com.member.dao;

import java.util.ArrayList;

import com.member.dto.MemberDTO;

public interface MemberDAO {
    // �߰�
	public void memberInsert(MemberDTO member);
	//��ü����
	public ArrayList<MemberDTO> memberList();
	//����
	public void memberUpdate(MemberDTO member);
	//����
	public void memberDelete(String userid);
	//�󼼺���
	public MemberDTO findById(String userid);
	//���̵��ߺ�üũ
	public String idCheck(String userid);
	//�α���üũ
	public int loginCheck(String userid, String pwd);
	//ȸ����
	public int getCount();
}
