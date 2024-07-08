package com.easycar.controller;

import com.easycar.entity.bean.SysAccount;
import com.easycar.entity.constants.Constants;
import com.easycar.entity.dto.CreateImageCode;
import com.easycar.entity.enums.ResponseCodeEnum;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.exception.BusinessException;
import com.easycar.service.SysAccountService;
import com.easycar.utils.StringTools;
import com.mysql.cj.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginController extends ABaseController{
    @Resource
    private SysAccountService sysAccountService;
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session) throws IOException, IOException {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        session.setAttribute(Constants.CHECK_CODE_KEY, code);
        vCode.write(response.getOutputStream());
    }
    @RequestMapping("/login")
        public ResponseVO login(HttpSession session, String phone, String password, String checkCode) {
        //判断验证码是否为空
        if (StringTools.isEmpty(phone) || StringTools.isEmpty(password) || StringTools.isEmpty(checkCode)) {
            throw new BusinessException(ResponseCodeEnum.PARAM_ERROR);//抛出请求参数缺失错误
        }
        if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY))) {
            throw new BusinessException(ResponseCodeEnum.CHECK_CODE_ERROR);
        }
        //验证码正确，进行查询操作
        SysAccount sysAccount = sysAccountService.getSysAccountByPhone(phone);
        if (sysAccount == null) {
            throw new BusinessException(ResponseCodeEnum.ACCOUNT_NOT_EXIST);
        }
        //判断密码是否正确
                if (!sysAccount.getPassword().equals(password)) {
            throw new BusinessException(ResponseCodeEnum.CODE_602);
        }

            return getSuccessResponseVO(sysAccount);


    }
    @RequestMapping("/logout")
            public ResponseVO logout(HttpSession session) {
        //使用session.invalidate()方法使session失效
            session.invalidate();
            return getSuccessResponseVO(null);
        }

}