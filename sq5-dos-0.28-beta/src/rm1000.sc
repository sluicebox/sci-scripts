;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1000 0
)

(local
	local0 = 1
	local1
	local2
)

(instance rm1000 of Rm
	(properties
		noun 8
		picture 120
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 664 663 673 661 678 660)
		(SetScore 234 50)
		(NormalEgo 0)
		(switch gPrevRoomNum
			(1005
				(NormalEgo 664 2)
				(gEgo posn: 160 97 init: setScale: myScaler)
			)
			(1010
				(doorLeft x: 6)
				(doorRight x: 20)
				(gCurRoom setScript: sEnterFromHall)
			)
			(1040
				(gCurRoom setScript: sEnterFromHall)
			)
			(else
				(= local2 1)
				(SetScore 244 20)
				(gEgo
					view: 663
					setLoop: -1
					setLoop: 0
					cel: 0
					x: 120
					y: 230
					setStep: 5 4
					scaleSignal: 1
					scaleX: 86
					scaleY: 86
					setPri: 1
					setCycle: 0
					init:
				)
				(gCurRoom setScript: sUpFromPod)
			)
		)
		(light1 init: setCycle: Fwd)
		(light2 init: setCycle: Fwd)
		(light3 init: setCycle: Fwd)
		(light4 init: setCycle: Fwd)
		(if (IsFlag 59)
			(driveOnOffLight cel: 2)
		else
			(driveOnOffLight cel: 0)
		)
		(driveOnOffLight init:)
		(doorLeft init:)
		(doorRight init:)
		(console init:)
		(engine init: setOnMeCheck: 1 1024)
		(carb init: setOnMeCheck: 1 64)
		(catwalk init: setOnMeCheck: 1 8192)
		(guard init: hide: setScript: sGuardPatrol)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 36 148 175 148 186 137 319 137 297 96 153 96 156 98 272 98 294 133 176 133 160 144 61 144 43 127 93 127 75 123 42 122 16 100 9 100
					yourself:
				)
		)
		(super init:)
		(gSq5Music1 number: 101 setLoop: -1 play:)
		(if local2
			(walkCheck init:)
		)
		(gGame handsOn:)
	)

	(method (doit)
		(Palette palANIMATE 65 69 10)
		(if (and (< (gEgo y:) 100) (== local1 0))
			(= local1 1)
		)
		(cond
			((and (StepOn gEgo 2) (not (gCurRoom script:)))
				(gCurRoom setScript: sExitToHall)
			)
			((and (StepOn gEgo 4) (not (gCurRoom script:)))
				(gCurRoom setScript: sDownLeftStairs)
			)
			((and (StepOn gEgo 8) (not (gCurRoom script:)))
				(if (< (gEgo y:) 139)
					(gCurRoom setScript: sUpDownLittleStairs 0 0)
				else
					(gCurRoom setScript: sUpDownLittleStairs 0 1)
				)
			)
			((and (InRect 277 100 319 132 gEgo) (not (gCurRoom script:)))
				(if (< (gEgo y:) 110)
					(gCurRoom setScript: sUpDownRightStairs 0 0)
				else
					(gCurRoom setScript: sUpDownRightStairs 0 1)
				)
			)
			(
				(and
					(InRect 15 135 90 142 gEgo)
					(not (gEgo scaler:))
					(not (gCurRoom script:))
				)
				(gEgo setScale: Scaler 100 22 145 103)
			)
			((and (InRect 15 143 90 150 gEgo) (gEgo scaler:))
				(gEgo setScale: 0)
			)
		)
		(super doit: &rest)
	)
)

