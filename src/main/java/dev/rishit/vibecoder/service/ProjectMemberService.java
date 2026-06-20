package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.member.InviteMemberRequest;
import dev.rishit.vibecoder.dto.member.MemberResponse;
import dev.rishit.vibecoder.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
