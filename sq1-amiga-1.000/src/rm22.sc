;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use System)

(public
	rm22 0
)

(instance rm22 of SQRoom
	(properties
		lookStr {Were you a proctologist, you might know what these oddly shaped bones are called. To you, though, they're just bones.}
		picture 22
		horizon 20
		north 19
		east 23
		south 25
		west 38
		walkOffTop 1
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(= style 13)
				(gEgo init:)
				(HandsOn)
			)
			(south
				(= style 14)
				(gEgo init:)
				(HandsOn)
			)
			(east
				(= style 11)
				(gEgo init:)
				(HandsOn)
			)
			(34
				(= global183 3000)
				(= global166 2)
				(= style 7)
				(LoadMany rsVIEW 45)
				(self setScript: outOfHole)
			)
			(else
				(gEgo init:)
				(= style 10)
				(HandsOn)
			)
		)
		(self setRegions: 704) ; keronaRegion
		(super init:)
		((ScriptID 704 1) x: 70 y: 76 approachX: 65 approachY: 76) ; plant
		((ScriptID 704 2) x: 15 y: 100 approachX: 10 approachY: 100) ; plant2
		(exitHole init:)
		(if (== global166 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 309 189 291 159 319 159
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 139 189 136 184 127 181 109 177 96 162 114 147 107 143 92 144 76 136 62 136 25 129 29 119 22 105 10 100 15 86 84 78 65 44 77 37 78 25 56 0 248 0 289 83 309 134 302 146 277 149 263 163 270 168 281 189
						yourself:
					)
			)
		else
			(if (== gPrevRoomNum north)
				(gEgo posn: 259 51)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 63 301 52 288 53 269 50 251 40 256 35 246 32 202 11 178 0 319 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 0 189 0 0 145 0 211 36 241 59 319 73
						yourself:
					)
			)
		)
	)
)

(instance outOfHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gSoundEffects number: 366 loop: 1 play:)
				(gEgo
					init:
					posn: 295 154
					view: 45
					loop: 1
					cel: 0
					cycleSpeed: 5
					setCycle: CT 2 1 self
				)
			)
			(2
				(gSoundEffects number: 809 loop: 1 play:)
				(gEgo cel: 3)
				(= cycles 18)
			)
			(3
				(gEgo cycleSpeed: 7 setCycle: End self)
			)
			(4
				(NormalEgo 0 1 61)
				(gEgo loop: 4 heading: 135 setMotion: MoveTo 308 160 self)
				(proc0_9 (gEgoHead view:))
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitHole of Feature
	(properties
		description {exit hole}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 146)
					(Print 22 0) ; "It's the hole you were jettisoned from when you were expelled from the cavern area."
				else
					(Print 22 1) ; "The cave is very small and empty, not unlike your grey matter."
				)
			)
			(3 ; Do
				(Print 22 2) ; "There's nothing you can do as there is no visible means of entry."
			)
			(5 ; Talk
				(Print 22 3) ; "Your shout produces no response."
			)
			(12 ; Smell
				(Print 22 4) ; "It smells empty."
			)
			(11 ; Taste
				(Print 22 5) ; "It tastes calcium-rich."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

