;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use SpeedTest)
(use LoadMany)
(use Game)

(public
	speedRoom 0
)

(instance speedRoom of Room
	(properties)

	(method (init)
		(Platform 0 2 1)
		(LoadMany rsVIEW 64980)
		(super init:)
		(= gHowFast (SpeedTest))
		(gGame
			detailLevel:
				(cond
					((> gHowFast 7) 3)
					((> gHowFast 5) 7)
					(else 14)
				)
		)
		(gEgo setSpeed: (= global112 4))
		(gCurRoom newRoom: global111)
	)
)

