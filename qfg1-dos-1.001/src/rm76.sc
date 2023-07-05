;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use n007)
(use n100)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm76 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(if (and local1 (< (gEgo distanceTo: acorn) 80))
		(HighPrint 76 0) ; "You pick up the Dryad's gift of a Magic Acorn."
	else
		(HighPrint 76 1) ; "You find an ordinary acorn on the ground."
	)
	(gEgo setScript: pickEmUp)
)

(procedure (localproc_1)
	(HighPrint 76 2) ; "That acorn tasted awfully bitter... just like an ordinary acorn."
)

(procedure (localproc_2)
	(HandsOff)
	(if (IsFlag 198)
		(HighPrint 76 3) ; "Until you have done so, you are only intruding on my concentration."
	else
		(HighPrint 76 4) ; "You need to become a friend of the forest. Harm not the gentle creatures or plants. See with all your senses the magic of the trees and wild places."
		(HighPrint 76 5) ; "Wander and learn. Then you too will be in harmony with the forest."
	)
	(dryad setScript: intoTree)
)

(instance miscSound of Sound
	(properties
		number 97
		priority 1
	)
)

(instance spitSound of Sound
	(properties
		number 18
		priority 1
	)
)

(instance gulpSound of Sound
	(properties
		number 27
		priority 1
	)
)

(instance bush of View
	(properties
		y 141
		x 80
		view 77
	)
)

(instance acorn of Prop
	(properties
		y 132
		x 130
		view 77
		loop 2
	)
)

(instance stag of TargActor
	(properties
		view 78
	)

	(method (getHurt)
		(+= global271 global272)
		(= global272 0)
		(HighPrint 76 6) ; "The stag looks more surprised than hurt."
	)
)

(instance seed of Act
	(properties
		view 16
	)
)

(instance dryad of Act
	(properties
		y 116
		x 96
		view 76
		illegalBits 0
	)
)

