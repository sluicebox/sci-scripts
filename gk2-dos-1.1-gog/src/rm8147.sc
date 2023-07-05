;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8147)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)
(use System)

(public
	rm8147 0
)

(instance rm8147 of ExitRoom
	(properties
		picture 8147
		south 810 ; rm810
	)

	(method (init)
		(super init: &rest)
		(ludwigPic init:)
		(self setScript: sInit)
	)
)

(instance sInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance ludwigPic of Feature
	(properties
		noun 30
		modNum 810
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 28 398 28 401 304 219 303
					yourself:
				)
		)
		(super init: &rest)
	)
)

