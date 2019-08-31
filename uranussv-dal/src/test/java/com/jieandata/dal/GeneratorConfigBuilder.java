package com.jieandata.dal;

/**
 * @Auther: pengke
 * @Date: 2019-8-5 16:33
 * @Description:
 */
public class GeneratorConfigBuilder {
    private static String[] tables = {
            /*"plan_info",
            "user_base_info",
            "user_device_info",
            "user_feedback",
            "user_flag_info",
            "user_flag_real",
            "user_level_info",
            "user_login_log",
            "user_plan_detail",
            "user_token_info",
            "agent_info",
            "manage_admin_logs",
            "manage_department",
            "manage_distri_admin",
            "manage_menu",
            "manage_menu_power",
            "manage_user",
            "member_level_info"*/
            "manage_group",
            "manage_user_group"
    };
    public static void main(String[] args) {
        buildTableConfigs();
    }

    private static void buildTableConfigs(){
        String domainObjectName;
        for (String name : tables) {
            domainObjectName = toCapitalizeCamelCase(name);
            System.out.println("<table tableName=\""+name+"\" domainObjectName=\""+domainObjectName+"Do\"" + " mapperName=\"" +domainObjectName+"Mapper\"");
            System.out.println("	    enableCountByExample=\"false\"");
            System.out.println("	    enableUpdateByExample=\"false\"");
            System.out.println("	    enableDeleteByExample=\"false\"");
            System.out.println("	    enableSelectByExample=\"false\"");
            System.out.println("	    selectByExampleQueryId=\"false\">");
            System.out.println("    <property name=\"useActualColumnNames\" value=\"true\"/>");
            System.out.println("</table>");
        }
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    private static final char SEPARATOR = '_';
}
