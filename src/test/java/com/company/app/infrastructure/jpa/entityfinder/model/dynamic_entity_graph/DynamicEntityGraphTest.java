package com.company.app.infrastructure.jpa.entityfinder.model.dynamic_entity_graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DynamicEntityGraphTest {

    @Test
    void test_success_create() {
        DynamicEntityGraph dynamicEntityGraph = new DynamicEntityGraph()
            .with("type")
            .with("status")
            .with("child", "child_field");

        Assertions.assertEquals(3, dynamicEntityGraph.getEntityGraphNodes().size());
    }

    @Test
    void test_negative_create() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new DynamicEntityGraph().with());
    }

    @Test
    void test_create_root() {
        DynamicEntityGraph dynamicEntityGraph = new DynamicEntityGraph()
            .with("1")
            .with("2")
            .with("3")
            .with("1", "1.1")
            .with("2", "2.1")
            .with("3", "3.1")
            .with("1", "1.1", "1.2")
            .with("1", "1.1", "1.3")
            .with("2", "2.1", "2.2")
            .with("2", "2.1", "2.3")
            .with("2", "2.1", "2.4")
            .with("3", "3.1", "3.2");

        EntityGraphNode root = dynamicEntityGraph.createTreeAndGetRoot();
        Assertions.assertEquals("root", root.getName());
        Assertions.assertEquals(3, root.getNodeList().size());
    }

}