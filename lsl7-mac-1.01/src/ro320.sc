;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use oFidgetTimer)
(use ego_64007)
(use TPSound)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use PushButton)
(use soFlashCyberSniff)
(use Plane)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ro320 0
)

(local
	local0
	local1
	local2
)

(instance ro320 of L7Room
	(properties)

	(method (init)
		(super init:)
		(proc60_1 0)
		(gOMusic1 setMusic: 0)
		(gEgo
			normalize: 2
			posn: 546 380
			init:
			addVerbHandler: ro320VerbHandler
			setScaler: Scaler 140 140 383 334
		)
		(foTable init:)
		(foCream init:)
		(foSyrupCake init:)
		(foExitVent init:)
		(foBody1 init:)
		(foBody2 init:)
		(foBody3 init:)
		(foBody4 init:)
		(oVoices setRelVol: 50)
		(oVoicesTimer setReal: oVoicesTimer 5)
		(oBGSound setAmbient: 32101)
		(gOMusic1 setMusic: 0)
		(gGame handsOn:)
		(gCurRoom setScript: soEnterThroughVent)
	)

	(method (dispose)
		(= global330 0)
		(if (gTimers contains: oVoicesTimer)
			(oVoicesTimer dispose: delete:)
		)
		(gOMusic1 stop:)
		(gOSound1 stop:)
		(proc60_1 1)
		(super dispose: &rest)
	)
)

