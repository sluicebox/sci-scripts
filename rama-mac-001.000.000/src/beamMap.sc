;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 353)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	beamMap 0
)

(instance beamMap of AutoMapInset
	(properties
		picture 353
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2040 ; BeamRgn1
				(param1 posn: 216 194)
			)
			(2041 ; BeamRgn2
				(param1 posn: 282 180)
			)
			(2042 ; BeamRgn3
				(param1 posn: 311 203)
			)
			(2043 ; BeamRgn4
				(param1 posn: 258 124)
			)
			(2045 ; BeamRgn6
				(param1 posn: 349 140)
			)
			(2046 ; BeamRgn7
				(param1 posn: 378 162)
			)
			(2047 ; BeamRgn8
				(param1 posn: 402 183)
			)
			(2049 ; BeamRgn10
				(param1 posn: 410 119)
			)
			(2051 ; BeamRgn12
				(param1 posn: 482 113)
			)
			(2052 ; BiotHanger1
				(param1 posn: 385 192)
			)
			(2053 ; BiotHanger2
				(param1 posn: 376 197)
			)
			(2054 ; BiotHanger3
				(param1 posn: 364 203)
			)
			(2055 ; trashBin
				(param1 posn: 311 203)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

