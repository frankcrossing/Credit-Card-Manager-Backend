package com.jieandata.utils.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jieandata.jaguar.common.exception.JaguarException;
import com.jieandata.jaguar.common.utils.base.JaguarAssert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import java.io.IOException;
import java.util.*;

/**
 * @Auther: pengke
 * @Date: 2019-1-16 11:16
 * @Description:
 */
@Slf4j
public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 根据属性名和值，查找所在节点的json
     * @param json
     * @param fieldName
     * @param value
     * @return
     */
    public static String[] findJsonsByFieldNameAndValue(String json, String fieldName, String value){
        try {
            JsonNode node = mapper.readTree(json);
            List<JsonNode> nodeList = node.findParents(fieldName);
            if(CollectionUtils.isEmpty(nodeList)){
                return null;
            }
            List<String> jsonList = new ArrayList<>();
            String text;
            for(JsonNode oneNode : nodeList){
                text = oneNode.get(fieldName).asText();
                if(text.equals(value)){
                    jsonList.add(oneNode.toString());
                }
            }
            return jsonList.toArray(new String[0]);
        } catch (IOException e) {
            log.error("",e);
        }
        return null;
    }

    public static String[] findJsonsByFieldNameAndStartsWithValue(String json, String fieldName, String value){
        try {
            JsonNode node = mapper.readTree(json);
            List<JsonNode> nodeList = node.findParents(fieldName);
            if(CollectionUtils.isEmpty(nodeList)){
                return null;
            }
            List<String> jsonList = new ArrayList<>();
            String text;
            for(JsonNode oneNode : nodeList){
                text = oneNode.get(fieldName).asText();
                if(text.startsWith(value)){
                    jsonList.add(oneNode.toString());
                }
            }
            return jsonList.toArray(new String[0]);
        } catch (IOException e) {
            log.error("",e);
        }
        return null;
    }
    /**
     * 获取相同属性的值的list
     * @param jsonStr
     * @param fieldName
     * @return
     */
    public static List<String> findValuesFromJsonStr(String jsonStr, String fieldName, String ... ignores) {
        List<String> values = new ArrayList<>();
        try {
            Assert.hasText(jsonStr, "jsonStr is empty");
            Assert.hasText(fieldName, "fieldName is empty");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonStr);
            List<JsonNode> fileds = node.findValues(fieldName);
            if (CollectionUtils.isEmpty(fileds)) {
                return values;
            }

            List<String> ignoreList = new ArrayList<>(Arrays.asList(ignores));
            String text;
            for (JsonNode filed : fileds) {
                text = filed.asText();
                if(StringUtils.isBlank(text)){
                    continue;
                }
                if(ignoreList.contains(text)){
                    continue;
                }
                values.add(text);
            }
            return values;
        } catch (Exception ex) {
            log.error("从jsonStr获取值失败, jsonStr is: " + jsonStr + ", fieldName is " + fieldName, ex);
            return values;
        }
    }

    /**
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, String> readFirstLayerJSON2Map(String jsonStr) {
        JaguarAssert.hasContent(jsonStr, "jsonStr is empty");
        JsonNode node = null;

        try {
            node = (new ObjectMapper()).readTree(jsonStr);
        } catch (Exception var5) {
            throw new JaguarException(var5, "将json串转换为Map失败，发生异常");
        }

        Map<String, String> map = new HashMap<>();
        Map.Entry<String, JsonNode> jsonNode = null;
        Iterator iterator = node.fields();

        while(iterator.hasNext()) {
            jsonNode = (Map.Entry)iterator.next();
            if(!jsonNode.getValue().isArray()){
                map.put(jsonNode.getKey(), jsonNode.getValue().asText());
                continue;
            }
            map.put(jsonNode.getKey(), jsonNode.getValue().toString());
        }

        return map;
    }

    public static Map<String, Object> str2Map(String jsonStr) {
        try {
            return new org.codehaus.jackson.map.ObjectMapper().readValue(jsonStr, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonParseException e) {
            log.error("jsonStr转Map失败", e);
        } catch (JsonMappingException e) {
            log.error("jsonStr转Map失败", e);
        } catch (IOException e) {
            log.error("jsonStr转Map失败", e);
        }
        return null;
    }

    public static String convertObj2String(Object obj) {
        try {
            return com.yunrich.monster.common.utils.convert.json.JsonUtils.writeEntiry2JSON(obj);
        } catch (Exception ex) {
            throw new JaguarException("json转换失败");
        }
    }

    public static Object convertJsonString2Object(String jsonStr, Class clazz) {
        try {
            return com.yunrich.monster.common.utils.convert.json.JsonUtils.readJSON2Object(jsonStr, clazz);
        } catch (Exception ex) {
            throw new JaguarException("json转换失败");
        }
    }

    public static String findValueFromJsonStr(String jsonStr, String fieldName) {
        try {
            return com.yunrich.monster.common.utils.convert.json.JsonUtils.findValueFromJsonStr(jsonStr, fieldName);
        } catch (Exception ex) {
            log.error("从jsonStr获取值失败, jsonStr is: " + jsonStr + ", fieldName is " + fieldName, ex);
            return "";
        }
    }

    public static String jsonFormat(String jsonStr) {
        JaguarAssert.hasContent(jsonStr, "jsonStr is empty");
        try {
            Object obj = mapper.readValue(jsonStr, Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    /*public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\new3.json"));
            byte[] buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf);
            fileInputStream.close();
            String json = new String(buf);
            String[] jsons = findJsonsByFieldNameAndValue(json, "analysis_item", "collection");
            System.out.println(jsons);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
