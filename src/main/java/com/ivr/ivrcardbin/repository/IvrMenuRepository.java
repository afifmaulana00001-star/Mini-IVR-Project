package com.ivr.ivrcardbin.repository;


import com.ivr.ivrcardbin.entity.IvrMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IvrMenuRepository extends JpaRepository<IvrMenu, Long> {
    List<IvrMenu> findByCardType(String cardType);

}
