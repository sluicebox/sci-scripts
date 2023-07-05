;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use n117)
(use n150)
(use n151)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm66 0
)

(synonyms
	(brazier fire)
	(beggar man)
)

(local
	local0
)

(procedure (localproc_0)
	(Face gEgo beggar)
	(gTObj tWindow: beggarWindow actor: beggar tLoop: 2 cSpeed: 2)
	(Talk &rest)
)

(instance beggarWindow of SysWindow
	(properties
		color 6
		back 14
		title {Beggar}
		brTop 20
		brLeft 70
		brBottom 100
		brRight 270
	)
)

(instance upperRock of Prop
	(properties
		y 111
		x 199
		view 166
		cycleSpeed 2
	)
)

(instance lowerRock of Prop
	(properties
		y 136
		x 150
		view 166
		loop 1
		cycleSpeed 2
	)
)

(instance brazier of Prop
	(properties
		y 141
		x 141
		view 372
		loop 5
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: (if (IsItemAt 7) 2 else 6)) ; crystal_heart | charcoal | helm
	)
)

(instance Rm66 of Rm
	(properties
		picture 66
	)

	(method (init)
		(super init:)
		(gCurRoom setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(61
				(gEgo posn: 20 170 loop: 0)
			)
			(63
				(gEgo posn: (- 310 (gEgo x:)) 180 loop: 3)
			)
			(else
				(gEgo posn: 140 160)
			)
		)
		(upperRock init: stopUpd:)
		(lowerRock init: stopUpd:)
		(beggar init:)
		(brazier init:)
		(proc0_13 81)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 61)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 63)
			)
		)
	)

	(method (notify)
		(Face gEgo beggar)
		(gTObj tWindow: beggarWindow actor: beggar tLoop: 2 cSpeed: 2)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said '/room,street')
							(Said '//room,street')
						)
						(Print 66 0) ; "The Street of David ends here against this sacred wall. A beggar sits, coaxing what warmth he can from a brazier filled with burning charcoal."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 66 1) ; "Though this wall looks to be made of similar stone to the rest of Jerusalem, it is a remnant of a very ancient temple built by King David many hundreds of years ago and is held sacred by the Jewish people."
					)
				)
			)
			((Said 'kill,attack,annihilate/beggar')
				(Print 66 2) ; "What is this mindless violence that inflicts you? Even a leper has a right to live."
			)
			((Said 'poke/beggar,hierophant')
				(Print 66 3) ; "Touch a man with leprosy? Do not be a fool!"
			)
			((Said 'hit,press/beggar')
				(Print 66 4) ; "That would be extraordinarily cruel, Arthur."
			)
		)
	)
)

