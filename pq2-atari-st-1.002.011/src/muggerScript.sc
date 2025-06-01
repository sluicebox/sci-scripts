;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Avoid)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	muggerScript 0
)

(local
	local0
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
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(procedure (localproc_1 param1 param2)
	(DirLoop param1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(if (== argc 3)
		(DirLoop
			param2
			(GetAngle (param2 x:) (param2 y:) (param1 x:) (param1 y:))
		)
	)
)

(instance mugMusic of Sound
	(properties
		number 26
	)
)

(instance muggerScript of Script
	(properties)

	(method (doit)
		(if (and (or global204 local4 local5) local8 (not local6))
			(= local6 1)
			(= local12 1)
			(muggerScript changeState: 9)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 77)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/man,mugger,punk,suspect,hair')
								(localproc_0 77 0) ; "He sure is UGLY!"
							)
							((Said '/friend')
								(localproc_0 77 1) ; "Good old Keith!"
							)
							((Said '/*')
								(localproc_0 77 2) ; "You keep your eyes on the unusual-looking individual."
							)
						)
					)
					((Said 'talk/friend')
						(if local0
							(localproc_0 77 3) ; "Good going, partner!"
						else
							(localproc_0 77 4) ; "He's not here."
						)
					)
					((Said 'freeze')
						(if (gCast contains: local2)
							(if (<= (local2 distanceTo: gEgo) 50)
								(= local4 1)
								(localproc_0 77 5) ; "Acting fast, you whip out your badge and identify yourself."
							else
								(localproc_0 77 6) ; "The man just runs at you."
							)
						else
							(localproc_0 77 7) ; "Your voice is lost in the vastness of the park."
						)
					)
					((Said 'show/badge,badge')
						(if
							(and
								(gCast contains: local2)
								(<= (local2 distanceTo: gEgo) 50)
							)
							(= local4 1)
							(localproc_0 77 5) ; "Acting fast, you whip out your badge and identify yourself."
						else
							(localproc_0 77 8) ; "Nobody can see your badge right now."
						)
					)
					(
						(or
							(Said 'call,extender/backup,friend')
							(Said '(key<up),use/(extender,talkie)')
						)
						(if (gEgo has: 30) ; walkie_talkie
							(cond
								(local0
									(localproc_0 77 9) ; "Who're you calling? Keith's here."
								)
								((and local3 (not local6))
									(if (not local5)
										(SetScore 5)
										(gContinuousMusic stop:)
									)
									(= local5 1)
									(localproc_0 77 10) ; "You key up your walkie-talkie and radio for help from Keith."
									(localproc_0 77 11) ; "The man sees you using the walkie-talkie. It scares him, so he runs off."
								)
								((and local3 local6 (not global237))
									(if (not local5)
										(SetScore 5)
										(gContinuousMusic stop:)
									)
									(= local5 1)
									(localproc_0 77 10) ; "You key up your walkie-talkie and radio for help from Keith."
								)
								(local1
									(localproc_0 77 12) ; "The mugger's gone, Sonny. What's your story?"
								)
								(global237
									(switch (Random 1 4)
										(1
											(localproc_0 77 13) ; "You key the walkie-talkie trying to raise Keith....you pause to listen, and then you hear..."
											(localproc_0 77 14) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
											(localproc_0 77 15) ; "A lot of noise and no answer...you can't seem to get him."
										)
										(2
											(localproc_0 77 16) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
										)
										(3
											(localproc_0 77 17) ; "You listen but he doesn't answer."
										)
										(4
											(localproc_0 77 18) ; "After trying to raise Keith and getting a lot of static, you think to yourself.... "WHEW! This is one sorry radio.""
										)
									)
								)
								((not global237)
									(localproc_0 77 19) ; "Calling for backup, already? What're you scared of, the flowers?"
								)
							)
						else
							(localproc_0 77 20) ; "You don't have a radio."
						)
					)
					((Said 'extender/dispatch')
						(localproc_0 77 21) ; "You only have walkie-talkies designed for local use."
					)
					((Said 'arrest,book,arrest/man,mugger,punk,suspect')
						(if local0
							(localproc_0 77 22) ; "Looks like he's in the bag already."
						else
							(localproc_0 77 23) ; "You have to stop him first."
						)
					)
					((Said 'read,give/right,miranda')
						(if local0
							(if (not local16)
								(SetScore 2)
								(= local16 1)
							)
							(localproc_0 77 24) ; "Keith's already done that."
						else
							(localproc_0 77 25) ; "There's nobody there."
						)
					)
					((Said 'give/cash')
						(cond
							((or (not local3) (not global237))
								(localproc_0 77 25) ; "There's nobody there."
							)
							((and local3 (not local6))
								(localproc_0 77 26) ; "Your a policeman! You shouldn't give in to criminals."
							)
							(else
								(localproc_0 77 27) ; "You don't need to."
							)
						)
					)
					((Said 'interrogate,talk/man,mugger,punk,suspect')
						(cond
							((not local3)
								(localproc_0 77 25) ; "There's nobody there."
							)
							(local1
								(localproc_0 77 28) ; "He's off to jail, now. Besides, he wasn't a brilliant conversationalist the first time, anyway."
							)
							((and local0 (not local7))
								(if (not local17)
									(= local17 1)
									(SetScore 2)
								)
								(localproc_0 77 29) ; "The mugger looks at you and says..."Listen, Pig, I ain't talking to nobody! You understand that?""
								(= local7 1)
							)
							((and local0 local7)
								(localproc_0 77 30) ; ""Talk's cheap, man!" the mugger says."
							)
							((and local3 (not local0))
								(localproc_0 77 31) ; "It doesn't look like talking is this guy's specialty."
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global212 3)
				(= local8 1)
				(if (!= (gContinuousMusic state:) 3)
					(gContinuousMusic number: 40 loop: 1 play:)
				)
				((= local2 (Act new:))
					view: 52
					posn:
						(switch gCurRoomNum
							(79 142)
							(80 319)
							(81 0)
							(82 259)
						)
						(switch gCurRoomNum
							(79 219)
							(80 133)
							(81 185)
							(82 125)
						)
					init:
					setCycle: Walk
					setMotion: Chase gEgo 18 self
					setAvoider: (Avoid new:)
					setStep: 6 4
				)
				(if global236
					(switch gCurRoomNum
						(80
							(= local13 (+ (gEgo x:) 35))
							(= local14 (gEgo y:))
						)
						(81
							(= local13 (- (gEgo x:) 35))
							(= local14 (gEgo y:))
						)
						(82
							(= local14 (+ (gEgo y:) 35))
							(= local13 (gEgo x:))
						)
						(79
							(switch gPrevRoomNum
								(80
									(= local13 (- (gEgo x:) 35))
									(= local14 (gEgo y:))
								)
								(81
									(= local13 (+ (gEgo x:) 35))
									(= local14 (gEgo y:))
								)
								(else
									(= local13 40)
									(= local14 125)
								)
							)
						)
					)
					(local2 posn: local13 local14)
				)
				(if (not global236)
					(localproc_0 77 32) ; "You notice that a man is approaching you."
					(gEgo setMotion: 0)
					(localproc_1 gEgo local2)
					(= global236 1)
				)
				(= local3 1)
			)
			(1
				(= local9 1)
				(local2 view: 32)
				(self cue:)
			)
			(2
				(if (not (IsFlag 140))
					(localproc_0 77 33 83) ; "Threatening you, the man says..."Give me all your money, dude, or I'll rip you apart with my bare hands.""
					(SetFlag 140)
				)
				(gEgo setMotion: 0)
				(localproc_1 gEgo local2)
				(User canControl: 0)
				(= cycles 70)
			)
			(3
				(HandsOff)
				(localproc_0 77 34 25 4) ; ""Let's have some fun, pal!" the mugger says."
				(self cue:)
			)
			(4
				(gEgo dispose:)
				(local2 hide:)
				(gContinuousMusic fade:)
				((= local10 (Prop new:))
					view: 88
					loop: (if (< (gEgo x:) (local2 x:)) 0 else 1)
					init:
					posn: (gEgo x:) (gEgo y:)
					setCycle: End self
				)
			)
			(5
				(local10 loop: 2 setCycle: Fwd)
				(mugMusic play: self)
			)
			(6
				((View new:)
					view: 88
					loop: 3
					cel: 0
					posn: (+ (local10 x:) 20) (local10 y:)
					init:
				)
				(local2 show:)
				(local10 dispose:)
				(= cycles 20)
			)
			(7
				(localproc_0 77 35 83) ; "The mugger seems to have had a little extra adrenaline pumping. He has managed to slap you into a deep coma."
				(self cue:)
			)
			(8
				(EgoDead 77 36) ; "Next time, try to react a little faster. Use your equipment."
			)
			(9
				(User canControl: 1)
				(local2
					view: 52
					setStep: 6 4
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 142)
							(80 319)
							(81 0)
							(82
								(if (> (gEgo y:) 142) 121 else 259)
							)
						)
						(switch gCurRoomNum
							(79 219)
							(80 133)
							(81 167)
							(82
								(if (> (gEgo y:) 142) 215 else 125)
							)
						)
						self
				)
			)
			(10
				(if local5
					(local2 hide:)
					(HandsOff)
					(User canInput: 1)
				else
					(= global237 1)
					(local2 dispose:)
				)
				(= cycles 2)
			)
			(11
				(localproc_0 77 37 83) ; "Evidently, the mugger doesn't like cops."
				(if local5
					(= cycles 10)
				else
					(= local12 0)
					(= global212 1)
					(= global236 0)
					(gContinuousMusic fade:)
					(client setScript: 0)
				)
			)
			(12
				(localproc_0 77 38 83 25 10) ; "You hear heavy breathing, hacking, and coughing as Keith escorts the would-be mugger back to you."
				(self cue:)
			)
			(13
				(gEgo
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 107)
							(80 217)
							(81 154)
							(82
								(if (> (gEgo y:) 150) 199 else 170)
							)
						)
						(switch gCurRoomNum
							(79 154)
							(80 151)
							(81 173)
							(82
								(if (> (gEgo y:) 150) 173 else 127)
							)
						)
						self
				)
			)
			(14
				(localproc_1 gEgo local2)
				(local2
					posn:
						(switch gCurRoomNum
							(79 82)
							(80 324)
							(81 -9)
							(82
								(if (> (gEgo y:) 150) 86 else 261)
							)
						)
						(switch gCurRoomNum
							(79 234)
							(80 149)
							(81 170)
							(82
								(if (> (gEgo y:) 150) 232 else 130)
							)
						)
					view: 46
					setStep: 3 2
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 97)
							(80 240)
							(81 126)
							(82
								(if (> (gEgo y:) 150) 172 else 189)
							)
						)
						(switch gCurRoomNum
							(79 164)
							(80 149)
							(81 170)
							(82
								(if (> (gEgo y:) 150) 169 else 130)
							)
						)
					show:
				)
				(= local0 1)
				(= cycles 10)
			)
			(15
				((= global112 (Act new:))
					view: 20
					illegalBits: 0
					posn:
						(switch gCurRoomNum
							(79 90)
							(80 324)
							(81 -9)
							(82
								(if (> (gEgo y:) 150) 83 else 261)
							)
						)
						(switch gCurRoomNum
							(79 238)
							(80 157)
							(81 178)
							(82
								(if (> (gEgo y:) 150) 233 else 124)
							)
						)
					init:
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 112)
							(80 247)
							(81 136)
							(82
								(if (> (gEgo y:) 150) 182 else 200)
							)
						)
						(switch gCurRoomNum
							(79 172)
							(80 157)
							(81 178)
							(82
								(if (> (gEgo y:) 150) 175 else 124)
							)
						)
					ignoreActors:
					startUpd:
				)
				(= cycles 30)
			)
			(16
				(User canInput: 1)
				(localproc_0 77 39 83) ; "Breathing heavily, Keith says..."Sonny, I'm getting too old for this kind of stuff.""
				(= cycles 100)
			)
			(17
				(if (not local7)
					(localproc_0 77 40 25 8) ; "Well," Keith says, "if you won't talk to him, I will!"
					(localproc_0 77 41) ; "The mugger says..."Listen, Pig, I ain't talking to nobody! You understand that?""
					(localproc_0 77 42 25 8) ; "Keith pipes up and says..."I'll take our little mugger friend and turn him over to Steelton PD.""
					(self cue:)
				else
					(localproc_0 77 42 25 10) ; "Keith pipes up and says..."I'll take our little mugger friend and turn him over to Steelton PD.""
					(self cue:)
				)
			)
			(18
				(global112
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 85)
							(80 324)
							(81 -9)
							(82
								(if (> (gEgo y:) 150) 83 else 261)
							)
						)
						(switch gCurRoomNum
							(79 234)
							(80 157)
							(81 178)
							(82
								(if (> (gEgo y:) 150) 233 else 124)
							)
						)
						self
				)
				(local2
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(79 78)
							(80 324)
							(81 -9)
							(82
								(if (> (gEgo y:) 150) 86 else 261)
							)
						)
						(switch gCurRoomNum
							(79 234)
							(80 149)
							(81 170)
							(82
								(if (> (gEgo y:) 150) 232 else 130)
							)
						)
				)
			)
			(19
				(= local0 0)
				(gEgo illegalBits: $8000)
				(global112 dispose:)
				(local2 dispose:)
				(= global212 1)
				(client setScript: 0)
				(= global236 0)
				(= global237 1)
				(= global238 1)
				(gContinuousMusic fade:)
				(HandsOn)
				(= local1 1)
			)
		)
	)
)

