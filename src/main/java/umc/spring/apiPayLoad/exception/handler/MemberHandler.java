package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
