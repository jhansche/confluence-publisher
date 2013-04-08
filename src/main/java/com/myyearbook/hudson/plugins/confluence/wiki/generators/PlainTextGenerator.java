
package com.myyearbook.hudson.plugins.confluence.wiki.generators;

import hudson.Extension;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.Descriptor;

import java.util.List;

import jenkins.plugins.confluence.soap.v1.RemoteAttachment;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Content generator that takes plain text input from the Job configuration. Any
 * build variables will be replaced.
 *
 * @author Joe Hansche <jhansche@myyearbook.com>
 */
public class PlainTextGenerator extends MarkupGenerator {
    public final String text;

    @DataBoundConstructor
    public PlainTextGenerator(final String text) {
        this.text = text;
    }

    @Override
    public Descriptor<MarkupGenerator> getDescriptor() {
        return super.getDescriptor();
    }

    @Override
	public String generateMarkup(AbstractBuild<?, ?> build,
			BuildListener listener, List<RemoteAttachment> remoteAttachments) {
    	return expand(build, listener, this.text, remoteAttachments);
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<MarkupGenerator> {
        @Override
        public String getDisplayName() {
            return "Plain text";
        }
    }
}
