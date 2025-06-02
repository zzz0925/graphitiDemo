// graphitiDemo/src/main/java/com/chat/entity/neo4j/ConversationNode.java
package com.chat.entity.neo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

@Node("Conversation")
@Data
public class ConversationNode {
    @Id
    private String sessionId; // 使用 sessionId 作为 Neo4j 节点的 ID

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @Relationship(type = "HAS_MESSAGE", direction = Relationship.Direction.OUTGOING)
    private List<MessageNode> messages; // 确保 Neo4j 中的关系类型确实是 "HAS_MESSAGE"
}