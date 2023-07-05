;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42200)
(include sci.sh)
(use Main)
(use oInvHandler)
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
	roCannonBall 0
)

(local
	bTorinInPlace
	bFF
	bReachedDecision
)

(procedure (StartMachine)
	(goMusic1 playSound: 42299)
	(poFlag setCycle: Fwd)
	(poEyes setCycle: Fwd)
	(poNose setScript: (soSwingShip new:))
	(poMouth setScript: (soSwingShip new:))
	(poWindMill setCycle: Fwd)
	(poShip setScript: (soSwingShip new:))
)

(procedure (StopMachine)
	(goMusic1 setMusic: 40300)
	(poFlag setCycle: 0)
	(poEyes setCycle: 0)
	(poNose setScript: 0 cel: 0)
	(poMouth setScript: 0)
	(poWindMill setCycle: 0)
	(poShip setScript: 0)
	(poFlap setCycle: 0 cel: 0)
	(poDoors setCycle: 0 cel: 0)
)

(instance foExitToIsland of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(self setRect: 610 0 632 316)
	)

	(method (doVerb)
		(gEgo setScript: soExit)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 662 300 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExit) ; oBoogle
				(gEgo setMotion: MoveTo 662 300 self)
			)
			(2
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance soBoogleExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBoogle loop: 1 cel: 0 doit: setCycle: End)
			)
		)
	)
)

(instance soBoogleEnter of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 284 344
					doit:
					setMotion: MoveTo 284 304 self
				)
			)
			(1
				((ScriptID 64018 0) setHeading: 135 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogle
					loop: 0
					cel: 0
					posn: 284 304
					setScaleDirect: ((ScriptID 64018 0) scaleX:) ; oBoogle
					init:
					setCycle: End
				)
				(self dispose:)
			)
		)
	)
)

(instance soWalkIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 662 300 setMotion: MoveTo 600 300 self)
				((ScriptID 64018 0) setScript: soBoogleEnter) ; oBoogle
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkIn of TPScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 672 300
					setMotion: MoveTo 610 300 self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance poBoogle of Prop
	(properties
		view 60201
	)
)

(instance foCoinBox of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 404 252 432 241 446 248 446 281 420 292 403 280
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (>= (NumCannonballsOwned) 5)
			(gMessager say: 1 1 2 0 0 40200) ; "I think five of these is just about all I can handle!"
		else
			(gCurRoom setScript: soSendCannonballDown)
		)
	)
)

(instance foCatch of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 592 293 543 295 474 302 477 314 594 315
					yourself:
				)
		)
	)

	(method (doVerb)
		(= bTorinInPlace 0)
		(gEgo setScript: soGetInPlace)
	)
)

(instance foBallDispenser of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 312 20 171 58 163 53 110 97 100 104 46 140 44 148 13 173 14 195 1 357 1 381 29 391 7 402 34 417 44 417 63 453 71 410 107 441 116 436 136 467 147 453 202 424 215 371 270 361 302 302 288 244 289 193 303 180 312
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if (or (gCurRoom script:) (gEgo script:))
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (doVerb)
		(gEgo setScript: soLookAtBallMachine)
	)
)

(instance soLookAtBallMachine of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(gMessager say: 7 1 0 0 self 40200) ; "It's nice to see a military-industrial complex with a sense of humor! (Of course, maybe that's why there's no one left around here.)"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poCannonball of Prop
	(properties
		view 42200
		cycleSpeed 4
	)
)

(instance poLavaBubble of Prop
	(properties
		priority 2
		fixPriority 1
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(self setScaler: Scaler 100 50 200 97)
		(self setScript: (soRandomBubble new:))
	)
)

(instance soRandomBubble of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(= ticks (Random 30 250))
			)
			(1
				(= register (Random 0 4))
				(switch register
					(0)
					(1
						(client x: (+ (client x:) 5))
					)
					(2
						(client x: (- (client x:) 5))
					)
					(3
						(client y: (+ (client y:) 3))
					)
					(4
						(client y: (- (client y:) 3))
					)
				)
				(client
					cel: 0
					loop: (Random 2 4)
					cycleSpeed: (Random 6 10)
					show:
					setCycle: End self
				)
			)
			(2
				(switch register
					(0)
					(1
						(client x: (- (client x:) 5))
					)
					(2
						(client x: (+ (client x:) 5))
					)
					(3
						(client y: (- (client y:) 3))
					)
					(4
						(client y: (+ (client y:) 3))
					)
				)
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance voPole of View
	(properties
		x 336
		y 45
		priority 5
		fixPriority 1
		view 42200
		loop 16
	)
)

