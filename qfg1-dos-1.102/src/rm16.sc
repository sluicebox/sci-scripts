;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use LoadMany)
(use Chase)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm16 0
	flyingSeed 1
	rock 2
)

(local
	[local0 4]
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
)

(procedure (localproc_0)
	(HighPrint 16 0) ; "You've already made a mess of that flower."
)

(procedure (localproc_1)
	(HighPrint 16 1) ; "There's not much point in that, now that you've already done what you came here to do."
)

(procedure (localproc_2)
	(cond
		((IsFlag 192)
			(HighPrint 16 2) ; "You don't need a rock for anything."
		)
		((== global326 0)
			(gEgo setScript: (ScriptID 292 0)) ; getRock
		)
		(else
			(HighPrint 16 3) ; "Not now!"
		)
	)
)

(procedure (localproc_3)
	(if (!= ([local0 0] loop:) 3)
		([local0 0] setLoop: 2 setCycle: End)
	)
	(if (!= ([local0 1] loop:) 3)
		([local0 1] setLoop: 2 setCycle: End)
	)
	(if (!= ([local0 2] loop:) 3)
		([local0 2] setLoop: 2 setCycle: End)
	)
	(if (!= ([local0 3] loop:) 3)
		([local0 3] setLoop: 2 setCycle: End)
	)
)

(procedure (localproc_4)
	([local0 0] stopUpd:)
	([local0 1] stopUpd:)
	([local0 2] stopUpd:)
	([local0 3] stopUpd:)
)

(instance flyingSeed of Act
	(properties
		view 16
		illegalBits 0
	)
)

(instance magicLasso of Act
	(properties
		view 520
		illegalBits 0
	)
)

(instance rock of Act
	(properties
		view 510
		illegalBits 0
	)
)

(instance spitSound of Sound
	(properties
		number 18
		priority 3
	)
)

(instance gulpSound of Sound
	(properties
		number 27
		priority 3
	)
)

