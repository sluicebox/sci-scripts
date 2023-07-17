;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use SQRoom)
(use n666)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0 = 9
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(instance rm440 of SQRoom
	(properties
		noun 1
		picture 440
	)

	(method (init)
		(if (and (IsFlag 154) (IsFlag 153))
			(gaurdsDead init:)
			(gCurRoom addObstacle: gaurdsDead)
		else
			(gaurdsAlive init:)
			(gCurRoom addObstacle: gaurdsAlive)
		)
		(super init:)
		(gGame handsOff:)
		(Load rsVIEW 900 4481 4482 446)
		(if (and (!= gPrevRoomNum 450) (!= gPrevRoomNum 460))
			(gGSound1 number: 440 loop: -1 play:)
		)
		(cond
			((== gPrevRoomNum 450)
				(gEgo
					normalize:
					posn: 189 115
					setHeading: 180
					setScaler: Scaler 100 70 130 114
					init:
				)
				(gGame handsOn:)
			)
			((and (== gPrevRoomNum 460) (or (== gComPostNextRoomNum 0) (== gComPostNextRoomNum 440)))
				(gEgo
					normalize:
					posn: 11 133
					setHeading: 0
					setScaler: Scaler 100 70 130 114
					init:
				)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: sExitThruComPost)
			)
			(else
				(gCurRoom setScript: sEnterRoom)
			)
		)
		(if (IsFlag 154)
			(deadChesbroPoly init:)
			(gCurRoom addObstacle: deadChesbroPoly)
			(chesbro init:)
		else
			(chesbroPoly init:)
			(gCurRoom addObstacle: chesbroPoly)
			(chesbro init: setScript: sChesbroSurvey)
		)
		(if (IsFlag 153)
			(deadMagnumPoly init:)
			(gCurRoom addObstacle: deadMagnumPoly)
			(magnum init:)
		else
			(opusHead init:)
			(magnumPoly init:)
			(gCurRoom addObstacle: magnumPoly)
			(magnum init: setScript: sMagnumSurvey)
		)
		(banner init: setScript: sOvrhdBanner)
		(donuts init:)
		(door1 init:)
		(comPost init: approachVerbs: 4) ; Do
		(shuttleBayDoor init: approachVerbs: 4) ; Do
		(tubeBottom init: approachVerbs: 4) ; Do
		(tubeTop init: approachVerbs: 4) ; Do
		(exitSign init: approachVerbs: 4) ; Do
		(leftButton init: approachVerbs: 4 107) ; Do, Sidney_Arm
		(rightButton init: approachVerbs: 4 107) ; Do, Sidney_Arm
		(leftLight init: approachVerbs: 4) ; Do
		(rightLight init: approachVerbs: 4) ; Do
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 460)
			(gGSound1 setVol: 90)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: leftButton)
			(gMouseDownHandler delete: leftButton)
		)
		(if (gMouseDownHandler contains: rightButton)
			(gMouseDownHandler delete: rightButton)
		)
		(gEgo normalize: setScale: 0)
		(if (gTimers contains: tryTimer)
			(tryTimer client: 0 delete: dispose:)
		)
		(sound1 dispose:)
		(super dispose:)
	)
)

(instance sPressLeftButton of Script
	(properties)

	(method (doit)
		(if local18
			(cond
				(local16
					(self changeState: 6)
				)
				(local11
					(self changeState: 4)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 441
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(= local7 (gEgo x:))
				(= local8 (gEgo y:))
				(tryTimer setReal: tryTimer 5)
				(gEgo state: (& (gEgo state:) $fffd))
				(= cycles 1)
			)
			(3
				(= local18 1)
				(gGame handsOn:)
			)
			(4
				(= local11 0)
				(gGame handsOff:)
				(gEgo view: 441 cel: 4 setLoop: 0 1 setCycle: Beg self)
			)
			(5
				(= local9 1)
				(= local14 0)
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
			(6
				(tryTimer dispose:)
				(= local16 0)
				(= local9 1)
				(self setScript: sRightTryHand self)
			)
			(7
				(self changeState: 2)
			)
		)
	)
)

(instance sRightTryHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local6)
				(gEgo
					view: 4410
					cel: 0
					setLoop: 0 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(if (> local6 1)
					(self setScript: sRightTryLeg self)
				else
					(= ticks 60)
				)
			)
			(2
				(gEgo view: 4410 loop: 0 cel: 6 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRightTryLeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4410
					cel: 0
					setLoop: 2 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo view: 4410 loop: 2 cel: 21 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseSidArmLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 441
					cel: 0
					setLoop: 0 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo view: 442 cel: 0 setLoop: 0 1 setCycle: End self)
			)
			(2
				(gEgo view: 442 cel: 0 setLoop: 2 1 setCycle: End self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gEgo cel: 4 setCycle: Beg self)
			)
			(5
				(gEgo cel: 5 setLoop: 0 1 setCycle: Beg self)
			)
			(6
				(gEgo view: 441 cel: 4 setLoop: 0 1 setCycle: Beg self)
			)
			(7
				(gEgo normalize: 3)
				(= next s450ExitScript)
				(self dispose:)
			)
		)
	)
)

