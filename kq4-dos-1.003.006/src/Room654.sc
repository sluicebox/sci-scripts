;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 654)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room654 0
)

(synonyms
	(soup gruel food)
)

(local
	local0
	[local1 49]
	local50
	[local51 7]
	local58
	local59
	local60
	[local61 2]
	local63
	local64
)

(instance dwarfMusic of Sound
	(properties
		number 31
		loop -1
	)
)

(instance Room654 of Rm
	(properties
		picture 54
		style 8
	)

	(method (init)
		(= gIndoors 1)
		(Load rsVIEW 630)
		(Load rsVIEW 677)
		(Load rsVIEW 678)
		(Load rsVIEW 500)
		(Load rsVIEW 76)
		(Load rsVIEW 533)
		(super init:)
		((View new:) view: 533 loop: 1 cel: 0 posn: 295 106 setPri: 9 addToPic:)
		(= local63 0)
		(gEgo posn: 150 125 view: 4 xStep: 4 yStep: 2 init: setCycle: Walk)
		((= [local51 0] (View new:))
			view: 677
			posn: 78 102
			loop: 3
			cel: 0
			init:
			stopUpd:
		)
		(= global176 0)
		((= local0 (Prop new:))
			view: 630
			posn: 83 124
			cycleSpeed: 0
			setCycle: Fwd
			init:
		)
		(if (not global223)
			(local0 addToPic:)
		)
		(Print 654 0 #at -1 20 #time 5) ; "You hear the dwarfs approaching."
		(self setScript: dwarfsInToEat)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room'))
						(Print 654 1) ; "This is the main room of the Seven Dwarfs' cozy tree house."
					)
					((Said 'look>')
						(cond
							((Said '/window')
								(Print 654 2) ; "You can see the forest out the window."
							)
							((Said '/table')
								(if (not global102)
									(Print 654 3) ; "You see a long, wooden table. It is empty."
								)
								(if (and global102 global176)
									(Print 654 4) ; "You see a long, wooden table. Empty soup bowls are left on it."
								)
							)
							((Said '<under/table')
								(Print 654 5) ; "There is nothing of interest under the table."
							)
							((Said '/stair')
								(Print 654 6) ; "The narrow stairs lead upward."
							)
							((Said '/cabinet')
								(Print 654 7) ; "You see a long cupboard."
							)
							((Said '/wall')
								(Print 654 8) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 654 9) ; "There is nothing interesting on the floor."
							)
							((Said '/caldron')
								(Print 654 10) ; "You see a pot of soup bubbling over a cheery fire."
							)
							((Said '/fire,fireplace')
								(Print 654 11) ; "A cheery fire heats a bubbling pot of soup in the fireplace."
							)
							((Said '/carpet')
								(Print 654 12) ; "A nice braided rug lies on the floor."
							)
							((Said '/clock')
								(Print 654 13) ; "This clock has seen better days. The cuckoo has flown away."
							)
							((Said '/bowl')
								(Print 654 14) ; "Bowls of soup are on the table."
							)
						)
					)
				)
			)
		)
	)
)

