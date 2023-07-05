;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	killKing 0
)

(instance killKing of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 180)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'get,capture,kill,attack,annihilate/hamid')
				(= global125 1)
			)
			((Said 'draw/blade')
				(event claimed: 0)
			)
			(else
				(Print 180 0 #at -1 30) ; "Arthur! Defend yourself!"
				(event claimed: 1)
			)
		)
	)

	(method (doit)
		(if (and (== state 1) (== (gSFX prevSignal:) -1))
			(self cue:)
		)
		(if
			(and
				(== global125 4)
				(>= (gEgo cel:) 2)
				(< state 4)
				(< 10 (gEgo distanceTo: (ScriptID 130 0)) 50) ; Jabir
			)
			(self changeState: 7)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== gCurRoomNum 44)
					((ScriptID 130 1) dispose:) ; jabirHead
					(Face gEgo (ScriptID 130 0)) ; Jabir
					(self changeState: 2)
				else
					(= global169 1)
					(switch gCurRoomNum
						(37
							(= temp0 65)
							(= temp1 180)
						)
						(38
							(= temp0 90)
							(= temp1 80)
						)
						(42
							(= temp0 60)
							(= temp1 80)
						)
						(46
							(= temp0 60)
							(= temp1 87)
						)
						(48
							(= temp0 305)
							(= temp1 130)
						)
						(49
							(= temp0 77)
							(= temp1 175)
						)
					)
					(gSFX number: 102 priority: 5 loop: 1 play:)
					((ScriptID 130 0) setMotion: MoveTo temp0 temp1 self) ; Jabir
					((ScriptID 130 1) dispose:) ; jabirHead
				)
			)
			(1
				(Face gEgo (ScriptID 130 0)) ; Jabir
			)
			(2
				((ScriptID 130 0) ; Jabir
					view: 399
					ignoreActors: 1
					setLoop: -1
					setCycle: Walk
					setStep: 8 5
				)
				(if (or (== gCurRoomNum 44) (== gCurRoomNum 48))
					((ScriptID 130 0) ; Jabir
						setMotion: MoveTo (+ (gEgo x:) 54) (gEgo y:) self
					)
				else
					((ScriptID 130 0) ; Jabir
						setMotion: MoveTo (- (gEgo x:) 54) (gEgo y:) self
					)
				)
				(gSFX number: 103 priority: 5 loop: 1 play:)
				(= global176 ((ScriptID 130 0) loop:)) ; Jabir
			)
			(3
				(SetMenu 1283 112 0)
				((ScriptID 130 0) ; Jabir
					view: 395
					setLoop:
						(if (> (gEgo x:) ((ScriptID 130 0) x:)) 0 else 1) ; Jabir
					cel: 0
					setCycle: CT 3 1
					setMotion:
						MoveTo
						(if (> (gEgo x:) ((ScriptID 130 0) x:)) ; Jabir
							(- (gEgo x:) 25)
						else
							(+ (gEgo x:) 25)
						)
						(gEgo y:)
						self
				)
			)
			(4
				(HandsOff)
				((ScriptID 130 0) setMotion: 0 setCycle: End) ; Jabir
				(gEgo
					view: 23
					loop: (if (> (gEgo x:) ((ScriptID 130 0) x:)) 0 else 1) ; Jabir
					cel: 0
					setScript: 0
					setCycle: End self
				)
				(gSFX number: (proc0_20 79) priority: 5 loop: 1 play:)
			)
			(5
				(gSFX number: (proc0_20 105) priority: 5 loop: 1 play:)
				(= cycles 10)
			)
			(6
				(SetFlag 124)
				(self dispose:)
			)
			(7
				(gSFX number: (proc0_20 104) priority: 5 loop: 1 play:)
				((ScriptID 130 0) ; Jabir
					view: 397
					ignoreActors: 0
					loop: global176
					cel: 0
					setMotion: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(= cycles 15)
			)
			(8
				(Print 180 1 #at -1 30) ; "That has put a well-needed end to this false guide at last. You have surely avenged many previous victims."
				(SetFlag 122)
				(= global174 ((ScriptID 130 0) x:)) ; Jabir
				(= global175 ((ScriptID 130 0) y:)) ; Jabir
				(= global189 10)
				(= global177 gCurRoomNum)
				(= global125 2)
				(SetMenu 1283 112 1)
				(SetMenu 1281 112 1)
				(client setScript: 0)
			)
		)
	)
)