(instance rm76 of Rm
	(properties
		picture 76
		style 8
	)

	(method (dispose)
		(SetFlag 66)
		(super dispose:)
	)

	(method (init)
		(if (not gNight)
			(LoadMany rsVIEW 76 79)
			(if (or (IsFlag 137) (IsFlag 138) (IsFlag 139))
				(Load rsVIEW 16)
				(LoadMany rsSOUND (SoundFX 18) (SoundFX 27))
			)
		else
			(Load rsSCRIPT 7)
			(Load rsVIEW 16)
		)
		(LoadMany rsVIEW 77 510)
		(LoadMany rsSOUND 97 98)
		(if (IsFlag 202)
			(Load rsVIEW 78)
		)
		(super init:)
		(bush ignoreActors: init: stopUpd: addToPic:)
		(SL enable:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(= global114 0)
		(if (not gNight)
			(spitSound number: (SoundFX 18) init:)
			(gulpSound number: (SoundFX 27) init:)
			(seed
				illegalBits: 0
				setLoop: 4
				init:
				ignoreActors:
				setCycle: Fwd
				stopUpd:
				hide:
			)
		)
		(if (and (not gNight) (IsFlag 202))
			(stag
				view: 78
				x: 318
				y: 145
				setScript: stagEntrance
				init:
				illegalBits: 0
			)
		else
			(gEgo posn: 318 130 init: setMotion: MoveTo 290 130)
			(ClearFlag 202)
			(= local0 1)
		)
		(miscSound init: play:)
	)

	(method (doit)
		(cond
			((and local4 (not (gEgo script:)) (< (stag x:) 50))
				(= local4 0)
				(HighPrint 76 7) ; "The stag is startled by your action."
				(stag setScript: stagBolts)
			)
			(
				(and
					local3
					(not (gEgo script:))
					(not (stag script:))
					(not (dryad script:))
					(== local0 2)
				)
				(= local3 0)
				(dryad setScript: egoToStag)
			)
		)
		(cond
			((> global114 1)
				(-- global114)
			)
			((== global114 1)
				(= global114 0)
				(localproc_2)
			)
		)
		(cond
			((and (== (gEgo edgeHit:) 2) (>= local0 1))
				(ClearFlag 202)
				(gCurRoom newRoom: 77)
			)
			(
				(and
					(< (gEgo x:) 200)
					(== local0 1)
					(not gNight)
					(or
						local6
						(not (IsFlag 201))
						(IsFlag 203)
						(IsFlag 137)
						(IsFlag 138)
						(IsFlag 139)
					)
				)
				(= local0 2)
				(dryad init: setScript: outOfTree)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evSAID
				(if (> global114 0)
					(cond
						((Said 'yes')
							(= global114 0)
							(HandsOff)
							(if (IsFlag 198)
								(HighPrint 76 8) ; "Give the seed to me."
								(dryad
									x: (+ (dryad x:) 6)
									setLoop: 4
									setCycle: End
								)
								(if (gEgo has: 20) ; seed
									(dryad setScript: hasSeed)
								else
									(HighPrint 76 9) ; "You are forced to confess that you lied to the Dryad. You don't have the magic seed."
									(HighPrint 76 10) ; "She tells you: "It's not nice to fool Mother Nature.""
									(dryad setScript: intoTree)
								)
							else
								(SolvePuzzle 693 1)
								(HighPrint 76 11) ; "Then you shall aid me, and I shall aid you in your quest."
								(HighPrint 76 12) ; "Bring me a seed from the Spore Spitting Spirea of the North that I may plant it elsewhere in order to preserve these rare and magical plants."
								(HighPrint 76 13) ; "Thus will you become a true friend of the forest."
								(SetFlag 198)
								(if (gEgo has: 20) ; seed
									(HighPrint 76 14) ; "I detect that you have in your possession such a seed. Are you willing to give me the seed?"
									(= global114 150)
									(User canInput: 1)
								else
									(dryad setScript: intoTree)
								)
							)
						)
						((Said 'no')
							(= global114 0)
							(localproc_2)
						)
						(else
							(event claimed: 1)
							(HighPrint 76 15) ; "Please. Just answer my question."
						)
					)
				)
				(cond
					((super handleEvent: event))
					((or (Said 'nap') (Said 'go[<to]/nap'))
						(if (not (CanSleep))
							(HighPrint 76 16) ; "You just can't sleep during the daytime."
							(DisposeScript 7)
						else
							(gEgo setScript: goToSleep)
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(if (== local0 2)
										(HighPrint 76 17) ; "The Dryad radiates magic."
									else
										(HighPrint 76 18) ; "The oak tree radiates magic."
									)
								)
							)
							(20
								(if (CastSpell temp0)
									(if (and (IsFlag 202) (< (stag x:) 50))
										(= local4 1)
									)
									(if (== local0 2)
										(= local3 1)
									)
									(CastDazzle)
								)
							)
							(23
								(if (CastSpell temp0)
									(if (== local0 2)
										(= local3 1)
									)
									(if (IsFlag 202)
										(= local4 1)
									)
									(if (gCast contains: stag)
										(LookAt gEgo stag)
										(RedrawCast)
									)
									(if
										(and
											(gCast contains: stag)
											(not (gEgo script:))
										)
										(CastDart stag)
									else
										(CastDart 0)
									)
									(= local6 1)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(= temp1 (if (gCast contains: stag) stag else 0))
						(if (ThrowKnife temp1)
							(if (== local0 2)
								(= local3 1)
							)
							(if (IsFlag 202)
								(= local4 1)
								(SetFlag 203)
							)
							(if (gCast contains: stag)
								(LookAt gEgo stag)
								(RedrawCast)
							)
						)
					)
					((Said 'throw/boulder')
						(= temp1 (if (gCast contains: stag) stag else 0))
						(if (ThrowRock temp1)
							(if (== local0 2)
								(= local3 1)
							)
							(if (IsFlag 202)
								(= local4 1)
								(SetFlag 203)
							)
							(if (gCast contains: stag)
								(LookAt gEgo stag)
								(RedrawCast)
							)
						)
					)
					((Said 'eat/acorn,nut')
						(if (gEgo has: 41) ; acorn
							(localproc_1)
							(gEgo use: 41) ; acorn
							(SolvePuzzle 696 -5)
						else
							(= local2 1)
							(localproc_0)
						)
					)
					((Said 'climb,ride/buck')
						(if (IsFlag 202)
							(HighPrint 76 19) ; "He's beyond your reach."
						else
							(HighPrint 76 20) ; "Huh?"
						)
					)
					((Said 'climb>')
						(cond
							((Said '/tree,oak')
								(HighPrint 76 21) ; "Something about the old oak tree makes you reluctant to climb upon it."
							)
							((Said '/boulder')
								(HighPrint 76 22) ; "The rocks to the north look too steep."
							)
						)
					)
					((or (Said 'ask/date') (Said 'ask/dryad,girl/date'))
						(HighPrint 76 23) ; "Perhaps the farmer has dates in his field."
					)
					((Said 'talk/dryad')
						(if 2
							(HighPrint 76 24) ; "I beg your pardon?"
						else
							(HighPrint 76 25) ; "Does a Dryad bark?"
							(HighPrint 76 26) ; "No, but she's a real birch."
							(HighPrint 76 27) ; "Don't make an ash of yourself."
						)
					)
					((Said 'lockpick<up/acorn,nut')
						(localproc_0)
					)
					((Said 'burn,torch/tree,oak')
						(if (== local0 2)
							(HighPrint 76 28) ; "As you begin to form thoughts of violence..."
							(dryad setScript: egoToStag)
						else
							(HighPrint 76 29) ; "You think better of burning up the woods."
						)
					)
					((Said 'fight,kill,hit,cut>')
						(cond
							((Said '/buck')
								(if (IsFlag 202)
									(= local4 1)
									(if (== local0 2)
										(HighPrint 76 28) ; "As you begin to form thoughts of violence..."
										(dryad setScript: egoToStag)
									else
										(SetFlag 203)
									)
								else
									(HighPrint 76 19) ; "He's beyond your reach."
									(SetFlag 203)
								)
							)
							((Said '/dryad,girl,woman')
								(if (== local0 2)
									(HighPrint 76 28) ; "As you begin to form thoughts of violence..."
									(dryad setScript: egoToStag)
								else
									(HighPrint 76 30) ; "She's beyond your reach."
								)
							)
							((Said '/tree,oak')
								(if (== local0 2)
									(HighPrint 76 28) ; "As you begin to form thoughts of violence..."
									(dryad setScript: egoToStag)
								else
									(HighPrint 76 31) ; "You needn't dull your blade playing woodsman."
								)
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/acorn,nut')
								(localproc_0)
							)
							((Said '/dryad,girl,woman')
								(if (== local0 2)
									(HighPrint 76 32) ; "She's rooted to the ground."
								else
									(event claimed: 0)
								)
							)
							((Said '/buck')
								(if (IsFlag 202)
									(HighPrint 76 33) ; "The stag remains out of your reach."
								else
									(event claimed: 0)
								)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/dryad,girl,woman')
								(if (== local0 2)
									(HighPrint 76 34) ; "The Dryad appears to be a woman made of wood and leaves."
								else
									(HighPrint 76 35) ; "You cannot look at what you cannot see."
								)
							)
							((Said '/tree,oak')
								(HighPrint 76 36) ; "The large, gnarled oak seems to draw your attention."
							)
							((Said '/boulder')
								(HighPrint 76 37) ; "There is a rock wall northwest of the large oak tree."
							)
							((Said '/buck')
								(if (IsFlag 202)
									(HighPrint 76 38) ; "The majestic white stag is an outstanding example of the beauty of the animal kingdom."
								else
									(HighPrint 76 39) ; "You see no such animal."
								)
							)
							((Said '/acorn,nut')
								(if local1
									(HighPrint 76 40) ; "There is a large, slightly glowing acorn on the ground."
								else
									(HighPrint 76 41) ; "There are acorns here and there on the ground."
								)
							)
							((Said '/west')
								(HighPrint 76 42) ; "The forest becomes so lush and thick that it is difficult to see far."
							)
							((Said '/south')
								(HighPrint 76 43) ; "The brush and undergrowth has formed an impassable thicket."
							)
							((Said '/north')
								(HighPrint 76 44) ; "You see thick brush, rocks, and heavy woods to the north. A large oak tree dominates the view."
							)
							((Said '/east')
								(HighPrint 76 45) ; "You see a clearing back the way you came."
							)
							((Said '/bush')
								(HighPrint 76 46) ; "Most of the bushes around here seem to be bramble and are very thorny."
							)
						)
					)
				)
			)
		)
	)
)

(instance stagEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					xStep: 5
					moveSpeed: 1
					posn: 319 150
					setCycle: Fwd
					setMotion: MoveTo 200 140 self
				)
			)
			(1
				(stag setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(stag setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(3
				(stag setCycle: End self)
			)
			(4
				(stag setLoop: 5 cel: 7 cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(stag
					setLoop: 1
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 130 140 self
				)
				(gEgo posn: 319 130 init: setMotion: MoveTo 290 130)
				(= local0 1)
			)
			(6
				(if (not (IsFlag 66))
					(HighPrint 76 47) ; "You follow the stag into this forest corner. You feel as though the eyes of the forest are watching you."
				else
					(HighPrint 76 48) ; "Again, you feel a sense of closeness with nature."
				)
				(stag
					setLoop: 9
					cel: 0
					xStep: 9
					setCycle: End
					setMotion: MoveTo 50 140 self
				)
			)
			(7
				(stag
					setLoop: 1
					cel: 0
					xStep: 5
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 30 140 self
				)
			)
			(8
				(if (not (IsFlag 66))
					(HighPrint 76 49) ; "You watch the stag, fascinated with his grace and beauty. There is something special about this place."
				else
					(HighPrint 76 50) ; "What a beautiful animal!"
				)
				(stag setLoop: 3 cycleSpeed: 1 setCycle: End self)
			)
			(9
				(HandsOn)
				(stag setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(10
				(stag loop: 6 cycleSpeed: 3 setCycle: Fwd)
				(= cycles (Random 20 90))
			)
			(11
				(stag setCycle: End self)
			)
			(12
				(stag loop: 4 cel: 7 cycleSpeed: 1 setCycle: Beg self)
			)
			(13
				(= cycles (Random 5 35))
			)
			(14
				(self changeState: 9)
			)
		)
	)
)

(instance outOfTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(miscSound stop: number: 98 play:)
				(dryad cycleSpeed: 1 setCycle: End)
				(= cycles 25)
			)
			(1
				(dryad setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(dryad
					moveSpeed: 1
					setStep: 5 3
					setCycle: End
					setMotion: MoveTo 124 130 self
				)
			)
			(3
				(cond
					((or local6 (IsFlag 203))
						(dryad setLoop: 6 cel: 6 forceUpd: setScript: egoToStag)
					)
					((IsFlag 198)
						(HighPrint 76 51) ; "Have you brought the seed I requested?"
						(= global114 150)
						(User canInput: 1)
					)
					((or (IsFlag 137) (IsFlag 138) (IsFlag 139))
						(dryad
							setLoop: 6
							cel: 6
							forceUpd:
							setScript: egoToPlant
						)
					)
					((IsFlag 197)
						(HighPrint 76 52) ; "Well, Hero-to-be! Are you yet a friend of the woods?"
						(= global114 150)
						(User canInput: 1)
					)
					(else
						(HighPrint 76 53) ; "I am the Dryad, keeper of the woods. Are you one with the woods?"
						(= global114 150)
						(User canInput: 1)
					)
				)
				(SetFlag 197)
			)
		)
	)
)

(instance intoTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dryad
					setLoop: 1
					cel: 9
					moveSpeed: 1
					setStep: 5 3
					setCycle: CT 2 -1
					setMotion: MoveTo 96 116 self
				)
			)
			(1
				(dryad setCycle: Beg self)
			)
			(2
				(dryad cycleSpeed: 1 setLoop: 0 cel: 5 setCycle: Beg self)
			)
			(3
				(if (IsFlag 201)
					(acorn init: setCycle: End)
					(= local1 1)
					(HighPrint 76 54) ; "You see an acorn fall slowly to the ground."
				)
				(HandsOn)
				(= local0 3)
				(dryad setScript: 0)
			)
		)
	)
)

