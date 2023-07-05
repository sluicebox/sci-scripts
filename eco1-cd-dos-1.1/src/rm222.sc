;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use n819)
(use EcoFeature)
(use Talker)
(use PolyPath)
(use Polygon)
(use Motion)
(use Inventory)
(use User)
(use System)

(public
	rm222 0
)

(instance rm222 of ApartmentRoom
	(properties
		picture 220
		style -32761
		east 200
		south 200
		lookStr 109
	)

	(method (init)
		(= global250 3)
		(= global251 1)
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
		(if (== ((Inv at: 8) owner:) 222) ; sharpShell
			(shell init: stopUpd:)
		)
		(super init: &rest)
		(poster1 addToPic:)
		(poster2 addToPic:)
		(case_o_shells addToPic:)
		(plant addToPic:)
		(plant2 addToPic:)
		(plant3 addToPic:)
		(hobostick addToPic:)
		(shadow addToPic:)
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
				(Epidermis init: 1 0 0 1 1 self) ; "Whoa, Dude! Who are you?"
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "I'm Adam. I came to tell you about a meeting the Mayor's called in the Council Chambers."
			)
			(2
				(Epidermis init: 1 0 0 2 1 self) ; "I'm Epidermis. I'd love to, like, surf on over there, but I got my own problems, man. Sorry."
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
				((ScriptID 2 1) init: 2 0 0 8 1 self) ; Adam, "What's wrong?"
			)
			(1
				(Epidermis init: 1 0 0 3 0 self) ; "I'm gonna have to, like, remove myself from Eluria, man. Hit the road, wave a fin, become a memory. Way bummer, man. I'll be, like, totally lost out there in the big, old sea all by myself."
			)
			(2
				(Epidermis init: 1 0 0 18 1 self) ; "Shark food, that's me."
			)
			(3
				((ScriptID 2 1) init: 2 0 0 9 1 self) ; Adam, "Why do you have to leave?"
			)
			(4
				(Epidermis init: 1 0 0 4 1 self) ; "I only eat one kind of plant, and we've been having this major algae problem. Just look at my potted garden. There's not one inch of algae-free leaf left in the whole city."
			)
			(5
				((ScriptID 2 1) init: 2 0 0 10 1 self) ; Adam, "Wow. My dad says chemical phosphate pollution in the water causes algae growth, but I never thought about it making fishes' food grody."
			)
			(6
				(Epidermis init: 1 0 0 5 1 self) ; "Phosphates, huh? Guess I'll have to, like, look for someplace where there are no `phosphates' - and no sharks or Flesh-Eaters either <sigh>."
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
				(EcoNarrator init: 3 0 0 116 self) ; "Adam swims over to Epidermis' food plants and puts the sea urchins on the algae-covered leaves."
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
				(gEgo put: 7 222) ; urchins
				(SetScore 10 285)
				(SetFlag 17)
				(seaUrchins init: cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(EcoNarrator init: 3 0 0 117 self) ; "The sea urchins begin to eat the algae. Gosh! They must have been hungry too!"
			)
			(5
				(if (IsFlag 146)
					(Epidermis init: 1 0 0 20 1 self) ; "Whoa! Sea urchin city! What exactly do they do again?"
				else
					(Epidermis init: 1 0 0 7 1 self) ; "Hey! What's the story with the sea urchins, Dude?"
				)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 11 1 self) ; Adam, "The sea urchins eat algae. They'll clean up your plants okay, but we'd need a whole army of sea urchins to clean up all the algae in the city."
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
				(Epidermis init: 1 0 0 8 1 self) ; "We can worry about that later, dude. For now, I'm just happy to have some food in my belly."
			)
			(10
				(Epi setPri: 15 setCycle: Walk setMotion: MoveTo 281 118 self)
			)
			(11
				(Epi setCycle: Fwd)
				(= seconds 6)
			)
			(12
				(EcoNarrator init: 3 0 0 113 self) ; "Epidermis happily munches on the algae-free areas the urchins are making."
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
				(Epidermis init: 1 0 0 9 1 self) ; "Ah! Way better! You think I should, like, go to the meeting after all?"
			)
			(16
				((ScriptID 2 1) init: 2 0 0 12 1 self) ; Adam, "Sure! Maybe together you can think of a way to make things better in the city."
			)
			(17
				(Epidermis init: 1 0 0 10 0 self) ; "And I can tell 'em about the urchins. Cool. I'm way glad I don't have to leave home - at least not right away."
			)
			(18
				(Epidermis init: 1 0 0 11 1 self) ; "Let me give you one of my shells. I'm totally into shells. Maybe you can start your own collection."
			)
			(19
				(self setScript: getShell self)
			)
			(20
				(Epidermis init: 1 0 0 17 0 self) ; "I like this one best because it's sharp as a knife! Just don't cut yourself, Dude."
			)
			(21
				(Epidermis init: 1 0 0 12 1 self) ; "And now I'm history, man. Like, hang cool. See ya later."
			)
			(22
				((ScriptID 2 1) init: 2 0 0 14 1 self) ; Adam, "Bye, Epidermis! And thanks for the shell."
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
				(gEgo posn: 183 113 get: 8) ; sharpShell
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
				((ScriptID 2 1) init: 2 0 0 15 1 self) ; Adam, "These sea urchins eat algae, ya know."
			)
			(1
				(Epidermis init: 1 0 0 15 1 self) ; "Way cool for them. At least somebody's got lots of food lying around."
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
				((ScriptID 2 1) init: 2 0 0 16 1 self) ; Adam, "I've got some healing potion."
			)
			(1
				(Epidermis init: 1 0 0 16 1 self) ; "Unless I can eat it I'm not, like, real enthusiastic, dude. Sorry."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shell of EcoView
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

(instance Epi of EcoActor
	(properties
		x 163
		y 118
		yStep 3
		view 225
		cel 6
		cycleSpeed 8
		xStep 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 42) ; "The little teenaged angel fish looks thin and hungry and sad."
			)
			(2 ; Talk
				(if (SetFlag 26)
					(Epidermis init: 1 0 0 6 1) ; "I'm too depressed to talk, man."
				else
					(gCurRoom setScript: whatsWrong)
				)
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 44) ; "Angel fish scales are delicate. Adam knows better than to touch the fish with his hands."
			)
			(44 ; Inventory
				(switch temp0
					(16
						(if (IsFlag 146)
							(EcoNarrator init: 3 0 0 129) ; "Adam's already shown the sea urchins to Epidermis. Epidermis doesn't know what to do with them."
						else
							(gCurRoom setScript: urchinsOnEpi)
						)
					)
					(12
						(gCurRoom setScript: potionOnEpi)
					)
					(else
						(Epidermis init: 1 0 0 14) ; "That's, like, real nice, Dude, but it doesn't make me any less hungry."
					)
				)
			)
			(6 ; Recycle
				(Epidermis init: 1 0 0 19) ; "That's most uncool, man. I wouldn't try to bag you."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance seaUrchins of EcoProp
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 118) ; "The sea urchins have cleared algae off of a section of the plant."
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 119) ; "Adam doesn't want to eat the algea-free areas of the plant! Leave it for Epidermis!"
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance poster1 of EcoView
	(properties
		x 109
		y 90
		view 224
		signal 16401
		lookStr 48
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
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (Inv at: 8)) ; sharpShell
			)
			(EcoNarrator init: 3 0 0 127) ; "Adam doesn't need to use the sharp shell here."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1) ; "Hands off, Dude!"
				else
					(EcoNarrator init: 3 0 0 52) ; "Adam doesn't want to take the angel fish's stuff!"
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance poster2 of EcoView
	(properties
		x 232
		y 104
		z 20
		view 224
		cel 1
		signal 16401
		lookStr 49
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1) ; "Hands off, Dude!"
				else
					(EcoNarrator init: 3 0 0 52) ; "Adam doesn't want to take the angel fish's stuff!"
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance case_o_shells of EcoView
	(properties
		x 78
		y 136
		view 224
		loop 1
		signal 16401
		lookStr 50
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 8) ; sharpShell
					(EcoNarrator init: 3 0 0 53) ; "Adam already has a shell. The rest belong to Epidermis."
				else
					(EcoNarrator init: 3 0 0 51) ; "If the angel fish wants Adam to have a shell, he'll give Adam one."
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoView
	(properties
		x 183
		y 48
		view 224
		loop 1
		cel 1
		signal 16401
		lookStr 11
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(44 ; Inventory
				(switch temp0
					(16
						(EcoNarrator init: 3 0 0 128) ; "Good idea, but the plants that need the urchins are by the door."
					)
					(else
						(EcoNarrator init: 3 0 0 120) ; "Adam doesn't want to mess with the angel fish's stuff."
					)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 278
		y 173
		approachX 244
		approachY 100
		view 224
		loop 2
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 9) ; ???
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 17)
					(EcoNarrator init: 3 0 0 114) ; "The urchins are very content as they eat the algae off of Epidermis' food plants."
				else
					(EcoNarrator init: 3 0 0 43) ; "The angel fish's plants are all covered with algae."
				)
			)
			(4 ; Do
				(if (IsFlag 17)
					(EcoNarrator init: 3 0 0 115) ; "Adam decides to leave the urchins with Epidermis so that they can continue cleaning his food for him."
				else
					(EcoNarrator init: 3 0 0 45) ; "Adam can't help the angel fish get the algae off the plants with just his hands!"
				)
			)
			(44 ; Inventory
				(if (IsFlag 26)
					(switch temp0
						(16
							(gCurRoom setScript: putOnUrchins)
						)
						(12
							(if
								(and
									(IsFlag 26)
									(not (== ((Inv at: 7) owner:) 222)) ; urchins
								)
								(EcoNarrator init: 3 0 0 111) ; "The healing potion won't help get the algae off the angel fish's plants."
							else
								(super doVerb: theVerb temp0 &rest)
							)
						)
						(22
							(EcoNarrator init: 3 0 0 112) ; "The bacteria is for oil, and doesn't help with algae. Besides, the flask is already empty."
						)
						(else
							(cond
								(
									(and
										(IsFlag 26)
										(== ((Inv at: 7) owner:) 222) ; urchins
									)
									(EcoNarrator init: 3 0 0 123) ; "Adam has already done all he needs to do with the food plants."
								)
								((IsFlag 26)
									(EcoNarrator init: 3 0 0 121) ; "That won't help get the algae off of the food plants."
								)
								(else
									(EcoNarrator init: 3 0 0 122) ; "Adam should talk to the angel fish before messing with his food plants."
								)
							)
						)
					)
				else
					(EcoNarrator init: 3 0 0 122) ; "Adam should talk to the angel fish before messing with his food plants."
				)
			)
			(6 ; Recycle
				(if (== ((Inv at: 7) owner:) 222) ; urchins
					(EcoNarrator init: 3 0 0 126) ; "Don't throw away the angel fish's food plants!"
				else
					(EcoNarrator init: 3 0 0 125) ; "Adam needs to help clear the algae from the food plants, not throw them away!"
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoView
	(properties
		x 118
		y 170
		view 224
		loop 2
		cel 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb &tmp temp0)
		(plant doVerb: theVerb temp0 &rest) ; UNINIT
	)
)

