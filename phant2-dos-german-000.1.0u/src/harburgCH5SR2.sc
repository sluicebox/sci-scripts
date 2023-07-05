;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5025)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)

(public
	harburgCH5SR2 0
)

(instance harburgCH5SR2 of P2Room
	(properties
		picture 970
	)

	(method (init)
		(ClearFlag 1001)
		(guardFidget init:)
		(guard init:)
		(door init:)
		(super init: &rest)
		(guardTimer init:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(guardTimer dispose:)
		(super dispose:)
	)
)

(instance guardFidget of P2Fidget
	(properties
		x 97
		y 339
		view 19703
		cycleSpeed 8
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance door of ExitFeature
	(properties
		scene 7660
		sceneScored 1
		doneFlag 730
		nextRoom 900
		exitDir 1
	)

	(method (init)
		(super init: (proc63002_10 354 43 390 36 390 209 352 200))
	)

	(method (onMe)
		(if (super onMe: &rest)
			(if (or (<= 0 (guardFidget cel:) 11) (<= 27 (guardFidget cel:) 40))
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance guard of ExitFeature
	(properties
		scene 7670
		sceneScored 1
		doneFlag 731
		nextRoom 999
	)

	(method (init)
		(super
			init:
				(proc63002_10
					104
					236
					181
					115
					257
					79
					294
					94
					303
					214
					225
					289
					124
					296
				)
		)
	)
)

(instance guardTimer of P2Timer
	(properties)

	(method (init)
		(self start: 3 7)
	)

	(method (cue)
		(= global211 1)
		(= global212 0)
		(SetFlag 731)
		(= global209 7670)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)
)

