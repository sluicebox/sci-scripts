;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 821)
(include sci.sh)
(use Main)
(use n913)
(use DPath)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	throwInDungeon 0
)

(local
	local0
	local1
)

(instance throwInDungeon of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 821)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) dungeonEntered: 3) ; rgCastle
				(gEgo
					normal: 0
					view: 825
					setLoop: 0
					cel: 0
					posn: 100 144
					setPri: 9
					setCycle: 0
					cycleSpeed: 8
					moveSpeed: 0
					setScale:
					scaleX: 121
					scaleY: 121
					setMotion: JumpTo 150 154 self
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gGlobalSound4 number: 960 setLoop: 1 play: self)
			)
			(3
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 64)) ; rgCastle
					(gMessager say: 1 0 8 0 self) ; "You'll stay here until we find out what the vizier wants to do with you!"
				else
					(= cycles 1)
				)
			)
			(4
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 64)) ; rgCastle
					(gGlobalSound4 number: 902 loop: 1 play:)
					((ScriptID 820 3) setCycle: Beg self) ; dungeonDoor
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(5
				(gGlobalSound4 number: 822 loop: 1 play: self)
			)
			(6
				(= cycles 1)
			)
			(7
				(= local0 0)
				(cond
					(((ScriptID 80 0) tstFlag: #rFlag1 128) ; rgCastle
						(= state 9)
						(self setScript: beautyEntrance self)
					)
					(((ScriptID 80 0) tstFlag: #rFlag1 4096) ; rgCastle
						((ScriptID 80 0) clrFlag: #rFlag1 4096) ; rgCastle
						(self setScript: searchEgo self)
					)
					(((ScriptID 80 0) tstFlag: #rFlag3 32) ; rgCastle
						((ScriptID 80 0) clrFlag: #rFlag3 32) ; rgCastle
						(= local0 (gEgo has: 44)) ; skeletonKey
						((ScriptID 820 3) setPri: -1 stopUpd:) ; dungeonDoor
						(self setScript: afterClownHelpedEgoEscape self)
					)
					(
						(and
							(IsFlag 10)
							(not ((ScriptID 80 0) tstFlag: #rFlag1 16384)) ; rgCastle
						)
						((ScriptID 80 0) setFlag: #rFlag1 16384 1) ; rgCastle
						((ScriptID 80 0) setFlag: #rFlag3 32) ; rgCastle
						(self register: jolloHelpsEgo setScript: jolloHelpsEgo)
					)
					((gEgo has: 44) ; skeletonKey
						(= local0 1)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				((ScriptID 80 0) setFlag: #rFlag3 64) ; rgCastle
				(if (not register)
					(= register self)
				)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(if local0
					(= state 11)
				)
				(gEgo reset: 7 posn: 132 149)
				(if (!= register self)
					(register cycles: 1)
				else
					(= cycles 1)
				)
			)
			(10
				(= cycles 3)
			)
			(11
				(gCurRoom setScript: (ScriptID 820 1)) ; noWayOut
			)
			(12
				(gGame handsOn:)
				((ScriptID 820 3) setPri: -1 stopUpd:) ; dungeonDoor
				(gEgo reset: 1)
				(self dispose:)
			)
		)
	)
)

(instance searchEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 44 820) ; skeletonKey
				(gMessager say: 1 0 13 0 self) ; "The vizier will have our heads if he finds out that a prisoner escaped! How do you suppose he did it, Rolf?"
			)
			(1
				((ScriptID 820 3) setCycle: Beg self) ; dungeonDoor
			)
			(2
				(gGlobalSound4 number: 822 loop: 1 play:)
				((ScriptID 820 3) setPri: -1 stopUpd:) ; dungeonDoor
				(self dispose:)
			)
		)
	)
)

(instance beautyEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 1 2 self) ; "The sound of running footsteps echo outside Alexander's cell...."
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo reset: 7 posn: 132 149)
				(= cycles 4)
			)
			(3
				(gMessager say: 1 0 1 3 self oneOnly: 0) ; "What are you doin' down here, Shrew? We've already got him locked up. Go back to your post upstairs!"
			)
			(4
				(= cycles 4)
			)
			(5
				((ScriptID 820 3) setPri: -1 stopUpd:) ; dungeonDoor
				(self dispose:)
			)
		)
	)
)

(instance afterClownHelpedEgoEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 11 0 self) ; "I think someone must have let our prisoner loose, Rolf."
			)
			(1
				((ScriptID 820 3) setCycle: Beg self) ; dungeonDoor
			)
			(2
				(gGlobalSound4 number: 822 loop: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance jolloHelpsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 9 1 self) ; "Alexander wonders how he'll get out of this one!"
			)
			(1
				(client cue:)
			)
			(2
				(= seconds 5)
			)
			(3
				(gGlobalSound4 number: 821 loop: 1 play: self)
			)
			(4
				(gGlobalSound4 number: 821 loop: 1 play:)
				((ScriptID 820 3) setCycle: End self) ; dungeonDoor
			)
			(5
				(gGlobalSound4 stop:)
				(jollo
					ignoreActors:
					init:
					cel: 0
					cycleSpeed: 8
					setLoop: 0
					setCycle: End self
				)
			)
			(6
				(jollo posn: 87 148 setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gMessager say: 1 0 9 2 self) ; "Psst! Prince Alex!"
			)
			(8
				(Face gEgo jollo self)
			)
			(9
				(= cycles 5)
			)
			(10
				(gMessager say: 1 0 9 3 self oneOnly: 0) ; "Jollo! What are you doing here?"
			)
			(11
				(jollo
					posn: 100 150
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(12
				(gEgo reset: 1 setPri: 1 setMotion: DPath 93 142 34 142 self)
			)
			(13
				(jollo setCycle: 0)
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance jollo of Prop
	(properties
		x 89
		y 147
		view 822
		priority 9
		signal 16
	)
)

