;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n104)
(use n106)
(use TargActor)
(use Chase)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	Encounter 0
	smallMonster 1
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
	[local14 12] = [500 40 40 40 40 50 30 35 40 50 30 40]
	[local26 12] = [10000 133 186 53 86 113 60 140 93 186 60 100]
	[local38 12] = ['/aardvark' '/bear' '/bull,bull' '/saurus' '/mantray' '/cheetaur' '/goblin' '/troll' '/ogre,giant' '/dragon,(rex[<saurus])' '/bandit,man' '/leader,woman']
	local50
	local51
	local52
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (<= 420 param1 470)
		(return (+ 1 (/ (- param1 420) 5)))
	else
		(return 0)
	)
)

(procedure (localproc_1)
	(cond
		((> global105 310)
			(= local3 2)
		)
		((< global105 10)
			(= local3 4)
		)
		((< global106 100)
			(= local3 1)
		)
		((> global106 180)
			(= local3 3)
		)
	)
)

(procedure (localproc_2 param1)
	(ClearFlag 351)
	(EgoGait 0 0) ; walking
	(= local9 1)
	(= local10 1)
	(if (or (not local6) (not (gCast contains: local6)))
		((= local6 smallMonster) init:)
	)
	(= local7 (+ global332 1))
	(SkillUsed 4 (/ [local26 (localproc_0 global332)] 12)) ; luck
	(HandsOn)
	(NormalEgo)
	(if param1
		(gEgo posn: 160 160)
		(local6 posn: 115 150)
	)
	(gEgo loop: 1 illegalBits: (gCurRoom illBits:) init:)
	(local6
		view: local7
		setLoop: 0
		cel: 0
		ignoreActors: 0
		setMotion: 0
		cycleSpeed: 1
	)
	(if (!= global332 445)
		(local6 setCycle: End)
	)
)

