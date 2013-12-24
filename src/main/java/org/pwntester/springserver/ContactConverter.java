package org.pwntester.springserver;

/**
 * Created by alvaro on 24/12/13.
 */
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ContactConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return clazz.equals(ContactImpl.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Contact contact = (Contact) value;
        writer.startNode("name");
        writer.setValue(contact.getFirstName());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Contact contact = new ContactImpl();
        reader.moveDown();
        contact.setFirstName(reader.getValue());
        reader.moveUp();
        return contact;
    }

}
