package com.hotel_pattern.utility;

import java.util.List;

/**
 *
 * @author Anthony
 */
public interface DaoService<E> {

    int addData(E object);

    int updateData(E object);

    int deleteData(E object);

    List<E> showAllData();
}
