;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use n814)
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
				(HandsOff)
				(switch gPrevRoomNum
					(38
						((ScriptID 39 2) ; theMaster
							posn: 318 138
							fightLeft: 1
							setLoop: 0
							setMotion: MoveTo 200 138 self
						)
					)
					(40
						((ScriptID 39 2) ; theMaster
							posn: 1 138
							setLoop: 1
							setMotion: MoveTo 100 138 self
						)
					)
					(41
						(if (> global103 160)
							((ScriptID 39 2) ; theMaster
								posn: 1 138
								setLoop: 1
								setMotion: MoveTo 100 138 self
							)
						else
							((ScriptID 39 2) ; theMaster
								posn: 318 138
								setLoop: 0
								fightLeft: 1
								setMotion: MoveTo 200 138 self
							)
						)
					)
					(else
						((ScriptID 39 2) ; theMaster
							posn: 1 138
							setLoop: 1
							setMotion: MoveTo 100 138 self
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
				((ScriptID 39 2) view: 638) ; theMaster
				(++ local0)
				(self setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 39 2)) ; theMaster
				(= cycles 15)
			)
			(3
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (gEgo distanceTo: (ScriptID 39 2)) 45)) ; theMaster
					)
					(self changeState: 2)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(4
				((ScriptID 39 2) ; theMaster
					view: 639
					setLoop: (if (< (gEgo x:) ((ScriptID 39 2) x:)) 0 else 1) ; theMaster
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
				(HandsOff)
				(switch gPrevRoomNum
					(38
						((ScriptID 39 2) posn: 200 140 fightLeft: 1) ; theMaster
					)
					(40
						((ScriptID 39 2) posn: 100 140) ; theMaster
					)
					(41
						(if (> global103 160)
							((ScriptID 39 2) posn: 100 170) ; theMaster
						else
							((ScriptID 39 2) posn: 200 170 fightLeft: 1) ; theMaster
						)
					)
					(else
						((ScriptID 39 2) posn: 100 147) ; theMaster
					)
				)
				(= cycles 1)
			)
			(1
				((ScriptID 39 2) view: 638) ; theMaster
				(++ local0)
				(self setScript: (ScriptID 217 (Random 0 6)) 0 (ScriptID 39 2)) ; theMaster
				(= cycles 12)
			)
			(2
				(if
					(and
						(< local0 (Random 7 12))
						(not (< (gEgo distanceTo: (ScriptID 39 2)) 45)) ; theMaster
					)
					(self changeState: 1)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(3
				(HandsOn)
				((ScriptID 39 2) ; theMaster
					view: 639
					setLoop: (if (< (gEgo x:) ((ScriptID 39 2) x:)) 0 else 1) ; theMaster
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
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 2) ignoreActors:) ; theMaster
				(gEgo ignoreActors:)
				(if (> ((ScriptID 39 2) x:) (gEgo x:)) ; theMaster
					((ScriptID 39 2) ; theMaster
						view: 639
						setLoop: (if (> ((ScriptID 39 2) x:) 187) 0 else 1) ; theMaster
						setCycle: Walk
						fightLeft: 1
						warriorX: 157
						warriorY: 135
						setMotion: MoveTo 207 135
					)
				else
					((ScriptID 39 2) ; theMaster
						view: 639
						setLoop: (if (> ((ScriptID 39 2) x:) 137) 0 else 1) ; theMaster
						setCycle: Walk
						fightLeft: 0
						warriorX: 187
						warriorY: 135
						setMotion: MoveTo 137 135
					)
				)
				(if ((ScriptID 39 2) fightLeft:) ; theMaster
					(gEgo setMotion: MoveTo 157 135)
				else
					(gEgo setMotion: MoveTo 187 135)
				)
				(= cycles 3)
			)
			(1
				(cond
					(((ScriptID 39 2) fightLeft:) ; theMaster
						(if
							(and
								(== (gEgo x:) 157)
								(== (gEgo y:) 135)
								(== ((ScriptID 39 2) x:) 207) ; theMaster
								(== ((ScriptID 39 2) y:) 135) ; theMaster
							)
							(self changeState: 3)
						else
							(= cycles 1)
						)
					)
					(
						(and
							(== (gEgo x:) 187)
							(== (gEgo y:) 135)
							(== ((ScriptID 39 2) x:) 137) ; theMaster
							(== ((ScriptID 39 2) y:) 135) ; theMaster
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
				(Face gEgo (ScriptID 39 2)) ; theMaster
				(if ((ScriptID 39 2) fightLeft:) ; theMaster
					((ScriptID 39 2) setPri: 6 setLoop: 5 cel: 0) ; theMaster
				else
					((ScriptID 39 2) setPri: 12 setLoop: 4 cel: 0) ; theMaster
				)
				(= ticks 20)
			)
			(4
				(gMessager say: 8 0 24) ; "I salute you!"
				((ScriptID 39 2) cycleSpeed: 12 setCycle: End self) ; theMaster
			)
			(5
				(gMessager say: 8 0 2) ; "En garde!"
				(gEgo
					view: 502
					setLoop: (if ((ScriptID 39 2) fightLeft:) 0 else 1) ; theMaster
					setCycle: End self
				)
			)
			(6
				(gMessager say: 8 0 1) ; "And the lesson begins!"
				((ScriptID 39 2) setCel: 0) ; theMaster
				(HandsOn)
				((ScriptID 39 2) setScript: (ScriptID 220 0)) ; theMaster, opponentFight
				(client setScript: 0)
			)
		)
	)
)

