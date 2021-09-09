package ru.popov.testForAlfa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GiphyData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_original_url")
    private String imageOriginalUrl;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("image_mp4_url")
    private String imageMp4Url;

    @JsonProperty("image_frames")
    private String imageFrames;

    @JsonProperty("image_width")
    private String imageWidth;

    @JsonProperty("image_height")
    private String imageHeight;

    @JsonProperty("fixed_height_downsampled_url")
    private String fixedHeightDownsampledUrl;

    @JsonProperty("fixed_height_downsampled_width")
    private String fixedHeightDownsampledWidth;

    @JsonProperty("fixed_height_downsampled_height")
    private String fixedHeightDownsampledHeight;

    @JsonProperty("fixed_width_downsampled_url")
    private String fixedWidthDownsampledUrl;

    @JsonProperty("fixed_width_downsampled_width")
    private String fixedWidthDownsampledWidth;

    @JsonProperty("fixed_width_downsampled_height")
    private String fixedWidthDownsampledHeight;

    @JsonProperty("fixed_height_small_url")
    private String fixedHeightSmallUrl;

    @JsonProperty("fixed_height_small_still_url")
    private String fixedHeightSmallStillUrl;

    @JsonProperty("fixed_height_small_width")
    private String fixedHeightSmallWidth;

    @JsonProperty("fixed_height_small_height")
    private String fixedHeightSmallHeight;

    @JsonProperty("fixed_width_small_url")
    private String fixedWidthSmallUrl;

    @JsonProperty("fixed_width_small_still_url")
    private String fixedWidthSmallStillUrl;

    @JsonProperty("fixed_width_small_width")
    private String fixedWidthSmallWidth;

    @JsonProperty("fixed_width_small_height")
    private String fixedWidthSmallHeight;
}
