package nonreg.svg;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
Test diagram MUST be put between triple quotes

"""
@startuml
' The rendered groups with a <title> are
' for the swimlanes, so should always have
' `fill-opacity="0.00000"`

' Should render: `<rect fill="none" .../>`
participant transparent_keyword #transparent

' Should render: `<rect fill="none" .../>`
participant white_with_zero_alpha #FFFFFF00
participant black_with_zero_alpha #00000000
participant gray_with_zero_alpha #CCCCCC00

' Should render: `<rect fill="{color}" fill-opacity="0.00392" .../>`
participant white_with_low_alpha #FFFFFF01
participant black_with_low_alpha #00000001
participant gray_with_low_alpha #CCCCCC01

' Should render: `<rect fill="{color}" fill-opacity="0.99608" .../>`
participant white_with_high_alpha #FFFFFFFE
participant black_with_high_alpha #000000FE
participant gray_with_high_alpha #CCCCCCFE

' Should render: `<rect fill="{color}" .../>`
participant white_with_full_alpha #FFFFFFFF
participant black_with_full_alpha #000000FF
participant gray_with_full_alpha #CCCCCCFF

' Should render: `<rect fill="{color}" .../>`
participant white_with_unspecified_alpha #FFFFFF
participant black_with_unspecified_alpha #000000
participant gray_with_unspecified_alpha #CCCCCC

white_with_zero_alpha -> black_with_zero_alpha: Hello
@enduml
"""

Expected result MUST be put between triple brackets