(instance sGuardPatrol of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(or
				(and (> (guard y:) 104) (InRect 16 100 188 148 gEgo))
				(and (> (guard y:) 119) (InRect 188 133 319 137 gEgo))
			)
			(guard setMotion: 0 setCycle: 0)
			(= next sGuardShoots)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* 10 local0))
			)
			(1
				(if (InRect 16 100 30 120 gEgo)
					(-- state)
					(= cycles 1)
				else
					(guard show:)
					(doorLeft x: 10)
					(doorRight x: 17)
					(gSq5Music2 number: 103 setLoop: 1 play:)
					(= ticks 20)
				)
			)
			(2
				(doorLeft x: 6)
				(doorRight x: 20)
				(= ticks 20)
			)
			(3
				(guard
					setPri: -1
					setLoop: -1
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 19 111 self
				)
			)
			(4
				(guard setLoop: 0 setCycle: Osc 1 self)
			)
			(5
				(guard
					setLoop: -1
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 26 120 self
				)
			)
			(6
				(guard setLoop: 0 setCycle: Osc 1 self)
			)
			(7
				(guard
					setLoop: -1
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 33 129 self
				)
			)
			(8
				(guard setLoop: 1 setCycle: End self)
			)
			(9
				(guard
					setLoop: -1
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 12 102 self
				)
			)
			(10
				(guard setPri: 1)
				(doorLeft x: 10)
				(doorRight x: 17)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(= ticks 6)
			)
			(11
				(doorLeft x: 13)
				(doorRight x: 14)
				(guard hide:)
				(= ticks 6)
			)
			(12
				(if (== local0 1)
					(= local0 3)
				else
					(= local0 1)
				)
				(= state -1)
				(= cycles 1)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance sGuardShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (guard loop:)
					(0
						(guard setCycle: Beg self)
					)
					(1
						(guard setCycle: Beg self)
					)
					(3
						(guard
							setLoop: 1
							setCel: (guard lastCel:)
							setCycle: Beg self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(guard view: 673)
				(cond
					((< (gEgo x:) 60)
						(guard setLoop: 2)
						(pukeShot
							x: (- (guard x:) (/ (* 10 (guard scaleX:)) 128))
							y: (- (guard y:) (/ (* 43 (guard scaleY:)) 128))
						)
					)
					((< (gEgo x:) 145)
						(guard setLoop: 4)
						(pukeShot
							x: (+ (guard x:) (/ (* 9 (guard scaleX:)) 128))
							y: (- (guard y:) (/ (* 38 (guard scaleY:)) 128))
						)
					)
					(else
						(guard setLoop: 0)
						(pukeShot
							x: (+ (guard x:) (/ (* 16 (guard scaleX:)) 128))
							y: (- (guard y:) (/ (* 40 (guard scaleY:)) 128))
						)
					)
				)
				(guard cel: 0 setCycle: End)
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(pukeShot
					init:
					setLoop: -1
					setLoop: 8
					setCel: 0
					setCycle: 0
					setStep: 20 10
					setMotion:
						MoveTo
						(- (gEgo x:) (/ (* 5 (gEgo scaleX:)) 128))
						(- (gEgo y:) (/ (* 29 (gEgo scaleY:)) 128))
						self
				)
			)
			(2
				(pukeShot setLoop: 9 setCycle: End)
				(gEgo view: 6501 cel: 0 setCycle: End self)
			)
			(3
				(EgoDead 33) ; "It's a nice look for you. Too bad it can't last."
				(self dispose:)
			)
		)
	)
)

(instance sDownLeftStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 663
					setLoop: -1
					setLoop: 1
					cel: 0
					setStep: 5 4
					setScale: 0
					scaleX: 86
					scaleY: 86
					scaleSignal: 1
					setPri: 1
					setCycle: Walk
					setMotion: MoveTo 120 230 self
				)
			)
			(1
				(gMessager say: 6 3 0 0 self) ; "You knew this was a one way trip the moment you stepped into the EVA pod, Roger. There's no turning back now."
			)
			(2
				(gEgo setLoop: 0 setMotion: MoveTo 116 188 self)
			)
			(3
				(walkCheck init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpFromPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo setLoop: 0 setMotion: MoveTo 116 188 self)
			)
			(2
				(walkCheck init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 664
					x: 13
					y: 102
					setScale: Scaler 100 22 145 103
					setCycle: Walk
					init:
					setMotion: MoveTo 14 110 self
				)
			)
			(1
				(doorLeft x: 10)
				(doorRight x: 17)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(= ticks 20)
			)
			(2
				(doorLeft x: 13)
				(doorRight x: 14)
				(walkCheck dispose:)
				(= ticks 20)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorLeft x: 10)
				(doorRight x: 17)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(= ticks 20)
			)
			(1
				(doorLeft x: 6)
				(doorRight x: 20)
				(= ticks 20)
			)
			(2
				(gEgo setMotion: MoveTo 13 102 self)
			)
			(3
				(gCurRoom newRoom: 1010)
				(self dispose:)
			)
		)
	)
)

