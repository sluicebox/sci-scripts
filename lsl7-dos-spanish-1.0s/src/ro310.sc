;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use ego_64007)
(use TPSound)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro310 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(poLarryArms setCycle: Beg)
)

(procedure (localproc_1)
	(poLarryArms setCycle: End)
)

(procedure (localproc_2)
	(if (< (poLarryArms cel:) 1)
		(poLarryArms setCycle: CT 1 1)
	else
		(poLarryArms setCycle: CT 1 -1)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

(instance ro310 of L7Room
	(properties
		picture 31000
	)

	(method (init)
		(gEgo
			normalize: 0
			posn: 82 293
			init:
			addVerbHandler: ro310VerbHandler
		)
		(super init:)
		(gOMusic1 setMusic: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 132 259 53 312 116 355 41 423 143 426 235 318 526 318 504 290 451 291 414 267 215 269
					yourself:
				)
		)
		(foBed init:)
		(foDresser init:)
		(foCart init:)
		(poBlanket init:)
		(poRespirator init:)
		(poMoonlight init:)
		(foDoor init:)
		(gGame handsOn:)
	)
)

(instance soDoMrBoning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 391 285 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(gMessager say: 4 83 0 1 self) ; "Okay, baby; this is it!"
				(Load rsPIC 31400)
			)
			(3
				(gOSound1 preload: 31011)
				(gEgo hide:)
				((ScriptID 64017 0) set: 305) ; oFlags
				(gOMusic1 setMusic: 31000)
				(poLarry
					view: 31001
					posn: 388 233
					loop: 0
					cel: 0
					cycleSpeed: 7
					init:
					setCycle: End self
				)
				(gOSound1 playSound: 31011)
			)
			(4
				(gOSound1 preload: 31013)
				(voLarryClothes init:)
				(poLarry
					view: 31002
					posn: 376 232
					loop: 0
					cel: 0
					setPri: 250
					doit:
					setCycle: End self 12 35 99
				)
			)
			(5
				(gOSound1 playSound: 31013)
				(poLarry setPri: 500)
			)
			(6
				(poBlanket dispose:)
			)
			(7
				(poLarry
					view: 31003
					posn: 375 228
					loop: 0
					cel: 0
					cycleSpeed: 9
					doit:
					setCycle: Fwd
				)
				(gOSound1 preload: 31019 31020 31021 31022)
				(= ticks 60)
			)
			(8
				(gMessager say: 4 83 0 2 self) ; "(FOREPLAY SOUNDS) Oh, yeah."
			)
			(9
				(= ticks 60)
			)
			(10
				(gMessager say: 4 83 0 3 self) ; "(FOREPLAY SOUNDS) Oooh."
				(poHeartMonitor cel: 0 init: cycleSpeed: 6 setCycle: Fwd)
			)
			(11
				(= ticks 60)
			)
			(12
				(gMessager say: 4 83 0 4 self) ; "(FOREPLAY SOUNDS) Mnnnnmmm."
				(self setScript: soBoningNoises)
			)
			(13
				(= ticks 60)
			)
			(14
				(gMessager say: 4 83 0 5 self) ; "(FOREPLAY SOUNDS) Ahhhh."
			)
			(15
				(= ticks 60)
			)
			(16
				(gOSound1 preload: 31015)
				(self setScript: 0)
				(oBoningSound playSound: 31022 self)
			)
			(17
				(oRespiratorSounds stop:)
				(= ticks 45)
			)
			(18
				(poHeartMonitor loop: 1)
				(oHeartSounds setAmbient: 31017)
				(if (> (poRespirator cel:) 4)
					(poRespirator setCycle: CT 4 -1)
				else
					(poRespirator setCycle: CT 4 1)
				)
				(gOSound1 playSound: 31015)
				(poAnnette
					view: 31404
					posn: 80 106
					init:
					setCycle: End self 17 99
				)
			)
			(19
				(gOSound1 preload: 31016)
				(gCurRoom drawPic: 31400)
				(Palette 1 314) ; PalLoad
				(gOSound1 playSound: 31016)
			)
			(20
				(poAnnette view: 31406 loop: 0 cel: 0 posn: 80 106 doit:)
				(voAnnetteMouth init:)
				(= global334 toAnnette)
				(= ticks 30)
			)
			(21
				(= local0 0)
				(gMessager say: 4 83 0 8) ; "(TURNING ON LIGHTS) (SIMULTANEOUSLY) What the...?"
				(gOSound1 preload: 31012)
				(poLarry
					view: 31402
					loop: 0
					cel: 0
					posn: 389 237
					cycleSpeed: 7
					doit:
					setCycle: End self 10 33 99
				)
				(poBlanket
					view: 31003
					loop: 2
					posn: 375 228
					cel: 0
					setPri: 502
					init:
					setCycle: End
				)
				(gOSound1 playSound: 31012)
			)
			(22
				(gMessager kill:)
				(= local0 0)
				(gMessager say: 4 83 0 10 coDoneTalking) ; "Annette?! (SEES OLD MAN IN BED BESIDE HIM) ARRGGGH!! (LEAPS FROM BED)"
			)
			(23
				(poLarry setPri: 350)
			)
			(24
				(gOMusic1 stop:)
				((ScriptID 64017 0) clear: 305) ; oFlags
				(= cycles 1)
			)
			(25
				(= cycles 3)
				(if (not local0)
					(-- state)
				)
			)
			(26
				(poLarry
					view: 31403
					posn: 394 243
					loop: 0
					cel: 0
					doit:
					setCycle: End self
				)
			)
			(27
				(poLarry dispose:)
				(poLarryArms init:)
				(voLarryMouth init:)
				(= global330 toLarry)
				(gMessager say: 4 83 0 11 self) ; "Larry, what are you doing?!"
			)
			(28
				(localproc_2)
				(gMessager say: 4 83 0 12 self) ; "You weren't supposed to kill him yet!"
			)
			(29
				(localproc_1)
				(gMessager sayRange: 4 83 0 13 15 self) ; "I... I thought you were..."
			)
			(30
				(voAnnetteMouth dispose:)
				(= global334 0)
				(poAnnette
					view: 31405
					loop: 0
					cel: 0
					posn: 80 106
					setPri: 370
					doit:
					setCycle: End self 9 999
				)
				(= local0 0)
				(gMessager say: 4 83 0 16 coDoneTalking) ; "Geez, the old guy's one sound sleeper."
			)
			(31
				(oHeartSounds stop:)
				(poHeartMonitor dispose:)
			)
			(32
				(= cycles 3)
				(if (not local0)
					(-- state)
				)
			)
			(33
				(localproc_0)
				(gMessager say: 4 83 0 17 self) ; "(WHISPERS) Hey! Maybe we should go to your room and let this old geezer rest in peace, huh?"
			)
			(34
				(poAnnette view: 31408 loop: 0 cel: 0 posn: 80 106 doit:)
				(voAnnetteMouth init:)
				(= global334 toAnnette)
				(localproc_2)
				(gMessager sayRange: 4 83 0 18 19 self) ; "Oh, I think this is exactly where you want to be."
			)
			(35
				(localproc_1)
				(gMessager sayRange: 4 83 0 20 21 self) ; "No, no. It's not like that at all!"
			)
			(36
				(localproc_2)
				(gMessager sayRange: 4 83 0 22 22 self) ; "But when does the other shoe drop? What's his game?"
			)
			(37
				(localproc_0)
				(gMessager sayRange: 4 83 0 23 25 self) ; "Annette, you don't think..."
			)
			(38
				(localproc_2)
				(gMessager sayRange: 4 83 0 26 26 self) ; "You cold-hearted bastard! I guess we'll do it your way."
			)
			(39
				(gOSound1 preload: 31403 31402)
				(voAnnetteMouth dispose:)
				(= global334 0)
				(poAnnette
					view: 31409
					loop: 0
					cel: 0
					doit:
					setCycle: End self 16 30 35 39
				)
				(gMessager sayRange: 4 83 0 27 27) ; "Let's get this stuff out of here. (GATHERS UP CLOTHES AND TOSSES OUT PORTHOLE)"
			)
			(40
				(voLarryClothes dispose:)
			)
			(41
				(gOSound1 playSound: 31402)
			)
			(42
				(voWindow init:)
			)
			(43
				(poClothes
					view: 31409
					loop: 3
					posn: 49 130
					setPri: 1
					init:
					setCycle: Fwd
				)
				(= ticks 120)
				(localproc_1)
				(= local0 0)
				(gMessager kill:)
				(gMessager say: 4 83 0 28 coDoneTalking) ; "Hey! My clothes!"
			)
			(44
				(gOSound1 playSound: 31403)
				(poClothes loop: 4 cel: 0 doit: setCycle: End)
				(poAnnette view: 31411 loop: 0 cel: 0 doit: setCycle: End self)
			)
			(45
				(if (not local0)
					(-- state)
				)
				(= cycles 1)
			)
			(46
				(poAnnette view: 31412 loop: 0 cel: 0 doit:)
				(voAnnetteMouth init:)
				(= global334 toAnnette)
				(localproc_2)
				(gMessager sayRange: 4 83 0 29 30 self) ; "Does he WANT evidence lying around?"
			)
			(47
				(= ticks 60)
			)
			(48
				(localproc_1)
				(proc64896_1 1 5 self)
			)
			(49
				((ScriptID 64017 0) set: 62) ; oFlags
				((ScriptID 64017 0) set: 260) ; oFlags
				(= global330 0)
				(= global334 0)
				(CopyWinningWallpaper 5)
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

(instance soBoningNoises of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(poRespirator setCycle: Fwd)
				(oRespiratorSounds setAmbient: 31018)
				(poHeartMonitor cycleSpeed: 4)
				(= cycles 1)
			)
			(2
				(oBoningSound playSound: 31019 self)
			)
			(3
				(poHeartMonitor cycleSpeed: 2)
				(oBoningSound playSound: 31020 self)
			)
			(4
				(poHeartMonitor cycleSpeed: 1)
				(oBoningSound playSound: 31021 self)
			)
			(5
				(-= state 4)
				(= cycles 1)
			)
		)
	)
)