(procedure (localproc_3 param1)
	(param1
		illegalBits: 0
		setMotion: Chase gEgo [local14 (localproc_0 global332)] Encounter
	)
	(= local50 1)
	(param1 setScript: 0)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(if (and argc param1)
		(= temp1 param1)
	else
		(cond
			((< [gEgoStats 13] 1000) ; experience
				(= temp0 (Random 0 3))
			)
			((< [gEgoStats 13] 2000) ; experience
				(= temp0 (Random 0 6))
			)
			(else
				(= temp0 (Random 2 6))
			)
		)
		(if gNight
			(+= temp0 2)
		)
		(= temp1
			(switch temp0
				(0 445)
				(1 430)
				(2 445)
				(3 465)
				(4 435)
				(5 440)
				(6 460)
				(else 450)
			)
		)
	)
	(if (OneOf gCurRoomNum 85 86 92)
		(if (or (<= temp0 4) (not gNight))
			(= temp1 465)
		else
			(= temp1 450)
		)
	)
	(= global284 0)
	(cond
		((== temp1 445)
			(= global284 (Random 1 10))
		)
		((== temp1 465)
			(= global284 (Random 5 25))
		)
		((== temp1 450)
			(= global284 (Random 20 50))
		)
		((== temp1 425)
			(= global284 50)
		)
	)
	(return temp1)
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 (& (gCurRoom entrances:) $000a))
	(= temp4 (& (gCurRoom entrances:) $0008))
	(= temp3 (& (gCurRoom entrances:) $0002))
	(param2 view: param1)
	(if (!= param1 435)
		(param2 xStep: 6 yStep: 4 cel: 0)
		(switch param1
			(430
				(param2 xStep: 5 yStep: 3 setCycle: Fwd)
			)
			(450
				(param2 xStep: 5 yStep: 3 setCycle: Walk)
			)
			(440
				(param2 xStep: 6 yStep: 3 setCycle: Fwd)
			)
			(445
				(param2 xStep: 4 yStep: 2 setCycle: Walk)
			)
			(465
				(param2 xStep: 3 yStep: 2 setCycle: Walk)
			)
			(460
				(param2 xStep: 8 yStep: 5 setCycle: Fwd)
			)
		)
		(if global201
			(param2 xStep: (* (param2 xStep:) 2) yStep: (* (param2 yStep:) 2))
		)
	)
	(cond
		(local4
			(if (== param1 435)
				(local6
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local50 1)
			(switch local3
				(1
					(gEgo setMotion: MoveTo global105 (- global106 2))
					(local6
						posn:
							(+ (gEgo x:) (Random 20 40))
							(+
								(gEgo y:)
								[local14 (localproc_0 param1)]
								(Random 20 30)
							)
						setCel: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
				(3
					(gEgo setMotion: MoveTo global105 (+ global106 2))
					(local6
						posn:
							(- (gEgo x:) (Random 30 50))
							(-
								(gEgo y:)
								(+
									[local14 (localproc_0 param1)]
									(Random 20 30)
								)
							)
						setCel: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
				(2
					(gEgo setMotion: MoveTo 320 global106)
					(local6
						posn:
							(-
								(gEgo x:)
								(+
									[local14 (localproc_0 param1)]
									(Random 25 40)
								)
							)
							(gEgo y:)
						setCel: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
				(4
					(gEgo setMotion: MoveTo 0 global106)
					(local6
						posn:
							(+
								(gEgo x:)
								[local14 (localproc_0 param1)]
								(Random 25 40)
							)
							(gEgo y:)
						setCel: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
			)
			(User canControl: 1)
		)
		(local5
			(if (== param1 435)
				(local6
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local50 1)
			(switch local3
				(1
					(= local50 0)
					(gEgo setMotion: MoveTo global105 190)
					(if
						(or
							(== param1 445)
							(== param1 435)
							(== param1 450)
							(== param1 465)
						)
						(local6 setScript: northDelay)
					else
						(= param1 (= global333 0))
						(local6 dispose:)
					)
				)
				(3
					(gEgo setMotion: MoveTo global105 0)
					(if
						(or
							(== param1 445)
							(== param1 435)
							(== param1 450)
							(== param1 465)
						)
						(local6
							posn:
								global105
								(if (== param1 435)
									235
								else
									(- global106 global118)
								)
							setCel: -1
							setLoop: -1
							setMotion:
								Chase
								gEgo
								[local14 (localproc_0 param1)]
								Encounter
						)
					else
						(= global332 (= global333 0))
						(local6 dispose:)
						(= local50 0)
					)
				)
				(2
					(gEgo setMotion: MoveTo 0 global106)
					(local6
						posn: (- global105 global117) (+ global106 global118)
						loop: 1
						setCel: -1
						setLoop: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
				(4
					(gEgo setMotion: MoveTo 320 global106)
					(local6
						posn: (- global105 global117) (+ global106 global118)
						loop: 0
						setCel: -1
						setLoop: -1
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 param1)]
							Encounter
					)
				)
			)
		)
		((== param1 435)
			(local6 setScript: (ScriptID 436 2)) ; startup
		)
		((== temp2 10)
			(switch (= temp2 (if (< (Random 0 1000) 500) 8 else 2))
				(2
					(param2 setScript: inEast)
				)
				(8
					(param2 setScript: inWest)
				)
			)
		)
		(temp3
			(param2 setScript: inEast)
		)
		(temp4
			(param2 setScript: inWest)
		)
		(else
			(= temp0 (gCurRoom ambushX:))
			(= temp1 (gCurRoom ambushY:))
			(param2
				posn: temp0 temp1
				setMotion:
					Chase
					gEgo
					[local14 (localproc_0 param1)]
					Encounter
			)
		)
	)
)

(procedure (localproc_6 &tmp [temp0 60])
	(switch global284
		(0
			(HighPrint 210 36) ; "What a waste! No treasure!"
		)
		(1
			(HighPrint 210 37) ; "You find a single silver coin, carefully polish it, and place it in your pouch. What a way to make a living!"
			(gEgo get: 1 1) ; silver
		)
		(else
			(HighPrint (Format @temp0 210 38 global284)) ; "You find %d silver coins, and carefully place them in your pouch."
			(gEgo get: 1 global284) ; silver
		)
	)
	(if (== global332 450)
		(HighPrint 210 39) ; "You thought that the Troll concealed some of its treasure in that thick beard, but you didn't find any there."
	)
	(= global284 0)
	(if (and (== gCurRoomNum global273) (or global271 global272 [gInvDropped 7])) ; dagger
		(gEgo get: 7 (+ global271 global272 [gInvDropped 7])) ; dagger, dagger
		(HighPrint 210 40) ; "You retrieve your daggers."
	)
	(= [gInvDropped 7] (= global272 (= global271 (= global273 0)))) ; dagger
)

(class EncRoom of Rm
	(properties
		encChance 0
		entrances 15
		ambushX 160
		ambushY 100
		illBits -32768
	)
)

(instance smallMonster of TargActor
	(properties
		signal 24576
		illegalBits 0
		targDeltaY -20
	)

	(method (getHurt param1)
		(= local51 1)
		(= local52 0)
		(-= global333 param1)
	)
)

(instance Encounter of Rgn
	(properties)

	(method (init &tmp temp0)
		(Load rsSCRIPT 972)
		(super init: &rest)
		(= local5 (= local4 (= local51 0)))
		(= local6 0)
		(localproc_1)
		(cond
			(
				(not
					(OneOf
						gPrevRoomNum
						420 ; bearArena
						425 ; minotaurArena
						430 ; saurusArena
						435 ; mantrayArena
						440 ; cheetaurArena
						445 ; goblinArena
						455 ; ogreArena
						450 ; trollArena
						460 ; dragonArena
						465 ; brigandArena
						470
					)
				)
				(if global332
					(if (and (== global332 450) (not gNight))
						(gEgo illegalBits: (gCurRoom illBits:) init:)
						(EgoGait 1 0) ; running
						(= global332 (= global333 0))
						(HighPrint 210 0) ; "As the sun begins to rise, the Troll runs off to some dark hole."
					else
						(= local5 1)
						(gEgo illegalBits: (gCurRoom illBits:) init:)
						(= local8 (= local9 0))
						(localproc_4 global332)
					)
				else
					(= temp0 (gCurRoom encChance:))
					(if gNight
						(*= temp0 2)
					)
					(if (IsFlag 87)
						(*= temp0 2)
					)
					(cond
						((> (Random100) temp0))
						(
							(and
								(== gEgoGait 2) ; sneaking
								(TrySkill 8 temp0) ; stealth
								(TrySkill 4 0 0) ; luck
							)
							(HighPrint 210 1) ; "A monster just wandered by. You hid in the bushes until it passed."
						)
						(else
							(= global332 (localproc_4 0))
							(= global333 [local26 (localproc_0 global332)])
							(= local8 (= local9 0))
						)
					)
					(gEgo illegalBits: (gCurRoom illBits:))
				)
			)
			((<= global333 0)
				(localproc_2 1)
			)
			(else
				(= local8 (= local9 0))
				(EgoGait 1 0) ; running
				(= local4 1)
				(NormalEgo)
				(gEgo illegalBits: (gCurRoom illBits:) posn: 160 140 init:)
				(localproc_4 global332)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(HandsOff)
		(if local8
			(= global117 (- (gEgo x:) (local6 x:)))
			(= global118 (- (gEgo y:) (local6 y:)))
		)
		(if
			(or
				local9
				(> global117 180)
				(> global118 80)
				(and
					(not
						(OneOf
							newRoomNumber
							420 ; bearArena
							425 ; minotaurArena
							430 ; saurusArena
							435 ; mantrayArena
							440 ; cheetaurArena
							445 ; goblinArena
							455 ; ogreArena
							450 ; trollArena
							460 ; dragonArena
							465 ; brigandArena
							470
						)
					)
					(not
						(OneOf
							newRoomNumber
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							56
							57
							61
							62
							69
							71
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
				)
			)
			(= global332 (= global333 0))
			(= global264 0)
		)
		(ClearFlag 351)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(cond
			(
				(and
					(not local8)
					(not local9)
					global332
					(or local5 (== (gEgo onControl: 1) 2048))
				)
				(= local8 1)
				((= local6 smallMonster) posn: 0 1000 init:)
				(localproc_5 global332 local6)
			)
			((and (== global332 435) (IsFlag 351))
				(localproc_2 0)
			)
			(
				(and
					local8
					global332
					(not local10)
					(<= global333 0)
					(not (IsFlag 351))
				)
				(localproc_2 0)
			)
		)
		(super doit: &rest)
	)

	(method (cue &tmp temp0)
		(= temp0 1)
		(if (and global332 (> global333 0))
			(EgoGait 0 0) ; walking
			(if (and temp0 (or local4 local5))
				(= temp0 0)
				(HighPrint 210 2) ; "You could not escape. The battle is on."
			else
				(HighPrint 210 3) ; "Hostile intent is evident. You prepare for battle."
			)
			(gCurRoom newRoom: global332)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'nap,rest')
					(if (and local8 (> global333 0))
						(HighPrint 210 4) ; "No rest for the weary. Something's after you!"
					else
						(event claimed: 0)
					)
				)
				(cond
					(local9
						(cond
							((super handleEvent: event))
							((Said 'kill,fight,hit,hit')
								(AlreadyDone)
							)
							((Said 'eat')
								(HighPrint 210 5) ; "All the excitement of the battle has caused you to lose your appetite."
							)
							((Said 'look>')
								(if
									(or
										(Said '/monster,creature')
										(Said [local38 (localproc_0 global332)])
									)
									(HighPrint 210 6) ; "It's dead, of course."
									(HighPrint 210 7) ; "It doesn't smell very good, either."
								else
									(event claimed: 0)
								)
							)
							((Said 'odor>')
								(if
									(or
										(Said '/monster,creature')
										(Said [local38 (localproc_0 global332)])
									)
									(HighPrint 210 8) ; "You can't help but smell it."
								else
									(HighPrint 210 9) ; "You only think you can smell that."
									(event claimed: 1)
								)
							)
							((Said 'get>')
								(cond
									((Said '/claw[<cheetaur]')
										(if (== global332 440)
											(if local0
												(AlreadyDone)
											else
												(HighPrint 210 10) ; "Some of the Cheetaur's claws have been broken off or damaged, apparently in battle. You remove the remaining claws and put them away in your pack."
												(= local0 1)
												(gEgo get: 31 (Random 4 10)) ; cheetaur claw
											)
										else
											(HighPrint 210 11) ; "Cheetaur claws are very rare except on Cheetaurs."
										)
									)
									((Said '/beard[<troll]')
										(cond
											(local1
												(HighPrint 210 12) ; "You already have the Troll's beard."
											)
											((== global332 450)
												(HighPrint 210 13) ; "You remove as much of the Troll's beard as you can and put it away in your pack."
												(= local1 1)
												(gEgo get: 32) ; troll beard
											)
											(else
												(HighPrint 210 14) ; "That's not easy to do, especially since this is not a Troll."
											)
										)
									)
								)
							)
							((Said 'search>')
								(if
									(or
										(Said
											'/monster,creature,body,enemy,[!*]'
										)
										(Said [local38 (localproc_0 global332)])
									)
									(if local2
										(AlreadyDone)
									else
										(= local2 1)
										(gEgo setScript: searchIt 0 local6)
									)
								else
									(HighPrint 210 15) ; "You look all around, but you can't find any of those."
									(event claimed: 1)
								)
							)
						)
					)
					((super handleEvent: event))
					((Said 'look>')
						(if
							(or
								(Said '/monster,creature')
								(Said [local38 (localproc_0 global332)])
							)
							(switch global332
								(445
									(HighPrint 210 16) ; "It's an ugly little Goblin."
								)
								(465
									(HighPrint 210 17) ; "Uh oh, this looks like one of the brigands that have been terrorizing the Valley. Better hope his friends aren't around."
								)
								(430
									(HighPrint 210 18) ; "Don't worry, it's just a little purple Saurus. Watch out for those teeth though."
								)
								(460
									(HighPrint 210 19) ; "Oh, no! It's a fierce (and hungry) looking Saurus Rex (smarter than your average Saurus)."
								)
								(440
									(HighPrint 210 20) ; "It's a Cheetaur, a Cheetah Centaur, one of the deadliest creatures in the land. Hope you've saved your game recently."
								)
								(455
									(HighPrint 210 21) ; "It's an Ogre, big, mean, and ugly. Ogres are said to eat human flesh."
								)
								(450
									(HighPrint 210 22) ; "It's a Troll, hard as stone."
								)
								(435
									(HighPrint 210 23) ; "It's a Mantray, a former sea creature that took flight many generations ago and moved to the mountains. Don't get stung!"
								)
								(else
									(HighPrint 210 24) ; "It's a Program Bug!"
								)
							)
						)
					)
					((Said 'fight')
						(if (and local8 global332)
							(gCurRoom newRoom: global332)
						else
							(HighPrint 210 25) ; "There is nothing here to fight."
						)
					)
					((Said 'cast>')
						(if
							(not
								(OneOf
									gCurRoomNum
									420 ; bearArena
									425 ; minotaurArena
									430 ; saurusArena
									435 ; mantrayArena
									440 ; cheetaurArena
									445 ; goblinArena
									455 ; ogreArena
									450 ; trollArena
									460 ; dragonArena
									465 ; brigandArena
									470
								)
							)
							(= temp0 (SaidSpell event))
							(if (CastSpell temp0)
								(switch temp0
									(0)
									(22
										(if (or local50 (== global332 435))
											(local6 setScript: spellDelay 0 22)
										else
											(HighPrint 210 26) ; "Although that spell is not useful here, you at least had a chance to practice it."
										)
									)
									(17
										(HighPrint 210 27) ; "You don't see anything closed around here."
									)
									(18
										(HighPrint 210 28) ; "You sense no magic here."
									)
									(20
										(if (or local50 (== global332 435))
											(local6 setScript: spellDelay 0 20)
										else
											(HighPrint 210 26) ; "Although that spell is not useful here, you at least had a chance to practice it."
										)
									)
									(21
										(= global250
											(+ 5 (/ [gEgoStats 21] 10)) ; zapSpell
										)
										(if
											(or
												(gEgo has: 7) ; dagger
												(gEgo has: 6) ; blade
											)
											(HighPrint 210 29) ; "Your weapon is now magically charged."
										else
											(HighPrint 210 30) ; "You don't seem to have a weapon to charge."
										)
									)
									(23
										(= temp1 0)
										(if local8
											(LookAt gEgo local6)
											(= temp1 local6)
										)
										(CastDart temp1)
									)
									(24
										(if local8
											(HighPrint 210 31) ; "Certainly you don't want to Fetch THAT!"
										else
											(HighPrint 210 32) ; "Good practice, but there's nothing worth Fetching here."
										)
									)
									(else
										(HighPrint 210 33) ; "Your spell had no effect."
									)
								)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(= temp1 0)
						(if local8
							(LookAt gEgo local6)
							(= temp1 local6)
						)
						(ThrowKnife temp1)
					)
					((Said 'throw/boulder')
						(= temp1 0)
						(if local8
							(LookAt gEgo local6)
							(= temp1 local6)
						)
						(ThrowRock temp1)
					)
				)
			)
		)
	)
)

(instance inWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 0 posn: -100 140 setMotion: MoveTo 0 140 self)
			)
			(1
				(localproc_3 client)
			)
		)
	)
)

(instance inEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 1 posn: 400 140 setMotion: MoveTo 319 140 self)
			)
			(1
				(localproc_3 client)
			)
		)
	)
)

(instance northDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(local6
					posn:
						global105
						(cond
							((> (gCurRoom horizon:) (- global106 global118))
								(- (gCurRoom horizon:) 20)
							)
							((== global332 435) -10)
							(else
								(- global106 global118)
							)
						)
					setCel: -1
					setLoop: -1
					setMotion:
						Chase
						gEgo
						[local14 (localproc_0 global332)]
						Encounter
				)
				(= local50 1)
				(client setScript: 0)
			)
		)
	)
)

(instance spellDelay of Script
	(properties)

	(method (doit)
		(if (and seconds local51 (not local52))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local50 0)
				(local6 setCycle: 0 setMotion: 0 ignoreActors: 0)
				(if (== register 22)
					(if (not (CastCalm self self))
						(self changeState: 4)
					)
				else
					(self changeState: 2)
				)
			)
			(1
				(= state 3)
				(cond
					((== global332 435)
						(HighPrint 210 34) ; "Unfortunately, the Mantray appears not to have been affected by your spell."
						(= cycles 1)
					)
					(local51
						(HighPrint 210 35) ; "The monster doesn't seem very calm. Maybe it didn't like you hurting it."
						(= cycles 1)
					)
					(else
						(= seconds (+ 5 (/ [gEgoStats 22] 10))) ; calmSpell
					)
				)
			)
			(2
				(= local52 1)
				(if (not (CastDazzle self self))
					(self changeState: 4)
				)
			)
			(3
				(if (== global332 435)
					(HighPrint 210 34) ; "Unfortunately, the Mantray appears not to have been affected by your spell."
					(= cycles 1)
				else
					(= seconds (+ 3 (/ [gEgoStats 22] 10))) ; calmSpell
				)
			)
			(4
				(if (not local10)
					(if
						(or
							(== global332 445)
							(== global332 450)
							(== global332 465)
							(< -15 (- (gEgo x:) (local6 x:)) 15)
						)
						(local6 setLoop: -1 setCycle: Walk)
					else
						(local6 setCycle: Fwd)
					)
					(local6
						ignoreActors:
						setMotion:
							Chase
							gEgo
							[local14 (localproc_0 global332)]
							Encounter
					)
					(= local50 1)
				)
				(= local52 0)
				(self dispose:)
			)
		)
	)
)

