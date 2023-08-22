;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use StdRoom)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
	local1
	[local2 18] = [58 0 2 4 26 40 17 31 26 42 0 2 4 25 43 18 31 29]
	[local20 4] = [1310 0 1 0]
	[local24 4] = [1310 1 1 0]
	[local28 4] = [1310 2 1 0]
	[local32 4] = [1310 3 1 0]
	[local36 8] = [1310 11 1 2 1 2 1 0]
	[local44 5] = [1310 16 1 2 0]
	[local49 5] = [1310 19 1 2 0]
	[local54 6] = [1310 22 2 1 2 0]
	[local60 12] = [1310 41 1 2 1 2 1 1 1 2 1 0]
	[local72 7] = [1310 59 1 1 2 1 0]
	[local79 12] = [1310 68 1 2 1 2 1 2 1 2 1 0]
	[local91 5] = [1310 85 1 2 0]
	[local96 5] = [1310 88 2 1 0]
	[local101 3] = [-1 {Quentin Lightfingers} 21]
	[local104 3] = [-1 {Silas Simpkin} 21]
	[local107 3] = [-1 {Hiram Levi} 21]
	[local110 3] = [-1 {Minnie Mublenews} 21]
	[local113 3] = [-1 {Biddy Bigears} 21]
	[local116 3] = [-1 {Oswald Oakhurst} 21]
	[local119 3] = [-1 {Miles Mindermast} 21]
	[local122 3] = [-1 {Corey Cole} 21]
	[local125 3] = [-1 {Lori Cole} 21]
)

(instance rm310 of StdRoom
	(properties
		picture 310
		style 100
		north 260
		east 260
		south 260
		west 300
	)

	(method (init)
		(self setRegions: 311) ; Fair
		(proc311_3)
		(if (OneOf gDisguiseNum 5 6) ; abbey monk, fens monk
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 319 0 319 189 246 189 197 172 233 166 195 138 142 154 153 177 186 189
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 75 288 75 288 66 262 66 262 23 248 23 209 37 124 37 109 49 43 49 0 31 0 0 259 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 80 121 80 195 61 236 61 273 75 273 96 236 106 251 120 206 132 177 136 149 119 146 123 138 135 35 135 35 119 22 104 0 104
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 277 168 271 181 206 181 201 168
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 273 157 278 130 319 119
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 184 36 184 36 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 65 189 65 184 187 184 187 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 133 48 147 48 157 25 157 20 152 0 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 254 44 230 44 230 34 254 34
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 138 139 164 139 164 149 138 149
						yourself:
					)
			)
		)
		(rugArm1 init: stopUpd:)
		(rugArm2 init: stopUpd:)
		(rugHead init: stopUpd:)
		(coryHead init: stopUpd:)
		(ear1 init: addToPic:)
		(ear2 init: addToPic:)
		(gameArm init: setScript: sRandom)
		(gFeatures
			add:
				person1
				person2
				person3
				person4
				person5
				person6
				person7
				person8
				person9
				person10
				person11
				person12
				person13
				person14
				person15
				person16
				person17
				person18
				person19
				person20
				person21
				person22
				gameTable
				stall
				table
				potA
				potB
				potC
				potC2
				potD
				potE
				potE2
				potF
				potF2
				potG
				potG2
				potH
				potH2
				mat
				rug1
				rug2
				rug3
				rug4
				wall
				satOnRug
				cart
				person55
				mule
			eachElementDo: #init
		)
		(if (OneOf gDisguiseNum 5 6) ; abbey monk, fens monk
			(badMonk
				init:
				view: (if (== gDisguiseNum 5) 129 else 128) ; abbey monk
				setScript: sMonk
			)
			(sheriffMan1 init:)
			(sheriffMan2 init:)
			(= local1 1)
		)
		(if (or (not global198) (> global198 270))
			((ScriptID 316) init:) ; marian
		)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gEgo x: (- (gEgo x:) 320))
				(super init: (gEgo edgeHit:))
				(HandsOn)
			)
			(260
				(HandsOff)
				(gEgo init: posn: 263 239 setHeading: 315)
				(self setScript: sEnter)
				(super init:)
			)
			(else
				(HandsOff)
				(self setScript: sEnter)
				(= local0 20)
				(gPennies put: (/ 20 4))
				(gHapennies put: (/ (mod local0 4) 2))
				(gFarthings put: (mod local0 2))
				(= gDisguiseNum 4) ; yeoman
				(= gDay 8)
				(SetFlag 34)
				(gEgo init: posn: 263 239 get: 17 get: 0 setHeading: 315) ; handScroll, bucks
				(super init:)
			)
		)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
		)
		(super doit:)
	)
)

