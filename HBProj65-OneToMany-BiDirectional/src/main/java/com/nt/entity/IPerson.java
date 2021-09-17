package com.nt.entity;

import java.util.Set;

public interface IPerson {
    public void setPid(Integer pid);
    public Integer getPid();
    public void setPname(String pname);
    public  String getPname();
    public void setPaddrs(String paddrs);
    public String getPaddrs();
    public Set<BankAccount> getAccounts();
    public void setAccounts(Set<BankAccount> accounts);
}
