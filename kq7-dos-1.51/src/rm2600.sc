;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2600)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Plane)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm2600 0
	dragonTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm2600 of KQRoom
	(properties
		picture 2601
		screen_mid 2602
	)

	(method (init)
		(gEgo x: 150)
		(Load rsVIEW 2601)
		(Load rsVIEW 2604)
		(Load 140 (if (IsFlag 60) 2611 else 2612)) ; WAVE
		(super init:)
		(self setRect: 0 0 640 136)
		(gEgo x: -20 y: 100 init: normalize: setScaler: Scaler 60 25 129 50)
		(= local2 (gEgo moveSpeed:))
		(dragon init:)
		(gemPile init:)
		(myWestExit init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 92 0 136 70 136 70 118 51 116 51 106 95 98 123 94 129 41 140 37 179 49 143 128 171 136 271 136 263 65 277 53 308 48 319 47 347 48 352 55 327 135 533 135 525 125 538 109 577 98 599 75 591 67 565 83 487 85 476 73 471 73 461 73 492 98 375 125 349 107 360 48 360 42 313 42 277 47 257 60 263 117 229 131 193 130 154 113 192 46 153 31 112 33 104 87 51 100 42 100
					yourself:
				)
		)
		(sp0 init: setCycle: Fwd)
		(sp1 init: setCycle: Fwd)
		(sp2 init: setCycle: Fwd)
		(sp3 init: setCycle: Fwd)
		(sp4 init: setCycle: Fwd)
		(sp5 init: setCycle: Fwd)
		(sp6 init: setCycle: Fwd)
		(sp7 init: setCycle: Fwd)
		(sp8 init: setCycle: Fwd)
		(g1 init: setCycle: Fwd)
		(g2 init: setCycle: Fwd)
		(g3 init: setCycle: Fwd)
		(g4 init: setCycle: Fwd)
		(g5 init: setCycle: Fwd)
		(g6 init: setCycle: Fwd)
		(gKqMusic1 number: 2600 setLoop: -1 play:)
		(self setScript: enterRoom)
	)

	(method (updateExits param1)
		((ScriptID 19 0) ; eastFeat
			nsLeft: (- ((ScriptID 19 0) nsLeft:) param1) ; eastFeat
			nsRight: (- ((ScriptID 19 0) nsRight:) param1) ; eastFeat
		)
		((ScriptID 19 1) ; westFeat
			nsLeft: (- ((ScriptID 19 1) nsLeft:) param1) ; westFeat
			nsRight: (- ((ScriptID 19 1) nsRight:) param1) ; westFeat
		)
		(if
			(and
				(not east)
				(<= (gThePlane right:) 326)
				((ScriptID 19 0) scratch:) ; eastFeat
			)
			((ScriptID 19 0) setHotspot: 0) ; eastFeat
		)
		(if (and (not ((ScriptID 19 0) scratch:)) (> (gThePlane right:) 330)) ; eastFeat
			((ScriptID 19 0) setHotspot: 10 10) ; eastFeat, Exit, Exit
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (gEgo x:) 390)
				(if (!= (gEgo moveSpeed:) 4)
					(gEgo setSpeed: 4)
					(= local6 0)
				)
			)
			((< (gEgo x:) 400)
				(if (!= (gEgo moveSpeed:) local2)
					(gEgo setSpeed: local2)
				)
			)
			((and (not local6) (not script))
				(= local6 1)
				(gEgo setMotion: PolyPath 477 105)
			)
		)
	)
)

(instance gemPile of Feature
	(properties
		noun 1
		sightAngle 5
		approachX 520
		approachY 92
		x 520
		y 45
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 557 68 502 68 494 55 520 23 534 23 557 60
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(gMessager say: noun theVerb 1)
		(self dispose:)
		(return 1)
	)
)

