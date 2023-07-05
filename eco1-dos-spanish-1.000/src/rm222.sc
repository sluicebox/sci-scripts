;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm222 0
)

(instance rm222 of ApartmentRoom
	(properties
		lookStr 109
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(= global229 1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 179 294 179 243 155 253 126 307 83 302 34 234 16 117 18 46 47 39 111 69 151 159 162 239 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(if (not (IsFlag 51))
			(Epi init: cycleSpeed: 12 setCycle: Fwd)
		)
		(if (IsFlag 17)
			(seaUrchins init: loop: 5 cel: 15 forceUpd: setPri: 2)
		)
		(if (== ((Inv at: 13) owner:) 222) ; sharpShell
			(shell init: stopUpd:)
		)
		(super init: &rest)
		(gAddToPics
			add:
				poster1
				poster2
				case_o_shells
				plant
				plant2
				plant3
				hobostick
				shadow
			eachElementDo: #init
			doit:
		)
	)

	(method (notify)
		(if (SetFlag 24)
			(HandsOn)
		else
			(Epi setScript: firstSpeech)
		)
	)
)

(instance firstSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Epidermis init: 1 1 self) ; "Whoa, Dude! Who are you?"
			)
			(1
				((ScriptID 2 1) init: 1 1 self) ; Adam, "I'm Adam. I came to tell you about a meeting the Mayor's called in the Council Chambers."
			)
			(2
				(Epidermis init: 2 1 self) ; "I'm Epidermis and I'd love to, like, surf on over there, but I have my own problems, man. Sorry."
			)
			(3
				(HandsOn)
				(= seconds 8)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance whatsWrong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Epi setMotion: 0)
				((ScriptID 2 1) init: 8 1 self) ; Adam, "What's wrong?"
			)
			(1
				(Epidermis init: 3 0 self) ; "I'm gonna have to, like, remove myself from Eluria, man. Hit the road, wave a fin, become a memory. Way bummer, man. I'll be, like, totally lost out there in the big old sea by myself."
			)
			(2
				(Epidermis say: 18 1 self)
			)
			(3
				((ScriptID 2 1) init: 9 1 self) ; Adam, "Why do you have to leave?"
			)
			(4
				(Epidermis init: 4 1 self) ; "I only eat one kind of plant, and we've been having a major algae problem. Just look at my potted garden. There's not an inch of algae-free leaf left in the city."
			)
			(5
				((ScriptID 2 1) init: 10 1 self) ; Adam, "Wow. My Dad says chemical phosphate pollution in the water causes algae growth, but I never thought about it making fishes' food grody."
			)
			(6
				(Epidermis init: 5 1 self) ; "Phosphates, huh? Guess I'll have to, like, look for someplace where there are no `phosphates' - and no sharks or Flesh-Eaters either <sigh>."
			)
			(7
				(HandsOn)
				(SetScore 2 284)
				(self dispose:)
			)
		)
	)
)

