package com.lyft.data.gateway.ha.router;

import javax.servlet.http.HttpServletRequest;

/** RoutingGroupSelector provides a way to match an HTTP request to a Gateway routing group. */
public interface RoutingGroupSelector {
  String ROUTING_GROUP_HEADER = "X-Presto-Routing-Group";

  /**
   * Routing group selector that relies on the X-Presto-Routing-Group header to determine the right
   * routing group.
   */
  static RoutingGroupSelector byRoutingGroupHeader() {
    return request -> request.getHeader(ROUTING_GROUP_HEADER);
  }

  /**
   * Given an HTTP request find a routing group to direct the request to. If a routing group cannot
   * be determined return null.
   */
  String findRoutingGroup(HttpServletRequest request);
}
