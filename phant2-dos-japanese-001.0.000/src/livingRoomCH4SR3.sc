;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2134)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Timer)
(use P2Fidget)
(use Rectangle)
(use PolyEdit)
(use Feature)
(use System)

(public
	livingRoomCH4SR3 0
)

(local
	[local0 4] = [453 68 534 245]
)

(instance livingRoomCH4SR3 of P2Room
	(properties
		picture 60
		style 0
		west 2124
	)

	(method (init)
		(if (not (IsFlag 518))
			(ClearFlag 1001)
			(allieNCurtis init:)
			(allieFeat init:)
			(AllieTimerCh4 whoDoit: allieCode)
			(= south 0)
		else
			(if (IsFlag 505)
				(ClearFlag 1001)
				(jocNCurtis init:)
				(filler init:)
				(jocilynFeat init:)
			else
				(bookCaseFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
				(phoneFeat init:)
				(hairPin init:)
				(fidget init:)
				(jukeBox init:)
				(teamPhoto init:)
				(wesBook init:)
			)
			(= south 2114)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance bookCaseFeat of P2Feature
	(properties
		scene 2410
		sceneScored 1
		doneFlag 510
	)
)

(instance phoneFeat of P2Feature
	(properties
		scene 2170
		doneFlag 556
	)

	(method (init)
		(super init: 101 264 144 291)
		(self delVerb: 4)
		(self addVerb: 13)
	)
)

(instance jocNCurtis of P2Fidget
	(properties
		x 159
		y 151
		view 10603
		initStart 2
		initFinish 5
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance hairPin of P2View
	(properties
		priority 500
		x 335
		y 299
		view 60
		loop 1
		nextRoom 2144
	)

	(method (init)
		(if (and (IsFlag 512) (not (IsFlag 514)))
			(super init: &rest)
			(self addTarget: (Rectangle new: 342 278 354 290))
		else
			(return 0)
		)
	)
)

(instance fidget of P2Fidget
	(properties
		x 227
		y 344
		view 10600
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 0
		zone1aRight 10
		zone1bLeft 11
		zone1bRight 21
		zone2aLeft 22
		zone2aRight 32
		zone2bLeft 33
		zone2bRight 42
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
		(self addVerb: 30 21 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global211 1)
				(SetFlag 1001)
				(proc63002_7 2420)
				(gEgo put: 20 get: 24) ; mailBundleI, thereseNoteI
			)
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

(instance jocilynFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit jocilynPresentCode)
		(super init: 245 166 302 272)
	)
)

(instance filler of View
	(properties
		x 91
		y 335
		view 10603
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance jocilynPresentCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 511))
			(proc63002_7 2260)
			(SetFlag 511)
		else
			(ClearFlag 505)
			(= global209 2280)
			(SetFlag 512)
			(ClearFlag 562)
			(gCurRoom newRoom: 2014) ; bedRoomCH4SR1
		)
	)
)

(instance allieNCurtis of P2Fidget
	(properties
		x 75
		y 404
		view 10606
		cycleSpeed 7
		initStart 2
		initFinish 5
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance allieFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit allieCode)
		(super init: 314 83 435 289)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 518)
			(self dispose:)
		)
	)
)

(instance allieCode of Code
	(properties)

	(method (doit)
		(switch (++ global231)
			(1
				(gP2SongPlyr fadeTo: 70)
				(proc63002_7 2200)
				(SetFlag 558)
				(gP2SongPlyr fadeTo: 100)
			)
			(2
				(proc63002_7 2210)
				(SetFlag 559)
			)
			(3
				(proc63002_7 2220)
				(SetFlag 560)
				(AllieTimerCh4 start: 3 10)
			)
			(4
				(AllieTimerCh4 dispose:)
				(gP2SongPlyr fadeOut: 0)
				(= global209 2240)
				(SetFlag 518)
				(ClearFlag 562)
				(gCurRoom newRoom: 2014) ; bedRoomCH4SR1
			)
		)
	)
)

(instance jukeBox of Feature
	(properties)

	(method (init)
		(super init: gThePlane 100 606 216 636 248)
		(= scratch 0)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self scratch: (+ (self scratch:) 1))
			(if (== (self scratch:) 10)
				(eggAMatic add: 2131 8 5)
				(gCurRoom newRoom: 2900) ; jukeRoom
			)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance teamPhoto of P2Feature
	(properties
		nextRoom 2130
	)

	(method (init)
		(super init: 414 128 433 143)
		(if (not (Random 0 9))
			(switch (Random 1 3)
				(1
					(outsidePic init:)
				)
				(2
					(loversPic init:)
				)
				(3
					(pizzaPic init:)
				)
			)
		)
	)
)

(instance outsidePic of P2Feature
	(properties
		nextRoom 2137
	)

	(method (init)
		(super init: 567 65 599 93)
	)
)

(instance loversPic of P2Feature
	(properties
		nextRoom 2138
	)

	(method (init)
		(super init: 571 104 592 142)
	)
)

(instance pizzaPic of P2Feature
	(properties
		nextRoom 2139
	)

	(method (init)
		(super init: 563 156 597 180)
	)
)

(instance wesBook of Feature
	(properties)

	(method (init)
		(super init: gThePlane 1 369 264 415 276)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event modifiers:) emALT)
				(& (event modifiers:) emCTRL)
				(& (event type:) evMOUSEBUTTON)
			)
			(gCurRoom newRoom: 2171) ; bookRoom
			(event claimed: 1)
		)
		(event claimed:)
	)
)

