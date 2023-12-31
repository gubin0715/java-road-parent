package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.common.util.MapSoft;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Api(value = "MapSoftController", description = "map相关接口")
public class MapSoftController {

    @RequestMapping(value = "/mapSoft", method = RequestMethod.POST)
    @ApiOperation(value = "map根据值正序倒序")
    public ResponseDto mapsoft() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("a", "3");
            map.put("b", "1");
            map.put("c", "2");
            //升序map
            Map<String, String> esc = MapSoft.sortByValueAscending(map);
            //降序map
            Map<String, String> desc = MapSoft.sortByValueDescending(map);
            Map zo = new HashMap();
            zo.put("esc", esc);
            zo.put("desc", desc);
            return ResponseDto.SUCCESSDATA(zo);
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }

    @RequestMapping(value = "/mapListSoft", method = RequestMethod.POST)
    @ApiOperation(value = "maplist排序")
    public ResponseDto maplistsoft() {
        try {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("ss_id", "1");
            map1.put("distance", "0.7245");
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("ss_id", "2");
            map2.put("distance", "4.3839");
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("ss_id", "3");
            map3.put("distance", "1.449");
            list.add(map1);
            list.add(map2);
            list.add(map3);
            // 排序前
            for (Map<String, Object> map : list) {
                System.out.println(map.get("distance"));
            }
            Collections.sort(list, new Comparator<Map<String, Object>>() {
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    String name1 = (String) o1.get("distance");
                    String name2 = (String) o2.get("distance");
                    return name1.compareTo(name2);
                }
            });
            // 排序后
            System.out.println("-------------------");
            for (Map<String, Object> map : list) {
                System.out.println(map.get("distance"));
            }
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }

    @RequestMapping(value = "/mapOut", method = RequestMethod.POST)
    @ApiOperation(value = "map遍历")
    public ResponseDto mapOut() {
        try {
            Map map = new LinkedHashMap();
            map.put("a", "aaa");
            map.put("b", "bbb");
            map.put("c", "ccc");
            //传统方式遍历Map
            Set keys = map.keySet();
            Iterator it = keys.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = (String) map.get(key);
                System.out.println("==========传统方式遍历Map===========" + key + "=" + value);
            }
            //增强for遍历map方式
            Set keys1 = map.keySet();
            for (Object obj : keys1) {
                String key = (String) obj;
                String value = (String) map.get(key);
                System.out.println("==========增强for遍历map方式===========" + key + "=" + value);
            }
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }
}