(instance hasSeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: setMotion: MoveTo 154 132 self)
			)
			(1
				(gEgo setLoop: 3)
				(= cycles 2)
			)
			(2
				(gEgo view: 77 setLoop: 1 cel: 1 forceUpd:)
				(= cycles 15)
			)
			(3
				(gEgo cycleSpeed: 1 setCycle: CT 3 1)
				(= cycles 10)
			)
			(4
				(HighPrint 76 55) ; "You drop the seed into the Dryad's limbs."
				(SolvePuzzle 694 7)
				(gEgo use: 20 setCycle: End self) ; seed
			)
			(5
				(if (or (IsFlag 137) (IsFlag 138) (IsFlag 139))
					(HighPrint 76 56) ; "You tell the Dryad: "No amount of persuasion could convince the flowers to relinquish their seed easily, so I was forced to hack my way to the seed with my weapon.""
					(dryad setScript: oMyGod)
				else
					(NormalEgo)
					(gEgo loop: 1 forceUpd:)
					(dryad setCycle: Beg self)
				)
			)
			(6
				(HighPrint 76 57) ; "Now this will boldly grow where none has grown before!"
				(self cue:)
			)
			(7
				(HighPrint 76 58) ; "Heed now my words, friend of the forest, and heed them well."
				(HighPrint 76 59) ; "Friend, you must know that there is an evil in this valley which perverts the ways of nature. The prophecy says that a hero will bring a young human from out this darkness."
				(HighPrint 76 60) ; "If you are the one to accomplish this task, there is a potion to break enchantments which you must have the Healer make."
				(HighPrint 76 61) ; "You must gather these ingredients:"
				(HighPrint 76 62) ; "Flowers from Erana's Peace,"
				(HighPrint 76 63) ; "Green Fur,"
				(HighPrint 76 64) ; "Fairy Dust,"
				(HighPrint 76 65) ; "a Magic Acorn,"
				(HighPrint 76 66) ; "and Flying Water."
				(HighPrint 76 67) ; "Farewell, friend. I must return to my concentration. May the forest forever surround you."
				(SetFlag 201)
				(ClearFlag 198)
				(dryad setScript: intoTree)
			)
		)
	)
)

