;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use Smopper)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm335 0
)

(procedure (localproc_0)
	(fisherman
		view: 328
		loop: 2
		cel: 0
		x: 122
		y: 111
		cycleSpeed: 12
		setCycle: End
	)
)

(instance rm335 of EcoRoom
	(properties
		lookStr 14
		picture 320
		style 7
		horizon 95
		south 341
	)

	(method (init)
		(LoadMany rsVIEW 241 323 328 811 825 249 329 330)
		(manatee init: hide:)
		(if (IsFlag 43)
			(manatee show:)
		)
		(NormalEgo)
		(gEgo
			view: 825
			setLoop: gStopGroop
			setCycle: Walk
			setStep: 4 2
			setHeading: 0
			init:
			hide:
		)
		(fisherman init: setCycle: Fwd)
		(ripples init: setCycle: Fwd)
		(rope init:)
		(propeller init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 56 133 42 93 0 93 0 0 319 0 319 91 266 91 259 123 163 147 108 146
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 51 163 110 163 110 175 51 175
					yourself:
				)
		)
		(if (not (IsFlag 43))
			(gCurRoom setScript: cartoon)
		else
			(gCurRoom setScript: fromBelow)
		)
		(super init: &rest)
		(gAddToPics add: boat eachElementDo: #init doit:)
		(gLongSong number: 923 loop: -1 play:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 14) ; "Adam is swimming on the ocean's surface above Eluria. A small fishing boat is anchored nearby."
			)
			(10 ; Recycle
				(if (> ((User curEvent:) y:) 67)
					(Narrator init: 12) ; "Hey! Not trashing the ocean is what this game's all about!"
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 2 4 1)
				(gCurRoom setScript: cantGoThatWay)
			)
		)
	)
)