(instance oBoningSound of TPSound
	(properties)
)

(instance oHeartSounds of TPSound
	(properties)
)

(instance oRespiratorSounds of TPSound
	(properties)
)

(instance poAnnette of Prop
	(properties)
)

(instance poLarry of Prop
	(properties)
)

(instance poClothes of Prop
	(properties)
)

(instance poBlanket of Prop
	(properties
		priority 490
		x 383
		y 242
		loop 2
		view 31401
		fixPriority 1
	)
)

(instance voWindow of View
	(properties
		priority 100
		x 80
		y 106
		loop 5
		view 31409
		fixPriority 1
	)
)

(instance poMoonlight of Prop
	(properties
		priority 1
		x 450
		y 83
		cycleSpeed 12
		view 31008
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: RandCycle)
	)
)

(instance poLarryArms of Prop
	(properties
		x 396
		y 243
		loop 2
		view 31407
	)
)

(instance voLarryClothes of View
	(properties
		x 388
		y 233
		view 31007
	)
)

(instance poRespirator of Prop
	(properties
		priority 550
		x 84
		y 289
		view 31400
		fixPriority 1
	)
)

(instance poHeartMonitor of Prop
	(properties
		priority 545
		x 36
		y 270
		view 31004
		fixPriority 1
	)

	(method (init)
		(oHeartSounds preload: 31014)
		(super init: &rest)
	)

	(method (doit)
		(if (and (== loop 0) (!= cel local1))
			(if (== cel 7)
				(oHeartSounds playSound: 31014)
			)
			(= local1 cel)
		)
		(super doit: &rest)
	)
)