(instance pickEmUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and local1 (< (gEgo distanceTo: acorn) 80))
					(gEgo setMotion: MoveTo 147 135 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 510
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(cond
					((and local1 (< (gEgo distanceTo: acorn) 80))
						(= local1 0)
						(gEgo get: 41) ; acorn
						(SolvePuzzle 695 1)
						(acorn dispose:)
					)
					(local2
						(HighPrint 76 68) ; "You pick it up and eat it."
					)
					(else
						(HighPrint 76 69) ; "The acorn appears too ordinary. You drop it back on the ground."
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(if local2
					(= local2 0)
					(localproc_1)
				)
				(NormalEgo)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance stagBolts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stag setLoop: 4 cel: 7 cycleSpeed: 0 setCycle: Beg self)
			)
			(1
				(stag setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(stag
					setLoop: 9
					cel: 0
					xStep: 9
					setCycle: End
					setMotion: MoveTo -20 140 self
				)
			)
			(3
				(ClearFlag 202)
				(stag dispose:)
			)
		)
	)
)

(instance oMyGod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dryad setLoop: 2 cel: 0 forceUpd:)
				(= cycles 10)
			)
			(1
				(HighPrint 76 70) ; "You did WHAT???"
				(self cue:)
			)
			(2
				(dryad setCycle: CT 3 1)
				(= seconds 3)
			)
			(3
				(dryad setCycle: End self)
			)
			(4
				(dryad setScript: egoToPlant)
			)
		)
	)
)