(instance rm16 of Rm
	(properties
		picture 16
		style 2
		east 17
		south 24
	)

	(method (dispose)
		(SetFlag 6)
		(ClearFlag 192)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 16 518 517 510)
		(if (gEgo knows: 24) ; fetchSpell
			(Load rsVIEW 520)
		)
		(LoadMany rsSCRIPT 291 292)
		(LoadMany rsSOUND (SoundFX 18) (SoundFX 27))
		(super init:)
		(gDirHandler add: self)
		(spitSound number: (SoundFX 18) init:)
		(gulpSound number: (SoundFX 27) init:)
		(SL enable:)
		(if (or gNight (IsFlag 136))
			(SetFlag 192)
		)
		(= local7 2)
		(NormalEgo)
		(gEgo init:)
		(rock
			setLoop: 4
			setStep: 70 30
			posn: 0 1000
			hide:
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(switch gPrevRoomNum
			(17
				(gEgo posn: 318 165 setMotion: MoveTo 275 165)
			)
			(else
				(gEgo posn: 170 188 setMotion: MoveTo 170 175)
			)
		)
		(if (IsFlag 139)
			(flower0 setLoop: 3 cel: 4)
		)
		(if (IsFlag 137)
			(flower1 setLoop: 3 cel: 4)
		)
		(if (IsFlag 138)
			(flower3 setLoop: 3 cel: 4)
		)
		((= [local0 0] flower0) init: stopUpd:)
		((= [local0 1] flower1) init: stopUpd:)
		((= [local0 2] flower2) init: stopUpd:)
		((= [local0 3] flower3) init: stopUpd:)
		(gAddToPics add: leaf0 leaf1 leaf2 leaf3 eachElementDo: #init doit:)
		(if (and (not (IsFlag 137)) (not (IsFlag 138)) (not (IsFlag 139)))
			(flyingSeed
				setLoop: 4
				setPri: 5
				ignoreActors:
				posn: 0 1000
				hide:
				setCycle: Fwd
				init:
				setScript: spitIt
			)
		)
	)

	(method (doit)
		(if local4
			(flyingSeed setScript: spitIt)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			($0040 ; direction
				(if (== global326 1)
					(switch (event message:)
						(JOY_LEFT
							(gEgo setScript: (ScriptID 291 2)) ; fallDown
						)
						(JOY_DOWN
							(gEgo setScript: (ScriptID 291 2)) ; fallDown
						)
						(JOY_RIGHT
							(= global326 2)
							(gEgo setScript: (ScriptID 291 3)) ; catchIt
						)
						(JOY_UP
							(= global326 2)
							(gEgo setScript: (ScriptID 291 3)) ; catchIt
						)
					)
				else
					(event claimed: 0)
				)
			)
			(evSAID
				(cond
					((Said 'look<for/boulder,brick')
						(localproc_2)
					)
					((Said 'look>')
						(cond
							((Said '/north,west')
								(HighPrint 16 4) ; "To the north and west are steep cliffs.  There are some unusual plants growing out of the side of the cliffs."
							)
							((Said '/south,east')
								(HighPrint 16 5) ; "To the south and east is the forest from which you came."
							)
							((Said '[<at,around][/!*,forest]')
								(HighPrint 16 6) ; "To the south and east is the forest from which you came. To the north and west are steep cliffs. There are some unusual plants growing out of the side of the cliffs."
								(if (not (IsFlag 192))
									(HighPrint 16 7) ; "They are spitting what seems to be some kind of seed."
								)
							)
							((Said '/cliff,boulder')
								(HighPrint 16 8) ; "The cliff walls are very steep, and they look difficult to climb."
							)
							((Said '[<down][/ground,needle,moss,grass]')
								(HighPrint 16 9) ; "The meadow clearing in which you stand is grassy and littered with blown pine needles and small mossy rocks."
							)
							((Said '[<up][/sky,cloud,star]')
								(if gNight
									(HighPrint 16 10) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
								else
									(HighPrint 16 11) ; "The sky is a piercing blue with scudding white clouds."
								)
							)
							((Said '/birch,tree')
								(HighPrint 16 12) ; "You can see pines, cedars, birches and other trees frequently associated with mountain forests."
							)
							((Said '/seed')
								(cond
									((gEgo has: 20) ; seed
										(event claimed: 0)
									)
									((IsFlag 192)
										(HighPrint 16 13) ; "You can't see it."
									)
									(else
										(HighPrint 16 14) ; "The large seed spins as it travels through the air."
									)
								)
							)
							((Said '/leaf')
								(HighPrint 16 15) ; "The leaves look tough and fibrous."
							)
						)
					)
					(
						(or
							(Said 'cut,hit,fight,kill[/plant,flower,pod]')
							(Said 'use,draw/blade')
						)
						(switch global326
							(1
								(HighPrint 16 16) ; "As you attempt to draw your weapon, you lose your balance momentarily."
								(gEgo setScript: (ScriptID 291 2)) ; fallDown
							)
							(3
								(HighPrint 16 3) ; "Not now!"
							)
							(4
								(HighPrint 16 3) ; "Not now!"
							)
							(0
								(cond
									(
										(not
											(or
												(& (gEgo onControl: 1) $1000)
												(& (gEgo onControl: 1) $4000)
												(& (gEgo onControl: 1) $2000)
											)
										)
										(NotClose)
									)
									((gEgo has: 6) ; blade
										(gEgo setScript: smashIt)
										(SetFlag 192)
									)
									(else
										(HighPrint 16 17) ; "If you had a sword, you might be able to do that."
									)
								)
							)
						)
					)
					((Said 'climb,get<down')
						(cond
							((and (> global326 1) (== global327 0))
								(HighPrint 16 18) ; "Wait a second!"
							)
							((>= global326 1)
								(gEgo setScript: (ScriptID 292 3)) ; climbDown
							)
							(else
								(HighPrint 16 19) ; "You're already on the ground."
							)
						)
					)
					((Said 'climb[<up][/cliff,boulder]')
						(cond
							((>= global326 1)
								(HighPrint 16 20) ; "You don't think you can climb any further up the cliff."
							)
							((IsFlag 136)
								(localproc_1)
							)
							((TrySkill 11 35 0) ; climbing
								(gEgo setScript: (ScriptID 291 1)) ; goodClimb
							)
							(else
								(gEgo setScript: (ScriptID 291 0)) ; badClimb
							)
						)
					)
					((Said 'capture[/seed]')
						(cond
							((IsFlag 192)
								(HighPrint 16 21) ; "There's not much point to that now."
							)
							((IsFlag 136)
								(localproc_1)
							)
							((== global326 1)
								(= global326 2)
								(gEgo setScript: (ScriptID 291 3)) ; catchIt
							)
							((or (== global326 2) (== global326 3))
								(HighPrint 16 22) ; "Why do you think you're standing like this. Trying to catch Flying Water?"
							)
							(else
								(HighPrint 16 23) ; "You can't catch the seed from down on the ground."
							)
						)
					)
					((Said '(lockpick<up),find,search>')
						(cond
							((Said '/boulder,brick')
								(localproc_2)
							)
							((Said '/seed')
								(if (IsFlag 136)
									(AlreadyDone)
								else
									(HighPrint 16 24) ; "It's not that easy."
								)
							)
						)
					)
					((Said 'throw>')
						(cond
							((Said '/boulder,brick')
								(cond
									((IsFlag 136)
										(localproc_1)
									)
									((IsFlag 192)
										(HighPrint 16 25) ; "You might have tried to throw a rock at the seed, but it's too late now."
									)
									((== global326 0)
										(if (gEgo has: 21) ; boulder
											(if (not local10)
												(HighPrint 16 26) ; "You get in position for a good throw."
											)
											(gEgo setScript: throwIt)
										else
											(HighPrint 16 27) ; "You need a good rock to throw."
										)
									)
									(else
										(HighPrint 16 3) ; "Not now!"
									)
								)
							)
							((Said '/dagger')
								(HighPrint 16 28) ; "Perhaps it would be better to find something else to throw."
							)
							((Said '/*')
								(HighPrint 16 29) ; "That's really not a good idea."
							)
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(17
								(cond
									((not (CastSpell temp0)))
									((IsFlag 136)
										(localproc_1)
									)
									((!= (gEgo script:) 0)
										(HighPrint 16 3) ; "Not now!"
									)
									((!= global326 0)
										(HighPrint 16 30) ; "You lose your concentration."
										(gEgo setScript: (ScriptID 291 2)) ; fallDown
									)
									((< [gEgoStats 17] 35) ; openSpell
										(HighPrint 16 31) ; "Your skill with the Open spell is not great enough to affect the plants."
									)
									(else
										(SetFlag 192)
										(gEgo setScript: openUp)
									)
								)
							)
							(24
								(cond
									((not (CastSpell temp0)))
									((IsFlag 136)
										(localproc_1)
									)
									((IsFlag 192)
										(HighPrint 16 32) ; "You might have tried to cast a spell at the seed, but it's too late now."
									)
									((== global326 0)
										(if (not local11)
											(HighPrint 16 33) ; "You get into a good position."
										)
										(= local9 1)
										(gEgo setScript: throwIt)
									)
									(else
										(HighPrint 16 30) ; "You lose your concentration."
										(gEgo setScript: (ScriptID 291 2)) ; fallDown
									)
								)
							)
							(23
								(if (not (IsFlag 136))
									(HighPrint 16 34) ; "That spell would damage the seed. You don't want to do that."
								else
									(HighPrint 16 35) ; "There is no need to be so destructive."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/seed')
								(cond
									((IsFlag 136)
										(AlreadyDone)
									)
									((IsFlag 192)
										(HighPrint 16 36) ; "Since the flowers have stopped spitting, the seed might be a little harder to get to."
									)
									(else
										(HighPrint 16 37) ; "You'd like to do that, wouldn't you?"
									)
								)
							)
							((Said '/plant,flower,pod,leaf')
								(HighPrint 16 38) ; "You have no need to take the flowers."
							)
							((Said '/boulder')
								(localproc_2)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance spitIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(= seconds (Random 3 5))
			)
			(1
				(if (IsFlag 192)
					(self changeState: 8)
				else
					(= global328 global327)
					(= global327 (Random 0 3))
					(if (== local14 global327)
						(while (== local14 global327)
							(if (<= (++ local15) 3)
								(= local15 0)
								(break)
							)
							(if (== global327 1)
								(= global327 2)
							else
								(= global327 1)
							)
						)
					else
						(= local15 0)
					)
					(= local14 global327)
					([local0 global328] setLoop: 1 startUpd: setCycle: End self)
					(if (and (!= global327 3) (!= global328 global327) local5)
						(throwIt cue:)
					)
				)
			)
			(2
				(flyingSeed
					show:
					yStep: 10
					posn:
						(switch global328
							(0 142)
							(1 35)
							(2 66)
							(3 228)
						)
						(switch global328
							(0 60)
							(1 85)
							(2 19)
							(3 70)
						)
				)
				(if local13
					(lassoSeed cue:)
				else
					(self cue:)
				)
			)
			(3
				(spitSound play:)
				(flyingSeed
					setMotion:
						MoveTo
						(flyingSeed x:)
						(-
							(flyingSeed y:)
							(if (and (== global328 global327) (!= global328 2))
								30
							else
								5
							)
						)
						self
				)
				([local0 global328] setCycle: Beg)
			)
			(4
				(flyingSeed
					yStep: 2
					setMotion:
						JumpTo
						(switch global327
							(0 142)
							(1 35)
							(2 66)
							(3 228)
						)
						(switch global327
							(0
								(if (== global326 3) 48 else 60)
							)
							(1 85)
							(2 19)
							(3 70)
						)
						self
				)
			)
			(5
				(if (and (== global326 3) (== global327 0))
					(gEgo setScript: (ScriptID 292 2)) ; heCaughtIt
				else
					(self cue:)
				)
			)
			(6
				([local0 global327] setLoop: 2 setCycle: End)
				(flyingSeed
					yStep: 6
					setMotion:
						MoveTo
						(flyingSeed x:)
						(+ (flyingSeed y:) 17)
						self
				)
			)
			(7
				(gulpSound play:)
				(flyingSeed hide:)
				([local0 global327] setCycle: Beg self)
			)
			(8
				([local0 global327] stopUpd:)
				([local0 global328] stopUpd:)
				(flyingSeed setScript: 0)
				(if (or (not (IsFlag 192)) (not local6))
					(= local4 1)
				)
			)
		)
	)
)

(instance smashIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SolvePuzzle 603 -10)
				(cond
					((& (gEgo onControl: 1) $1000)
						(if (IsFlag 137)
							(localproc_0)
						else
							(HandsOff)
							(= local7 1)
							(gEgo
								illegalBits: 0
								setMotion: MoveTo 57 132 self
							)
						)
					)
					((& (gEgo onControl: 1) $4000)
						(if (IsFlag 138)
							(localproc_0)
						else
							(HandsOff)
							(= local7 3)
							(gEgo
								illegalBits: 0
								setMotion: MoveTo 226 140 self
							)
						)
					)
					((& (gEgo onControl: 1) $2000)
						(if (IsFlag 139)
							(localproc_0)
						else
							(HandsOff)
							(= local7 0)
							(gEgo
								illegalBits: 0
								setMotion: MoveTo 137 132 self
							)
						)
					)
				)
			)
			(1
				(gEgo view: 518 setLoop: (if (== local7 1) 2 else 0) cel: 0)
				([local0 1] setPri: (if (== local7 1) 15 else -1))
				(self cue:)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(++ local8)
				(gEgo
					setLoop: (if (== local7 1) 3 else 1)
					setCycle: End self
				)
			)
			(4
				(if (== local8 2)
					(switch local7
						(0
							([local0 0]
								setLoop: 3
								cel: 0
								cycleSpeed: 1
								setCycle: End
							)
							(SetFlag 139)
						)
						(1
							([local0 1]
								setLoop: 3
								cel: 0
								cycleSpeed: 1
								setCycle: End
							)
							(SetFlag 137)
						)
						(3
							([local0 3]
								setLoop: 3
								cel: 0
								cycleSpeed: 1
								setCycle: End
							)
							(SetFlag 138)
						)
					)
					(if (== local7 global327)
						(flyingSeed show:)
					)
				)
				(if (> local8 3)
					(= local8 0)
					(= cycles 4)
				else
					(self changeState: 3)
				)
			)
			(5
				(gEgo setLoop: (if (== local7 1) 2 else 0) cel: 3)
				(= cycles 2)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					loop: (if (== local7 1) 1 else 3)
					posn:
						(if (!= local7 1)
							(+ (gEgo x:) 10)
						else
							(gEgo x:)
						)
						(gEgo y:)
				)
				(NormalEgo)
				(if
					(and
						(== local7 global327)
						(not local12)
						(not (IsFlag 136))
					)
					(= cycles 3)
				else
					(HandsOn)
					(gEgo setScript: 0)
				)
				(= local7 2)
			)
			(8
				(HighPrint 16 39) ; "You see the seed floating above the shattered remains of the plant."
				(if (== ([local0 1] priority:) 15)
					([local0 1] setPri: 1)
				)
				(= cycles 2)
			)
			(9
				(flyingSeed
					setMotion:
						MoveTo
						(flyingSeed x:)
						(+ (flyingSeed y:) 15)
						self
				)
			)
			(10
				(flyingSeed dispose:)
				(= cycles 2)
			)
			(11
				(HighPrint 16 40) ; "You take the seed."
				(SolvePuzzle 651 8)
				(gEgo get: 20 setScript: 0) ; seed
				(SetFlag 136)
				(HandsOn)
			)
		)
	)
)

(instance throwIt of Script
	(properties)

	(method (dispose)
		(= local9 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (Random 242 258) (Random 160 175) self
				)
			)
			(1
				(gEgo
					view: (if local9 520 else 510)
					cycleSpeed: 1
					setLoop: (if local9 0 else 2)
					cel: 0
				)
				(= local5 1)
			)
			(2
				(= local5 0)
				(if local9
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
			)
			(3
				(if local9
					(magicLasso
						ignoreActors:
						posn: (+ (gEgo x:) 2) (- (gEgo y:) 36)
						setLoop: 4
						setStep: 20 10
						setCycle: Fwd
						init:
					)
					(if (TrySkill 24 0 20) ; fetchSpell
						(magicLasso setScript: lassoSeed)
					else
						(magicLasso setScript: lassoFailed)
					)
					(gEgo setScript: 0)
					(= local11 1)
				else
					(rock posn: (- (gEgo x:) 13) (- (gEgo y:) 34) show:)
					(gEgo setCycle: End self)
					(= local10 1)
					(if (TrySkill 10 0 -10) ; throwing
						(rock setScript: rockHitsIt)
					else
						(rock setScript: (ScriptID 292 1)) ; youMissed
					)
				)
			)
			(4
				(gEgo use: 21 1 loop: 1 setScript: 0) ; boulder
				(NormalEgo)
			)
		)
	)
)