(instance touchTail of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 8765)
					(gEgo setPri: 140 setMotion: MoveTo 575 80 self)
				)
				(1
					(gEgo setMotion: MoveTo 572 67 self)
				)
				(2
					(gEgo setHeading: 315 self)
				)
				(3
					(gEgo view: 8765 setLoop: 1 cel: 0 setCycle: End self)
				)
				(4
					(gMessager say: 4 register 0 0 self)
				)
				(5
					(gEgo
						normalize: 7
						setPri: 140
						setMotion: MoveTo 575 80 self
					)
				)
				(6
					(gEgo setMotion: MoveTo 510 94 self)
				)
				(7
					(gEgo setPri: -1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveSpark of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(SetFlag 60)
					(gGame handsOff: 1)
					(Load 140 2603) ; WAVE
					(Load 140 2604) ; WAVE
					(Load 140 2605) ; WAVE
					(Load 140 2606) ; WAVE
					(Load rsSOUND 2610)
					(Load 140 2480) ; WAVE
					(Load rsVIEW 2602)
					(Load rsVIEW 2603)
					(Load rsVIEW 26025)
					(dragon setScript: 0 view: 2601 setLoop: 3 cel: 0)
					(tail show:)
					(gEgo setHeading: 45 self)
				)
				(1
					(gMessager say: 2 44 0 1 self) ; "(TENTATIVE)Um, this doesn't happen to be the kind of spark you meant, does it?"
				)
				(2
					(gEgo setHeading: 135 self)
				)
				(3
					(gEgo
						setScale: 0
						view: 26025
						setLoop: 6
						cel: 0
						setCycle: CT 21 1 self
					)
				)
				(4
					(dragon view: 2602 setLoop: 1 cel: 0 setCycle: End self)
				)
				(5
					(dragon setLoop: 1 cel: 0 setCycle: End self)
				)
				(6
					(gMessager say: 2 44 0 2 self) ; "(EXCITED)A spark! Bless you, little troll! Here, let me have it!"
				)
				(7
					(dragon setLoop: 2 cel: 0 setCycle: End self)
				)
				(8
					(gEgo setCycle: End self)
					(gKqSound1 number: 2603 setLoop: 1 play:)
				)
				(9
					(dragon view: 26025 setLoop: 3 cel: 0 setCycle: CT 4 1 self)
					(gEgo
						setScaler: Scaler 60 25 129 50
						normalize: 6
						put: 36 ; Lantern_with_Spark
						get: 35 ; Lantern
					)
				)
				(10
					(gKqSound1 number: 2605 setLoop: 1 play:)
					(dragon setCycle: End self)
				)
				(11
					(dragon setLoop: 4 cel: 0 setCycle: End self)
					(gKqSound1 number: 2606 setLoop: 1 play:)
				)
				(12
					(dragon view: 2603 setLoop: 0 cel: 0 setCycle: End self)
				)
				(13
					(dragonTalker
						view: 2601
						loop: 21
						clientCel: -2
						mouth_x: -6
						mouth_y: 4
					)
					(gMessager say: 2 44 0 3 self) ; "(GRATEFUL, HAPPY)I am indebted to you. Here, take this diamond. With it you can live like a princess."
				)
				(14
					(dragonTalker view: -1 loop: -1 mouth_x: -999 mouth_y: -999)
					(gEgo setMotion: MoveTo 490 75 self)
				)
				(15
					(gEgo setHeading: 45 self)
				)
				(16
					(gEgo view: 8765 setLoop: 0 cel: 0 setCycle: CT 6 1 self)
				)
				(17
					(gEgo setCycle: End self)
					(dragon view: 2601 setLoop: 1 cel: (dragon lastCel:))
				)
				(18
					(gEgo normalize: 6 get: 37) ; Big_Gem
					(= ticks 30)
				)
				(19
					(gMessager sayRange: 2 44 0 4 5 self) ; "(NOT SURE SHE SHOULD ASK)"Thank you, it's beautiful...but what I'd really like is...one of your scales?"
				)
				(20
					(gEgo view: 8915 setLoop: 1 cel: 0 setCycle: End self)
				)
				(21
					(tail dispose:)
					(dragon
						view: 2603
						setLoop: 1
						cel: 0
						cycleSpeed: 16
						setCycle: CT 30 1 self
					)
					(gEgo posn: 468 76 setPri: 74 cel: 0 setCycle: End)
					(gKqMusic1 fade:)
				)
				(22
					(gKqMusic1 number: 2610 setLoop: -1 play:)
					(dragon setCycle: End self)
				)
				(23
					(gMessager say: 2 44 0 6 self) ; "Farewell!"
				)
				(24
					(= local3 1)
					(dragon dispose:)
					(= local4 gCast)
					(= local5 (Plane new:))
					(local5
						setRect: 0 0 319 (gThePlane bottom:)
						back: 0
						picture: 2610
						priority: 3000
						init:
						addCast: (= gCast (Cast new:))
					)
					(dragon
						init:
						view: 2610
						setLoop: 0
						cel: 0
						posn: 153 63
						cycleSpeed: 17
						setCycle: End self
					)
				)
				(25
					(dragon dispose:)
					(local5 dispose:)
					(= gCast local4)
					(gEgo
						normalize: 6
						posn: 460 80
						setMotion: MoveTo 482 70 self
					)
				)
				(26
					(gEgo
						view: 8835
						setLoop: 1
						cel: (gEgo lastCel:)
						setCycle: Beg self
					)
				)
				(27
					(= local5 (Plane new:))
					(local5
						setRect: 0 0 319 (gThePlane bottom:)
						back: 0
						picture: 2620
						priority: 3000
						init:
						addCast: (= gCast (Cast new:))
					)
					(dragon
						view: 2620
						posn: 36 92
						setLoop: 0
						cel: 0
						init:
						setCycle: CT 23 1 self
					)
				)
				(28
					(gKqSound1 number: 2606 setLoop: 1 setVol: 75 play:)
					(dragon setCycle: End self)
				)
				(29
					(dragon dispose:)
					(local5 dispose:)
					(= gCast local4)
					(gEgo x: 485)
					(= ticks 100)
				)
				(30
					(gKqSound1 number: 2480 setLoop: 1 setVol: 127 play: self)
					(gKqMusic1 fade:)
				)
				(31
					(gEgo setCycle: Beg self)
				)
				(32
					(gEgo normalize: 6 setMotion: MoveTo 505 94 self)
				)
				(33
					(gKqMusic1 number: 2600 setLoop: -1 play:)
					((gCurRoom obstacles:) release:)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 92 0 136 70 136 70 118 51 116 51 106 95 98 123 94 129 41 140 37 179 49 143 128 171 136 271 136 263 65 277 53 308 48 319 47 347 48 352 55 327 135 533 135 524 118 594 67 580 53 544 46 528 45 498 47 468 54 462 72 492 98 375 125 349 107 360 48 360 42 313 42 277 47 257 60 263 117 229 131 193 130 154 113 192 46 153 31 112 33 104 87 51 100 42 100
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 496 53 556 53 572 65 559 76 529 80 500 77 482 64
								yourself:
							)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(ClearFlag 539)
			(SetFlag 60)
			(if (gCast contains: dragon)
				(dragon dispose:)
			)
			(if (gCast contains: tail)
				(tail dispose:)
			)
			(if (gPlanes contains: local5)
				(local5 dispose:)
				(= gCast local4)
			)
			(gEgo
				posn: 509 85
				put: 36 ; Lantern_with_Spark
				get: 37 ; Big_Gem
				get: 35 ; Lantern
				setScaler: Scaler 60 25 129 50
				normalize: 2
				setMotion: 0
				posn: 505 94
			)
			(= cycles (= ticks (= seconds 0)))
			(gKqMusic1 number: 2600 setLoop: -1 play:)
			((gCurRoom obstacles:) release:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 0 92 0 136 70 136 70 118 51 116 51 106 95 98 123 94 129 41 140 37 179 49 143 128 171 136 271 136 263 65 277 53 308 48 319 47 347 48 352 55 327 135 533 135 524 118 594 67 580 53 544 46 528 45 498 47 468 54 462 72 492 98 375 125 349 107 360 48 360 42 313 42 277 47 257 60 263 117 229 131 193 130 154 113 192 46 153 31 112 33 104 87 51 100 42 100
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 496 53 556 53 572 65 559 76 529 80 500 77 482 64
						yourself:
					)
			)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance getScale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2604)
				(Load rsSOUND 2616)
				(sleep seconds: 1000)
				(gEgo setMotion: MoveTo 532 82 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 2604
					setLoop: 2
					cel: 0
					cycleSpeed: 14
					posn: 530 81
					setCycle: CT 21 1 self
				)
			)
			(3
				(gEgo setCycle: End self)
				(gKqSound1 number: 2616 setLoop: 1 play:)
			)
			(4
				(gEgo get: 27 normalize: 0 setMotion: MoveTo 510 94 self) ; Dragon_Scale
			)
			(5
				(sleep cycles: 4)
				(SetFlag 63)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getSquished of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2606)
				(Load rsSOUND 2611)
				(Load rsSOUND 2617)
				(dragon
					setScript: 0
					view: 2601
					setLoop: 3
					cel: 0
					setCycle: CT 7 1 self
				)
			)
			(1
				(dragon setCycle: End self)
				(gEgo setMotion: MoveTo 533 76 self)
				(gKqSound1 number: 2611 setLoop: 1 play:)
			)
			(2 0)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(tail hide:)
				(gEgo hide:)
				(dragon view: 2606 setLoop: 0 cel: 0 setCycle: CT 20 1 self)
			)
			(5
				(dragon setCycle: CT 44 1 self)
				(gKqSound1 number: 2617 setLoop: 1 play:)
			)
			(6
				(dragon setCycle: End self)
				(gKqSound1 number: 2617 setLoop: 1 play:)
			)
			(7
				(EgoDead 62 self)
			)
			(8
				(gEgo show: normalize: 2 posn: 500 88 setMotion: 0)
				(ClearFlag 371)
				(ClearFlag 372)
				(= local0 0)
				(dragon setScript: sleep)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dragon setScript: 0)
				(gEgo setHeading: 45 self)
			)
			(1
				(gMessager say: 2 8 1 1 self) ; "(FEARFUL BUT IN AWE OF THE DRAGON'S BEAUTY)Are...are you a dragon?"
			)
			(2
				(dragon view: 2601 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager sayRange: 2 8 1 2 6 self) ; "I am. Do not fear me, little troll."
			)
			(4
				(dragon setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(dragon setLoop: 3 cel: 0 setCycle: End self)
				(gKqSound1 number: 2612 setLoop: 1 play:)
			)
			(6
				(dragon setLoop: 0 cel: 0 setCycle: ForwardCounter 1 self)
			)
			(7
				(dragon setCycle: 0 setScript: sleep)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance saySecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dragon setScript: 0)
				(gEgo setHeading: 45 self)
			)
			(1
				(gMessager say: 2 8 2 1 self) ; "(GENTLY, NOT WANTING TO INTRUDE)What did you mean when you said you'd lost your will to live? Why?"
			)
			(2
				(dragon view: 2601 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 2 8 2 2 self) ; "(SAD, LONG-SUFFERING)I meant just what I said. I have lost my spark. My world has grown cold. Leave me to my sorrow, little troll."
			)
			(4
				(dragon setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(dragon setLoop: 3 cel: 0 setCycle: End self)
				(gKqSound1 number: 2612 setLoop: 1 play:)
			)
			(6
				(dragon setLoop: 0 cel: 0 setCycle: ForwardCounter 2 self)
			)
			(7
				(dragon setCycle: 0 setScript: sleep)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayOther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dragon setScript: 0)
				(gEgo setHeading: 45 self)
			)
			(1
				(dragon view: 2601 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (== register 8)
					(gMessager say: 2 8 3 0 self) ; "(SAD, NOT THREATENING)Leave me be, little creature."
				else
					(gMessager say: 0 0 4 0 self) ; "Pardon me, good dragon, but--"
				)
			)
			(3
				(dragon setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(dragon setCycle: 0 setScript: sleep)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useSpoonOnNose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo view: 8765 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 0)
				(= ticks 14)
			)
			(3
				(gMessager say: 4 34 0 0 self) ; "(THINKS TO HERSELF)Nope. Prying isn't going to work."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hitNoseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 472 75 self)
			)
			(1
				(gEgo view: 8765 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(cond
					(local1
						(gMessager say: 4 8 0 1 self) ; "(THINKS TO HERSELF)Rats. I'll NEVER get a scale with just my bare hands."
					)
					(local0
						(= local1 1)
						(gMessager say: 3 8 2 1 self) ; "(LOUDLY, URGENTLY)Please, good dragon, wake up! I truly NEED one of your scales!"
					)
					(else
						(= local0 1)
						(gMessager say: 3 8 1 1 self) ; "(TENTATIVE)Hello? Madam dragon? Wake up!"
					)
				)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useHammerOnNose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 75 setMotion: MoveTo 472 72 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 2604
					setLoop: 2
					cel: 0
					cycleSpeed: 14
					posn: 470 70
					setCycle: CT 21 1 self
				)
			)
			(3
				(gEgo setCycle: End self)
				(gKqSound1 number: 2616 setLoop: 1 play:)
			)
			(4
				(gEgo normalize: 6 setPri: 75 posn: 472 72)
				(= ticks 10)
			)
			(5
				(gMessager say: 3 46 1 1 self) ; "Oh, I'm sorry! I didn't mean--"
			)
			(6
				(gEgo setMotion: MoveTo 472 76 self)
			)
			(7
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 25 100 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsRight 20
		nsBottom 140
		approachX -40
		approachY 110
		x -50
		y 110
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 2550)
	)
)

