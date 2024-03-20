package com.interviewpanel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminToInterviewPanelRepository {
    // stores the adminid and the ids of interview panel created by that admin
    private Map<Integer, List<Integer>> adminToInterviewPanel = new HashMap<>();
    private static AdminToInterviewPanelRepository instance;
    private AdminToInterviewPanelRepository() {}

    public static AdminToInterviewPanelRepository getInstance() {
        if(instance == null) {
            instance = new AdminToInterviewPanelRepository();
        }
        return instance;
    }

    public void addAdminToInterviewPanel(int adminId, int interviewPanelId) {
        if(adminToInterviewPanel.containsKey(adminId)) {
            adminToInterviewPanel.get(adminId).add(interviewPanelId);
        } else {
            List<Integer> interviewPanelIds = new ArrayList<>();
            interviewPanelIds.add(interviewPanelId);
            adminToInterviewPanel.put(adminId, interviewPanelIds);
        }
    }

    public List<Integer> getInterviewPanelsByAdminId(int adminId) {
        return adminToInterviewPanel.get(adminId);
    }
}
