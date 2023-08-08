package xyz.applebox.batch.part3;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class CustomItemReader<T> implements ItemReader<T> {
    private final List<T> items;

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(!items.isEmpty()) {
            return items.remove(0);
        }
        return null;
    }
}