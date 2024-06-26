package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.LichSuDangNhap;

import util.HibernateUtil;

public class LichSuDangNhapDAO implements DAOInterface<LichSuDangNhap> {

	public List<LichSuDangNhap> selectAll() {
		List<LichSuDangNhap> listLichSuDangNhap = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from LichSuDangNhap c";
				Query query = session.createQuery(hql);
				listLichSuDangNhap = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listLichSuDangNhap;
	}

	public LichSuDangNhap selectById(LichSuDangNhap t) {
		List<LichSuDangNhap> listLichSuDangNhap = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from LichSuDangNhap c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listLichSuDangNhap = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listLichSuDangNhap.size() > 0) {
			return listLichSuDangNhap.get(0);
		}
		else return null;
	}

	
	
	
	public boolean insert(LichSuDangNhap t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				//Chỉ lưu khi chưa tồn tại
				session.save(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}
	
	
	public boolean update(LichSuDangNhap t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				session.update(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}

	
	public boolean delete(LichSuDangNhap t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				session.delete(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}
	
	
	
	@Override
	public LichSuDangNhap selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