(instance putOnUrchins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(Narrator init: 116 self) ; "Adam swims over to Epidermis' food plants and puts the sea urchins on the algae-covered leaves."
			)
			(2
				(gEgo
					setCycle: 0
					view: 224
					setLoop: 3
					cel: 0
					setPri: 2
					posn: 253 102
					setCycle: End self
				)
			)
			(3
				(gEgo put: 15 222) ; urchins
				(SetScore 10 285)
				(SetFlag 17)
				(seaUrchins init: cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(Narrator init: 117 self) ; "The sea urchins begin to eat the algae. Gosh! They must have been hungry too!"
			)
			(5
				(if (IsFlag 146)
					(Epidermis init: 20 1 self) ; "Whoa! Sea urchin city! What exactly do they do again?"
				else
					(Epidermis init: 7 1 self) ; "Hey! What's the story with the sea urchins, Dude?"
				)
			)
			(6
				((ScriptID 2 1) init: 11 1 self) ; Adam, "The sea urchins eat algae. They'll clean up your plants okay, but we'd need a whole army of sea urchins to clean up all the algae in the city <sigh>."
			)
			(7
				(NormalEgo 0)
				(gEgo
					view: 802
					posn: (plant2 approachX:) (plant2 approachY:)
				)
				(seaUrchins
					setLoop: 5
					cel: 0
					cycleSpeed: 35
					setCycle: CT 2 1 self
				)
			)
			(8
				(seaUrchins setCycle: End)
				(= ticks 1)
			)
			(9
				(Epidermis init: 8 1 self) ; "We can worry about that later, man. For now, I'm just way happy to have some food in my belly."
			)
			(10
				(Epi setPri: 15 setCycle: Walk setMotion: MoveTo 281 118 self)
			)
			(11
				(Epi setCycle: Fwd)
				(= seconds 6)
			)
			(12
				(Narrator init: 113 self) ; "Epidermis happily munches on the algae-free areas the urchins are making."
			)
			(13
				(Epi
					setCycle: Walk
					setMotion: MoveTo (- (Epi x:) 55) (Epi y:) self
				)
			)
			(14
				(Face gEgo Epi self)
				(Epi setHeading: 90)
			)
			(15
				(Epidermis init: 9 1 self) ; "Ah! Way better! You think I should, like, go to that meeting after all?"
			)
			(16
				((ScriptID 2 1) init: 12 1 self) ; Adam, "Sure! Maybe together you can think of a way to make things better in the city."
			)
			(17
				(Epidermis init: 10 0 self) ; "And I can tell 'em about urchins. Cool. I'm way glad I don't have to leave my home - at least not right away."
			)
			(18
				(Epidermis say: 11 1 self)
			)
			(19
				(self setScript: getShell self)
			)
			(20
				(Epidermis init: 17 0 self) ; "I like this one best because it's sharp as a knife! Just don't cut yourself, Dude."
			)
			(21
				(Epidermis say: 12 1 self)
			)
			(22
				((ScriptID 2 1) init: 14 1 self) ; Adam, "Bye, Epidermis! And thanks for the shell."
			)
			(23
				(gEgo setHeading: 180 self)
			)
			(24
				(= cycles 12)
			)
			(25
				(Epi setMotion: PolyPath 346 178 self)
			)
			(26
				(Epi dispose:)
				(SetFlag 51)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 2)
				(gEgo setMotion: MoveTo 191 109 self)
				(Epi setPri: -1 ignoreActors: setMotion: MoveTo 80 125 self)
			)
			(1 0)
			(2
				(shell dispose:)
				(Epi setMotion: MoveTo 162 114 self)
			)
			(3
				(Face Epi gEgo self)
			)
			(4
				(Epi
					view: 237
					loop: 1
					cel: 0
					posn: 165 117
					setCycle: CT 2 1 self
				)
			)
			(5
				(gEgo
					setCycle: 0
					view: 237
					loop: 0
					cel: 0
					posn: 172 107
					setCycle: CT 2 1 self
				)
			)
			(6
				(Epi setCycle: End self)
				(gEgo setCycle: End self)
			)
			(7 0)
			(8
				(NormalEgo 1)
				(SetScore 2 286)
				(gEgo posn: 183 113 get: 13) ; sharpShell
				(Epi view: 225 loop: 0 posn: 165 117 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance urchinsOnEpi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 146)
				((ScriptID 2 1) init: 15 1 self) ; Adam, "These sea urchins eat algae, ya know."
			)
			(1
				(Epidermis init: 15 1 self) ; "Way cool for them. At least somebody has lots of food lying around <sigh>."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance potionOnEpi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 16 1 self) ; Adam, "I've got some healing potion."
			)
			(1
				(Epidermis init: 16 1 self) ; "Unless I can eat it I'm not, like, real enthusiastic. Sorry, Dude."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shell of View
	(properties
		x 74
		y 123
		onMeCheck 0
		view 224
		loop 1
		cel 2
		priority 1
		signal 16400
	)
)

