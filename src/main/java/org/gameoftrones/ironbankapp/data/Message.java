package org.gameoftrones.ironbankapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Message {
    private String author;
    private String content;
}
