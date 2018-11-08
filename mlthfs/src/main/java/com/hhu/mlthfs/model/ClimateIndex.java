package com.hhu.mlthfs.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author HHU
 * @since 2018-07-26
 *
 */
@TableName("climate_index")
@KeySequence(value = "tm",clazz = String.class)
public class ClimateIndex extends Model<ClimateIndex> {

    private static final long serialVersionUID = 1L;

    /**
     * 日期（年月：yyyymm）
     */
	private String tm;
    /**
     * 北半球副高面积指数
     */
	private Double c1;
    /**
     * 北非副高面积指数

     */
	private Double c2;
    /**
     * 北非-大西洋-北美副高面积指数

     */
	private Double c3;
    /**
     * 印度副高面积指数

     */
	private Double c4;
    /**
     * 西太平洋副高面积指数

     */
	private Double c5;
    /**
     * 东太平洋副高面积指数

     */
	private Double c6;
    /**
     * 北美副高面积指数

     */
	private Double c7;
    /**
     * 北大西洋副高面积指数

     */
	private Double c8;
    /**
     * 南海副高面积指数

     */
	private Double c9;
    /**
     * 北美大西洋副高面积指数

     */
	private Double c10;
    /**
     * 北太平洋副高面积指数

     */
	private Double c11;
    /**
     * 北半球副高强度指数

     */
	private Double c12;
    /**
     * 北非副高强度指数

     */
	private Double c13;
    /**
     * 北非-北大西洋-北美副高强度指数

     */
	private Double c14;
    /**
     * 印度副高强度指数

     */
	private Double c15;
    /**
     * 西太平洋副高强度指数

     */
	private Double c16;
    /**
     * 东太平洋副高强度指数

     */
	private Double c17;
    /**
     * 北美副高强度指数

     */
	private Double c18;
    /**
     * 北大西洋副高强度指数

     */
	private Double c19;
    /**
     * 南海副高强度指数

     */
	private Double c20;
    /**
     * 北美-北大西洋副高强度指数

     */
	private Double c21;
    /**
     * 太平洋副高强度指数

     */
	private Double c22;
    /**
     * 北半球副高脊线位置指数

     */
	private Double c23;
    /**
     * 北非副高脊线位置指数

     */
	private Double c24;
    /**
     * 北非-北大西洋-北美副高脊线位置指数

     */
	private Double c25;
    /**
     * 印度副高脊线位置指数

     */
	private Double c26;
    /**
     * 西太平洋副高脊线位置指数

     */
	private Double c27;
    /**
     * 东太平洋副高脊线位置指数

     */
	private Double c28;
    /**
     * 北美副高脊线位置指数

     */
	private Double c29;
    /**
     * 大西洋副高脊线位置指数

     */
	private Double c30;
    /**
     * 南海副高脊线位置指数

     */
	private Double c31;
    /**
     * 北美-北大西洋副高脊线位置指数

     */
	private Double c32;
    /**
     * 北太平洋副高脊线位置指数

     */
	private Double c33;
    /**
     * 北半球副高北界位置指数

     */
	private Double c34;
    /**
     * 北非副高北界位置指数

     */
	private Double c35;
    /**
     * 北非-北大西洋-北美副高北界位置指数

     */
	private Double c36;
    /**
     * 印度副高北界位置指数

     */
	private Double c37;
    /**
     * 西太平洋副高北界位置指数

     */
	private Double c38;
    /**
     * 东太平洋副高北界位置指数

     */
	private Double c39;
    /**
     * 北美副高北界位置指数

     */
	private Double c40;
    /**
     * 北大西洋副高北界位置指数

     */
	private Double c41;
    /**
     * 南海副高北界位置指数

     */
	private Double c42;
    /**
     * 北美-北大西洋副高北界位置指数

     */
	private Double c43;
    /**
     * 北太平洋副高北界位置指数

     */
	private Double c44;
    /**
     * 西太平洋副高西伸脊点指数

     */
	private Double c45;
    /**
     * 亚洲区极涡面积指数

     */
	private Double c46;
    /**
     * 太平洋区极涡面积指数

     */
	private Double c47;
    /**
     * 北美区极涡面积指数

     */
	private Double c48;
    /**
     * 大西洋欧洲区极涡面积指数

     */
	private Double c49;
    /**
     * 北半球极涡面积指数

     */
	private Double c50;
    /**
     * 亚洲区极涡强度指数

     */
	private Double c51;
    /**
     * 太平洋区极涡强度指数

     */
	private Double c52;
    /**
     * 北美区极涡强度指数

     */
	private Double c53;
    /**
     * 北大西洋-欧洲区极涡强度指数

     */
	private Double c54;
    /**
     * 北半球极涡强度指数

     */
	private Double c55;
    /**
     * 北半球极涡中心经向位置指数

     */
	private Double c56;
    /**
     * 北半球极涡中心纬向位置指数

     */
	private Double c57;
    /**
     * 北半球极涡中心强度指数

     */
	private Double c58;
    /**
     * 欧亚纬向环流指数

     */
	private Double c59;
    /**
     * 欧亚经向环流指数

     */
	private Double c60;
    /**
     * 亚洲纬向环流指数

     */
	private Double c61;
    /**
     * 亚洲经向环流指数

     */
	private Double c62;
    /**
     * 东亚槽位置指数

     */
	private Double c63;
    /**
     * 东亚槽强度指数

     */
	private Double c64;
    /**
     * 西藏高原-1指数

     */
	private Double c65;
    /**
     * 西藏高原-2 指数

     */
	private Double c66;
    /**
     * 印缅槽强度指数

     */
	private Double c67;
    /**
     * 北极涛动指数

     */
	private Double c68;
    /**
     * 南极涛动指数

     */
	private Double c69;
    /**
     * 北大西洋涛动指数

     */
	private Double c70;
    /**
     * 太平洋-北美遥相关型指数

     */
	private Double c71;
    /**
     * 东大西洋遥相关型指数

     */
	private Double c72;
    /**
     * 西太平洋遥相关型指数

     */
	private Double c73;
    /**
     * 北太平洋遥相关型指数

     */
	private Double c74;
    /**
     * 东大西洋-西俄罗斯遥相关型指数

     */
	private Double c75;
    /**
     * 热带-北半球遥相关型指数

     */
	private Double c76;
    /**
     * 极地-欧亚遥相关型指数

     */
	private Double c77;
    /**
     * 斯堪的纳维亚遥相关型指数

     */
	private Double c78;
    /**
     * 太平洋转换型指数

     */
	private Double c79;
    /**
     * 30hPa纬向风指数

     */
	private Double c80;
    /**
     * 50hPa纬向风指数

     */
	private Double c81;
    /**
     * 赤道中东太平洋200hPa纬向风指数

     */
	private Double c82;
    /**
     * 850hPa西太平洋信风指数

     */
	private Double c83;
    /**
     * 850hPa中太平洋信风指数

     */
	private Double c84;
    /**
     * 850hPa东太平洋信风指数

     */
	private Double c85;
    /**
     * 北大西洋-欧洲环流W型指数

     */
	private Long c86;
    /**
     * 北大西洋-欧洲环流型C型指数

     */
	private Long c87;
    /**
     * 北大西洋-欧洲环流E型指数

     */
	private Long c88;
    /**
     * NINO 1+2区海表温度距平指数

     */
	private Double c89;
    /**
     *  NINO 3区海表温度距平指数

     */
	private Double c90;
    /**
     * NINO 4区海表温度距平指数

     */
	private Double c91;
    /**
     * NINO 3.4区海表温度距平指数

     */
	private Double c92;
    /**
     * NINO W区海表温度距平指数

     */
	private Double c93;
    /**
     * NINO C区海表温度距平指数

     */
	private Double c94;
    /**
     * NINO A区海表温度距平指数

     */
	private Double c95;
    /**
     * NINO B区海表温度距平指数

     */
	private Double c96;
    /**
     * NINO Z区海表温度距平海表温度指数

     */
	private Double c97;
    /**
     * 热带北大西洋海温指数

     */
	private Double c98;
    /**
     * 热带南大西洋海温指数

     */
	private Double c99;
    /**
     * 西半球暖池指数

     */
	private Double c100;
    /**
     * 印度洋暖池面积指数

     */
	private Double c101;
    /**
     * 印度洋暖池强度指数

     */
	private Double c102;
    /**
     * 西太平洋暖池面积指数

     */
	private Double c103;
    /**
     * 西太平洋暖池强度指数

     */
	private Double c104;
    /**
     * 大西洋多年代际振荡指数

     */
	private Double c105;
    /**
     * 亲潮区海温指数

     */
	private Double c106;
    /**
     * 西风漂流区海温指数

     */
	private Double c107;
    /**
     * 黑潮区海温指数

     */
	private Double c108;
    /**
     * 类ENSO指数

     */
	private Double c109;
    /**
     * 暖池型ENSO指数

     */
	private Double c110;
    /**
     * 冷舌型ENSO指数

     */
	private Double c111;
    /**
     * 热带印度洋全区一致海温模态指数

     */
	private Double c112;
    /**
     * 热带印度洋海温偶极子指数

     */
	private Double c113;
    /**
     * 副热带南印度洋偶极子指数

     */
	private Double c114;
    /**
     * 冷空气次数

     */
	private Double c115;
    /**
     * 西太平洋编号台风数

     */
	private Long c116;
    /**
     * 登陆中国台风数

     */
	private Long c117;
    /**
     * 太阳黑子指数

     */
	private Long c118;
    /**
     * 南方涛动指数

     */
	private Double c119;
    /**
     * 热带太平洋射出长波辐射指数

     */
	private Double c120;
    /**
     * 多变量ENSO指数

     */
	private Double c121;
    /**
     * 北太平洋年代际振荡指数

     */
	private Double c122;
    /**
     * 大西洋经向模海温指数

     */
	private Double c123;
    /**
     * 准两年振荡指数

     */
	private Double c124;
    /**
     * 全球综合角动量指数

     */
	private Double c125;
    /**
     * 太阳辐射通量指数

     */
	private Long c126;
    /**
     * 赤道太平洋130°E-80°W范围次表层海温指数

     */
	private Double c127;
    /**
     * 赤道太平洋160°E-80°W范围次表层海温指数

     */
	private Double c128;
    /**
     * 赤道太平洋次表层海温指数

     */
	private Double c129;
    /**
     * 大西洋海温三极子指数

     */
	private Double c130;
    /**
     * 更新时间
     */
	private Date updateDate;
	private String remarks;
	private Date createDate;
	private Integer delFlag;
	private Long updateBy;
	private Long createBy;


	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	public Double getC1() {
		return c1;
	}