(instance rugArm1 of Prop
	(properties
		x 177
		y 93
		view 310
		loop 1
		priority 9
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 58) ; "A man selling rugs."
			)
			(5 ; Talk
				(Converse @local72 @local116 6 0 1) ; "These fine rugs come from the King's palace in Daventry, auctioned off for but a fraction of their worth."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1310 63 80 {Oswald Oakhurst}) ; "I couldn't part with such quality rugs for less than my asking price."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rugArm2 of Prop
	(properties
		x 188
		y 93
		view 310
		loop 2
		priority 9
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 58) ; "A man selling rugs."
			)
			(5 ; Talk
				(Converse @local72 @local116 6 0 1) ; "These fine rugs come from the King's palace in Daventry, auctioned off for but a fraction of their worth."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1310 63 80 {Oswald Oakhurst}) ; "I couldn't part with such quality rugs for less than my asking price."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rugHead of Prop
	(properties
		x 183
		y 92
		view 310
		loop 4
		priority 9
		signal 16400
		cycleSpeed 5
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 58) ; "A man selling rugs."
			)
			(5 ; Talk
				(Converse @local72 @local116 6 0 1) ; "These fine rugs come from the King's palace in Daventry, auctioned off for but a fraction of their worth."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1310 63 80 {Oswald Oakhurst}) ; "I couldn't part with such quality rugs for less than my asking price."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coryHead of Prop
	(properties
		x 298
		y 119
		view 310
		loop 3
		priority 14
		signal 16400
		cycleSpeed 5
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 84) ; "A familiar man."
			)
			(5 ; Talk
				(Converse @local91 @local122 @local125 0 1) ; "Reminds me of Spielburg."
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ear1 of View
	(properties
		x 176
		y 160
		view 310
		loop 5
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 110) ; "The mule looks displeased with its lot in life."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 111 80 {Francis the Mule}) ; "If I could talk, I wouldn't be hauling this cart around."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ear2 of View
	(properties
		x 184
		y 160
		view 310
		loop 6
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 110) ; "The mule looks displeased with its lot in life."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 111 80 {Francis the Mule}) ; "If I could talk, I wouldn't be hauling this cart around."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gameArm of Prop
	(properties
		x 2
		y 48
		view 310
		priority 9
		signal 16400
		cycleSpeed 5
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 25) ; "A boy at a game board."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 26 80 {Joshua Mandel}) ; "I want to design games when I grow up."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person1 of Feature
	(properties
		x 26
		y 19
		nsTop 1
		nsLeft 16
		nsBottom 38
		nsRight 37
		sightAngle 90
		approachX 38
		approachY 43
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 9) ; "A townsman."
			)
			(5 ; Talk
				(Say 1310 6 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person2 of Feature
	(properties
		x 68
		y 20
		nsLeft 57
		nsBottom 41
		nsRight 79
		sightAngle 90
		approachX 85
		approachY 54
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 10) ; "He has the look of a pickpocket, eyeing off the purse of the man near him as a cat would eye a mouse."
			)
			(5 ; Talk
				(if (Fair firstPickpocket:)
					(Converse @local36 6 @local101 0 1) ; "You wouldn't be thinking of slipping your fingers into that man's purse, would you?"
					(Fair firstPickpocket: 0)
				else
					(Converse @local44 6 @local101 0 1) ; "You have been warned."
				)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person3 of Feature
	(properties
		x 101
		y 20
		nsLeft 86
		nsBottom 41
		nsRight 116
		sightAngle 90
		approachX 85
		approachY 54
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 18) ; "A man who is careless with his purse."
			)
			(5 ; Talk
				(Converse @local49 6 @local104 0 1) ; "I'd advise you, sir, to take more care with your purse."
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person4 of Feature
	(properties
		x 173
		y 15
		nsLeft 163
		nsBottom 30
		nsRight 184
		sightAngle 90
		approachX 197
		approachY 43
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 21) ; "A merchant selling sturdy blue trousers."
			)
			(5 ; Talk
				(Converse @local54 6 @local107 0 1) ; "What do you think of the quality of my wares, sir?"
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person5 of Feature
	(properties
		x 8
		y 81
		z 30
		nsTop 35
		nsBottom 67
		nsRight 17
		sightAngle 90
		approachX 24
		approachY 58
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 25) ; "A boy at a game board."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 26 80 {Joshua Mandel}) ; "I want to design games when I grow up."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person6 of Feature
	(properties
		x 75
		y 98
		z 20
		nsTop 52
		nsLeft 65
		nsBottom 105
		nsRight 85
		sightAngle 90
		approachX 74
		approachY 80
		_approachVerbs 20
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 27) ; "This man shows more interest in gossiping with a neighbor than in tending to his own wares."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 29 80 {George Bush}) ; "I'm busy."
				(SetMessageColor 0)
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1310 28 80 {George Bush}) ; "Don't bother me."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person7 of Feature
	(properties
		x 88
		y 84
		z 30
		nsTop 44
		nsLeft 79
		nsBottom 65
		nsRight 97
		sightAngle 90
		approachX 74
		approachY 74
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 30) ; "A man trying very hard to look wise."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 31 80 {Daniel Quail}) ; "A mind is a waste of thing to lose. Nay, uh..."
				(Say 1310 32 80 {Daniel Quail}) ; "To lose a mind is a waste to... Nay, um..."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person8 of Feature
	(properties
		x 109
		y 93
		z 40
		nsTop 42
		nsLeft 102
		nsBottom 65
		nsRight 116
		sightAngle 90
		approachX 101
		approachY 78
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 33) ; "A man selling used armour."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 34 80 {Christopher Shankarmour}) ; "Get your second-hand armour here! Crusade cast-offs!"
				(Say 1310 35 80 {Christopher Shankarmour}) ; "Minor dints, dings and dents! No charge for bloodstains!"
				(Say 1310 36 80 {Christopher Shankarmour}) ; "Impress the ladies! Free tale of gallantry with each purchase!"
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person9 of Feature
	(properties
		x 243
		y 21
		nsTop -1
		nsLeft 234
		nsBottom 43
		nsRight 253
		sightAngle 90
		approachX 222
		approachY 43
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 37) ; "A woman looking at the Fair."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 38 80 {Mistress Yhalkee}) ; "It all looks so wonderful, I hardly know where to start."
				(Say 1310 39 80 {Mistress Yhalkee}) ; "I wonder where the scrumpy cider is?"
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person10 of Feature
	(properties
		x 281
		y 33
		nsTop 2
		nsLeft 269
		nsBottom 65
		nsRight 293
		sightAngle 90
		onMeCheck 4
		approachX 276
		approachY 75
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 40) ; "A woman gossiping."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Converse @local60 @local110 @local113 0 1) ; "Well, I hear tell that she dances in the woods."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person11 of Feature
	(properties
		x 302
		y 40
		nsTop 15
		nsLeft 292
		nsBottom 66
		nsRight 312
		sightAngle 90
		approachX 276
		approachY 75
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 50) ; "A woman listening to gossip."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(SayModeless 1310 51 80 {Biddy Bigears}) ; "Don't interrupt, you rudesby!"
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person12 of Feature
	(properties
		x 14
		y 120
		nsTop 93
		nsLeft 6
		nsBottom 148
		nsRight 23
		sightAngle 90
		approachX 32
		approachY 127
		_approachVerbs 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1310 52) ; "A man talking to a peasant."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 53 80 {Cedric Nimfadoro}) ; "Yonder potmonger shows not the slightest care for his own business."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person13 of Feature
	(properties
		x 33
		y 128
		nsTop 104
		nsLeft 23
		nsBottom 152
		nsRight 43
		sightAngle 90
		approachX 32
		approachY 127
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 54) ; "A peasant bent with age."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 55 80 {Old Gaffer}) ; "If the potmonger has no time for me, I'll go buy my pots elsewhere."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person14 of Feature
	(properties
		x 150
		y 150
		z 30
		nsTop 94
		nsLeft 139
		nsBottom 146
		nsRight 161
		sightAngle 90
		approachX 119
		approachY 143
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 56) ; "A woman looking at the pots."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 57 80 {Patience Witzend}) ; "If I stand here long enough, looking needful, perhaps one day the potmonger will deign to notice me."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person15 of Feature
	(properties
		x 181
		y 98
		nsTop 83
		nsLeft 167
		nsBottom 113
		nsRight 195
		sightAngle 90
		approachX 164
		approachY 123
		_approachVerbs 24
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 58) ; "A man selling rugs."
			)
			(5 ; Talk
				(Converse @local72 @local116 6 0 1) ; "These fine rugs come from the King's palace in Daventry, auctioned off for but a fraction of their worth."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1310 63 80 {Oswald Oakhurst}) ; "I couldn't part with such quality rugs for less than my asking price."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person16 of Feature
	(properties
		x 201
		y 104
		nsTop 78
		nsLeft 191
		nsBottom 130
		nsRight 212
		sightAngle 90
		approachX 174
		approachY 130
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 64) ; "A man looking at the rugs."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 65 80 {Mark Hood}) ; "How do I know these rugs come from Daventry?"
				(SayModeless 1310 66 80 {Oswald Oakhurst}) ; "Trust me."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person17 of Feature
	(properties
		x 20
		y 269
		z 100
		nsTop 150
		nsLeft 6
		nsBottom 189
		nsRight 34
		sightAngle 90
		approachX 23
		approachY 179
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 67) ; "A young man with a sack on his back."
			)
			(5 ; Talk
				(Converse @local79 6 @local119 0 1) ; "What do you carry to Fair?"
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person18 of Feature
	(properties
		x 132
		y 271
		z 100
		nsTop 154
		nsLeft 116
		nsBottom 189
		nsRight 149
		sightAngle 90
		approachX 132
		approachY 184
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 77) ; "A man with a cart full of large jugs."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 78 80 {Wystan Wheelwright}) ; "I wouldn't be too interested in these jugs, sir."
				(Say 1310 79 80 {Wystan Wheelwright}) ; "They're old privy pots I'm hauling off from the castle."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person19 of Feature
	(properties
		x 218
		y 259
		z 100
		nsTop 141
		nsLeft 210
		nsBottom 178
		nsRight 226
		sightAngle 90
		approachX 228
		approachY 162
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 80) ; "'Tis Richard, Aaron's son."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 81 80 {Richard}) ; "My Da wants me to move up in the world, so I'm going to be a swineherd when I grow up."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person20 of Feature
	(properties
		x 248
		y 253
		z 100
		nsTop 124
		nsLeft 226
		nsBottom 182
		nsRight 270
		sightAngle 90
		approachX 228
		approachY 162
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 82) ; "A man named Aaron, bearing a firtle of sticks."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 83 80 {Aaron}) ; "I used to be a programmer for Sierra On-Line, but hauling wood is much easier work."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person21 of Feature
	(properties
		x 299
		y 123
		nsTop 110
		nsLeft 289
		nsBottom 136
		nsRight 309
		sightAngle 90
		approachX 279
		approachY 128
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 84) ; "A familiar man."
			)
			(5 ; Talk
				(Converse @local91 @local122 @local125 0 1) ; "Reminds me of Spielburg."
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person22 of Feature
	(properties
		x 305
		y 105
		nsTop 81
		nsLeft 297
		nsBottom 130
		nsRight 314
		sightAngle 90
		approachX 279
		approachY 128
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 87) ; "A familiar woman (or is it a woman with a familiar?)."
			)
			(5 ; Talk
				(Converse @local96 @local122 @local125 0 1) ; "Reminds me of the alleys of Shapeir only, well, earthier."
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gameTable of Feature
	(properties
		x 19
		y 62
		nsTop 53
		nsLeft 4
		nsBottom 71
		nsRight 35
		sightAngle 90
		onMeCheck 4
		approachX 24
		approachY 58
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 90) ; "Some sort of rudimentary game has been scratched into the table."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stall of Feature
	(properties
		x 150
		y 86
		z 40
		nsTop 33
		nsLeft 112
		nsBottom 60
		nsRight 188
		sightAngle 90
		approachX 140
		approachY 68
		_approachVerbs 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 91) ; "A bin filled with slightly used pieces of armour."
			)
			(3 ; Do
				(Say 1310 92) ; "I've no use for armour such as this."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 193
		y 15
		nsLeft 155
		nsBottom 31
		nsRight 231
		sightAngle 90
		approachX 197
		approachY 43
		_approachVerbs 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 93) ; "Sturdy blue pants of stiff material."
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1310 94) ; "I prefer the comfort and freedom of my woolen hose over trousers."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of Feature
	(properties
		x 89
		y 117
		nsTop 101
		nsLeft 39
		nsBottom 134
		nsRight 139
		sightAngle 90
		onMeCheck 4
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 95) ; "A woven straw mat on which pots of many sizes are displayed with utter indifference."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potA of Feature
	(properties
		x 107
		y 97
		nsTop 89
		nsLeft 98
		nsBottom 105
		nsRight 117
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 96) ; "A 5 gallon pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potB of Feature
	(properties
		x 38
		y 101
		nsTop 93
		nsLeft 29
		nsBottom 110
		nsRight 48
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 97) ; "A one gallon pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potC of Feature
	(properties
		x 49
		y 118
		nsTop 112
		nsLeft 43
		nsBottom 124
		nsRight 55
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 98) ; "A quart pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potC2 of Feature
	(properties
		x 62
		y 124
		nsTop 119
		nsLeft 54
		nsBottom 130
		nsRight 70
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 98) ; "A quart pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potD of Feature
	(properties
		x 80
		y 125
		nsTop 121
		nsLeft 72
		nsBottom 130
		nsRight 88
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 99) ; "A pint pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potE of Feature
	(properties
		x 92
		y 102
		nsTop 99
		nsLeft 88
		nsBottom 105
		nsRight 96
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 100) ; "A one gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potE2 of Feature
	(properties
		x 97
		y 109
		nsTop 105
		nsLeft 91
		nsBottom 114
		nsRight 103
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 100) ; "A one gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potF of Feature
	(properties
		x 108
		y 116
		nsTop 111
		nsLeft 103
		nsBottom 122
		nsRight 113
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 101) ; "A half-gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potF2 of Feature
	(properties
		x 117
		y 122
		nsTop 118
		nsLeft 110
		nsBottom 127
		nsRight 124
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 101) ; "A half-gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potG of Feature
	(properties
		x 54
		y 107
		nsTop 104
		nsLeft 50
		nsBottom 111
		nsRight 59
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 102) ; "A quarter-gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potG2 of Feature
	(properties
		x 62
		y 114
		nsTop 110
		nsLeft 58
		nsBottom 118
		nsRight 67
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 102) ; "A quarter-gill pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potH of Feature
	(properties
		x 99
		y 123
		nsTop 120
		nsLeft 94
		nsBottom 127
		nsRight 105
		sightAngle 90
		approachX 92
		approachY 137
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 103) ; "A nipperkin pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potH2 of Feature
	(properties
		x 70
		y 126
		sightAngle 45
		approachX 92
		approachY 137
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 92 105 91 111 88 112 84 109 85 103
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 103) ; "A nipperkin pot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 131
		y 74
		nsTop 48
		nsBottom 100
		nsRight 263
		sightAngle 90
		onMeCheck 2
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 104) ; "The wall runs the length of the Fair and divides the merchants."
				(Say 1310 105) ; "This marks its eastern end."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug1 of Feature
	(properties
		x 165
		y 71
		nsTop 59
		nsLeft 141
		nsBottom 84
		nsRight 189
		sightAngle 90
		approachX 249
		approachY 111
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 106) ; "They are thick, luxurious rugs with a foreign look to them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug2 of Feature
	(properties
		x 208
		y 60
		nsTop 52
		nsLeft 191
		nsBottom 69
		nsRight 225
		sightAngle 90
		approachX 249
		approachY 111
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 106) ; "They are thick, luxurious rugs with a foreign look to them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug3 of Feature
	(properties
		x 245
		y 60
		nsTop 46
		nsLeft 231
		nsBottom 74
		nsRight 260
		sightAngle 90
		approachX 249
		approachY 111
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 106) ; "They are thick, luxurious rugs with a foreign look to them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug4 of Feature
	(properties
		x 235
		y 94
		nsTop 87
		nsLeft 208
		nsBottom 102
		nsRight 262
		sightAngle 90
		approachX 249
		approachY 111
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 106) ; "They are thick, luxurious rugs with a foreign look to them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance satOnRug of Feature
	(properties
		x 196
		y 114
		nsTop 102
		nsLeft 153
		nsBottom 127
		nsRight 240
		sightAngle 90
		onMeCheck 4
		approachX 249
		approachY 111
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 107) ; "The man kneels upon a thick rug woven in the Daventry style."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cart of Feature
	(properties
		x 93
		y 176
		nsTop 163
		nsLeft 57
		nsBottom 189
		nsRight 130
		sightAngle 90
		onMeCheck 4
		approachX 111
		approachY 173
		_approachVerbs 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 108) ; "The cart is filled with large, bad-smelling jugs."
			)
			(3 ; Do
				(Say 1310 109) ; "I think I'll leave these jugs well alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mule of Feature
	(properties
		x 168
		y 273
		z 100
		nsTop 157
		nsLeft 146
		nsBottom 189
		nsRight 190
		sightAngle 90
		onMeCheck 4
		approachX 172
		approachY 184
		_approachVerbs 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1310 110) ; "The mule looks displeased with its lot in life."
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1310 111 80 {Francis the Mule}) ; "If I could talk, I wouldn't be hauling this cart around."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance badMonk of Actor
	(properties
		x 330
		y 110
		signal 18432
	)
)