(instance rockHitsIt of Script
	(properties)

	(method (doit)
		(if (and (not local12) (== (flyingSeed y:) 150) (== (rock y:) 160))
			(= local12 1)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rock setMotion: Chase flyingSeed 5 self)
			)
			(1
				(SetFlag 192)
				(= local4 0)
				(flyingSeed setScript: 0 setMotion: 0)
				(rock
					setMotion: MoveTo (+ (flyingSeed x:) 3) (flyingSeed y:) self
				)
				(if (!= ([local0 global327] cel:) 0)
					([local0 global327] setCycle: Beg)
				)
			)
			(2
				(rock setMotion: JumpTo 150 160 self)
				(flyingSeed
					show:
					setStep: 3 15
					setMotion: MoveTo (flyingSeed x:) 150
				)
			)
			(3
				(= global327 2)
				(= global328 2)
				(flyingSeed setMotion: 0 setCycle: 0 ignoreActors: 0)
				(rock hide:)
				(= cycles 2)
			)
			(4
				(localproc_3)
				(= cycles 10)
			)
			(5
				(localproc_4)
				(rock hide:)
				(= cycles 1)
			)
			(6
				(flyingSeed setCycle: 0 stopUpd:)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(if (< (flyingSeed x:) (gEgo x:))
							(+ (flyingSeed x:) 16)
						else
							(- (flyingSeed x:) 16)
						)
						149
						self
				)
			)
			(7
				(gEgo
					view: 510
					setLoop: (if (< (flyingSeed x:) (gEgo x:)) 1 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(8
				(HighPrint 16 40) ; "You take the seed."
				(flyingSeed dispose:)
				(gEgo setCycle: Beg self)
			)
			(9
				(NormalEgo)
				(SolvePuzzle 651 8)
				(gEgo get: 20 setScript: 0) ; seed
				(SetFlag 136)
				(HandsOn)
				(rock dispose:)
			)
		)
	)
)

