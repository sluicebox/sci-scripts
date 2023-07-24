;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use n666)
(use DText)
(use Str)
(use Array)
(use Inset)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm470 0
	Wriggley 1
	Roger 2
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
	local8
	local9
)

(procedure (localproc_0)
	(if (and (IsFlag 120) (IsFlag 431) (IsFlag 96))
		(return 1)
	)
)

(procedure (localproc_1)
	(if (and local6 local5)
		(if
			(and
				(== (redCable x:) 127)
				(== (redCable y:) 98)
				(== (blueCable x:) 203)
				(== (blueCable y:) 92)
			)
			(inHood setScript: sExitInset)
		else
			(inHood setScript: sRogerFail)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(Message msgGET 470 param1 param2 param3 param4 (local0 data:))
	(= local1 (IntArray with: 0 0 0 0))
	(Text 0 (local1 data:) (local0 data:) 60 320) ; TextSize
	((= local2 (DText new:))
		text: (KString 8 (local0 data:)) ; StrDup
		fore:
			(switch param3
				(13 209)
				(14 50)
				(else 84)
			)
		font: 60
		mode: 1
		x: (- 160 (/ (local1 at: 2) 2))
		y: (if (gCurRoom inset:) 25 else 65)
		setPri: 250
		setSize: 320
		init:
	)
)

(instance rm470 of SQRoom
	(properties
		noun 1
		picture 470
	)

	(method (init)
		(= gShuttleRoomNum 470)
		(= local0 (Str newWith: 80 {}))
		(gGSound1 number: 131 flags: 1 loop: -1 play:)
		(Load 140 325 471 473 475 477 922 47002 47001) ; WAVE
		(super init:)
		(gGame handsOff:)
		(Load rsVIEW 470 471 477)
		(Load rsSCRIPT 64941)
		(Load rsHEAP 64941)
		(= local3 (gEgo cycleSpeed:))
		(= local4 gEgoSpeed)
		(if (IsFlag 123)
			(wriggley view: 4760 loop: 2 cel: 0 posn: 92 59 init: setCycle: Fwd)
			(wriggleyHood init:)
			(wriggleyShip init:)
			(wriggleyDoor cel: 8 init:)
			(waitingHood init: approachVerbs: 4) ; Do
			(theCables init: setCycle: Fwd)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 5 135 312 135 311 31 5 31
						yourself:
					)
					(= local7
						((Polygon new:)
							type: PBarredAccess
							init: 200 66 278 66 278 81 217 84 123 81 58 70 43 39 181 75
							yourself:
						)
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 5 135 312 135 311 31 5 31
						yourself:
					)
					(= local7
						((Polygon new:)
							type: PBarredAccess
							init: 220 66 278 66 278 73 262 83 167 83 167 77
							yourself:
						)
					)
			)
		)
		(gEgo view: 4710 loop: 1 cel: 0 posn: 205 91 setSpeed: 9 init:)
		(= gEgoSpeed 9)
		(ship init: approachVerbs: 111) ; Windshield_Sign
		(door init: approachVerbs: 4) ; Do
		(if (and (not (IsFlag 124)) (IsFlag 120))
			(tailSign init:)
		)
		(trunk init: approachVerbs: 4) ; Do
		(if (IsFlag 96)
			(hood init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 124)
			(shuttleEngine init: setCycle: Fwd)
		)
		(if (not (IsFlag 420))
			(fish init: approachVerbs: 4) ; Do
		)
		(gCurRoom setScript: sExitShuttle)
	)

	(method (dispose)
		(gGSound1 fade:)
		(super dispose:)
	)
)