{{{
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" data-diagram-type="SEQUENCE" preserveAspectRatio="none" version="1.1" zoomAndPan="magnify">
  <defs/>
  <g>
    <g class="participant-lifeline" data-entity-uid="part1" data-qualified-name="transparent_keyword" data-source-line="6" id="part1-lifeline">
      <g>
        <title>transparent_keyword</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part2" data-qualified-name="white_with_zero_alpha" data-source-line="9" id="part2-lifeline">
      <g>
        <title>white_with_zero_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part3" data-qualified-name="black_with_zero_alpha" data-source-line="10" id="part3-lifeline">
      <g>
        <title>black_with_zero_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part4" data-qualified-name="gray_with_zero_alpha" data-source-line="11" id="part4-lifeline">
      <g>
        <title>gray_with_zero_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part5" data-qualified-name="white_with_low_alpha" data-source-line="14" id="part5-lifeline">
      <g>
        <title>white_with_low_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part6" data-qualified-name="black_with_low_alpha" data-source-line="15" id="part6-lifeline">
      <g>
        <title>black_with_low_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part7" data-qualified-name="gray_with_low_alpha" data-source-line="16" id="part7-lifeline">
      <g>
        <title>gray_with_low_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part8" data-qualified-name="white_with_high_alpha" data-source-line="19" id="part8-lifeline">
      <g>
        <title>white_with_high_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part9" data-qualified-name="black_with_high_alpha" data-source-line="20" id="part9-lifeline">
      <g>
        <title>black_with_high_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part10" data-qualified-name="gray_with_high_alpha" data-source-line="21" id="part10-lifeline">
      <g>
        <title>gray_with_high_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part11" data-qualified-name="white_with_full_alpha" data-source-line="24" id="part11-lifeline">
      <g>
        <title>white_with_full_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part12" data-qualified-name="black_with_full_alpha" data-source-line="25" id="part12-lifeline">
      <g>
        <title>black_with_full_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part13" data-qualified-name="gray_with_full_alpha" data-source-line="26" id="part13-lifeline">
      <g>
        <title>gray_with_full_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part14" data-qualified-name="white_with_unspecified_alpha" data-source-line="29" id="part14-lifeline">
      <g>
        <title>white_with_unspecified_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part15" data-qualified-name="black_with_unspecified_alpha" data-source-line="30" id="part15-lifeline">
      <g>
        <title>black_with_unspecified_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant-lifeline" data-entity-uid="part16" data-qualified-name="gray_with_unspecified_alpha" data-source-line="31" id="part16-lifeline">
      <g>
        <title>gray_with_unspecified_alpha</title>
        <rect fill="#000000" fill-opacity="0.00000"/>
        <line style="stroke:#181818;stroke-width:0.5;stroke-dasharray:5,5;"/>
      </g>
    </g>
    <g class="participant participant-head" data-entity-uid="part1" data-qualified-name="transparent_keyword" data-source-line="6" id="part1-head">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">transparent_keyword</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part1" data-qualified-name="transparent_keyword" data-source-line="6" id="part1-tail">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">transparent_keyword</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part2" data-qualified-name="white_with_zero_alpha" data-source-line="9" id="part2-head">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_zero_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part2" data-qualified-name="white_with_zero_alpha" data-source-line="9" id="part2-tail">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_zero_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part3" data-qualified-name="black_with_zero_alpha" data-source-line="10" id="part3-head">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_zero_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part3" data-qualified-name="black_with_zero_alpha" data-source-line="10" id="part3-tail">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_zero_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part4" data-qualified-name="gray_with_zero_alpha" data-source-line="11" id="part4-head">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_zero_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part4" data-qualified-name="gray_with_zero_alpha" data-source-line="11" id="part4-tail">
      <rect fill="none" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_zero_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part5" data-qualified-name="white_with_low_alpha" data-source-line="14" id="part5-head">
      <rect fill="#FFFFFF" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_low_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part5" data-qualified-name="white_with_low_alpha" data-source-line="14" id="part5-tail">
      <rect fill="#FFFFFF" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_low_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part6" data-qualified-name="black_with_low_alpha" data-source-line="15" id="part6-head">
      <rect fill="#000000" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_low_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part6" data-qualified-name="black_with_low_alpha" data-source-line="15" id="part6-tail">
      <rect fill="#000000" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_low_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part7" data-qualified-name="gray_with_low_alpha" data-source-line="16" id="part7-head">
      <rect fill="#CCCCCC" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_low_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part7" data-qualified-name="gray_with_low_alpha" data-source-line="16" id="part7-tail">
      <rect fill="#CCCCCC" fill-opacity="0.00392" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_low_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part8" data-qualified-name="white_with_high_alpha" data-source-line="19" id="part8-head">
      <rect fill="#FFFFFF" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_high_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part8" data-qualified-name="white_with_high_alpha" data-source-line="19" id="part8-tail">
      <rect fill="#FFFFFF" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_high_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part9" data-qualified-name="black_with_high_alpha" data-source-line="20" id="part9-head">
      <rect fill="#000000" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_high_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part9" data-qualified-name="black_with_high_alpha" data-source-line="20" id="part9-tail">
      <rect fill="#000000" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_high_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part10" data-qualified-name="gray_with_high_alpha" data-source-line="21" id="part10-head">
      <rect fill="#CCCCCC" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_high_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part10" data-qualified-name="gray_with_high_alpha" data-source-line="21" id="part10-tail">
      <rect fill="#CCCCCC" fill-opacity="0.99608" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_high_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part11" data-qualified-name="white_with_full_alpha" data-source-line="24" id="part11-head">
      <rect fill="#FFFFFF" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_full_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part11" data-qualified-name="white_with_full_alpha" data-source-line="24" id="part11-tail">
      <rect fill="#FFFFFF" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_full_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part12" data-qualified-name="black_with_full_alpha" data-source-line="25" id="part12-head">
      <rect fill="#000000" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_full_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part12" data-qualified-name="black_with_full_alpha" data-source-line="25" id="part12-tail">
      <rect fill="#000000" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_full_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part13" data-qualified-name="gray_with_full_alpha" data-source-line="26" id="part13-head">
      <rect fill="#CCCCCC" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_full_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part13" data-qualified-name="gray_with_full_alpha" data-source-line="26" id="part13-tail">
      <rect fill="#CCCCCC" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_full_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part14" data-qualified-name="white_with_unspecified_alpha" data-source-line="29" id="part14-head">
      <rect fill="#FFFFFF" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_unspecified_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part14" data-qualified-name="white_with_unspecified_alpha" data-source-line="29" id="part14-tail">
      <rect fill="#FFFFFF" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">white_with_unspecified_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part15" data-qualified-name="black_with_unspecified_alpha" data-source-line="30" id="part15-head">
      <rect fill="#000000" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_unspecified_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part15" data-qualified-name="black_with_unspecified_alpha" data-source-line="30" id="part15-tail">
      <rect fill="#000000" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">black_with_unspecified_alpha</text>
    </g>
    <g class="participant participant-head" data-entity-uid="part16" data-qualified-name="gray_with_unspecified_alpha" data-source-line="31" id="part16-head">
      <rect fill="#CCCCCC" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_unspecified_alpha</text>
    </g>
    <g class="participant participant-tail" data-entity-uid="part16" data-qualified-name="gray_with_unspecified_alpha" data-source-line="31" id="part16-tail">
      <rect fill="#CCCCCC" style="stroke:#181818;stroke-width:0.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">gray_with_unspecified_alpha</text>
    </g>
    <g class="message" data-entity-1="part2" data-entity-2="part3" data-source-line="33" id="msg1">
      <polygon fill="#181818" style="stroke:#181818;stroke-width:1;"/>
      <line style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">Hello</text>
    </g>
  </g>
</svg>
}}}

 */
public class SVG0003_Test extends SvgTest {

	@Test
	void testSequenceDiagramUsesCorrectNonOpaqueColours() throws IOException {
		checkXmlAndDescription("(16 participants)");
	}

}