(instance fromBelow of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(manatee cycleSpeed: 17 setCycle: Fwd)
				(gEgo
					show:
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= seconds 1)
			)
			(3
				(Narrator init: 26 self) ; "Adam resurfaces to find Gregarious and the fisherman still eyeing each other suspiciously."
			)
			(4
				(Gregarious init: 5 1 self) ; "Did ya come up with a way ta fix them propellers yet, Adam?"
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(manatee
					show:
					view: 241
					loop: 2
					x: 71
					y: 171
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(2
				(manatee cycleSpeed: 23 setCycle: End self)
			)
			(3
				(manatee
					view: 241
					loop: 3
					x: 71
					y: 171
					cycleSpeed: 23
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(4
				(gEgo
					show:
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= cycles 3)
			)
			(6
				(Gregarious init: 1 1 self) ; "<gulp> It sure feels good to breathe!"
			)
			(7
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Is this the boat?"
			)
			(8
				(Gregarious init: 2 1 self) ; "Yup. Gosh darn propellers anyway!"
			)
			(9
				(SetFlag 43)
				(ClearFlag 40)
				(= cycles 1)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToFisherman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 142 149 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(SetScore 2 300)
				((ScriptID 2 1) init: 2 1 self) ; Adam, "Hey! Mr. Fisherman!"
			)
			(3
				(Fisherman init: 1 1 self) ; "Wha- who said that?"
			)
			(4
				(fisherman
					view: 328
					loop: 1
					cel: 0
					x: 122
					y: 111
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(5
				(localproc_0)
				(= seconds 4)
			)
			(6
				((ScriptID 2 1) init: 3 1 self) ; Adam, "I'm down here!"
			)
			(7
				(Fisherman init: 2 1 self) ; "Oh, a diver, ey? Why didn't youse say so? <mumble> Cock-a-maimie kids."
			)
			(8
				((ScriptID 2 1) init: 4 1 self) ; Adam, "We just swam up through some of your trash. Lots of creatures have to live in the ocean. You shouldn't dump stuff in here, you know."
			)
			(9
				(Fisherman init: 3 1 self) ; "What's that? Creatures is it? Whatdya think I'm fishin' fer? The ocean's a big place, matey. That little bitta trash ain't gonna hurt them fishies none."
			)
			(10
				(localproc_0)
				(= seconds 4)
			)
			(11
				((ScriptID 2 1) init: 5 1 self) ; Adam, "But it DOES. You wouldn't believe all the trash down there. Anyway, that's not what I came to talk to you about. It's about Gregarious."
			)
			(12
				(Fisherman init: 4 1 self) ; "Gregarious? That's a heck of a name fer just a dumb manatee. And what's all them bandages fer anyhow?"
			)
			(13
				(localproc_0)
				(= seconds 4)
			)
			(14
				((ScriptID 2 1) init: 6 1 self) ; Adam, "Because YOU keep hitting him with your propellers!"
			)
			(15
				(Fisherman init: 5 1 self) ; "M' propellers? You mean m' propellers did that?"
			)
			(16
				((ScriptID 2 1) init: 7 1 self) ; Adam, "He says every time he comes up to breathe, your boat runs into him."
			)
			(17
				(Fisherman init: 6 1 self) ; "Well, I'll be a land-lubber! What do I do about that?"
			)
			(18
				(if (== (gCurRoom script:) cageOnFisherman)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(19
				(SetFlag 34)
				(fisherman cycleSpeed: 12 setCycle: Fwd)
				(= cycles 1)
			)
			(20
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useSteelCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 11 1 self) ; Adam, "You wanna give me a hand with this, Gregarious?"
			)
			(1
				(Gregarious init: 7 1 self) ; "Sure, Adam."
			)
			(2
				(gEgo setMotion: PolyPath 142 149 self)
			)
			(3
				(Narrator init: 29 self) ; "Adam and Gregarious swim under the boat to attach the cage to the propellers."
			)
			(4
				(= cycles 5)
			)
			(5
				(manatee
					view: 241
					loop: 4
					cel: 4
					x: 71
					y: 171
					cycleSpeed: 14
					setCycle: Beg self
				)
				(gEgo
					setCycle: 0
					view: 811
					loop: 2
					cel: 3
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(6 0)
			(7
				(gEgo hide:)
				(= cycles 1)
			)
			(8
				(manatee hide:)
				(= cycles 1)
			)
			(9
				(INSET init:)
				(manatee
					show:
					view: 330
					loop: 1
					cel: 0
					cycleSpeed: 15
					posn: 149 132
					setPri: 14
					ignoreActors:
					setCycle: End self
				)
			)
			(10
				(gSoundEffects number: 334 loop: 1 play:)
				(gEgo
					setCycle: 0
					view: 330
					loop: 2
					cel: 0
					posn: 168 116
					cycleSpeed: 15
					setPri: 15
					ignoreActors:
					show:
					setCycle: End self
				)
			)
			(11
				(Narrator posn: -1 15 init: 1 self) ; "With Gregarious' help, Adam fits the steel cage over the propellers and fastens it on with the four screws."
			)
			(12
				(SetScore 5 299)
				(INSET dispose:)
				(manatee
					view: 241
					loop: 4
					x: 71
					y: 171
					cycleSpeed: 14
					setCycle: End self
				)
				(gEgo
					put: 10 335 ; bikeCage
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(13 0)
			(14
				(manatee
					view: 241
					loop: 3
					x: 71
					y: 171
					cycleSpeed: 23
					setCycle: Fwd
				)
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= cycles 3)
			)
			(15
				(Fisherman init: 9 1 self) ; "Oh! I see what yer talkin' about now. That cage jimmies right over them propellers, don't it?"
			)
			(16
				((ScriptID 2 1) init: 8 1 self) ; Adam, "Yup. Now you don't have to worry about the manatees."
			)
			(17
				(Fisherman init: 10 1 self) ; "Thanks, son. Yer not too bad fer a kid. Thanks fer makin' my boat safe. Guess I'll think about what youse said about the garbage dumpin'."
			)
			(18
				((ScriptID 2 1) init: 9 1 self) ; Adam, "Thanks! Bye now!"
			)
			(19
				(ClearFlag 43)
				(HandsOn)
				(gCurRoom newRoom: 341)
			)
		)
	)
)

(instance cantGoThatWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Narrator init: 2 self) ; "The ocean is a huge place. Adam should stick close to the boat or he might get lost."
			)
			(2
				(cond
					((== (gEgo edgeHit:) EDGE_LEFT)
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 5)
								(gEgo y:)
								self
						)
					)
					((== (gEgo edgeHit:) EDGE_RIGHT)
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 5)
								(gEgo y:)
								self
						)
					)
					((== (gEgo edgeHit:) EDGE_TOP)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 3)
								self
						)
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cageOnFisherman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 34)
					((ScriptID 2 1) init: 10 1 self) ; Adam, "You know, this cage is like the ones my Dad uses to cover the propellers on our lab boats. I bet it would work just as well on your propeller blades."
				else
					(self setScript: talkToFisherman self)
				)
			)
			(1
				(if (IsFlag 34)
					(= cycles 1)
				else
					((ScriptID 2 1) init: 12 1 self) ; Adam, "Well, this cage is like the ones my Dad uses to cover the propellers on our lab boats. I bet it would work just as well on your propeller blades."
				)
			)
			(2
				(Fisherman init: 16 1 self) ; "I'm not sure I'm gettin' ya, kid, but if youse wanta take a shot at tryin' it, I won't holler none."
			)
			(3
				(if (not (IsFlag 34))
					(HandsOn)
				)
				(= cycles 1)
			)
			(4
				(SetFlag 34)
				(self dispose:)
			)
		)
	)
)

