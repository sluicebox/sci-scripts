;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm880 0
)

(local
	enteredCode
	correctDoor
)

(instance rm880 of LLRoom
	(properties
		lookStr {The studio floor of the K-RAP building is far underground, filled with soundproof studios and playback speakers. A large fountain, complete with giant bronze sculptures, fills the center of the room.}
		picture 880
		east 890
		west 870
	)

	(method (init)
		(LoadMany rsVIEW 872 880 882 883)
		(LoadMany rsSOUND 800 801 802)
		(gEgo init: normalize: 872 actions: ActionsKRAP illegalBits: 2)
		(switch gPrevRoomNum
			(west
				(HandsOn)
				(= style 12)
			)
			(east
				(gEgo posn: 250 127 setHeading: 270 edgeHit: EDGE_NONE)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(doorA init: approachVerbs: 3 2) ; Do, Look
		(doorB init: approachVerbs: 3 2) ; Do, Look
		(doorC init: approachVerbs: 3 2) ; Do, Look
		(windowA init:)
		(windowB init:)
		(windowC init:)
		(keypadA init: approachVerbs: 3 2) ; Do, Look
		(keypadB init: approachVerbs: 3 2) ; Do, Look
		(keypadC init: approachVerbs: 3 2) ; Do, Look
		(PChammer init: setCycle: RandCycle cycleSpeed: 12)
		(movingSignA init: setCycle: Fwd cycleSpeed: 12)
		(gCast eachElementDo: #checkDetail)
		(mikeStand init:)
		(statue init:)
		(recSignA init:)
		(recSignB init:)
		(gAddToPics doit:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 133 85 138 141 148 188 166 216 187 316 187 316 171 268 132 251 120 238 116 210 116 207 124 163 124 175 109 139 76 68 76 65 72 54 82 15 116 0 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 91 109 97 105 120 105 124 112 117 120 97 120
					yourself:
				)
		)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(if enteredCode
					(gEgo edgeHit: EDGE_TOP)
					(gCurRoom newRoom: (gCurRoom east:))
				else
					(TPrint 880 0) ; "It's locked."
				)
			)
		)
	)

	(method (notify codeNumber)
		(if (and (OneOf codeNumber gRoomBNumber -2) (== correctDoor 1))
			(doorB locked: 0)
			(= correctDoor 0)
			(TPrint 880 1) ; "You hear the door's lock click."
		else
			(TPrint 880 2) ; "You hear no sound from the door. That must not have been the correct number."
		)
		(HandsOn)
	)
)

(instance doorA of Door
	(properties
		x 47
		y 77
		description {the door to Control Room A}
		sightAngle 40
		approachX 64
		approachY 80
		lookStr {This door leads to Control Room A. You can see a man working inside.}
		view 880
		loop 1
		locked 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 880 3) ; "You really don't want to open this door. Your mission is to NOT get caught!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance doorB of Door
	(properties
		x 200
		y 111
		description {the Control Room B door}
		sightAngle 40
		approachX 218
		approachY 130
		lookStr {This door leads to Control Room B, which appears to be empty.}
		view 880
		loop 2
		entranceTo 890
		locked 1
		moveToX 220
		moveToY 116
		enterType 0
		exitType 0
	)
)

