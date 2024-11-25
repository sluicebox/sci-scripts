;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
)

(instance rm710 of LLRoom
	(properties
		picture 710
		north 730
		south 700
	)

	(method (init)
		(gEgo init: normalize: 711)
		(switch gPrevRoomNum
			(720
				(gEgo edgeHit: EDGE_NONE)
				(gTheIconBar disable: 6)
			)
			(north
				(HandsOff)
				(gEgo setHeading: 180 edgeHit: EDGE_NONE)
				(if (IsFlag 37) ; fCasinoSide
					(self setScript: sFromNorth 0 1)
				else
					(self setScript: sFromNorth 0 0)
				)
			)
			(south
				(gEgo x: 144)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(girlPic1 init:)
		(girlPic2 init:)
		(rouletteArea init: approachVerbs: 5) ; Talk
		(blackjackArea init: approachVerbs: 5) ; Talk
		(chandelier init:)
		(chandelier2 init:)
		(ballroom init:)
		(statue1 init: approachVerbs: 3 4) ; Do, Inventory
		(statue2 init: approachVerbs: 3 4) ; Do, Inventory
		(statue3 init: approachVerbs: 3 4) ; Do, Inventory
		(statue4 init: approachVerbs: 3 4) ; Do, Inventory
		(statue5 init: approachVerbs: 3 4) ; Do, Inventory
		(poker1 init: approachVerbs: 3 4) ; Do, Inventory
		(poker3 init: approachVerbs: 3 4) ; Do, Inventory
		(poker5 init: approachVerbs: 3 4) ; Do, Inventory
		(poker6 init: approachVerbs: 3 4) ; Do, Inventory
		(poker7 init: approachVerbs: 3 4) ; Do, Inventory
		(poker8 init: approachVerbs: 3 4) ; Do, Inventory
		(poker9 init: approachVerbs: 3 4) ; Do, Inventory
		(poker10 init: approachVerbs: 3 4) ; Do, Inventory
		(poker11 init: approachVerbs: 3 4) ; Do, Inventory
		(poker12 init: approachVerbs: 3 4) ; Do, Inventory
		(poker15 init: approachVerbs: 3 4) ; Do, Inventory
		(poker16 init: approachVerbs: 3 4) ; Do, Inventory
		(poker17 init: approachVerbs: 3 4) ; Do, Inventory
		(poker18 init: approachVerbs: 3 4) ; Do, Inventory
		(poker19 init: approachVerbs: 3 4) ; Do, Inventory
		(poker20 init: approachVerbs: 3 4) ; Do, Inventory
		(poker21 init: approachVerbs: 3 4) ; Do, Inventory
		(poker22 init: approachVerbs: 3 4) ; Do, Inventory
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 99 0 126 46 126 62 136 62 136 72 118 88 108 88 100 76 72 76 55 94 113 94 108 126 121 126 123 88 151 88 151 138 105 138 105 146 41 146 50 134 50 129 48 129 46 135 29 135 15 160 121 160 128 176 128 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 154 189 165 184 223 184 246 174 273 174 273 154 239 154 239 150 197 150 197 136 307 136 294 100 285 100 275 112 257 112 243 100 220 100 227 115 263 115 263 124 161 124 161 114 197 114 194 101 161 101 159 90 229 90 224 73 188 73 188 63 222 63 219 52 201 52 190 46 215 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 128 154 194 154 191 165 133 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 161 0 190 40 182 46 136 46 129 41
					yourself:
				)
		)
		(if (== gPrevRoomNum 700)
			(gTheMusic fade: 127 10 10 0)
		else
			(gTheMusic number: 710 setLoop: -1 flags: 1 play: 127)
		)
		(gTheMusic2 number: 711 setLoop: -1 flags: 1 play: 127)
		(person0 init:)
		(person1 init:)
		(person2 init:)
		(person3 init:)
		(person4 init:)
		(person5 init:)
		(if (IsFlag 49) ; fDidLana
			(rope1 init: stopUpd:)
			(rope2 init: stopUpd:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 710 0) ; "Tramp's Casino has spared no expense to create the ultimate in tasteless luxuriant opulent detritus. Video poker machines surround you to such an extent that you are unsure how to walk around them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (IsFlag 49) (StepOn gEgo 6)) ; fDidLana
				(HandsOff)
				(gCurRoom setScript: sClosed)
			)
			((StepOn gEgo 2)
				(gEgo edgeHit: EDGE_TOP)
				(HandsOff)
				(self setScript: sToNorth 0 1)
			)
			((StepOn gEgo 4)
				(gEgo edgeHit: EDGE_TOP)
				(HandsOff)
				(self setScript: sToNorth 0 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 700)
			(gTheMusic fade:)
		)
		(gTheMusic2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sClosed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(TPrint 710 1) ; "The Tramp Casino Ballroom is presently closed."
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 4) self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 0
					setMotion: MoveTo (if register 115 else 205) 41 self
				)
			)
			(1
				(gEgo setPri: -1)
				(if register
					(SetFlag 37) ; fCasinoSide
				else
					(ClearFlag 37) ; fCasinoSide
				)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 0
					x: (if register 115 else 205)
					y: 41
					setMotion: MoveTo (if register 136 else 184) 48 self
				)
			)
			(1
				(gEgo setPri: -1 setHeading: 180 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance person0 of Prop
	(properties
		x 29
		y 132
		description {the gambler}
		lookStr {All of these gamblers look compulsive to you.}
		view 710
		signal 16384
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Beg person1)
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person1)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 2) ; "Leave them alone, Larry; they're concentrating on losing."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance person1 of Prop
	(properties
		x 93
		y 143
		view 710
		loop 1
		signal 16384
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person2)
	)

	(method (doVerb)
		(person0 doVerb: &rest)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)
)

