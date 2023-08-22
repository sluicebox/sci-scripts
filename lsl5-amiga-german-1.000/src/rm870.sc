;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use eRS)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm870 0
)

(instance rm870 of LLRoom
	(properties
		picture 870
		east 880
	)

	(method (init)
		(LoadMany rsVIEW 870 871 872 873)
		(LoadMany rsSOUND 853 800 801 802)
		(switch gPrevRoomNum
			(east
				(HandsOn)
				(= style 11)
				(gEgo init: actions: ActionsKRAP edgeHit: EDGE_LEFT normalize: 872)
				(elevator init: setPri: -1 addToPic:)
				(eDoor init: setPri: -1 addToPic:)
				(elevatorSide init: setPri: -1 addToPic:)
				(gAddToPics doit:)
				(door init: approachVerbs: 3) ; Do
				(keypad init: approachVerbs: 3 2) ; Do, Look
				(studioARoom init:)
				(studioBRoom init:)
				(studioCRoom init:)
				(elevatorKeypad init: approachVerbs: 3 2) ; Do, Look
			)
			(else
				(HandsOn)
				(SetFFRoom 0)
				(gEgo init: normalize: 873 hide:)
				(door init:)
				(keypad init:)
				(studioARoom init:)
				(studioBRoom init:)
				(studioCRoom init:)
				(elevatorKeypad init:)
				(self setScript: goingDownScript)
			)
		)
		(statue init:)
		(dude1 init: setCycle: RandCycle)
		(dude2 init: setCycle: RandCycle)
		(dude3 init: setCycle: RandCycle)
		(super init:)
		(clothesRack init:)
		(gAddToPics doit:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 100 293 100 256 63 201 63 173 100 124 101 104 134 92 133 76 134 64 134 54 146 90 146 73 168 44 179 24 174 11 187 135 187 151 176 186 162 235 153 319 153 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 197 116 204 110 228 110 234 114 225 122 204 122
					yourself:
				)
		)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 0) ; "The studio floor of the K-RAP building is far underground, filled with soundproof studios and playback speakers. A large fountain, complete with giant bronze sculptures, fills the center of the room."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)

	(method (notify)
		(TPrint 870 1) ; "You hear no sound from the door. That must not have been the correct number."
		(HandsOn)
	)
)

(instance clothesRack of PicView
	(properties
		x 68
		y 158
		description {the clothes rack}
		view 870
		cel 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 2) ; "What a break! A clothing rack stands right beside your elevator."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance keypad of Feature
	(properties
		x 231
		y 35
		nsTop 29
		nsLeft 227
		nsBottom 41
		nsRight 235
		description {the keypad}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 3) ; "This keypad is similar to those upstairs. Unfortunately, you don't know the combination to this one."
			)
			(3 ; Do
				(if (!= (gEgo view:) 873)
					((ScriptID 20 0) init: 0 rm870) ; TTDialer
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance studioARoom of Feature
	(properties
		x 180
		y 46
		nsTop 28
		nsLeft 171
		nsBottom 64
		nsRight 190
		description {Studio A}
		sightAngle 40
	)

	(method (doVerb)
		(dude1 doVerb: &rest)
	)
)

(instance door of Feature
	(properties
		x 245
		y 42
		nsTop 24
		nsLeft 235
		nsBottom 60
		nsRight 255
		description {the studio door}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 4) ; "This door leads to K-RAP's Studio B."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance studioBRoom of Feature
	(properties
		x 203
		y 37
		nsTop 24
		nsLeft 198
		nsBottom 51
		nsRight 208
		description {Studio B}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 5) ; "This is K-RAP's Studio B."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance studioCRoom of Feature
	(properties
		x 278
		y 42
		nsTop 23
		nsLeft 268
		nsBottom 62
		nsRight 288
		description {Studio C}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 6) ; "This is K-RAP's Studio C."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance statue of Feature
	(properties
		x 217
		y 1
		nsTop 20
		nsLeft 116
		nsBottom 189
		nsRight 319
		description {the statue}
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 7) ; "How impressive! K-RAP has a fountain filled with a huge statue of the King of Rock 'n' Roll--Barry Manilow!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance elevatorKeypad of Feature
	(properties
		x 9
		y 157
		nsTop 138
		nsLeft 4
		nsBottom 157
		nsRight 15
		description {the elevator keypad}
		sightAngle 40
		approachX 20
		approachY 180
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 8) ; "This keypad is similar to those upstairs. Unfortunately, you don't know the combination to this one."
			)
			(3 ; Do
				(TPrint 870 9) ; "Since you have no way of knowing John Krapper's personal elevator's access code, it appears you are trapped down here forever!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance clothes of View
	(properties
		x 68
		y 179
		z 20
		description {the clothes}
		sightAngle 40
		approachX 56
		approachY 162
		view 870
		cel 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 10) ; "A set of brightly-colored, over-sized rapper's clothes hangs on the clothes rack, conveniently placed near the elevator."
			)
			(3 ; Do
				(if (== (gEgo view:) 873)
					(gEgo setScript: getClothesScript)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dude1 of Prop
	(properties
		x 142
		y 71
		description {that "2 Live 2 Screw" dude}
		view 870
		loop 2
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 870 11) ; "Inside Studio A, the members of "2 Live 2 Screw" are carrying on a lively discussion. If only you could hear their conversation."
			)
			(3 ; Do
				(TPrint 870 12) ; "You are unable to hear those dudes through the soundproof glass."
			)
			(10 ; Zipper
				(TPrint 870 13) ; "Patti! You have no interest whatsoever in these guys!"
			)
			(4 ; Inventory
				(TPrint 870 14) ; "They can't hear your offer, and wouldn't be willing to deal with you anyway!"
			)
			(else
				(TPrint 870 15) ; "If only you could find some way to overhear their conversation."
			)
		)
	)
)

