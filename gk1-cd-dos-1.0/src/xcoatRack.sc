;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use n013)
(use Polygon)
(use Feature)
(use System)

(public
	xcoatRack 0
	xcoffeeStuff 1
	xbooksBehindLadder 2
	xbooksLeftOfLadder 3
	xcurtainDoor 4
	xdrawers 5
	xgargoyle 6
	xgermanBooks 7
	xladder 8
	xbalcony 9
	xcashRegister 10
	xcoffeeTable 11
	xbooksBottomRight 12
	xbooksBottomLeft 13
	xcoffeeBooks 14
	xbookRack 15
	xwindowBooks 16
	xchandelier 17
	xrightWindow 18
	xdesk 19
	xdoorMat 20
	xdeskLamp 21
	xsnakeBooks 22
	xdeskTop 23
	xphone 24
	xmoney 25
	xallElse 26
	xbehindPic 27
	xdeskBooks 28
)

(instance xcoatRack of Feature
	(properties
		noun 18
		modNum 211
		nsLeft 103
		nsTop 42
		nsRight 114
		nsBottom 85
		sightAngle 20
		approachX 110
		approachY 98
		x 108
		y 58
	)

	(method (init)
		(self approachVerbs: 9 8 12) ; Move, Operate, Pickup
		(super init:)
	)
)

(instance xcoffeeStuff of Feature
	(properties
		noun 19
		modNum 211
		nsLeft 90
		nsTop 100
		nsRight 118
		nsBottom 120
		sightAngle 20
		x 118
		y 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (IsFlag 367))
					(SetFlag 367)
					(gCurRoom setScript: (ScriptID 211 4)) ; getSomeCoffee
				else
					(gMessager say: noun 12 14 1 0 211) ; "My kidneys are already floating, thanks."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance xbalcony of Feature
	(properties
		noun 3
		modNum 211
		sightAngle 20
		x 31
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 1 22 136 22 0 78 yourself:)
		)
		(super init:)
	)
)

(instance xsnakeBooks of Feature
	(properties
		noun 11
		modNum 211
		sightAngle 20
		x 200
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 22 213 22 212 36 171 34
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: (ScriptID 212 10)) ; getSnakeBook
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance xbooksBehindLadder of Feature
	(properties
		noun 4
		modNum 211
		sightAngle 20
		x 200
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 41 212 70 171 65 169 40
					yourself:
				)
		)
		(super init:)
	)
)

(instance xbooksLeftOfLadder of Feature
	(properties
		noun 5
		modNum 211
		sightAngle 20
		x 137
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 35 161 39 157 84 118 78
					yourself:
				)
		)
		(super init:)
	)
)

(instance xbooksBottomRight of Feature
	(properties
		noun 6
		modNum 211
		sightAngle 20
		x 308
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 146 263 146 282 131 287 101 318 91
					yourself:
				)
		)
		(super init:)
	)
)

(instance xbooksBottomLeft of Feature
	(properties
		noun 12
		modNum 211
		sightAngle 20
		x 42
		y 138
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 114 67 131 89 130 118 146 0 147
					yourself:
				)
		)
	)
)

(instance xcoffeeBooks of Feature
	(properties
		noun 8
		modNum 211
		sightAngle 20
		x 172
		y 198
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 174 117 195 129 189 137 155 134 140 121
					yourself:
				)
		)
		(super init:)
	)
)

(instance xgermanBooks of Feature
	(properties
		noun 9
		modNum 211
		nsLeft 128
		nsTop 22
		nsRight 162
		nsBottom 32
		sightAngle 20
		x 147
		y 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: (ScriptID 212 5)) ; getTheGermanBook
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance xbookRack of Feature
	(properties
		noun 10
		modNum 211
		nsLeft 245
		nsTop 120
		nsRight 268
		nsBottom 145
		sightAngle 20
		x 257
		y 134
	)
)

(instance xwindowBooks of Feature
	(properties
		noun 7
		modNum 211
		sightAngle 20
		x 43
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 103 65 74 76 81 78 100 25 125 25 120 3 114 0 116
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: (ScriptID 210 19)) ; getReferenceBooks
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xchandelier of Feature
	(properties
		noun 15
		modNum 211
		sightAngle 20
		x 167
		y 52
		z 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 41 156 46 171 35 189 51 177 64 148 63 132 49
					yourself:
				)
		)
		(super init:)
	)
)