(instance poShip of Prop
	(properties
		x 339
		y 44
		priority 500
		fixPriority 1
		view 42200
		loop 17
	)
)

(instance soSwingShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= ticks 20)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= ticks 20)
			)
			(4
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(client setCycle: 0)
		(super dispose: &rest)
	)
)

(instance poWindMill of Prop
	(properties
		x 97
		y 193
		priority 500
		fixPriority 1
		view 42200
		loop 15
	)
)

(instance poFireWorks of Prop
	(properties
		x 427
		y 129
		priority 129
		fixPriority 1
		view 42200
		loop 14
	)
)

(instance poFlap of Prop
	(properties
		x 219
		y 213
		priority 10
		fixPriority 1
		view 42200
		loop 13
	)
)

(instance poDoors of Prop
	(properties
		x 118
		y 173
		priority 10
		fixPriority 1
		view 42200
		loop 12
	)
)

(instance poMouth of Prop
	(properties
		x 281
		y 223
		priority 10
		fixPriority 1
		view 42200
		loop 11
	)
)

(instance poNose of Prop
	(properties
		x 267
		y 178
		priority 178
		fixPriority 1
		view 42200
		loop 10
	)
)

(instance poEyes of Prop
	(properties
		x 268
		y 164
		priority 164
		fixPriority 1
		view 42200
		loop 9
	)
)

(instance poFlag of Prop
	(properties
		x 264
		y 148
		priority 148
		fixPriority 1
		view 42200
		loop 8
	)
)

(instance coKillMachine of CueMe ; UNUSED
	(properties)

	(method (cue)
		(StopMachine)
	)
)

(instance poTorin of Prop
	(properties
		x 553
		y 306
		view 42200
		loop 7
	)
)

(instance oBallSounds of TPSound
	(properties)
)

(instance oFireworks of TPSound
	(properties)
)