	public void setC1(Double c1) {
		this.c1 = c1;
	}

	public Double getC2() {
		return c2;
	}

	public void setC2(Double c2) {
		this.c2 = c2;
	}

	public Double getC3() {
		return c3;
	}

	public void setC3(Double c3) {
		this.c3 = c3;
	}

	public Double getC4() {
		return c4;
	}

	public void setC4(Double c4) {
		this.c4 = c4;
	}

	public Double getC5() {
		return c5;
	}

	public void setC5(Double c5) {
		this.c5 = c5;
	}

	public Double getC6() {
		return c6;
	}

	public void setC6(Double c6) {
		this.c6 = c6;
	}

	public Double getC7() {
		return c7;
	}

	public void setC7(Double c7) {
		this.c7 = c7;
	}

	public Double getC8() {
		return c8;
	}

	public void setC8(Double c8) {
		this.c8 = c8;
	}

	public Double getC9() {
		return c9;
	}

	public void setC9(Double c9) {
		this.c9 = c9;
	}

	public Double getC10() {
		return c10;
	}

	public void setC10(Double c10) {
		this.c10 = c10;
	}

	public Double getC11() {
		return c11;
	}

	public void setC11(Double c11) {
		this.c11 = c11;
	}

	public Double getC12() {
		return c12;
	}