(instance dragon of Prop
	(properties
		noun 2
		sightAngle 359
		approachX 472
		approachY 75
		x 469
		y 71
		view 2601
	)

	(method (init)
		(super init: &rest)
		(if (not local3)
			(tail init:)
			(self
				setPri: 73
				approachVerbs: 8 43 41 38 ; Do, Lantern, Wet_Sulfur, Shield
				signal: (| signal $1000)
				setScript: sleep
			)
			(cond
				((IsFlag 63)
					(self approachVerbs: 0)
				)
				((IsFlag 60)
					(self noun: 3 setHotspot: 8 10 46 34) ; Do, Exit, Hammer_and_Chisel, Silver_Spoon
				)
				(else
					(self setHotspot: 9998)
				)
			)
		)
	)

	(method (onMe param1)
		(if
			(or
				(> (param1 x:) 515)
				(and (not (IsFlag 371)) (== (gUser message:) 44))
			)
			(return 0)
		else
			(return (super onMe: param1 &rest))
		)
	)

	(method (dispose)
		(super dispose:)
		(tail dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; Lantern_with_Spark
				(gCurRoom setScript: giveSpark)
			)
			(46 ; Hammer_and_Chisel
				(self setHotspot: 0)
				(gCurRoom setScript: useHammerOnNose)
			)
			(34 ; Silver_Spoon
				(if (not (IsFlag 60))
					(gCurRoom setScript: sayOther 0 theVerb)
				else
					(gCurRoom setScript: useSpoonOnNose)
				)
			)
			(8 ; Do
				(cond
					((IsFlag 60)
						(gCurRoom setScript: hitNoseScript)
					)
					((IsFlag 372)
						(gCurRoom setScript: sayOther 0 8)
					)
					((IsFlag 371)
						(SetFlag 372)
						(gCurRoom setScript: saySecond)
					)
					(else
						(SetFlag 371)
						(gCurRoom setScript: sayFirst)
					)
				)
			)
			(else
				(gCurRoom setScript: sayOther 0 theVerb)
			)
		)
		(return 1)
	)
)