(instance sExitInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 11 4 11 0 self) ; "Okay, Manuel, we're all hooked up. Give it a try."
			)
			(1
				(localSound number: 47003 play: self)
			)
			(2
				(= ticks 60)
			)
			(3
				(localSound number: 47003 play: self)
			)
			(4
				(= ticks 60)
			)
			(5
				(localSound number: 47004 play: self)
			)
			(6
				(SetFlag 124)
				(wriggleyHood dispose:)
				(tailSign dispose:)
				(= ticks 120)
			)
			(7
				(inHood dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 11 4 11 0 self) ; "Okay, Manuel, we're all hooked up. Give it a try."
			)
			(1
				(localSound number: 47003 play: self)
			)
			(2
				(= ticks 60)
			)
			(3
				(localSound number: 47003 play: self)
			)
			(4
				(= ticks 60)
			)
			(5
				(inHood dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sShockRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 90)
			)
			(1
				(localSound number: 922 play:)
				(gEgo
					view: 474
					loop: 0
					cel: 0
					posn: 213 80
					setPri: -1
					setSpeed: 6
					setCycle: CT 1 1 self
				)
			)
			(2
				(gEgo setCycle: ROsc 4 2 7 self)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(FrameOut)
				(EgoDead 26 self) ; "You pick strange methods of getting a charge out of life."
			)
			(5
				(gEgo
					normalize: 4
					view: 470
					posn: 182 75
					setPri: -1
					setSpeed: 9
					setCycle: StopWalk 471
				)
				(= local5 0)
				(= local6 0)
				(= cycles 5)
			)
			(6
				(gCurRoom setInset: inHood)
				(self dispose:)
			)
		)
	)
)

