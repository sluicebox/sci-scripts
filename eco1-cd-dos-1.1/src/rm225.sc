;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use n819)
(use EcoFeature)
(use Talker)
(use PFollow)
(use PolyPath)
(use Polygon)
(use Motion)
(use Inventory)
(use System)

(public
	rm225 0
)

(local
	local0 = 231
)

(instance rm225 of ApartmentRoom
	(properties
		picture 220
		style -32761
		east 200
		south 200
		picAngle 60
		lookStr 95
	)

	(method (init)
		(= global250 3)
		(= global251 2)
		(= global229 3)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 319 -10 319 182 274 150 305 96 300 31 225 12 67 25 25 81 47 145 110 154 238 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(if (IsFlag 299)
			(= local0 252)
		)
		(if (not (IsFlag 43))
			(manatee view: local0 init: setCycle: Fwd)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 148 93 194 93 194 115 148 115
						yourself:
					)
			)
		)
		(super init: &rest)
		(plant5 addToPic:)
		(plant4 addToPic:)
		(plant3 addToPic:)
		(plant2 addToPic:)
		(plant1 addToPic:)
		(saw addToPic:)
		(chest addToPic:)
		(wallstuff addToPic:)
		(tools addToPic:)
		(portraits init:)
	)

	(method (notify)
		(cond
			((and (not (IsFlag 43)) (!= ((Inv at: 0) owner:) 335)) ; bikeCage
				(Gregarious init: 2 0 0 1 1) ; "Wulp, whatcha need now, Adam?"
			)
			((IsFlag 43)
				(EcoNarrator init: 3 0 0 96) ; "Gregarious isn't here. He's still waiting at the surface for Adam to take care of those propellers."
			)
			((== ((Inv at: 0) owner:) 335) ; bikeCage
				(Gregarious init: 2 0 0 6 1) ; "Hey there, Adam. Hope yer havin' luck with the other citizens in the buildin'."
			)
		)
		(HandsOn)
	)
)

(instance gregSwimToSurface of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 156 144 self)
			)
			(1
				(manatee setLoop: 2)
				(gEgo setHeading: 0 self)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 26 1 self) ; Adam, "Why are you so blue, Gregarious?"
			)
			(3
				(Gregarious init: 2 0 0 2 1 self) ; "I'm, uh, holdin' my breath."
			)
			(4
				((ScriptID 2 1) init: 1 0 0 27 1 self) ; Adam, "Why on Earth are you doing that?"
			)
			(5
				(Gregarious init: 2 0 0 3 1 self) ; "Ya see these bandages? I keep gettin' hit by the same dumb speedboat every time I go up to the surface to breathe. Danged propellers! I'm just not goin' up there no more!"
			)
			(6
				((ScriptID 2 1) init: 1 0 0 28 1 self) ; Adam, "But you're a mammal! You have to go up to breathe real air or you'll suffocate."
			)
			(7
				(Gregarious init: 2 0 0 4 1 self) ; "Nope, nope, nope. Don't care. I ain't goin'! That propeller has gotten the last piece of Gregarious A. Manatee, by gill!"
			)
			(8
				((ScriptID 2 1) init: 1 0 0 29 1 self) ; Adam, "How about if I go up there with you? You can show me the boat while we're up there. Maybe I can do something about their propellers."
			)
			(9
				(Gregarious init: 2 0 0 5 1 self) ; "Gee, Adam! You'd do that <a-hyuh>? What a pal. Follow me."
				(SetFlag 40)
			)
			(10
				(manatee
					view: local0
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 230 130 self
				)
			)
			(11
				(gEgo ignoreActors: 1 setMotion: PFollow manatee 47)
				(manatee
					view: local0
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 298 188 self
				)
			)
			(12
				(HandsOn)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance manatee of EcoActor
	(properties
		x 168
		y 108
		yStep 3
		view 231
		loop 4
		signal 20480
		illegalBits 0
		xStep 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (== ((Inv at: 0) owner:) 335) ; bikeCage
					(EcoNarrator init: 3 0 0 78) ; "Gregarious looks a lot happier now that he doesn't have to worry about those propellers."
				else
					(EcoNarrator init: 3 0 0 6) ; "The manatee is absolutely covered with bandages! He's also turning blue."
				)
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 79) ; "With all of his cuts and bandages, Gregarious might not appreciate being touched."
			)
			(2 ; Talk
				(if (== ((Inv at: 0) owner:) 335) ; bikeCage
					(Gregarious init: 2 0 0 8 1) ; "There're still some citizens in the apartments, Adam. Check the ones with the lights <a-hyuh>."
				else
					(gCurRoom setScript: gregSwimToSurface)
				)
			)
			(44 ; Inventory
				(Gregarious init: 2 0 0 9) ; "Wulp, that's real purty, Adam, but I don't know what ta do with it."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tools of EcoView
	(properties
		x 101
		y 83
		view 230
		signal 20497
		lookStr 93
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 94) ; "Gregarious needs his tools in his job as handyman for the apartment. Adam doesn't want to take them."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wallstuff of EcoView
	(properties
		x 258
		y 100
		view 230
		cel 1
		signal 20497
		lookStr 11
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
				(EcoNarrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance chest of EcoView
	(properties
		x 85
		y 126
		view 230
		loop 1
		signal 20497
		lookStr 76
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 80) ; "The toolbox contains Gregarious' tools for working around the apartments. There's nothing in there that Adam needs."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance saw of EcoView
	(properties
		x 114
		y 115
		view 230
		loop 1
		cel 1
		signal 20497
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 97) ; "Some of Gregarious' tools are lying on the floor. They look rather dull."
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 94) ; "Gregarious needs his tools in his job as handyman for the apartment. Adam doesn't want to take them."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant1 of EcoView
	(properties
		x 193
		y 182
		view 230
		loop 2
		priority 15
		signal 20497
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
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 122
		y 181
		view 230
		loop 2
		cel 1
		priority 15
		signal 20497
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
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoView
	(properties
		x 101
		y 167
		view 230
		loop 2
		cel 2
		priority 15
		signal 20497
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
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant4 of EcoView
	(properties
		x 140
		y 183
		view 230
		loop 2
		cel 2
		priority 15
		signal 20497
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
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant5 of EcoView
	(properties
		x 165
		y 185
		view 230
		loop 2
		cel 2
		priority 15
		signal 20497
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
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance portraits of EcoFeature
	(properties
		x 255
		y 56
		nsTop 45
		nsLeft 229
		nsBottom 67
		nsRight 282
		lookStr 77
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 92) ; "Adam doesn't want to take the pictures of Gregarious' parents. They have faces only a son could love."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Gregarious of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 240
		charNum 7
		keepWindow 1
	)

	(method (init)
		(if (== ((Inv at: 0) owner:) 335) ; bikeCage
			(= view 249)
		else
			(= view 240)
		)
		(gBust view: view)
		(gEyes view: view)
		(gMouth view: view)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of EcoProp
	(properties
		view 240
	)
)

(instance gEyes of EcoProp
	(properties
		nsTop 13
		nsLeft 13
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of EcoProp
	(properties
		nsTop 16
		nsLeft 9
		view 240
		loop 1
		cycleSpeed 10
	)
)

