;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40500)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roLavaCrossing 0
)

(instance foDestination of Feature
	(properties
		nsLeft 171
		nsTop 27
		nsRight 281
		nsBottom 155
		x 246
		y 121
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soDestination)
	)
)

(instance soDestination of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo face: foDestination self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 2 1 0 0 self 40600) ; "That must be the way out of here...but how can I cross a river of hot lava?"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voWaterCannon of View
	(properties
		approachX 384
		approachY 316
		x 378
		y 310
		view 40500
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 74)
	)

	(method (doVerb)
		(gEgo setScript: soTorinInspectsCannon)
	)
)

(instance voWaterCannonEnd of View
	(properties
		x 378
		y 310
		view 40500
		loop 4
	)
)

(instance soTorinInspectsCannon of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: voWaterCannon self)
			)
			(1
				(gGame handsOff:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 40600) ; roWaterCannon
			)
		)
	)
)

(instance soTorinShootsCannon of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo approachThenFace: voWaterCannon self)
			)
			(1
				(= ticks 120)
			)
			(2
				(poBoogleJumps init: setCycle: CT 41 1 self)
			)
			(3
				(goSound1 playSound: 40504 self)
				(= ticks 180)
			)
			(4)
			(5
				(poBoogleJumps setCycle: End self)
			)
			(6
				(voWaterCannon dispose:)
				(poBoogleJumps dispose:)
				(gEgo hide:)
				(goSound1 preload: 40502)
				(poTorinKneels init: setCycle: CT 37 1 self)
			)
			(7
				(goSound1 setAmbient: 40503)
				(poTorinKneels setCycle: End self)
			)
			(8
				(poTorinKneels setCycle: CT 37 -1 self)
			)
			(9
				(poTorinKneels setCycle: End self)
			)
			(10
				(poTorinKneels setCycle: CT 37 -1 self)
			)
			(11
				(poTorinKneels setCycle: End self)
			)
			(12
				(poTorinKneels setCycle: CT 37 -1 self)
			)
			(13
				(poTorinKneels setCycle: End self)
			)
			(14
				(poTorinKneels setCycle: CT 37 -1 self)
			)
			(15
				(poTorinKneels setCycle: End self)
			)
			(16
				(poTorinKneels setCycle: CT 37 -1 self)
			)
			(17
				(goSound1 fadeOut:)
				(poTorinKneels setCycle: End self)
			)
			(18
				(goSound1 stop:)
				(= ticks 60)
			)
			(19
				(poTorinKneels dispose:)
				(voWaterCannon init:)
				(poTorinOperatesCannon init: setCycle: CT 21 1 self)
			)
			(20
				(= ticks (poTorinOperatesCannon cycleSpeed:))
			)
			(21
				(voWaterCannon dispose:)
				(poTorinOperatesCannon setCel: 22 setCycle: CT 36 1 self)
			)
			(22
				(oWaterGun setAmbient: 40501)
				(poTorinOperatesCannon setCycle: CT 46 1 self)
			)
			(23
				(poTorinOperatesCannon setCycle: CT 43 -1 self)
			)
			(24
				(poTorinOperatesCannon setCycle: CT 46 1 self)
			)
			(25
				(poTorinOperatesCannon setCycle: CT 43 -1 self)
			)
			(26
				(poTorinOperatesCannon setCycle: CT 48 1 self)
			)
			(27
				(oWaterGun fadeOut:)
				(oHiss playSound: 40502)
				(poTorinOperatesCannon setCycle: End self)
				(poPathForms init: setCycle: End self)
			)
			(28)
			(29
				(= ticks 120)
			)
			(30
				(poTorinOperatesCannon dispose:)
				(poPathForms dispose:)
				(voWaterCannonEnd init:)
				(goMusic1 playSound: 40598)
				(poTorinRuns init: setCycle: End self)
				(poBoogleRuns init: setCycle: End self)
				(poPathMelts init: setCycle: End self)
				(gMessager say: 1 74 0 0 self 40600) ; "Yes!"
			)
			(31)
			(32)
			(33)
			(34
				(poTorinRuns dispose:)
				(poBoogleRuns dispose:)
				(poPathMelts dispose:)
				((ScriptID 64017 0) set: 155) ; oFlags
				(= ticks 60)
			)
			(35
				(gCurRoom newRoom: 40700) ; roLavaMountain
			)
		)
	)
)

(instance poTorinKneels of Prop
	(properties
		x 379
		y 307
		view 40500
	)

	(method (init)
		(super init: &rest)
		(self setPri: 311)
	)
)

(instance poBoogleJumps of Prop
	(properties
		x 378
		y 310
		view 40500
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 311)
	)
)

(instance poTorinOperatesCannon of Prop
	(properties
		x 378
		y 310
		view 40500
		loop 2
	)
)

(instance poPathForms of Prop
	(properties
		x 378
		y 310
		view 40500
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance poTorinRuns of Prop
	(properties
		x 378
		y 310
		view 40501
	)
)

(instance poBoogleRuns of Prop
	(properties
		x 288
		y 259
		view 40501
		loop 1
	)
)

(instance poPathMelts of Prop
	(properties
		x 378
		y 310
		view 40501
		loop 2
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self setPri: 255)
	)
)

