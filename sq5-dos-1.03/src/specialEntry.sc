;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use eureka)
(use rm240)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Motion)
(use System)

(public
	specialEntry 0
	beaClimbsOut 1
	spikeComesWith 2
)

(instance beaClimbsOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc240_1)
					(self setScript: (ScriptID 240 3) self 2) ; getOffPad
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 188 136 self)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(SetScore 204 10)
				((ScriptID 240 5) view: 280 loop: 1 cel: 5 setCycle: Beg self) ; chamber
			)
			(4
				((ScriptID 240 5) view: 259 loop: 2 cel: 2) ; chamber
				((ScriptID 240 2) ; bea
					init:
					view: 24
					loop: 0
					cel: 0
					posn: 172 109 0
					setPri: 11
					setCycle: End self
				)
			)
			(5
				((ScriptID 240 5) view: 280 loop: 1 cel: 0 setCycle: End self) ; chamber
			)
			(6
				((ScriptID 240 5) view: 259 loop: 2 cel: 1) ; chamber
				((ScriptID 240 2) ; bea
					view: 8
					loop: 2
					posn: 140 129
					setCycle: StopWalk -1
					setLoop: Grooper
					setScale: Scaler 116 71 149 123
				)
				(if (IsFlag 84)
					(gMessager say: 2 2 3 0 self) ; "Whew! I'm glad to get out of there. How come all those pretty lights are flashing? What's going on?"
				else
					(gMessager say: 2 2 56 0 self) ; "Thanks for letting me out of there Robert."
				)
			)
			(7
				((ScriptID 240 2) setMotion: MoveTo 119 127 self) ; bea
			)
			(8
				((ScriptID 240 2) setMotion: MoveTo 128 143 self) ; bea
			)
			(9
				((ScriptID 240 2) setHeading: 180 self) ; bea
			)
			(10
				(((ScriptID 240 2) looper:) dispose:) ; bea
				((ScriptID 240 2) looper: 0 setCycle: 0) ; bea
				(= cycles 3)
			)
			(11
				((ScriptID 240 2) view: 25 setLoop: 0 setScale: 0 cel: 15) ; bea
				(ClearFlag 45)
				(= gBeaState 9)
				(if (== (eureka puke:) 7)
					(= next beaGoesFirst)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance specialEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 239
					loop: 3
					cel: 0
					setPri: 1
					posn: 42 135
					setScale:
					scaleX: 110
					scaleY: 110
					setScript: shakeShip
					setCycle: End self
				)
			)
			(1
				(NormalEgo 0 2)
				(gEgo posn: 48 134 setScale: Scaler 116 71 149 123)
				((ScriptID 240 22) setCycle: Beg self) ; northDoor
			)
			(2
				(gMessager say: 20 0 28 0 self) ; "Whoa! That was close! I'd hate to try that again..."
			)
			(3
				(if (gCast contains: (ScriptID 240 2)) ; bea
					(= next beaGoesFirst)
				else
					(gGame handsOn:)
				)
				((ScriptID 240 22) stopUpd:) ; northDoor
				(self dispose:)
			)
		)
	)
)

(instance beaGoesFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo (ScriptID 240 2) self) ; bea
			)
			(1
				(gMessager say: 2 2 4 1 2 self) ; "I'm not sure if the transporter is working right. You better go first Bea."
			)
			(2
				((ScriptID 240 2) setCycle: Beg self) ; bea
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(3
				(gSq5Music2 stop:)
				((ScriptID 240 2) dispose:) ; bea
				(= seconds 2)
			)
			(4
				(gMessager say: 2 2 4 3 self) ; "Good. She didn't get killed. I guess the transporter checks out."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shakeShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(ShakeScreen 5 ssLEFTRIGHT)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance spikeComesWith of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 240 24) init: 1 setCycle: End self) ; tankTop
				((ScriptID 240 20) init: cel: 0 setCycle: End self) ; bubbles
			)
			(1)
			(2
				((ScriptID 240 24) stopUpd:) ; tankTop
				((ScriptID 240 20) dispose:) ; bubbles
				((ScriptID 240 8) setCycle: Beg self) ; spike
			)
			(3
				(gSq5Music1 number: 23 loop: -1 play:)
				((ScriptID 240 8) ; spike
					view: 244
					loop: 5
					cel: 0
					posn: 251 100
					setCycle: End self
				)
			)
			(4
				(proc240_29 1)
				((ScriptID 240 8) ; spike
					posn: 181 144
					setMotion:
						MoveTo
						(+ (gEgo x:) 30)
						(+ (gEgo y:) 5)
						self
				)
			)
			(5
				(gEgo setHeading: 135 self)
				((ScriptID 240 8) setHeading: 270) ; spike
			)
			(6
				(proc240_30)
				((ScriptID 240 8) dispose:) ; spike
				(= register 3)
				(= start 0)
				(gEgo
					view: 192
					loop: 0
					cel: 0
					setScale: Scaler 116 71 149 123
					setCycle: End self
				)
			)
			(7
				(gEgo setCycle: CT 5 -1 self)
			)
			(8
				(gEgo setCycle: End self)
				(if (-- register)
					(-= state 2)
				)
			)
			(9
				(= register 3)
				(gEgo loop: 1 cel: 0)
				(= cycles 1)
			)
			(10
				(gEgo setCycle: CT 4 1 self)
			)
			(11
				(gEgo get: 8 setCycle: CT 1 -1 self) ; Spike
				(if (-- register)
					(-= state 2)
				)
			)
			(12
				(gEgo setCycle: End self)
			)
			(13
				(gMessager say: 22 0 31 0 self) ; "Ahh, sorry Spike. I wouldn't want to forget my best little... my best little... my best little whatever you are."
			)
			(14
				(NormalEgo 0 4)
				(self dispose:)
			)
		)
	)
)

