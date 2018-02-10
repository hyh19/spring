package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "AutoCorrectFilter", urlPatterns = {"/*"})
public class AutoCorrectFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        AutoCorrectHttpServletRequestWrapper wrapper = new AutoCorrectHttpServletRequestWrapper(httpServletRequest);
        chain.doFilter(wrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    class AutoCorrectHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private HttpServletRequest httpServletRequest;

        public AutoCorrectHttpServletRequestWrapper(HttpServletRequest httpServletRequest) {
            super(httpServletRequest);
            this.httpServletRequest = httpServletRequest;
        }

        @Override
        public String getParameter(String name) {
            return autoCorrect(httpServletRequest.getParameter(name));
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            final Map<String, String[]> parameterMap =
                    httpServletRequest.getParameterMap();

            Map<String, String[]> newMap = new Map<String,
                    String[]>() {

                public int size() {
                    return parameterMap.size();
                }

                public boolean isEmpty() {
                    return parameterMap.isEmpty();
                }

                public boolean containsKey(Object key) {
                    return parameterMap.containsKey(key);
                }

                public boolean containsValue(Object value) {
                    return parameterMap.containsValue(value);
                }

                public String[] get(Object key) {
                    return autoCorrect(parameterMap.get(key));
                }

                public void clear() {
                    // this will throw an IllegalStateException,
                    // but let the user get the original
                    // exception
                    parameterMap.clear();
                }

                public Set<String> keySet() {
                    return parameterMap.keySet();
                }

                public Collection<String[]> values() {
                    return autoCorrect(parameterMap.values());
                }

                public Set<Map.Entry<String,
                        String[]>> entrySet() {
                    return autoCorrect(parameterMap.entrySet());
                }

                public String[] put(String key, String[] value) {
                    // this will throw an IllegalStateException,
                    // but let the user get the original
                    // exception
                    return parameterMap.put(key, value);
                }

                public void putAll(
                        Map<? extends String, ? extends
                                String[]> map) {
                    // this will throw an IllegalStateException,
                    // but let
                    // the user get the original exception
                    parameterMap.putAll(map);
                }

                public String[] remove(Object key) {
                    // this will throw an IllegalStateException,
                    // but let
                    // the user get the original exception
                    return parameterMap.remove(key);
                }
            };
            return newMap;
        }

        @Override
        public String[] getParameterValues(String name) {
            return autoCorrect(httpServletRequest.getParameterValues(name));
        }
    }

    private String autoCorrect(String value) {
        if (value == null) {
            return null;
        }
        value = value.trim();
        int length = value.length();
        StringBuilder temp = new StringBuilder();
        boolean lastCharWasSpace = false;
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            if (c == ' ') {
                if (!lastCharWasSpace) {
                    temp.append(c);
                }
                lastCharWasSpace = true;
            } else {
                temp.append(c);
                lastCharWasSpace = false;
            }
        }
        return temp.toString();
    }

    private String[] autoCorrect(String[] values) {
        if (values != null) {
            int length = values.length;
            for (int i = 0; i < length; i++) {
                values[i] = autoCorrect(values[i]);
            }
            return values;
        }
        return null;
    }

    private Collection<String[]> autoCorrect(
            Collection<String[]> valueCollection) {
        Collection<String[]> newCollection =
                new ArrayList<String[]>();
        for (String[] values : valueCollection) {
            newCollection.add(autoCorrect(values));
        }
        return newCollection;
    }

    private Set<Map.Entry<String, String[]>> autoCorrect(
            Set<Map.Entry<String, String[]>> entrySet) {
        Set<Map.Entry<String, String[]>> newSet = new
                HashSet<Map.Entry<String, String[]>>();
        for (final Map.Entry<String, String[]> entry
                : entrySet) {
            Map.Entry<String, String[]> newEntry = new
                    Map.Entry<String, String[]>() {
                        public String getKey() {
                            return entry.getKey();
                        }

                        public String[] getValue() {
                            return autoCorrect(entry.getValue());
                        }

                        public String[] setValue(String[] value) {
                            return entry.setValue(value);
                        }
                    };
            newSet.add(newEntry);
        }
        return newSet;
    }

}