	public void setC12(Double c12) {
		this.c12 = c12;
	}

	public Double getC13() {
		return c13;
	}

	public void setC13(Double c13) {
		this.c13 = c13;
	}

	public Double getC14() {
		return c14;
	}

	public void setC14(Double c14) {
		this.c14 = c14;
	}

	public Double getC15() {
		return c15;
	}

	public void setC15(Double c15) {
		this.c15 = c15;
	}

	public Double getC16() {
		return c16;
	}

	public void setC16(Double c16) {
		this.c16 = c16;
	}

	public Double getC17() {
		return c17;
	}

	public void setC17(Double c17) {
		this.c17 = c17;
	}

	public Double getC18() {
		return c18;
	}

	public void setC18(Double c18) {
		this.c18 = c18;
	}

	public Double getC19() {
		return c19;
	}

	public void setC19(Double c19) {
		this.c19 = c19;
	}

	public Double getC20() {
		return c20;
	}

	public void setC20(Double c20) {
		this.c20 = c20;
	}

	public Double getC21() {
		return c21;
	}

	public void setC21(Double c21) {
		this.c21 = c21;
	}

	public Double getC22() {
		return c22;
	}

	public void setC22(Double c22) {
		this.c22 = c22;
	}

	public Double getC23() {
		return c23;
	}

