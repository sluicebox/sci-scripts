;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 365)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	londonOutsideMap 0
)

(instance londonOutsideMap of AutoMapInset
	(properties
		picture 365
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2060 ; CPLondon1
				(param1 posn: 349 268)
			)
			(2061 ; CPLondon2
				(param1 posn: 292 241)
			)
			(2062 ; CPLondon3
				(param1 posn: 281 216)
			)
			(2064 ; CPLondon5
				(param1 posn: 288 108)
			)
			(2065 ; CPLondon6
				(param1 posn: 200 122)
			)
			(3001 ; london_1
				(param1 posn: 440 117)
			)
			(3009 ; london_Door_1
				(param1 posn: 440 117)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

