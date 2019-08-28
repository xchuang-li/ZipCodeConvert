package cn.com.maping;
/**
 *
 *@author ����:�¿���
 *@version 2019��8��27������6:17:41
 */
public interface Weight_Code_Enum {
	//Ȩ��ö��ֵ
	enum Weight{
		SEVEN(7),FOUR(4),TWO(2),ONE(1),ZERO(0);
		private int num;
		private Weight(int num){
			this.num = num;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
	}
	//ȫ�� ���� ö��ֵ
	enum Code{
		ZERO(":",0),ONE("|",1);
		private String codeStr;
		private int codeNum;
		private Code(String codeStr,int codeNum){
			this.codeStr = codeStr;
			this.codeNum = codeNum;
		}
		public static String getCodeStrBynum(int num){
			for (Code codeeach : Code.values()) {
				if(num == codeeach.getCodeNum()){
					return codeeach.getCodeStr();
				}
			}
			return null;
		}
		public static int getNumByCodeStr(String codeStr){
			for (Code codeeach : Code.values()) {
				if(codeStr.equals(codeeach.getCodeStr())){
					return codeeach.getCodeNum();
				}
			}
			return -1;
		}
		public String getCodeStr() {
			return codeStr;
		}
		public void setCodeStr(String codeStr) {
			this.codeStr = codeStr;
		}
		public int getCodeNum() {
			return codeNum;
		}
		public void setCodeNum(int codeNum) {
			this.codeNum = codeNum;
		}
	}
}