	public void setC23(Double c23) {
		this.c23 = c23;
	}

	public Double getC24() {
		return c24;
	}

	public void setC24(Double c24) {
		this.c24 = c24;
	}

	public Double getC25() {
		return c25;
	}

	public void setC25(Double c25) {
		this.c25 = c25;
	}

	public Double getC26() {
		return c26;
	}

	public void setC26(Double c26) {
		this.c26 = c26;
	}

	public Double getC27() {
		return c27;
	}

	public void setC27(Double c27) {
		this.c27 = c27;
	}

	public Double getC28() {
		return c28;
	}

	public void setC28(Double c28) {
		this.c28 = c28;
	}

	public Double getC29() {
		return c29;
	}

	public void setC29(Double c29) {
		this.c29 = c29;
	}

	public Double getC30() {
		return c30;
	}

	public void setC30(Double c30) {
		this.c30 = c30;
	}

	public Double getC31() {
		return c31;
	}

	public void setC31(Double c31) {
		this.c31 = c31;
	}

	public Double getC32() {
		return c32;
	}

	public void setC32(Double c32) {
		this.c32 = c32;
	}

	public Double getC33() {
		return c33;
	}

	public void setC33(Double c33) {
		this.c33 = c33;
	}

	public Double getC34() {
		return c34;
	}

	public void setC34(Double c34) {
		this.c34 = c34;
	}

	public Double getC35() {
		return c35;
	}

	public void setC35(Double c35) {
		this.c35 = c35;
	}

	public Double getC36() {
		return c36;
	}

	public void setC36(Double c36) {
		this.c36 = c36;
	}

	public Double getC37() {
		return c37;
	}

	public void setC37(Double c37) {
		this.c37 = c37;
	}

	public Double getC38() {
		return c38;
	}

	public void setC38(Double c38) {
		this.c38 = c38;
	}

	public Double getC39() {
		return c39;
	}

	public void setC39(Double c39) {
		this.c39 = c39;
	}

	public Double getC40() {
		return c40;
	}

	public void setC40(Double c40) {
		this.c40 = c40;
	}

	public Double getC41() {
		return c41;
	}

	public void setC41(Double c41) {
		this.c41 = c41;
	}

	public Double getC42() {
		return c42;
	}

	public void setC42(Double c42) {
		this.c42 = c42;
	}

	public Double getC43() {
		return c43;
	}

	public void setC43(Double c43) {
		this.c43 = c43;
	}

	public Double getC44() {
		return c44;
	}

	public void setC44(Double c44) {
		this.c44 = c44;
	}

	public Double getC45() {
		return c45;
	}

	public void setC45(Double c45) {
		this.c45 = c45;
	}

	public Double getC46() {
		return c46;
	}

	public void setC46(Double c46) {
		this.c46 = c46;
	}

	public Double getC47() {
		return c47;
	}

	public void setC47(Double c47) {
		this.c47 = c47;
	}

	public Double getC48() {
		return c48;
	}

	public void setC48(Double c48) {
		this.c48 = c48;
	}

	public Double getC49() {
		return c49;
	}

	public void setC49(Double c49) {
		this.c49 = c49;
	}

	public Double getC50() {
		return c50;
	}

	public void setC50(Double c50) {
		this.c50 = c50;
	}

	public Double getC51() {
		return c51;
	}

	public void setC51(Double c51) {
		this.c51 = c51;
	}

	public Double getC52() {
		return c52;
	}

	public void setC52(Double c52) {
		this.c52 = c52;
	}

	public Double getC53() {
		return c53;
	}

	public void setC53(Double c53) {
		this.c53 = c53;
	}

	public Double getC54() {
		return c54;
	}

	public void setC54(Double c54) {
		this.c54 = c54;
	}

	public Double getC55() {
		return c55;
	}

	public void setC55(Double c55) {
		this.c55 = c55;
	}

	public Double getC56() {
		return c56;
	}

	public void setC56(Double c56) {
		this.c56 = c56;
	}

