;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7004)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	dreamingTreeRoomCH4 0
)

(local
	local0
)

(instance dreamingTreeRoomCH4 of P2Room
	(properties
		picture 300
	)

	(method (init)
		(ClearFlag 1001)
		(if (not (IsFlag 573))
			(SetFlag 1001)
			(= picture 421)
			(= south 900)
			(gP2SongPlyr start: 910)
		else
			(gP2SongPlyr fadeIn: 7000)
			(= picture 300)
			(curtisFidget init:)
			(menu init:)
			(if (IsFlag 570)
				(maxFidget init:)
				(exitFeat init:)
				(SetFlag 1001)
			else
				(menu isHot: 0)
				(= local0 0)
				(= global209 9350)
				(SetFlag 567)
				(trevFidget init:)
				(split init:)
			)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance split of View
	(properties
		x 331
		y 239
		view 302
	)
)

(instance curtisFidget of P2Fidget
	(properties
		x 386
		y 338
		view 13000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance trevFidget of P2Fidget
	(properties
		x 140
		y 339
		view 13003
	)

	(method (init)
		(super init: &rest)
		(trevFeat init:)
		(self setPri: 10)
	)
)

(instance maxFidget of P2Fidget
	(properties
		x 261
		y 316
		view 13005
	)

	(method (init)
		(super init: &rest)
		(maxFeat init:)
		(self setPri: 10)
	)
)

(instance menu of P2View
	(properties
		x 395
		y 233
		view 300
		loop 2
		nextRoom 7010
	)
)

(instance exitFeat of ExitFeature
	(properties
		priority 100
		nextRoom 900
		exitDir 0
	)

	(method (init)
		(super init: (proc63002_10 317 162 317 48 355 6 400 41 398 162))
	)
)

(instance maxFeat of P2Feature
	(properties
		priority 10
		scene 9330
		doneFlag 566
	)

	(method (init)
		(super init: 266 33 318 266)
	)
)

(instance trevFeat of P2Feature
	(properties)

	(method (init)
		(super init: 173 112 260 284)
		(= whoDoit trevCode)
	)
)

(instance trevExit of ExitFeature
	(properties
		doneFlag 572
		nextRoom 900
		exitDir 0
		exitScene 9480
	)

	(method (init)
		(super init: (proc63002_10 317 162 317 48 355 6 400 41 398 162))
	)
)

(instance trevCode of Code
	(properties)

	(method (doit)
		(switch (++ local0)
			(1
				(proc63002_7 9400)
				(SetFlag 568)
			)
			(2
				(proc63002_7 9420)
				(SetFlag 569)
			)
			(3
				(proc63002_7 9460)
				(SetFlag 570)
				(trevExit init:)
			)
			(4
				(= global209 9470)
				(SetFlag 571)
				(gCurRoom newRoom: 900) ; mapRoom
			)
		)
	)
)

