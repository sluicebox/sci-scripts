;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 352)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	baseCampMap 0
)

(instance baseCampMap of AutoMapInset
	(properties
		picture 352
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2001 ; baseCampTent1
				(param1 posn: 420 60)
			)
			(2002 ; baseCamp2
				(param1 posn: 394 87)
			)
			(2003 ; baseCamp3
				(param1 posn: 346 123)
			)
			(2004 ; baseCamp4
				(param1 posn: 298 185)
			)
			(2005 ; baseCamp5
				(param1 posn: 235 159)
			)
			(2006 ; baseCampFridge
				(param1 posn: 321 232)
			)
			(2007 ; baseCampBasket
				(param1 posn: 289 218)
			)
			(2008 ; BCCableCar
				(param1 posn: 241 200)
			)
			(2009 ; baseCampTable
				(param1 posn: 235 159)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

