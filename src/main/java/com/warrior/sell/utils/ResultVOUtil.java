package com.warrior.sell.utils;

import com.warrior.sell.vo.ResultVO;

/**
 * 返回 ResultVO 的状态值
 * @author jun
 */
public class ResultVOUtil {
    public static <DATA> ResultVO<DATA> success(DATA data) {
        ResultVO<DATA> resultVO = new ResultVO<>();
        resultVO.setData(data);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO<Object> success() {
        return success(null);
    }

    public static ResultVO<Object> error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
