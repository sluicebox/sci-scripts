;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use Main)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm322 0
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

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (and (== param1 33) (gEgo has: 8)) ; leather
		(-= param2 50)
	)
	(if (Purchase param2)
		(= temp0 (if (== param1 3) 5 else 1))
		(if (== param1 33)
			(if (gEgo has: 8) ; leather
				(HighPrint 322 0) ; "You won't be needing your old leather armor anymore. I shall give you a 50 silver trade-in discount."
				(gEgo use: 8) ; leather
			)
			(if (== gHeroType 0) ; Fighter
				(SolvePuzzle 610 3)
			)
		)
		(gEgo get: param1 temp0)
		(SetFlag 120)
		(HighPrint 322 1) ; "Here you are; thank you for your patronage."
	else
		(HighPrint 322 2) ; "As you count your money, you realize that you don't have enough to purchase this particular item."
	)
)

(instance rm322 of Rm
	(properties
		picture 322
		style 2
		south 320
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 96)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 322)
		(super init:)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onKeg1
				onKeg2
				onKeg3
				onKeg4
				onStove
				onFlask
				onShield
				onTeaPot
				onEggs
				onLinen
				onFlour
				onPigsFeet
				onBeets
				onTea2
				onSalt
				onSugar
				onSaltPork
				onPepper
				onHoney
		)
		(self setLocales: 801)
		(SL enable:)
		(proprietor init:)
		(NormalEgo)
		(gEgo posn: 163 188 init: setMotion: MoveTo 163 170)
		((View new:)
			view: 322
			loop: 0
			cel: 0
			posn: 84 141
			init:
			setPri: 9
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 3
			cel: 2
			posn: 94 97
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 3
			cel: 0
			posn: 232 141
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 3
			cel: 0
			posn: 244 146
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 3
			cel: 0
			posn: 239 123
			setPri: 11
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 3
			cel: 1
			posn: 68 159
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 0
			posn: 107 94
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 1
			posn: 113 94
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 1
			posn: 213 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 1
			posn: 205 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 2
			posn: 200 109
			init:
			setPri: 9
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 3
			posn: 123 94
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 4
			posn: 133 81
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 4
			posn: 130 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 4
			posn: 137 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 5
			posn: 133 109
			init:
			setPri: 9
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 5
			posn: 144 109
			init:
			setPri: 9
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 5
			posn: 115 70
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 5
			posn: 129 70
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 6
			posn: 109 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 6
			posn: 166 69
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 6
			posn: 158 70
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 6
			posn: 152 69
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 7
			posn: 119 82
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 8
			posn: 194 94
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 8
			posn: 207 94
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 9
			posn: 207 69
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 9
			posn: 184 69
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 322
			loop: 2
			cel: 10
			posn: 197 70
			init:
			stopUpd:
			addToPic:
		)
	)

	(method (doit)
		(cond
			((and (< (gEgo y:) 140) (not local0))
				(= local0 1)
			)
			((and (> (gEgo y:) 140) local0)
				(= local0 0)
				(if local2
					(= local2 0)
				)
				(if (and local1 local3)
					(proprietor setCycle: Beg)
					(= local3 0)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'drop/*')
						(HighPrint 322 3) ; "It would not be a good idea to drop anything here."
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,room,building,shop]')
								(HighPrint 322 4) ; "This looks like a dry goods store, but it smells like a musty library. The stove feels nice on such a crisp day. Behind the counter and on the shelves, there are many and various items for sale. The shopkeeper appears to ignore you while he reads a book."
							)
							((Said '/stove,coal')
								(HighPrint 322 5) ; "The stove is burning merrily away, making the shop seem almost too warm."
							)
							((Said '/man,shopkeeper,keeper,owner,kaspar')
								(HighPrint 322 6) ; "The shopkeeper is a small, balding man who wears glasses. He looks as if he can barely lift the book he is reading. Judging from his clothes, he is fairly well-to-do."
							)
							((Said '/barrel')
								(HighPrint 322 7) ; "The barrels appear to be filled with something and look rather heavy."
							)
							((Said '/can,(drygoods<canned)')
								(HighPrint 322 8) ; "The jars of beets and sauerkraut look like they were canned locally."
							)
							((Said '<behind/counter')
								(if local0
									(HighPrint 322 9) ; "Behind the counter are weapons, armor, and such equipment as you would more often find in an "Adventurer's Shop"."
								else
									(HighPrint 322 10) ; "You're not close enough to the counter to see behind it."
								)
							)
							((Said '/counter,shelf,item,drygoods')
								(HighPrint 322 11) ; "On the counter and on the shelves are assortments of canned goods, honey jars, sewing items, and odds and ends that people in a small town would need."
							)
							((Said '/armor,leather,chain,chainmail,chainmail')
								(HighPrint 322 12) ; "The leather armor is more like barding, designed to be used under clothing. The chain mail is much heavier, and looks very strong."
							)
							((Said '/odd,end,stuff,item')
								(HighPrint 322 13) ; "There are barrels of flour and salt next to the counter. There seem to be jars of pickled pigs' feet, linen cloth, and other things in which you have very little interest."
							)
							((Said '/equipment')
								(HighPrint 322 14) ; "There are a variety of items of the sort an adventurer might need."
							)
						)
					)
				)
			)
		)
	)
)

