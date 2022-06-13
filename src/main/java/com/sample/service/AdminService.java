package com.sample.service;

import com.sample.entity.Admin;

public interface AdminService {
Admin registerAdmin(Admin admin);
Admin loginAdmin(Admin admin);
Admin updateAdmin(Admin admin,int aId);
void deleteAdminAccount(int aId);
}