	public Double getC57() {
		return c57;
	}

	public void setC57(Double c57) {
		this.c57 = c57;
	}

	public Double getC58() {
		return c58;
	}

	public void setC58(Double c58) {
		this.c58 = c58;
	}

	public Double getC59() {
		return c59;
	}

	public void setC59(Double c59) {
		this.c59 = c59;
	}

	public Double getC60() {
		return c60;
	}

	public void setC60(Double c60) {
		this.c60 = c60;
	}

	public Double getC61() {
		return c61;
	}

	public void setC61(Double c61) {
		this.c61 = c61;
	}

	public Double getC62() {
		return c62;
	}

	public void setC62(Double c62) {
		this.c62 = c62;
	}

	public Double getC63() {
		return c63;
	}

	public void setC63(Double c63) {
		this.c63 = c63;
	}

	public Double getC64() {
		return c64;
	}

	public void setC64(Double c64) {
		this.c64 = c64;
	}

	public Double getC65() {
		return c65;
	}

	public void setC65(Double c65) {
		this.c65 = c65;
	}

	public Double getC66() {
		return c66;
	}

	public void setC66(Double c66) {
		this.c66 = c66;
	}

	public Double getC67() {
		return c67;
	}

	public void setC67(Double c67) {
		this.c67 = c67;
	}

	public Double getC68() {
		return c68;
	}

	public void setC68(Double c68) {
		this.c68 = c68;
	}

	public Double getC69() {
		return c69;
	}

	public void setC69(Double c69) {
		this.c69 = c69;
	}

	public Double getC70() {
		return c70;
	}

	public void setC70(Double c70) {
		this.c70 = c70;
	}

	public Double getC71() {
		return c71;
	}

	public void setC71(Double c71) {
		this.c71 = c71;
	}

	public Double getC72() {
		return c72;
	}

	public void setC72(Double c72) {
		this.c72 = c72;
	}

	public Double getC73() {
		return c73;
	}

	public void setC73(Double c73) {
		this.c73 = c73;
	}

	public Double getC74() {
		return c74;
	}

	public void setC74(Double c74) {
		this.c74 = c74;
	}

	public Double getC75() {
		return c75;
	}

	public void setC75(Double c75) {
		this.c75 = c75;
	}

	public Double getC76() {
		return c76;
	}

	public void setC76(Double c76) {
		this.c76 = c76;
	}

	public Double getC77() {
		return c77;
	}

	public void setC77(Double c77) {
		this.c77 = c77;
	}

	public Double getC78() {
		return c78;
	}

	public void setC78(Double c78) {
		this.c78 = c78;
	}

	public Double getC79() {
		return c79;
	}

	public void setC79(Double c79) {
		this.c79 = c79;
	}

	public Double getC80() {
		return c80;
	}

	public void setC80(Double c80) {
		this.c80 = c80;
	}

	public Double getC81() {
		return c81;
	}

	public void setC81(Double c81) {
		this.c81 = c81;
	}

	public Double getC82() {
		return c82;
	}

	public void setC82(Double c82) {
		this.c82 = c82;
	}

	public Double getC83() {
		return c83;
	}

	public void setC83(Double c83) {
		this.c83 = c83;
	}

	public Double getC84() {
		return c84;
	}

	public void setC84(Double c84) {
		this.c84 = c84;
	}

	public Double getC85() {
		return c85;
	}

	public void setC85(Double c85) {
		this.c85 = c85;
	}

	public Long getC86() {
		return c86;
	}

	public void setC86(Long c86) {
		this.c86 = c86;
	}

	public Long getC87() {
		return c87;
	}

	public void setC87(Long c87) {
		this.c87 = c87;
	}

	public Long getC88() {
		return c88;
	}

	public void setC88(Long c88) {
		this.c88 = c88;
	}

	public Double getC89() {
		return c89;
	}

	public void setC89(Double c89) {
		this.c89 = c89;
	}

	public Double getC90() {
		return c90;
	}

	public void setC90(Double c90) {
		this.c90 = c90;
	}

	public Double getC91() {
		return c91;
	}

	public void setC91(Double c91) {
		this.c91 = c91;
	}

	public Double getC92() {
		return c92;
	}

	public void setC92(Double c92) {
		this.c92 = c92;
	}

	public Double getC93() {
		return c93;
	}

	public void setC93(Double c93) {
		this.c93 = c93;
	}

