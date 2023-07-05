;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 343)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use PFollow)
(use Polygon)
(use Motion)
(use System)

(public
	rm343 0
)

(local
	local0 = 1
	local1 = 1
)

(instance rm343 of EcoRoom
	(properties
		picture 347
		style -32759
		horizon -20
		south 480
		lookStr 16
	)

	(method (init)
		(= global250 3)
		(ClearFlag 107)
		(self setRegions: 51) ; bubblesRegion
		(gFeatures
			add:
				DriftNet
				SawfishBones
				Float1
				Float2
				Float3
				Float4
				Float5
				Weight1
				Weight2
				Weight3
				Weight4
			eachElementDo: #init
		)
		(if (not (gEgo has: 26)) ; sawFishHead
			(SawfishSaw init:)
		)
		(DeadPorpi init:)
		(if (and (not (IsFlag 67)) (not (IsFlag 73)))
			(lobster init:)
		)
		(NormalEgo)
		(gEgo setPri: 3 init:)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph
				z: 0
				ignoreHorizon: 1
				setPri: 2
				moveSpeed: 0
				cycleSpeed: 0
				init:
			)
			(gDelph talkScript: firstNetConversation lookStr 19)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -3 195 -3 -3 322 -3 322 195 316 195 316 3 3 3 3 195
					yourself:
				)
		)
		(super init:)
		(self setScript: fromVertical)
		(if (!= (gLongSong number:) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 446 loop: -1 flags: 1 play:)
	)

	(method (doit)
		(if (or (not (< 26 (gEgo x:) 293)) (< (gEgo y:) 14))
			(gEgo setMotion: 0)
			(cond
				((< (gEgo x:) 27)
					(gEgo x: 27)
				)
				((> (gEgo x:) 292)
					(gEgo x: 292)
				)
				(else
					(gEgo y: 14)
				)
			)
			(EcoNarrator init: 3 0 0 28) ; "There's nothing of interest that way."
		)
		(super doit: &rest)
		(Palette palANIMATE 177 192 -3)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 16) ; "Adam and Delphineus are swimming in front of a wall of net and bones. The wall is called a driftnet. This one has been abandoned and is now an unmonitored killer. Delphineus trembles with dread as he gazes at it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gDelph lookStr: 0 setMotion: 0)
		(SetFlag 107)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 flags: 0 fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance lobster of EcoActor
	(properties
		x 291
		y 104
		approachX 256
		approachY 108
		view 341
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 0 setPri: 3 ignoreActors: 1 setCycle: Fwd cycleSpeed: 26)
		(self approachVerbs: 4 1 2) ; Do, Look, Talk
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 15) ; "The lobster is too entangled in the tough nylon net for Adam to get it free with his hands alone. He'll have to try something else."
			)
			(1 ; Look
				(if (and (not (IsFlag 67)) (not (IsFlag 73)))
					(if (== local0 1)
						(rm343 setScript: firstLobsterLookConversation)
					else
						(EcoNarrator init: 3 0 0 11) ; "A little lobster struggles madly in the net. Her claws are entangled and she cannot get herself free."
					)
				)
			)
			(44 ; Inventory
				(switch temp0
					(37
						(EcoNarrator init: 3 0 0 14) ; "That hacksaw is much too dangerous to use anywhere near that lobster! Adam will have to think of something else."
					)
					(17
						(rm343 setScript: freeLobster)
					)
					(else
						(EcoNarrator init: 3 0 0 13) ; "The lobster doesn't care about anything right now except getting free, and that's not going to help Adam free the lobster."
					)
				)
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 12) ; "The little lobster is too terrified to talk."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 26) ; "Adam can't help the lobster by throwing it away!"
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SawfishSaw of EcoView
	(properties
		x 269
		y 49
		view 341
		loop 1
	)

	(method (init)
		(self setPri: 3 ignoreActors: 1)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 21) ; "The sawfish saw would crumble at Adam's slightest touch."
			)
			(1 ; Look
				(if (not (gEgo has: 26)) ; sawFishHead
					(EcoNarrator init: 3 0 0 2) ; "The sawfish's saw, though a deadly weapon when used against other fish, was not much use against the nylon net."
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 18) ; "The fish bones are not endangering the environment - that net is. There's no reason to throw the bones away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance DeadPorpi of EcoView
	(properties
		x 65
		y 100
		view 341
		loop 2
	)

	(method (init)
		(self setPri: 3 ignoreActors: 1)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 25) ; "There's nothing Adam can do for the dolphins now."
			)
			(1 ; Look
				(EcoNarrator init: 3 0 0 24) ; "A family of dolphins died in the net."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 18) ; "The fish bones are not endangering the environment - that net is. There's no reason to throw the bones away."
			)
			(44 ; Inventory
				(if (or (== temp0 17) (== temp0 37))
					(EcoNarrator init: 3 0 0 27) ; "There's no point in cutting free the dolphin bones. They are long past the need for rescue."
				else
					(EcoNarrator init: 3 0 0 25) ; "There's nothing Adam can do for the dolphins now."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance DriftNet of EcoFeature
	(properties
		x 155
		y 30
		nsTop 30
		nsLeft 5
		nsBottom 155
		nsRight 310
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 7) ; "Unfortunately, Adam can't do anything about the net. It's too big and heavy for him to try and gather."
			)
			(1 ; Look
				(if (and (not (IsFlag 142)) (not (IsFlag 73)))
					(rm343 setScript: firstNetConversation)
				else
					(EcoNarrator init: 3 0 0 10) ; "The driftnet floats vertically in the water. It has been lost by some fisherman and now acts as a time bomb; sinking as it gets heavy with fish corpses and rising to trap more fish as the bodies decompose."
				)
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 22) ; "There's nothing Adam can do about the driftnet right now."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 8) ; "The net is way too big to fit in Adam's garbage bag."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SawfishBones of EcoFeature
	(properties
		x 247
		y 103
		z 50
		nsTop 43
		nsLeft 229
		nsBottom 64
		nsRight 266
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 3) ; "The main body of the skeleton is still surprisingly strong."
			)
			(1 ; Look
				(EcoNarrator init: 3 0 0 1) ; "This huge sawfish has been floating in the net for years. His skeleton is bleached and brittle from the constant motion of the water."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 23) ; "The sawfish bones are long past helping."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 18) ; "The fish bones are not endangering the environment - that net is. There's no reason to throw the bones away."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Float1 of EcoFeature
	(properties
		x 277
		y 10
		nsTop 5
		nsLeft 271
		nsBottom 10
		nsRight 284
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 5) ; "The floats keep the top of the net on the surface of the ocean. When paired with the weights, the floats cause the net to float vertically in the water forming a wall of death."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Float2 of EcoFeature
	(properties
		x 186
		y 32
		nsTop 25
		nsLeft 180
		nsBottom 32
		nsRight 192
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 5) ; "The floats keep the top of the net on the surface of the ocean. When paired with the weights, the floats cause the net to float vertically in the water forming a wall of death."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Float3 of EcoFeature
	(properties
		x 128
		y 43
		nsTop 38
		nsLeft 123
		nsBottom 43
		nsRight 132
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 5) ; "The floats keep the top of the net on the surface of the ocean. When paired with the weights, the floats cause the net to float vertically in the water forming a wall of death."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Float4 of EcoFeature
	(properties
		x 104
		y 59
		nsTop 47
		nsLeft 85
		nsBottom 59
		nsRight 122
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 5) ; "The floats keep the top of the net on the surface of the ocean. When paired with the weights, the floats cause the net to float vertically in the water forming a wall of death."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Float5 of EcoFeature
	(properties
		x 33
		y 71
		nsTop 64
		nsLeft 4
		nsBottom 71
		nsRight 58
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 5) ; "The floats keep the top of the net on the surface of the ocean. When paired with the weights, the floats cause the net to float vertically in the water forming a wall of death."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Weight1 of EcoFeature
	(properties
		x 270
		y 165
		nsTop 155
		nsLeft 264
		nsBottom 164
		nsRight 275
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 6) ; "The weights hold the bottom of the net down so that the net forms a vertical wall of death in the water."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Weight2 of EcoFeature
	(properties
		x 174
		y 148
		nsTop 141
		nsLeft 171
		nsBottom 148
		nsRight 177
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 6) ; "The weights hold the bottom of the net down so that the net forms a vertical wall of death in the water."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Weight3 of EcoFeature
	(properties
		x 100
		y 140
		nsTop 124
		nsLeft 76
		nsBottom 140
		nsRight 123
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 6) ; "The weights hold the bottom of the net down so that the net forms a vertical wall of death in the water."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Weight4 of EcoFeature
	(properties
		x 33
		y 127
		nsTop 118
		nsLeft 6
		nsBottom 127
		nsRight 59
	)

	(method (doVerb theVerb invItem)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= invItem theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 6) ; "The weights hold the bottom of the net down so that the net forms a vertical wall of death in the water."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance firstNetConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 142)
					((ScriptID 2 0) init: 2 0 0 21 1 self) ; Delphineus, "I'm not up for conversation while we're so close to this horrid thing, Adam. Do what you need to do and let's get the heck out of here!"
					(self dispose:)
				else
					(SetFlag 142)
					((ScriptID 2 1) init: 1 0 0 1 1 self) ; Adam, "It's a driftnet, Delphineus. Just like the one you were caught in before you came to my dad's lab."
				)
			)
			(1
				(= seconds 1)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 2 1 self) ; Delphineus, "Why do men create things like this, Adam? I just don't understand."
			)
			(3
				((ScriptID 2 1) nsTop: 116 init: 1 0 0 4 1 self) ; Adam, "It's used for commercial fishing. There are floats at the top and weights at the bottom to keep the net vertical in the water. The fishermen leave it out and come back later for their catch."
			)
			(4
				((ScriptID 2 1) nsTop: 96 init: 1 0 0 5 1 self) ; Adam, "But the net doesn't care WHAT it catches so dolphins and other creatures that aren't any use to fishermen die too. And the nets sometimes get lost - like this one. Unattended nets will just float and kill forever."
			)
			(5
				((ScriptID 2 1) init: 1 0 0 6 1 self) ; Adam, "It's like a time bomb that just keeps going off."
			)
			(6
				((ScriptID 2 0) init: 2 0 0 3 1 self) ; Delphineus, "I'll tell you a secret, Adam. My... my family died this way. At least, the Oracle told me she saw a net in her visions after they disappeared."
			)
			(7
				((ScriptID 2 1) init: 1 0 0 7 1 self) ; Adam, "I'm sorry, Del. My mom's gone too. I never even knew her but I miss her a lot. So does my dad."
			)
			(8
				((ScriptID 2 0) init: 2 0 0 4 1 self) ; Delphineus, "Maybe that's why we make such good friends, Adam. Hey, do ya think we could get away from this thing now?"
			)
			(9
				(= local1 0)
				(gDelph talkScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance firstLobsterLookConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 1 0 0 8 1 self) ; Adam, "Look, Del! That little lobster over there is still moving!"
			)
			(1
				((ScriptID 2 0) init: 2 0 0 5 1 self) ; Delphineus, "Why, that's Persephone - Demeter's daughter! So that's what happened to her!"
			)
			(2
				((ScriptID 2 0) init: 2 0 0 6 1 self) ; Delphineus, "Do you think you could get her out, Adam? I already know my flippers are useless against that driftnet."
			)
			(3
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance fromVertical of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 80 190 setMotion: MoveTo 190 120 self)
				(if (not (IsFlag 73))
					(gDelph
						posn: (gEgo x:) 220
						setMotion: PFollow gEgo 90
					)
				)
			)
			(1
				(if (and (not (IsFlag 141)) (not (IsFlag 73)))
					(SetFlag 141)
					((ScriptID 2 0) init: 2 0 0 1 1 self) ; Delphineus, "Oh, horrible <shudder>! This must be the 'net of bones' in the Oracle's prophecy."
				else
					(self dispose:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 215 108 self)
			)
			(3
				(gEgo setHeading: 108)
				(self dispose:)
			)
		)
	)
)

(instance freeLobster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 275 105 self)
			)
			(1
				(SetScore 5 308)
				(gEgo setHeading: 90)
				((ScriptID 2 1) init: 1 0 0 9 1 self) ; Adam, "Don't worry - I'll get you out. Easy now. Don't pinch me."
			)
			(2
				((ScriptID 2 0) init: 2 0 0 7 1 self) ; Delphineus, "Persephone! You better go home now to your mother, Demeter. She's been worried sick!"
			)
			(3
				(lobster
					setLoop: 3
					setCycle: Fwd
					cycleSpeed: 6
					setMotion: MoveTo 330 (lobster y:) self
				)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 8 1 self) ; Delphineus, "Good goin', Adam. At least you have the thumbs for the job."
			)
			(5
				(SetFlag 67)
				(lobster dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

