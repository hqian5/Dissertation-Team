package org.dissertation.airline.common;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.objenesis.instantiator.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class CommonRowMapper<T> implements RowMapper<T> {
    private static final Logger logger = LoggerFactory.getLogger(ColumnMapRowMapper.class);
    private Converter<String, String> converter =
            CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);

    private Class<T> clazz;
    public CommonRowMapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    private String convert(String field) {
        return converter.convert(field);
    }


    private void set(Method writeMethod, T entity, ResultSet resultSet, String column) throws SQLException, InvocationTargetException, IllegalAccessException {
        Class clz = writeMethod.getParameters()[0].getType();
        if (clz == int.class){
            writeMethod.invoke(entity, resultSet.getInt(column));
        } else if (clz == long.class) {
            writeMethod.invoke(entity, resultSet.getLong(column));
        } else if (clz == String.class) {
            writeMethod.invoke(entity, resultSet.getString(column));
        } else if (clz == Time.class){
            writeMethod.invoke(entity, resultSet.getTime(column));
        }
    }

    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        try {
            T entity = ClassUtils.newInstance(this.clazz);
            BeanInfo beanInfo = Introspector.getBeanInfo(this.clazz, Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                String column = convert(pd.getName());
                Method writeMethod = pd.getWriteMethod();
                if (writeMethod!= null && !Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                    writeMethod.setAccessible(true);
                }
                try {
                    set(writeMethod, entity, resultSet, column);
                } catch (Exception e) {
                    logger.warn(e.getMessage(), e);
                }
            }
            return entity;
        } catch(Exception e){
            throw new SQLException(e);
        }
    }

}