(instance beggar of Act
	(properties
		y 138
		x 139
		view 372
		loop 1
		cycleSpeed 2
	)

	(method (handleEvent event &tmp temp0)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'look/brazier')
					(Said 'ask/merlin/brazier')
					(MouseClaimed brazier event)
				)
				(Print 66 5) ; "A small pile of charcoal burns inside a simple bronze brazier."
			)
			(
				(or
					(Said 'look/beggar')
					(Said 'ask/merlin/beggar')
					(MouseClaimed self event)
				)
				(Print 66 6) ; "The beggar is a pathetic sight for his limbs are rotting with the disease of leprosy."
			)
			((or (Said 'look/staff,cane') (Said 'ask/merlin/staff,cane'))
				(Print 66 7) ; "The beggar holds a staff in one hand."
			)
			((Said 'talk[/beggar,hierophant]>')
				(= temp0 (Said '/hierophant'))
				(event claimed: 1)
				(cond
					((and (not temp0) (not (IsFlag 137)) (IsFlag 134))
						(cond
							((IsItemAt 7) ; crystal_heart | charcoal | helm
								(localproc_0 66 8) ; "A thousand blessings upon for bringing me this charcoal."
							)
							((not local0)
								(= local0 1)
								(localproc_0 66 9 66 10) ; "At night, I suffer from the cold. I have only this brazier in which to burn charcoal, my only source of warmth. Men fear to come near me and I can no longer walk upon my rotted limbs."
							)
							(else
								(localproc_0 66 11) ; "A small bag of charcoal would be a gift greater than silver or gold to this poor leper."
							)
						)
					)
					((and (not (IsFlag 137)) (not temp0))
						(localproc_0 66 12) ; "Alms for a poor leper. Look upon the wretched with mercy. Alms for a poor leper."
					)
					((IsFlag 157)
						(localproc_0 66 13 66 14) ; "Sa'alam aleikem, King Arthur. You have passed many trials, yet more Guardians of the Sacred Cup wait to test you."
					)
					((not (IsFlag 157))
						(localproc_0 66 15 66 16 66 17) ; "I am the hierophant you seek, King Arthur. Though I may admit you to face the next Guardian of the Sacred Cup, you have not yet passed the Test of Symbols."
					)
				)
			)
			((Said 'open/catacomb')
				(if (or (IsFlag 157) (IsFlag 137))
					(gEgo setScript: openCatacombs)
				else
					(localproc_0 66 12) ; "Alms for a poor leper. Look upon the wretched with mercy. Alms for a poor leper."
				)
			)
			((Said 'get/elixer')
				(cond
					((not (IsFlag 137))
						(localproc_0 66 18) ; "You would ask a gift from a poor leprous beggar?"
					)
					((not (IsFlag 157))
						(localproc_0 66 19) ; "Return to Fatima and pass the Test of Symbols, if you desire greater help from me."
					)
					(else
						(gEgo setScript: openCatacombs)
					)
				)
			)
			((Said 'get/brazier')
				(Print 66 20) ; "Your reward for such a mean-spirited action would be to burn your hands."
			)
			((Said 'give/alm')
				(Print 66 21) ; "Usually an alm can be money, though sometimes it may be some other gift. You must decide what would be best to give this beggar."
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(event claimed: 0)
					)
					((proc150_0 self self -6 12) 0)
					(else
						(SetScore 277 2 5)
						(switch (Random 0 2)
							(0
								(localproc_0 66 22) ; "Bless you! May you always walk the path of righteousness."
							)
							(1
								(localproc_0 66 23) ; "Bless you, good sir, bless you!"
							)
							(else
								(localproc_0 66 24) ; "May you be richly blessed for your kindness!"
							)
						)
						(= global132 0)
					)
				)
			)
			((Said 'drop,pour/charcoal/brazier')
				(if (not (gEgo has: 7)) ; crystal_heart | charcoal | helm
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(Print 66 25) ; "Best to leave it to the beggar to decide when and how to burn the charcoal once you give it to him."
				)
			)
			((or (Said 'give,show/charcoal') (Said 'give,show/bag/charcoal'))
				(cond
					((not (gEgo has: 7)) ; crystal_heart | charcoal | helm
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((& (gEgo onControl: 1) $0100)
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(SetScore 0 0 5 2 5)
						(gEgo setScript: giveCharcoal)
					)
				)
			)
			((and (or global140 (Said '/ass>')) (Said 'give,show'))
				(if (not (IsItemAt 7)) ; crystal_heart | charcoal | helm
					(localproc_0 66 26) ; "Great is your charity, yet I would only ask for one thing -- a bag of charcoal."
				else
					(localproc_0 66 27) ; "I am content with what I have."
				)
			)
			((and (or global140 (Said '/ass>')) (Said 'sell,bargain'))
				(localproc_0 66 28) ; "I am but a poor, leprous beggar, not a merchant."
			)
			((Said 'get,buy/grail')
				(if (IsFlag 137)
					(localproc_0 66 29) ; "It is not mine to give."
				else
					(localproc_0 66 30) ; "There are many merchants in the bazaar who may help you, though they will not help me."
				)
			)
			((Said 'get,buy')
				(localproc_0 66 30) ; "There are many merchants in the bazaar who may help you, though they will not help me."
			)
			((Said 'ask[/beggar,beggar,hierophant]/*>')
				(cond
					((Said '//grail')
						(if (IsFlag 137)
							(SetScore 278 1 1)
							(localproc_0 66 31) ; "My task it to guide you toward the Grail, nothing more."
						else
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						)
					)
					((Said '//galahad')
						(if (IsFlag 137)
							(SetScore 279 1 1)
							(localproc_0 66 33) ; "He chose to enter the catacombs without passing the Test of Symbols. He has not been seen since."
						else
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						)
					)
					((Said '//gift,elixer,rat,catacomb')
						(cond
							((not (IsFlag 137))
								(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
							)
							((not (IsFlag 157))
								(localproc_0 66 19) ; "Return to Fatima and pass the Test of Symbols, if you desire greater help from me."
							)
							(else
								(localproc_0 66 34) ; "If you ask me to open the catacombs, then I will tell you more. If you choose not to enter, there is no point in my telling you anything."
							)
						)
					)
					((Said '//wisdom,knowledge,truth')
						(if (not (IsFlag 137))
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						else
							(localproc_0 66 35) ; "Wisdom and knowledge must always be sought. With them you will be rewarded, but without them you will be doomed."
						)
					)
					((Said '//fatima')
						(if (not (IsFlag 137))
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						else
							(localproc_0 66 36) ; "She is extremely powerful for she has the highest favor of the goddess."
						)
					)
					((Said '//goddess')
						(if (not (IsFlag 137))
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						else
							(localproc_0 66 37) ; "Once in this city she was greatly worshipped under the name of Aphrodite. By that name still we call her."
						)
					)
					((Said '//seeress')
						(if (not (IsFlag 137))
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						else
							(localproc_0 66 38) ; "Tamra serves Aphrodite, as do I."
						)
					)
					((Said '//direction,north,south,east,west')
						(localproc_0 66 39) ; "I sit with by back to the north, my face to the south, half in shadow, half in light."
					)
					((Said '//charcoal')
						(if (IsItemAt 7) ; crystal_heart | charcoal | helm
							(localproc_0 66 40) ; "Thanks to your generosity, the charcoal will keep me warm during the cold nights."
						else
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						)
					)
					((Said '//brazier')
						(if (IsItemAt 7) ; crystal_heart | charcoal | helm
							(localproc_0 66 41) ; "The burning charcoal heats my brazier which in turn warms my poor diseased body."
						else
							(localproc_0 66 42) ; "My brazier needs charcoal to keep me warm during the cold nights."
						)
					)
					((Said '//leprosy,disease')
						(localproc_0 66 43) ; "It causes my body to rot, my fingers and toes to fall off. Do not come near me, I beg you."
					)
					((Said '//guardian')
						(if (IsItemAt 7) ; crystal_heart | charcoal | helm
							(localproc_0 66 44) ; "I guard the way to the catacombs and admit only those who are found worthy."
						else
							(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
						)
					)
					((Said '//bandit')
						(localproc_0 66 45) ; "No thief dares to rob from a leper."
					)
					(else
						(event claimed: 1)
						(localproc_0 66 32) ; "What answer can you expect from a leprous beggar?"
					)
				)
			)
		)
	)
)