(instance sGetItems of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4712
					loop: 0
					cel: 0
					setSpeed: 9
					setCycle: CT 2 1 self
				)
			)
			(2
				(if register
					(gEgo get: 63) ; Jumper_Cables
					(gGame points: 1 431)
					(jumperCables dispose:)
				else
					(gEgo get: 112) ; Windshield_Sign
					(gGame points: 1 419)
					(rolledSign dispose:)
				)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize: 7
					view: 470
					setSpeed: 9
					setCycle: StopWalk 471
					setScale: 0
				)
				(= cycles 5)
			)
			(4
				(if (and (IsFlag 431) (IsFlag 419))
					(gEgo setMotion: MoveTo 311 115 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(5
				(trunk doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sClimbIntoShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4710
					loop: 0
					cel: 0
					posn: 212 91
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo setSpeed: local3)
				(= gEgoSpeed local4)
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sExitShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo
					view: 4710
					loop: 1
					cel: 0
					posn: 205 91
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 5
					view: 470
					setSpeed: 9
					setCycle: StopWalk 471
					setScale: 0
					posn: 206 91
				)
				(= cycles 1)
			)
			(3
				(cond
					((and (localproc_0) (not (IsFlag 123)))
						(= next sShipApproach)
						(self dispose:)
					)
					((IsFlag 123)
						(switch (RandomNumber 1 2)
							(1
								(gMessager say: 4 0 3 0 self) ; "Well, let's get a move on. I have a wax job in an hour and I still have a half light year to make up. Juanobbee is just going to murder me if I'm late again."
							)
							(2
								(gMessager say: 4 0 7 0 self) ; "Hallo! I really have to get going. Can we turn it up a notch?"
							)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTheFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fish dispose:)
				(gEgo
					view: 4730
					loop: 0
					cel: 0
					posn: 160 119
					setSpeed: 9
					setCycle: CT 6 1 self
				)
			)
			(2
				(localSound number: 47002 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize: 2
					view: 470
					posn: 146 118
					setCycle: StopWalk 471
				)
				(gEgo get: 29) ; Dead_Fish2
				(= cycles 1)
			)
			(4
				(gGame points: 1 420 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo
					view: 472
					loop: 0
					cel: 0
					x: 310
					y: 115
					setSpeed: 9
					setCycle: CT 3 1 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setCycle: End)
				(trunk loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(trunk loop: 5 cel: 1)
				(localSound number: 475 play: self)
			)
			(6
				(gEgo
					normalize: 7
					view: 470
					posn: 304 97
					setCycle: StopWalk 471
				)
				(= cycles 1)
			)
			(7
				(ClearFlag 95)
				(if (localproc_0)
					(= next sShipApproach)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sCloseHood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(1
				(hood dispose:)
				(gEgo
					view: 472
					loop: 1
					cel: 0
					x: 182
					y: 75
					setSpeed: 9
					setCycle: CT 7 1 self
				)
			)
			(2
				(localSound number: 475 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 4 view: 470 setCycle: StopWalk 471)
				(= cycles 5)
			)
			(4
				(ClearFlag 96)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHangTheSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 112 setHeading: 45 self) ; Windshield_Sign
			)
			(1
				(gEgo
					view: 472
					loop: 2
					cel: 0
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(tailSign init:)
				(gGame points: 1 421)
				(gEgo
					normalize: 6
					view: 470
					posn: 284 74
					setCycle: StopWalk 471
				)
				(= cycles 1)
			)
			(3
				(SetFlag 120)
				(if (localproc_0)
					(= next sShipApproach)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sShipApproach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 123)
				(Fade 1 1 self)
			)
			(1
				(gGSound1 pause: 1)
				(gGSound2 number: 476 flags: 1 loop: -1 play:)
				(= ticks 30)
			)
			(2
				(localproc_2 0 0 9 1)
				(Load 140 471) ; WAVE
				(= ticks 200)
			)
			(3
				(gEgo
					view: 4711
					loop: 1
					cel: 0
					x: 176
					y: 101
					setSpeed: 9
					setCycle: ROsc 50 1 8
				)
				(local2 dispose:)
				(= cycles 5)
			)
			(4
				(Fade 0 1 self)
			)
			(5
				(= cycles 5)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(gEgo setCycle: CT 9 -1 self)
			)
			(8
				(gEgo setCycle: ROsc 50 1 8)
				(= ticks 60)
			)
			(9
				(Fade 1 1 self)
			)
			(10
				(= ticks 30)
			)
			(11
				(localproc_2 0 0 9 2)
				(= ticks 200)
			)
			(12
				(gEgo
					view: 4711
					loop: 0
					cel: 0
					x: 142
					y: 111
					setSpeed: 9
					setCycle: ROsc 50 0 4
				)
				(local2 dispose:)
				(= cycles 5)
			)
			(13
				(Fade 0 1 self)
			)
			(14
				(= ticks 30)
			)
			(15
				(gEgo setCycle: End self)
			)
			(16
				(gEgo setCycle: ROsc 50 27 31)
				(= ticks 30)
			)
			(17
				(Fade 1 1 self)
			)
			(18
				(= ticks 30)
			)
			(19
				(localproc_2 0 0 9 3)
				(= ticks 200)
			)
			(20
				(local2 dispose:)
				(gEgo
					view: 4711
					loop: 2
					cel: 0
					posn: 223 104
					setSpeed: 9
					setCycle: Fwd
				)
				(= cycles 5)
			)
			(21
				(Fade 0 1 self)
			)
			(22
				(gGSound2 fade:)
				(= ticks 120)
			)
			(23
				(gGSound1 pause: 0)
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 4751 self
						x: 0
						y: 10
						start:
						yourself:
					)
				)
			)
			(24
				(localSound number: 471 play: self)
			)
			(25
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 475 self
						x: -1
						y: 8
						start:
						yourself:
					)
				)
			)
			(26
				(wriggleyShip init:)
				(gEgo setCycle: End self)
			)
			(27
				(gEgo
					view: 4711
					loop: 3
					cel: 0
					posn: 224 104
					setSpeed: 9
					setCycle: End self
				)
			)
			(28
				(gEgo
					normalize: 5
					view: 470
					setSpeed: 9
					setCycle: StopWalk 471
					setScale: 0
				)
				(= cycles 5)
			)
			(29
				(localSound number: 47001 play:)
				(wriggleyDoor init: setCycle: End self)
			)
			(30
				(= ticks 60)
			)
			(31
				(wriggley init: setSpeed: 9 setCycle: End self)
			)
			(32
				(wriggley view: 4760 loop: 2 cel: 0 posn: 94 87 setCycle: Fwd)
				(= cycles 10)
			)
			(33
				(gMessager say: 4 0 2 1 self) ; "Hello, Sweetheart. You look like you could use a little assistance. Is there anything I can do?"
			)
			(34
				(gMessager say: 4 0 2 2 self) ; "Well, yes, there is. Thanks for stopping."
			)
			(35
				(gMessager say: 4 0 2 3 self) ; "You just name it, I guess."
			)
			(36
				(gMessager say: 4 0 2 4 self) ; "It seems I've stalled my engines. Could you give me a jump? I have cables."
			)
			(37
				(gMessager say: 4 0 2 5 self) ; "I'd jump you in a heartbeat, Dollface. I guess you must'a got caught up in that anti-anomaly. They can be a real pain in the ... anyway, let's get it done."
			)
			(38
				(wriggley
					view: 476
					loop: 2
					cel: 0
					posn: 65 88
					setSpeed: 10
					setPri: -1
					setCycle: End self
				)
				(gEgo setMotion: PolyPath 120 59 self)
			)
			(39
				(localSound number: 473 play:)
				(wriggley
					loop: 3
					cel: 0
					posn: 104 59
					setPri: -1
					setCycle: End self
				)
			)
			(40
				(wriggleyHood init:)
				(wriggley
					view: 4760
					loop: 2
					cel: 0
					posn: 88 58
					setSpeed: 9
					setCycle: Fwd
				)
			)
			(41
				(gEgo
					put: 63 ; Jumper_Cables
					view: 477
					loop: 0
					cel: 0
					posn: 104 59
					setSpeed: 9
					setCycle: CT 7 1 self
				)
			)
			(42
				(gEgo view: 477 loop: 5 cel: 0 setSpeed: 9 setCycle: Fwd)
				(= cycles 1)
			)
			(43
				(gMessager say: 4 0 2 6 self) ; "Well, here's your end of the cables."
			)
			(44
				(gMessager say: 4 0 2 7 self) ; "I'll let you know when I'm all hooked up."
			)
			(45
				(wriggley
					view: 477
					loop: 0
					cel: 8
					posn: 104 59
					setCycle: End self
				)
				(gEgo hide:)
			)
			(46
				(wriggley loop: 1 cel: 0 setCycle: End self)
				(gEgo
					normalize: 5
					setSpeed: 9
					view: 470
					setCycle: StopWalk 471
					setScale: 0
					setSpeed: 9
					posn: 120 59
					show:
				)
			)
			(47
				(gMessager say: 4 0 6 0 self) ; "CONTACT!"
			)
			(48
				(gEgo hide:)
				(wriggley
					view: 477
					loop: 2
					cel: 0
					posn: 104 59
					setCycle: End self
				)
			)
			(49
				(wriggley view: 4760 loop: 2 cel: 0 posn: 88 58 setCycle: Fwd)
				(gEgo
					view: 477
					loop: 3
					cel: 0
					x: 104
					y: 59
					setSpeed: 9
					show:
					setCycle: End self
				)
			)
			(50
				(theCables init: setCycle: Fwd)
				(waitingHood init:)
				(gEgo
					normalize: 4
					view: 470
					posn: 182 75
					setPri: -1
					setSpeed: 9
					setCycle: StopWalk 471
				)
				(= cycles 1)
			)
			(51
				(gCurRoom setInset: inHood)
				(self dispose:)
			)
		)
	)
)

