;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	drawerOpen
)

(instance rm180 of LLRoom
	(properties
		lookStr {PPC's file room is filled with file cabinets which are filled with files.}
		picture 180
		south 160
	)

	(method (init)
		(self setRegions: 40) ; HollywoodRgn
		(gEgo init: normalize:)
		(switch gPrevRoomNum
			(south
				(gEgo x: 200)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(imprinter init: approachVerbs: 3) ; Do
		(light init:)
		(bookcase init:)
		(nudePainting init:)
		(desk init:)
		(lamp init:)
		(magnifier init:)
		(drawer init: approachVerbs: 3) ; Do
		(loserDrawer1 init: approachVerbs: 3) ; Do
		(loserDrawer2 init: approachVerbs: 3) ; Do
		(loserDrawer3 init: approachVerbs: 3) ; Do
		(books init:)
		(fan init:)
		(chair init:)
		(fTwins init:)
		(fRolls init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 244 189 284 152 259 154 218 127 220 118 163 121 96 119 80 136 82 141 54 168 158 168 165 189 0 189
					yourself:
				)
		)
	)
)

(instance imprinter of Prop
	(properties
		x 128
		y 1162
		z 1000
		description {the credit card imprinter}
		approachX 137
		approachY 165
		view 180
		priority 15
		signal 16400
	)

	(method (init)
		(if (gEgo has: 7) ; AeroDork_Gold_Card
			(self setCel: 1)
		else
			(self setCel: 0)
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gEgo has: 7) ; AeroDork_Gold_Card
					(TPrint 180 0) ; "The empty credit card imprinter holds no fascination for you."
				else
					(TPrint 180 1) ; "Say! An exclusive "AeroDork Airlines Gold Card" rests in the credit card imprinter. Probably just someone racking up a few charges on the ol' company dole!"
				)
			)
			(3 ; Do
				(if (gEgo has: 7) ; AeroDork_Gold_Card
					(TPrint 180 2) ; "The imprinter is of no value to you. The Gold Card was all you needed."
				else
					(self setScript: sGetCard)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drawer of Actor
	(properties
		x 266
		y 125
		description {the drawer}
		sightAngle 40
		approachX 240
		approachY 140
		view 180
		loop 2
		signal 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((gEgo has: 5) ; Michelle_Milken_s_Resume
						(TPrint 180 3) ; "The "Winners" drawer is now empty."
					)
					(drawerOpen
						(TPrint 180 4) ; "There are three resume files here."
					)
					(else
						(TPrint 180 5) ; "Why, look! Here it is!! You've found it! This drawer is labeled "Winners!""
					)
				)
			)
			(3 ; Do
				(cond
					((gEgo has: 5) ; Michelle_Milken_s_Resume
						(TPrint 180 6) ; "There was nothing else of value in that drawer."
					)
					(drawerOpen
						(self setScript: sDrawer 0 1)
					)
					(else
						(self setScript: sDrawer 0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGetCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 181
					setLoop: 2
					setCel: 0
					posn: 141 157
					setPri: 15
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(Points 5 88)
				(gEgo setCycle: Beg self)
			)
			(2
				(imprinter setCel: 1 approachVerbs: 0)
				(gEgo setLoop: 2 posn: 137 165 get: 7 normalize:) ; AeroDork_Gold_Card
				(= cycles 2)
			)
			(3
				(TPrint 180 7) ; "Assuming that your recent promotion now authorizes such extravagance, you remove the luxurious "AeroDork Gold Card" from the credit card imprinter."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== register 1)
					(self changeState: 3)
				else
					(gEgo
						view: 181
						setLoop: 0
						setCel: 0
						cycleSpeed: 12
						setCycle: CT 2 1 self
					)
				)
			)
			(1
				(gEgo setCycle: End)
				(drawer setMotion: MoveTo 255 (drawer y:) self)
				(gTheMusic2 number: 181 setLoop: 1 play:)
			)
			(2
				(= drawerOpen 1)
				(self changeState: 6)
			)
			(3
				(gEgo view: 181 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(Points 8 89)
				(gEgo get: 5 15 19) ; Michelle_Milken_s_Resume
				(drawer setLoop: 1)
				(= cycles 1)
			)
			(5
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
				(gTheMusic2 number: 182 setLoop: 1 play:)
				(drawer setMotion: MoveTo 263 (drawer y:))
				(= drawerOpen 0)
				(drawer approachVerbs: 0)
			)
			(6
				(if (== register 1)
					(TPrint 180 8) ; "You take the three resumes from the drawer."
				)
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 220
		y 40
		nsTop 18
		nsLeft 210
		nsBottom 62
		nsRight 231
		description {the light}
		sightAngle 40
		lookStr {Staring into the lamp is an enlightening experience for you.}
	)
)

(instance bookcase of Feature
	(properties
		x 157
		y 47
		nsTop 34
		nsLeft 113
		nsBottom 61
		nsRight 201
		description {the bookcase}
		sightAngle 40
		lookStr {This bookcase is filled with everything but books.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 9) ; "The bookcase contains nothing that is of use to you. Perhaps you should look elsewhere."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance nudePainting of Feature
	(properties
		x 60
		y 57
		nsTop 38
		nsLeft 43
		nsBottom 76
		nsRight 78
		description {the nude painting}
		sightAngle 40
		lookStr {You don't know much about art, but something about this painting touches your fancy!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 10) ; "You'd love to fold this up for your wallet, but you refuse to create a bulge in your leisure suit."
			)
			(5 ; Talk
				(TPrint 180 11) ; ""Were you ever featured in `National Geographic?'" you wonder."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 89
		y 165
		nsTop 154
		nsLeft 33
		nsBottom 176
		nsRight 145
		description {your desk}
		sightAngle 40
		lookStr {Why are there no workers in this place?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 12) ; "What? You work?! No way!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 46
		y 158
		nsTop 145
		nsLeft 35
		nsBottom 171
		nsRight 58
		description {the lamp}
		sightAngle 40
		lookStr {You admire anyone who uses incandescent lighting.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 13) ; "You have no use for the lamp."
			)
			(5 ; Talk
				(Say gEgo 180 14) ; ""Testing 1, 2, 3!" you say forcefully, thinking that desk lamp is a hidden microphone."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance magnifier of Feature
	(properties
		x 95
		y 159
		nsTop 144
		nsLeft 73
		nsBottom 174
		nsRight 117
		description {the magnifier}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 180 15) ; "One of your favorite pastimes here at PornProdCorp is to stand here holding the magnifier up to various parts of your anatomy."
				(TPrint 180 16) ; "Like your fingerprints, Larry!"
				(TPrint 180 17 67 -1 185) ; "(Shame on you for thinking thoughts like that!)"
			)
			(3 ; Do
				(TPrint 180 18) ; "You move the magnifier slightly, then restore it to exactly the same spot again, all in the twinkling of a video scan!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance loserDrawer1 of Feature
	(properties
		x 257
		y 124
		nsTop 97
		nsLeft 233
		nsBottom 152
		nsRight 281
		description {the file drawer}
		sightAngle 40
		approachX 226
		approachY 135
		lookStr {This file drawer is labeled "Losers." You're looking for the files of the three finalists. This is no time to try to fatten your address book, Larry!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 19) ; "As you start to open the drawer, you read the label, and decide this is not the drawer for you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance loserDrawer2 of Feature
	(properties
		x 155
		y 93
		nsTop 71
		nsLeft 100
		nsBottom 116
		nsRight 210
		description {the file drawer}
		sightAngle 40
		lookStr {This file drawer is labeled "Losers." You're looking for the files of the three finalists. This is no time to try to fatten your address book, Larry!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 19) ; "As you start to open the drawer, you read the label, and decide this is not the drawer for you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance loserDrawer3 of Feature
	(properties
		x 63
		y 123
		nsTop 101
		nsLeft 40
		nsBottom 149
		nsRight 87
		description {the file drawer}
		sightAngle 40
		lookStr {This file drawer is labeled "Losers." You're looking for the files of the three finalists. This is no time to try to fatten your address book, Larry!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 19) ; "As you start to open the drawer, you read the label, and decide this is not the drawer for you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 57
		y 93
		nsTop 87
		nsLeft 46
		nsBottom 99
		nsRight 69
		description {some books}
		sightAngle 40
		lookStr {Why would you want to look at books, Larry? You can barely read!}
	)
)

(instance fan of Feature
	(properties
		x 263
		y 87
		nsTop 75
		nsLeft 254
		nsBottom 100
		nsRight 273
		description {the fan}
		sightAngle 40
		lookStr {This is your biggest fan!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 20) ; "You are afraid to turn on that fan without protective garments."
				(TPrint 180 21 67 -1 185) ; "(And it, you!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 222
		y 104
		nsTop 96
		nsLeft 212
		nsBottom 113
		nsRight 232
		description {your chair}
		sightAngle 40
		lookStr {This chair is your favorite work-place sleeper.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 180 22) ; "Remember: the Sexiest Woman in America. THE Sexiest Woman in America! You're not going to find her sitting around in here!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fTwins of Feature
	(properties
		x 100
		y 111
		z 66
		nsTop 31
		nsLeft 93
		nsBottom 60
		nsRight 108
		description {the twins poster}
		sightAngle 40
		lookStr {This poster is your personal favorite. You've always had a soft spot for twins.}
	)

	(method (doVerb theVerb &tmp [str 100])
		(if (== theVerb 2) ; Look
			(Format @str 180 23 (if (IsFlag 0) {red} else {blonde})) ; "This poster is your personal favorite. You've always had a soft spot for %s-haired twins."
			(TPrint @str)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fRolls of Feature
	(properties
		x 91
		y 103
		nsTop 93
		nsLeft 82
		nsBottom 114
		nsRight 101
		description {the rolls of paper}
		sightAngle 40
		lookStr {There are some unimportant rolls of paper lying there.}
	)
)

