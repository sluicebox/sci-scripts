;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11100)
(include sci.sh)
(use Main)
(use oBoogle)
(use oHandsOnWhenCued)
(use CueMe)
(use foEExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roFahrmHouseInt 0
)

(instance soMomChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 194 274 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= ticks 1)
			)
			(3
				(gMessager say: 4 1 0 0) ; "That was Mom's favorite chair. I hope she's okay."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance foMomChair of Feature
	(properties
		noun 4
		x 80
		y 202
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 275 17 130 80 132 90 209 139 215 143 270
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soMomChair)
	)
)

(instance soDadChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 232 243 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= ticks 1)
			)
			(3
				(gMessager say: 5 1 0 0) ; "That's where Dad always sat after dinner...and drifted off to sleep."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance foDadChair of Feature
	(properties
		noun 5
		x 144
		y 181
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 106 209 88 130 120 112 158 120 163 180 197 188 200 230 162 250 145 247 142 213 107 208
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soDadChair)
	)
)

(instance foAshtray of Feature
	(properties
		noun 2
		case 1
		approachX 253
		approachY 225
		x 200
		y 225
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 179 189 169 217 172 204 185
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(if ((ScriptID 64017 0) test: 2) ; oFlags
				(gGame handsOff:)
				(gMessager say: 2 1 3 1 (ScriptID 64020 0)) ; "I don't want any of Dad's other smoking stuff.", oHandsOnWhenCued
			else
				(gEgo setScript: soLookAtAshtray)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance soLookAtAshtray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foAshtray self)
			)
			(1
				(= ticks 2)
				(gEgo stopwalk:)
			)
			(2
				(gCurRoom newRoom: 11300) ; roAshtray
			)
		)
	)
)

(instance foSewingBasket of Feature
	(properties
		noun 1
		case 1
		approachX 159
		approachY 306
		x 158
		y 307
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 314 55 253 126 255 163 314
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(if ((ScriptID 64017 0) test: 3) ; oFlags
				(gGame handsOff:)
				(gMessager say: 1 1 2 1 (ScriptID 64020 0)) ; "I searched Mom's sewing basket thoroughly last time. There's nothing else I need from there besides Inchie.", oHandsOnWhenCued
			else
				(gEgo setScript: soLookInsideBasket)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance soLookInsideBasket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foSewingBasket self)
			)
			(1
				(= ticks 2)
				(gEgo stopwalk:)
			)
			(2
				(gCurRoom newRoom: 11200) ; roSewingBasket
			)
		)
	)
)

(instance foStove of Feature
	(properties
		x 484
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 587 192 502 190 467 220 477 287 581 293 630 290 630 221
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soHot)
	)
)

(instance poTorin of Prop
	(properties
		view 60800
	)
)

(instance soHot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 451 275 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(2
				(poTorin
					setCel: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setScaler: gEgo
					doit:
					setCycle: CT 3 1 self
				)
				(gEgo hide:)
			)
			(3
				(poTorin cel: 1)
				(= ticks (poTorin cycleSpeed:))
			)
			(4
				(poTorin setScaler: 0 setScale: 0 setLoop: -1 dispose:)
				(gEgo show:)
				(gMessager say: 3 1 0 0 self) ; "Ow! Yep, the stove's still hot all right!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poFire of Prop
	(properties
		x 476
		y 218
		view 11101
		cycleSpeed 15
	)
)

(instance poBoogleToBox of Prop
	(properties
		view 11100
		loop 2
	)
)

(instance soBoogleLearnBox of Script
	(properties)

	(method (init)
		(goSound1 preload: 60011 60019)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom delBoogleFeature: foBox)
				(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogleToBox
					cel: 0
					posn: ((ScriptID 64018 0) x:) ((ScriptID 64018 0) y:) ; oBoogle, oBoogle
					init:
					setCycle: CT 27 1 self
				)
			)
			(1
				(goSound1 playSound: 60011)
				(poBoogleToBox setCycle: CT 37 1 self)
			)
			(2
				(goSound1 playSound: 60019)
				(poBoogleToBox setCycle: End self)
			)
			(3
				(poBoogleToBox dispose:)
				((ScriptID 64018 0) loop: 6 show:) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance foBox of BoogleLearnMeClass
	(properties
		approachX 448
		approachY 187
		x 448
		y 187
	)
)

(instance foOuttaTheWay of BoogleLearnMeClass
	(properties
		approachX 394
		approachY 230
		x 394
		y 230
	)
)

(instance soOuttaTheWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom delBoogleFeature: foOuttaTheWay)
				((ScriptID 64018 0) setWander: 0) ; oBoogle
				(soDoorScript cue:)
				(self dispose:)
			)
		)
	)
)

