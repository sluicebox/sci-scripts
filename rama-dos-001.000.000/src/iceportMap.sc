;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 354)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	iceportMap 0
)

(instance iceportMap of AutoMapInset
	(properties
		picture 354
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2100 ; CPIceport1
				(param1 posn: 117 87)
			)
			(2101 ; CPIceport2
				(param1 posn: 270 77)
			)
			(2102 ; CPIceport3
				(param1 posn: 357 98)
			)
			(2103 ; CPIceport4
				(param1 posn: 408 111)
			)
			(2104 ; CPIceport5
				(param1 posn: 364 123)
			)
			(2105 ; CPIceport6
				(param1 posn: 452 116)
			)
			(2106 ; CPIceport7
				(param1 posn: 281 201)
			)
			(2107 ; CPIceport8
				(param1 posn: 307 221)
			)
			(2108 ; bombCloseUp
				(param1 posn: 364 123)
			)
			(2109 ; icemobileCU
				(param1 posn: 338 212)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