(instance soUndress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: oVoicesTimer)
					(oVoicesTimer dispose: delete:)
				)
				(oVoices stop:)
				(gGame handsOff:)
				(gOSound1 preload: 32022)
				(gMessager say: 0 0 2 1 self) ; "Hey! I don't want to be left out of this!"
			)
			(1
				(gOSound1 playSound: 31011 self)
			)
			(2
				(gOSound1 playSound: 38603)
				(= cycles 1)
			)
			(3
				(= ticks 200)
			)
			(4
				(gOSound1 stop:)
				(gMessager sayRange: 0 0 2 2 6 self) ; "Okay, girls! Who wants me first?"
			)
			(5
				(gCurRoom drawPic: 32200)
				(Palette 1 324) ; PalLoad
				(if (== global325 1)
					(voEnglishBanner init:)
				else
					(voBannerLabel init:)
				)
				(voBGTasters1 init:)
				(voBGTasters2 init:)
				(poTaster1 cel: 0 init: setCycle: CT 13 1)
				(poTaster2 cel: 0 init: setCycle: CT 19 1)
				(poTaster3 cel: 0 init: setCycle: CT 11 1)
				(voWheelchair init:)
				(poOldMan init:)
				(gEgo dispose:)
				(poAnnette init:)
				(if (gTimers contains: oVoicesTimer)
					(oVoicesTimer dispose: delete:)
				)
				(oVoices stop:)
				(= local0 0)
				(poLarryOnMoose
					view: 32400
					loop: 1
					cel: 0
					posn: 290 132
					setPri: 318
					init:
				)
				(poLarryMouth
					view: 32400
					loop: 0
					cel: 0
					posn: 290 132
					setPri: 319
					init:
				)
				(gOSound1 preload: 32022 32205)
				(gOSound1 playSound: 32022)
				(FrameOut)
				(oBGSound setAmbient: 32205)
				(gMessager say: 0 0 2 7) ; "(GASP) Gasp!"
				(= cycles 1)
			)
			(6
				(= ticks 42)
			)
			(7
				(poLarryMouth setCycle: CT 3 1 self)
			)
			(8
				(= ticks 42)
			)
			(9
				(poLarryMouth setCycle: CT 11 1 self)
			)
			(10
				(= ticks 30)
			)
			(11
				(poLarryMouth setCycle: CT 15 1 self)
			)
			(12
				(= ticks 24)
			)
			(13
				(poLarryMouth setCycle: CT 17 1 self)
			)
			(14
				(= ticks 30)
			)
			(15
				(poLarryMouth setCycle: CycleCueList 26 1 self 18 26)
			)
			(16
				(poLarryOnMoose dispose:)
			)
			(17
				(= ticks 90)
			)
			(18
				(poLarryMouth setCycle: CT 31 1 self)
			)
			(19
				(= ticks 90)
			)
			(20
				(= local1 0)
				(oBGSound fadeOut:)
				(gMessager say: 0 0 2 8 coSpeechDone) ; "Blind Dessert Taste Test? Whew! That was close."
				(= ticks 90)
			)
			(21
				(= cycles 3)
				(if (not local1)
					(-= state 1)
				)
			)
			(22
				(poLarryMouth setCycle: CT 37 1 self)
			)
			(23
				(= global330 toLarryMoose)
				(poLarryMouth view: 32401 loop: 1 cel: 0 posn: 349 266)
				(poLarryOnMoose view: 32401 loop: 0 cel: 0 posn: 349 266 init:)
				(poAnnette setCycle: End)
				(gOMusic1 playSound: 32204)
				(gMessager say: 0 0 2 9 self) ; "It's nice to see the sight-challenged having a good time!"
			)
			(24
				(poTaster1 setCycle: End self)
				(poTaster2 setCycle: End self)
				(poTaster3 setCycle: End self)
			)
			(25)
			(26)
			(27
				(= global330 0)
				(poLarryOnMoose dispose:)
				(poLarryMouth dispose:)
				(poAnnette dispose:)
				(if (== global325 1)
					(voEnglishBanner dispose:)
				else
					(voBannerLabel dispose:)
				)
				(gCurRoom addRoomPlane: oTossPlane)
				(oBGSound stop:)
				(gOSound1 preload: 20306)
				(oBGSound playSound: 32023)
				(gMessager sayRange: 0 0 2 11 13 self) ; "Idiot!"
			)
			(28
				(Palette 1 321) ; PalLoad
				(poLarryFlies
					view: 32100
					loop: 1
					cel: 0
					posn: 408 388
					init:
					setCycle: End self 9 999
				)
			)
			(29
				(gOSound1 playSound: 20306)
			)
			(30
				(gMessager say: 0 0 2 14 self 320) ; "(AS YOU HIT THE PAVEMENT) Ouf!"
				(poLarryFlies view: 32101 loop: 0 cel: 0 setCycle: End self)
			)
			(31
				(poLarryFlies posn: 1 353 loop: 1 cel: 0 setCycle: End self)
			)
			(32
				((ScriptID 64017 0) set: 66) ; oFlags
				((ScriptID 64017 0) set: 179) ; oFlags
				((ScriptID 64017 0) set: 258) ; oFlags
				(oBGSound stop:)
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

(instance oTossPlane of Plane
	(properties
		picture 32100
	)

	(method (init)
		(super init: 0 0 639 479)
	)
)

(instance toLarryMoose of Talker
	(properties)

	(method (init)
		(= view 32401)
		(= loop 1)
		(= x 349)
		(= y 266)
		(= priority (+ (poLarryOnMoose priority:) 1))
		(poLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance poLarryFlies of Prop
	(properties)
)

(instance poLarryOnMoose of Prop
	(properties
		x 349
		y 266
		view 32401
	)
)

(instance poLarryMouth of Prop
	(properties
		x 349
		y 266
		priority 267
		fixPriority 1
		view 32401
		loop 1
	)
)

(instance poAnnette of Prop
	(properties
		x 75
		y 482
		priority 550
		fixPriority 1
		view 32402
	)
)

(instance foTable of Feature
	(properties
		noun 7
		x 325
		y 415
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 335 464 426 459 504 448 560 438 619 423 623 409 603 398 544 384 520 380 377 367 254 368 171 368 118 377 71 385 37 397 28 404 35 421 113 445 178 456 278 464 320 464
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 3 12)
	)
)

(instance foCream of Feature
	(properties
		noun 5
		x 421
		y 358
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 254 86 220 147 215 161 266
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foSyrupCake of Feature
	(properties
		noun 6
		x 210
		y 369
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 384 218 481 216 479 259 382 267
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foBody1 of Feature
	(properties)

	(method (init)
		(= noun 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 15 275 83 275 109 370 17 385
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foBody2 of Feature
	(properties)

	(method (init)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 237 253 226 288 348 195 343
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foBody3 of Feature
	(properties)

	(method (init)
		(= noun 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 300 461 294 466 356 325 358
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foBody4 of Feature
	(properties)

	(method (init)
		(= noun 4)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 15 275 83 275 109 370 17 385
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 7 3 12)
	)
)

(instance foExitVent of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 529 21 629 12 611 186 511 170
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soLeaveVent)
	)
)

(instance soLeaveVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 38603 self)
			)
			(1
				(gCurRoom newRoom: 387) ; ro387
			)
		)
	)
)

(instance soEnterThroughVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 38603)
				(= ticks 100)
			)
			(1
				(gOSound1 playSound: 20306 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voBannerLabel of TextItem
	(properties
		x 20
		y 5
		back 255
		skip 255
		font 7
		border 0
	)

	(method (init &tmp temp0 temp1 [temp2 2])
		(= text (MakeMessageText 0 0 4 1 320)) ; "Blind Dessert Taste Test"
		(super init: &rest)
		(= temp1 100)
		(= temp0 500)
		(self setScale:)
		(= scaleX (MulDiv 128 temp0 nWidth))
		(= scaleY (MulDiv 128 temp1 nHeight))
		(UpdateScreenItem self)
	)
)

(instance voEnglishBanner of View
	(properties
		x 374
		y 105
		priority 10
		fixPriority 1
		view 32250
	)
)

(instance voBGTasters1 of View
	(properties
		x 77
		y 365
		priority 19
		fixPriority 1
		view 32408
	)
)

(instance voBGTasters2 of View
	(properties
		x 523
		y 325
		priority 19
		fixPriority 1
		view 32408
		loop 1
	)
)

(instance poTaster1 of Prop
	(properties
		x 122
		y 478
		priority 200
		fixPriority 1
		view 32403
	)
)

(instance poTaster2 of Prop
	(properties
		x 456
		y 479
		priority 200
		fixPriority 1
		view 32404
	)
)

(instance poTaster3 of Prop
	(properties
		x 580
		y 479
		priority 200
		fixPriority 1
		view 32405
	)
)

(instance voWheelchair of View
	(properties
		x 317
		y 478
		priority 710
		fixPriority 1
		view 32406
	)
)

(instance poOldMan of Prop
	(properties
		x 317
		y 478
		priority 700
		fixPriority 1
		view 32406
		loop 1
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance oVoices of TPSound
	(properties)
)

(instance oBGSound of TPSound
	(properties)
)

(instance oVoicesTimer of Timer
	(properties)

	(method (cue &tmp temp0 temp1)
		(for ((= temp1 local2)) (== temp1 local2) ((= temp1 (Random 1 10)))
		)
		(= local2 temp1)
		(= temp0 (Random 0 1))
		(if (not local0)
			(= local0 1)
			(if temp0
				(oVoices playMessage: 0 0 1 temp1 coEndSound 320 1)
			else
				(oVoices playMessage: 0 0 3 temp1 coEndSound 320 1)
			)
		)
		(self setReal: self (Random 3 11))
	)
)

(instance coEndSound of CueMe
	(properties)

	(method (cue)
		(= local0 0)
	)
)

(instance coSpeechDone of CueMe
	(properties)

	(method (cue)
		(= local1 1)
	)
)

(instance ro320VerbHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(83 ; Undress
				(gCurRoom setScript: soUndress)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

