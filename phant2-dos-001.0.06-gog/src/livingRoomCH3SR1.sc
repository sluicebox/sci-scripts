;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2113)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)
(use PolyEdit)
(use Feature)
(use System)

(public
	livingRoomCH3SR1 0
)

(local
	[local0 4] = [227 122 315 179]
	local4
	local5
	local6
)

(instance livingRoomCH3SR1 of P2Room
	(properties
		picture 40
		style 0
		south 2133
		east 2123
	)

	(method (init)
		(= local4 0)
		(= local5 0)
		(= local6 0)
		(if (not (IsFlag 339))
			(ratCageFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
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
			((not (IsFlag 308))
				(if (not (IsFlag 304))
					(= scene 1970)
					(= doneFlag 304)
					(super init: &rest)
				)
			)
			((and (IsFlag 371) (not (IsFlag 306)))
				(= whoDoit ratCode)
				(super init: &rest)
			)
		)
	)
)

(instance ratCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 305))
			(= global211 1)
			(proc63002_7 2000)
			(SetFlag 305)
		else
			(proc63002_7 2010)
			(SetFlag 306)
			(ratCageFeat dispose:)
		)
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
		(self addVerb: 21 30 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2143) ; livingRoomCH3SR4
			)
			(30 ; mailBundleI
				(gEgo put: 20) ; mailBundleI
				(proc63002_7 2061)
				(if (IsFlag 310)
					(SetFlag 1001)
				)
			)
			(28 ; dadLetterI
				(= global211 1)
				(SetFlag 315)
				(proc63002_7 2145)
			)
		)
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
			(eggAMatic add: 2113 1 1)
			(++ local5)
			(((gThePlane cast:) doitList:) delete: fidget)
			(((gThePlane cast:) eventList:) delete: self)
			(= local6 (fidget cel:))
			(= local4 0)
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
				(if (< (++ local4) 7)
					(-= state 2)
				)
			)
			(4
				(if (== local5 4)
					(= local5 0)
					(eggAMatic add: 2113 2 7)
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
				(fidget cel: local6)
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
				(= ticks 12)
			)
			(5
				(andyScript init:)
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
				(fidget cel: local6)
				(UpdateScreenItem fidget)
				(((gThePlane cast:) doitList:) add: fidget)
				(((gThePlane cast:) eventList:) add: booger)
				(boogerScript dispose:)
				(self dispose:)
			)
		)
	)
)

(instance andy of View
	(properties
		x 475
		y 153
		view 10401
	)

	(method (init)
		(= x 475)
		(= y 153)
		(super init: &rest)
	)
)

(instance andyScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(andy init:)
				(= ticks 1)
			)
			(1
				(if (> (= temp0 (+ (= temp0 (andy x:)) 10)) 640)
					(andy dispose:)
					(self dispose:)
				else
					(-= state 1)
					(andy posn: temp0 (andy y:))
					(= ticks 1)
				)
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

