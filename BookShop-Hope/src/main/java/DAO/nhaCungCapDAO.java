package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.NhaCungCap;
import util.HibernateUtil;

public class nhaCungCapDAO implements DAOInterface<NhaCungCap> {

	@Override
	public List<NhaCungCap> selectAll() {
		List<NhaCungCap> listNhaCungCap = new	ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from NhaCungCap c";
				Query query = session.createQuery(hql);
				listNhaCungCap = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listNhaCungCap;
	}

	@Override
	public NhaCungCap selectById(NhaCungCap t) {
		List<NhaCungCap> listNhaCungCap = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from NhaCungCap c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listNhaCungCap = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listNhaCungCap.size() > 0) {
			return listNhaCungCap.get(0);
		}
		else return null;
	}

	
	
	@Override
	public boolean insert(NhaCungCap t) {
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
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}
	
	@Override
	public boolean update(NhaCungCap t) {
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
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(NhaCungCap t) {
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
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}

	@Override
	public NhaCungCap selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

