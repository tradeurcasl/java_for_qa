package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups(Collection<GroupData> groups) {
        this.delegate = new HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    public Groups without(GroupData group){
        Groups groups= new Groups(this);
        groups.remove(group);
        return groups;
    }

    public Groups withAdded(GroupData group){
        Groups groups= new Groups(this);
        groups.add(group);
        return groups;
    }

}