(instance hobostick of EcoView
	(properties
		x 53
		y 136
		view 224
		cel 2
		signal 16401
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 17)
					(EcoNarrator init: 3 0 0 110) ; "Luckily for Epidermis, he won't be needing his hobo stick now that he can stay a while longer in Eluria."
				else
					(EcoNarrator init: 3 0 0 46) ; "Looks like the little angel fish is all set to leave his home."
				)
			)
			(4 ; Do
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1) ; "Hands off, Dude!"
				else
					(EcoNarrator init: 3 0 0 47) ; "Adam doesn't need the hobo stick. Besides, it belongs to the angel fish."
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 124) ; "Adam shouldn't throw away the angel fish's stuff!"
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 120) ; "Adam doesn't want to mess with the angel fish's stuff."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance shadow of EcoView
	(properties
		x 279
		y 173
		onMeCheck 0
		view 224
		loop 2
		cel 2
		signal 16401
	)
)

(instance Epidermis of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 234
		viewInPrint 1
		charNum 10
		keepWindow 1
	)

	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of EcoProp
	(properties
		view 234
	)
)

(instance eEyes of EcoProp
	(properties
		nsTop 18
		nsLeft 33
		view 234
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of EcoProp
	(properties
		nsTop 23
		nsLeft 30
		view 234
		loop 1
		cycleSpeed 10
	)
)

