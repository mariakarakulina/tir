package ua.mariia.similatities;

import org.apache.lucene.search.similarities.BasicStats;
import org.apache.lucene.search.similarities.SimilarityBase;

public class LMDirichletSimilarity extends SimilarityBase {

	private final float mu;

	public LMDirichletSimilarity(float mu) {
		this.mu = mu;
	}

	@Override
	protected float score(BasicStats stats, float freq, float docLen) {
		float collectProbability = stats.getTotalTermFreq() / stats.getNumberOfFieldTokens();
		return (float) Math.log((freq + mu * collectProbability) / (docLen + mu));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