(instance proprietor of Act
	(properties
		view 322
		loop 4
		illegalBits 0
	)

	(method (init)
		(self posn: 172 112)
		(self setScript: proprietorScript)
		(super init:)
	)

	(method (doit)
		(if (and local0 local1 (not local3))
			(self setCycle: End)
			(= local3 1)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed self event 3)
					(HighPrint 322 6) ; "The shopkeeper is a small, balding man who wears glasses. He looks as if he can barely lift the book he is reading. Judging from his clothes, he is fairly well-to-do."
				)
			)
			(evSAID
				(cond
					((Said 'yes')
						(if local2
							(proprietorScript changeState: 3)
						else
							(HighPrint 322 15) ; "The shopkeeper doesn't seem to hear you."
						)
					)
					((Said 'no')
						(if local2
							(proprietorScript changeState: 4)
						else
							(HighPrint 322 15) ; "The shopkeeper doesn't seem to hear you."
						)
					)
					((Said '/hello')
						(if (and (not local1) local0)
							(proprietorScript cue:)
						else
							(HighPrint 322 16) ; "Either the shopkeeper can't hear you or he's ignoring you. Try striding right up to the counter."
						)
					)
					((Said 'talk/man')
						(HighPrint 322 17) ; "Go ahead. Talk to him."
					)
					((or (Said 'talk>') (Said 'ask>'))
						(cond
							((and (not local1) local0)
								(proprietorScript cue:)
								(event claimed: 1)
							)
							((not local0)
								(HighPrint 322 16) ; "Either the shopkeeper can't hear you or he's ignoring you. Try striding right up to the counter."
								(event claimed: 1)
							)
							(else
								(= local6 1)
								(cond
									((Said '/weapon,equipment')
										(HighPrint 322 18) ; "Unfortunately, I have only standard weapons and equipment, " the shopkeeper tells you. "I carry daggers and chain armor. Maybe someday I'll be able to carry magic ones, though."
										(HighPrint 322 19) ; "I can also sell you food or empty flasks for carrying liquids or powders."
									)
									((Said '/armor,chain,chainmail,chainmail')
										(HighPrint 322 20) ; "You can get really good protection from my chain mail armor. It's very heavy though, and I would have to charge you 500 silvers for it."
									)
									((Said '/dagger,dagger')
										(HighPrint 322 21) ; "Ah! The use of the dagger is a most skillful art. Actually, this particular weapon is longer than most, but still easily concealable. A bargain at 20 silvers."
									)
									((Said '/food,ration,breakfast')
										(HighPrint 322 22) ; "Adventuring rations aren't the tastiest food in the world, but they will keep you healthy and alert as you go along. A pack of 5 rations will cost you just 5 silvers."
									)
									((Said '/ale,ale,wine')
										(HighPrint 322 23) ; "Oh, no, I don't carry that sort of thing here. If you want to get drunk, try the tavern."
									)
									((Said '/bottle')
										(HighPrint 322 24) ; "It's a very good idea to carry an empty flask or two, in case you want to pick up a liquid or something else that needs a container. Our flasks are a great bargain at 2 silvers each."
									)
									((Said '/book')
										(HighPrint 322 25) ; "Oh, this book? It's about an adventurer who is trying to become a Hero. The title is 'A Hero's Death'."
									)
									(
										(Said
											'/pig,feet,broom,hoe,handle,pan,teapot,egg,cheesecloth,flour,bag,tea,salt,pepper,honey,honey,beet,sauerkraut,saurus,drygoods'
										)
										(= local6 0)
										(HighPrint 322 26) ; "Oh, you don't want those. They're for the people who live here in town. Adventurers just need adventuring equipment."
									)
									((Said '/meisterson,otto,goon')
										(HighPrint 322 27) ; "The Sheriff and Otto protect this town. The Sheriff used to be a real adventurer, you know!"
									)
									((Said '/man,shopkeeper,kaspar')
										(HighPrint 322 28) ; "Why, that's me! Kaspar!"
									)
									((Said '/filly')
										(HighPrint 322 29) ; "Hilde sells fine produce for a reasonable price."
									)
									(
										(or
											(Said
												'/bandit,baron,barnard,woman,zara,ermit,baba,barnard,elsa,hamlet'
											)
											(Said
												'/erasmus,erana,monster,brauggi,giant,meep,healer,bouncer,master,ermit'
											)
										)
										(HighPrint 322 30) ; "I don't like to talk about other people behind their backs."
									)
									((Said '/food,drygoods')
										(HighPrint 322 31) ; "I have pigs feet, brooms, rakes, handles, pots, teapots, eggs, linen, flour, etc..""
									)
									(else
										(= local6 0)
										(event claimed: 1)
										(HighPrint 322 32) ; "I'm sorry, I don't have any of those for sale."
										(HighPrint 322 33) ; "I carry weapons, armor, daggers, rations, ale flasks, and various food stuffs."
									)
								)
								(if local6
									(SolvePuzzle 730 1)
								)
							)
						)
					)
					((Said 'buy,get>')
						(cond
							((not local1)
								(event claimed: 1)
								(proprietorScript cue:)
							)
							((Said '/bottle')
								(= local4 26)
								(= local5 2)
							)
							((Said '/food,ration,breakfast')
								(= local4 3)
								(= local5 5)
							)
							((Said '/dagger')
								(= local4 7)
								(= local5 20)
							)
							((Said '/armor,chain,chainmail,chainmail')
								(= local4 33)
								(= local5 500)
							)
							(else
								(event claimed: 1)
								(= local4 (= local5 0))
							)
						)
						(cond
							((not local1)
								(event claimed: 1)
								(proprietorScript cue:)
							)
							(local4
								(localproc_0 local4 local5)
							)
							(else
								(event claimed: 1)
								(HighPrint 322 34) ; "Aw, you wouldn't want to buy that."
							)
						)
					)
				)
			)
		)
	)
)