	public Double getC94() {
		return c94;
	}

	public void setC94(Double c94) {
		this.c94 = c94;
	}

	public Double getC95() {
		return c95;
	}

	public void setC95(Double c95) {
		this.c95 = c95;
	}

	public Double getC96() {
		return c96;
	}

	public void setC96(Double c96) {
		this.c96 = c96;
	}

	public Double getC97() {
		return c97;
	}

	public void setC97(Double c97) {
		this.c97 = c97;
	}

	public Double getC98() {
		return c98;
	}

	public void setC98(Double c98) {
		this.c98 = c98;
	}

	public Double getC99() {
		return c99;
	}

	public void setC99(Double c99) {
		this.c99 = c99;
	}

	public Double getC100() {
		return c100;
	}

	public void setC100(Double c100) {
		this.c100 = c100;
	}

	public Double getC101() {
		return c101;
	}

	public void setC101(Double c101) {
		this.c101 = c101;
	}

	public Double getC102() {
		return c102;
	}

	public void setC102(Double c102) {
		this.c102 = c102;
	}

	public Double getC103() {
		return c103;
	}

	public void setC103(Double c103) {
		this.c103 = c103;
	}

	public Double getC104() {
		return c104;
	}

	public void setC104(Double c104) {
		this.c104 = c104;
	}

	public Double getC105() {
		return c105;
	}

	public void setC105(Double c105) {
		this.c105 = c105;
	}

	public Double getC106() {
		return c106;
	}

	public void setC106(Double c106) {
		this.c106 = c106;
	}

	public Double getC107() {
		return c107;
	}

	public void setC107(Double c107) {
		this.c107 = c107;
	}

	public Double getC108() {
		return c108;
	}

	public void setC108(Double c108) {
		this.c108 = c108;
	}

	public Double getC109() {
		return c109;
	}

	public void setC109(Double c109) {
		this.c109 = c109;
	}

	public Double getC110() {
		return c110;
	}

	public void setC110(Double c110) {
		this.c110 = c110;
	}

	public Double getC111() {
		return c111;
	}

	public void setC111(Double c111) {
		this.c111 = c111;
	}

	public Double getC112() {
		return c112;
	}

	public void setC112(Double c112) {
		this.c112 = c112;
	}

	public Double getC113() {
		return c113;
	}

	public void setC113(Double c113) {
		this.c113 = c113;
	}

	public Double getC114() {
		return c114;
	}

	public void setC114(Double c114) {
		this.c114 = c114;
	}

	public Double getC115() {
		return c115;
	}

	public void setC115(Double c115) {
		this.c115 = c115;
	}

	public Long getC116() {
		return c116;
	}

	public void setC116(Long c116) {
		this.c116 = c116;
	}

	public Long getC117() {
		return c117;
	}

	public void setC117(Long c117) {
		this.c117 = c117;
	}

	public Long getC118() {
		return c118;
	}

	public void setC118(Long c118) {
		this.c118 = c118;
	}

	public Double getC119() {
		return c119;
	}

	public void setC119(Double c119) {
		this.c119 = c119;
	}

	public Double getC120() {
		return c120;
	}

	public void setC120(Double c120) {
		this.c120 = c120;
	}

	public Double getC121() {
		return c121;
	}

	public void setC121(Double c121) {
		this.c121 = c121;
	}

	public Double getC122() {
		return c122;
	}

	public void setC122(Double c122) {
		this.c122 = c122;
	}

	public Double getC123() {
		return c123;
	}

	public void setC123(Double c123) {
		this.c123 = c123;
	}

	public Double getC124() {
		return c124;
	}

	public void setC124(Double c124) {
		this.c124 = c124;
	}

	public Double getC125() {
		return c125;
	}

	public void setC125(Double c125) {
		this.c125 = c125;
	}

	public Long getC126() {
		return c126;
	}

	public void setC126(Long c126) {
		this.c126 = c126;
	}

	public Double getC127() {
		return c127;
	}

	public void setC127(Double c127) {
		this.c127 = c127;
	}

	public Double getC128() {
		return c128;
	}

	public void setC128(Double c128) {
		this.c128 = c128;
	}

	public Double getC129() {
		return c129;
	}

	public void setC129(Double c129) {
		this.c129 = c129;
	}

	public Double getC130() {
		return c130;
	}

