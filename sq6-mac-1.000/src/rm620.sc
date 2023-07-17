;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use n666)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm620 0
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	local5
	local6
)

(instance rm620 of SQRoom
	(properties
		noun 1
		picture 620
	)

	(method (init)
		(SetFlag 53)
		(gEgo init: hide: normalize: code: scrollCode)
		(Load 140 621 622 624 702) ; WAVE
		(Load rsVIEW 6222 6210 6240 627)
		(if (and (IsFlag 99) (IsFlag 98))
			(= picture 625)
		)
		(super init:)
		(switch gPrevRoomNum
			(610
				(= local0 3)
				(gGSound2 stop:)
				(crawlPoly init:)
				(gCurRoom addObstacle: crawlPoly)
				((gCurRoom plane:) setRect: 0 0 319 416)
				(self setScript: sEgoEnterFromUlcer)
			)
			(640
				(= local0 5)
				(climbPoly init:)
				(gCurRoom addObstacle: climbPoly)
				(if (IsFlag 99)
					(if (IsFlag 98)
						(gCast eachElementDo: #hide)
						(dednan1 init:)
						(dednan2 init:)
						(dednan3 init:)
						(twinkie init:)
						((gCurRoom plane:) setRect: 0 0 319 138)
						(gGame handsOff:)
						(self setScript: sDrowning)
					else
						((gCurRoom plane:) setRect: 0 -270 319 138)
						(gGame handsOff:)
						(self setScript: sTwinkieFalls)
					)
				else
					(Load 140 691) ; WAVE
					(gEgo
						posn: 159 86
						view: 6221
						setLoop: 1 1
						show:
						setCycle: Walk
					)
					((gCurRoom plane:) setRect: 0 0 319 416)
					(gGame handsOn:)
				)
			)
			(650
				(= local0 4)
				(genPoly init:)
				(gCurRoom addObstacle: genPoly)
				(Load 140 691) ; WAVE
				(gEgo posn: 48 365 show: normalize: 0)
				((gCurRoom plane:) setRect: 0 -270 319 138)
				(gGame handsOn:)
			)
			(else
				(= local0 4)
				(genPoly init:)
				(gCurRoom addObstacle: genPoly)
				(Load 140 691) ; WAVE
				(gEgo posn: 176 348 show: normalize: 0)
				((gCurRoom plane:) setRect: 0 -270 319 138)
				(gGame handsOn:)
			)
		)
		(UpdatePlane plane)
		(if (not (IsFlag 98))
			(topNan init: setCycle: Fwd)
			(frontNan init: setCycle: Fwd)
			(sideNan1 init: setCycle: Fwd)
			(sideNan2 init: setCycle: Fwd)
		)
		(if (not (IsFlag 99))
			(smallBubble init: setScript: sBubbles)
		)
		(bigBubble init:)
		(oneBubble init:)
		(leftDrop init: setScript: sDrops)
		(rightDrop init:)
		(ctrDrkDrop init:)
		(ctrLghtDrop init:)
		(if (not (IsFlag 98))
			(if (not (IsFlag 170))
				(yMnm init: approachVerbs: 4) ; Do
			)
			(if (not (IsFlag 168))
				(rMnm init: approachVerbs: 4) ; Do
			)
			(if (not (IsFlag 169))
				(gMnm init: approachVerbs: 4) ; Do
			)
			(if (not (IsFlag 477))
				(feather init: approachVerbs: 4) ; Do
			)
		)
		(if (and (IsFlag 93) (IsFlag 92))
			(tablet init: approachVerbs: 114 4) ; Eva_Helmet, Do
		)
		(if
			(and
				(not (and (IsFlag 99) (IsFlag 98)))
				(or
					(IsFlag 107)
					(and (not (gEgo has: 17)) (not (gEgo has: 56))) ; Celery, Grappling_Hook
				)
			)
			(celery init:)
		)
		(if
			(and
				(not (IsFlag 107))
				(not (gEgo has: 104)) ; Staple
				(not (gEgo has: 56)) ; Grappling_Hook
			)
			(staple init: approachVerbs: 4) ; Do
		)
		(if (and (IsFlag 99) (IsFlag 98))
			(ClearFlag 99)
		)
		(acidPoolNear init:)
		(acidPoolFar init:)
		(ulcer init:)
		(ceiling init:)
		(walls init: approachVerbs: 4) ; Do
		(gGSound1 number: 620 loop: -1 play:)
		(if (IsFlag 107)
			(exitToEsoph init: gTheExitNCursor)
		)
		(if (IsFlag 98)
			(exit650 init: gTheExitWCursor)
		)
		(exit610 init: gTheExitECursor)
		(gWalkHandler addToFront: self)
		(if (== global173 0)
			(= global173 3)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 640)
	)

	(method (doit)
		(if
			(and
				(not (IsFlag 98))
				(< (gEgo x:) 115)
				(> (gEgo y:) 344)
				(< (gEgo y:) 397)
				(not (self script:))
			)
			(self setScript: sNanitesRipRoger)
		)
		(if (== local0 5)
			(cond
				(
					(and
						(gEgo mover:)
						(< ((gEgo mover:) yLast:) (gEgo y:))
					)
					(gEgo setLoop: 1 1)
				)
				(
					(and
						(gEgo mover:)
						(> ((gEgo mover:) yLast:) (gEgo y:))
					)
					(gEgo setLoop: 0 1)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(145 ; Grappling_Hook
				(if (not (IsFlag 107))
					(cond
						(
							(and
								(ulcer onMe: gEgo)
								(< gMouseY 63)
								(not (gEgo script:))
							)
							(exitToEsoph init: gTheExitNCursor approachVerbs: 9) ; ExitUp
							(gEgo setScript: sHookWedged)
						)
						(
							(and
								(== local0 4)
								(< gMouseY 21)
								(not (gEgo script:))
							)
							(gEgo setScript: sThrowHookUp)
						)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 98)
					(gMessager say: 1 1) ; "The inside of Stellar's tummy is slippery, mostly because of the mucus secreted by the stomach lining, and there are a few pock marks here and there, but when push comes to shove, this is the most beautiful stomach you've ever been in."
				else
					(gMessager say: 1 1 3) ; "The inside of Stellar's tummy is slippery, mostly because of the mucus secreted by the stomach lining, and there are a few pock marks here and there, but when push comes to shove, this is the most beautiful stomach you've ever been in."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== local0 5)
					(== (gEgo y:) 338)
					(> (event y:) 346)
					(not (gEgo script:))
				)
				(climbPoly dispose:)
				((gCurRoom obstacles:) delete: climbPoly)
				(= local0 4)
				(genPoly init:)
				(gCurRoom addObstacle: genPoly)
				(gEgo posn: 155 344 normalize: 0)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(== local0 3)
					(>= (gEgo y:) 354)
					(> (event y:) 341)
					(not (gEgo script:))
				)
				(crawlPoly dispose:)
				((gCurRoom obstacles:) delete: crawlPoly)
				(= local0 4)
				(genPoly init:)
				(gCurRoom addObstacle: genPoly)
				(gEgo posn: 220 355 normalize: 3)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(gEgo setScale: 0 normalize:)
		(super dispose:)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 2)
		(if
			(and
				(> (+ (gEgo y:) temp2) 81)
				(> temp4 139)
				(gEgo mover:)
				(> (gEgo y:) ((gEgo mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (- temp2 temp0) temp3 (- (+ temp2 416) temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo y:) temp2) 79)
				(< temp2 0)
				(gEgo mover:)
				(< (gEgo y:) ((gEgo mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (+ temp2 temp0) temp3 (+ temp2 416 temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sEgoEnterFromUlcer of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 691) ; WAVE
				(= cycles 3)
			)
			(1
				(gEgo
					posn: 291 76
					view: 6202
					loop: 0
					cel: 0
					cycleSpeed: 12
					init:
					setCycle: End self
				)
			)
			(2
				(gEgo view: 6202 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gEgo posn: 288 125 view: 619 setLoop: 0 1 setCycle: Walk)
				(= cycles 1)
			)
			(4
				(= temp4 5)
				(= temp0 ((gCurRoom plane:) left:))
				(= temp2 ((gCurRoom plane:) right:))
				(= temp3 ((gCurRoom plane:) bottom:))
				(= temp1 ((gCurRoom plane:) top:))
				(if (> ((gCurRoom plane:) top:) -55)
					((gCurRoom plane:)
						setRect:
							temp0
							(- temp1 temp4)
							temp2
							(- (+ temp1 416) temp4)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrops of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (Random 0 2))
				(if (Random 0 1)
					(leftDrop cel: 0 setCycle: End)
				)
				(cond
					((== local6 0)
						(ctrLghtDrop cel: 0 setCycle: End)
						(ctrDrkDrop cel: 0 setCycle: End self)
					)
					((== local6 1)
						(ctrLghtDrop cel: 0 setCycle: End self)
					)
					((== local6 2)
						(ctrDrkDrop cel: 0 setCycle: End self)
					)
				)
			)
			(1
				(cond
					((== local6 0)
						(rightDrop cel: 0 setCycle: End self)
					)
					((== local6 1)
						(rightDrop posn: 204 323 cel: 0 setCycle: End self)
					)
					((== local6 2)
						(rightDrop posn: 278 331 cel: 0 setCycle: End self)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sBubbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (Random 0 4))
				(= local5 (RandomNumber 0 2))
				(= ticks (Random 60 120))
			)
			(1
				(if (Random 0 1)
					(bubbleSnd setVol: 64 play:)
					(smallBubble setCycle: Fwd)
				else
					(smallBubble setCycle: End)
				)
				(cond
					((== local4 0)
						(bubbleSnd setVol: 64 play:)
						(bigBubble posn: 144 381 setCycle: Fwd)
					)
					((== local4 1)
						(bubbleSnd setVol: 64 play:)
						(bigBubble posn: 147 395 setCycle: Fwd)
					)
					((== local4 2)
						(bubbleSnd setVol: 64 play:)
						(bigBubble posn: 174 405 setCycle: Fwd)
					)
					((== local4 3)
						(bubbleSnd setVol: 64 play:)
						(bigBubble posn: 226 394 setCycle: Fwd)
					)
					(else
						(bigBubble setCycle: End)
					)
				)
				(cond
					((== local5 0)
						(bubbleSnd setVol: 64 play:)
						(oneBubble posn: 130 337 cycleSpeed: 10 setCycle: Fwd)
					)
					((== local5 1)
						(bubbleSnd setVol: 64 play:)
						(oneBubble posn: 89 342 cycleSpeed: 10 setCycle: Fwd)
					)
					((== local5 2)
						(bubbleSnd setVol: 64 play:)
						(oneBubble posn: 109 342 cycleSpeed: 10 setCycle: Fwd)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sThrowHookUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 176 348 self)
			)
			(1
				(gGame handsOff:)
				(= scratch (Random 2 5))
				(gEgo
					view: 6220
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(if scratch
					(-- state)
				)
				(-- scratch)
				(gEgo view: 6220 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 6220 loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo posn: 158 350 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHookWedged of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 287 132 self)
			)
			(1
				(= temp4 5)
				(= temp0 ((gCurRoom plane:) left:))
				(= temp2 ((gCurRoom plane:) right:))
				(= temp3 ((gCurRoom plane:) bottom:))
				(= temp1 ((gCurRoom plane:) top:))
				(if (< ((gCurRoom plane:) top:) -5)
					((gCurRoom plane:)
						setRect: temp0 (+ temp1 temp4) temp2 (+ temp1 416 temp4)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gEgo
					posn: 291 83
					view: 6202
					loop: 2
					cel: 10
					cycleSpeed: 9
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					put: 56 ; Grappling_Hook
					posn: 291 83
					view: 627
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(gMessager say: 4 145 8 0 self) ; "Nice shot!"
			)
			(5
				(SetFlag 107)
				(celery init:)
				(if (== local0 3)
					(crawlPoly dispose:)
					((gCurRoom obstacles:) delete: crawlPoly)
					(= local0 4)
					(genPoly init:)
					(gCurRoom addObstacle: genPoly)
				)
				(= cycles 1)
			)
			(6
				(gEgo posn: 176 348 normalize: 1)
				((gCurRoom plane:) setRect: 0 -276 319 140)
				(UpdatePlane (gCurRoom plane:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNanitesRipRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(frontNan setCycle: CT 4 1)
				(topNan setCycle: CT 14 1)
				(sideNan1 setCycle: CT 8 1)
				(sideNan2 setCycle: CT 9 1)
				(gEgo setHeading: 219 self)
			)
			(1
				(bubbleSnd stop:)
				(frontNan dispose:)
				(topNan dispose:)
				(sideNan1 dispose:)
				(sideNan2 dispose:)
				(gEgo
					posn: 102 359
					view: 6211
					cel: 0
					loop: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(2
				(sound1 number: 624 loop: 0 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(sound1 stop:)
				(EgoDead 18 self) ; "My goodness, those little guys are efficient! However, based on how they left your boots behind, you might consider some Odor Eaters."
			)
			(4
				(gEgo posn: 117 355 normalize: 1)
				(topNan init: setCycle: Fwd)
				(frontNan init: setCycle: Fwd)
				(sideNan1 init: setCycle: Fwd)
				(sideNan2 init: setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(= local2 0)
				(gGame handsOn:)
				(bubbleSnd play:)
				(self dispose:)
			)
		)
	)
)

(instance sChangeSpeed of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(topNan cycleSpeed: (Random 6 15))
				(self changeState: 4)
			)
			(1
				(frontNan cycleSpeed: (RandomNumber 6 20))
				(self changeState: 4)
			)
			(2
				(sideNan1 cycleSpeed: (Random 6 20))
				(self changeState: 4)
			)
			(3
				(sideNan2 cycleSpeed: (RandomNumber 6 20))
				(self changeState: 4)
			)
			(4
				(= ticks 120)
			)
			(5
				(self changeState: (Random 0 3))
			)
		)
	)
)

(instance sEgoDissolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local0 5)
					(self setScript: sComeDown self)
				else
					(= ticks 1)
				)
			)
			(1
				(cond
					((> (gEgo x:) 157)
						(gEgo setMotion: PolyPath 187 360 self)
					)
					((> (gEgo x:) 106)
						(gEgo setMotion: PolyPath 132 355 self)
					)
					((> (gEgo x:) 0)
						(gEgo setMotion: PolyPath 100 365 self)
					)
				)
			)
			(2
				(cond
					((> (gEgo x:) 157)
						(gEgo setHeading: 270 self)
					)
					((> (gEgo x:) 106)
						(gEgo setHeading: 180 self)
					)
					((> (gEgo x:) 0)
						(gEgo setHeading: 90 self)
					)
				)
			)
			(3
				(cond
					((> (gEgo x:) 157)
						(gEgo
							view: 6210
							loop: 1
							cel: 0
							cycleSpeed: 12
							setCycle: CT 4 1 self
						)
					)
					((> (gEgo x:) 106)
						(gEgo
							view: 6210
							loop: 2
							cel: 0
							cycleSpeed: 12
							setCycle: CT 4 1 self
						)
					)
					((> (gEgo x:) 0)
						(gEgo
							view: 6210
							loop: 0
							cel: 0
							cycleSpeed: 12
							setCycle: CT 4 1 self
						)
					)
				)
			)
			(4
				(sound1 number: 622 loop: 0 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(5
				(gEgo
					view: 6210
					loop: 4
					cel: 0
					posn: 149 386
					setCycle: End self
				)
			)
			(6
				(EgoDead 19 self) ; "That's pretty far to go just to do your Wizard of Oz impression. Makes you feel tingly all over, doesn't it?"
			)
			(7
				(if ((gCurRoom obstacles:) contains: crawlPoly)
					((gCurRoom obstacles:) delete: crawlPoly)
					(crawlPoly dispose:)
				)
				(if (not ((gCurRoom obstacles:) contains: genPoly))
					(genPoly init:)
					(gCurRoom addObstacle: genPoly)
				)
				(gEgo posn: 176 348 normalize:)
				(= local0 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoDissolvedInSmall of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 6210
					loop: 3
					cel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(1
				(sound1 number: 622 loop: 0 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(2
				(gEgo
					view: 6210
					loop: 4
					cel: 0
					posn: 111 335
					setCycle: End self
				)
			)
			(3
				(EgoDead 19 self) ; "That's pretty far to go just to do your Wizard of Oz impression. Makes you feel tingly all over, doesn't it?"
			)
			(4
				(gEgo posn: 176 348 normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTwinkieFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(twinkieFalling init: setCycle: CT 2 1 self)
			)
			(2
				(sound1 number: 622 loop: 0 play:)
				(twinkieFalling cel: 3 setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 640)
				(self dispose:)
			)
		)
	)
)

(instance sStaplePull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 248 367 self)
			)
			(2
				(gGame points: 1 478)
				(gEgo
					get: 104 ; Staple
					view: 622
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(3
				(sound1 number: 623 loop: 0 play:)
				(staple dispose:)
				(gEgo cel: 6 setCycle: End self)
			)
			(4
				(gEgo posn: 224 365 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPourStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 252 359 self)
			)
			(2
				(gGame points: 3 481)
				(cond
					((gEgo has: 44) ; Eva_Full_Enz
						(ClearFlag 104)
						(gEgo
							view: 625
							loop: 2
							cel: 0
							cycleSpeed: 12
							setCycle: CT 2 1 self
						)
					)
					((gEgo has: 42) ; Eva_Full
						(ClearFlag 105)
						(gEgo
							view: 625
							loop: 1
							cel: 0
							cycleSpeed: 12
							setCycle: CT 2 1 self
						)
					)
					((gEgo has: 43) ; Eva_Full_Both
						(ClearFlag 104)
						(ClearFlag 105)
						(gEgo
							view: 6250
							loop: 1
							cel: 0
							cycleSpeed: 12
							setCycle: CT 2 1 self
						)
					)
				)
			)
			(3
				(cond
					((gEgo has: 44) ; Eva_Full_Enz
						(if (or (== global174 7) (== global174 0))
							(= global174 6)
							(cond
								((== global173 3)
									(= global173 4)
									(tablet cel: 0 setCycle: CT 4 1)
								)
								((== global173 4)
									(= global173 5)
									(tablet cel: 4 setCycle: End)
								)
							)
						)
						(gEgo put: 44 get: 45) ; Eva_Full_Enz, Eva_Helmet
						(gEgo cel: 3 setCycle: End self)
					)
					((gEgo has: 42) ; Eva_Full
						(if (or (== global174 6) (== global174 0))
							(= global174 7)
							(cond
								((== global173 3)
									(= global173 4)
									(tablet cel: 0 setCycle: CT 4 1)
								)
								((== global173 4)
									(= global173 5)
									(tablet cel: 4 setCycle: End)
								)
							)
						)
						(gEgo put: 42 get: 45) ; Eva_Full, Eva_Helmet
						(gEgo cel: 3 setCycle: End self)
					)
					((gEgo has: 43) ; Eva_Full_Both
						(cond
							((== global173 3)
								(= global173 5)
								(tablet cel: 0 setCycle: End)
							)
							((== global173 4)
								(= global173 5)
								(tablet cel: 4 setCycle: End)
							)
						)
						(gEgo put: 43 get: 45) ; Eva_Full_Both, Eva_Helmet
						(gEgo cel: 3 setCycle: End self)
					)
				)
			)
			(4
				(gEgo normalize: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetCelery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local0 3)
					(gEgo setMotion: MoveTo 220 359 self)
				else
					(gEgo setMotion: PolyPath 233 354 self)
				)
			)
			(1
				(if (== local0 3)
					(= local0 4)
					(crawlPoly dispose:)
					((gCurRoom obstacles:) delete: crawlPoly)
					(genPoly init:)
					(gCurRoom addObstacle: genPoly)
					(= cycles 3)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== local0 3)
					(gEgo normalize: 3 setMotion: MoveTo 233 354 self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					posn: 226 350
					view: 6222
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 1 1 self
				)
			)
			(4
				(sound1 number: 625 loop: 0 play:)
				(celery dispose:)
				(gEgo get: 17 cel: 2 cycleSpeed: 12 setCycle: End self) ; Celery
			)
			(5
				(gGame points: 1 475)
				(gEgo
					posn: 200 343
					view: 6222
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo posn: 202 344 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sM_mInAcid of Script
	(properties
		name {sM&mInAcid}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 194 365 self)
			)
			(2
				(gEgo cycleSpeed: 9 setHeading: 200 self)
			)
			(3
				(gGame points: 5 479)
				(cond
					((== gCurrentMnM 1)
						(gEgo
							put: 67 ; M_M_Yellow
							view: 6240
							loop: 0
							cel: 0
							setCycle: CT 7 1 self
						)
					)
					((== gCurrentMnM 2)
						(gEgo
							put: 66 ; M_M_Green
							view: 6240
							loop: 2
							cel: 0
							setCycle: CT 7 1 self
						)
					)
					((== gCurrentMnM 0)
						(gEgo
							put: 65 ; M_M
							view: 6240
							loop: 1
							cel: 0
							setCycle: CT 7 1 self
						)
					)
				)
			)
			(4
				(sound1 number: 702 loop: 0 play:)
				(cond
					((== gCurrentMnM 1)
						(gEgo cel: 8 setCycle: End self)
					)
					((== gCurrentMnM 2)
						(gEgo cel: 8 setCycle: End self)
					)
					((== gCurrentMnM 0)
						(gEgo cel: 8 setCycle: End self)
					)
				)
			)
			(5
				(acidRise init: setCycle: End self)
			)
			(6
				(waves init: setCycle: End self)
			)
			(7
				(gMessager say: 6 141) ; "(SHOW ANIMATION OF THE ACID POOL RISING JUST SHORT OF THE NANITES THEN RECEDING.) Interesting. The acid rises, but just not quite high enough to submerse those nanites."
				(waves dispose:)
				(acidRise cel: 4 setCycle: Beg self)
			)
			(8
				(acidRise dispose:)
				(gEgo normalize: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetM_M of Script
	(properties
		name {sGetM&M}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((== gCurrentMnM 1)
						(gEgo setMotion: PolyPath 249 367 self)
					)
					((== gCurrentMnM 2)
						(gEgo setMotion: PolyPath 268 370 self)
					)
					((== gCurrentMnM 0)
						(gEgo setMotion: PolyPath 262 356 self)
					)
				)
			)
			(2
				(gEgo cycleSpeed: 12)
				(gGame points: 1 476)
				(cond
					((== gCurrentMnM 1)
						(gEgo view: 624 loop: 0 cel: 0 setCycle: CT 3 1 self)
					)
					((== gCurrentMnM 2)
						(gEgo view: 624 loop: 1 cel: 0 setCycle: CT 3 1 self)
					)
					((== gCurrentMnM 0)
						(gEgo view: 624 loop: 2 cel: 0 setCycle: CT 3 1 self)
					)
				)
			)
			(3
				(cond
					((== gCurrentMnM 1)
						(yMnm dispose:)
						(gEgo get: 67 cel: 4 setCycle: End self) ; M_M_Yellow
					)
					((== gCurrentMnM 2)
						(gMnm dispose:)
						(gEgo get: 66 cel: 4 setCycle: End self) ; M_M_Green
					)
					((== gCurrentMnM 0)
						(rMnm dispose:)
						(gEgo get: 65 cel: 4 setCycle: End self) ; M_M
					)
				)
			)
			(4
				(gMessager say: 12 4) ; "You acquire a candy. (CAN TAKE ALL OF THEM ONE AT A TIME. SEE ART)"
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCrawlToClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 222 354 self)
			)
			(1
				(gGame handsOff:)
				(crawlPoly dispose:)
				((gCurRoom obstacles:) delete: crawlPoly)
				(climbPoly init:)
				(gCurRoom addObstacle: climbPoly)
				(= cycles 1)
			)
			(2
				(gEgo normalize: 1 setMotion: MoveTo 155 344 self)
			)
			(3
				(= local0 5)
				(gEgo posn: 160 338 view: 6221 setLoop: 0 1 setCycle: Walk)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbToCrawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 155 344 self)
			)
			(1
				(= local0 3)
				((gCurRoom obstacles:) delete: climbPoly)
				(climbPoly init:)
				(crawlPoly init:)
				(gCurRoom addObstacle: crawlPoly)
				(= cycles 1)
			)
			(2
				(gEgo normalize: 0 setMotion: MoveTo 222 354 self)
			)
			(3
				(gEgo view: 619 setLoop: 0 1 setCycle: Walk)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerClimbing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 155 344 self)
			)
			(1
				(= local0 5)
				(if ((gCurRoom obstacles:) contains: genPoly)
					(genPoly dispose:)
					((gCurRoom obstacles:) delete: genPoly)
				)
				(climbPoly init:)
				(gCurRoom addObstacle: climbPoly)
				(gEgo
					posn: 160 338
					view: 6221
					setLoop: 0 1
					setCycle: Walk self
				)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance sRogerCrawls of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 222 354 self)
			)
			(1
				(= local0 3)
				(if ((gCurRoom obstacles:) contains: genPoly)
					((gCurRoom obstacles:) delete: genPoly)
					(genPoly dispose:)
				)
				(crawlPoly init:)
				(gCurRoom addObstacle: crawlPoly)
				(= cycles 1)
			)
			(2
				(gEgo view: 619 setLoop: 0 1 setCycle: Walk)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComeDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== local0 3)
						(gEgo setMotion: MoveTo 222 354 self)
					)
					((== local0 5)
						(gEgo setMotion: MoveTo 160 338 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (not (== local0 4))
					(gEgo normalize:)
				)
				(= cycles 1)
			)
			(2
				(cond
					((== local0 3)
						(= local0 4)
						(crawlPoly dispose:)
						((gCurRoom obstacles:) delete: crawlPoly)
						(genPoly init:)
						(gCurRoom addObstacle: genPoly)
					)
					((== local0 5)
						(= local0 4)
						(climbPoly dispose:)
						((gCurRoom obstacles:) delete: climbPoly)
						(genPoly init:)
						(gCurRoom addObstacle: genPoly)
					)
				)
				(= cycles 3)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sGetTimePills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(IsFlag 121)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 252 359 self)
			)
			(2
				(gGame points: 1 482)
				(gEgo
					view: 626
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gMessager say: 9 4 3 0 self 640) ; "You now own one of those tiny timed-release pills."
			)
			(4
				(gEgo get: 105 normalize: 0) ; Time_Pills
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 166 355 self)
			)
			(2
				(gEgo
					get: 79 ; Pinfeather
					view: 6203
					loop: 0
					cel: 0
					setCycle: CT 7 1 self
				)
			)
			(3
				(gGame points: 1 477)
				(feather dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUlcerExit of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 287 132 self)
			)
			(1
				(= temp4 5)
				(= temp0 ((gCurRoom plane:) left:))
				(= temp2 ((gCurRoom plane:) right:))
				(= temp3 ((gCurRoom plane:) bottom:))
				(= temp1 ((gCurRoom plane:) top:))
				(if (< ((gCurRoom plane:) top:) -5)
					((gCurRoom plane:)
						setRect: temp0 (+ temp1 temp4) temp2 (+ temp1 416 temp4)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gEgo
					posn: 291 83
					view: 6202
					loop: 2
					cel: 10
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(3
				(gGSound2 number: 255 setLoop: -1 play: setVol: 127)
				(gEgo
					posn: 289 90
					view: 6202
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gCurRoom newRoom: 610)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDuodenumExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (== local0 4))
					(self setScript: sComeDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOn:)
				(gEgo setMotion: PolyPath 40 370 self)
			)
			(2
				(gGame handsOff:)
				(gEgo
					posn: 40 370
					view: 628
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: 650)
				(self dispose:)
			)
		)
	)
)

(instance sEsophExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 158 56 self)
			)
			(1
				(gGame handsOff: points: 3 480)
				(gCurRoom newRoom: 640)
				(self dispose:)
			)
		)
	)
)

(instance sWalkToCrawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(walls approachX:)
						(walls approachY:)
						self
				)
			)
			(1
				(gEgo view: 619 setLoop: 0 1 setCycle: Walk)
				(= local0 3)
				(if ((gCurRoom obstacles:) contains: genPoly)
					((gCurRoom obstacles:) delete: genPoly)
					(genPoly dispose:)
				)
				(crawlPoly init:)
				(gCurRoom addObstacle: crawlPoly)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance celery of View
	(properties
		noun 11
	)

	(method (init)
		(if (IsFlag 107)
			(= x 157)
			(= y 59)
			(= z 0)
			(= view 6270)
			(= cel (= loop 0))
			(= sightAngle 90)
		else
			(= x 229)
			(= y 313)
			(= z 20)
			(= view 6201)
			(= loop 0)
			(= cel 3)
			(= sightAngle 63)
		)
		(gWalkHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(self onMe: event)
					(== gTheCursor gDoCursor)
				)
				(if (IsFlag 107)
					(cond
						((== local0 3)
							(gEgo setScript: sCrawlToClimb)
						)
						((== local0 4)
							(gEgo setScript: sRogerClimbing)
						)
					)
				else
					(gEgo setScript: sGetCelery)
				)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOVE)
					(not (event modifiers:))
					(self onMe: event)
					(IsFlag 107)
				)
				(cond
					((== local0 3)
						(gEgo setScript: sCrawlToClimb)
						(event claimed: 1)
						(return 1)
					)
					((== local0 5)
						(event claimed: 0)
					)
					(else
						(gEgo setScript: sRogerClimbing)
						(event claimed: 1)
						(return 1)
					)
				)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 107)
					(gMessager say: 109 1 0 0 0 15) ; "That's your makeshift grappling hook."
				else
					(gMessager say: 11 1) ; "Hmmm. Loosely woven into the stomach lining is a piece of celery string. That stuff could be used to make steel-belted radial tires stronger. Rumor has it that it was the original inspiration for dental floss. I think I saw that on one of those James Burke shows."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance yMnm of View
	(properties
		noun 12
		sightAngle 73
		approachX 250
		approachY 353
		x 260
		y 359
		view 6201
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (gEgo has: 65)) ; M_M
						(not (gEgo has: 66)) ; M_M_Green
						(not (gEgo has: 67)) ; M_M_Yellow
					)
					(SetFlag 170)
					(= gCurrentMnM 1)
					(gEgo setScript: sGetM_M)
				else
					(gMessager say: 12 4 7) ; "I already have one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance gMnm of View
	(properties
		noun 12
		sightAngle 73
		approachX 250
		approachY 353
		x 290
		y 366
		view 6201
		cel 1
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (gEgo has: 65)) ; M_M
						(not (gEgo has: 66)) ; M_M_Green
						(not (gEgo has: 67)) ; M_M_Yellow
					)
					(SetFlag 169)
					(= gCurrentMnM 2)
					(gEgo setScript: sGetM_M)
				else
					(gMessager say: 12 4 7) ; "I already have one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance rMnm of View
	(properties
		noun 12
		sightAngle 73
		approachX 250
		approachY 353
		x 282
		y 348
		view 6201
		cel 2
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (gEgo has: 65)) ; M_M
						(not (gEgo has: 66)) ; M_M_Green
						(not (gEgo has: 67)) ; M_M_Yellow
					)
					(SetFlag 168)
					(= gCurrentMnM 0)
					(gEgo setScript: sGetM_M)
				else
					(gMessager say: 12 4 7) ; "I already have one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance staple of View
	(properties
		noun 9
		sightAngle 63
		x 279
		y 320
		view 6201
		cel 4
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (event modifiers:))
				(self onMe: event)
				(== gTheCursor gDoCursor)
			)
			(gEgo setScript: sStaplePull)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance feather of View
	(properties
		noun 10
		approachX 166
		approachY 355
		x 132
		y 336
		z 10
		view 6201
		cel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetFeather)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tablet of Prop
	(properties
		noun 13
		sightAngle 106
		approachX 252
		approachY 359
		x 280
		y 355
		view 626
		signal 16417
	)

	(method (init)
		(cond
			((== global173 3)
				(= cel 0)
			)
			((== global173 4)
				(= cel 4)
			)
			((== global173 5)
				(= cel 20)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(115 ; Eva_Full
				(gEgo setScript: sPourStuff)
			)
			(4 ; Do
				(cond
					((== global173 3)
						(gMessager say: 13 4 11) ; "An interesting idea. What are you up to, Roger?"
					)
					((== global173 4)
						(gMessager say: 13 4 9) ; "An interesting idea. What are you up to, Roger?"
					)
					((and (not (IsFlag 121)) (== global173 5))
						(gEgo setScript: sGetTimePills)
					)
				)
			)
			(1 ; Look
				(if (== global173 4)
					(gMessager say: 13 4 9) ; "An interesting idea. What are you up to, Roger?"
				else
					(gMessager say: 13 1) ; "It's one of those tiny timed-release pills."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance twinkieFalling of Prop
	(properties
		x 176
		y 399
		view 623
	)
)

(instance topNan of Actor
	(properties
		noun 8
		sightAngle 40
		x -5
		y 320
		view 6200
		loop 2
	)
)

(instance frontNan of Actor
	(properties
		noun 8
		sightAngle 40
		x 51
		y 372
		view 6200
	)
)

(instance sideNan2 of Actor
	(properties
		noun 8
		sightAngle 40
		x 69
		y 410
		view 6200
		loop 3
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)

	(method (doit)
		(if (not local2)
			(cond
				((== local3 0)
					(cond
						((and (> (self cel:) 10) (< (self cel:) 16))
							(self cel: (self cel:) setCycle: CT 20 1)
							(= local3 2)
						)
						((== (self cel:) 20)
							(self cel: 0 setCycle: CT 20 1)
						)
					)
				)
				((== local3 1)
					(if (== (self cel:) 11)
						(self cel: 11 setCycle: CT 11 1)
					else
						(self cel: (self cel:) setCycle: CT 11 1)
					)
				)
				((and (== local3 2) (or (< (self cel:) 11) (> (self cel:) 16)))
					(self cel: (self cel:) setCycle: CT 20 1)
					(= local3 0)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance sideNan1 of Actor
	(properties
		noun 8
		sightAngle 40
		x 28
		y 397
		view 6200
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setScript: sChangeSpeed)
		(super init: &rest)
	)

	(method (doit)
		(if (not local2)
			(cond
				((== local3 0)
					(if (and (> (self cel:) 12) (< (self cel:) 21))
						(self setCycle: Fwd)
						(= local3 1)
					)
				)
				((== local3 2)
					(self setCycle: CT 13 1)
				)
				((and (== local3 1) (or (< (self cel:) 13) (> (self cel:) 21)))
					(= local3 0)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance smallBubble of Prop
	(properties
		noun 6
		sightAngle 40
		x 181
		y 386
		view 620
	)
)

(instance bigBubble of Prop
	(properties
		noun 6
		sightAngle 40
		x 144
		y 381
		view 620
		loop 1
	)
)

(instance oneBubble of Prop
	(properties
		noun 6
		sightAngle 40
		x 130
		y 337
		view 620
		loop 2
	)
)

(instance leftDrop of Prop
	(properties
		noun 5
		sightAngle 40
		x 108
		y 352
		view 620
		loop 3
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance rightDrop of Prop
	(properties
		noun 5
		sightAngle 40
		x 278
		y 331
		view 620
		loop 5
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance ctrDrkDrop of Prop
	(properties
		noun 5
		sightAngle 40
		x 283
		y 301
		view 620
		loop 4
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance ctrLghtDrop of Prop
	(properties
		noun 5
		sightAngle 40
		x 202
		y 295
		view 620
		loop 6
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance acidRise of Prop
	(properties
		x 87
		y 417
		view 6241
		cycleSpeed 10
	)
)

(instance waves of Prop
	(properties
		x 87
		y 417
		view 6241
		loop 1
		cycleSpeed 16
	)

	(method (init)
		(self setPri: 420)
		(super init:)
	)
)

(instance walls of Feature
	(properties
		noun 5
		sightAngle 180
		approachX 222
		approachY 354
		x 249
		y 309
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 270 175 298 212 319 192 338 234 349 288 344 319 344 319 270
					yourself:
				)
		)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOVE)
				(== local0 3)
				(not (event modifiers:))
				(self onMe: event)
			)
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== local0 4)
						(gEgo view: 619 setLoop: 0 1 setCycle: Walk)
						(= local0 3)
						(if ((gCurRoom obstacles:) contains: genPoly)
							((gCurRoom obstacles:) delete: genPoly)
							(genPoly dispose:)
						)
						(crawlPoly init:)
						(gCurRoom addObstacle: crawlPoly)
					)
					((== local0 5)
						(gEgo setScript: sClimbToCrawl)
					)
				)
			)
			(3 ; Walk
				(cond
					((== local0 4)
						(gEgo setScript: sWalkToCrawl)
					)
					((== local0 5)
						(gEgo setScript: sClimbToCrawl)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(super dispose:)
	)
)

(instance ceiling of Feature
	(properties
		noun 4
		sightAngle 40
		x 159
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 126 9 33 37 12 87 15 107 27 116 53 130 66 184 66 200 54 210 23 233 11 265 19 272 24 259 30 253 57 257 82 275 104 293 128
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance acidPoolFar of Feature
	(properties
		noun 6
		sightAngle 345
		approachX 110
		approachY 355
		x 111
		y 330
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 332 101 330 96 322 125 319 131 325 143 324 149 328 136 341 95 345
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance acidPoolNear of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 185
		approachY 363
		x 186
		y 390
		z 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 135 371 135 377 98 382 169 402 153 405 188 406 270 387 204 377 171 375 148 367 149 364 126 365
					yourself:
				)
		)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(141 ; M_M
				(gEgo setScript: sM_mInAcid)
			)
			(3 ; Walk
				(gEgo setScript: sEgoDissolved)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(super dispose:)
	)
)

(instance ulcer of Feature
	(properties
		noun 2
		sightAngle 40
		x 289
		y 61
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 30 260 49 260 81 282 127 319 127 318 24 279 24
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitToEsoph of ExitFeature
	(properties
		noun 3
		sightAngle 40
		x 157
		y 44
		nextRoom 640
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 124 57 112 0 202 0 191 57 157 63
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(if (not (== local0 5))
					(gMessager say: 3 9 5) ; "Now, let's see. Although we could let you do a macho Tarzan swing, fall down and make a complete fool of yourself, we would advise you to go back down and climb up the old way."
				else
					(gEgo setScript: sEsophExit)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit650 of ExitFeature
	(properties
		noun 7
		nextRoom 650
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 17 309 34 320 41 336 58 355 49 369 0 373 0 282
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; ExitLeft
				(gEgo setScript: sDuodenumExit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit610 of ExitFeature
	(properties
		noun 2
		approachX 290
		approachY 77
		nextRoom 610
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 276 53 287 43 288 33 320 33 320 75 290 75 277 67
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(if (not (== local0 3))
					(gMessager say: 3 9 5) ; "Now, let's see. Although we could let you do a macho Tarzan swing, fall down and make a complete fool of yourself, we would advise you to go back down and climb up the old way."
				else
					(gEgo setScript: sUlcerExit)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

(instance bubbleSnd of Sound
	(properties
		flags 1
		number 691
		loop 0
	)
)

(instance genPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 54 358 21 408 108 408 141 400 81 381 118 371 105 360 130 357 163 358 169 365 210 370 252 379 278 385 299 373 298 368 271 377 250 372 243 363 260 355 238 351 221 355 209 350 154 334 142 337 128 343 113 345 89 345 82 352
		)
	)
)

(instance climbPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 160 338 161 338 161 34 160 34)
	)
)

(instance crawlPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 290 111 287 264 222 354 293 264)
	)
)

(instance sDrowning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(twinkie cycleSpeed: 12 setCycle: End)
				(dednan1 setCycle: End)
				(dednan2 setCycle: End)
				(dednan3 setCycle: End self)
			)
			(1
				(sound1 number: 621 loop: -1 play:)
				(dednan1 loop: 1 cel: 0 setCycle: End)
				(dednan2 setCycle: Beg)
				(dednan3 setCycle: Beg self)
			)
			(2
				(dednan2 loop: 3 cel: 0 setCycle: End)
				(dednan3 setCycle: End self)
			)
			(3
				(dednan3 loop: 5 cel: 0 setCycle: End self)
			)
			(4
				(sound1 stop:)
				(gCurRoom newRoom: 640)
				(self dispose:)
			)
		)
	)
)

(instance twinkie of Prop
	(properties
		x 176
		y 99
		view 6230
	)
)

(instance dednan1 of Prop
	(properties
		x 33
		y 56
		view 629
	)
)

(instance dednan2 of Prop
	(properties
		x 109
		y 98
		view 629
		loop 2
	)
)

(instance dednan3 of Prop
	(properties
		x 30
		y 100
		view 629
		loop 4
	)
)