(instance proprietorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proprietor cycleSpeed: 1 stopUpd:)
			)
			(1
				(proprietor setCycle: End self)
				(= local3 1)
			)
			(2
				(HighPrint 322 35) ; "Oh, I'm sorry!" the shopkeeper blurts out. "I didn't notice you coming in."
				(cond
					((IsFlag 120)
						(HighPrint 322 36) ; "Well, my adventurer friend! Would you like to make another purchase?"
					)
					((IsFlag 119)
						(HighPrint 322 37) ; "Well, my adventurer friend! Would you like to make a purchase this time?"
					)
					(else
						(HighPrint 322 38) ; "My, you look like an adventurer! We don't see too many around here. The brigands tend to get rid of most adventurers before they make it to town."
						(HighPrint 322 39) ; "You may be in luck. I carry a modest amount of adventurer's equipment behind the counter. Would you like to make a purchase?"
					)
				)
				(= local1 1)
				(= local2 1)
				(SetFlag 119)
			)
			(3
				(= local2 0)
				(HighPrint 322 40) ; "Oh, good! I do try to stock some things adventurers can use. I actually would rather be an adventurer than a shopkeeper, you see."
				(HighPrint 322 41) ; "My items are pretty ordinary, though. You probably already have most of them if you've done any adventuring at all."
				(if local4
					(localproc_0 local4 local5)
				else
					(HighPrint 322 42) ; "Now what was that you wanted again?"
				)
			)
			(4
				(= local2 0)
				(HighPrint 322 43) ; "Well, look around anyway. You may find something you could use.""
			)
		)
	)
)

(instance onKeg1 of RFeature
	(properties
		nsTop 120
		nsLeft 61
		nsBottom 154
		nsRight 75
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg1 event 3)
				(HighPrint 322 44) ; "You see broom and rake handles in this barrel."
			)
		)
	)
)

(instance onKeg2 of RFeature
	(properties
		nsTop 121
		nsLeft 223
		nsBottom 141
		nsRight 234
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg2 event 3)
				(HighPrint 322 7) ; "The barrels appear to be filled with something and look rather heavy."
			)
		)
	)
)