(instance sShipIsReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5 510)
				(= cycles 10)
			)
			(1
				(shuttleEngine init: setCycle: Fwd)
				(theCables setCycle: 0 dispose:)
				((gCurRoom obstacles:) delete: local7)
				(local7 dispose:)
				(gCurRoom
					addObstacle:
						(= local7
							((Polygon new:)
								type: PBarredAccess
								init: 220 66 278 66 278 73 262 83 167 83 167 77
								yourself:
							)
						)
				)
				(gEgo
					normalize: 5
					view: 470
					posn: 182 75
					setPri: -1
					setCycle: StopWalk 471
					setSpeed: 6
				)
				(wriggley view: 4760 loop: 2 cel: 0 posn: 92 59 setCycle: Fwd)
				(= ticks 90)
			)
			(2
				(gMessager say: 4 0 12 1 self) ; "Bye-bye, Sugar Bunny."
			)
			(3
				(gMessager say: 4 0 12 2 self) ; "I've gotta be running along."
			)
			(4
				(gMessager say: 4 0 12 3 self) ; "Hey, thanks for stopping to help me."
			)
			(5
				(gMessager say: 4 0 12 4 self) ; "See ya'."
			)
			(6
				(wriggley view: 4770 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(wriggley dispose:)
				(alien init: setCycle: CT 31 1 self)
			)
			(8
				(localSound number: 325 play:)
				(alien setCycle: End self)
			)
			(9
				(alien dispose:)
				(localSound number: 47001 play:)
				(wriggleyDoor setCycle: Beg self)
			)
			(10
				(wriggleyDoor dispose:)
				(= ticks 30)
			)
			(11
				(wriggleyShip dispose:)
				(waitingHood dispose:)
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 4752 self
						x: -5
						y: -2
						start:
						yourself:
					)
				)
			)
			(12
				(ClearFlag 51)
				(ClearFlag 123)
				(SetFlag 50)
				(SetFlag 94)
				(= next sCloseHood)
				(self dispose:)
			)
		)
	)
)

