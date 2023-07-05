;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 366)
(include sci.sh)
(use Main)
(use AutoMapProp)
(use n1111)
(use Actor)

(public
	hubSiteMap 0
)

(instance hubSiteMap of AutoMapInset
	(properties
		picture 366
	)

	(method (init)
		(super init: &rest)
		(cableCar init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(1000 ; hubCamp0
				(param1 posn: 250 69)
			)
			(1001 ; hubCamp1
				(param1 posn: 208 70)
			)
			(1002 ; hubCamp2
				(param1 posn: 223 77)
			)
			(1003 ; hubCamp3
				(param1 posn: 255 85)
			)
			(1004 ; hubCamp4
				(param1 posn: 276 95)
			)
			(1005 ; hubCamp5
				(param1 posn: 201 81)
			)
			(1006 ; hubCamp6
				(param1 posn: 240 90)
			)
			(1007 ; hubCamp7
				(param1 posn: 240 104)
			)
			(1008 ; hubCamp8
				(param1 posn: 204 210)
			)
			(1009 ; hubCamp9
				(param1 posn: 191 207)
			)
			(1010 ; hubCampLocker1
				(param1 posn: 223 77)
			)
			(1011 ; hubCampLocker2
				(param1 posn: 223 77)
			)
			(1012 ; hubCampLocker3
				(param1 posn: 223 77)
			)
			(1016 ; hubCampLocker4
				(param1 posn: 223 77)
			)
			(1013
				(param1 posn: 276 95)
			)
			(1014 ; hubCampBomb
				(param1 posn: 191 207)
			)
			(1020 ; hubCableCar
				(param1 posn: 253 104)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance cableCar of View
	(properties
		x 256
		y 102
		priority 1
		fixPriority 1
		view 366
	)

	(method (init)
		(if (IsFlag 79)
			(return)
		)
		(super init: &rest)
	)
)