(instance lassoFailed of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 192)
				(= temp0 (/ (- ([local0 global327] x:) (magicLasso x:)) 2))
				(= temp1
					(/ (- (- ([local0 global327] y:) (magicLasso y:)) 30) 2)
				)
				(magicLasso
					setMotion:
						MoveTo
						(+ (magicLasso x:) temp0)
						(+ (magicLasso y:) temp1)
						self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(magicLasso dispose:)
				(ClearFlag 192)
				(= local4 1)
				(NormalEgo)
				(HandsOn)
				(HighPrint 16 41) ; "You lose concentration, and the spell fades. You will have to practice some more."
				(self dispose:)
			)
		)
	)
)

(instance lassoSeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 192)
				(magicLasso
					setMotion:
						MoveTo
						([local0 global327] x:)
						(- ([local0 global327] y:) 30)
						self
				)
			)
			(1
				(ClearFlag 192)
				(= local4 1)
				(= local13 1)
			)
			(2
				(flyingSeed
					setScript: 0
					setStep: 1 1
					setMotion: MoveTo (flyingSeed x:) (- (magicLasso y:) 2) self
				)
				(spitSound play:)
				([local0 global328] setCycle: Beg)
			)
			(3
				(magicLasso
					setPri: 7
					setStep: 6 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 2)
						(- (gEgo y:) 36)
						self
				)
				(flyingSeed
					setPri: 7
					setStep: 6 4
					setMotion: MoveTo (+ (gEgo x:) 2) (- (gEgo y:) 38)
				)
			)
			(4
				(= seconds 3)
			)
			(5
				(magicLasso hide:)
				(flyingSeed dispose:)
				(= global327 2)
				(= global328 2)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(HighPrint 16 42) ; "You place the seed into your pack."
				(SetFlag 136)
				(SolvePuzzle 651 8)
				(gEgo get: 20 loop: 1) ; seed
				(NormalEgo)
				(HandsOn)
				(= cycles 2)
			)
			(7
				(localproc_3)
				(= cycles 10)
			)
			(8
				(localproc_4)
				(magicLasso dispose:)
			)
		)
	)
)