(instance xgargoyle of Feature
	(properties
		noun 30
		modNum 211
		nsLeft 194
		nsTop 98
		nsRight 218
		nsBottom 125
		sightAngle 20
		approachX 196
		approachY 132
		x 208
		y 116
	)

	(method (init)
		(self approachVerbs: 9 8 12 11) ; Move, Operate, Pickup, Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(if (IsFlag 6)
					(gMessager say: noun 11 8 0 0 211) ; "Life is too short to talk to ugly statues."
				else
					(gMessager say: noun 11 12 0 0 211) ; "The gargoyle can hardly take the place of Grace."
				)
			)
			(10 ; Ask
				(if (IsFlag 6)
					(gMessager say: noun 10 8 0 0 211) ; "Life is too short to talk to ugly statues."
				else
					(gMessager say: noun 10 12 0 0 211) ; "The gargoyle can hardly take the place of Grace."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xrightWindow of Feature
	(properties
		noun 41
		modNum 211
		sightAngle 20
		approachX 60
		approachY 116
		x 19
		y 81
	)

	(method (init)
		(self
			approachVerbs: 7 6 ; Look, Open
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 45 60 43 83 25 90 24 68 yourself:)
				((Polygon new:) type: PTotalAccess init: 8 76 8 97 0 103 0 79 yourself:)
		)
		(super init:)
	)
)

(instance xdrawers of Feature
	(properties
		noun 25
		modNum 211
		nsLeft 229
		nsTop 96
		nsRight 237
		nsBottom 112
		sightAngle 20
		x 231
		y 105
	)
)

(instance xdesk of Feature
	(properties
		noun 26
		modNum 211
		sightAngle 20
		x 200
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 91 223 96 267 74 267 100 224 124 192 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance xcurtainDoor of Feature
	(properties
		noun 24
		modNum 211
		nsLeft 298
		nsTop 42
		nsRight 319
		nsBottom 93
		sightAngle 20
		approachX 285
		approachY 136
		x 300
		y 55
	)

	(method (init)
		(self approachVerbs: 11) ; Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if (and (== gDay 10) (not (IsFlag 389)))
					(SetFlag 409)
					(gEgo setScript: (ScriptID 210 18)) ; readMaliasNote
				else
					(gEgo setScript: (ScriptID 210 15)) ; exitToGabsRoom
				)
			)
			(13 ; Walk
				(if (and (== gDay 10) (not (IsFlag 389)))
					(SetFlag 409)
					(gEgo setScript: (ScriptID 210 18)) ; readMaliasNote
				else
					(gEgo setScript: (ScriptID 210 15)) ; exitToGabsRoom
				)
			)
			(11 ; Talk
				(if (IsFlag 6)
					(gMessager say: noun theVerb 8 0 0 211) ; "Is anyone back there?"
				else
					(gMessager say: noun theVerb 12 0 0 211) ; "Gabriel is feeling a little tense, and would prefer not to tempt the fates by talking to closed doors."
				)
			)
			(8 ; Operate
				(if (and (== gDay 10) (not (IsFlag 389)))
					(SetFlag 409)
					(gEgo setScript: (ScriptID 210 18)) ; readMaliasNote
				else
					(gEgo setScript: (ScriptID 210 15)) ; exitToGabsRoom
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xladder of Feature
	(properties
		noun 31
		modNum 211
		sightAngle 30
		x 215
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 94 179 22 201 21 192 98
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (IsFlag 6)
					(gEgo setScript: (ScriptID 213 3)) ; egoClimbLadder
				else
					(gMessager say: noun theVerb 12 0 0 211) ; "It just wouldn't be the same without Grace here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xcashRegister of Feature
	(properties
		noun 13
		modNum 211
		sightAngle 20
		x 211
		y 86
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 90 219 94 202 91 202 77 211 73 215 74 216 76 224 84
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: (ScriptID 210 16)) ; openTheRegister
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xmoney of Feature
	(properties
		noun 21
		modNum 211
		y 49
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 95 0 141 25 140 36 58 80 38 67 75 38 42 25
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(SetFlag 368)
				((ScriptID 210 17) dispose:) ; drawer
			)
			(else
				(if (not (OneOf theVerb 9 7 5 32)) ; Move, Look, giftCert, hundred
					(super doVerb: 0)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance xallElse of Feature
	(properties
		noun 22
		modNum 211
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 140 0 140 83 0 83 0 0 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(SetFlag 369)
				((ScriptID 210 17) dispose:) ; drawer
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xcoffeeTable of Feature
	(properties
		noun 20
		modNum 211
		sightAngle 20
		x 134
		y 199
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 144 119 144 108 140 107 138 103 132 82 126 80 123 84 121 129 130 141 128 144 133 200 141 213 131
					yourself:
				)
		)
		(super init:)
	)
)

(instance xdoorMat of Feature
	(properties
		noun 29
		modNum 211
		nsLeft 77
		nsTop 87
		nsRight 117
		nsBottom 102
		sightAngle 20
		x 91
		y 61
	)
)

(instance xdeskLamp of Feature
	(properties
		noun 27
		modNum 211
		nsLeft 216
		nsTop 64
		nsRight 233
		nsBottom 78
		sightAngle 20
		x 222
		y 68
	)
)

(instance xdeskTop of Feature
	(properties
		noun 28
		modNum 211
		sightAngle 20
		x 225
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 89 226 73 238 75 251 72 269 74 221 97
					yourself:
				)
		)
		(super init:)
	)
)

(instance xphone of Feature
	(properties
		noun 37
		modNum 211
		nsLeft 242
		nsTop 68
		nsRight 261
		nsBottom 77
		sightAngle 20
		x 254
		y 70
	)
)

(instance xbehindPic of Feature
	(properties
		noun 43
		modNum 211
		nsLeft 255
		nsTop 41
		nsRight 283
		nsBottom 69
		sightAngle 20
		x 271
		y 70
	)
)

(instance xdeskBooks of Feature
	(properties
		noun 44
		modNum 211
		nsLeft 225
		nsTop 37
		nsRight 245
		nsBottom 72
		sightAngle 20
		x 235
		y 56
	)
)