(instance propeller of Feature
	(properties
		x 94
		y 157
		z 26
		nsTop 120
		nsLeft 77
		nsBottom 142
		nsRight 112
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 21) ; "The boat has a large motor attached to its stern. Judging from Gregarious' scars, the underwater blades are uncovered and are dangerously sharp! The motor is currently off."
			)
			(3 ; Do
				(Narrator init: 22) ; "Adam can't stop the propellers from hurting surface mammals by covering them up with his hands!"
			)
			(10 ; Recycle
				(Narrator init: 9) ; "Adam can't dispose of Gregarious' problem as easily as that!"
			)
			(4 ; Inventory
				(switch invItem
					(10 ; bikeCage
						(if (IsFlag 42)
							(if (IsFlag 34)
								(gCurRoom setScript: useSteelCage)
							else
								(Narrator init: 31) ; "Perhaps Adam should talk to the fisherman before making changes to his boat."
							)
						else
							(Narrator init: 4) ; "Good idea, but Adam needs some way to fasten the cage to the boat."
						)
					)
					(18 ; screws
						(Narrator init: 30) ; "If Adam wants to attach something to the propellers with the screws, he'll need to attach the screws to the object first."
					)
					(12 ; trident
						(Narrator init: 23) ; "Adam needs to make the propellers safe, not break them!"
					)
					(16 ; waterPump
						(Narrator init: 23) ; "Adam needs to make the propellers safe, not break them!"
					)
					(else
						(Narrator init: 24) ; "That won't make the propellers safe for surface-floating mammals."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rope of Feature
	(properties
		x 152
		y 118
		sightAngle 90
	)

	(method (onMe param1)
		(return
			(or
				(InRect 149 114 122 155 param1)
				(InRect 153 123 156 129 param1)
				(InRect 154 130 159 139 param1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 18) ; "The fishing boat is anchored."
			)
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't need to take the boat's anchor."
			)
			(4 ; Inventory
				(Narrator init: 20) ; "The boat's anchor is of no interest to Adam."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boat of PicView
	(properties
		x 65
		y 76
		view 323
		signal 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 13) ; "The boat that's terrorized Gregarious is only a little fishing vessel, but the danger its exposed propellers can create for surface-floating mammals is no small matter."
			)
			(3 ; Do
				(Narrator init: 7) ; "Adam is on a mission and has no desire to desert Eluria and ride away in the fisherman's boat."
			)
			(10 ; Recycle
				(Narrator init: 9) ; "Adam can't dispose of Gregarious' problem as easily as that!"
			)
			(4 ; Inventory
				(switch invItem
					(10 ; bikeCage
						(Narrator init: 3) ; "The cage will only be useful if put over the propellers."
					)
					(18 ; screws
						(Narrator init: 17) ; "If Adam wants to attach something to the boat with the screws, he'll need to attach the screws to the object first."
					)
					(else
						(Narrator init: 15) ; "That won't make the boat manatee-safe."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fisherman of Prop
	(properties
		x 139
		y 111
		view 328
		priority 8
		signal 4112
		cycleSpeed 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 28) ; "The fisherman has a face as tanned and wrinkled as old leather. Though he looks as tough and steady as a rock, he doesn't appear to be particularly unkind or spiteful."
			)
			(3 ; Do
				(Narrator init: 6) ; "The fisherman looks like a tough old guy and Adam's not sure he wants to tangle with him. Besides, there's got to be a better solution than that."
			)
			(5 ; Talk
				(if (not (IsFlag 34))
					(gCurRoom setScript: talkToFisherman)
				else
					(Fisherman init: 7 1) ; "Lemme know if you think of something to do with them propellers."
				)
			)
			(10 ; Recycle
				(Narrator init: 11) ; "While the fisherman is ecologically careless, he's hardly trash."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; bikeCage
						(gCurRoom setScript: cageOnFisherman)
					)
					(12 ; trident
						(Fisherman init: 12) ; "Nice stick, kid. Bit fancy fer my tastes, though."
					)
					(16 ; waterPump
						(Fisherman init: 13) ; "Found m' pump, did yer? Youses can keep it. I got me a new one last week and tossed that one 'ere on purpose."
					)
					(18 ; screws
						(Fisherman init: 15) ; "Them 'er screws alright."
					)
					(17 ; spine
						(Narrator init: 27) ; "Don't poison the fisherman! He may litter the oceans, but that's no reason to get nasty!"
					)
					(else
						(switch (Random 0 1)
							(0
								(Fisherman init: 11 self) ; "Cain't see how that there's gonna change the sitchiation none."
							)
							(1
								(Fisherman init: 8 self) ; "What the heck do I do with that?"
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ripples of Prop
	(properties
		x 143
		y 129
		onMeCheck 0
		view 323
		loop 1
		priority 2
		signal 20496
		cycleSpeed 18
		detailLevel 2
	)
)

(instance manatee of Prop
	(properties
		x 71
		y 171
		view 241
		loop 3
		signal 4096
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 25) ; "Gregarious eyes the boat warily - but at least he's no longer blue."
			)
			(3 ; Do
				(Narrator init: 8) ; "The manatee's skin is sensitive with all of the cuts. You'd better not touch him."
			)
			(5 ; Talk
				(Gregarious init: 6) ; "That's the boat right there <a-hyup>. Don't know what ya can do about it, but it sure does make ma life mis'rable."
			)
			(10 ; Recycle
				(Narrator init: 10) ; "Adam is here to help Gregarious, not insult him!"
			)
			(4 ; Inventory
				(switch invItem
					(10 ; bikeCage
						(Gregarious init: 3) ; "I'm not sure what ya want me ta do, Adam. Maybe ya could show me."
					)
					(18 ; screws
						(Gregarious init: 3) ; "I'm not sure what ya want me ta do, Adam. Maybe ya could show me."
					)
					(else
						(Gregarious init: 4) ; "That's real purty, Adam, but I'm not sure what ta do with it."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance INSET of View
	(properties
		x 91
		y 69
		view 330
		priority 13
		signal 16401
	)
)

(instance Gregarious of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 249
		viewInPrint 1
		charNum 7
		keepWindow 1
	)

	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of Prop
	(properties
		view 249
		cel 1
	)
)

(instance gEyes of Prop
	(properties
		nsTop 9
		nsLeft 9
		view 249
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of Prop
	(properties
		nsTop 12
		nsLeft 4
		view 249
		loop 1
		cycleSpeed 10
	)
)

(instance Fisherman of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 329
		viewInPrint 1
		charNum 9
		keepWindow 1
	)

	(method (init)
		(super init: fBust fEyes fMouth &rest)
	)
)

(instance fBust of Prop
	(properties
		view 329
		cel 1
	)
)

(instance fEyes of Prop
	(properties
		nsTop 15
		nsLeft 13
		view 329
		loop 2
		cycleSpeed 30
	)
)

(instance fMouth of Prop
	(properties
		nsTop 12
		nsLeft 4
		view 329
		loop 1
		cycleSpeed 10
	)
)

