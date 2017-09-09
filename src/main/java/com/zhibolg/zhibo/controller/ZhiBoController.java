package com.zhibolg.zhibo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.MessageAll;
import com.zhibolg.zhibo.entity.Page;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.entity.ZhiBo;
import com.zhibolg.zhibo.service.MessageAllService;
import com.zhibolg.zhibo.service.ZhiBoService;
import com.zhibolg.zhibo.util.UserUtil;

@Controller
@RequestMapping(value = "ZhiBo")
public class ZhiBoController extends ControllerBase{
	private static Log log = LogFactory.getLog(UserController.class);

	/*
	 * 获取直播间信息
	 */
	@Autowired
	private ZhiBoService ZhiBoService;
	
	/*
	 * 获取留言信息
	 */
	@Autowired
	private MessageAllService messageAllService;

	@ModelAttribute
	public Page<ZhiBo> get(@RequestParam(required = false) String index,@RequestParam(required=false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		ZhiBo zhiBo = new ZhiBo();
		if(index == null) { 
			index = 1+"";
		}
		
		//用于分页的时候条件查询
		zhiBo.getPageMap().put("index", index);
		zhiBo.getPageMap().put("name", name);
		
		//获得当前页面与以及总页面
		String no = request.getParameter("pageNo");
		String size = request.getParameter("pageSize");
		
		//创建page实例
		Page<ZhiBo> p = new Page<ZhiBo>(index,no,size);
		p.getPageMap().put("name", name);
		
		//查询当前页面的所有直播间
		Page<ZhiBo> page = ZhiBoService.findPage(p, zhiBo);
		
		return page;
	}

	@RequestMapping(value = "")
	public String ZhiBo(Page<ZhiBo> page, Model model,
			@RequestParam(required=false) String gameId,
			HttpServletRequest request) {
		
		model.addAttribute("page", page);
		/*
		 * 获取当前用户
		 */
		User user = UserUtil.getUser();
		model.addAttribute("user", user);
		
		Page<MessageAll> messageAllPage = getMessageAllPage(request, page.getPageMap().get("index"));
		model.addAttribute("messageAllPage", messageAllPage);
		
		Map<String, List<MessageAll>> messageHuiFuMap = getMessageAllHuiFu(messageAllPage.getResults());
		model.addAttribute("messageHuiFuMap", messageHuiFuMap);
		
		return gameId == null ? "zhibo/zhiBo" : "redirect:/ZhiBo.html?index="+gameId;
	}

	/**
	 * @param results 留言List
	 * @return 每个留言的回复内容list
	 */
	private Map<String, List<MessageAll>> getMessageAllHuiFu(List<MessageAll> results) {
		Map<String, List<MessageAll>> map = new HashMap<String, List<MessageAll>>();
		for(MessageAll m: results){
			String contentId = m.getContentId();
			if(contentId != null && contentId != ""){
				List<MessageAll> list = messageAllService.findListHuiFuByContentId(contentId);
				map.put(m.getContentId(), list);
			}
		}
		return map;
	}

	/**
	 * 获取留言分页信息
	 * @param request 存储页码
	 * @param index 游戏栏目
	 * @return 查询出当前页面的留言 并返回
	 */
	private Page<MessageAll> getMessageAllPage(HttpServletRequest request, String index) {
		
		//用于分页的时候条件查询
		MessageAll messageAll = new MessageAll();
		messageAll.getPageMap().put("index", index);
	
		//获得当前页面与以及总页面
		String no = request.getParameter("messageAllpageNo");
		String size = request.getParameter("messageAllpageSize");
		
		//创建page实例
		Page<MessageAll> mpage = new Page<MessageAll>(index,no,size);
		mpage.setFuncName("messageAllPage");
		mpage.setPageSize(8);
		
		return messageAllService.findPage(mpage, messageAll);
	}
}
