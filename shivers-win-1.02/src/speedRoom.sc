;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 942)
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
		(LoadMany rsVIEW 64980)
		(super init:)
		(= gHowFast (SpeedTest))
		(PrintDebug {howFast = %d} gHowFast)
		(gGame detailLevel: gHowFast)
		(gCurRoom newRoom: global101)
	)
)

