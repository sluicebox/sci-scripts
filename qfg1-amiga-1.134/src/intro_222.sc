;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	intro 0
	intro2 1
	startFight 2
)

(local
	local0
)

(instance intro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(38
						((ScriptID 221 0) ; theMaster
							posn: 318 140
							fightLeft: 1
							setMotion: MoveTo 200 140 self
						)
					)
					(40
						((ScriptID 221 0) ; theMaster
							posn: 1 140
							setMotion: MoveTo 100 140 self
						)
					)
					(41
						(if (> global105 160)
							((ScriptID 221 0) ; theMaster
								posn: 1 170
								setMotion: MoveTo 100 170 self
							)
						else
							((ScriptID 221 0) ; theMaster
								posn: 318 170
								fightLeft: 1
								setMotion: MoveTo 200 170 self
							)
						)
					)
					(else
						((ScriptID 221 0) ; theMaster
							posn: 1 130
							setMotion: MoveTo 100 130 self
						)
					)
				)
			)
			(1
				(if (not (IsFlag 243))
					(SetFlag 243)
				)
				(self cue:)
			)
			(2
				((ScriptID 221 0) view: 638) ; theMaster
				(++ local0)
				(self setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 221 0)) ; theMaster
				(= cycles 15)
			)
			(3
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (gEgo distanceTo: (ScriptID 221 0)) 40)) ; theMaster
					)
					(self changeState: 2)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(4
				((ScriptID 221 0) ; theMaster
					view: 639
					setLoop:
						(if (< (gEgo x:) ((ScriptID 221 0) x:)) 5 else 4) ; theMaster
					setCel: 0
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance intro2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(38
						((ScriptID 221 0) posn: 200 140 fightLeft: 1) ; theMaster
					)
					(40
						((ScriptID 221 0) posn: 100 140) ; theMaster
					)
					(41
						(if (> global105 160)
							((ScriptID 221 0) posn: 100 170) ; theMaster
						else
							((ScriptID 221 0) posn: 200 170 fightLeft: 1) ; theMaster
						)
					)
					(else
						((ScriptID 221 0) posn: 100 130) ; theMaster
					)
				)
				(= cycles 1)
			)
			(1
				((ScriptID 221 0) view: 638) ; theMaster
				(++ local0)
				(self setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 221 0)) ; theMaster
				(= cycles 12)
			)
			(2
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (gEgo distanceTo: (ScriptID 221 0)) 40)) ; theMaster
					)
					(self changeState: 1)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(3
				((ScriptID 221 0) ; theMaster
					view: 639
					setLoop:
						(if (< (gEgo x:) ((ScriptID 221 0) x:)) 5 else 4) ; theMaster
					setCel: 0
				)
				(client setScript: 0)
			)
		)
	)
)

(instance startFight of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 222)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 221 0) ignoreActors:) ; theMaster
				(gEgo ignoreActors:)
				(if (> ((ScriptID 221 0) x:) (gEgo x:)) ; theMaster
					((ScriptID 221 0) ; theMaster
						view: 639
						setLoop: -1
						setCycle: Walk
						fightLeft: 1
						warriorX: 125
						setMotion: MoveTo 187 150
					)
				else
					((ScriptID 221 0) ; theMaster
						view: 639
						setLoop: -1
						setCycle: Walk
						fightLeft: 0
						setMotion: MoveTo 125 150
					)
				)
				(if ((ScriptID 221 0) fightLeft:) ; theMaster
					(gEgo setMotion: MoveTo 125 150)
				else
					(gEgo setMotion: MoveTo 187 150)
				)
				(= cycles 3)
			)
			(1
				(cond
					(((ScriptID 221 0) fightLeft:) ; theMaster
						(if
							(and
								(== (gEgo x:) 125)
								(== (gEgo y:) 150)
								(== ((ScriptID 221 0) x:) 187) ; theMaster
								(== ((ScriptID 221 0) y:) 150) ; theMaster
							)
							(self changeState: 3)
						else
							(= cycles 1)
						)
					)
					(
						(and
							(== (gEgo x:) 187)
							(== (gEgo y:) 150)
							(== ((ScriptID 221 0) x:) 125) ; theMaster
							(== ((ScriptID 221 0) y:) 150) ; theMaster
						)
						(self changeState: 3)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(self changeState: 1)
			)
			(3
				(LookAt gEgo (ScriptID 221 0)) ; theMaster
				(if ((ScriptID 221 0) fightLeft:) ; theMaster
					((ScriptID 221 0) setLoop: 5 cel: 0) ; theMaster
				else
					((ScriptID 221 0) setLoop: 4 cel: 0) ; theMaster
				)
				(= cycles 5)
			)
			(4
				((ScriptID 221 0) cycleSpeed: 2 setCycle: CT 2 1) ; theMaster
				(= cycles 10)
			)
			(5
				(HighPrint 222 0) ; "I salute you!"
				(gEgo
					view: 639
					setLoop: (if ((ScriptID 221 0) fightLeft:) 8 else 9) ; theMaster
					setCycle: CT 2 1
				)
				(= cycles 10)
			)
			(6
				(HighPrint 222 1) ; ""En garde!" shouts the Weapon Master..."
				((ScriptID 221 0) setCel: 3) ; theMaster
				(gEgo setCel: 3)
				(= cycles 5)
			)
			(7
				(HighPrint 222 2) ; "And the lesson begins!"
				(HandsOn)
				((ScriptID 221 0) setScript: (ScriptID 220 0)) ; theMaster, opponentFight
				(client setScript: 0)
			)
		)
	)
)