(instance sUpLeftStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: -1
					setLoop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 73 125 self
				)
			)
			(1
				(gEgo
					view: 664
					cel: 0
					setLoop: -1
					loop: 1
					setPri: -1
					setScale: Scaler 100 22 145 103
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
				)
			)
			(2
				(walkCheck dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpDownRightStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo
						view: 663
						cel: 0
						setLoop: -1
						setLoop: 0
						setStep: 5 4
						cycleSpeed: 4
						y: 132
						setCycle: Walk
						setMotion: PolyPath (- (gEgo x:) 23) 98 self
					)
				else
					(gEgo
						view: 663
						cel: 0
						setLoop: -1
						setLoop: 1
						setScale: 0
						setCycle: Walk
						setMotion: PolyPath (+ (gEgo x:) 21) 136 self
					)
				)
			)
			(1
				(if register
					(gEgo
						view: 664
						cel: 0
						setLoop: -1
						loop: 1
						cycleSpeed: 6
						setCycle: Walk
						setScale: myScaler
						setMotion: PolyPath 237 98 self
					)
				else
					(gEgo
						view: 664
						cel: 0
						setLoop: -1
						loop: 1
						setCycle: Walk
						setMotion: PolyPath 280 136 self
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpDownLittleStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not register)
					(gEgo
						setMotion:
							PolyPath
							(- (gEgo x:) 15)
							(gEgo y:)
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(gEgo
						view: 664
						setLoop: -1
						setLoop: 8
						cel: 0
						x: 168
						y: 139
						setCycle: End self
					)
				else
					(gEgo
						view: 664
						setLoop: -1
						setLoop: 9
						cel: 0
						x: 170
						y: 135
						setCycle: End self
					)
				)
			)
			(2
				(gEgo view: 664 cel: 0 setLoop: -1 setCycle: Walk)
				(if register
					(gEgo
						loop: 0
						cel: 6
						x: 190
						y: 136
						setMotion: MoveTo 208 136 self
					)
				else
					(gEgo
						loop: 1
						cel: 1
						x: 155
						y: 145
						setMotion: MoveTo 130 145 self
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guard of Actor
	(properties
		x 12
		y 102
		noun 7
		view 661
		loop 2
		priority 1
		signal 16400
		cycleSpeed 10
		moveSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 100 22 145 103)
	)
)

(instance pukeShot of Actor
	(properties
		view 678
		signal 16384
		moveSpeed 0
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 100 22 145 103)
	)
)

(instance light1 of Prop
	(properties
		x 141
		y 81
		noun 8
		view 660
		signal 16384
		cycleSpeed 10
	)
)

(instance light2 of Prop
	(properties
		x 143
		y 77
		noun 8
		view 660
		loop 1
		signal 16384
	)
)

(instance light3 of Prop
	(properties
		x 155
		y 80
		noun 8
		view 660
		loop 2
		signal 16384
		cycleSpeed 14
	)
)

(instance light4 of Prop
	(properties
		x 156
		y 83
		noun 8
		view 660
		loop 2
		signal 16384
		cycleSpeed 10
	)
)

(instance driveOnOffLight of Prop
	(properties
		x 165
		y 78
		noun 8
		view 660
		loop 3
		signal 16384
	)
)

(instance doorLeft of View
	(properties
		x 13
		y 93
		noun 3
		view 660
		loop 4
		priority 2
		signal 16400
	)
)

(instance doorRight of View
	(properties
		x 14
		y 93
		noun 3
		view 660
		loop 4
		cel 1
		priority 2
		signal 16400
	)
)

(instance catwalk of Feature
	(properties
		x 150
		y 84
		noun 2
		onMeCheck 8192
	)
)

(instance carb of Feature
	(properties
		x 150
		y 84
		noun 1
		onMeCheck 64
	)
)

(instance engine of Feature
	(properties
		x 150
		y 84
		noun 4
		onMeCheck 1024
	)
)

(instance console of Feature
	(properties
		x 150
		y 84
		noun 5
		nsTop 74
		nsLeft 120
		nsBottom 97
		nsRight 184
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (InRect 153 92 174 100 gEgo)
					(gCurRoom newRoom: 1005)
				else
					(gMessager say: 5 4 1 0) ; "You can't reach anything on the panel from where you're standing."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walkCheck of Feature
	(properties
		x 150
		y 84
		nsBottom 189
		nsRight 319
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: walkCheck)
	)

	(method (dispose)
		(gWalkHandler delete: walkCheck)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sUpLeftStairs)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myScaler of Scaler
	(properties)

	(method (init param1)
		(if argc
			(= client param1)
		)
		(self doit:)
	)

	(method (doit)
		(if (> (gEgo x:) 250)
			(gEgo scaleSignal: 1 scaleX: 128 scaleY: 128)
		else
			(gEgo
				scaleSignal: 1
				scaleX: (- 128 (/ (* 2 (- 250 (gEgo x:))) 3))
				scaleY: (gEgo scaleX:)
			)
		)
	)
)

