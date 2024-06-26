package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Sach;
import util.HibernateUtil;

public class sachDAO implements DAOInterface<Sach> {
	
	@Override
	public List<Sach> selectAll() {
		List<Sach> listSach = new	ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Sach c";
				Query query = session.createQuery(hql);
				listSach = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai HAHA");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listSach;
	}

	@Override
	public Sach selectById(Sach t) {
		List<Sach> listSach = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Sach c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listSach = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (listSach.size() > 0) {
			return listSach.get(0);
		}
		else return null;
	}
	
	@Override
	public boolean insert(Sach t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
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
	public boolean update(Sach t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
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
	public boolean delete(Sach t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
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
	public Sach selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Sach> searchByCriteria(String criteria) {
	    List<Sach> listSach = new ArrayList();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            
	            String hql = "from Sach c where c.id like :criteria or c.tenSach like :criteria or c.tacGia like :criteria or c.nhaXuatBan like :criteria or cast(c.namXuatBan as string) like :criteria or c.maNhaCungCap like :criteria";
	            Query query = session.createQuery(hql);
	            query.setParameter("criteria", "%" + criteria + "%");
	            listSach = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listSach;
	}


}
