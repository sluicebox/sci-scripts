;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1001)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1001 0
)

(local
	local0
)

(instance rm1001 of Rm
	(properties
		noun 9
		picture 120
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 660 665 4 6)
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
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 36 148 175 148 186 137 319 137 297 96 153 96 156 98 272 98 294 133 176 133 160 144 61 144 43 127 93 127 75 123 42 122 16 100 9 100
					yourself:
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(1005
				(gEgo
					view: 4
					posn: 165 98
					loop: 2
					setStep: 5 3
					setScale: myScaler
					setCycle: Walk
					init:
				)
				(gGame handsOn:)
			)
			(else
				(gCurRoom setScript: sBeamIn)
			)
		)
		(gSq5Music1 number: 101 setLoop: -1 play:)
	)

	(method (doit)
		(if (and (< (gEgo y:) 100) (== local0 0))
			(= local0 1)
		)
		(cond
			((and (StepOn gEgo 2) (not (gCurRoom script:)))
				(gCurRoom setScript: sExitToHall)
			)
			((and (InRect 277 100 319 110 gEgo) (not (gCurRoom script:)))
				(gCurRoom setScript: sDownRightStairs)
			)
			((and (InRect 264 130 268 142 gEgo) (not (gCurRoom script:)))
				(gCurRoom setScript: sUpRightStairs)
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

(instance sBeamIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo
					view: 6
					loop: 0
					cel: 0
					x: 100
					y: 145
					init:
					setCycle: End self
				)
			)
			(2
				(gSq5Music2 number: 603 setLoop: 1 play: self)
			)
			(3
				(gMessager say: 8 32 0 0 self) ; "Wilco, here. Go ahead, Flo."
			)
			(4
				(gEgo
					view: 4
					loop: 3
					cel: 0
					setStep: 5 3
					setCycle: Walk
					setMotion: PolyPath 120 145 self
				)
			)
			(5
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
				(if (not (IsFlag 59))
					(= next sShipBlows)
					(self dispose:)
				)
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
				(gEgo setPri: 1)
				(doorLeft x: 10)
				(doorRight x: 17)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(= ticks 20)
			)
			(4
				(doorLeft x: 13)
				(doorRight x: 14)
				(= ticks 20)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 1040)
				(self dispose:)
			)
		)
	)
)

(instance sShipBlows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShakeScreen 5 ssLEFTRIGHT)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 203 setLoop: 1 play:)
				(PalVary pvINIT 2100 1)
				(= seconds 2)
			)
			(2
				(EgoDead 36) ; "Ever get that nagging feeling you forgot something?"
				(self dispose:)
			)
		)
	)
)

(instance sDownRightStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 665
					cel: 0
					x: 273
					y: 92
					setPri: 10
					setScale: 0
					setLoop: -1
					setLoop: 2
					setCycle: End self
				)
			)
			(1
				(gSq5Music2 number: 152 setLoop: 1 play:)
				(gEgo
					setCel: 5
					setLoop: -1
					setLoop: 2
					setCycle: 0
					setMotion: MoveTo 284 116 self
				)
			)
			(2
				(gEgo
					cel: 0
					x: 273
					y: 122
					setLoop: -1
					setLoop: 3
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 4
					setLoop: -1
					loop: 1
					cel: 0
					x: 267
					y: 136
					setStep: 5 3
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 247 136 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpRightStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 665
					cel: 0
					setLoop: -1
					loop: 1
					x: 279
					y: 106
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 4
					cel: 3
					setLoop: -1
					loop: 7
					x: 269
					y: 98
					setStep: 5 3
					setCycle: Walk
					setScale: myScaler
					setMotion: MoveTo 259 98 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		x 141
		y 81
		noun 9
		view 660
		signal 16384
		cycleSpeed 10
	)
)

(instance light2 of Prop
	(properties
		x 143
		y 77
		noun 9
		view 660
		loop 1
		signal 16384
	)
)

(instance light3 of Prop
	(properties
		x 155
		y 80
		noun 9
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
		noun 9
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
		noun 9
		view 660
		loop 3
		signal 16384
	)
)

(instance doorLeft of View
	(properties
		x 13
		y 93
		noun 4
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
		noun 4
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
		noun 3
		onMeCheck 8192
	)
)

(instance carb of Feature
	(properties
		x 150
		y 84
		noun 2
		onMeCheck 64
	)
)

(instance engine of Feature
	(properties
		x 150
		y 84
		noun 5
		onMeCheck 1024
	)
)

(instance console of Feature
	(properties
		x 150
		y 84
		noun 6
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
					(gMessager say: 6 4 1 0) ; "You can't reach anything on the panel from where you're standing."
				)
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

