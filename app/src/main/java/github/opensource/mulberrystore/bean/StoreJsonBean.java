package github.opensource.mulberrystore.bean;

/**
 * Project :  MulberryStore.
 * Package name: github.opensource.mulberrystore.bean
 * Created by :  Benjamin.
 * Created time: 2018/3/12 16:19
 * Changed by :  Benjamin.
 * Changed time: 2018/3/12 16:19
 * Class description:
 */

public class StoreJsonBean {

    /**
     * error : 0
     * mes : {"ean":"6939320513300","titleSrc":"http://www.liantu.com/tiaoma/eantitle.php?title=dUd3Z3BhS2J3cUk9","guobie":"中国","sort_id":null,"faccode":"69393205","fac_name":""}
     */

    private int error;
    private MesBean mes;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public MesBean getMes() {
        return mes;
    }

    public void setMes(MesBean mes) {
        this.mes = mes;
    }

    public static class MesBean {
        /**
         * ean : 6939320513300
         * titleSrc : http://www.liantu.com/tiaoma/eantitle.php?title=dUd3Z3BhS2J3cUk9
         * guobie : 中国
         * sort_id : null
         * faccode : 69393205
         * fac_name :
         */

        private String ean;
        private String titleSrc;
        private String guobie;
        private String sort_id;
        private String faccode;
        private String fac_name;

        public String getEan() {
            return ean;
        }

        public void setEan(String ean) {
            this.ean = ean;
        }

        public String getTitleSrc() {
            return titleSrc;
        }

        public void setTitleSrc(String titleSrc) {
            this.titleSrc = titleSrc;
        }

        public String getGuobie() {
            return guobie;
        }

        public void setGuobie(String guobie) {
            this.guobie = guobie;
        }

        public String getSort_id() {
            return sort_id;
        }

        public void setSort_id(String sort_id) {
            this.sort_id = sort_id;
        }

        public String getFaccode() {
            return faccode;
        }

        public void setFaccode(String faccode) {
            this.faccode = faccode;
        }

        public String getFac_name() {
            return fac_name;
        }

        public void setFac_name(String fac_name) {
            this.fac_name = fac_name;
        }
    }
}