(instance sPressRightButton of Script
	(properties)

	(method (doit)
		(if local17
			(cond
				(local15
					(self changeState: 6)
				)
				(local11
					(self changeState: 4)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 441
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(= local7 (gEgo x:))
				(= local8 (gEgo y:))
				(tryTimer setReal: tryTimer 5)
				(gEgo state: (& (gEgo state:) $fffd))
				(= cycles 1)
			)
			(3
				(= local17 1)
				(gGame handsOn:)
			)
			(4
				(= local11 0)
				(gGame handsOff:)
				(gEgo view: 441 setLoop: 1 1 cel: 4 setCycle: Beg self)
			)
			(5
				(= local9 2)
				(= local14 0)
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
			(6
				(tryTimer dispose:)
				(= local15 0)
				(= local9 2)
				(self setScript: sLeftTryHand self)
			)
			(7
				(self changeState: 2)
			)
		)
	)
)

(instance sLeftTryHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local5)
				(gEgo
					view: 4410
					cel: 0
					setLoop: 1 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(if (> local5 1)
					(self setScript: sLeftTryLeg self)
				else
					(= ticks 60)
				)
			)
			(2
				(gEgo view: 4410 loop: 1 cel: 6 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeftTryLeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4410
					cel: 0
					setLoop: 3 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo view: 4410 loop: 3 cel: 21 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseSidArmRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 441
					cel: 0
					setLoop: 1 1
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo view: 442 cel: 0 setLoop: 1 1 setCycle: End self)
			)
			(2
				(gEgo view: 442 cel: 0 setLoop: 3 1 setCycle: End self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gEgo cel: 4 setCycle: Beg self)
			)
			(5
				(gEgo cel: 5 setLoop: 1 1 setCycle: Beg self)
			)
			(6
				(gEgo view: 441 cel: 4 setLoop: 1 1 setCycle: Beg self)
			)
			(7
				(gEgo normalize: 3)
				(= next s450ExitScript)
				(self dispose:)
			)
		)
	)
)

