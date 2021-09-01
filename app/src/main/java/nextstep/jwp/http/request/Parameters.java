package nextstep.jwp.http.request;

import java.util.HashMap;
import java.util.Map;

public class Parameters {

    private static final String KEY_VALUE_SEPARATOR = "=";

    Map<String, String> parameters = new HashMap<>();

    public Parameters(String requestUri, String body) {
        parseRequestUri(requestUri);
        parseBody(body);
    }

    private void parseBody(String body) {
        if (body.equals("")) {
            return;
        }
        parseKeyValue(body);
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }

    private void parseRequestUri(String requestUri) {
        int index = requestUri.indexOf("?");

        if (index > -1) {
            String queryString = requestUri.substring(index + 1);
            parseKeyValue(queryString);
        }
    }

    private void parseKeyValue(String keyValueString) {
        String[] splitQueryString = keyValueString.split("&");

        for (String queryString : splitQueryString) {
            splitQueryString = queryString.split(KEY_VALUE_SEPARATOR);
            parameters.put(splitQueryString[0], splitQueryString[1]);
        }
    }

}