(instance egoToPlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag setScript: stagBolts)
				(HighPrint 76 71) ; "You have destroyed the plant that was to be preserved!"
				(HighPrint 76 72) ; "As you have destroyed, so shall you now become!"
				(self cue:)
			)
			(1
				(dryad setLoop: 3 cel: 0 cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(2
				(gEgo
					view: 79
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(dryad setCycle: End)
			)
			(3
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(gEgo
					view: 16
					setLoop: 1
					cel: 0
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 5)
					forceUpd:
				)
				(= seconds 2)
			)
			(5
				(++ local5)
				(gEgo setLoop: 1 setCycle: End self)
			)
			(6
				(seed
					posn: (gEgo x:) (- (gEgo y:) 29)
					yStep: 10
					startUpd:
					show:
				)
				(self cue:)
			)
			(7
				(spitSound play:)
				(gEgo setCycle: Beg)
				(seed setMotion: MoveTo (seed x:) (- (seed y:) 30) self)
			)
			(8
				(gEgo setLoop: 2 setCycle: End)
				(seed
					yStep: 10
					setMotion: MoveTo (seed x:) (+ (seed y:) 17) self
				)
			)
			(9
				(gulpSound play:)
				(seed hide:)
				(gEgo setCycle: Beg self)
			)
			(10
				(if (< local5 4)
					(self changeState: 5)
				else
					(self cue:)
				)
			)
			(11
				(EgoDead 76 73 80 {Plant it, fella!} 82 79 2 6) ; "Well, it looks like the Dryad really made you eat dirt. You're the spitting image of a Spirea plant, and you'll be hanging around for a long, long time."
			)
		)
	)
)