(instance dude2 of Prop
	(properties
		x 134
		y 68
		description {that "2 Live 2 Screw" dude}
		view 870
		loop 3
		cycleSpeed 10
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(dude1 doVerb: theVerb invItem)
	)
)

(instance dude3 of Prop
	(properties
		x 150
		y 63
		description {that "2 Live 2 Screw" dude}
		view 870
		loop 4
		cycleSpeed 8
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(dude1 doVerb: theVerb invItem)
	)
)

(instance elevator of View
	(properties
		x 44
		y 171
		description {the showervator}
		view 870
		priority 8
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 870 16) ; "You are far too familiar with the "showervator" already! You hope that somehow, some way, you'll be able to find your way back up to Krapper's office and to your own clothes!"
			)
			(3 ; Do
				(TPrint 870 17) ; "From down here, Mr. Krapper's private elevator requires his personal access number through the keypad to the left."
			)
			(10 ; Zipper
				(TPrint 870 18) ; "While you might want to undress and re-enter the shower, you can't, as the elevator door is now firmly locked."
			)
			(4 ; Inventory
				(TPrint 870 19) ; "That doesn't seem to unlock the shower door."
			)
			(else
				(TPrint 870 20) ; "The showervator is off-limits to you at the moment."
			)
		)
	)
)

(instance eDoor of Prop
	(properties
		x 44
		y 171
		description {the showervator}
		view 870
		loop 1
		priority 15
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(elevator doVerb: theVerb invItem)
	)
)

(instance elevatorSide of View
	(properties
		x 44
		y 171
		description {the showervator}
		view 870
		cel 1
		priority 15
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(elevator doVerb: theVerb invItem)
	)
)

(instance elevatorWithPatti of Actor
	(properties
		x 44
		y 5
		description {your naked body}
		view 870
		loop 5
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 870 21) ; "Down you come!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance goingDownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheMusic setVol: gLastVolume)
				(clothes init: setPri: 12)
				(elevatorWithPatti
					init:
					setLoop: 5
					setCel: 0
					moveSpeed: 3
					setMotion: MoveTo 44 171 self
				)
			)
			(1
				(gTheMusic2 release:)
				(= ticks 30)
			)
			(2
				(elevatorWithPatti dispose:)
				(elevator init: setPri: 12 stopUpd:)
				(eDoor init: setPri: -1 stopUpd:)
				(elevatorSide init: setPri: -1 stopUpd:)
				(gEgo
					show:
					x: 37
					y: 183
					z: 20
					setLoop: 4
					setCel: 0
					setPri: 12
					actions: ActionsKRAP
				)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance getClothesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(eDoor startUpd: setCel: 0)
				(= seconds 3)
			)
			(1
				(TPrint 870 22) ; "Checking as much of the downstairs as you can see, you make sure that no one is coming. Cautiously leaning out of the showervator, you grab the set of clothes conveniently hanging on the nearby clothes rack."
				(= seconds 3)
			)
			(2
				(eDoor setCycle: End self)
			)
			(3
				(gEgo
					x: 43
					y: 166
					z: 0
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 56 162 self
				)
			)
			(4
				(Points 1 153)
				(clothes hide:)
				(gEgo
					view: 871
					setLoop: 0
					setCel: 0
					x: 69
					y: 160
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(gEgo
					normalize: 872
					x: 56
					y: 162
					loop: 0
					setMotion: MoveTo 78 166 self
				)
			)
			(6
				(TPrint 870 23) ; "Wow! Look at you! It's the all-new, all-what's-happenin' "Rappin' Patti P!!""
				(TPrint 870 24) ; "With that outfit and your impromptu copier make-up job, you're all set to blend right in down here!"
				(eDoor setCycle: Beg self)
			)
			(7
				(eDoor setPri: -1 stopUpd:)
				(gTheIconBar enable: 0)
				(door approachVerbs: 3) ; Do
				(keypad approachVerbs: 3 2) ; Do, Look
				(elevatorKeypad approachVerbs: 3 2) ; Do, Look
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)

	(method (doit)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 873)
					(TPrint 870 25) ; "You briefly consider doing what you often do when you're in the shower, but soon decide this is neither the time nor the place."
					(return 1)
				else
					(TPrint 870 26) ; "You attempt to hike up those Hammerpants you're wearing, but it does no good!"
					(return 1)
				)
			)
			(10 ; Zipper
				(if (== (gEgo view:) 873)
					(TPrint 870 25) ; "You briefly consider doing what you often do when you're in the shower, but soon decide this is neither the time nor the place."
					(return 1)
				else
					(TPrint 870 27) ; "Maintaining your cool, you surreptitiously check the zipper on your giant pants. It's fine."
					(return 1)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