	public void setC130(Double c130) {
		this.c130 = c130;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	@Override
	protected Serializable pkVal() {
		return this.tm;
	}

	@Override
	public String toString() {
		return "ClimateIndex{" +
			", tm=" + tm +
			", c1=" + c1 +
			", c2=" + c2 +
			", c3=" + c3 +
			", c4=" + c4 +
			", c5=" + c5 +
			", c6=" + c6 +
			", c7=" + c7 +
			", c8=" + c8 +
			", c9=" + c9 +
			", c10=" + c10 +
			", c11=" + c11 +
			", c12=" + c12 +
			", c13=" + c13 +
			", c14=" + c14 +
			", c15=" + c15 +
			", c16=" + c16 +
			", c17=" + c17 +
			", c18=" + c18 +
			", c19=" + c19 +
			", c20=" + c20 +
			", c21=" + c21 +
			", c22=" + c22 +
			", c23=" + c23 +
			", c24=" + c24 +
			", c25=" + c25 +
			", c26=" + c26 +
			", c27=" + c27 +
			", c28=" + c28 +
			", c29=" + c29 +
			", c30=" + c30 +
			", c31=" + c31 +
			", c32=" + c32 +
			", c33=" + c33 +
			", c34=" + c34 +
			", c35=" + c35 +
			", c36=" + c36 +
			", c37=" + c37 +
			", c38=" + c38 +
			", c39=" + c39 +
			", c40=" + c40 +
			", c41=" + c41 +
			", c42=" + c42 +
			", c43=" + c43 +
			", c44=" + c44 +
			", c45=" + c45 +
			", c46=" + c46 +
			", c47=" + c47 +
			", c48=" + c48 +
			", c49=" + c49 +
			", c50=" + c50 +
			", c51=" + c51 +
			", c52=" + c52 +
			", c53=" + c53 +
			", c54=" + c54 +
			", c55=" + c55 +
			", c56=" + c56 +
			", c57=" + c57 +
			", c58=" + c58 +
			", c59=" + c59 +
			", c60=" + c60 +
			", c61=" + c61 +
			", c62=" + c62 +
			", c63=" + c63 +
			", c64=" + c64 +
			", c65=" + c65 +
			", c66=" + c66 +
			", c67=" + c67 +
			", c68=" + c68 +
			", c69=" + c69 +
			", c70=" + c70 +
			", c71=" + c71 +
			", c72=" + c72 +
			", c73=" + c73 +
			", c74=" + c74 +
			", c75=" + c75 +
			", c76=" + c76 +
			", c77=" + c77 +
			", c78=" + c78 +
			", c79=" + c79 +
			", c80=" + c80 +
			", c81=" + c81 +
			", c82=" + c82 +
			", c83=" + c83 +
			", c84=" + c84 +
			", c85=" + c85 +
			", c86=" + c86 +
			", c87=" + c87 +
			", c88=" + c88 +
			", c89=" + c89 +
			", c90=" + c90 +
			", c91=" + c91 +
			", c92=" + c92 +
			", c93=" + c93 +
			", c94=" + c94 +
			", c95=" + c95 +
			", c96=" + c96 +
			", c97=" + c97 +
			", c98=" + c98 +
			", c99=" + c99 +
			", c100=" + c100 +
			", c101=" + c101 +
			", c102=" + c102 +
			", c103=" + c103 +
			", c104=" + c104 +
			", c105=" + c105 +
			", c106=" + c106 +
			", c107=" + c107 +
			", c108=" + c108 +
			", c109=" + c109 +
			", c110=" + c110 +
			", c111=" + c111 +
			", c112=" + c112 +
			", c113=" + c113 +
			", c114=" + c114 +
			", c115=" + c115 +
			", c116=" + c116 +
			", c117=" + c117 +
			", c118=" + c118 +
			", c119=" + c119 +
			", c120=" + c120 +
			", c121=" + c121 +
			", c122=" + c122 +
			", c123=" + c123 +
			", c124=" + c124 +
			", c125=" + c125 +
			", c126=" + c126 +
			", c127=" + c127 +
			", c128=" + c128 +
			", c129=" + c129 +
			", c130=" + c130 +
			", updateDate=" + updateDate +
			", remarks=" + remarks +
			", createDate=" + createDate +
			", delFlag=" + delFlag +
			", updateBy=" + updateBy +
			", createBy=" + createBy +
			"}";
	}
}
