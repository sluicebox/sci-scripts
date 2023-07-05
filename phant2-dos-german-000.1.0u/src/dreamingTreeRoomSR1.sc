;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7010)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	dreamingTreeRoomSR1 0
)

(instance dreamingTreeRoomSR1 of CloseupRoom
	(properties
		picture 302
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(foodFeature init:)
		(alcoholFeature init:)
		(gGame handsOn: 1)
	)
)

(instance foodFeature of P2Feature
	(properties
		doneFlag 89
	)

	(method (init)
		(if (super init: &rest)
			(target dispose:)
			(= target (proc63002_10 89 164 134 0 614 0 578 211))
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(proc63002_11 7000 2 0 5 1)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)
)

(instance alcoholFeature of ExitFeature
	(properties
		sceneScored 1
		doneFlag 90
		exitScene 8670
	)

	(method (init)
		(if
			(and
				(not (IsFlag 100))
				(or (not (IsFlag 70)) (!= gChapter 1))
				(not (IsFlag doneFlag))
			)
			(= nextRoom gPrevRoomNum)
			(super init: (proc63002_10 89 164 578 211 559 386 90 294))
		)
	)
)

