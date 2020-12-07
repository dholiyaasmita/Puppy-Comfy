package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T finfById(ID id){
        return  map.get(id);
    }

    T save(T object){
        if (object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }
        else{
            throw new RuntimeException("object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private long getNextId(){
        Long nextID = null;
        try{
            nextID = Collections.max(map.keySet()) +1;
        }catch (NoSuchElementException e){
         nextID = 1L;
        }
        return nextID;
    }

}