(instance wriggley of Actor
	(properties
		sightAngle 40
		x 65
		y 88
		view 476
		signal 20513
	)
)

(instance shuttleEngine of Prop
	(properties
		noun 2
		sightAngle 40
		x 219
		y 137
		view 479
		cel 5
		cycleSpeed 10
	)
)

(instance theCables of Prop
	(properties
		noun 7
		sightAngle 40
		x 213
		y 79
		view 474
		loop 1
		signal 20513
		cycleSpeed 11
	)
)

(instance engines of Prop
	(properties
		sightAngle 40
		x 100
		y 112
		priority 2
		fixPriority 1
		view 4750
		loop 1
		signal 20513
	)
)

(instance wriggleyDoor of Prop
	(properties
		sightAngle 40
		x 78
		y 88
		priority 2
		fixPriority 1
		view 4750
		loop 2
		signal 20513
	)
)

(instance trunk of Prop
	(properties
		noun 6
		sightAngle 40
		approachX 311
		approachY 115
		x 270
		y 89
		view 473
		loop 5
		signal 20513
	)

	(method (init)
		(if (IsFlag 95)
			(if (not (IsFlag 431))
				(jumperCables init: approachVerbs: 4) ; Do
			)
			(if (not (IsFlag 419))
				(rolledSign init: approachVerbs: 4) ; Do
			)
		else
			(= cel 1)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(and
							(IsFlag 95)
							(or (not (IsFlag 431)) (not (IsFlag 419)))
						)
						(gMessager say: noun theVerb 8) ; "Might as well get everything while it's open. You never know what's going to go wrong next."
					)
					((IsFlag 95)
						(gCurRoom setScript: sCloseTrunk)
					)
					(else
						(gMessager say: noun theVerb 10) ; "It opens from the inside."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alien of Prop
	(properties
		x 104
		y 116
		view 4771
		signal 20513
	)
)

(instance wriggleyHood of View
	(properties
		sightAngle 40
		x 69
		y 54
		priority 2
		fixPriority 1
		view 473
		loop 6
		signal 20513
	)
)

(instance wriggleyShip of View
	(properties
		sightAngle 40
		y 47
		priority 1
		fixPriority 1
		view 4750
		signal 20513
	)

	(method (init)
		(engines init:)
		(super init:)
	)

	(method (dispose)
		(engines dispose:)
		(super dispose:)
	)
)

(instance hood of View
	(properties
		noun 5
		sightAngle 40
		approachX 182
		approachY 75
		x 192
		y 49
		priority 80
		fixPriority 1
		view 473
		loop 4
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 123)
					(gMessager say: 1 4) ; MISSING MESSAGE
				else
					(gEgo setScript: sCloseHood)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jumperCables of View
	(properties
		noun 7
		sightAngle 40
		approachX 298
		approachY 133
		x 272
		y 109
		view 473
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetItems 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rolledSign of View
	(properties
		noun 8
		sightAngle 40
		approachX 308
		approachY 129
		x 279
		y 102
		view 473
		loop 1
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetItems 0 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tailSign of View
	(properties
		noun 8
		x 282
		y 53
		view 473
		loop 2
		signal 20513
	)
)

(instance fish of View
	(properties
		noun 9
		approachX 159
		approachY 119
		x 178
		y 99
		view 473
		loop 3
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sGetTheFish)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waitingHood of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 182
		approachY 75
		x 187
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 61 192 58 205 58 191 49 196 48 208 50 215 55 207 79 192 77 188 73
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setInset: inHood)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 212
		approachY 91
		x 221
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 61 232 65 226 72 220 87 210 81
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sClimbIntoShuttle)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ship of Feature
	(properties
		noun 2
		approachX 278
		approachY 82
		x 248
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 61 195 57 209 57 223 52 237 53 240 50 245 48 243 53 250 56 268 65 291 55 285 52 291 52 315 60 315 62 311 62 297 78 300 79 299 80 309 85 310 87 310 95 306 105 309 107 309 109 307 112 319 119 319 138 303 138 283 128 280 121 272 116 257 114 258 112 252 110 251 112 237 114 234 112 231 112 230 116 223 115 228 120 238 128 242 129 253 138 211 138 204 133 188 117 187 112 178 103 178 97 182 94 190 95 196 99 198 101 204 100 222 102 233 100 219 90 211 95 201 89 208 82 203 80 189 76
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(111 ; Windshield_Sign
				(gEgo setScript: sHangTheSign)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFlashMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local9 0)
				(= cycles 1)
			)
			(1
				(if register
					(localproc_2 0 0 13 1)
				else
					(localproc_2 0 0 14 1)
				)
				(= cycles 1)
			)
			(2
				(= cycles 20)
			)
			(3
				(local2 dispose:)
				(= cycles 20)
			)
			(4
				(if (<= local9 7)
					(++ local9)
					(self changeState: 1)
					(= cycles 1)
				else
					(if register
						(localproc_2 0 0 13 1)
					else
						(localproc_2 0 0 14 1)
					)
					(gTheIconBar setupExit: 1)
					(gGame handsOn:)
					(gTheIconBar enable: 0 select: (gTheIconBar at: 2) show:)
					(FrameOut)
					(self dispose:)
				)
			)
		)
	)
)

