;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm435 0
)

(instance rm435 of LLRoom
	(properties
		picture 430
		north 425
		east 445
	)

	(method (init)
		(gEgo init: normalize: 570)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE)
				(gTheMusic2 number: 436 loop: -1 play:)
			)
			(east
				(HandsOn)
				(self style: 11)
			)
			(west
				(gEgo edgeHit: EDGE_NONE)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(northDoor init: stopUpd:)
		(if (not (gEgo has: 13)) ; Credit_Cards
			(hooterShooter init: stopUpd: approachVerbs: 3) ; Do
		)
		(door init:)
		(dartboard init:)
		(northBank init:)
		(southBank init:)
		(monitors init:)
		(plug init:)
		(outlet init:)
		(chair init:)
		(joystick init:)
		(circuitboard init:)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 116 0 116 69 116 80 89 80 9 131 107 131 111 128 190 128 190 136 283 136 294 147 319 147 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 124 0 319 0 319 99 138 99 138 80 124 80
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 0) ; "Although you haven't really thought about, this isn't what you would have pictured an F.B.I. lab to be."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber (gCurRoom north:))
			(gTheMusic2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sGetBra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 441
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(Points 6 100)
				(hooterShooter dispose:)
				(gEgo get: 13 setCycle: End self) ; Credit_Cards
			)
			(2
				(gEgo normalize:)
				(= ticks 67)
			)
			(3
				(TPrint 435 1) ; "You take the double-barreled brassiere from the workbench. It smells strongly of fresh gunpowder."
				(= seconds 3)
			)
			(4
				(TPrint 435 2 #at -1 185) ; "(You hope they lowered the size of the charge!)"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		x 106
		y 77
		description {the exterior door}
		approachX 126
		approachY 85
		view 430
		entranceTo 425
		moveToX 120
		moveToY 75
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 3) ; "This door leads to the street outside."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hooterShooter of View
	(properties
		x 271
		y 96
		z 22
		description {the brassiere cannon}
		sightAngle 40
		approachX 261
		approachY 99
		view 430
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 4) ; "It appears the F.B.I. technician left his bra lying on the workbench!"
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetBra)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 23
		y 80
		nsTop 47
		nsLeft 5
		nsBottom 114
		nsRight 42
		description {Desmond's door}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 5) ; "This door leads to Inspector Desmond's office. It is presently locked."
			)
			(3 ; Do
				(TPrint 435 6) ; "You decide that it wouldn't be a very good idea to try to open your new boss' private office--especially when he's locked the door."
			)
			(5 ; Talk
				(TPrint 435 7) ; "Hey, Desmond!" you cry. "Are you in there?"
				(TPrint 435 8 #at -1 185) ; "(Evidently not!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dartboard of Feature
	(properties
		x 64
		y 91
		z 40
		nsTop 37
		nsLeft 54
		nsBottom 65
		nsRight 75
		description {the dart board}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 9) ; "It is easy to see that F.B.I. employees don't always score!"
			)
			(3 ; Do
				(TPrint 435 10) ; "This dart board is here only for the amusement of the full-time, salaried employees."
				(TPrint 435 11 #at -1 185 #width 280) ; "(Besides, you've never played darts in your life, and you don't intend to begin now!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance northBank of Feature
	(properties
		x 234
		y 89
		z 55
		nsTop 1
		nsLeft 155
		nsBottom 77
		nsRight 319
		description {the laboratory tables}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 12) ; "These tables are filled with highly-expensive scientific equipment, all paid for with your tax dollars!"
			)
			(3 ; Do
				(TPrint 435 13) ; "You really shouldn't mess around with the F.B.I.'s equipment."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 125
		nsTop 118
		nsBottom 189
		nsRight 319
		description {the laboratory tables}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 14) ; "These tables are filled with highly-expensive scientific equipment, all paid for with your tax dollars!"
			)
			(3 ; Do
				(TPrint 435 15) ; "You really shouldn't mess around with the F.B.I.'s equipment."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance monitors of Feature
	(properties
		x 190
		y 90
		z 49
		nsTop 24
		nsLeft 164
		nsBottom 59
		nsRight 216
		description {the monitors}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 16) ; "These monitors are presently disconnected. When they were heavily used many years ago, it was only to play "Jawbreaker!""
			)
			(3 ; Do
				(TPrint 435 17) ; "You try to turn on the monitor, but are unable to do so."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plug of Feature
	(properties
		x 83
		y 118
		z 100
		nsTop 3
		nsLeft 71
		nsBottom 33
		nsRight 96
		description {the giant plug}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 18) ; "You wonder exactly what that giant plug plugs into."
			)
			(3 ; Do
				(TPrint 435 19) ; "What? And get electrocuted?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 147
		y 77
		z 27
		nsTop 43
		nsLeft 142
		nsBottom 57
		nsRight 152
		description {the intercom}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 20) ; "The lab technicians use this intercom to communicate with the front office and Commander Twit."
			)
			(3 ; Do
				(TPrint 435 21) ; "You attempt to communicate through the intercom, but you find you're suffering from insufficient clearance."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 169
		y 130
		nsTop 117
		nsLeft 152
		nsBottom 144
		nsRight 186
		description {the chair}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 22) ; "This office chair prevents you from accessing the intricate equipment below it."
			)
			(3 ; Do
				(TPrint 435 23) ; "Don't move it. You don't need anything that's past the chair."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		x 121
		y 169
		z 34
		nsTop 126
		nsLeft 108
		nsBottom 145
		nsRight 135
		description {the joystick}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 24) ; "Wow! What a joystick!"
			)
			(3 ; Do
				(TPrint 435 25) ; "You briefly picture yourself playing "Zeliard.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance circuitboard of Feature
	(properties
		x 68
		y 189
		z 9
		nsTop 172
		nsLeft 46
		nsBottom 189
		nsRight 91
		description {the circuit board}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 435 26) ; "This looks like a giant circuit board."
			)
			(3 ; Do
				(TPrint 435 27) ; "Be careful. You'll get shocked!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