(instance dwarfsInToEat of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 290)
		(Load rsVIEW 291)
		(Load rsVIEW 292)
		(Load rsVIEW 293)
		(Load rsVIEW 294)
		(Load rsVIEW 295)
		(Load rsVIEW 296)
		(Load rsVIEW 297)
		(Load rsVIEW 298)
		(Load rsVIEW 299)
		(Load rsVIEW 275)
		(Load rsVIEW 276)
		(Load rsVIEW 277)
		(Load rsVIEW 278)
		(= [local1 1] 296)
		(= [local1 2] 278)
		(= [local1 3] 0)
		(= [local1 4] 218)
		(= [local1 5] 138)
		(= [local1 8] 295)
		(= [local1 9] 277)
		(= [local1 10] 1)
		(= [local1 11] 295)
		(= [local1 12] 160)
		(= [local1 15] 294)
		(= [local1 16] 276)
		(= [local1 17] 1)
		(= [local1 18] 262)
		(= [local1 19] 160)
		(= [local1 22] 293)
		(= [local1 23] 275)
		(= [local1 24] 0)
		(= [local1 25] 194)
		(= [local1 26] 138)
		(= [local1 29] 292)
		(= [local1 30] 299)
		(= [local1 31] 1)
		(= [local1 32] 228)
		(= [local1 33] 160)
		(= [local1 36] 291)
		(= [local1 37] 298)
		(= [local1 38] 1)
		(= [local1 39] 190)
		(= [local1 40] 160)
		(= [local1 43] 290)
		(= [local1 44] 297)
		(= [local1 45] 0)
		(= [local1 46] 240)
		(= [local1 47] 137)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(= local58 0)
				(= local60 (Print 654 15 #font gSmallFont #at 200 20 #width 110 #dispose)) ; "You watch quietly as the dwarfs file in one by one, get a bowl of soup, and take a seat at the table."
				(dwarfMusic play:)
				(gEgo loop: 2 setCycle: Walk setMotion: MoveTo 116 122 self)
			)
			(1
				(gEgo loop: 2 cel: 0 stopUpd:)
				(= [local1 local58]
					((Act new:)
						view: [local1 (+ local58 1)]
						posn: 155 185
						illegalBits: 0
						setStep: 4 3
						cycleSpeed: 0
						init:
						yourself:
					)
				)
				([local1 local58] setCycle: Walk setMotion: MoveTo 135 140 self)
			)
			(2
				([local1 local58] setCycle: Walk setMotion: MoveTo 83 134 self)
			)
			(3
				([local51 0] cel: (+ ([local51 0] cel:) 1) forceUpd:)
				([local1 local58]
					view: [local1 (+ local58 2)]
					loop: 1
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(4
				([local51 0] stopUpd:)
				(if (== ([local51 0] cel:) 7)
					(cls)
					(= state 2)
					(= local60 (Print 654 16 #font gSmallFont #at -1 20 #dispose)) ; "This dwarf must really be hungry; he's getting two bowls of soup!"
					(= seconds 1)
				else
					([local1 local58] loop: 2 cel: 0 setCycle: End self)
				)
			)
			(5
				([local1 local58]
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 135 130 self
				)
			)
			(6
				(if (== [local1 (+ local58 3)] 1)
					([local1 local58] setLoop: 7 setMotion: MoveTo 135 160 self)
				else
					(++ state)
					([local1 local58]
						setMotion:
							MoveTo
							[local1 (+ local58 4)]
							[local1 (+ local58 5)]
							self
					)
				)
			)
			(7
				([local1 local58]
					setLoop: -1
					setMotion:
						MoveTo
						[local1 (+ local58 4)]
						[local1 (+ local58 5)]
						self
				)
			)
			(8
				(= [local1 (+ local58 6)]
					((View new:)
						view: [local1 (+ local58 2)]
						loop: 6
						posn:
							[local1 (+ local58 4)]
							(- [local1 (+ local58 5)] 3)
						init:
						ignoreActors: 1
						stopUpd:
						yourself:
					)
				)
				([local1 local58]
					loop: 3
					cel: 0
					setPri: (if (== [local1 (+ local58 3)] 1) 13 else 12)
					posn:
						[local1 (+ local58 4)]
						(if (== [local1 (+ local58 3)] 1)
							(- [local1 (+ local58 5)] 12)
						else
							(- [local1 (+ local58 5)] 6)
						)
					setCycle: End self
				)
			)
			(9
				([local1 local58] loop: 4 cel: 0 ignoreActors: 1 stopUpd:)
				(if (< (+= local58 7) 48)
					(= state 0)
					(self cue:)
				else
					([local51 0] dispose:)
				)
				(gEgo startUpd:)
				(if (> local58 48)
					(cls)
					(= local60
						(Print 654 17 #font gSmallFont #at 7 15 #width 290 #draw #dispose) ; "The Seven Dwarfs seem very pleased that you tidied their messy home. One politely asks you your name. You tell him, and he cordially invites you to sit down with them and eat the bowl of soup he got for you."
					)
				)
				(= seconds 15)
			)
			(10
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 270 136 self
				)
			)
			(11
				(User canInput: 1)
				(cls)
				(= local60 (Print 654 18 #font gSmallFont #at -1 20 #dispose)) ; "You seat yourself at the table and begin to eat the surprisingly delicious soup."
				(gEgo view: 76 loop: 5)
				(dwarfMusic dispose:)
				(= global176 1)
				(gEgo setScript: eatOut)
				(= seconds 60)
			)
			(12
				(= local63 1)
			)
			(13
				(cls)
				(= local60 (Print 654 19 #font gSmallFont #at -1 20 #dispose)) ; "It's time for the little men to go back to the mine."
				(= global176 2)
				(User canInput: 0)
				(for ((= local58 0)) (< local58 7) ((++ local58))
					([local1 (* local58 7)] cel: 0)
				)
				(gEgo cel: 0)
				(= local58 49)
				(= seconds 5)
			)
			(14
				(dwarfMusic play:)
				(cls)
				(= local60 (Print 654 20 #font gSmallFont #at -1 20 #dispose)) ; ""Good-bye, and thanks for the soup!" you call, as they take their leave."
				(self cue:)
			)
			(15
				(-= local58 7)
				([local1 local58] loop: 5 cel: 0 setCycle: End self)
				((= local50 (View new:))
					view: 500
					loop: 1
					cel: 2
					setPri: 12
					ignoreActors: 1
					posn:
						([local1 local58] x:)
						(if [local1 (+ local58 3)] 136 else 133)
					addToPic:
				)
				(if (== local58 28)
					((= local59 (View new:))
						view: 500
						loop: 0
						cel: 0
						posn: (+ (local50 x:) 8) (- (local50 y:) 1)
						ignoreActors: 1
						setPri: 12
						init:
						stopUpd:
					)
					((gInventory at: 1) moveTo: 54) ; Diamond_Pouch
				)
			)
			(16
				([local1 local58]
					view: [local1 (+ local58 1)]
					setPri: -1
					cel: 0
					loop: 1
					posn:
						([local1 (+ local58 6)] x:)
						(+ ([local1 (+ local58 6)] y:) 2)
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 140 (+ ([local1 (+ local58 6)] y:) 2) self
				)
				([local1 (+ local58 6)] dispose:)
			)
			(17
				([local1 local58]
					setPri: ([local1 local58] priority:)
					setMotion: MoveTo 150 207 self
				)
			)
			(18
				([local1 local58] dispose:)
				(if local58
					(= state 14)
				)
				(self cue:)
			)
			(19
				(dwarfMusic loop: 1 changeState:)
				(cls)
				(Print 654 21 #font gSmallFont #at -1 20) ; "You finished your soup, also. It was the best soup you have ever tasted! Maybe though, you were just REALLY hungry!"
				((= local50 (View new:))
					view: 500
					loop: 1
					cel: 2
					posn: (gEgo x:) 132
					setPri: 12
					addToPic:
				)
				(gEgo
					ignoreActors: 0
					illegalBits: -32768
					posn: 270 135
					view: 4
					loop: 2
					setCycle: Walk
				)
				(self cue:)
			)
			(20
				(dwarfMusic dispose:)
				(User canControl: 1 canInput: 1)
				(= global205 0)
				(gCurRoom newRoom: 54)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look/dwarf')
						(Print 654 22) ; "You see seven small men seated around their dining table, noisily slurping bowls of soup."
					)
					((Said 'look/table')
						(Print 654 23) ; "You see a long, wooden table. The Seven Dwarfs are eating soup around it."
					)
					((Said 'look/soup')
						(Print 654 24) ; "It looks delicious."
					)
					((Said 'talk[/dwarf]')
						(tacodoco1 cue:)
					)
					((or (Said 'get/soup') (Said 'get/bowl'))
						(cond
							((== global176 0)
								(Print 654 25) ; "The bowl of soup is on the table; ready for you to eat."
							)
							((== global176 1)
								(Print 654 26) ; "You already have a bowl of soup."
							)
							(else
								(Print 654 27) ; "You have eaten the soup. There is no more."
							)
						)
					)
					((Said 'kill/dwarf')
						(Print 654 28) ; "You are NOT a murderous girl, Rosella!"
					)
					((Said 'get/dwarf')
						(Print 654 29) ; "You couldn't get the Seven Dwarfs."
					)
					((or (Said 'kiss[/!*]') (Said 'kiss/dwarf'))
						(Print 654 30) ; "Not while they're eating!"
					)
					((Said 'give>')
						(if
							(and
								(= temp0 (gInventory saidMe:))
								(gEgo has: (gInventory indexOf: temp0))
							)
							(Print 654 31) ; "The Seven Dwarfs look at it curiously, but refuse it."
						else
							(event claimed: 0)
						)
					)
					((or (Said 'eat/soup') (Said 'eat'))
						(switch global176
							(0
								(Print 654 32) ; "The soup is in front of you."
								(= global176 1)
							)
							(1
								(Print 654 33) ; "You're already eating the soup."
							)
							(2
								(Print 654 27) ; "You have eaten the soup. There is no more."
							)
						)
					)
					((Said '(stand<up),(get<up),exit/table,chair')
						(Print 654 34) ; "You're still eating your soup!"
					)
				)
			)
		)
	)
)

(instance tacodoco1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 654 35) ; "You politely talk to the dwarf nearest you. "Where are you from, Rosella?" he asks. You tell him "Daventry." "Hmmmm," the dwarf thinks for a moment. "Never heard of it.""
			)
			(1
				(Print 654 36) ; "Again, you engage in conversation. "Is Daventry far from Tamir?" the dwarfs wonder. "Very far," you tell them."
				(Print 654 37) ; ""How did you get here?" they ask. As you don't want to get into specifics, you tell them "by sea." That answer seems to satisfy them as they return to their eating."
			)
			(2
				(Print 654 38) ; "You speak to the nearest dwarf again. He wonders why you are here in Tamir. You explain that you are in the service of Genesta, the Good Fairy, who wishes to regain her magic talisman from the clutches of Lolotte, the Bad Fairy. "Well, young lady," the dwarf states. "I don't envy you. You're much braver than I am, dealin' with that evil fairy.""
			)
			(3
				(Print 654 39) ; "You attempt conversation another time, but the dwarfs tell you they must hurry and finish their soup, as they need to get back to work before dark."
				(= state 2)
			)
		)
	)
)

(instance eatOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 8)
					setLoop: 0
					setCycle: End
				)
				(= seconds 7)
			)
			(1
				(cls)
				(gEgo setLoop: 1 stopUpd:)
				(= local58 (* (Random 0 6) 7))
				(if (< (Random 1 10) 3)
					(gEgo setCycle: End)
				)
				([local1 local58] setCycle: End self)
			)
			(2
				(if (> (gEgo cel:) 0)
					(gEgo setCycle: CT 0 1)
				)
				([local1 local58] setCycle: CT 0 1 self)
			)
			(3
				([local1 local58] stopUpd:)
				(if (not local63)
					(= state 0)
					(self cue:)
				else
					(dwarfsInToEat cue:)
				)
			)
		)
	)
)