(instance inHood of Inset
	(properties
		picture 475
		disposeNotOnMe 1
		noun 11
	)

	(method (init)
		(super init: &rest)
		(gGSound2 loop: -1 number: 479 play:)
		(= local6 0)
		(= local5 0)
		(= local8 redCable)
		(poll1 init:)
		(poll2 init:)
		(poll3 init:)
		(poll4 init:)
		(poll5 init:)
		(poll6 init:)
		(poll7 init:)
		(poll8 init:)
		(poll9 init:)
		(poll10 init:)
		(redCable init: hide:)
		(blueCable init: hide:)
		(PalCycle 0 224 228 1 15) ; Start
		(self setScript: sFlashMessage 0 1)
	)

	(method (dispose)
		(gGSound2 stop:)
		(poll1 dispose:)
		(poll2 dispose:)
		(poll3 dispose:)
		(poll4 dispose:)
		(poll5 dispose:)
		(poll6 dispose:)
		(poll7 dispose:)
		(poll8 dispose:)
		(poll9 dispose:)
		(poll10 dispose:)
		(redCable dispose:)
		(blueCable dispose:)
		(gTheIconBar setupExit: 0)
		(gTheIconBar enable: 0 show:)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(PalCycle 4) ; Off
		(super dispose:)
		(if (and local6 local5)
			(if
				(and
					(== (redCable x:) 127)
					(== (redCable y:) 98)
					(== (blueCable x:) 203)
					(== (blueCable y:) 92)
				)
				(gCurRoom setScript: sShipIsReady)
			else
				(gCurRoom setScript: sShockRoger)
			)
		else
			((gCurRoom obstacles:) delete: local7)
			(local7 dispose:)
			(gCurRoom
				addObstacle:
					(= local7
						((Polygon new:)
							type: PBarredAccess
							init: 200 66 278 66 278 81 217 84 123 81 58 70 43 39 181 75
							yourself:
						)
					)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(param1 localize: plane)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 31 temp0 291) (<= 5 temp1 124)))
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(super doit: &rest)
	)
)