(instance toLarry of Talker
	(properties
		priority 351
		x 396
		y 243
		loop 1
		view 31407
	)

	(method (init)
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance voLarryMouth of View
	(properties
		priority 351
		x 396
		y 243
		loop 1
		view 31407
		fixPriority 1
	)
)

(instance voAnnetteMouth of View
	(properties)

	(method (init)
		(= view (poAnnette view:))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(= loop (+ (poAnnette loop:) 1))
		(= priority (+ (poAnnette priority:) 1))
		(= fixPriority 1)
		(super init: &rest)
	)
)

(instance toAnnette of Talker
	(properties)

	(method (init)
		(= view (voAnnetteMouth view:))
		(= x (voAnnetteMouth x:))
		(= y (voAnnetteMouth y:))
		(= loop (voAnnetteMouth loop:))
		(= priority (voAnnetteMouth priority:))
		(voAnnetteMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voAnnetteMouth show:)
		(super dispose: &rest)
	)
)

(instance foBed of Feature
	(properties
		noun 1
		x 385
		y 322
		approachX 391
		approachY 285
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 408 161 324 182 274 226 247 262 238 279 243 293 271 533 272 536 197 548 149 586 111 624 97 639 98 639 292 627 307 629 321 636 338 620 342 606 370 580 371 575 385 585 384 579 399 568 409 562 432 524 432 518 416 509 413 489 419 490 439 446 441 430 407 401 408 401 389 377 389 378 407 362 406 358 395 330 394 329 407 289 409 287 395 265 395 264 407 247 407 251 367 230 361 206 360 194 372 204 423 192 422 191 411
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1 5 71 3 12 123)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(super doVerb: theVerb)
				((ScriptID 64017 0) set: 61) ; oFlags
			)
			(123 ; Climb in
				(gCurRoom setScript: soDoMrBoning)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDresser of Feature
	(properties
		x 319
		y 255
		approachX 325
		approachY 282
	)

	(method (init)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 244 230 218 262 205 399 204 408 216 408 262 289 259 272 239 249 237
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 3 12)
	)
)

(instance foCart of Feature
	(properties
		x 61
		y 349
		approachX 117
		approachY 315
	)

	(method (init)
		(= noun 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 387 1 246 9 231 79 226 87 280 82 366 40 391
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 5 3 12)
	)
)

(instance foDoor of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 57 113 89 113 267 81 272 79 225 42 226
					yourself:
				)
		)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 311 3 281)
	)
)

(instance ro310VerbHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(83 ; Undress
				(gCurRoom setScript: soDoMrBoning)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

