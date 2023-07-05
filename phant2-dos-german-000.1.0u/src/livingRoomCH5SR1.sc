;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2115)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Timer)
(use P2Fidget)
(use BorderWindow)
(use Feature)
(use System)

(public
	livingRoomCH5SR1 0
)

(local
	local0
	[local1 4] = [227 122 315 179]
	[local5 4] = [187 116 274 167]
	local9
	local10
	local11
)

(instance livingRoomCH5SR1 of P2Room
	(properties
		picture 40
		style 0
	)

	(method (init)
		(= local9 0)
		(= local10 0)
		(= local11 0)
		(if (not (IsFlag 705))
			(gEgo put: 1) ; walletI
			(gEgo put: 2) ; cardKeyI
			(gEgo put: 8) ; harburgCardI
			(ClearFlag 1001)
			(allie init:)
			(nakedCurtis init:)
			(allieNotes init:)
			(= picture 850)
			(ratCageFeat init: [local5 0] [local5 1] [local5 2] [local5 3])
			(= south (= north (= east (= west 0))))
		else
			(= east 2125)
			(= south 2135)
			(ratCageFeat init: [local1 0] [local1 1] [local1 2] [local1 3])
			(= picture 40)
			(fidget init:)
			(booger init:)
			(wesWall init:)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(boogerScript dispose:)
		(lookScript dispose:)
		(gTheCursor show:)
		(super dispose: &rest)
	)
)

(instance ratCageFeat of P2Feature
	(properties)

	(method (init)
		(cond
			((not (IsFlag 705))
				(= doneFlag 708)
				(= scene 2700)
			)
			((IsFlag 709)
				(return 0)
			)
			(else
				(= whoDoit ratCode)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if plane
			(super dispose:)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 709)
			(self dispose:)
		)
	)
)

(instance ratCode of Code
	(properties)

	(method (doit)
		(if (IsFlag 708)
			(cond
				((not (IsFlag 710))
					(proc63002_7 2720)
					(SetFlag 710)
				)
				((not (IsFlag 709))
					(proc63002_7 2740)
					(SetFlag 709)
				)
			)
		else
			(proc63002_7 2740)
			(SetFlag 709)
		)
	)
)

(instance allie of P2Feature
	(properties)

	(method (init)
		(= whoDoit allieCode)
		(super init: 321 68 378 234)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 707)
			(self dispose:)
		)
	)
)

(instance allieCode of Code
	(properties)

	(method (doit)
		(switch (++ local0)
			(1
				(proc63002_7 2440)
				(SetFlag 705)
				(allieNotes dispose:)
				(allieGun init:)
			)
			(2
				(proc63002_7 2450)
				(SetFlag 706)
				(allieTimer start: 3 10)
			)
			(3
				(allieTimer dispose:)
				(= global209 2470)
				(SetFlag 707)
				(ClearFlag 732)
				(gCurRoom newRoom: 2015) ; bedRoomCH5SR1
			)
		)
	)
)

(instance allieTimer of P2Timer
	(properties)

	(method (cue)
		(= global209 2480)
		(SetFlag 727)
		(ClearFlag 732)
		(gCurRoom newRoom: 2015) ; bedRoomCH5SR1
	)
)

(instance fidget of P2Fidget
	(properties
		x 400
		y 9
		view 10400
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 20
		zone1aRight 14
		zone1bLeft 13
		zone1bRight 12
		zone2aLeft 0
		zone2aRight 5
		zone2bLeft 6
		zone2bRight 11
	)

	(method (init)
		(super init:)
		(curtisFeat init: left top right bottom)
		(self setPri: 1)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(self delVerb: 4)
		(self addVerb: 21 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global211 1)
				(SetFlag 315)
				(proc63002_7 2145)
			)
		)
	)
)

(instance allieNotes of P2Fidget
	(properties
		x 314
		y 327
		view 18501
		initStart 1
		initFinish 4
		cycleStart 3
		cycleFinish 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance allieGun of P2Fidget
	(properties
		x 307
		y 327
		view 18502
		initStart 1
		initFinish 2
		cycleStart 3
		cycleFinish 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance nakedCurtis of P2Fidget
	(properties
		x 499
		y 339
		view 18500
		initStart 3
		initFinish 5
		cycleStart 3
		cycleFinish 8
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance booger of Feature
	(properties)

	(method (init)
		(super init: gThePlane 600 429 42 430 43)
		(Load 140 2803) ; WAVE
		(Load 140 2804) ; WAVE
	)

	(method (handleEvent event)
		(if (and (== gVerb 4) (& (event type:) evMOUSEBUTTON)) ; Do
			(event claimed: 1)
			(eggAMatic add: 2111 1 1)
			(++ local10)
			(((gThePlane cast:) doitList:) delete: fidget)
			(((gThePlane cast:) eventList:) delete: self)
			(= local11 (fidget cel:))
			(= local9 0)
			(boogerScript init:)
		)
	)
)

(instance boogerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheCursor hide:)
				(fidget setCel: 23)
				(UpdateScreenItem fidget)
				(= ticks 4)
			)
			(1
				(fidget cel: 24)
				(UpdateScreenItem fidget)
				(= ticks 4)
			)
			(2
				(fidget cel: 25)
				(UpdateScreenItem fidget)
				(= ticks 4)
			)
			(3
				(fidget cel: 26)
				(UpdateScreenItem fidget)
				(= ticks 4)
				(if (< (++ local9) 7)
					(-= state 2)
				)
			)
			(4
				(if (== local10 4)
					(= local10 0)
					(eggAMatic add: 2111 2 2)
					(lookScript init:)
				else
					(gP2SoundFX play: 2803)
					(fidget setCel: 27)
					(UpdateScreenItem fidget)
					(= ticks 4)
				)
			)
			(5
				(fidget cel: 28)
				(UpdateScreenItem fidget)
				(= ticks 4)
			)
			(6
				(fidget cel: 29)
				(UpdateScreenItem fidget)
				(= ticks 4)
			)
			(7
				(gTheCursor show:)
				(fidget cel: local11)
				(UpdateScreenItem fidget)
				(((gThePlane cast:) doitList:) add: fidget)
				(((gThePlane cast:) eventList:) add: booger)
				(self dispose:)
			)
		)
	)
)

(instance lookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fidget cel: 3)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(1
				(fidget cel: 4)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(2
				(fidget cel: 5)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(3
				(fidget cel: 6)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(4
				(fidget cel: 7)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(5
				(gP2SoundFX play: 2804)
				(fidget cel: 8)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(6
				(fidget cel: 7)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(7
				(fidget cel: 6)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(8
				(fidget cel: 5)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(9
				(fidget cel: 4)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(10
				(fidget cel: 3)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(11
				(fidget cel: 2)
				(UpdateScreenItem fidget)
				(= ticks 7)
			)
			(12
				(gTheCursor show:)
				(fidget cel: local11)
				(UpdateScreenItem fidget)
				(((gThePlane cast:) doitList:) add: fidget)
				(((gThePlane cast:) eventList:) add: booger)
				(boogerScript dispose:)
				(self dispose:)
			)
		)
	)
)

(instance wesWall of Feature
	(properties)

	(method (init)
		(super init: gThePlane 1 1 11 32 103)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event modifiers:) emALT)
				(& (event modifiers:) emCTRL)
				(& (event type:) evMOUSEBUTTON)
			)
			(gCurRoom newRoom: 2170) ; tractorRoom
			(event claimed: 1)
		)
		(event claimed:)
	)
)

