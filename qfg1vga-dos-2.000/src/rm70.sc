;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use dartScript)
(use n104)
(use n106)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use System)

(public
	rm70 0
)

(local
	[local0 4]
	local4
	local5
	local6
	[local7 26] = [0 0 0 0 0 0 0 0 0 62 119 91 145 134 104 75 40 109 108 108 107 101 98 97 101 0]
)

(instance rm70 of Rm
	(properties
		noun 2
		picture 70
		style 0
		horizon 37
		north 62
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 63 71 230 71 230 88 254 88 254 144 241 144 241 156 139 156 139 123 160 114 132 102 88 102 81 111 59 111 57 103 39 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 140 125 140 125 161 59 161
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 66 115 102 115 132 121 132 138 97 124 66 124
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 94 0 94 54 0 54 0 0 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 54 149 54 150 -3
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 137 33 157 39 184 110 184 110 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 163 189 163 187 319 187 319 189
					yourself:
				)
		)
		(LoadMany rsVIEW 510 72)
		(= global40 0)
		(super init:)
		(SL enable:)
		(NormalEgo)
		(switch gPrevRoomNum
			(62
				(gCurRoom setScript: sEnterFromNorth)
			)
			(71
				(gCurRoom setScript: sEnterFromEast)
			)
			(69
				(gCurRoom setScript: sEnterFromWest)
			)
			(999
				(gEgo posn: (gEgo x:) (gEgo y:) init:)
			)
			(else
				(gCurRoom setScript: sEnterFromSouth)
			)
		)
		(mush1 init:)
		(mush2 init:)
		(mush3 init:)
		(mush4 init:)
		(mush5 init:)
		(mush6 init:)
		(mush7 init:)
		(ring init:)
		(rocks init:)
		(treesRight init:)
		(treesLeft init:)
		(roomTimer setReal: self 6)
	)

	(method (cue)
		(if (not (IsFlag 60))
			(SetFlag 60)
			(gMessager say: 2 0 7) ; "The trees look more vibrant than most of the forest."
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			(script)
			((> (gEgo x:) 310)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
			((< (gEgo x:) 10)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
			((> (gEgo y:) 185)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; Talk [ REMOVED ]
				(gMessager say: 2 57) ; "To whom are you talking?"
			)
			(50 ; detectMagicSpell
				(gMessager say: 2 50) ; MISSING MESSAGE
			)
			(78 ; dazzleSpell
				(CastDazzle)
			)
			(80 ; calmSpell
				(CastCalm)
			)
			(81 ; flameDartSpell
				(CastDart 0)
			)
			(else
				(gMessager say: 2 0 3) ; "You don't need to do that."
			)
		)
	)
)

(instance treesLeft of Feature
	(properties
		x 58
		y 94
		noun 5
		nsTop -1
		nsBottom 189
		nsRight 116
		sightAngle 40
		onMeCheck 2
	)
)

(instance treesRight of Feature
	(properties
		x 224
		y 94
		noun 4
		nsTop -1
		nsLeft 130
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)
)

(instance rocks of Feature
	(properties
		x 145
		y 101
		noun 3
		nsTop 49
		nsLeft 43
		nsBottom 153
		nsRight 247
		sightAngle 40
		onMeCheck 8
	)
)

(instance mush1 of Feature
	(properties
		x 115
		y 102
		noun 1
		nsTop 84
		nsLeft 79
		nsBottom 102
		nsRight 152
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 0) ; "It's a ring formed of large and rather unusual-looking mushrooms."
			)
			(4 ; Do
				(if (not local4)
					(= local4 118)
					(= local5 95)
					(= local6 0)
				)
				(gCurRoom setScript: pickEm)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mush2 of Feature
	(properties
		x 71
		y 102
		noun 1
		nsTop 95
		nsLeft 64
		nsBottom 109
		nsRight 79
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local6 0)
			(= local4 55)
			(= local5 104)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush3 of Feature
	(properties
		x 80
		y 116
		noun 1
		nsTop 111
		nsLeft 72
		nsBottom 121
		nsRight 89
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(= local6 0)
			(= local4 61)
			(= local5 118)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush4 of Feature
	(properties
		x 113
		y 123
		noun 1
		nsTop 115
		nsLeft 97
		nsBottom 131
		nsRight 129
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(= local4 140)
			(= local5 123)
			(= local6 1)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush5 of Feature
	(properties
		x 156
		y 125
		noun 1
		nsTop 119
		nsLeft 144
		nsBottom 131
		nsRight 168
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(= local4 157)
			(= local5 114)
			(= local6 0)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush6 of Feature
	(properties
		x 163
		y 102
		noun 1
		nsTop 96
		nsLeft 153
		nsBottom 108
		nsRight 174
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(= local4 157)
			(= local5 114)
			(= local6 0)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush7 of Feature
	(properties
		x 177
		y 116
		noun 1
		nsTop 109
		nsLeft 170
		nsBottom 121
		nsRight 185
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(= local4 157)
			(= local5 114)
			(= local6 0)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance ring of Feature
	(properties
		x 137
		y 100
		z 100
		noun 1
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 1 1 0) ; "It's a ring formed of large and rather unusual-looking mushrooms."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 350 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -25 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 69)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 350 111 setMotion: MoveTo 300 111 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: -25 126 setMotion: MoveTo 57 126 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance pickEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath local4 local5 self
				)
			)
			(1
				(gEgo view: 510 setLoop: local6 setCel: 0 setCycle: End self)
				(= local4 0)
				(= local5 0)
				(= local6 0)
			)
			(2
				(gMessager say: 2) ; "You pick a handful of the smaller mushrooms and carefully put them away in your backpack."
				(SetFlag 279)
				(SolvePuzzle 690 3)
				(gEgo get: 30 3 setCycle: Beg self) ; mushroom
			)
			(3
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 122 39 setMotion: MoveTo 122 51 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 139 245 setMotion: MoveTo 139 180 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance roomTimer of Timer
	(properties)
)

