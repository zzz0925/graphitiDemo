// graphitiDemo/src/main/java/com/chat/repository/neo4j/ConversationNodeRepository.java
package com.chat.repository.neo4j;

import com.chat.entity.neo4j.ConversationNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface ConversationNodeRepository extends Neo4jRepository<ConversationNode, String> {

    @Query("MATCH (n)-[r]->(m) " +
            "RETURN {id: id(n), labels: labels(n), properties: properties(n)} AS node1, " +
            "{id: id(m), labels: labels(m), properties: properties(m)} AS node2, " +
            "{id: id(r), type: type(r), startNode: id(startNode(r)), endNode: id(endNode(r)), properties: properties(r)} AS relationship")
    List<Map<String, Object>> findAllGraphElementsRaw();

    @Query("MATCH (c:Conversation)-[r:HAS_MESSAGE]->(m:Message) " +
            "RETURN c AS conversation, COLLECT(m) AS messages, r AS relationship")
    List<Map<String, Object>> findConversationsWithMessagesAndRelationships();
}