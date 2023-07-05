;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	rm24 0
)

(instance rm24 of SQRoom
	(properties
		lookStr {A section of vertebra, near where the head used to be attached, extends north and south. To the east is the ominous-looking skull.}
		picture 24
		horizon 20
		north 21
		east 38
		south 27
		west 23
		walkOffTop 1
	)

	(method (init)
		(if (== global166 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 127 194 127 136 128 152 115 209 114 272 107 257 100 224 106 203 105 160 94 129 94 113 94 134 81 160 81 199 61 277 54 319 76
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 55 37 62 128 160 126 189
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 93 189 86 173 61 148 50 130 58 128 53 121 37 120 14 99 13 88 0 76 0 0 318 0 319 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 102 36 143 52 170 58 189 0 189
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(HandsOn)
				(gEgo init:)
			)
			(south
				(= style 14)
				(HandsOn)
				(cond
					((< 113 (gEgo x:) 131)
						(gEgo init: x: 131)
					)
					((< 90 (gEgo x:) 110)
						(gEgo init: x: 89)
					)
					(else
						(gEgo init:)
					)
				)
			)
			(north
				(= style 13)
				(HandsOn)
				(gEgo init:)
			)
			(east
				(= style 8)
				(HandsOn)
				(gEgo init:)
			)
			(else
				(= style 10)
				(gEgo init:)
				(self setScript: outOfCave)
			)
		)
		(teeth init:)
		(skull init:)
		(self setRegions: 704) ; keronaRegion
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $4000)
				(self newRoom: 28)
			)
		)
		(super doit:)
	)
)

(instance outOfCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 240 112 setMotion: MoveTo 153 108 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance teeth of Feature
	(properties
		description {teeth}
		onMeCheck 8192
		lookStr {No doubt about it. Those are some serious teeth. It could've used a little dental work - maybe some braces even. It's just a good thing you never had the opportunity to be on the business end of these things when it was still a living being.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 24 0) ; "These teeth are in to stay."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skull of Feature
	(properties
		description {skull}
		onMeCheck 4096
		lookStr {This must be the skull previously attached to the rest of the mammoth bones partially assembled here.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 24 1) ; "Many years of sandblasting by the Keronian elements have given the skull a smooth finish."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