(instance oHiss of TPSound
	(properties)
)

(instance oWaterGun of TPSound
	(properties)
)

(instance oMoodMusic of TPSound
	(properties
		type 1
	)
)

(instance oPlayMusic of CueMe
	(properties)

	(method (cue)
		(goMusic1 setMusic: 40300)
	)
)

(instance poLava1 of Prop
	(properties
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setScript: soLava1)
	)
)

(instance soLava1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava1 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(switch (Random 0 6)
					(0
						(poLava1 posn: 104 277)
					)
					(1
						(poLava1 posn: 150 247)
					)
					(2
						(poLava1 posn: 167 273)
					)
					(3
						(poLava1 posn: 386 267)
					)
					(4
						(poLava1 posn: 351 221)
					)
					(5
						(poLava1 posn: 235 243)
					)
					(6
						(poLava1 posn: 422 258)
					)
				)
				(poLava1 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava2 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setScript: soLava2)
	)
)

(instance soLava2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava2 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(switch (Random 0 4)
					(0
						(poLava2 loop: 2)
					)
					(1
						(poLava2 loop: 3)
					)
					(2
						(poLava2 loop: 4)
					)
					(3
						(poLava2 loop: 7)
					)
					(4
						(poLava2 loop: 8)
					)
				)
				(switch (Random 0 7)
					(0
						(poLava2 posn: 123 177)
					)
					(1
						(poLava2 posn: 73 154)
					)
					(2
						(poLava2 posn: 22 180)
					)
					(3
						(poLava2 posn: 140 143)
					)
					(4
						(poLava2 posn: 176 132)
					)
					(5
						(poLava2 posn: 164 158)
					)
					(6
						(poLava2 posn: 170 176)
					)
					(7
						(poLava2 posn: 202 174)
					)
				)
				(poLava2 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava3 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setScript: soLava3)
	)
)

(instance soLava3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava3 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(switch (Random 0 4)
					(0
						(poLava3 loop: 2)
					)
					(1
						(poLava3 loop: 3)
					)
					(2
						(poLava3 loop: 4)
					)
					(3
						(poLava3 loop: 7)
					)
					(4
						(poLava3 loop: 8)
					)
				)
				(switch (Random 0 13)
					(0
						(poLava3 posn: 305 162)
					)
					(1
						(poLava3 posn: 330 142)
					)
					(2
						(poLava3 posn: 311 105)
					)
					(3
						(poLava3 posn: 304 94)
					)
					(4
						(poLava3 posn: 335 92)
					)
					(5
						(poLava3 posn: 354 109)
					)
					(6
						(poLava3 posn: 364 71)
					)
					(7
						(poLava3 posn: 374 92)
					)
					(8
						(poLava3 posn: 404 35)
					)
					(9
						(poLava3 posn: 441 28)
					)
					(10
						(poLava3 posn: 499 27)
					)
					(11
						(poLava3 posn: 559 20)
					)
					(12
						(poLava3 posn: 631 31)
					)
					(13
						(poLava3 posn: 604 24)
					)
				)
				(poLava3 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava4 of Prop
	(properties
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setScript: soLava4)
	)
)

(instance soLava4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava4 hide: setCel: 0)
				(= ticks (Random 1 150))
			)
			(1
				(switch (Random 0 4)
					(0
						(poLava4 loop: 2)
					)
					(1
						(poLava4 loop: 3)
					)
					(2
						(poLava4 loop: 4)
					)
					(3
						(poLava4 loop: 7)
					)
					(4
						(poLava4 loop: 8)
					)
				)
				(poLava4 posn: (Random 416 632) (Random 54 123))
				(poLava4 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance soTorinEnters of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 590 335
					setLoop: 7
					setMotion: MoveTo 532 307 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foExit of Feature
	(properties
		nsLeft 448
		nsTop 269
		nsRight 632
		nsBottom 316
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soTorinLeaves)
	)
)

(instance soTorinLeaves of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 552 307 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 590 335 self)
			)
			(3
				(gEgo setMotion: MoveTo 595 340)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 40300) ; roSpitsOfLand
			)
		)
	)
)

(instance roLavaCrossing of TPRoom
	(properties
		picture 40500
		south 40300
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 144) ; oFlags
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 596 320 558 297 533 302 466 297 435 277 340 292 293 290 271 270 234 289 193 292 158 297 68 300 85 323
					yourself:
				)
		)
		(foExit init:)
		(gEgo init: normalize: setScaler: Scaler 55 40 306 142)
		(voWaterCannon init:)
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(40600 ; roWaterCannon
				(goMusic1 setMusic: 40300)
				(gEgo
					posn: (voWaterCannon approachX:) (voWaterCannon approachY:)
					setLoop: 7
				)
				(if ((ScriptID 64017 0) test: 153) ; oFlags
					(gEgo setScript: soTorinShootsCannon)
				)
			)
			(else
				(oMoodMusic playSound: 40599 oPlayMusic)
				(goMusic1 setMusic: 0)
				(gEgo setScript: soTorinEnters)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 37)) ; oInvHandler, ioWrench
	)
)

