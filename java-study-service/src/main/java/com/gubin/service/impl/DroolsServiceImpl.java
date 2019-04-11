package com.gubin.service.impl;

import com.gubin.common.drools.DroolsLog;
import com.gubin.common.drools.DroolsUtil;
import com.gubin.common.dto.ResponseDto;
import com.gubin.service.DroolsService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroolsServiceImpl implements DroolsService {
    @Override
    public ResponseDto drools() {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("drools-rules");
            DroolsUtil droolsUtil = new DroolsUtil();
            droolsUtil.setAge(20);
            kSession.insert(droolsUtil);
            //规则记录List
            List<DroolsLog> droolsLogs = new ArrayList<>();
            kSession.setGlobal("droolsLogs",droolsLogs);
            //执行所有规则
            kSession.fireAllRules();
            return ResponseDto.SUCCESSDATA(droolsLogs);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERROR();
        }
    }
}
