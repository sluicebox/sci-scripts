;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4103)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	trevorsCubicleRoomCH3 0
)

(instance trevorsCubicleRoomCH3 of P2Room
	(properties
		picture 240
		south 3333
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 80)
		(= global241 60)
		(if (not (IsFlag 384))
			(trevorProp init: setPri: 1)
			(trevor init: whoDoit: trevorCode)
		else
			(= picture 241)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance trevorProp of P2Fidget
	(properties
		x 184
		y 337
		view 12401
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(trevor handleEvent: &rest)
	)
)

(instance trevor of P2Feature
	(properties
		priority 2
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 397)
			(self delVerb: 4)
		)
	)

	(method (onMe)
		(return (trevorProp onMe: &rest))
	)
)

(instance trevorCode of Code
	(properties)

	(method (doit)
		(cond
			((not (SetFlag 395))
				(proc63002_7 4520)
			)
			((not (SetFlag 396))
				(proc63002_7 3950)
			)
			(else
				(proc63002_7 4530)
				(SetFlag 397)
				(trevor delVerb: 4)
			)
		)
	)
)

