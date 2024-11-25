;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room45 0
)

(synonyms
	(room room castle)
	(leopard leopard cat)
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
	[local10 2]
)

(instance Room45 of Rm
	(properties
		picture 45
		style 16
	)

	(method (init)
		(Load rsVIEW 632)
		(Load rsVIEW 645)
		(Load rsVIEW 365)
		(Load rsVIEW 101)
		(Load rsVIEW 112)
		(Load rsVIEW 115)
		(super init:)
		(HandsOn)
		(= global205 0)
		(fairyMusic init: play:)
		(gEgo
			view: 4
			posn: 225 174
			illegalBits: $8000
			init:
			setStep: 4 2
			setPri: -1
		)
		(if global223
			((View new:) view: 632 posn: 115 100 setPri: 0 addToPic:)
			((View new:) view: 632 posn: 201 100 setPri: 0 addToPic:)
			((= local2 (Prop new:))
				view: 632
				posn: 115 43
				setLoop: 1
				setCycle: Fwd
				init:
			)
			((= local3 (Prop new:))
				view: 632
				posn: 201 43
				setLoop: 1
				setCycle: Fwd
				init:
			)
		)
		((= local6 (Prop new:))
			view: 101
			loop: 0
			cel: 0
			ignoreActors: 1
			posn: 159 126
			setPri: 11
			init:
		)
		((= local0 (Act new:))
			view: 112
			posn: 110 60
			setStep: 1 59
			setLoop: 0
			setCycle: Fwd
			setScript: Flutter3
			init:
		)
		((= local1 (Act new:))
			view: 115
			posn: 200 59
			setStep: 1 1
			setLoop: 1
			setCycle: Fwd
			setScript: Flutter6
			init:
		)
		((= local4 (Prop new:)) view: 365 posn: 59 130 ignoreActors: 1 init:)
		(if global223
			(local4 setScript: catMove)
		else
			(local4 addToPic:)
		)
		(gEgo observeBlocks: catBlock)
	)

	(method (doit)
		(super doit:)
		(if (gCast contains: gEgo)
			(if (& (gEgo onControl: 0) $0040)
				(gCurRoom newRoom: 46)
			)
			(if
				(and
					(gEgo inRect: 93 116 223 151)
					(!= (self script:) closer)
				)
				(cond
					((< (gEgo x:) 158)
						(if (!= (local0 script:) ChaseEgo)
							(local0 setScript: ChaseEgo)
						)
					)
					((!= (local1 script:) ChaseEgo)
						(local1 setScript: ChaseEgo)
					)
				)
			else
				(if (!= (local0 script:) ChaseEgoWhenTalk)
					(local0 setScript: Flutter3)
				)
				(if (!= (local1 script:) ChaseEgoWhenTalk)
					(local1 setScript: Flutter6)
				)
			)
		)
	)

	(method (dispose)
		(cls)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '[<on,in,at]/bed')
								(Print 45 0) ; "Genesta is very ill. She lies, unmoving, in her shell bed."
							)
							((Said '<under/bed')
								(Print 45 1) ; "There is nothing under the bed."
							)
							((Said '/wand[<magic]')
								(Print 45 2) ; "Genesta's magic wand lies upon the bed."
							)
							((Said '/window')
								(if (gEgo inRect: 113 110 208 122)
									(Print 45 3) ; "You see the ocean out the window."
								else
									(Print 45 4) ; "You can't see out the window from here."
								)
							)
							((Said '/blossom,flora')
								(Print 45 5) ; "Gorgeous flowers surround Genesta as she lies, ill, on her bed."
							)
							((Said '/stair')
								(Print 45 6) ; "Wide steps lead down from Genesta's bed chamber."
							)
							((Said '/chest,dresser,drawer>')
								(if (Said '<in,in')
									(Print 45 7) ; "No. It's private."
								else
									(Print 45 8) ; "It must hold Genesta's clothes."
									(event claimed: 1)
								)
							)
							((Said '/wall')
								(Print 45 9) ; "There is nothing of importance on the walls."
							)
							((Said '[<down]/dirt')
								(Print 45 10) ; "There is nothing interesting on the floor."
							)
							((Said '/genesta')
								(Print
									(Format ; "The lovely fairy is visibly fading...fast. Within hours, if she doesn't get her magic talisman back, she'll be dead. %s"
										@global228
										45
										11
										(if (== gLolotteAlive 1)
											{This will be a loss for Tamir, as the evil Lolotte will come to power!}
										else
											{ }
										)
									)
								)
							)
							((Said '/leopard[<snow,white]')
								(Print 45 12) ; "A white, spotted snow leopard lies on the floor of Genesta's bed chamber. It lies quite still, but for an occasional twitch of its tail."
							)
							(
								(Said
									'[<around][/room,tower,bedroom,chamber[<bed]]'
								)
								(Print 45 13) ; "Genesta's bed chamber is very beautiful and serene. Genesta lies very still upon the seashell bed; her concerned fairy helpers hovering near, and her pet snow leopard lying close by."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'give,return/amulet[/genesta]')
						(if (gEgo has: 2) ; Talisman
							(cls)
							(HandsOff)
							(= global160 30)
							(= global159 1)
							(gEgo put: 2 999) ; Talisman
							(fairyMusic dispose:)
							(Print 45 14 #at 0 10 #font gSmallFont) ; "You give the magic talisman to the dying fairy. Almost instantly, the color returns to her cheeks and her green eyes begin to sparkle. She sits up in bed, stretches, and smiles at you."
							(= global224 1)
							(self setScript: closer)
						else
							(Print 800 2) ; "You don't have it."
						)
					)
					(
						(or
							(Said
								'(lay<down,on,in),(sleep<in,on),(get<in,on)[/bed]'
							)
							(Said 'sleep[/!*]')
						)
						(Print 45 15) ; "Not with Genesta in it!"
					)
					((Said 'get/blossom')
						(Print 45 16) ; "No. They belong to Genesta."
					)
					((Said 'get,get,rob/wand')
						(Print 45 17) ; "That belongs to Genesta."
					)
					((Said 'open/dresser,drawer,chest')
						(Print 45 7) ; "No. It's private."
					)
					((or (Said 'talk/genesta') (Said 'talk[/!*]'))
						(Print 45 18) ; "As you attempt to speak to the gravely ill Genesta, her small fairy helpers flutter madly about, trying to prevent you from disturbing her."
						(cond
							((< (gEgo x:) 158)
								(if (== (local0 script:) Flutter3)
									(local0 setScript: ChaseEgoWhenTalk)
								)
							)
							((== (local1 script:) Flutter6)
								(local1 setScript: ChaseEgoWhenTalk)
							)
						)
					)
					((Said 'kill/genesta')
						(Print 45 19) ; "THAT is DEFINITELY NOT the thing to do!"
					)
					((Said 'get/genesta')
						(Print 45 20) ; "You cannot get Genesta."
					)
					((or (Said 'kiss/genesta') (Said 'kiss[/!*]'))
						(Print 45 21) ; "She needs her talisman, not a kiss!"
					)
					((Said 'help,save/genesta')
						(Print 45 22) ; "You can start by helping to get her talisman back from Lolotte."
					)
					(else
						(event claimed: 0)
					)
				)
				(if (not (event claimed:))
					(cond
						((Said 'look[/fairies[<little]]')
							(Print 45 23) ; "Genesta's constant companions are small fairies with fluttering wings and brightly-colored gowns. They utter not a word."
						)
						((Said 'talk[/fairies]')
							(Print 45 24) ; "You speak to the little fairies, but they do not respond. Perhaps, they cannot talk."
						)
						((Said 'kill[/fairies]')
							(Print 45 25) ; "You are NOT a murderous girl, Rosella!"
						)
						((Said 'get/fairies')
							(Print 45 26) ; "It's impossible to obtain a fairy."
						)
						((Said 'capture/fairies')
							(Print 45 26) ; "It's impossible to obtain a fairy."
						)
						((Said 'kiss/fairies')
							(Print 45 27) ; "The little fairies do not need kissing."
						)
						((Said 'help/fairies')
							(Print 45 28) ; "The little fairies don't need your help; Genesta does."
						)
						((Said 'talk/leopard[<snow,white]')
							(Print 45 29) ; "Snow leopards do not talk!"
						)
						((Said 'kill/leopard[<snow,white]')
							(Print 45 30) ; "Oh, yeah. You're going to kill a big snow leopard with your bare hands!"
						)
						((Said 'get,capture/leopard[<snow,white]')
							(Print 45 31) ; "Not this cat!"
						)
						((Said 'kiss,pat/leopard[<snow,white]')
							(Print 45 32) ; "That's probably not a good idea."
						)
						((or (Said 'give/leopard/*') (Said 'give/*/leopard'))
							(Print 45 33) ; "The snow leopard doesn't want it."
						)
						((or (Said 'give/fairies/*') (Said 'give/*/fairies'))
							(Print 45 34) ; "The small fairies don't need anything."
						)
						(
							(or
								(Said 'give/genesta,fairies/*')
								(Said 'give/*[/genesta,fairies]')
							)
							(Print 45 35) ; "Genesta only needs her talisman."
						)
					)
				)
			)
		)
	)
)

