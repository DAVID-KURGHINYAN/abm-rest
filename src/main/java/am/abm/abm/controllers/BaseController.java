package am.abm.abm.controllers;

import am.abm.abm.models.ResponseModel;

public class BaseController {

    protected <R> ResponseModel<R> createResult(R data, String message) {
        ResponseModel<R> responseModel = new ResponseModel<>();
        responseModel.setData(data);
        responseModel.setSuccess(true);
        responseModel.setMessage(message);
        return responseModel;
    }

    protected ResponseModel createErrorResult(Exception e) {
        ResponseModel responseModel = new ResponseModel<>();
        responseModel.setSuccess(false);
        responseModel.setMessage(e.getMessage());
        return responseModel;
    }

}
