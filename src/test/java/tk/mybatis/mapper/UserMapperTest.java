package tk.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.pojo.SysRole;
import tk.mybatis.pojo.SysUser;

import java.util.*;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        //获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //查询用户id为1的用户
            SysUser user = userMapper.selectById(1L);
            //判断用户是否为空
            Assert.assertNotNull(user);
            //判断用户的名称是否为admin
            Assert.assertEquals("admin", user.getUserName());
            System.out.println(user);
        } finally {
            //关闭sqlSession的连接
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            //结果不为空
            Assert.assertNotNull(userList);
            //用户数量大于0个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.close();
        }

    }


    @Test
    public void selectRolesByUserIdTest() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectRolesByUserId方法查询用户的角色
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色个数大于0个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertTest() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个User对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //正常情况下应该读入一张图片存在byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int result = userMapper.insert(user);
            //只插入一条数据
            Assert.assertEquals(1, result);
            //id为null,没有给id赋值，并且没有配置回写id的值
            Assert.assertNotNull(user.getId());
        } finally {
            //默认的sqlSession是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //关闭sqlSession
            sqlSession.close();
        }
    }


    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert3(user);
            //只插入一条数据
            Assert.assertEquals(1, result);
            //由于id回写，所以id不为null
            Assert.assertNotNull(user.getId());
            System.out.println(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //查询一个user对象
            SysUser user = userMapper.selectById(1L);
            //判断当前名为admin
            Assert.assertEquals("admin", user.getUserName());
            //修改用户名
            user.setUserName("admin_test");
            //修改邮箱
            user.setUserEmail("test@mybatis.tk");
            //更新数据
            int result = userMapper.updateById(user);
            Assert.assertEquals(1, result);
            //根据当前id查询修改后的数据
            user = userMapper.selectById(1L);
            System.out.println(user);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库中查询数据，根据id=1查询
            SysUser user = userMapper.selectById(1L);
            //判断是否能查询出
            Assert.assertNotNull(user);
            //调用方法删除
            Assert.assertEquals(1, userMapper.deleteById(1L));
            //再次查询，数据应该为null
            Assert.assertNull(userMapper.selectById(1L));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //查询用户角色
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            //结果不为空
            Assert.assertNotNull(userList);
            //角色数量大于0个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //只查询用户名时
            SysUser query = new SysUser();
            query.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUser(query);
            Assert.assertTrue(userList.size() > 0);
            //只查询用户邮箱
            query.setUserName(null);
            query.setUserEmail("test@mybatis.tk");
            userList = userMapper.selectByUser(query);
            Assert.assertTrue(userList.size() > 0);
            //当同时查询用户名和邮箱的时候
            query.setUserName("ad");
            userList = userMapper.selectByUser(query);
            //由于没有同时复合这两个用户条件的用户，所以查询结果为0
            Assert.assertTrue(userList.size() == 0);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testUpdateByIdSelective() {
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个新的user对象
            SysUser user = new SysUser();
            //更新id=1的用户
            user.setId(1L);
            //修改邮箱
            user.setUserEmail("test@mybatis.tk");
            //更新数据
            int result = userMapper.updateByIdSelective(user);
            Assert.assertEquals(1, result);
            user = userMapper.selectById(1L);
            Assert.assertEquals("admin", user.getUserName());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testInsertSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test-selective");
            user.setUserPassword("123456");
            user.setUserInfo("test info");
            user.setCreateTime(new Date());
            //插入数据库
            userMapper.insert2(user);
            //获取插入的这条数据
            user = userMapper.selectById(user.getId());
            //获取插入的这条数据
            user = userMapper.selectById(user.getId());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdOrderName() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //只查询用户id
            SysUser user = new SysUser();
            user.setId(1L);
            user.setUserName("admin");
            SysUser query = userMapper.selectByIdOrderUserName(user);
            Assert.assertNotNull(query);
            //查询用户名
            user.setId(null);
            query = userMapper.selectByIdOrderUserName(user);
            Assert.assertNotNull(query);
            //当id和name都为空时
            user.setUserName(null);
            query = userMapper.selectByIdOrderUserName(user);
            Assert.assertNotNull(query);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }


    @Test
    public void testSelectByIdList() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            //业务逻辑中必须校验idList.size()>0
            List<SysUser> userList = userMapper.selectByIdList(idList);
            Assert.assertEquals(2, userList.size());
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testInsertList() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123456");
                user.setUserEmail("test@mybatis.tk");
                userList.add(user);
            }
            //将新建的对象批量插入数据库中
            int result = userMapper.insertList(userList);
            Assert.assertEquals(2, result);

            for (SysUser user : userList) {
                System.out.println(user);
            }
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void testUpdateByMap() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            //查询条件，同样更新字段，必须保证该值的存在
            map.put("id", 1L);
            //更新的其他字段
            map.put("user_email", "test@mybatis.tk");
            map.put("user_password", "12345678");
            //更新数据
            userMapper.updateByMap(map);
            //根据当前id查询修改后的数据
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
