;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4505)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	tomsCubicleRoomCH5 0
)

(instance tomsCubicleRoomCH5 of P2Room
	(properties
		picture 282
		south 3355
	)

	(method (init)
		(super init: &rest)
		(monitor init: 286 136 346 196)
		(gGame handsOn: 1)
	)
)

(instance monitor of P2Feature
	(properties
		scene 4920
		sceneScored 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 759)
			(self isHot: 0)
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(SetFlag 759)
			(self isHot: 0)
		)
	)
)

