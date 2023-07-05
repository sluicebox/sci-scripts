;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7003)
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
	dreamingTreeRoomCH3 0
)

(instance dreamingTreeRoomCH3 of P2Room
	(properties
		picture 300
	)

	(method (init)
		(ClearFlag 1001)
		(if (IsFlag 371)
			(gP2SongPlyr fadeIn: 7000)
			(SetFlag 100)
			(if (and (not (IsFlag 383)) (not (IsFlag 384)))
				(if (not (== gPrevRoomNum 7010)) ; dreamingTreeRoomSR1
					(= global209 9261)
					(SetFlag 379)
					(= global239 0)
				)
				(ClearFlag 1001)
				(shake init:)
				(trevFidget init:)
				(trevExit init:)
			else
				(SetFlag 1001)
				(maxFidget init:)
				(exitFeat init:)
				(chair init:)
			)
			(curtisFidget init:)
			(menu init:)
			(if (IsFlag 100)
				(menu isHot: 0)
			)
		else
			(SetFlag 1001)
			(gP2SongPlyr start: 910)
			(= picture 421)
			(= south 900)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(ClearFlag 100)
		(super dispose: &rest)
	)
)

(instance trevFidget of P2Fidget
	(properties
		x 146
		y 339
		view 13002
	)

	(method (init)
		(super init: &rest)
		(trevFeat init:)
		(self setPri: 10)
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

	(method (init)
		(super init: &rest)
	)
)

(instance shake of View
	(properties
		x 316
		y 174
		view 300
		loop 4
	)

	(method (init)
		(if (IsFlag 380)
			(= x 324)
			(= y 180)
			(= cel 1)
		)
		(super init: &rest)
		(self setPri: 5)
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
		readyFlag 382
		doneFlag 384
		nextRoom 900
		exitDir 0
		exitScene 9320
	)

	(method (init)
		(super init: (proc63002_10 317 162 317 48 355 6 400 41 398 162))
	)
)

(instance trevCode of Code
	(properties)

	(method (doit)
		(switch (++ global239)
			(1
				(proc63002_7 9260)
				(SetFlag 380)
				(shake x: 324 y: 180 setCel: 1)
			)
			(2
				(proc63002_7 9270)
				(SetFlag 381)
			)
			(3
				(proc63002_7 9280)
				(SetFlag 382)
				(trevExit init:)
			)
			(4
				(= global209 9310)
				(SetFlag 383)
				(gCurRoom newRoom: 900) ; mapRoom
			)
		)
	)
)

(instance maxFeat of P2Feature
	(properties
		priority 10
	)

	(method (init)
		(if (IsFlag 378)
			(return 0)
		else
			(super init: 266 33 318 266)
			(= whoDoit maxCode)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 378)
			(self dispose:)
		)
		(event claimed:)
	)
)

(instance maxCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 377))
			(SetFlag 377)
			(proc63002_7 9180)
		else
			(SetFlag 378)
			(proc63002_7 9250)
		)
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

(instance chair of P2View
	(properties
		x 180
		y 223
		view 300
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self isHot: 0)
		(target setPri: 3 update:)
	)
)

