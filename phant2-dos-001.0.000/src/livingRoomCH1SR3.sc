;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2131)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use PolyEdit)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	livingRoomCH1SR3 0
)

(local
	[local0 4] = [453 68 534 245]
	local4
	local5
	local6
)

(instance livingRoomCH1SR3 of P2Room
	(properties
		picture 60
		style 0
		south 2111
		west 2121
	)

	(method (init)
		(if (IsFlag 15)
			(ClearFlag 1001)
			(sexFidget init:)
			(= east (= north (= west (= south 0))))
			(super init: &rest)
			(gP2SongPlyr stop:)
			(rain play: 0 global236)
		else
			(couchFeat init:)
			(bookCaseFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
			(polaroid init:)
			(fidget init:)
			(jukeBox init:)
			(teamPhoto init:)
			(wesBook init:)
			(super init: &rest)
		)
		(gGame handsOn: 1)
		(gCast add: checkBreasts)
	)

	(method (dispose)
		(if (gCast contains: checkBreasts)
			(gCast delete: checkBreasts)
		)
		(if (gSounds contains: rain)
			(rain dispose:)
		)
		(super dispose:)
	)
)

(instance couchFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(if (and (IsFlag 19) (not (IsFlag 38)))
			(= whoDoit couchClicked)
			(super
				init:
					(proc63002_10
						109
						232
						296
						190
						368
						198
						373
						242
						191
						320
						169
						268
						133
						257
					)
			)
			(if (IsFlag 13)
				(self delVerb: 4)
			)
			(if
				(and
					(not (IsFlag 16))
					(not (IsFlag 38))
					(IsFlag 13)
				)
				(self addVerb: 31)
			)
			(if (and (IsFlag 16) (not (IsFlag 38)))
				(self addVerb: 7)
			)
		else
			(return 0)
		)
	)
)

(instance couchClicked of Code
	(properties)

	(method (doit)
		(cond
			((and (not (IsFlag 13)) (IsFlag 19))
				(couchFeat delVerb: 4 addVerb: 31)
				(proc63002_7 1420)
				(SetFlag 13)
			)
			((and (IsFlag 16) (not (IsFlag 38)))
				(couchFeat delVerb: 7)
				(proc63002_7 1370)
				(SetFlag 38)
				(gEgo get: 1) ; walletI
				(gEgo get: 21) ; ratI
				(gEgo put: 3) ; candyI
			)
			(
				(and
					(not (IsFlag 16))
					(not (IsFlag 38))
					(IsFlag 13)
				)
				(couchFeat delVerb: 31 addVerb: 7)
				(proc63002_7 1360)
				(SetFlag 16)
				(gEgo put: 21) ; ratI
			)
		)
	)
)

(instance bookCaseFeat of P2Feature
	(properties
		scene 1460
		doneFlag 14
	)
)

(instance polaroid of P2View
	(properties
		x 369
		y 302
		view 60
		nextRoom 2190
	)

	(method (init)
		(if (not (IsFlag 94))
			(super init: &rest)
			(self addTarget: (tablePoly init:))
		else
			(return 0)
		)
	)
)

(instance tablePoly of Polygon
	(properties)

	(method (init)
		(super init: 369 285 389 285 391 292 373 293)
		(return self)
	)
)

(instance jocilynFeat of P2View ; UNUSED
	(properties)

	(method (init)
		(= whoDoit jocilynCode)
		(super init: &rest)
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
		(self addVerb: 30)
		(= whoDoit mailOnCurtisCode)
	)
)

(instance mailOnCurtisCode of Code
	(properties)

	(method (doit)
		(curtisFeat delVerb: 30)
		(proc63002_7 1520)
		(gEgo put: 20 get: 6) ; mailBundleI, sexyCardI
		(if (IsFlag 112)
			(SetFlag 1001)
		)
	)
)

(instance jocilynCode of Code
	(properties)

	(method (doit)
		(gCast delete: checkBreasts)
		(rain stop:)
		(rain dispose:)
		(if (== global207 1)
			(= global209 1631)
		else
			(= global209 1630)
		)
		(gCurRoom newRoom: 800) ; endChapter
	)
)

(instance sexFidget of P2Fidget
	(properties
		x 114
		y 151
		view 10604
		cycleSpeed 10
		initStart 3
		initFinish 5
	)

	(method (init)
		(super init:)
		(filler init:)
		(sexFeat init: 131 162 194 268)
		(breastFeat init: 164 214 176 229)
		(self setPri: 1)
	)
)

(instance sexFeat of P2Feature
	(properties
		priority 50
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(= whoDoit jocilynCode)
	)
)

(instance breastFeat of P2Feature
	(properties
		priority 100
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(= whoDoit jocilynCode)
	)
)

(instance filler of View
	(properties
		x 91
		y 335
		view 10604
		loop 1
	)
)

(instance checkBreasts of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if (not (= local4 (== (gTheCursor hotObject:) breastFeat)))
			(= local5 0)
		)
		(if (and local4 (not local5) (& (temp0 modifiers:) emALT))
			(if (== (mod (++ local6) 8) 0)
				(cond
					((== local6 24)
						(eggAMatic add: 2131 2 2)
						(gP2SoundFX play: 2816)
					)
					((== local6 48)
						(gP2SoundFX play: 2817)
						(eggAMatic add: 2131 4 1)
					)
					(else
						(eggAMatic add: 2131 1 3)
						(gP2SoundFX play: 2815)
					)
				)
			)
			(= local5 1)
		)
	)
)

(instance rain of Sound
	(properties
		loop -1
		number 2911
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

