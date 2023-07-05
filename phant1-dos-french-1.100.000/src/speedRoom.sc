;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
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

	(method (init &tmp temp0)
		(LoadMany rsVIEW 64980)
		(super init:)
		(= gHowFast (SpeedTest))
		(= global158 4)
		(gGame
			detailLevel:
				(cond
					((> gHowFast 7) 3)
					((> gHowFast 5) 7)
					(else 14)
				)
		)
		(gCurRoom newRoom: global108)
	)
)

