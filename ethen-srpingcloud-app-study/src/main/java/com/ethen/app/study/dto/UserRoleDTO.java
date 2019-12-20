package com.ethen.app.study.dto;


import javax.persistence.*;

@Entity
@Table(name = "t_role_user")
public class UserRoleDTO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "remarks")
    private String remarks;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RoleConfigDTO.class)
    private RoleConfigDTO roleConfigDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public RoleConfigDTO getRoleConfigDTO() {
        return roleConfigDTO;
    }

    public void setRoleConfigDTO(RoleConfigDTO roleConfigDTO) {
        this.roleConfigDTO = roleConfigDTO;
    }
}