(instance onKeg3 of RFeature
	(properties
		nsTop 123
		nsLeft 235
		nsBottom 145
		nsRight 251
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg3 event 3)
				(HighPrint 322 7) ; "The barrels appear to be filled with something and look rather heavy."
			)
		)
	)
)

(instance onKeg4 of RFeature
	(properties
		nsTop 99
		nsLeft 230
		nsBottom 120
		nsRight 246
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg4 event 3)
				(HighPrint 322 7) ; "The barrels appear to be filled with something and look rather heavy."
			)
		)
	)
)

(instance onStove of RFeature
	(properties
		nsTop 112
		nsLeft 76
		nsBottom 141
		nsRight 93
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onStove event 3)
				(HighPrint 322 5) ; "The stove is burning merrily away, making the shop seem almost too warm."
			)
		)
	)
)

(instance onFlask of RFeature
	(properties
		nsTop 86
		nsLeft 187
		nsBottom 95
		nsRight 210
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFlask event 3)
				(HighPrint 322 45) ; "Flasks, very useful for storing liquids."
			)
		)
	)
)

(instance onShield of RFeature
	(properties
		nsTop 81
		nsLeft 89
		nsBottom 95
		nsRight 97
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onShield event 3)
				(HighPrint 322 46) ; "An unornamented but exceptionally sturdy shield."
			)
		)
	)
)

(instance onTeaPot of RFeature
	(properties
		nsTop 103
		nsLeft 194
		nsBottom 110
		nsRight 207
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTeaPot event 3)
				(HighPrint 322 47) ; "The proprietor's teapot."
			)
		)
	)
)

(instance onEggs of RFeature
	(properties
		nsTop 102
		nsLeft 128
		nsBottom 110
		nsRight 148
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onEggs event 3)
				(HighPrint 322 48) ; "Pickled Saurus eggs."
			)
		)
	)
)

(instance onLinen of RFeature
	(properties
		nsTop 63
		nsLeft 175
		nsBottom 71
		nsRight 215
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onLinen event 3)
				(HighPrint 322 49) ; "Linen coarsely woven from the fibers of spore spitting Spirea plants."
			)
		)
	)
)

(instance onFlour of RFeature
	(properties
		nsTop 61
		nsLeft 148
		nsBottom 70
		nsRight 170
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFlour event 3)
				(HighPrint 322 50) ; "Bags of flour."
			)
		)
	)
)

(instance onPigsFeet of RFeature
	(properties
		nsTop 63
		nsLeft 109
		nsBottom 70
		nsRight 132
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPigsFeet event 3)
				(HighPrint 322 51) ; "Pickled pigs feet."
			)
		)
	)
)

(instance onBeets of RFeature
	(properties
		nsTop 74
		nsLeft 201
		nsBottom 83
		nsRight 216
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBeets event 3)
				(HighPrint 322 52) ; "Jars of beets and sauerkraut."
			)
		)
	)
)

(instance onTea2 of RFeature
	(properties
		nsTop 86
		nsLeft 109
		nsBottom 94
		nsRight 115
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTea2 event 3)
				(HighPrint 322 53) ; "Tea imported all the way from Shapeir."
			)
		)
	)
)

(instance onSalt of RFeature
	(properties
		nsTop 74
		nsLeft 104
		nsBottom 83
		nsRight 112
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSalt event 3)
				(HighPrint 322 54) ; "Salt from the desert east of the mountains."
			)
		)
	)
)

(instance onSugar of RFeature
	(properties
		nsTop 74
		nsLeft 113
		nsBottom 83
		nsRight 123
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSugar event 3)
				(HighPrint 322 55) ; "Sugar from dried figs."
			)
		)
	)
)

(instance onSaltPork of RFeature
	(properties
		nsTop 74
		nsLeft 124
		nsBottom 83
		nsRight 139
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSaltPork event 3)
				(HighPrint 322 56) ; "Salted, dried Saurus."
			)
		)
	)
)

(instance onPepper of RFeature
	(properties
		nsTop 87
		nsLeft 104
		nsBottom 94
		nsRight 109
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPepper event 3)
				(HighPrint 322 57) ; "Locally grown pepper."
			)
		)
	)
)

(instance onHoney of RFeature
	(properties
		nsTop 87
		nsLeft 116
		nsBottom 94
		nsRight 127
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onHoney event 3)
				(HighPrint 322 58) ; "Wild honey from the forest."
			)
		)
	)
)