(instance searchIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 register)
				(local6 ignoreActors:)
				(= local12
					(switch global332
						(430 10)
						(440 12)
						(460 18)
						(445 23)
						(435 12)
						(465 0)
						(else 20)
					)
				)
				(= local13
					(switch global332
						(430 4)
						(440 -3)
						(460 4)
						(445 1)
						(435 4)
						(465 2)
						(else 20)
					)
				)
				(HandsOff)
				(if (> (gEgo y:) (local6 y:))
					(gEgo
						illegalBits: 0
						ignoreActors:
						setPri: (+ (local6 priority:) 1)
						setMotion:
							MoveTo
							(+ (local6 x:) local12)
							(+ (local6 y:) local13)
							self
					)
				else
					(gEgo
						illegalBits: 0
						ignoreActors:
						setPri: (- (local6 priority:) 1)
						setMotion:
							MoveTo
							(-
								(local6 x:)
								(cond
									((== global332 435) 19)
									((== global332 465) 36)
									(else 11)
								)
							)
							(- (local6 y:) 5)
							self
					)
				)
			)
			(1
				(gEgo
					view: 510
					setLoop: (if (> (gEgo y:) (local6 y:)) 1 else 0)
					setCycle: End self
				)
			)
			(2
				(HighPrint 210 41) ; "You search your opponent."
				(gEgo setCycle: Beg self)
			)
			(3
				(localproc_6)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						185
						(if (< (gEgo x:) (local6 x:)) 140 else 160)
						self
				)
			)
			(4
				(gEgo setLoop: 1)
				(local6 ignoreActors: 0)
				(NormalEgo)
				(gEgo illegalBits: (gCurRoom illBits:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

