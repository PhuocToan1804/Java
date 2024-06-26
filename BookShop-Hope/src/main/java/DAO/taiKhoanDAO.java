package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.TaiKhoan;
import util.HibernateUtil;

public class taiKhoanDAO implements DAOInterface<TaiKhoan> {
	
	public taiKhoanDAO() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<TaiKhoan> selectAll() {
		List<TaiKhoan> listTaiKhoan = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from TaiKhoan c";
				Query query = session.createQuery(hql);
				listTaiKhoan = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listTaiKhoan;
	}

	@Override
	public TaiKhoan selectById(TaiKhoan t) {
		List<TaiKhoan> listTaiKhoan = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from TaiKhoan c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listTaiKhoan = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listTaiKhoan.size() > 0) {
			return listTaiKhoan.get(0);
		}
		else return null;
	}

	
	
	@Override
	public boolean insert(TaiKhoan t) {
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
	
	@Override
	public boolean update(TaiKhoan t) {
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

	@Override
	public boolean delete(TaiKhoan t) {
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
	
	public boolean exists(TaiKhoan t) {
	    List<TaiKhoan> listTaiKhoan = new ArrayList();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql = "from TaiKhoan c where c.id =: id and c.matKhau =: matKhau and c.loaiTaiKhoan =: loaiTaiKhoan";
	            Query query = session.createQuery(hql);
	            query.setParameter("id", t.getId());
	            query.setParameter("matKhau", t.getMatKhau());
	            query.setParameter("loaiTaiKhoan", t.getLoaiTaiKhoan());
	            listTaiKhoan = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai HAHA");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();// TODO: handle exception
	    }
	    return listTaiKhoan.size() > 0;
	} 
	
	@Override
	public TaiKhoan selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
