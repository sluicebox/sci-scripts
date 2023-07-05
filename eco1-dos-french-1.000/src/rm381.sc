;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use Talker)
(use Language)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm381 0
	dolphin 3
)

(instance rm381 of EcoRoom
	(properties
		picture 901
		style -32759
		east 320
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(LoadMany rsVIEW 388 387 380 382 841 813)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 4 83 14 81 33 76 57 75 83 73 103 76 116 82 136 87 159 93 190 103 220 113 260 127 281 113 228 103 179 88 179 82 123 64 107 62 101 58 34 58 4 68
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 315 117 264 139 319 158 319 119
					yourself:
				)
		)
		(gFeatures
			add:
				bucket
				ladder
				panel
				fishNet
				cabinet
				cages
				boats
				garageDoor
				net
				wall
				lowerWall
				mat
				dock
				water
				safeArea
				pool
				poolFloor
				safeFood
				blackBoard
				starFish
			eachElementDo: #init
		)
		(SetFlag 70)
		(super init: &rest)
		(self picture: 380)
		(cond
			((== gPrevRoomNum 400)
				(self setScript: fromLab)
			)
			((== gPrevRoomNum 380)
				(self setScript: startUp)
			)
			(else
				(self setScript: fromOcean)
			)
		)
	)

	(method (notify)
		(self setScript: leaveRoom)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator posn: 160 20 init: 1 0 380) ; "The Lab has a specially designed room for treating stranded or injured animals."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((>= (gEgo x:) 315)
				(if (not (gEgo has: 9)) ; airTanks
					(self setScript: warnEgo)
				else
					(self setScript: leaveRoom)
				)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 380)
	)
)

(instance delphBackDrop of View
	(properties
		x 93
		y 50
		view 387
		loop 1
		priority 13
		signal 16400
	)
)

(instance outsideGate of Prop
	(properties
		x 245
		y 174
		lookStr 23
		view 396
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dolphinLever of Prop
	(properties
		x 217
		y 145
		lookStr 55
		view 380
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance labDoor of Prop
	(properties
		x 90
		y 56
		lookStr 21
		view 380
		signal 16384
		cycleSpeed 0
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 400)
			(self setCel: (self lastCel:))
		)
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 70))
			(switch theVerb
				(2 ; Look
					(Narrator init: lookStr 0 380)
				)
				(3 ; Do
					(gCurRoom setScript: toLab)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(Narrator posn: 160 20 init: 69 0 380) ; "Adam must go inside to do that."
		)
	)
)