(instance sheriffMan1 of Actor
	(properties
		x -11
		y 175
		view 750
		signal 18432
	)

	(method (cue)
		(super cue:)
		(self setCel: 0 setCycle: 0)
	)
)

(instance sheriffMan2 of Actor
	(properties
		x -16
		y 162
		view 750
		signal 18432
	)

	(method (cue)
		(super cue:)
		(self setCel: 0 setCycle: 0)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 187)
					(gEgo
						setMotion:
							PolyPath
							(+ (gEgo x:) 40)
							(+ (gEgo y:) 60)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(gEgo x:)
							(+ (gEgo y:) 60)
							self
					)
				)
			)
			(1
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sMonk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* 2 (+ gHowFast 1)))
			)
			(1
				(badMonk
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 203 157 self
				)
				(sheriffMan1
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 145 (sheriffMan1 y:) sheriffMan1
				)
				(sheriffMan2
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 164 (sheriffMan2 y:) sheriffMan2
				)
			)
			(2
				(= seconds (* 4 (+ gHowFast 1)))
			)
			(3
				(badMonk setCel: 0)
				(HandsOff)
				(if (< (gEgo y:) 198)
					(gEgo setHeading: 315)
					(if (== gDisguiseNum 5) ; abbey monk
						(Converse 1 @local20 10 3 self 1) ; "You there! I've seen your face!"
					else
						(Converse 1 @local28 11 3 self 1) ; "You dare to show your face here, imposter?"
					)
				else
					(gEgo setMotion: PolyPath (gEgo x:) 242)
					(= seconds 2)
					(gCurRoom newRoom: 260)
				)
			)
			(4
				(if (== gDisguiseNum 5) ; abbey monk
					(Converse 1 @local24 10 3 self 1) ; "Soldiers, arrest him! That's ROBIN HOOD!"
				else
					(Converse 1 @local32 11 3 self 1) ; "You men, arrest this false monk!"
				)
			)
			(5
				(= gDeathNum 4)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance sRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 8)
					(0
						(self changeState: 5)
					)
					(1
						(self changeState: 10)
					)
					(2
						(self changeState: 15)
					)
					(3
						(self changeState: 20)
					)
					(4
						(self changeState: 40)
					)
					(else
						(= state -1)
						(= ticks (Random 20 60))
					)
				)
			)
			(5
				(rugHead startUpd: setCel: (Random 0 2))
				(= cycles 2)
			)
			(6
				(rugHead stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(10
				(rugArm1
					startUpd:
					cycleSpeed: (Random 10 30)
					setCycle: End self
				)
			)
			(11
				(rugArm1 cycleSpeed: (Random 10 30) setCycle: Beg self)
			)
			(12
				(rugArm1 stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(15
				(rugArm2
					startUpd:
					cycleSpeed: (Random 10 30)
					setCycle: End self
				)
			)
			(16
				(rugArm2 cycleSpeed: (Random 10 30) setCycle: Beg self)
			)
			(17
				(rugArm2 stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(20
				(coryHead startUpd: setCel: (Random 0 2))
				(= cycles 2)
			)
			(21
				(coryHead stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(25
				(ear1 setCel: (Random 0 2))
				(= state -1)
				(= ticks (Random 20 60))
			)
			(30
				(ear2 setCel: (Random 0 2))
				(= state -1)
				(= ticks (Random 20 60))
			)
			(40
				(gameArm
					startUpd:
					cycleSpeed: (Random 10 30)
					setCycle: End self
				)
			)
			(41
				(gameArm cycleSpeed: (Random 10 30) setCycle: Beg self)
			)
			(42
				(gameArm stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 195 185 self)
				(gRgnMusic number: 280 loop: -1 play:)
			)
			(2
				(if (OneOf gDisguiseNum 5 6) ; abbey monk, fens monk
					(User canControl: 1 canInput: 1)
					(gTheIconBar enable: 0 curIcon: (gTheIconBar at: 0))
					(= ticks (- gHowFast 3))
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(gGame setCursor: 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -15 (gEgo y:) self)
			)
			(1
				(if (not (Fair walkingOut:))
					(gCurRoom newRoom: 300)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

(instance person55 of Feature
	(properties
		x 52
		y 87
		z 30
		nsTop 47
		nsLeft 41
		nsBottom 67
		nsRight 63
		sightAngle 90
		onMeCheck 8
		approachX 24
		approachY 58
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1310 5 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