(instance s450ExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 3 466)
				(door2 init:)
				(door3 init:)
				(door4 init:)
				(door5 init:)
				(door6 init:)
				(door7 init:)
				(= ticks 60)
			)
			(1
				(sound1 number: 44001 loop: 0 play:)
				(door1 setCycle: End self)
			)
			(2
				(= ticks 60)
			)
			(3
				(sound1 number: 44002 loop: 0 play:)
				(door2 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(door2 dispose:)
				(sound1 number: 44003 loop: 0 play:)
				(door3 setCycle: End self)
			)
			(6
				(= ticks 60)
			)
			(7
				(door3 dispose:)
				(sound1 number: 44004 loop: 0 play:)
				(door4 setCycle: End self)
			)
			(8
				(= ticks 60)
			)
			(9
				(door4 dispose:)
				(sound1 number: 44005 loop: 0 play:)
				(door5 setCycle: End self)
			)
			(10
				(= ticks 60)
			)
			(11
				(door5 dispose:)
				(sound1 number: 44006 loop: 0 play:)
				(door6 setCycle: End self)
			)
			(12
				(door6 dispose:)
				(sound1 number: 44007 loop: 0 play:)
				(door7 setCycle: End self)
			)
			(13
				(gEgo
					setScaler: Scaler 70 46 113 105
					setSpeed: 9
					setCycle: Fwd
					setMotion: MoveTo 191 105 self
				)
			)
			(14
				(gEgo normalize: 3 setPri: 60)
				(= cycles 1)
			)
			(15
				(sound1 number: 44007 loop: 0 play:)
				(door7 cel: 10 setCycle: Beg self)
			)
			(16
				(gCurRoom newRoom: 450)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGSound2 number: 941 loop: 1 play:)
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 11 133
					setPri: 133
					setSpeed: local0
					setCycle: End self
					init:
				)
			)
			(2
				(gEgo normalize: loop: 2 setScaler: Scaler 100 73 130 114)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: loop: 3 posn: 11 133 init:)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(gGSound2 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 11 133
					setSpeed: local0
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance sMagnumSurvey of Script
	(properties)

	(method (doit)
		(if local13
			(cond
				((IsFlag 156)
					(= local13 0)
					(self changeState: 10)
				)
				((== (mod (= local3 (Random 2 10)) 2) 0)
					(self changeState: local3)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(magnum view: 444 loop: 0 cel: 0)
				(opusHead
					init:
					view: 444
					loop: 1
					cel: 0
					cycleSpeed: 22
					setCycle: Fwd
				)
				(= ticks (Random 180 240))
			)
			(1
				(= local13 1)
			)
			(2
				(= local13 0)
				(opusHead
					view: 4440
					loop: 1
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(3
				(self changeState: 0)
			)
			(4
				(= local13 0)
				(opusHead
					view: 4440
					loop: 2
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(5
				(self changeState: 0)
			)
			(6
				(= local13 0)
				(opusHead hide:)
				(magnum view: 4440 loop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(7
				(magnum view: 4440 loop: 3 cel: 3 setCycle: End self)
				(sound1 number: 445 loop: 0 play:)
			)
			(8
				(= cycles 1)
			)
			(9
				(opusHead show:)
				(self changeState: 0)
			)
			(10
				(if (IsFlag 155)
					(magnum setScript: sMagnumEat)
					(self dispose:)
				else
					(self setScript: sMagnumEat self)
				)
			)
			(11
				(opusHead show:)
				(self changeState: 0)
			)
		)
	)
)

(instance sMagnumEat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 155)
					(gGame handsOff:)
				)
				(opusHead hide:)
				(= local1 (Random 1 4))
				(= local13 0)
				(= local2 0)
				(magnum view: 448 cel: 0 loop: 0 setCycle: CT 3 1 self)
			)
			(1
				(donuts cel: 0)
				(magnum cel: 4 setCycle: End self)
			)
			(2
				(magnum loop: 1 cel: 0 setCycle: End self)
				(sound1 number: 442 loop: 0 play:)
			)
			(3
				(if (<= local2 local1)
					(++ local2)
					(self changeState: 2)
				else
					(= cycles 1)
				)
			)
			(4
				(magnum loop: 2 cel: 0 setCycle: End self)
				(sound1 number: 443 loop: 0 play:)
			)
			(5
				(if (IsFlag 155)
					(magnum setScript: sMagnumMorph)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sMagnumMorph of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGSound1 stop:)
				((ScriptID 0 12) client: 0 delete: dispose:) ; magnumEatingTimer
				(sChesbroSurvey dispose:)
				(SetFlag 153)
				(opusHead dispose:)
				(magnumPoly dispose:)
				((gCurRoom obstacles:) delete: magnumPoly)
				(gGame points: 3 465)
				(magnum view: 4480 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(sound1 number: 44015 loop: 0 play:)
				(magnum view: 4480 loop: 0 cel: 3 setCycle: End self)
			)
			(2
				(if (not (IsFlag 154))
					(chesbro
						view: 449
						loop: 0
						cel: 0
						setScript: sChesbroLooking
					)
				)
				(sound1 number: 44010 loop: 1 play:)
				(magnum view: 4480 setLoop: 1 1 setCycle: End self)
			)
			(3
				(magnum
					view: 4480
					setLoop: 2 1
					setCycle: Fwd
					setMotion:
						DPath
						(Random 138 242)
						(Random 130 135)
						(Random 138 242)
						(Random 130 135)
						self
				)
			)
			(4
				(magnum hide:)
				(morph
					x: (magnum x:)
					y: (magnum y:)
					cel: 0
					init:
					setCycle: CT 2 1 self
				)
			)
			(5
				(sound1 stop:)
				(= ticks 1)
			)
			(6
				(gGSound1 number: 44011 loop: 1 play:)
				(morph cel: 2 setCycle: End self)
				(magnum
					view: 4481
					loop: 0
					cel: 0
					xStep: 1
					yStep: 1
					show:
					setCycle: Fwd
				)
			)
			(7
				(morph hide:)
				(if (> (magnum x:) 180)
					(magnum
						view: 4481
						loop: 0
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (- (magnum x:) 40) (magnum y:) self
					)
				else
					(magnum
						view: 4481
						loop: 0
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo (+ (magnum x:) 40) (magnum y:) self
					)
				)
			)
			(8
				(gGSound1 stop:)
				(= ticks 1)
			)
			(9
				(sound1 number: 44010 loop: 1 play:)
				(magnum view: 4480 setLoop: 1 1 setCycle: End self)
			)
			(10
				(magnum
					view: 4480
					setLoop: 2 1
					setCycle: Fwd
					setMotion:
						DPath
						(Random 138 242)
						(Random 130 135)
						(Random 138 242)
						(Random 130 135)
						self
				)
			)
			(11
				(magnum hide:)
				(morph
					x: (magnum x:)
					y: (magnum y:)
					cel: 0
					show:
					setCycle: CT 2 1 self
				)
			)
			(12
				(sound1 stop:)
				(= ticks 1)
			)
			(13
				(morph cel: 2 setCycle: End self)
				(sound1 number: 44012 loop: 0 play:)
				(magnum view: 4481 loop: 1 cel: 0 show: setCycle: Fwd)
			)
			(14
				(morph hide:)
				(= ticks 260)
			)
			(15
				(sound1 stop:)
				(= ticks 1)
			)
			(16
				(sound1 number: 44010 loop: 1 play:)
				(magnum view: 4480 setLoop: 1 1 setCycle: End self)
			)
			(17
				(magnum
					view: 4480
					setLoop: 2 1
					setCycle: Fwd
					setMotion:
						DPath
						(Random 138 242)
						(Random 130 135)
						(Random 138 242)
						(Random 130 135)
						self
				)
			)
			(18
				(magnum hide:)
				(morph
					x: (magnum x:)
					y: (magnum y:)
					cel: 0
					show:
					setCycle: CT 2 1 self
				)
			)
			(19
				(sound1 stop:)
				(= ticks 1)
			)
			(20
				(morph cel: 2 setCycle: End self)
				(sound1 number: 44013 loop: 0 play:)
				(magnum view: 4481 loop: 2 cel: 0 show: setCycle: RandCycle)
			)
			(21
				(morph hide:)
				(= ticks 220)
			)
			(22
				(sound1 stop:)
				(= ticks 1)
			)
			(23
				(sound1 number: 44010 loop: 1 play:)
				(magnum view: 4480 setLoop: 1 1 setCycle: End self)
			)
			(24
				(magnum
					view: 4480
					setLoop: 2 1
					setCycle: Fwd
					setMotion:
						DPath
						(Random 138 242)
						(Random 130 135)
						(Random 138 242)
						(Random 130 135)
						self
				)
			)
			(25
				(magnum hide:)
				(morph
					x: (magnum x:)
					y: (magnum y:)
					cel: 0
					show:
					setCycle: CT 2 1 self
				)
			)
			(26
				(sound1 stop:)
				(= ticks 1)
			)
			(27
				(morph cel: 2 setCycle: End self)
				(sound1 number: 44014 loop: 0 play:)
				(magnum view: 4481 loop: 3 cel: 0 show: setCycle: Fwd)
			)
			(28
				(morph hide:)
				(= ticks 400)
			)
			(29
				(sound1 stop:)
				(= ticks 1)
			)
			(30
				(sound1 number: 44010 loop: 1 play:)
				(magnum view: 4480 setLoop: 1 1 setCycle: End self)
			)
			(31
				(magnum
					view: 4480
					setLoop: 2 1
					setCycle: Fwd
					setMotion:
						DPath
						(Random 138 242)
						(Random 130 135)
						163
						117
						self
				)
			)
			(32
				(magnum hide:)
				(morph
					x: (magnum x:)
					y: (magnum y:)
					cel: 0
					show:
					setCycle: CT 2 1 self
				)
			)
			(33
				(morph cel: 2 setCycle: End self)
				(deadMagnumPoly init:)
				(gCurRoom addObstacle: deadMagnumPoly)
				(magnum view: 4482 loop: 0 cel: 0 show: setCycle: CT 8 1 self)
			)
			(34
				(sound1 stop:)
				(= ticks 1)
			)
			(35
				(sound1 number: 423 loop: 0 play:)
				(magnum cel: 8 setCycle: End self)
			)
			(36
				(morph dispose:)
				(chesbro view: 449 loop: 3 cel: 0 setCycle: End)
				(gGSound1 number: 440 setVol: 127 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChesbroLooking of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== (magnum mover:) 0) (not (== state 4)))
				(self changeState: 4)
			)
			((and (> (magnum x:) 120) (not (or (== state 2) (== state 3))))
				(self changeState: 2)
			)
			((and (< (magnum x:) 120) (not (or (== state 0) (== state 1))))
				(self changeState: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chesbro view: 449 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(chesbro view: 449 loop: 3 cel: 0 setCycle: Fwd)
			)
			(2
				(chesbro view: 449 loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(chesbro view: 449 loop: 5 cel: 0 setCycle: Fwd)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sChesbroSurvey of Script
	(properties)

	(method (doit)
		(if (and local13 (== (mod (= local3 (Random 2 6)) 2) 0))
			(self changeState: local3)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chesbro view: 444 loop: 2 cel: 0 cycleSpeed: 22 setCycle: Fwd)
				(= ticks (Random 180 240))
			)
			(1
				(= local13 1)
			)
			(2
				(= local13 0)
				(chesbro
					view: 4441
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(3
				(self changeState: 0)
			)
			(4
				(= local13 0)
				(chesbro
					view: 4441
					loop: 1
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(5
				(self changeState: 0)
			)
			(6
				(= local13 0)
				(chesbro
					view: 4441
					loop: 2
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance sNervePinch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(chesbro ignoreActors: 1)
				(if (IsFlag 153)
					(SetFlag 154)
				)
				(if (and (== (gEgo x:) 230) (== (gEgo y:) 113))
					(= cycles 1)
				else
					(gEgo setMotion: DPath 246 130 230 113 self)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(cond
					((and (IsFlag 155) (== (magnum script:) sMagnumSurvey))
						(gEgo normalize: 2)
						(magnum setScript: sMagnumEat)
						(self dispose:)
					)
					((and (IsFlag 155) (== (magnum script:) sMagnumEat))
						(gEgo normalize: 2)
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (IsFlag 463)
					(gGame points: 3 464)
				else
					(gGame points: 3 463)
				)
				(gEgo hide:)
				(chesbro view: 449 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gEgo view: 449)
				(gMessager say: 9 4 7 0 self) ; "O, mumble mumble mumble mumble mumble mumble mumble mumble."
			)
			(5
				(chesbro view: 449 loop: 1 cel: 5 setCycle: CT 10 1 self)
			)
			(6
				(sound1 number: 265 setVol: 127 loop: 0 play:)
				(chesbro cel: 11 setCycle: End self)
			)
			(7
				(gEgo normalize: 1 show:)
				(chesbro view: 449 loop: 2 cel: 0)
				(= cycles 1)
			)
			(8
				(if (IsFlag 153)
					(deadChesbroPoly init:)
					(gCurRoom addObstacle: deadChesbroPoly)
					(chesbroPoly dispose:)
					((gCurRoom obstacles:) delete: chesbroPoly)
					(gaurdsDead init:)
					(gCurRoom addObstacle: gaurdsDead)
					(gaurdsAlive dispose:)
					((gCurRoom obstacles:) delete: gaurdsAlive)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(9
				(if (IsFlag 153)
					(gEgo setMotion: PolyPath 230 128 self)
				else
					(= cycles 1)
				)
			)
			(10
				(if (IsFlag 153)
					(gEgo
						setHeading: 290
						view: 2671
						loop: 1
						cel: 0
						setCycle: CT 3 1 self
					)
				else
					(= cycles 1)
				)
			)
			(11
				(if (IsFlag 153)
					(gMessager say: 37 0 0 0 self 260) ; "Smooth move! You've got his keyring."
				else
					(= cycles 1)
				)
			)
			(12
				(if (IsFlag 153)
					(gGame points: 1 467)
					(gEgo
						get: 1 ; Alarm_Key
						view: 2671
						loop: 1
						cel: 4
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(13
				(cond
					((IsFlag 153)
						(gEgo normalize: 7)
						(gGame handsOn:)
					)
					((IsFlag 155)
						(gEgo normalize: 2)
					)
					(else
						(= next sMagnumBeatsRoger)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sMagnumBeatsRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (magnum script:) sMagnumSurvey)
						(sMagnumSurvey dispose:)
					)
					((== (magnum script:) sMagnumEat)
						(sMagnumEat dispose:)
					)
				)
				(= cycles 1)
			)
			(1
				(gEgo hide:)
				(opusHead dispose:)
				(magnum
					setSpeed: 12
					view: 446
					loop: 0
					cel: 0
					setCycle: CT 14 1 self
				)
			)
			(2
				(sound1 number: 441 setVol: 32 loop: 0 play:)
				(magnum cel: 15 setCycle: CT 17 1 self)
			)
			(3
				(sound1 number: 441 setVol: 64 loop: 0 play:)
				(magnum cel: 18 setCycle: CT 20 1 self)
			)
			(4
				(sound1 number: 441 setVol: 127 loop: 0 play:)
				(magnum cel: 21 setCycle: End self)
			)
			(5
				(if (IsFlag 8)
					(EgoDead 20 self) ; "I'll bet Magnum kicks some serious butt playing marbles!"
				else
					(= cycles 1)
				)
			)
			(6
				(if (IsFlag 8)
					(magnum setScript: sMagnumSurvey)
					(chesbro setScript: sChesbroSurvey)
					(gEgo show: posn: 8 132 normalize: 0)
					(gGame handsOn:)
				else
					(SetFlag 3)
					(gCurRoom newRoom: 370)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOvrhdBanner of Script
	(properties)

	(method (doit)
		(if (and local12 (== (mod (= local4 (Random 0 18)) 2) 0))
			(self changeState: local4)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local12 0)
				(banner
					init:
					setLoop: 0 1
					moveSpeed: 12
					setMotion: MoveTo 35 35 self
				)
			)
			(1
				(= local12 1)
			)
			(2
				(= local12 0)
				(banner
					view: 4400
					setLoop: 1 1
					posn: 325 35
					setMotion: MoveTo 49 35 self
				)
			)
			(3
				(= local12 1)
			)
			(4
				(= local12 0)
				(banner setLoop: 2 1 posn: 278 35 setMotion: MoveTo 101 35 self)
			)
			(5
				(= local12 1)
			)
			(6
				(= local12 0)
				(banner setLoop: 3 1 posn: 294 35 setMotion: MoveTo 104 35 self)
			)
			(7
				(= local12 1)
			)
			(8
				(= local12 0)
				(banner
					posn: 193 35
					cel: 0
					setSpeed: 20
					setLoop: 4
					setCycle: End self
				)
			)
			(9
				(= local12 1)
			)
			(10
				(= local12 0)
				(banner
					posn: 193 35
					cel: 0
					setSpeed: 20
					setLoop: 5
					setCycle: End self
				)
			)
			(11
				(= local12 1)
			)
			(12
				(= local12 0)
				(banner posn: 193 35 cel: 0 setSpeed: 20 loop: 6 setCycle: Fwd)
				(= ticks 180)
			)
			(13
				(= local12 1)
			)
			(14
				(= local12 0)
				(banner
					posn: 193 35
					cel: 0
					setSpeed: 20
					loop: 7
					setCycle: End self
				)
			)
			(15
				(= local12 1)
			)
			(16
				(= local12 0)
				(banner
					loop: 8
					cel: 0
					setSpeed: 20
					posn: 163 35
					setCycle: End self
				)
			)
			(17
				(= local12 1)
			)
			(18
				(= local12 0)
				(banner
					loop: 9
					cel: 0
					setSpeed: 20
					posn: 190 35
					setCycle: End self
				)
			)
			(19
				(= local12 1)
			)
		)
	)
)

(instance sDonutPut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sMagnumSurvey dispose:)
				(gEgo setMotion: PolyPath 57 114 self)
			)
			(1
				(putDonut init: cel: 0 loop: 2 setCycle: CT 5 1 self)
			)
			(2
				(donuts cel: 1)
				(putDonut cel: 5 setCycle: End self)
			)
			(3
				(putDonut dispose:)
				(magnum setScript: sMagnumSurvey)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDonutToss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sMagnumSurvey dispose:)
				(gEgo setMotion: PolyPath 319 118 self)
			)
			(1
				(tossDonut init: loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(tossDonut dispose:)
				(donuts cel: 1)
				(magnum setScript: sMagnumSurvey)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance morph of Actor
	(properties
		noun 8
		view 4480
		loop 3
		signal 20513
	)
)

(instance magnum of Actor
	(properties
		noun 8
		signal 20513
	)

	(method (init)
		(if (IsFlag 153)
			(self view: 4482 loop: 0 cel: 16 x: 163 y: 117)
		else
			(self view: 444 loop: 0 cel: 0 x: 163 y: 117)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 153)
						(gMessager say: 8 1 2) ; "My, this guy would give Sybil a run for her money."
					)
					((== gAct 1)
						(gMessager say: 8 1 3) ; "This is Magnum Opus. You owe him 200 buckazoids from a lost bet. In other words, scram."
					)
					((> gAct 1)
						(gMessager say: 8 1) ; "Magnum Opus belongs to an elite StarCon fighting force called The Flying Flingers (FF for short)."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chesbro of Prop
	(properties
		noun 9
		signal 20513
	)

	(method (init)
		(if (IsFlag 154)
			(self view: 449 loop: 2 cel: 0 x: 213 y: 114)
		else
			(self view: 444 loop: 2 cel: 0 x: 213 y: 114)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((< gAct 2)
						(gMessager say: 9 1 3) ; "This is your dear crewmate, Chesbro."
					)
					((IsFlag 154)
						(gMessager say: 9 1 2) ; "That is an incapacitated security guard. I think it's time to spend a lot less time leisurely touring and a lot more time trying to get your can out of this place."
					)
					(else
						(gMessager say: 9 1) ; "That's Chesbro, one of the Shuttlebay guards."
					)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 154)
						(gMessager say: 9 4 2) ; "Yep, he's nonfunctional, all right."
					)
					((IsFlag 141)
						(if (IsFlag 118)
							(self setScript: sNervePinch)
						else
							(gMessager say: 0 4 2 0 0 0) ; "You didn't learn the pinch just to use it against your friendly crew mates."
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opusHead of Prop
	(properties
		noun 8
		x 163
		y 117
		view 444
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 153)
						(gMessager say: 8 1 2) ; "My, this guy would give Sybil a run for her money."
					)
					((== gAct 1)
						(gMessager say: 8 1 3) ; "This is Magnum Opus. You owe him 200 buckazoids from a lost bet. In other words, scram."
					)
					((> gAct 1)
						(gMessager say: 8 1) ; "Magnum Opus belongs to an elite StarCon fighting force called The Flying Flingers (FF for short)."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tossDonut of Prop
	(properties
		x 206
		y 78
		view 447
		loop 1
	)
)

(instance putDonut of Prop
	(properties
		x 67
		y 95
		view 447
		loop 2
	)
)

(instance donuts of Prop
	(properties
		noun 10
		x 113
		y 97
		view 4470
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 153))
					(gMessager say: 10 1) ; "Mmmm! A nice fatty doughnut. Magnum will probably scarf this down. After all, he needs to maintain his boyish, tub o' guts figure."
				)
			)
			(96 ; Donut_Morph
				(cond
					((IsFlag 153)
						(gMessager say: 10 12) ; "There's no need to attempt it again."
					)
					((< (gEgo x:) 93)
						(if
							(or
								(and
									(== (opusHead view:) 444)
									(or
										(== (opusHead cel:) 8)
										(== (opusHead cel:) 9)
									)
								)
								(and
									(== (chesbro view:) 444)
									(or
										(== (chesbro cel:) 7)
										(== (chesbro cel:) 8)
									)
								)
							)
							(gMessager say: 10 4 1) ; "You're being watched!"
						else
							(gEgo put: 32) ; Donut_Morph
							((ScriptID 0 12) setReal: (ScriptID 0 12) 2) ; magnumEatingTimer, magnumEatingTimer
							(SetFlag 155)
							(self setScript: sDonutPut)
						)
					)
					((> (gEgo x:) 292)
						(if
							(or
								(and
									(== (opusHead view:) 444)
									(or
										(== (opusHead cel:) 8)
										(== (opusHead cel:) 9)
									)
								)
								(and
									(== (chesbro view:) 444)
									(or
										(== (chesbro cel:) 7)
										(== (chesbro cel:) 8)
									)
								)
							)
							(gMessager say: 10 4 1) ; "You're being watched!"
						else
							(gEgo put: 32) ; Donut_Morph
							((ScriptID 0 12) setReal: (ScriptID 0 12) 2) ; magnumEatingTimer, magnumEatingTimer
							(SetFlag 155)
							(self setScript: sDonutToss)
						)
					)
					((and (>= (gEgo x:) 93) (<= (gEgo x:) 292))
						(gMessager say: 10 4 1) ; "You're being watched!"
					)
				)
			)
			(12 ; Donut
				(cond
					((IsFlag 196)
						(gMessager say: 8 12 4) ; "Nah. You already tried throwing the plain doughnut."
					)
					((IsFlag 153)
						(gMessager say: 10 12) ; "There's no need to attempt it again."
					)
					((< (gEgo x:) 93)
						(if
							(or
								(and
									(== (opusHead view:) 444)
									(or
										(== (opusHead cel:) 8)
										(== (opusHead cel:) 9)
									)
								)
								(and
									(== (chesbro view:) 444)
									(or
										(== (chesbro cel:) 7)
										(== (chesbro cel:) 8)
									)
								)
							)
							(gMessager say: 10 4 1) ; "You're being watched!"
						else
							(SetFlag 196)
							(gEgo put: 31) ; Donut
							(self setScript: sDonutPut)
						)
					)
					((> (gEgo x:) 292)
						(if
							(or
								(and
									(== (opusHead view:) 444)
									(or
										(== (opusHead cel:) 8)
										(== (opusHead cel:) 9)
									)
								)
								(and
									(== (chesbro view:) 444)
									(or
										(== (chesbro cel:) 7)
										(== (chesbro cel:) 8)
									)
								)
							)
							(gMessager say: 10 4 1) ; "You're being watched!"
						else
							(SetFlag 196)
							(gEgo put: 31) ; Donut
							(self setScript: sDonutToss)
						)
					)
					((and (>= (gEgo x:) 93) (<= (gEgo x:) 292))
						(gMessager say: 10 4 1) ; "You're being watched!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance banner of Actor
	(properties
		x 335
		y 35
		view 4400
	)
)

(instance door1 of Prop
	(properties
		x 171
		y 62
		view 440
	)

	(method (init)
		(super init: &rest)
		(self setPri: 67 ignoreActors: 1)
	)
)

(instance door2 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 66 ignoreActors: 1)
	)
)

(instance door3 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 65 ignoreActors: 1)
	)
)

(instance door4 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 64 ignoreActors: 1)
	)
)

(instance door5 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 63 ignoreActors: 1)
	)
)

(instance door6 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 62 ignoreActors: 1)
	)
)

(instance door7 of Prop
	(properties
		x 171
		y 62
		view 440
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 61 ignoreActors: 1)
	)
)

(instance leftButton of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 179
		approachY 115
		x 154
		y 115
		z 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 80 161 80 158 90 148 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 154) (IsFlag 153))
					(if (not local14)
						(= local14 1)
						(gCurRoom setScript: sPressLeftButton)
						(gMouseDownHandler addToFront: leftButton)
					else
						(= local15 1)
					)
				else
					(gMessager say: 13 4 8) ; "An interesting idea. What are you up to, Roger?"
				)
			)
			(107 ; Sidney_Arm
				(if (and (IsFlag 154) (IsFlag 153))
					(if local17
						(if local14
							(gCurRoom setScript: sUseSidArmRight)
						else
							(gCurRoom setScript: sUseSidArmLeft)
						)
					else
						(gCurRoom setScript: sUseSidArmLeft)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser input:)
				(gUser controls:)
				(& (event type:) evMOUSEBUTTON)
				(not (event modifiers:))
				(not (rightButton onMe: event))
			)
			(if (gMouseDownHandler contains: self)
				(gMouseDownHandler delete: self)
			)
			(gEgo normalize: 3)
			(= local17 0)
			(= local15 0)
			(= local14 0)
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
	)
)

(instance rightButton of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 200
		approachY 115
		x 228
		y 115
		z 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 80 232 80 234 90 225 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 154) (IsFlag 153))
					(if (not local14)
						(= local14 1)
						(gCurRoom setScript: sPressRightButton)
						(gMouseDownHandler addToFront: rightButton)
					else
						(= local16 1)
					)
				else
					(gMessager say: 12 4 8) ; "An interesting idea. What are you up to, Roger?"
				)
			)
			(107 ; Sidney_Arm
				(if (and (IsFlag 154) (IsFlag 153))
					(if local18
						(if local14
							(gCurRoom setScript: sUseSidArmLeft)
						else
							(gCurRoom setScript: sUseSidArmRight)
						)
					else
						(gCurRoom setScript: sUseSidArmRight)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser input:)
				(gUser controls:)
				(& (event type:) evMOUSEBUTTON)
				(not (event modifiers:))
				(not (leftButton onMe: event))
			)
			(if (gMouseDownHandler contains: self)
				(gMouseDownHandler delete: self)
			)
			(gEgo normalize: 3)
			(= local18 0)
			(= local16 0)
			(= local14 0)
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
	)
)

(instance comPost of Feature
	(properties
		noun 3
		nsLeft 5
		nsTop 94
		nsRight 18
		nsBottom 104
		sightAngle 40
		approachX 11
		approachY 133
		x 11
		y 99
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shuttleBayDoor of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 189
		approachY 115
		x 189
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 241 112 225 40 158 40 141 112
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeBottom of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 11
		approachY 133
		x 11
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 131 6 130 19 130 29 132 19 134 0 134
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeTop of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 11
		approachY 133
		x 11
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 35 16 36 24 36 29 34 29 0 0 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitSign of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 189
		approachY 115
		x 189
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 29 162 38 222 38 222 29
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftLight of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 116
		approachY 120
		x 116
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 85 117 85 122 80 108 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightLight of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 265
		approachY 120
		x 265
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 80 267 85 282 85 277 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance deadMagnumPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super init: 120 114 201 114 205 119 112 119)
	)
)

(instance deadChesbroPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super init: 204 113 221 113 238 123 233 133 189 134 185 125)
	)
)

(instance magnumPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super init: 131 111 196 112 199 118 107 118)
	)
)

(instance chesbroPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super init: 198 112 233 112 233 117 199 117)
	)
)

(instance gaurdsAlive of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 12 131 0 133 318 137 264 122 319 117 248 120 241 118 201 118 198 118 128 118 121 120 57 114 115 122 73 130
		)
	)
)

(instance gaurdsDead of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 12 131 0 133 318 137 264 122 319 117 248 120 228 114 138 114 121 120 57 114 115 122 73 130
		)
	)
)

(instance tryTimer of Timer
	(properties)

	(method (cue)
		(= local11 1)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