(instance tail of Prop
	(properties
		noun 4
		approachX 513
		approachY 82
		x 468
		y 71
		view 2601
		loop 4
	)

	(method (hide)
		(self
			setPri: 0
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 480 70 555 70 555 83 480 83
					yourself:
				)
		)
	)

	(method (show)
		(self setPri: 72 setPolygon: 0)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 72 signal: (| signal $1000))
		(if (and (not (IsFlag 63)) (IsFlag 60))
			(self
				signal: (| signal $1000)
				setHotspot: 8 10 34 46 ; Do, Exit, Silver_Spoon, Hammer_and_Chisel
				approachVerbs: 8 34 46 ; Do, Silver_Spoon, Hammer_and_Chisel
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; Hammer_and_Chisel
				(gCurRoom
					setScript:
						(if local7
							(dragon setHotspot: 0)
							(self setHotspot: 0)
							getScale
						else
							getSquished
						)
				)
			)
			(34 ; Silver_Spoon
				(gCurRoom setScript: touchTail 0 theVerb)
			)
			(8 ; Do
				(gCurRoom setScript: touchTail 0 theVerb)
			)
		)
		(return 1)
	)
)

(instance sleep of Script
	(properties)

	(method (dispose)
		(tail show:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragon cel: 0 view: 2601 setLoop: 3)
				(tail show:)
				(= seconds (Random 5 7))
			)
			(1
				(dragon view: 2601 setLoop: 3 cel: 0 setCycle: CT 7 1 self)
			)
			(2
				(dragon setCycle: End self)
				(if (IsFlag 60)
					(gKqSound1 number: 2611 setLoop: 1 play:)
				else
					(gKqSound1 number: 2612 setLoop: 1 play:)
				)
			)
			(3
				(= register
					(switch (mod (Random 0 30) 4)
						(0 0)
						(1 1)
						(2 4)
						(else 5)
					)
				)
				(if (IsFlag 60)
					(= register
						(switch register
							(1 4)
							(0 5)
							(else register)
						)
					)
				else
					(= register (if (!= register 0) 5 else 0))
				)
				(if (!= register 5)
					(if (!= register 0)
						(dragon view: 2604)
						(tail hide:)
					else
						(tail show:)
					)
					(dragon setLoop: register cel: 0 setCycle: End self)
				else
					(tail show:)
					(self init:)
				)
			)
			(4
				(if (== register 4)
					(= local7 1)
					(= seconds (Random 5 9))
				else
					(self init:)
				)
			)
			(5
				(= local7 0)
				(dragon setCycle: Beg self)
			)
			(6
				(self init:)
			)
		)
	)
)

