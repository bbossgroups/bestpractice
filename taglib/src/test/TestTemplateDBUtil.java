package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.frameworkset.common.poolman.DBUtil;
import com.frameworkset.common.poolman.JDBCTemplate;
import com.frameworkset.common.poolman.PreparedDBUtil;
import com.frameworkset.common.poolman.TemplateDBUtil;

/**
 * 
 * 
 * <p>Title: TestTemplateDBUtil.java</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: 湖南科创信息股份有限公司</p>
 * @Date Jul 24, 2008 11:09:41 AM
 * @author biaoping.yin,尹标平
 * @version 1.0
 */
public class TestTemplateDBUtil {
	public static void testrollbackWithConnection() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						Connection con = PreparedDBUtil.getConection();
						PreparedDBUtil db = null;
						try {
							for (int i = 0; i < 1; i++) {
								db = new PreparedDBUtil();
								
									db
											.preparedInsert("bspf",
													"insert into td_reg_bank_acc_bak (create_acc_time,starttime,endtime) values(?,?,?)");
									Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);

									db.setDate(1, new java.util.Date());
									db.setDate(2, new java.util.Date());
									db.setDate(3, new java.util.Date());

									// if(true && i < 50)
									// {
									// throw new Exception("e");
									// }

									db.executePrepared(con);

								
							}
						
						}
						catch(SQLException e)
						{
							con.rollback();
							throw e;
						}
						catch(Exception e)
						{
							con.rollback();
							throw e;
						}
						finally {
							db.resetPrepare();
							con.close();
						}
						
						dbUtil.executeInsert("insert into table values()");
					}
				
				}
			);
	}
	
	public static void testrollback() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						
						PreparedDBUtil db = null;
						try {
							for (int i = 0; i < 1; i++) {
								db = new PreparedDBUtil();
								
									db.preparedInsert("bspf",
													"insert into td_reg_bank_acc_bak (create_acc_time,starttime,endtime) values(?,?,?)");
									Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);

									db.setDate(1, new java.util.Date());
									db.setDate(2, new java.util.Date());
									db.setDate(3, new java.util.Date());

									// if(true && i < 50)
									// {
									// throw new Exception("e");
									// }

									db.executePrepared();

								
							}
						} finally {
							
						}
						
						dbUtil.executeInsert("bspf","insert into table values()");
					}
				
				}
			);
	}
	
	public static void testcommit() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						
						PreparedDBUtil db = null;
						try {
							
								db = new PreparedDBUtil();
								//插入操作
								db.preparedInsert("bspf",
												"insert into td_reg_bank_acc_bak (create_acc_time,starttime,endtime) values(?,?,?)");
								Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);

								db.setDate(1, new java.util.Date());
								db.setDate(2, new java.util.Date());
								db.setDate(3, new java.util.Date());

								// if(true && i < 50)
								// {
								// throw new Exception("e");
								// }

								String id = String.valueOf(db.executePrepared());
								System.out.println("insert id:" + id);
								
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after insert common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after insert common select end.");
								//更新操作
								db = new PreparedDBUtil();
								
								db.preparedUpdate("bspf",
								"update td_reg_bank_acc_bak set create_acc_time=?,starttime=?,endtime=? where id=?");
								db.setDate(1, null);
								db.setDate(2, null);
								db.setDate(3, null);
								db.setString(4, id);
								db.executePrepared();
								//查询操作
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after update common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after update common select end.");
								//删除操作
								db = new PreparedDBUtil();
								db.preparedDelete("bspf",
								"delete  from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								//删除后查询
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete common select：");
								System.out.println(db.size());
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?",0,10);
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak ",0,10);
								
								
								db.executePrepared();
								System.out.println(" pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
						} finally {
							
						}
						
						dbUtil.executeInsert("bspf","insert into td_reg_bank_acc_bak (clob1,clob2) values('aa','bb')");
					}
				
				}
			);
	}
	
	public static void testcommitWithoutTableinfo() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						
						PreparedDBUtil db = null;
						try {
							
								db = new PreparedDBUtil();
								//插入操作
								db.preparedInsert("bspf",
												"insert into testprepared (id,create_acc_time,starttime,endtime) values(?,?,?,?)");
								Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);
								db.setString(1, "1");
								db.setDate(2, new java.util.Date());
								db.setDate(3, new java.util.Date());
								db.setDate(4, new java.util.Date());

								// if(true && i < 50)
								// {
								// throw new Exception("e");
								// }

								//String id = String.valueOf(db.executePrepared());
								db.executePrepared();
								String id = "1";
								System.out.println("insert id:" + id);
								
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from testprepared where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after insert common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after insert common select end.");
								//更新操作
								db = new PreparedDBUtil();
								
								db.preparedUpdate("bspf",
								"update testprepared set create_acc_time=?,starttime=?,endtime=? where id=?");
								db.setDate(1, null);
								db.setDate(2, null);
								db.setDate(3, null);
								db.setString(4, id);
								db.executePrepared();
								//查询操作
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from testprepared where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after update common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after update common select end.");
								//删除操作
								db = new PreparedDBUtil();
								db.preparedDelete("bspf",
								"delete  from testprepared where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								//删除后查询
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from testprepared where id=?");								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete common select：");
								System.out.println(db.size());
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from testprepared where id=?",0,10);
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
								
								db = new PreparedDBUtil();
								db.preparedSelect("bspf",
								"select create_acc_time,starttime,endtime from testprepared ",0,10);
								
								
								db.executePrepared();
								System.out.println(" pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
						} finally {
							
						}
						
						dbUtil.executeInsert("bspf","insert into testprepared (clob1,clob2) values('aa','bb')");
					}
				
				}
			);
	}
	
	public static void testcommitWithoutdbname() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						
						PreparedDBUtil db = null;
						try {
							
								db = new PreparedDBUtil();
								//插入操作
								db.preparedInsert(
												"insert into td_reg_bank_acc_bak (create_acc_time,starttime,endtime) values(?,?,?)");
								Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);

								db.setDate(1, new java.util.Date());
								db.setDate(2, new java.util.Date());
								db.setDate(3, new java.util.Date());

								// if(true && i < 50)
								// {
								// throw new Exception("e");
								// }

								String id = String.valueOf(db.executePrepared());
								System.out.println("insert id:" + id);
								
								
								db = new PreparedDBUtil();
								db.preparedSelect(
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after insert common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after insert common select end.");
								//更新操作
								db = new PreparedDBUtil();
								
								db.preparedUpdate(
								"update td_reg_bank_acc_bak set create_acc_time=?,starttime=?,endtime=? where id=?");
								db.setDate(1, null);
								db.setDate(2, null);
								db.setDate(3, null);
								db.setString(4, id);
								db.executePrepared();
								//查询操作
								db = new PreparedDBUtil();
								db.preparedSelect(
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after update common select begin.");
								System.out.println(db.size());
								System.out.println("create_acc_time:"+db.getDate(0, "create_acc_time"));
								System.out.println("starttime:"+db.getDate(0, "starttime"));
								System.out.println("endtime:"+db.getDate(0, "endtime"));
								System.out.println("after update common select end.");
								//删除操作
								db = new PreparedDBUtil();
								db.preparedDelete(
								"delete  from td_reg_bank_acc_bak where id=?");
								
								db.setString(1, id);
								db.executePrepared();
								//删除后查询
								db = new PreparedDBUtil();
								db.preparedSelect(
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?");								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete common select：");
								System.out.println(db.size());
								
								db = new PreparedDBUtil();
								db.preparedSelect(
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak where id=?",0,10);
								
								db.setString(1, id);
								db.executePrepared();
								System.out.println("after delete pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
								
								db = new PreparedDBUtil();
								db.preparedSelect(
								"select create_acc_time,starttime,endtime from td_reg_bank_acc_bak ",0,10);
								
								
								db.executePrepared();
								System.out.println(" pagine select：");
								System.out.println("db.size():"+db.size());
								System.out.println("db.getTotalSize():" +db.getLongTotalSize());
						} finally {
							
						}
						
						dbUtil.executeInsert("insert into td_reg_bank_acc_bak (clob1,clob2) values('aa','bb')");
					}
				
				}
			);
	}
	
	
	public static void testcommitWithConnection() throws Throwable
	{
		TemplateDBUtil.executeTemplate(
				new JDBCTemplate(){
					public void execute() throws Exception {
						DBUtil dbUtil = new DBUtil();
						
						PreparedDBUtil db = null;
						try {
							for (int i = 0; i < 1; i++) {
								db = new PreparedDBUtil();
								
									db.preparedInsert("bspf",
													"insert into td_reg_bank_acc_bak (create_acc_time,starttime,endtime) values(?,?,?)");
									Date today = new Date(new java.util.Date().getTime());
//									db.setInt(1, 1000 + i);

									db.setDate(1, new java.util.Date());
									db.setDate(2, new java.util.Date());
									db.setDate(3, new java.util.Date());

									// if(true && i < 50)
									// {
									// throw new Exception("e");
									// }

									db.executePrepared(dbUtil.getConection());

								
							}
						} finally {
							
						}
						
						dbUtil.executeInsert("insert into td_reg_bank_acc_bak (clob1,clob2) values('conaa','conbb')");
					}
				
				}
			);
	}
	
	public static void main(String[] args) throws Throwable
	{
//		TestTemplateDBUtil.testrollback();
//		TestTemplateDBUtil.testrollbackWithConnection();
//		TestTemplateDBUtil.testcommitWithoutdbname();
//		TestTemplateDBUtil.testcommitWithConnection();
//		testcommitWithoutTableinfo();
//		System.out.println(DBUtil.getNumActive());
//		System.out.println(DBUtil.getNumIdle());
//		System.out.println(DBUtil.getMaxNumActive());
		
		String c = "/";
		c = c.substring("/".length() );
		System.out.println(c);
		
	}

}
