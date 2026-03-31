package com.ivr.ivrcardbin.Service;

import com.ivr.ivrcardbin.entity.IvrMenu;
import com.ivr.ivrcardbin.repository.IvrMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IvrMenuService {

    @Autowired
    private IvrMenuRepository repository;

    public String getMenu(String cardType){

        List<IvrMenu> menus = repository.findByCardType(cardType);

        StringBuilder menuText = new StringBuilder();

        for(IvrMenu menu : menus){
            menuText.append(menu.getOptionNumber())
                    .append(" ")
                    .append(menu.getDescription())
                    .append("\n");
        }

        return menuText.toString();
    }
}