(instance voDoor of View
	(properties
		x 335
		y 183
		priority 10
		fixPriority 1
		view 11100
		loop 3
	)
)

(instance soTorinWalkOutDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 388 170 self)
				((ScriptID 64018 0) setMotion: MoveTo 388 190) ; oBoogle
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTorinOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foDoor self)
			)
			(1
				(poTorin
					view: 11100
					loop: 1
					cel: 0
					posn: 335 183
					init:
					setCycle: CT 2 1 self
				)
				(gEgo hide:)
			)
			(2
				(goSound1 playSound: 11101)
				(voDoor hide:)
				(poTorin setCycle: CT 10 1 self)
			)
			(3
				(goSound1 stop:)
				(poTorin setCycle: End self)
				(voDoor loop: 4 show:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 405 163 425 209 465 198 446 153
							yourself:
						)
				)
			)
			(4
				(poTorin dispose:)
				(gEgo cel: 6 show:)
				(self dispose:)
			)
		)
	)
)

(instance soDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(foOuttaTheWay init: soOuttaTheWay)
				(gCurRoom addBoogleFeature: foOuttaTheWay)
				(self setScript: soTorinOpenDoor self)
			)
			(1)
			(2
				(self setScript: soTorinWalkOutDoor self)
			)
			(3
				(gCurRoom newRoom: 11000) ; roFahrmHouseExt
			)
		)
	)
)

(instance foDoor of ExitFeature
	(properties
		approachX 334
		approachY 179
		x 334
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 366 74 385 61 410 66 421 93 426 166 351 163 355 114
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gEgo setScript: soDoorScript)
	)
)

(instance coBoogleOutOfBag of CueMe
	(properties)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 64018 0) show: setWander: 1) ; oBoogle
	)
)

(instance coBoogleJumpOutOfBag of CueMe
	(properties)

	(method (cue)
		(gCurRoom setScript: (ScriptID 64018 2) coBoogleOutOfBag) ; soBoogleOutOfPouch
	)
)

(instance roFahrmHouseInt of TPRoom
	(properties
		picture 11100
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 11100)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 174 267 153 286 162 316 320 338 635 336 626 289 459 295 442 246 462 216 599 220 546 185 440 183 420 167 362 168 348 176 234 172 213 183 232 206 226 240
					yourself:
				)
		)
		(if (not (gEgo has: ((ScriptID 64001 1) get: 0))) ; oBoogleHandler, ioBoogleBox
			(foBox init: soBoogleLearnBox)
			(self addBoogleFeature: foBox)
		)
		(poFire init: setCycle: Fwd)
		(voDoor init:)
		(foDoor init:)
		(foSewingBasket init:)
		(foAshtray init:)
		(foStove init:)
		(foMomChair init:)
		(foDadChair init:)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(11200 ; roSewingBasket
				((ScriptID 64018 0) ; oBoogle
					init:
					normalize:
					setScaler: Scaler 125 72 300 180
					doit:
				)
				(gEgo
					init:
					normalize: 1 60100 5
					setScaler: Scaler 125 72 300 180
					doit:
				)
			)
			(11300 ; roAshtray
				((ScriptID 64018 0) ; oBoogle
					init:
					normalize:
					setScaler: Scaler 125 72 300 180
					doit:
				)
				(gEgo
					init:
					normalize: 1 60100 1
					setScaler: Scaler 125 72 300 180
					doit:
				)
			)
			(else
				(gGame handsOff:)
				((ScriptID 64018 0) normalize:) ; oBoogle
				(gEgo
					init:
					normalize:
					setScaler: Scaler 125 72 300 180
					posn: (foDoor approachX:) (foDoor approachY:)
					loop: 2
				)
				(if ((ScriptID 64017 0) test: 232) ; oFlags
					(gEgo setMotion: MoveTo 298 234 coBoogleJumpOutOfBag)
				else
					(gEgo setMotion: MoveTo 298 234 (ScriptID 64020 0)) ; oHandsOnWhenCued
					((ScriptID 64018 0) ; oBoogle
						init:
						posn: 419 206
						setScaler: Scaler 125 72 300 180
					)
				)
			)
		)
	)
)

