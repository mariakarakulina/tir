package ua.mariia.similatities;

import org.apache.lucene.search.similarities.BasicStats;
import org.apache.lucene.search.similarities.LMSimilarity;
import org.apache.lucene.search.similarities.SimilarityBase;

public class LMMercerSimilarity extends SimilarityBase {

	private final float lambda;

	public LMMercerSimilarity(float lambda) {
		this.lambda = lambda;
	}

	@Override
	protected float score(BasicStats stats, float freq, float docLen) {
		float docProbability = freq / docLen;
		float collectionProbability = stats.getDocFreq() / stats.getNumberOfFieldTokens();
		return (float) Math.log((lambda * docProbability) + (1 - lambda) * collectionProbability);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