(instance ChaseEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 45 36 #at -1 10) ; "Genesta's tiny fairy helpers flit furiously about, trying to keep you from disturbing the dying fairy."
				(client
					yStep: 2
					illegalBits: 0
					setMotion: Chase gEgo 30 self
				)
			)
			(1
				(client
					yStep: 1
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 55) self
				)
			)
		)
	)
)

(instance ChaseEgoWhenTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					illegalBits: 0
					yStep: 2
					setMotion: MoveTo (gEgo x:) (+ (client y:) 25)
				)
				(= seconds 4)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance Flutter3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client illegalBits: 0 setMotion: MoveTo 103 60 self)
			)
			(1
				(client illegalBits: $2000 setMotion: Wander 5)
			)
		)
	)
)

(instance Flutter6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client illegalBits: 0 setMotion: MoveTo 220 60 self)
			)
			(1
				(client illegalBits: $2000 setMotion: Wander 5)
			)
		)
	)
)

(instance catMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(local4 setCycle: End self)
			)
			(2
				(if (> (Random 0 200) 180)
					(local4
						cycleSpeed: 1
						setLoop: 1
						cel: 255
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(3
				(local4 stopUpd:)
				(= seconds 3)
			)
			(4
				(local4 setLoop: 0)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance closer of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 101)
		(Load rsVIEW 103)
		(Load rsVIEW 104)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 0)
				(cls)
				(gGame changeScore: 10)
				(gCast eachElementDo: #hide)
				(DrawPic 991)
				(local6 view: 103 loop: 0 posn: 160 159 show:)
				((= local7 (Prop new:))
					view: 103
					loop: 1
					posn: (local6 x:) (- (local6 y:) 30)
					setPri: (+ (local6 priority:) 1)
					init:
				)
				((= local8 (Prop new:))
					view: 103
					loop: 2
					posn: (local6 x:) (local6 y:)
					setPri: (+ (local6 priority:) 1)
					init:
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(1
				(local7 cycleSpeed: 2 setCycle: End)
				(= seconds 4)
			)
			(2
				(local8 dispose:)
				(local7 dispose:)
				(local6 hide:)
				(= cycles 1)
			)
			(3
				(DrawPic 45 7)
				((View new:) view: 632 posn: 115 100 setPri: 0 addToPic:)
				((View new:) view: 632 posn: 201 100 setPri: 0 addToPic:)
				(local6
					view: 101
					loop: 1
					cel: 0
					ignoreActors: 1
					posn: 159 126
					setPri: 11
				)
				(gCast eachElementDo: #show)
				(local6 setCycle: End)
				(= seconds 4)
			)
			(4
				(Print 45 37 #at 20 10) ; ""You have saved my life, Rosella!" the beautiful fairy says gratefully."
				(Print 45 38 #at 100 140) ; "And you have saved Tamir from the persecution of Lolotte. We are deeply indebted to you."
				(local6 loop: 2 setCycle: End self)
			)
			(5
				(Print 45 39 #at -1 150) ; "I want to go outside; I need to feel the warm sun on my face!"
				(= local5 (Print 45 40 #at -1 10 #dispose)) ; "Exuberantly, she waves her magic wand and ..."
				(local6 loop: 3 setCycle: Fwd)
				((= local9 (Prop new:))
					view: 686
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					init:
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(6
				(gEgo dispose:)
				(local9 cel: 5 setCycle: End self)
			)
			(7
				(local9 dispose:)
				(cls)
				(local6 view: 104 loop: 1 setCycle: End self)
			)
			(8
				(= global205 1)
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance fairyMusic of Sound
	(properties
		number 34
		priority 15
	)
)

(instance catBlock of Blk
	(properties
		top 125
		left 31
		bottom 131
		right 80
	)
)