(instance soSendCannonballDown of TPScript
	(properties
		bHasRew 1
	)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bHasFF 0)
				(self setButtons:)
				(= bReachedDecision 0)
				(gEgo setMotion: PolyPath 452 312 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64017 0) set: 131) ; oFlags
				(foCatch init:)
				(oBallSounds
					preload: 42104 42201 42210 42207 42202 42203 42205 42204
				)
				(gEgo setHeading: 315 self)
			)
			(2
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(3
				(goSound1 playSound: 42201)
			)
			(4
				(= bHasFF 1)
				(self setButtons:)
				(StartMachine)
				(foCoinBox deleteHotspotVerb: 1)
				(gGame handsOn:)
				(oBallSounds setAmbient: 42202)
				(poCannonball
					loop: 0
					cel: 0
					posn: 376 90
					setPri: 130
					init:
					setCycle: CT 12 1 self
				)
			)
			(5
				(oBallSounds setAmbient: 42203)
				(poCannonball setCycle: End self)
			)
			(6
				(poFireWorks cel: 0 init: setCycle: End coKillFireWorks)
				(oFireworks playSound: 42210)
				(oBallSounds setAmbient: 42202)
				(= ticks 30)
			)
			(7
				(poCannonball
					loop: 1
					cel: 0
					posn: 381 166
					setCycle: CT 4 1 self
				)
			)
			(8
				(poCannonball setPri: 160 setCycle: End self)
			)
			(9
				(= ticks 60)
			)
			(10
				(poCannonball
					loop: 2
					cel: 0
					posn: 166 216
					setPri: 9
					setCycle: CT 1 1 self
				)
				(poFlap cel: 0 setCycle: End coRestoreFlap)
			)
			(11
				(poCannonball setPri: 210 setCycle: End self)
			)
			(12
				(oBallSounds setAmbient: 42205)
				(= ticks 90)
			)
			(13
				(oBallSounds setAmbient: 42202)
				(poCannonball
					loop: 3
					cel: 0
					posn: 87 183
					setPri: 1
					setCycle: CT 3 1 self
				)
			)
			(14
				(poCannonball setPri: 180 setCycle: CT 18 1 self)
			)
			(15
				(poDoors cel: 0 setCycle: End coResetDoors)
				(poCannonball setCycle: CT 21 1 self)
			)
			(16
				(poCannonball setPri: 2 setCycle: End self)
			)
			(17
				(oBallSounds setAmbient: 42205)
				(= ticks 180)
			)
			(18
				(oBallSounds playSound: 42204)
				(poCannonball
					loop: 4
					cel: 0
					posn: 186 92
					setPri: 90
					setCycle: CT 27 1 self
				)
			)
			(19
				(oBallSounds setAmbient: 42202)
				(poCannonball setPri: 200 setCycle: CT 34 1 self)
			)
			(20
				(poCannonball setPri: 90 setCycle: End self)
			)
			(21
				(= ticks 60)
			)
			(22
				(poCannonball loop: 5 cel: 0 posn: 412 92 setCycle: End self)
			)
			(23
				(foCatch dispose:)
				(= bReachedDecision 1)
				(if (> (gEgo x:) 460)
					(gCurRoom setScript: soNabBall)
				else
					(self cue:)
				)
			)
			(24
				(= ticks 60)
			)
			(25
				(= bReachedDecision 1)
				(oBallSounds setAmbient: 42202)
				(= ticks 0)
				(self cue:)
			)
			(26
				(= cycles 1)
			)
			(27
				(if (!= (poMouth cel:) 7)
					(self changeState: (- state 1))
				else
					(self cue:)
				)
			)
			(28
				(poMouth cel: 7 setCycle: 0 setScript: 0)
				(poCannonball loop: 6 cel: 0 posn: 449 233 setPri: 0)
				(= ticks (poCannonball cycleSpeed:))
			)
			(29
				(poCannonball cel: 1 setPri: 90 doit: setCycle: CT 4 1 self)
			)
			(30
				(poMouth setScript: (soSwingShip new:))
				(poCannonball setPri: 90 setCycle: CT 18 1 self)
			)
			(31
				(oBallSounds setAmbient: 0)
				(poCannonball setCycle: CT 23 1 self)
			)
			(32
				(oBallSounds playSound: 42207)
				(poCannonball setCycle: End self)
			)
			(33
				(StopMachine)
				(poCannonball dispose:)
				(= ticks 30)
			)
			(34
				(goSound1 playSound: 42104)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(foCoinBox addHotspotVerb: 1)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(foCatch dispose:)
		(self setScript: 0)
		(goSound1 stop:)
		(poCannonball dispose:)
		(StopMachine)
		(gEgo setScript: 0 posn: 452 312 normalize: 1 60100 7 show:)
		(gCurRoom setScript: self)
	)

	(method (ff)
		(self setScript: 0)
		(foCatch dispose:)
		(goSound1 stop:)
		((ScriptID 64018 0) setWander: 1) ; oBoogle
		(cond
			(bReachedDecision
				(if (< state 25)
					(self changeState: 25)
				else
					(poCannonball dispose:)
					(foCoinBox addHotspotVerb: 1)
					(oBallSounds setAmbient: 0)
					(StopMachine)
					(self dispose:)
				)
			)
			((> (gEgo x:) 460)
				(= bFF 1)
				(gCurRoom setScript: soNabBall)
			)
			(else
				(self changeState: 25)
			)
		)
	)
)