(instance doorC of Feature
	(properties
		x 265
		y 94
		nsTop 57
		nsLeft 257
		nsBottom 131
		nsRight 274
		description {the Control Room C door}
		sightAngle 40
		approachX 260
		approachY 100
		lookStr {This door leads to Control Room C. It appears to be unoccupied at the moment.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 880 3) ; "You really don't want to open this door. Your mission is to NOT get caught!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance keypadA of Feature
	(properties
		x 60
		y 39
		nsTop 31
		nsLeft 55
		nsBottom 47
		nsRight 65
		description {the keypad}
		sightAngle 40
		approachX 64
		approachY 80
		lookStr {Each of the doors has a keypad to limit access to only those with authorization. This keypad controls access to Control Room A.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				((ScriptID 20 0) init: 0 rm880) ; TTDialer
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance keypadB of Feature
	(properties
		x 239
		y 81
		nsTop 74
		nsLeft 232
		nsBottom 89
		nsRight 246
		description {the keypad}
		sightAngle 40
		approachX 238
		approachY 115
		lookStr {Each of the doors has a keypad to limit access to only those with authorization. This keypad controls access to Control Room B.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(= correctDoor 1)
				((ScriptID 20 0) init: 0 rm880) ; TTDialer
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance keypadC of Feature
	(properties
		x 254
		y 85
		nsTop 74
		nsLeft 248
		nsBottom 95
		nsRight 257
		description {the keypad}
		sightAngle 40
		approachX 260
		approachY 100
		lookStr {Each of the doors has a keypad to limit access to only those with authorization. This keypad controls access to Control Room C.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				((ScriptID 20 0) init: 0 rm880) ; TTDialer
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance windowA of Feature
	(properties
		x 122
		y 41
		nsTop 29
		nsLeft 116
		nsBottom 53
		nsRight 128
		description {the window of Control Room A}
		sightAngle 40
		lookStr {Through this window you can see Control Room A.}
	)
)

(instance windowB of Feature
	(properties
		x 161
		y 59
		nsTop 39
		nsLeft 146
		nsBottom 79
		nsRight 176
		description {the window of Control Room B}
		sightAngle 40
		lookStr {Through this window you can see Control Room B. It appears to be currently unoccupied.}
	)
)

(instance windowC of Feature
	(properties
		x 303
		y 111
		nsTop 74
		nsLeft 287
		nsBottom 148
		nsRight 319
		description {the window of Control Room C}
		sightAngle 40
		lookStr {Through this window you can see Control Room C. It appears to be currently unoccupied.}
	)
)

(instance statue of Feature
	(properties
		x 99
		y 106
		nsTop 24
		nsBottom 189
		nsRight 198
		description {the statue}
		sightAngle 40
		onMeCheck 16384
		lookStr {How impressive! K-RAP has a fountain filled with a huge statue of the Queen of Rock 'n' Roll--Connie Stevens!}
	)
)

(instance recSignA of Feature
	(properties
		x 100
		y 26
		nsTop 24
		nsLeft 73
		nsBottom 29
		nsRight 128
		description {the recording sign}
		sightAngle 40
		lookStr {This sign is illuminated when Control Room A is recording.}
	)
)

(instance recSignB of Feature
	(properties
		x 162
		y 36
		nsTop 24
		nsLeft 144
		nsBottom 48
		nsRight 181
		description {the recording sign}
		sightAngle 40
		lookStr {This sign is illuminated when Control Room B is recording.}
	)
)

(instance movingSignA of Prop
	(properties
		x 75
		y 28
		description {the recording sign}
		lookStr {Control Room A's recording indicator lamp is presently on.}
		view 880
		loop 4
		priority 15
		signal 16
		detailLevel 3
	)
)

(instance PChammer of Actor
	(properties
		x 90
		y 67
		description {P. C. Hammer}
		view 883
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 880 4) ; "P. C. Hammer is the man Desmond says is linked to much of the evil doings here at K-RAP radio!"
				(TPrint 880 5) ; "It's a good thing your disguise is working out so well. You certainly wouldn't want him to notice you."
			)
			(5 ; Talk
				(TPrint 880 6) ; "You may wish to talk with P. C. Hammer later, but now is not the time."
			)
			(3 ; Do
				(TPrint 880 7) ; "Stay away from the window, in case P. C. realizes you're not the woman you seem to be."
			)
			(10 ; Zipper
				(TPrint 880 8) ; "Patti! Is that all you have on your mind?"
				(TPrint 880 9 67 -1 185) ; "(Although he IS kind of cute!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mikeStand of PicView
	(properties
		x 175
		y 121
		description {the microphone stand}
		view 880
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 880 10) ; "A large, heavy microphone stand waits for a gig."
			)
			(3 ; Do
				(TPrint 880 11) ; "You really have no use for a microphone stand."
				(TPrint 880 12 67 -1 185) ; "(Especially one that must weigh a ton!)"
			)
			(10 ; Zipper
				(TPrint 880 13) ; "Patti!"
				(TPrint 880 14 67 -1 185) ; "(Besides, wouldn't that steel be cold!?)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
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
				(TPrint 880 15) ; "You attempt to hike up those Hammerpants you're wearing, but it does no good!"
				(return 1)
			)
			(10 ; Zipper
				(TPrint 880 16) ; "Maintaining your cool, you surreptitiously check the zipper on your giant baggy pants. It's fine."
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

