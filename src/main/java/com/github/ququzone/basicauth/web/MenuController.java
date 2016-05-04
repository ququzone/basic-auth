package com.github.ququzone.basicauth.web;

import com.github.ququzone.basicauth.model.Menu;
import com.github.ququzone.basicauth.service.AuthService;
import com.github.ququzone.common.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * menu controller.
 *
 * @author Yang XuePing
 */
@Controller
public class MenuController {
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public String menus(HttpServletRequest request) {
        List<Menu> menus = authService.getAllMenus();
        request.setAttribute("menus", menus);
        return "auth/menus";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestParam("name") String name, @RequestParam("icon") String icon) {
        authService.addMenu(name, icon);
        return ResponseEntity.ok("{}");
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(GsonUtil.DEFAULT_GSON.toJson(authService.getMenu(id)));
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") String id,
                                         @RequestParam("name") String name, @RequestParam("icon") String icon) {
        if (!"home".equals(id)) {
            authService.updateMenu(id, name, icon);
        }
        return ResponseEntity.ok("{}");
    }
}
