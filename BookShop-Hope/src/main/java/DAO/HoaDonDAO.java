package DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.HoaDon;
import util.HibernateUtil;

public class HoaDonDAO implements DAOInterface<HoaDon> {

	@Override
	public List<HoaDon> selectAll() {
	    List<HoaDon> listHoaDon = new ArrayList<>();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            
	            // Thực thi câu lệnh HQL sắp xếp theo mã hóa đơn từ lớn đến nhỏ
	            String hql = "from HoaDon c order by cast(c.id as integer) desc";

	            Query query = session.createQuery(hql);
	            listHoaDon = query.getResultList();
	            
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Kết nối thất bại");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listHoaDon;
	}

	@Override
	public HoaDon selectById(HoaDon t) {
		List<HoaDon> listHoaDon = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from HoaDon c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listHoaDon = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listHoaDon.size() > 0) {
			return listHoaDon.get(0);
		}
		else return null;
	}
	
	public HoaDon selectIdMax() {
	    HoaDon hoaDon = null;
	    Session session = null;
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql = "from HoaDon c order by CAST(c.id as integer) desc";
	            Query query = session.createQuery(hql);
	            query.setMaxResults(1);
	            List results = query.getResultList();
	            if (!results.isEmpty()) {
	                // ignores multiple results
	                hoaDon = (HoaDon) results.get(0);
	            }
	            tr.commit();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return hoaDon;
	}



	
	
	@Override
	public boolean insert(HoaDon t) {
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
	public boolean update(HoaDon t) {
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
	public boolean delete(HoaDon t) {
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
	public HoaDon selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Object[]> getDoanhThuTheoNgay() {
	    List<Object[]> listDoanhThu = new ArrayList<>();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql = "SELECT cast(hd.thoiGian as date) as Ngay, sum(coalesce(hd.tongTien, 0)) as TongDoanhThu " +
	                    "FROM HoaDon hd " +
	                    "GROUP BY cast(hd.thoiGian as date)";

	            Query query = session.createQuery(hql);
	            listDoanhThu = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listDoanhThu;
	}
	
	public List<Object[]> getDoanhThuTheoThang() {
	    List<Object[]> listDoanhThu = new ArrayList<>();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql =  "SELECT   month(hd.thoiGian) as Thang, year(hd.thoiGian) as Nam, sum(coalesce(hd.tongTien, 0)) as TongDoanhThu " +
	                    "FROM HoaDon hd " +
	                    "GROUP BY month(hd.thoiGian), year(hd.thoiGian)";

	            Query query = session.createQuery(hql);
	            listDoanhThu = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listDoanhThu;
	}

    public List<Object[]> getDoanhThuTheoNam() {
	    List<Object[]> listDoanhThu = new ArrayList<>();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql =  	"SELECT year(hd.thoiGian) as Nam, sum(coalesce(hd.tongTien, 0)) as TongDoanhThu " +
	            	    "FROM HoaDon hd " +
	            	    "GROUP BY year(hd.thoiGian)";

	            Query query = session.createQuery(hql);
	            listDoanhThu = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listDoanhThu;
	}
    
    public List<HoaDon> searchByCriteria(String criteria) {
        List<HoaDon> listHoaDon = new ArrayList();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                
                String hql = "from HoaDon c where cast(c.id as string) like :criteria or c.thoiGian like :criteria or cast(c.tongTien as string) like :criteria or c.sdt like :criteria or c.maNhanVien like :criteria";
                Query query = session.createQuery(hql);
                query.setParameter("criteria", "%" + criteria + "%");
                listHoaDon = query.getResultList();
                tr.commit();
                session.close();
            } else {
                System.out.println("Ket noi that bai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

}


