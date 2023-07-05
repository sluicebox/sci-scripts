;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use fileScr)
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

(class cObj of Obj
	(properties)
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
				(if (or (== (proc330_2) 11) (IsFlag 112))
					(gMessager say: 0 0 (proc330_2) 0 self)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(2
				(cond
					((< (gEgo x:) 157)
						(gEgo setHeading: 45 self)
					)
					((> (gEgo x:) 210)
						(gEgo setHeading: 310 self)
					)
					(else
						(gEgo setHeading: 360 self)
					)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(cond
					((and (== (proc330_2) 11) (< (gEgo x:) 157))
						(gEgo setMotion: PolyPath 114 136 self)
					)
					((and (== (proc330_2) 11) (>= (gEgo x:) 157))
						(gEgo setMotion: PolyPath 217 138 self)
					)
					(else
						(self setScript: exitScr)
					)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
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
				((ScriptID 330 12) setPri: 145) ; spigot
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 28)
						(+ (gEgo y:) 40)
						self
				)
			)
			(2
				(gCurRoom newRoom: 310)
			)
		)
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
				(gEgo setMotion: MoveTo 83 135 egoCue)
			)
			(1
				((ScriptID 330 1) setHeading: 225 self) ; gammie
			)
			(2
				((ScriptID 330 1) loop: 4 cel: 1) ; gammie
				(= ticks 30)
			)
			(3
				(if
					(and
						(!= register 3)
						(!= (gEgo x:) 83)
						(!= (gEgo y:) 135)
					)
					(-- state)
					(= ticks 60)
				else
					(gMessager say: 11 0 4 1 self) ; "Hi ya, Gammie! I'm so glad you could come!"
				)
			)
			(4
				(gMessager say: 11 0 4 2 self) ; "I'd be glad too!"
			)
			(5
				((ScriptID 330 1) setHeading: 360 self) ; gammie
			)
			(6
				((ScriptID 330 1) ; gammie
					view: 333
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 12 1 self
				)
			)
			(7
				(UpdateScreenItem ((ScriptID 92 3) view: 1906)) ; larryTBust
				((ScriptID 330 1) setCycle: End self) ; gammie
			)
			(8
				(gGlobalSound2 number: 520 loop: 1 play:)
				(ShakeScreen 5 ssUPDOWN)
				(= cycles 2)
			)
			(9
				((ScriptID 330 1) view: 333 loop: 1 cel: 0 posn: 175 122 27) ; gammie
				(= ticks 30)
			)
			(10
				(UpdateScreenItem ((ScriptID 92 3) view: 1900 loop: 1)) ; larryTBust
				(= global171 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoCue of cObj
	(properties)

	(method (cue &tmp temp0)
		(if (not (= temp0 (enterRoomScr register:)))
			(gGame handsOn:)
			(enterRoomScr register: 0 dispose:)
		else
			(enterRoomScr register: (++ temp0))
			(switch temp0
				(2
					(gEgo setHeading: 45 self)
				)
				(3
					(gEgo loop: 8 cel: 0)
				)
			)
		)
	)
)

