;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use rm330)
(use PolyPath)
(use Motion)
(use System)

(public
	leaveWithMsgScr 0
	exitScr 1
	notWhileRunningScr 2
	enterRoomScr 3
)

(instance leaveWithMsgScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 (proc330_2) 0 self)
			)
			(2
				(self setScript: (exitScr start: 1 yourself:))
			)
		)
	)
)

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 28)
						(+ (gEgo y:) 40)
						self
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 331)
	)
)

(instance notWhileRunningScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 34 0 self) ; "You're too energy conscious to leave the room while that giant Cellulite Drainage Machine is running."
			)
			(2
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 4) self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 331)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (OneOf global171 6 7)
					((ScriptID 330 1) ; gammie
						view: 203
						loop: 3
						cel: 0
						posn: 192 145 0
						setCycle: Walk
						setMotion: MoveTo 194 131 self
						init:
					)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo setMotion: MoveTo 83 135 self)
			)
			(1
				(if (not register)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				((ScriptID 330 1) ; gammie
					view: 333
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gGlobalSound2 number: 520 loop: 1 play:)
				(ShakeScreen 5 ssUPDOWN)
				(= cycles 2)
			)
			(4
				((ScriptID 330 1) view: 333 loop: 1 cel: 0 posn: 175 122 27) ; gammie
				(= global171 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 331)
	)
)

