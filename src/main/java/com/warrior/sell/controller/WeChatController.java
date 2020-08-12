package com.warrior.sell.controller;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author jun
 * @data 2020/8/9 16:17
 */
@Slf4j
@Controller
@RequestMapping("/wechat")
public class WeChatController {
    @Resource
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        String url = "http://junlaile.natapp1.cc/sell/wechat/userInfo";
        String encode = "";
        try {
            encode = URLEncoder.encode(returnUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("【微信授权】 编码不正确 encode = {}", encode);
            throw new SellException(ResultEnum.WECHAT_MP_ENCODE_ERROR.getCode(), e.getMessage());
        }
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, encode);
        log.info("【微信授权】 获取 code redirectUrl={}", redirectUrl);
        return String.format("redirect:%s",redirectUrl);
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code, @RequestParam("state") String redirectUrl) {
        WxMpOAuth2AccessToken accessToken;
        try {
            accessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】异常 e = {}", e.getError().getErrorMsg());
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openid = accessToken.getOpenId();
        return String.format("redirect:%s", redirectUrl + "?openid=" + openid);
    }

}
