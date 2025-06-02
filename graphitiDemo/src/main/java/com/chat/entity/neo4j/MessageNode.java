// graphitiDemo/src/main/java/com/chat/entity/neo4j/MessageNode.java
package com.chat.entity.neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;

@Node("Message")
@Data
public class MessageNode {
    @Id @GeneratedValue
    private Long id; // Neo4j 内部ID

    private String role;
    private String content;
    private LocalDateTime timestamp; // 消息时间

    @Relationship(type = "REPLIES_TO", direction = Relationship.Direction.OUTGOING)
    private MessageNode repliesTo; // 如果是回答某个消息
}