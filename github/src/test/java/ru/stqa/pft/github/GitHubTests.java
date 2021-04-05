package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("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");
        RepoCommits commits = github.repos().get(new Coordinates
                .Simple("tradeurcasl", "java_for_qa")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