(instance openUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 145 self)
			)
			(1
				(gEgo view: 521 setLoop: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 25)
			)
			(2
				(localproc_3)
				(flyingSeed
					setPri: (+ ([local0 global327] priority:) 1)
					posn: ([local0 global327] x:) (- ([local0 global327] y:) 15)
					show:
				)
				(= cycles 10)
			)
			(3
				(localproc_4)
				(flyingSeed setMotion: MoveTo (flyingSeed x:) 145 self)
			)
			(4
				(flyingSeed setCycle: 0 stopUpd:)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(if (< (flyingSeed x:) (gEgo x:))
							(+ (flyingSeed x:) 16)
						else
							(- (flyingSeed x:) 16)
						)
						144
						self
				)
			)
			(5
				(gEgo
					view: 510
					setLoop: (if (< (flyingSeed x:) (gEgo x:)) 1 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(6
				(HighPrint 16 40) ; "You take the seed."
				(flyingSeed dispose:)
				(gEgo setCycle: Beg self)
			)
			(7
				(NormalEgo)
				(SolvePuzzle 651 8)
				(gEgo get: 20 setScript: 0) ; seed
				(SetFlag 136)
				(HandsOn)
			)
		)
	)
)

(instance leaf0 of PV
	(properties
		y 93
		x 142
		view 16
	)
)