(instance beggarActions of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(-- state)
				(if (and (not (gEgo script:)) (not global80))
					(beggar setLoop: 1 setCel: 0 setCycle: End)
				)
				(= seconds (Random 4 10))
			)
		)
	)
)

(instance giveCharcoal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (- (beggar x:) 8) (+ (beggar y:) 10) self
				)
			)
			(1
				(Face gEgo beggar)
				(PutItem 7) ; crystal_heart | charcoal | helm
				(++ global146)
				(proc151_0 2 self self)
			)
			(2
				(gTObj talkCue: self)
				(localproc_0 66 46) ; "Bless you a thousand times, good sir! May your charity win you a place in Paradise."
			)
			(3
				(brazier cycleSpeed: 2)
				(gEgo ignoreActors: 0 illegalBits: -32768)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance openCatacombs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(= cycles 2)
			)
			(1
				(cond
					((& (gEgo onControl: 1) $0100)
						(-- state)
						(gEgo setMotion: MoveTo 90 180 self)
					)
					((< (gEgo y:) 144)
						(-- state)
						(gEgo setMotion: MoveTo (gEgo x:) 144 self)
					)
					(else
						(gEgo
							setMotion:
								MoveTo
								(+ (beggar x:) 20)
								(+ (beggar y:) 5)
								self
						)
					)
				)
			)
			(2
				(gTObj talkCue: self)
				(if (IsFlag 157)
					(localproc_0 66 47 66 48 66 49) ; "Because you have passed the Test of Symbols, I will give you a gift that could save your life. Within the catacombs are cursed rats whose bite is poison."
				else
					(localproc_0 66 50) ; "As you wish it. Listen carefully. Within the catacombs are hordes of rats with a deadly poison in their bite. Once you are bitten, nothing can save you."
				)
				(gEgo loop: 3)
			)
			(3
				(if (IsFlag 157)
					(beggar setLoop: 3 cel: 0 setCycle: End self)
				else
					(self changeState: 6)
				)
			)
			(4
				(gEgo
					view: 70
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(beggar setLoop: 1)
				(gEgo view: 0 loop: 1 cycleSpeed: 0 get: 5) ; sleeve | elixir
				(SetScore 0 0 5)
				(gTObj talkCue: self)
				(localproc_0 66 51) ; "If you are bitten, drink it and you will be cured. There is but one dosage, so waste it not."
			)
			(6
				(beggar setLoop: 4 cel: 0 setCycle: Fwd)
				(= cycles 12)
			)
			(7
				(beggar setCycle: 0)
				(upperRock setCycle: End self)
				(lowerRock setCycle: End)
			)
			(8
				(if (not (IsFlag 157))
					(gTObj talkCue: self)
					(localproc_0 66 52) ; "Go now. There is no turning back."
				else
					(gTObj talkCue: self)
					(localproc_0 66 53) ; "The way is open. Go."
				)
			)
			(9
				(= seconds 2)
			)
			(10
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 172 138 self
				)
			)
			(11
				(gEgo setPri: 1 setLoop: 3 setMotion: MoveTo 147 180 self)
			)
			(12
				(if (gEgo has: 2) ; lodestone
					(SetFlag 72)
				else
					(ClearFlag 72)
				)
				(if (gEgo has: 5) ; sleeve | elixir
					(SetFlag 73)
				)
				(if (gEgo has: 4) ; rose | apple | green_apple
					(SetFlag 74)
				)
				(gCurRoom newRoom: 69)
			)
		)
	)
)