(instance redCable of View
	(properties
		noun 7
		x 127
		y 97
		priority 90
		fixPriority 1
		view 478
		signal 20513
	)
)

(instance blueCable of View
	(properties
		noun 7
		x 217
		y 98
		priority 100
		fixPriority 1
		view 478
		loop 1
		cel 1
		signal 20513
	)
)

(class PollFeature of Feature
	(properties
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localSound number: 477 play:)
				(switch self
					(poll1
						(local8 posn: 132 91 show:)
					)
					(poll2
						(local8 posn: 155 91 show:)
					)
					(poll3
						(local8 posn: 178 93 show:)
					)
					(poll4
						(local8 posn: 203 92 show:)
					)
					(poll5
						(local8 posn: 226 92 show:)
					)
					(poll6
						(local8 posn: 127 98 show:)
					)
					(poll7
						(local8 posn: 154 98 show:)
					)
					(poll8
						(local8 posn: 180 99 show:)
					)
					(poll9
						(local8 posn: 207 99 show:)
					)
					(poll10
						(local8 posn: 235 98 show:)
					)
				)
				(cond
					((and (== local8 redCable) (not local6))
						(= local6 1)
						(= local8 blueCable)
						(local2 dispose:)
						(inHood setScript: sFlashMessage 0 0)
					)
					((and (== local8 blueCable) (not local5))
						(local2 dispose:)
						(= local5 1)
					)
				)
				(localproc_1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poll1 of PollFeature
	(properties
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 85 140 94 132 94 132 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll2 of PollFeature
	(properties
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 86 164 86 164 94 156 94
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll3 of PollFeature
	(properties
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 95 188 95 188 86 180 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll4 of PollFeature
	(properties
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 86 211 86 211 95 204 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll5 of PollFeature
	(properties
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 86 227 95 235 95 235 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll6 of PollFeature
	(properties
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 92 135 92 135 100 128 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll7 of PollFeature
	(properties
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 100 156 92 163 92 163 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll8 of PollFeature
	(properties
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 100 182 92 189 92 189 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll9 of PollFeature
	(properties
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 209 93 217 93 217 101 209 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poll10 of PollFeature
	(properties
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 235 93 243 93 243 101 235 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance Wriggley of SmallTalker
	(properties
		talkView 476
		talkLoop 1
	)

	(method (init)
		(= client wriggley)
		(if (and (== (client view:) 477) (== (client loop:) 1))
			(self talkView: 477 talkLoop: 4)
		else
			(self talkView: 476 talkLoop: 1)
		)
		(super init:)
	)
)

(instance Roger of SmallTalker
	(properties
		talkView 4772
		talkLoop 1
	)

	(method (init)
		(= client gEgo)
		(if (== (client view:) 477)
			(self talkLoop: 2)
		else
			(self talkLoop: 1)
		)
		(super init:)
	)
)

(instance localSound of Sound
	(properties
		flags 1
	)
)