(instance egoToStag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag setScript: stagBolts)
				(cond
					((IsFlag 203)
						(HighPrint 76 74) ; "You have attempted to harm a free creature of the forest!"
						(HighPrint 76 75) ; "You shall now become a part of the forest!"
					)
					(local6
						(HighPrint 76 76) ; "You have misused your skills, oh Magician! You have used the Flame Dart on my forest."
						(HighPrint 76 77) ; "You must be made less dangerous."
					)
					(else
						(HighPrint 76 78) ; "You dare to harm the Dryad of this forest! You must be made less dangerous."
					)
				)
				(self cue:)
			)
			(1
				(dryad setLoop: 3 cel: 0 cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(2
				(gEgo
					view: 79
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(dryad setCycle: End)
			)
			(3
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(EgoDead 76 79 80 {Oh, deer!} 82 79 1 5) ; "You are staggered by the Dryad's spell. She appears to enjoy having lots of bucks."
			)
		)
	)
)

(instance goToSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 201 132 self)
			)
			(1
				(= global61 1)
				(gCurRoom drawPic: 76 6)
				(gEgo view: 16 setLoop: 6 setCel: 0)
				(= seconds 3)
			)
			(2
				(TimePrint 5 76 80) ; "You sleep comfortably and well in this quiet and protected corner of the woods."
				(= seconds 5)
			)
			(3
				(HandsOn)
				(EgoSleeps 6 0)
				(= global61 0)
				(bush ignoreActors: init: stopUpd: addToPic:)
				(gCurRoom drawPic: 76 7)
				(gEgo posn: 201 132 setLoop: 2)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

