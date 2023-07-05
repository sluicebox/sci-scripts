;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use n819)
(use Talker)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm225 0
)

(local
	local0 = 231
)

(instance rm225 of ApartmentRoom
	(properties
		lookStr 95
		picture 220
		style -32761
		east 200
		south 200
		picAngle 60
	)

	(method (init)
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
		(gAddToPics
			add: plant5 plant4 plant3 plant2 plant1 saw chest wallstuff tools
			eachElementDo: #init
			doit:
		)
		(portraits init:)
	)

	(method (notify)
		(cond
			((and (not (IsFlag 43)) (!= ((Inv at: 10) owner:) 335)) ; bikeCage
				(Gregarious init: 1 1) ; "Wulp, whatcha need now, Adam?"
			)
			((IsFlag 43)
				(Narrator init: 96) ; "Gregarious isn't here. He's still waiting at the surface for Adam to take care of those propellers."
			)
			((== ((Inv at: 10) owner:) 335) ; bikeCage
				(Gregarious init: 6 1) ; "Hey there, Adam. Hope yer havin' luck with the other citizens in the buildin'."
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
				(gEgo setMotion: PolyPath 166 144 self)
			)
			(1
				(manatee setLoop: 2)
				(gEgo setHeading: 0 self)
			)
			(2
				((ScriptID 2 1) init: 26 1 self) ; Adam, "Why are you so blue, Gregarious?"
			)
			(3
				(Gregarious init: 2 1 self) ; "I'm, uh, holdin' my breath."
			)
			(4
				((ScriptID 2 1) init: 27 1 self) ; Adam, "Why on Earth are you doing that?"
			)
			(5
				(Gregarious init: 3 1 self) ; "Ya see these bandages? I keep gettin' hit by the same dumb speedboat every time I go up to the surface to breathe. Danged propellers! I'm just not goin' up there no more!"
			)
			(6
				((ScriptID 2 1) init: 28 1 self) ; Adam, "But you're a mammal! You have to go up to breathe real air or you'll suffocate."
			)
			(7
				(Gregarious init: 4 1 self) ; "Nope, nope, nope. Don't care. I ain't goin'! That propeller has gotten the last piece of Gregarious A. Manatee, by gill!"
			)
			(8
				((ScriptID 2 1) init: 29 1 self) ; Adam, "How about if I go up with you? You can show me the boat while we're up there. Maybe I can do something about the propellers."
			)
			(9
				(Gregarious init: 5 1 self) ; "Gee, Adam! You'd do that <a-hyuh>? What a pal. Follow me."
				(SetFlag 40)
			)
			(10
				(manatee
					view: local0
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 188 111 self
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

(instance manatee of Actor
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((Inv at: 10) owner:) 335) ; bikeCage
					(Narrator init: 78) ; "Gregarious looks a lot happier now that he doesn't have to worry about those propellers."
				else
					(Narrator init: 6) ; "The manatee is absolutely covered with bandages! He's also turning blue."
				)
			)
			(3 ; Do
				(Narrator init: 79) ; "With all of his cuts and bandages, Gregarious might not appreciate being touched."
			)
			(5 ; Talk
				(if (== ((Inv at: 10) owner:) 335) ; bikeCage
					(Gregarious init: 8 1) ; "There're still some citizens in the apartments, Adam. Check the ones with that lights <a-hyuh>."
				else
					(gCurRoom setScript: gregSwimToSurface)
				)
			)
			(4 ; Inventory
				(Gregarious init: 9) ; "Wulp, that's real purty, Adam, but I don't know what ta do with it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tools of PicView
	(properties
		x 101
		y 83
		lookStr 93
		view 230
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 94) ; "Gregarious needs his tools in his job as handyman for the apartment. Adam doesn't want to take them."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wallstuff of PicView
	(properties
		x 258
		y 100
		lookStr 11
		view 230
		cel 1
		priority 0
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of PicView
	(properties
		x 85
		y 126
		lookStr 76
		view 230
		loop 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 80) ; "The toolbox contains Gregarious' tools for working around the apartments. There's nothing in there that Adam needs."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance saw of PicView
	(properties
		x 114
		y 115
		view 230
		loop 1
		cel 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 97) ; "Some of Gregarious' tools are lying on the floor. They look rather dull."
			)
			(3 ; Do
				(Narrator init: 94) ; "Gregarious needs his tools in his job as handyman for the apartment. Adam doesn't want to take them."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant1 of PicView
	(properties
		x 193
		y 182
		lookStr 11
		view 230
		loop 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant2 of PicView
	(properties
		x 122
		y 181
		lookStr 11
		view 230
		loop 2
		cel 1
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant3 of PicView
	(properties
		x 101
		y 167
		lookStr 11
		view 230
		loop 2
		cel 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant4 of PicView
	(properties
		x 140
		y 183
		lookStr 11
		view 230
		loop 2
		cel 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant5 of PicView
	(properties
		x 165
		y 185
		lookStr 11
		view 230
		loop 2
		cel 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance portraits of Feature
	(properties
		x 255
		y 56
		nsTop 45
		nsLeft 229
		nsBottom 67
		nsRight 282
		lookStr 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 92) ; "Adam doesn't want to take the pictures of Gregarious' parents. They have faces only a son could love."
			)
			(4 ; Inventory
				(Narrator init: 98) ; "Adam doesn't want to mess around with Gregarious' things."
			)
			(10 ; Recycle
				(Narrator init: 99) ; "Gregarious doesn't need his things cleaned up, thanks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Gregarious of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 240
		viewInPrint 1
		charNum 7
		keepWindow 1
	)

	(method (init)
		(if (== ((Inv at: 10) owner:) 335) ; bikeCage
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

(instance gBust of Prop
	(properties
		view 240
		cel 1
	)
)

(instance gEyes of Prop
	(properties
		nsTop 9
		nsLeft 9
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of Prop
	(properties
		nsTop 12
		nsLeft 4
		view 240
		loop 1
		cycleSpeed 10
	)
)