(instance Epi of Actor
	(properties
		x 163
		y 118
		yStep 3
		view 225
		cel 6
		cycleSpeed 8
		xStep 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 42) ; "The little teenaged angel fish looks thin and hungry and sad."
			)
			(5 ; Talk
				(if (SetFlag 26)
					(Epidermis init: 6 1) ; "I'm too depressed to talk, man."
				else
					(gCurRoom setScript: whatsWrong)
				)
			)
			(3 ; Do
				(Narrator init: 44) ; "Angel fish scales are delicate. Adam knows better than to touch the fish with his hands."
			)
			(4 ; Inventory
				(switch invItem
					(15 ; urchins
						(if (IsFlag 146)
							(Narrator init: 129) ; "Adam's already shown the sea urchins to Epidermis. Epidermis doesn't know what to do with them."
						else
							(gCurRoom setScript: urchinsOnEpi)
						)
					)
					(21 ; healingPotion
						(gCurRoom setScript: potionOnEpi)
					)
					(else
						(Epidermis init: 14) ; "That's, like, real nice, Dude, but it doesn't make me any less hungry."
					)
				)
			)
			(10 ; Recycle
				(Epidermis init: 19) ; "That's most uncool, man. I wouldn't try to bag you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance seaUrchins of Prop
	(properties
		x 281
		y 164
		z 58
		view 224
		loop 4
		priority 2
		signal 16401
		cycleSpeed 30
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 118) ; "The sea urchins have cleared algae off of a section of the plant."
			)
			(3 ; Do
				(Narrator init: 119) ; "Adam doesn't want to eat the algea-free areas of the plant! Leave it for Epidermis!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poster1 of PicView
	(properties
		x 109
		y 90
		lookStr 48
		view 224
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(not (gCurRoom script:))
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (Inv at: 13)) ; sharpShell
			)
			(Narrator init: 127) ; "Adam doesn't need to use the sharp shell here."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 13 1) ; "Hands off, Dude!"
				else
					(Narrator init: 52) ; "Adam doesn't want to take the angel fish's stuff!"
				)
			)
			(10 ; Recycle
				(Narrator init: 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(4 ; Inventory
				(Narrator init: 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster2 of PicView
	(properties
		x 232
		y 104
		z 20
		lookStr 49
		view 224
		cel 1
		priority 0
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 13 1) ; "Hands off, Dude!"
				else
					(Narrator init: 52) ; "Adam doesn't want to take the angel fish's stuff!"
				)
			)
			(10 ; Recycle
				(Narrator init: 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(4 ; Inventory
				(Narrator init: 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance case_o_shells of PicView
	(properties
		x 78
		y 136
		lookStr 50
		view 224
		loop 1
		priority 0
		signal 16400
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (gEgo has: 13) ; sharpShell
					(Narrator init: 53) ; "Adam already has a shell. The rest belong to Epidermis."
				else
					(Narrator init: 51) ; "If the angel fish wants Adam to have a shell, he'll give Adam one."
				)
			)
			(10 ; Recycle
				(Narrator init: 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(4 ; Inventory
				(Narrator init: 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant of PicView
	(properties
		x 183
		y 48
		lookStr 11
		view 224
		loop 1
		cel 1
		priority 0
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(switch invItem
					(15 ; urchins
						(Narrator init: 128) ; "Good idea, but the plants that need the urchins are by the door."
					)
					(else
						(Narrator init: 120) ; "Adam doesn't want to mess with the angel fish's stuff."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant2 of PicView
	(properties
		x 278
		y 173
		approachX 244
		approachY 100
		view 224
		loop 2
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 17)
					(Narrator init: 114) ; "The urchins are very content as they eat the algae off of Epidermis' food plants."
				else
					(Narrator init: 43) ; "The angel fish's plants are all covered with algae."
				)
			)
			(3 ; Do
				(if (IsFlag 17)
					(Narrator init: 115) ; "Adam decides to leave the urchins with Epidermis so that they can continue cleaning his food for him."
				else
					(Narrator init: 45) ; "Adam can't help the angel fish get the algae off the plants with just his hands!"
				)
			)
			(4 ; Inventory
				(if (IsFlag 26)
					(switch invItem
						(15 ; urchins
							(gCurRoom setScript: putOnUrchins)
						)
						(21 ; healingPotion
							(if
								(and
									(IsFlag 26)
									(not (== ((Inv at: 15) owner:) 222)) ; urchins
								)
								(Narrator init: 111) ; "The healing potion won't help get the algae off the angel fish's plants."
							else
								(super doVerb: theVerb invItem &rest)
							)
						)
						(3 ; beaker
							(Narrator init: 112) ; "The bacteria is for oil, and doesn't help with algae. Besides, the flask is already empty."
						)
						(else
							(cond
								(
									(and
										(IsFlag 26)
										(== ((Inv at: 15) owner:) 222) ; urchins
									)
									(Narrator init: 123) ; "Adam has already done all he needs to do with the food plants."
								)
								((IsFlag 26)
									(Narrator init: 121) ; "That won't help get the algae off of the food plants."
								)
								(else
									(Narrator init: 122) ; "Adam should talk to the angel fish before messing with his food plants."
								)
							)
						)
					)
				else
					(Narrator init: 122) ; "Adam should talk to the angel fish before messing with his food plants."
				)
			)
			(10 ; Recycle
				(if (== ((Inv at: 15) owner:) 222) ; urchins
					(Narrator init: 126) ; "Don't throw away the angel fish's food plants!"
				else
					(Narrator init: 125) ; "Adam needs to help clear the algae from the food plants, not throw them away!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant3 of PicView
	(properties
		x 118
		y 170
		view 224
		loop 2
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(plant doVerb: theVerb invItem &rest)
	)
)

(instance hobostick of PicView
	(properties
		x 53
		y 136
		view 224
		cel 2
		priority 0
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 17)
					(Narrator init: 110) ; "Luckily for Epidermis, he won't be needing his hobo stick now that he can stay a while longer in Eluria."
				else
					(Narrator init: 46) ; "Looks like the little angel fish is all set to leave his home."
				)
			)
			(3 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 13 1) ; "Hands off, Dude!"
				else
					(Narrator init: 47) ; "Adam doesn't need the hobo stick. Besides, it belongs to the angel fish."
				)
			)
			(10 ; Recycle
				(Narrator init: 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(4 ; Inventory
				(Narrator init: 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shadow of PicView
	(properties
		x 279
		y 173
		onMeCheck 0
		view 224
		loop 2
		cel 2
		priority 0
		signal 16400
	)
)

(instance Epidermis of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 234
		viewInPrint 1
		charNum 10
		keepWindow 1
	)

	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of Prop
	(properties
		view 234
		cel 1
	)
)

(instance eEyes of Prop
	(properties
		nsTop 16
		nsLeft 29
		view 234
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of Prop
	(properties
		nsTop 21
		nsLeft 26
		view 234
		loop 1
		cycleSpeed 10
	)
)