(instance leaf1 of PV
	(properties
		y 118
		x 35
		view 16
	)
)

(instance leaf2 of PV
	(properties
		y 58
		x 67
		view 16
		cel 1
	)
)

(instance leaf3 of PV
	(properties
		y 103
		x 230
		view 16
	)
)

(instance flower0 of Prop
	(properties
		y 89
		x 142
		view 16
		loop 1
		cycleSpeed 1
	)
)

(instance flower1 of Prop
	(properties
		y 114
		x 35
		view 16
		loop 1
		cycleSpeed 1
	)
)

(instance flower2 of Prop
	(properties
		y 48
		x 66
		view 16
		loop 1
		cycleSpeed 1
	)
)

(instance flower3 of Prop
	(properties
		y 99
		x 228
		view 16
		loop 1
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(MouseClaimed flower0 event 3)
				(MouseClaimed flower1 event 3)
				(MouseClaimed flower2 event 3)
				(MouseClaimed flower3 event 3)
				(Said 'look/flower,plant,pod')
			)
			(event claimed: 1)
			(HighPrint 16 43) ; "You've never seen anything quite like them. They're pretty, in a grotesque way."
			(if (or (IsFlag 137) (IsFlag 138) (IsFlag 139))
				(HighPrint 16 44) ; "At least, they're pretty when they're not dead."
			)
		)
	)
)

