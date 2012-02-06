package com.mediapp.web.common;

import java.util.Map;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.mediapp.domain.common.Person;

/**
 * When using a Spring Controller that is ignorant of media types, the resulting model
 * objects end up in a map as values. The MappingJacksonJsonView then converts this map
 * to JSON, which (possibly) incorrectly wraps the single model object in the map
 * entry's key. This class eliminates this wrapper element if there is only one model
 * object.
 */
public class SimpleJacksonJsonView extends MappingJacksonJsonView {

    @Override
    @SuppressWarnings("unchecked")
/*    protected Object filterModel(Map<String, Object> model) {
        Map<String, Object> filteredModel = (Map<String, Object>) super.filterModel(model);
        if(filteredModel.size() != 1) return filteredModel;
        return filteredModel.entrySet().iterator().next().getValue();
    }
*/
    protected Object filterModel(Map<String, Object> model)
    {
       Object result = super.filterModel(model);
       if (!(result instanceof Map))
       {
          return result;
       }
       Map map = (Map) result;
       if (map.size() == 1)
       {
          return map.values().toArray()[0];
       }
       return map;
    }

}