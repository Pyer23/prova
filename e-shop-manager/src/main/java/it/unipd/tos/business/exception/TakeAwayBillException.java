////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {

    private static final long serialVersionUID = 1L;

    public TakeAwayBillException(String msg){
        super(msg);
    }
}