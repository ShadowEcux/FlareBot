package stream.flarebot.flarebot.permissions;

import org.eclipse.jetty.util.ConcurrentHashSet;

import java.util.Set;


public class Group {

    private final Set<String> permissions = new ConcurrentHashSet<>();
    private String name;
    private String roleId;

    private Group() {
    }

    Group(String name) {
        this.name = name;
    }


    public Set<String> getPermissions() {
        return permissions;
    }

    public String getName() {
        return name;
    }

    public boolean addPermission(String permission) {
        return permissions.add(permission);
    }

    public boolean removePermission(String permission) {
        return permissions.remove(permission);
    }

    public Permission.Reply hasPermission(Permission permission) {
        for (String s : permissions) {
            if (s.startsWith("-")) {
                if (new PermissionNode(s.substring(1)).test(permission.getPermission()))
                    return Permission.Reply.DENY;
            }
            if (new PermissionNode(s).test(permission.getPermission()))
                return Permission.Reply.ALLOW;
        }
        return Permission.Reply.NEUTRAL;
    }

    public void linkRole(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }
}
