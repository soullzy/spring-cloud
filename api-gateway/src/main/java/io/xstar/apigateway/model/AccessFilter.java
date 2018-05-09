package io.xstar.apigateway.model;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Zuul过滤器
 * @author Li Zhengyue
 * @date 2018/4/11
 * @since JDK1.8
 */
public class AccessFilter extends ZuulFilter {
  private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

  /**
   * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行
   * pre、route、post
   * @return
   */
  @Override public String filterType() {
    return "pre";
  }

  /**
   * 过滤器的执行顺序，数字越大优先级越低
   * @return
   */
  @Override public int filterOrder() {
    return 0;
  }

  /**
   * 判断该过滤器是否需要被执行
   * @return
   */
  @Override public boolean shouldFilter() {
    return true;
  }

  @Override public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

    Object token = request.getParameter("Authorization");
    if (token == null) {
      log.warn("access token is empty");
      //设置zuul过滤该请求，不对其进行路由
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      ctx.setResponseBody("authentication invalid");
      return null;
    }
    log.info("access token ok");
    return null;
  }
}