(instance dragonTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client dragon)
		(super init: &rest)
	)
)

(instance sp0 of Prop
	(properties
		x 401
		y 44
		priority 150
		fixPriority 1
		view 2605
		cel 6
	)
)

(instance sp1 of Prop
	(properties
		x 534
		y 23
		priority 150
		fixPriority 1
		view 2605
		loop 1
		cel 13
		cycleSpeed 4
	)
)

(instance sp2 of Prop
	(properties
		x 566
		y 91
		priority 150
		fixPriority 1
		view 2605
		loop 2
		cel 5
	)

	(method (init)
		(super init:)
	)
)

(instance sp3 of Prop
	(properties
		x 478
		y 20
		priority 150
		fixPriority 1
		view 2605
		loop 3
		cel 4
		cycleSpeed 7
	)
)

(instance sp4 of Prop
	(properties
		x 636
		y 79
		priority 79
		fixPriority 1
		view 2605
		loop 4
		cel 13
		cycleSpeed 9
	)
)

(instance sp5 of Prop
	(properties
		x 336
		y 48
		priority 200
		fixPriority 1
		view 2605
		loop 5
		cel 8
		cycleSpeed 4
	)
)

(instance sp6 of Prop
	(properties
		x 561
		y 6
		view 2605
		loop 6
		cel 1
		cycleSpeed 10
	)
)

