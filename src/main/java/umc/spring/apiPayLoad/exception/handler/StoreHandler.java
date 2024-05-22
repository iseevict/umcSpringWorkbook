package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