(instance person2 of Prop
	(properties
		x 194
		y 184
		view 710
		loop 2
		signal 16384
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person3)
	)

	(method (doVerb)
		(person0 doVerb: &rest)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)
)

(instance person3 of Prop
	(properties
		x 294
		y 171
		view 710
		loop 3
		priority 14
		signal 16400
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person4)
	)

	(method (doVerb)
		(person0 doVerb: &rest)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)
)

(instance person4 of Prop
	(properties
		x 261
		y 152
		view 710
		loop 4
		signal 16384
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person5)
	)

	(method (doVerb)
		(person0 doVerb: &rest)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)
)

(instance person5 of Prop
	(properties
		x 73
		y 75
		view 710
		loop 5
		signal 16384
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(self setCycle: Beg person0)
	)

	(method (doVerb)
		(person0 doVerb: &rest)
	)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)
)

(instance rope1 of View
	(properties
		x 131
		y 36
		view 710
		loop 6
		priority 1
		signal 16400
	)
)

(instance rope2 of View
	(properties
		x 195
		y 37
		view 710
		loop 6
		priority 1
		signal 16400
	)
)

(instance girlPic1 of Feature
	(properties
		x 56
		y 21
		nsTop 1
		nsBottom 41
		nsRight 112
		description {the painting}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 710 3) ; "You find the casino's artwork totally tasteless..."
				(TPrint 710 4) ; "...and fascinating!"
			)
			(3 ; Do
				(TPrint 710 5) ; "Don't touch those paintings!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance girlPic2 of Feature
	(properties
		x 56
		y 21
		nsTop 1
		nsLeft 203
		nsBottom 43
		nsRight 319
		description {the painting}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 710 3) ; "You find the casino's artwork totally tasteless..."
				(TPrint 710 4) ; "...and fascinating!"
			)
			(3 ; Do
				(TPrint 710 5) ; "Don't touch those paintings!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rouletteArea of Feature
	(properties
		x 23
		y 70
		nsTop 45
		nsBottom 96
		nsRight 46
		description {the roulette tables}
		sightAngle 40
		lookStr {You don't know how to play roulette.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 6) ; "You? Play roulette? HA!"
			)
			(5 ; Talk
				(TPrint 710 7) ; "The roulette players are too busy to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Silver_Dollar
						(TPrint 710 8) ; "Save your money, Larry! You'll only lose anyway!"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blackjackArea of Feature
	(properties
		x 278
		y 62
		nsTop 42
		nsLeft 237
		nsBottom 82
		nsRight 319
		description {the blackjack tables}
		sightAngle 40
		lookStr {Blackjack is just not your game. You can remember that much from "Leisure Suit Larry 1!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 9) ; "If you want to play blackjack, buy "Leisure Suit Larry 1!""
				(TPrint 710 10 #at -1 185) ; "(Another fine Al Lowe game!)"
			)
			(5 ; Talk
				(TPrint 710 11) ; "The blackjack players are too busy to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Silver_Dollar
						(TPrint 710 8) ; "Save your money, Larry! You'll only lose anyway!"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chandelier of Feature
	(properties
		x 164
		y 107
		z 73
		nsTop 46
		nsLeft 134
		nsBottom 86
		nsRight 184
		description {the chandelier}
		sightAngle 40
		lookStr {Isn't it wonderful what they're doing with polymers these days?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 12) ; "You try your best, but just can't reach the chandelier from your current (low) altitude."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chandelier2 of Feature
	(properties
		x 164
		y 107
		z 73
		nsTop 25
		nsLeft 151
		nsBottom 44
		nsRight 177
		description {the chandelier}
		lookStr {Isn't it wonderful what they're doing with polymers these days?}
	)

	(method (doVerb theVerb invItem)
		(chandelier doVerb: theVerb invItem)
	)
)

(instance ballroom of Feature
	(properties
		x 156
		y 22
		nsLeft 120
		nsBottom 45
		nsRight 199
		description {the ballroom entrance}
		sightAngle 40
		lookStr {It appears a crowd has gathered inside the exclusive Tramp Ballroom.}
	)
)

(instance statue1 of Feature
	(properties
		x 229
		y 170
		nsTop 151
		nsLeft 212
		nsBottom 189
		nsRight 246
		description {the statue}
		sightAngle 40
		lookStr {Naked girls holding balloon bouquets have been a favorite subject for the world's greatest artists for many centuries.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 13) ; "Larry! She's only a statue!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance statue2 of Feature
	(properties
		x 258
		y 74
		nsTop 45
		nsLeft 248
		nsBottom 104
		nsRight 268
		sightAngle 40
	)

	(method (doVerb)
		(statue1 doVerb: &rest)
	)
)

(instance statue3 of Feature
	(properties
		x 69
		y 109
		nsTop 86
		nsLeft 55
		nsBottom 133
		nsRight 84
		sightAngle 40
	)

	(method (doVerb)
		(statue1 doVerb: &rest)
	)
)

(instance statue4 of Feature
	(properties
		x 116
		y 51
		nsTop 28
		nsLeft 108
		nsBottom 75
		nsRight 124
		sightAngle 40
	)

	(method (doVerb)
		(statue1 doVerb: &rest)
	)
)

(instance statue5 of Feature
	(properties
		x 159
		y 125
		nsTop 96
		nsLeft 148
		nsBottom 154
		nsRight 170
		description {the statue}
		sightAngle 40
		lookStr {What a set of balloons she has!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 710 14) ; "You find the faux marble cool and exciting to the touch!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poker1 of Feature
	(properties
		x 48
		y 82
		nsTop 66
		nsLeft 43
		nsBottom 99
		nsRight 54
		description {the video poker machine}
		sightAngle 40
		approachX 70
		approachY 93
	)

	(method (doVerb theVerb invItem &tmp [str 300])
		(switch theVerb
			(2 ; Look
				(Format @str 710 15 gPokerJackpot gPokerJackpot) ; "The only machines accessible to you are these progressive video poker machines. You notice the jackpot is up to $%d!"
				(TPrint @str)
			)
			(3 ; Do
				(if (gEgo has: 17) ; Silver_Dollar
					(Format @str 710 16 gSilvDollars gSilvDollars) ; "You insert all %d of your silver dollars into the video poker machine."
					(Points 4 133)
					(TPrint @str)
					(gCurRoom newRoom: 720)
				else
					(TPrint 710 17) ; "You have no silver dollars with which to play this machine."
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Silver_Dollar
						(if (gEgo has: 17) ; Silver_Dollar
							(Format @str 710 18 gSilvDollars gSilvDollars) ; "You insert all %d of your silver dollars into the video poker machine."
							(TPrint @str)
							(gCurRoom newRoom: 720)
						else
							(TPrint 710 17) ; "You have no silver dollars with which to play this machine."
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poker3 of Feature
	(properties
		x 95
		y 115
		nsTop 80
		nsLeft 84
		nsBottom 135
		nsRight 107
		sightAngle 40
		approachX 109
		approachY 115
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker5 of Feature
	(properties
		x 127
		y 127
		nsTop 118
		nsLeft 108
		nsBottom 136
		nsRight 146
		sightAngle 40
		approachX 148
		approachY 135
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker6 of Feature
	(properties
		x 136
		y 99
		nsTop 82
		nsLeft 127
		nsBottom 117
		nsRight 146
		sightAngle 40
		approachX 151
		approachY 119
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker7 of Feature
	(properties
		x 212
		y 90
		nsTop 83
		nsLeft 177
		nsBottom 98
		nsRight 247
		sightAngle 40
		approachX 226
		approachY 106
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker8 of Feature
	(properties
		x 207
		y 113
		nsTop 105
		nsLeft 170
		nsBottom 122
		nsRight 245
		sightAngle 40
		approachX 212
		approachY 130
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker9 of Feature
	(properties
		x 292
		y 90
		nsTop 82
		nsLeft 270
		nsBottom 99
		nsRight 315
		sightAngle 40
		approachX 286
		approachY 107
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker10 of Feature
	(properties
		x 309
		y 124
		nsTop 99
		nsLeft 301
		nsBottom 149
		nsRight 318
		sightAngle 40
		approachX 304
		approachY 126
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker11 of Feature
	(properties
		x 238
		y 138
		nsTop 129
		nsLeft 208
		nsBottom 148
		nsRight 300
		sightAngle 40
		approachX 238
		approachY 154
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker12 of Feature
	(properties
		x 273
		y 185
		nsTop 164
		nsLeft 246
		nsBottom 185
		nsRight 319
		sightAngle 40
		approachX 273
		approachY 174
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker15 of Feature
	(properties
		x 48
		y 116
		nsTop 107
		nsLeft 8
		nsBottom 125
		nsRight 55
		sightAngle 40
		approachX 48
		approachY 131
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker16 of Feature
	(properties
		x 10
		y 146
		nsTop 126
		nsBottom 167
		nsRight 20
		sightAngle 40
		approachX 25
		approachY 143
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker17 of Feature
	(properties
		x 59
		y 162
		nsTop 149
		nsLeft 21
		nsBottom 168
		nsRight 111
		sightAngle 40
		approachX 59
		approachY 160
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker18 of Feature
	(properties
		x 112
		y 179
		nsTop 169
		nsLeft 104
		nsBottom 189
		nsRight 121
		sightAngle 40
		approachX 128
		approachY 188
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker19 of Feature
	(properties
		x 80
		y 63
		nsTop 55
		nsLeft 56
		nsBottom 72
		nsRight 105
		sightAngle 40
		approachX 93
		approachY 77
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker20 of Feature
	(properties
		x 228
		y 63
		nsTop 44
		nsLeft 221
		nsBottom 82
		nsRight 236
		sightAngle 40
		approachX 224
		approachY 80
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker21 of Feature
	(properties
		x 207
		y 64
		nsTop 57
		nsLeft 194
		nsBottom 72
		nsRight 220
		sightAngle 40
		approachX 209
		approachY 81
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

(instance poker22 of Feature
	(properties
		x 100
		y 128
		nsTop 118
		nsLeft 79
		nsBottom 138
		nsRight 121
		sightAngle 40
		approachX 111
		approachY 144
	)

	(method (doVerb)
		(poker1 doVerb: &rest)
	)
)

