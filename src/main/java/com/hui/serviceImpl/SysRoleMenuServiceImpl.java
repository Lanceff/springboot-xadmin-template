package com.hui.serviceImpl;

import com.hui.entity.SysRoleMenu;
import com.hui.mapper.SysRoleMenuMapper;
import com.hui.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Integer id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }

}
