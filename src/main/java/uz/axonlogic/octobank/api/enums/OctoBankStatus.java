package uz.axonlogic.octobank.api.enums;

public enum OctoBankStatus {

    INPUT,
    CHANGE_PAYMENT_TYPE,
    PREPARE_PAYMENT,
    PREPARE_PAYMENT_DONE,
    PREPARE_PAYMENT_FAIL,
    CONFIRM_PAYMENT,
    IN_PROGRESS_CANCEL_PAYMENT,
    CANCEL_PAYMENT_DONE,
    CANCEL_PAYMENT_FAIL,

    CONFIRM_PAYMENT_DONE,
    CONFIRM_PAYMENT_FAIL,
    PAYMENT_SUCCESS,
    PAYMENT_FAIL,
    ROLLBACK_PROCESS,
    FINISH_SUCCESS_PAID,
    CHECKING_PAYMENT,
    RESEND_CODE,
    RESEND_CODE_DONE,
    RESEND_CODE_FAIL,

}