(instance sp7 of Prop
	(properties
		x 373
		y 94
		priority 110
		fixPriority 1
		view 2605
		loop 6
		cel 10
	)
)

(instance sp8 of Prop
	(properties
		x 542
		y 117
		priority 200
		fixPriority 1
		view 2605
		loop 6
		cel 1
	)
)

(instance g1 of Prop
	(properties
		x 106
		y 16
		priority 500
		fixPriority 1
		view 2605
		cel 14
		cycleSpeed 7
	)
)

(instance g2 of Actor
	(properties
		x 221
		y 58
		priority 500
		fixPriority 1
		view 2605
		loop 3
		cel 4
		cycleSpeed 4
	)
)

(instance g3 of Actor
	(properties
		x 114
		y 106
		priority 500
		fixPriority 1
		view 2605
		loop 2
		cel 5
	)

	(method (init)
		(super init:)
	)
)

(instance g4 of Actor
	(properties
		x 81
		y 38
		priority 500
		fixPriority 1
		view 2605
		loop 2
		cel 13
		cycleSpeed 5
	)
)

(instance g5 of Actor
	(properties
		x 312
		y 95
		priority 95
		fixPriority 1
		view 2605
		loop 2
		cel 5
		cycleSpeed 8
	)
)

(instance g6 of Actor
	(properties
		x 164
		y 12
		priority 500
		fixPriority 1
		view 2605
		cel 10
	)
)