(instance dockDoor of Prop
	(properties
		x 292
		y 128
		z 60
		approachX 271
		approachY 138
		lookStr 22
		view 380
		loop 2
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(3 ; Do
				(if (IsFlag 70)
					(gCurRoom setScript: inDockDoor)
				else
					(gCurRoom setScript: outDockDoor)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance outsideGateLever of Prop
	(properties
		x 212
		y 116
		approachX 204
		approachY 107
		lookStr 71
		view 380
		loop 3
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setCel: (self lastCel:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Inventory
				(Narrator posn: 160 20 init: 132 0 380) ; "The lever for the hatch is operated by hand. It's not necessary to use anything on the lever."
			)
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance insideGate of Prop
	(properties
		x 144
		y 142
		lookStr 54
		view 396
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setCel: (self lastCel:))
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bucket of Feature
	(properties
		x 104
		y 55
		onMeCheck 4
		approachX 104
		approachY 66
		lookStr 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				((ScriptID 2 1) init: lookStr 1 0 380) ; Adam
			)
			(3 ; Do
				((ScriptID 2 1) init: lookStr 1 0 380) ; Adam
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ladder of Feature
	(properties
		x 72
		y 42
		onMeCheck 2
		approachX 87
		approachY 80
		lookStr 18
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance starFish of Feature
	(properties
		x 234
		y 165
		nsTop 156
		nsLeft 204
		nsBottom 176
		nsRight 255
		onMeCheck 256
		approachX 317
		approachY 136
		lookStr 56
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 160 20 init: lookStr 0 380)
			)
			(3 ; Do
				(Narrator posn: 160 20 init: lookStr 0 380)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panel of Feature
	(properties
		x 6
		y 46
		nsTop 36
		nsBottom 68
		nsRight 20
		onMeCheck 16384
		approachX 10
		approachY 69
		lookStr 12
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator posn: 160 20 init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fishNet of Feature
	(properties
		x 29
		y 16
		nsTop 2
		nsLeft 21
		nsBottom 60
		nsRight 37
		onMeCheck 16384
		approachX 27
		approachY 66
		lookStr 15
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 152
		y 52
		nsTop 39
		nsLeft 130
		nsBottom 76
		nsRight 186
		onMeCheck 8192
		approachX 135
		approachY 74
		lookStr 62
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 70))
			(switch theVerb
				(2 ; Look
					(Narrator posn: 160 20 init: lookStr 0 380)
				)
				(3 ; Do
					(if (gEgo has: 9) ; airTanks
						(Narrator posn: 160 20 init: 60 0 380) ; "There's nothing more in the cabinet."
					else
						(gCurRoom setScript: (ScriptID 67 0)) ; lookAtCabinet
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(Narrator posn: 160 20 init: 69 0 380) ; "Adam must go inside to do that."
		)
	)
)

(instance cages of Feature
	(properties
		x 218
		y 74
		nsTop 78
		nsLeft 188
		nsBottom 102
		nsRight 235
		onMeCheck 16384
		approachX 201
		approachY 99
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 70))
			(switch theVerb
				(2 ; Look
					(gCurRoom setScript: (ScriptID 69 1) 0 -1) ; lookAtCage
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 69 1) 0 -1) ; lookAtCage
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(Narrator posn: 160 20 init: 69 0 380) ; "Adam must go inside to do that."
		)
	)
)

(instance boats of Feature
	(properties
		x 228
		y 59
		nsTop 13
		nsLeft 191
		nsBottom 103
		nsRight 279
		onMeCheck 8192
		approachX 201
		approachY 99
		lookStr 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(3 ; Do
				(Narrator init: 2 0 380) ; "The Lab uses the speedboats as little as possible. The gasoline really hurts the reef."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance garageDoor of Feature
	(properties
		x 228
		y 59
		nsLeft 209
		nsBottom 48
		nsRight 294
		onMeCheck 4096
		approachX 201
		approachY 99
		lookStr 63
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance net of Feature
	(properties
		x 127
		y 149
		nsTop 104
		nsLeft 39
		nsBottom 189
		nsRight 205
		onMeCheck 4096
		approachX 176
		approachY 93
		lookStr 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wall of Feature
	(properties
		x 222
		y 148
		nsLeft 125
		nsBottom 189
		nsRight 319
		onMeCheck 2048
		approachX 227
		approachY 107
		lookStr 65
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lowerWall of Feature
	(properties
		nsTop 149
		nsLeft 177
		nsBottom 149
		nsRight 265
		onMeCheck 1024
		approachX 227
		approachY 107
		lookStr 66
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of Feature
	(properties
		x 297
		y 125
		nsTop 117
		nsLeft 274
		nsBottom 138
		nsRight 317
		onMeCheck 16384
		approachX 313
		approachY 133
		lookStr 67
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
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
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(if (not (IsFlag 70))
					(if (not (IsFlag 113))
						(event claimed: 1)
						(dockDoor doVerb: 3)
					else
						(event claimed: 1)
						(ladder doVerb: 3)
					)
				else
					(super handleEvent: event &rest)
				)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance blackBoard of Feature
	(properties
		x 140
		y 37
		nsTop 2
		nsLeft 130
		nsBottom 49
		nsRight 196
		sightAngle 45
		onMeCheck 16384
		approachX 135
		approachY 74
	)

	(method (doVerb theVerb)
		(if (not (IsFlag 70))
			(switch theVerb
				(2 ; Look
					(gCurRoom setScript: (ScriptID 69 0) 0 -1) ; lookAtBlackBoard
				)
				(3 ; Do
					(gCurRoom setScript: (ScriptID 69 0) 0 -1) ; lookAtBlackBoard
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Narrator posn: 160 20 init: 69 0 380) ; "Adam must go inside to do that."
		)
	)
)

(instance safeFood of Feature
	(properties
		x 201
		y 127
		nsTop 117
		nsLeft 186
		nsBottom 135
		nsRight 221
		sightAngle 45
		onMeCheck 8192
		lookStr 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 160 20 init: lookStr 0 380)
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 58 0 380) ; "That's the dolphin's food. No one else should touch it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dock of Feature
	(properties
		x 315
		y 139
		nsTop 109
		nsLeft 248
		nsBottom 169
		nsRight 319
		onMeCheck 4096
		approachX 315
		approachY 139
		lookStr 25
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
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
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(if (not (IsFlag 70))
					(if (not (IsFlag 113))
						(event claimed: 1)
						(dockDoor doVerb: 3)
					else
						(event claimed: 1)
						(ladder doVerb: 3)
					)
				else
					(super handleEvent: event &rest)
				)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(3 ; Do
				(Narrator init: 27 0 380) ; "The docks are in good repair."
			)
			(5 ; Talk
				(dolphin doVerb: 5)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poolFloor of Feature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck 64
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not (event modifiers:))
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
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(IsFlag 70)
				)
				(event claimed: 1)
				(dockDoor doVerb: 3)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb)
		(gCurRoom doVerb: &rest)
	)
)

(instance water of Feature
	(properties
		nsTop 150
		nsLeft 266
		nsBottom 189
		nsRight 319
		onMeCheck 16384
		approachX 313
		approachY 133
		lookStr 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeArea of Feature
	(properties
		x 158
		y 159
		nsTop 120
		nsLeft 62
		nsBottom 189
		nsRight 227
		onMeCheck 512
		approachX 228
		approachY 109
		lookStr 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dolphin of Actor
	(properties
		x 160
		y 97
		lookStr 68
		view 387
		loop 7
		priority 14
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr 0 380)
			)
			(5 ; Talk
				((ScriptID 2 0) init: 33 1 0 380) ; Delphineus, "Adam, hurry up, I'm really worried and need to get going!"
			)
			(4 ; Inventory
				((ScriptID 2 0) init: 36 1 0 380) ; Delphineus, "C'mon Adam. I gotta go. I can't play now!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pool of Feature
	(properties
		x 67
		y 117
		nsTop 83
		nsBottom 189
		nsRight 188
		onMeCheck 256
		approachX 62
		approachY 66
		lookStr 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Narrator init: lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tFrisbee of PicView
	(properties
		z 100
		view 380
		loop 5
		priority 1
		signal 16400
	)

	(method (init)
		(self x: global120 y: global121)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 160 20 init: 96 0 380) ; "A green frisbee sits on the floor. Maybe Adam should practice catching!"
			)
			(3 ; Do
				(Narrator posn: 160 20 init: 116 0 380) ; "Adam doesn't need that anymore. The dolphin has lost interest in frisbee."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 250])
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 106)
				(= cycles 1)
			)
			(1
				(proc932_8 99 380 83 @temp0)
				(= register
					(Display
						@temp0
						dsCOORD
						5
						85
						dsALIGN
						alCENTER
						dsWIDTH
						310
						dsCOLOR
						global207
						dsFONT
						6
						dsSAVEPIXELS
					)
				)
				(= seconds 7)
			)
			(2
				(Display {} dsRESTOREPIXELS register)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(gCurRoom drawPic: 380)
				(gLongSong2 number: 391 loop: -1 play:)
				(gEgo
					view: 387
					init:
					loop: 0
					cel: 0
					setPri: -1
					posn: 288 146
					cycleSpeed: 20
					setCycle: Fwd
				)
				(if (== ((gInventory at: 6) owner:) 380) ; frisbee
					(tFrisbee init:)
					(gAddToPics doit:)
				)
				(= seconds 4)
			)
			(3
				(Narrator init: 84 self 380) ; "A familiar figure appears on the horizon."
			)
			(4
				(delphBackDrop init:)
				(= seconds 2)
			)
			(5
				(returningSound number: 383 loop: -1 play: 37 fade: 52 40 5 0)
				(dolphin init: setCycle: End)
				(= seconds 2)
			)
			(6
				(returningSound fade: 67 40 5 0)
				(dolphin loop: 6 cel: 0 posn: 160 99 setCycle: End)
				(= seconds 2)
			)
			(7
				(returningSound fade: 82 40 5 0)
				(dolphin loop: 5 cel: 0 posn: 160 101 setCycle: End)
				(= seconds 2)
			)
			(8
				(returningSound fade: 97 40 5 0)
				(dolphin loop: 4 cel: 0 posn: 160 105 setCycle: End)
				(= seconds 2)
			)
			(9
				(returningSound fade: 112 40 5 0)
				(dolphin loop: 3 cel: 0 posn: 146 112 setCycle: End)
				(= seconds 2)
			)
			(10
				(returningSound fade: 127 40 5 0)
				(dolphin loop: 2 cel: 0 posn: 174 114 setCycle: End)
				(= seconds 2)
			)
			(11
				(dolphin loop: 8 cel: 0 posn: 158 136 setCycle: End self)
			)
			(12
				(gSoundEffects number: 916 loop: 1 play:)
				(= seconds 2)
			)
			(13
				(returningSound fade:)
				(gLongSong number: 386 loop: -1 play:)
				(dolphin
					view: 382
					loop: 6
					cel: 0
					posn: 285 283 100
					setCycle: Fwd
					cycleSpeed: 20
				)
				(delphBackDrop dispose:)
				(gEgo loop: 9 cel: 0 setCycle: End self)
			)
			(14
				((ScriptID 2 1) init: 11 0 self 380) ; Adam, "Delphineus! I'm so glad to see you! I've been wondering what happened to you all week."
			)
			(15
				((ScriptID 2 1) init: 12 1 self 380) ; Adam, "Did you find your missing king?"
			)
			(16
				((ScriptID 2 0) init: 17 1 self 380) ; Delphineus, "No, things are worse than ever...Gotta catch my breath."
			)
			(17
				((ScriptID 2 1) init: 13 1 self 380) ; Adam, "Slow down. Take your time. What do you mean?"
			)
			(18
				((ScriptID 2 0) init: 18 1 self 380) ; Delphineus, "Strange things are happening in the kingdom, oh, it's too hard to explain! If only you could see it!"
			)
			(19
				((ScriptID 2 1) init: 14 1 self 380) ; Adam, "Well, I could see it. I'll just go back there with you!"
			)
			(20
				((ScriptID 2 0) init: 19 1 self 380) ; Delphineus, "You! A human? You must be joking! Human lungs could never last where we'd be going!"
			)
			(21
				(if (gEgo has: 9) ; airTanks
					((ScriptID 2 1) init: 15 1 self 380) ; Adam, "I could so! I'm checked out on all the new diving equipment. Say it's O.K, c'mon!"
				else
					((ScriptID 2 0) init: 21 1 self 380) ; Delphineus, "You'll have to get ready, Adam, before I could even consider it!"
				)
			)
			(22
				(if (gEgo has: 9) ; airTanks
					((ScriptID 2 0) init: 20 1 self 380) ; Delphineus, "Hmmm, well, they did say 'Bring help!' Okay, I'll take the responsibility. Come on!"
				else
					(= ticks 3)
				)
			)
			(23
				(NormalEgo 5)
				(gEgo
					posn: 279 149
					setPri: 10
					setMotion: MoveTo 294 142 self
				)
			)
			(24
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inDockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 70)
				(gEgo setMotion: PolyPath 272 131 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 380 loop: 7 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(dockDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(NormalEgo 3)
				(dockDoor setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 289 130 self)
			)
			(6
				(gEgo setPri: -1 setMotion: MoveTo 236 110 self)
			)
			(7
				(gLongSong2 fade: 0 10 25 1)
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor setCycle: Beg self)
			)
			(8
				(dockDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outDockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 271 138 self)
			)
			(1
				(SetFlag 70)
				(gSoundEffects number: 901 loop: 1 play:)
				(gLongSong2 number: 391 loop: -1 play: 0 fade: 127 10 25 0)
				(dockDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 307 136 self)
			)
			(3
				(gEgo setPri: 11)
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor setCycle: Beg self)
			)
			(4
				(dockDoor stopUpd:)
				(if (== client gCurRoom)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance toLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 53 63 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gSoundEffects number: 901 loop: 1 play:)
				(gEgo view: 380 loop: 6 cel: 0 setCycle: CT 1 1 self)
				(labDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(labDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(labDoor setCycle: End)
				(NormalEgo 6)
				(gEgo setMotion: MoveTo 73 61 self)
			)
			(5
				(gEgo setMotion: MoveTo 73 41 self)
			)
			(6
				(labDoor stopUpd:)
				(gCurRoom newRoom: 400)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance warnEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 0) init: 21 1 self 380) ; Delphineus, "You'll have to get ready, Adam, before I could even consider it!"
			)
			(1
				(gEgo setMotion: MoveTo 298 134 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromOcean of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(gCurRoom drawPic: 380)
				(gEgo init: get: 8 posn: 334 141) ; scubaGear
				(dolphin
					view: 382
					loop: 6
					init:
					cel: 0
					posn: 285 283 100
					setCycle: Fwd
					cycleSpeed: 20
				)
				(NormalEgo 7)
				(SetFlag 70)
				(if (== ((gInventory at: 6) owner:) 380) ; frisbee
					(tFrisbee init:)
					(gAddToPics doit:)
				)
				(= cycles 1)
			)
			(1
				(self setScript: takeGearOff self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(gCurRoom drawPic: 380)
				(gEgo init: posn: 73 71)
				(NormalEgo 2)
				(ClearFlag 70)
				(dolphin
					view: 382
					loop: 6
					init:
					cel: 0
					posn: 285 183
					setCycle: Fwd
					cycleSpeed: 20
				)
				(if (== ((gInventory at: 6) owner:) 380) ; frisbee
					(tFrisbee init:)
					(gAddToPics doit:)
				)
				(gLongSong number: 386 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(gSoundEffects number: 902 loop: 1 play:)
				(labDoor startUpd: setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 5 242)
				(if (gEgo has: 0) ; sodaCan
					(SetFlag 214)
				)
				(gEgo
					put: 0 ; sodaCan
					put: 1 ; certificate
					put: 2 ; card
					put: 4 ; rag
					put: 5 ; dishSoap
					put: 6 360 ; frisbee
					put: 7 ; mackeral
					put: 34 ; waterBottle
					put: 8 ; scubaGear
				)
				(Narrator init: 118 self 380) ; "Adam empties his pockets."
			)
			(1
				(if (not (IsFlag 70))
					(self setScript: outDockDoor self)
				else
					(= ticks 3)
				)
			)
			(2
				(self setScript: getGearOn self)
			)
			(3
				(gCurRoom newRoom: 320)
				(self dispose:)
			)
		)
	)
)

(instance getGearOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 298 154 self)
			)
			(1
				(gEgo
					view: 387
					loop: 9
					cel: 6
					cycleSpeed: 15
					setCycle: Beg self
				)
			)
			(2
				(gEgo view: 376 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 376 loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 376 loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 376 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(Narrator init: 130 self 380) ; "He puts on his fins, gloves, and mask and jumps into the water."
			)
			(7
				(gEgo
					view: 376
					loop: 4
					cel: 0
					posn: 275 141
					setCycle: CT 6 1 self
				)
			)
			(8
				(gSoundEffects number: 398 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo hide:)
				(self dispose:)
			)
		)
	)
)

(instance takeGearOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 376
					setLoop: 5
					cel: 0
					setCycle: Walk
					posn: 334 153
					setMotion: MoveTo 298 154 self
				)
			)
			(1
				(gEgo
					cycleSpeed: 15
					setLoop: -1
					loop: 0
					cel: 6
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 376
					loop: 3
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 376
					loop: 2
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					view: 376
					loop: 1
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(gEgo view: 387 loop: 9 cel: 0 setCycle: End self)
			)
			(6
				(NormalEgo 5)
				(gEgo
					posn: 288 146
					setPri: 11
					setMotion: MoveTo 298 134 self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance returningSound of Sound
	(properties)
)