(instance soNabBall of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oBallSounds setAmbient: 42202)
				(= bTorinInPlace 0)
				(gEgo setScript: soGetInPlace)
				(if bFF
					(= bFF 0)
					(poCannonball setCycle: 0 hide:)
					(self cue:)
				else
					(= ticks 60)
				)
			)
			(1
				(= ticks 10)
			)
			(2
				(if (not bTorinInPlace)
					(-= state 2)
				)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (!= (poMouth cel:) 7)
					(-= state 2)
				)
				(= cycles 1)
			)
			(5
				(poMouth cel: 7 setCycle: 0 setScript: 0)
				(poCannonball loop: 6 cel: 0 posn: 449 233 setPri: 0 show:)
				(= ticks (poCannonball cycleSpeed:))
			)
			(6
				(poCannonball cel: 1 setPri: 90 doit: setCycle: CT 4 1 self)
			)
			(7
				(poMouth setScript: (soSwingShip new:))
				(poCannonball setPri: 90 setCycle: CT 18 1 self)
			)
			(8
				(oBallSounds setAmbient: 0)
				(poCannonball setCycle: CT 21 1 self)
			)
			(9
				(poCannonball dispose:)
				(gEgo hide:)
				(poTorin cel: 0 init: setCycle: End self)
			)
			(10
				(poTorin dispose:)
				(if (not (GetUnheldCannonball))
					(PrintDebug {no cannonballs left})
				else
					(gEgo get: (GetUnheldCannonball))
					((ScriptID 64017 0) set: 132) ; oFlags
				)
				(gEgo posn: 556 310 normalize: 1 60100 4 show:)
				(StopMachine)
				(if (not ((ScriptID 64017 0) test: 135)) ; oFlags
					((ScriptID 64017 0) set: 135) ; oFlags
					(gMessager say: 1 1 1 0 self 40200) ; "Ough! Stone cannonballs! Man, these suckers are heavy."
				else
					(self cue:)
				)
			)
			(11
				(foCoinBox addHotspotVerb: 1)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(if (and (!= (gCurRoom script:) self) (GetHeldCannonball))
			(gEgo put: (GetHeldCannonball))
		)
		(foCatch dispose:)
		(poTorin dispose:)
		(goSound1 stop:)
		(oBallSounds setAmbient: 0)
		(poCannonball dispose:)
		(StopMachine)
		(gEgo setScript: 0 posn: 452 312 normalize: 1 60100 7 show:)
		(foCoinBox deleteHotspotVerb: 1)
		(gCurRoom setScript: soSendCannonballDown)
	)

	(method (ff)
		(goSound1 stop:)
		(foCatch dispose:)
		((ScriptID 64018 0) setWander: 1) ; oBoogle
		(poTorin dispose:)
		(if (not (GetUnheldCannonball))
			(PrintDebug {no cannonballs left})
		else
			(gEgo get: (GetUnheldCannonball))
			((ScriptID 64017 0) set: 132) ; oFlags
		)
		(gEgo setScript: 0 posn: 556 310 normalize: 1 60100 4 show:)
		(poCannonball dispose:)
		(StopMachine)
		(foCoinBox addHotspotVerb: 1)
		(oBallSounds setAmbient: 0)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance coKillFireWorks of CueMe
	(properties)

	(method (cue)
		(poFireWorks dispose:)
	)
)

(instance coRestoreFlap of CueMe
	(properties)

	(method (cue)
		(poFlap cel: 0)
	)
)

(instance coResetDoors of CueMe
	(properties)

	(method (cue)
		(poDoors cel: 0)
	)
)

(instance soGetInPlace of TPScript
	(properties
		bKillRew 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 484 312 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= bTorinInPlace 1)
				(self dispose:)
			)
		)
	)
)

(instance roCannonBall of TPRoom
	(properties
		picture 42200
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 40300)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 436 314 629 314 628 295 548 295
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 200 309 207 314 381 314 310 292 252 292
					yourself:
				)
		)
		(poFlag init:)
		(poEyes init:)
		(poNose init:)
		(poMouth init:)
		(poDoors init:)
		(poFlap init:)
		(voPole init:)
		(poWindMill init:)
		(poShip init:)
		(foCoinBox init:)
		(foBallDispenser init:)
		((poLavaBubble new:) posn: 45 293 init:)
		((poLavaBubble new:) posn: 18 221 init:)
		((poLavaBubble new:) posn: 28 153 init:)
		((poLavaBubble new:) posn: 24 96 init:)
		((poLavaBubble new:) posn: 74 92 init:)
		((poLavaBubble new:) posn: 471 121 init:)
		((poLavaBubble new:) posn: 528 94 init:)
		(foExitToIsland init:)
		(gEgo init: normalize: setScalePercent: 75)
		((ScriptID 64018 0) posn: 610 300 init: normalize: setScalePercent: 75) ; oBoogle
		(gGame handsOn:)
		((ScriptID 64017 0) set: 138) ; oFlags
		(gEgo setScript: soWalkIn)
	)

	(method (gimme))
)

