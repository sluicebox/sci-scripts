;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use MoveToAndScale)
(use TransPlane)
(use Array)
(use Print)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	MapRoom 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(instance MapRoom of Room
	(properties
		style 9
		picAngle 15
	)

	(method (init &tmp temp0)
		(= local6
			(IntArray
				newWith:
					16
					60
					259
					231
					182
					77
					239
					230
					264
					247
					240
					259
					250
					266
					212
					212
					212
			)
		)
		(= local7
			(IntArray
				newWith:
					16
					38
					77
					82
					87
					96
					113
					67
					89
					98
					103
					109
					110
					119
					132
					132
					132
			)
		)
		(= local8
			(IntArray
				newWith:
					16
					880
					780
					600
					300
					800
					380
					420
					200
					900
					400
					240
					500
					350
					100
					170
					140
			)
		)
		(= local9
			(IntArray
				newWith: 16 12 13 14 15 16 17 18 19 20 21 22 23 24 25 29 26
			)
		)
		(= local10 (IntArray newWith: 16 5 3 6 4 1 7 8 9 10 11 12 13 14 2 2 2))
		((= plane gThePlane)
			picture: -1
			back: 0
			style: style
			setRect: 0 0 319 199 1
		)
		(if (gPqFlags test: 29)
			(gPqFlags clear: 25)
			(gPqFlags clear: 26)
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(= gOverlays -1)
		(= local3 (List new:))
		(Sounds eachElementDo: #fade 0 10 10 1)
		(gGame setScript: scaleDown)
		(gTheIconBar state: (| (gTheIconBar state:) $0004))
	)

	(method (dispose)
		(gGame setCursor: local12 1)
		(gGame setScript: 0)
		(gTheIconBar enable:)
		(gThePlane setRect: 0 0 319 152 1)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(cond
			((!= (scaleDown state:) 3))
			((and local3 (= temp0 (local3 firstTrue: #onMe gMouseX gMouseY)))
				(if (!= local4 temp0)
					(= local4 temp0)
					(if (signpost dialog:)
						((signpost dialog:) dispose:)
					)
					(signpost
						font: 999
						fore: 33
						plane: TransPlane
						mode: 1
						width: 75
						addText: (temp0 noun:) 0 0 1
					)
					(= temp3 ((signpost dialog:) nsBottom:))
					(signpost
						x:
							(if (< (temp0 x:) 266)
								(Max 5 (- (temp0 x:) 28))
							else
								266
							)
						y:
							(if (> (+ (temp0 y:) temp3) 200)
								(- (temp0 y:) (+ temp3 7))
							else
								(+ (temp0 y:) 7)
							)
						modeless: 2
						init:
					)
					(gPrints delete: signpost)
				)
			)
			((signpost dialog:)
				((signpost dialog:) dispose:)
				(gTheCursor show:)
				(= local4 0)
			)
		)
		(cond
			((!= (scaleDown state:) 3))
			(
				(and
					local13
					(= temp1 (local13 firstTrue: #onMe gMouseX gMouseY))
					(!= local14 temp1)
				)
				(if local14
					(local14 doit: 0)
				)
				(temp1 doit: 1)
				(= local14 temp1)
				(if (zonepost dialog:)
					((zonepost dialog:) dispose:)
				)
				(zonepost
					font: 999
					mode: 1
					width: 75
					back: 0
					fore: 22
					addText: (temp1 noun:) 0 0 1
					x: 20
					y: 150
					modeless: 2
					init:
				)
				(gPrints delete: zonepost)
			)
		)
	)
)

(instance mapMusic of Sound
	(properties)
)

(instance map of Actor
	(properties
		x 159
		y 100
		maxScale 127
		fixPriority 1
		view 8017
		yStep 5
		scaleSignal 1
		xStep 5
		origStep 2313
		moveSpeed 0
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 140)
			(= y 93)
		)
		(|= signal $6800)
		(super init:)
	)
)

(instance mapMover of MoveToAndScale
	(properties)

	(method (doit &tmp temp0 temp1 [temp2 4])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(if
				(<=
					(= temp1 (GetDistance x y (client x:) (client y:)))
					(client xStep:)
				)
				(= temp0 const)
			else
				(= temp0 (+ (/ (* slopeNum temp1) slopeDen) const))
			)
			(client scaleX: temp0 scaleY: temp0)
			(return (= temp1 (DoBresen self)))
		else
			(return 0)
		)
	)
)

(instance zoneFeature1 of Feature
	(properties
		noun 15
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 113 257 99 257 106 254 111 255 117 251 117 249 115 244 115 237 120 229 119
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone1)
			(zone1 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone1))
					(zone1 init:)
				)
			)
			((gCast contains: zone1)
				(zone1 dispose:)
			)
		)
	)
)

(instance zoneFeature2 of Feature
	(properties
		noun 16
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 94 227 94 232 100 237 100 242 103 242 107 229 113 229 116 213 116
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone2)
			(zone2 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone2))
					(zone2 init:)
				)
			)
			((gCast contains: zone2)
				(zone2 dispose:)
			)
		)
	)
)

(instance zoneFeature3 of Feature
	(properties
		noun 17
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 129 182 127 184 125 184 120 187 116 229 116 229 119 225 124 225 128 199 128
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone3)
			(zone3 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone3))
					(zone3 init:)
				)
			)
			((gCast contains: zone3)
				(zone3 dispose:)
			)
		)
	)
)

(instance zoneFeature4 of Feature
	(properties
		noun 18
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 117 254 112 257 106 257 99 271 91 271 89 279 89 282 85 283 86 282 91 289 91 289 104 274 104 273 124 259 124
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone4)
			(zone4 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone4))
					(zone4 init:)
				)
			)
			((gCast contains: zone4)
				(zone4 dispose:)
			)
		)
	)
)

(instance zoneFeature5 of Feature
	(properties
		noun 19
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 160 263 161 267 158 266 165 269 167 244 189 211 189 206 186 211 183 214 183 213 178 220 178
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone5)
			(zone5 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone5))
					(zone5 init:)
				)
			)
			((gCast contains: zone5)
				(zone5 dispose:)
			)
		)
	)
)

(instance zoneFeature6 of Feature
	(properties
		noun 20
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 97 185 97 191 95 189 94 177 94 171 96 162 96 165 88 161 88 161 85 163 83 171 83 174 80 180 81 183 84 190 85 192 82 213 86 213 101 176 101
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone6)
			(zone6 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone6))
					(zone6 init:)
				)
			)
			((gCast contains: zone6)
				(zone6 dispose:)
			)
		)
	)
)

(instance zoneFeature7 of Feature
	(properties
		noun 21
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 118 169 111 173 108 174 105 163 101 213 101 213 116 187 116 184 119 184 126 181 128 170 122 177 116
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone7)
			(zone7 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone7))
					(zone7 init:)
				)
			)
			((gCast contains: zone7)
				(zone7 dispose:)
			)
		)
	)
)

(instance zoneFeature8 of Feature
	(properties
		noun 22
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 82 122 80 132 80 156 81 161 85 160 94 146 99 155 108 167 108 169 106 173 106 169 112 168 118 126 118 120 114 116 117 111 113 99 123 84 117 69 117 68 105 54 102 70 81 77 82 80 82 85 80 115 80
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone8)
			(zone8 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone8))
					(zone8 init:)
				)
			)
			((gCast contains: zone8)
				(zone8 dispose:)
			)
		)
	)
)

(instance zoneFeature9 of Feature
	(properties
		noun 23
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 123 80 119 83 116 80 110 80 114 71 113 68 104 64 104 47 129 47 133 38 139 44 143 44 146 46 150 46 154 49 151 52 151 65 146 65 146 77 140 80
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone9)
			(zone9 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone9))
					(zone9 init:)
				)
			)
			((gCast contains: zone9)
				(zone9 dispose:)
			)
		)
	)
)

(instance zoneFeature10 of Feature
	(properties
		noun 24
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 80 80 82 76 81 70 81 49 76 41 76 23 64 23 55 29 49 105 47 104 65 113 68 114 72 110 80
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone10)
			(zone10 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone10))
					(zone10 init:)
				)
			)
			((gCast contains: zone10)
				(zone10 dispose:)
			)
		)
	)
)

(instance zoneFeature11 of Feature
	(properties
		noun 25
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 86 209 86 209 69 226 71 240 83 254 77 256 73 277 71 280 74 277 77 282 80 287 82 278 89 272 89 270 93 244 106 237 100 232 100 226 94 213 94
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone11)
			(zone11 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone11))
					(zone11 init:)
				)
			)
			((gCast contains: zone11)
				(zone11 dispose:)
			)
		)
	)
)

(instance zoneFeature12 of Feature
	(properties
		noun 26
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 138 240 138 240 144 226 144 222 148 216 146 208 154 208 150 205 150 205 141 198 142 194 137 186 137 186 133 194 133 199 128 225 128
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone12)
			(zone12 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone12))
					(zone12 init:)
				)
			)
			((gCast contains: zone12)
				(zone12 dispose:)
			)
		)
	)
)

(instance zoneFeature13 of Feature
	(properties
		noun 27
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 138 225 124 230 119 236 120 244 115 249 115 250 117 256 117 257 124 248 124 247 136 241 136 240 138
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone13)
			(zone13 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone13))
					(zone13 init:)
				)
			)
			((gCast contains: zone13)
				(zone13 dispose:)
			)
		)
	)
)

(instance zoneFeature14 of Feature
	(properties
		noun 28
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 126 151 128 162 128 159 132 168 138 177 138 175 144 179 156 146 155 150 160 145 160 114 132 136 124 126 118 170 118
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone14)
			(zone14 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone14))
					(zone14 init:)
				)
			)
			((gCast contains: zone14)
				(zone14 dispose:)
			)
		)
	)
)

(instance zoneFeature15 of Feature
	(properties
		noun 29
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 65 151 53 153 51 153 48 151 47 153 42 161 42 188 49 189 51 175 53 175 57 179 57 188 74 181 74 181 77 189 80 192 75 204 70 209 74 209 86 193 82 191 85 183 84 178 80 174 80 172 83 163 83 162 84 159 84 156 81 141 80 141 79 146 77 146 65
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone15)
			(zone15 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone15))
					(zone15 init:)
				)
			)
			((gCast contains: zone15)
				(zone15 dispose:)
			)
		)
	)
)

(instance zoneFeature16 of Feature
	(properties
		noun 30
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 46 144 44 139 44 134 38 132 35 124 35 120 30 121 20 103 6 155 6 161 10 157 14 157 18 154 20 154 22 158 22 161 18 168 18 167 23 186 24 214 20 214 19 221 19 222 24 248 22 247 28 238 28 238 34 233 34 232 45 195 45 194 48 191 51 188 51 188 48 163 42 154 42 152 46
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone17)
			(zone16 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone16))
					(zone16 init:)
				)
			)
			((gCast contains: zone16)
				(zone16 dispose:)
			)
		)
	)
)

(instance zoneFeature17 of Feature
	(properties
		noun 31
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 31 43 38 43 38 27 58 28 59 22 62 17 71 20 74 16 78 20 83 18 82 14 84 11 88 13 98 7 104 7 121 20 120 30 123 35 133 35 133 37 128 47 28 49
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone17)
			(zone17 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone17))
					(zone17 init:)
				)
			)
			((gCast contains: zone17)
				(zone17 dispose:)
			)
		)
	)
)

(instance zoneFeature18 of Feature
	(properties
		noun 32
	)

	(method (init)
		(local13 add: self)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 149 226 144 240 144 242 151 244 151 247 147 252 147 255 152 253 155 243 155 241 158 228 160 220 160
					yourself:
				)
		)
	)

	(method (dispose)
		(local13 delete: self)
		(if (gCast contains: zone18)
			(zone18 dispose:)
		)
		(self setPolygon: 0)
	)

	(method (doit param1)
		(cond
			(param1
				(if (not (gCast contains: zone18))
					(zone18 init:)
				)
			)
			((gCast contains: zone18)
				(zone18 dispose:)
			)
		)
	)
)

(instance zone1 of View
	(properties
		x 254
		y 107
		view 8017
		loop 2
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 244)
			(= y 109)
		)
		(super init: &rest)
	)
)

(instance zone2 of View
	(properties
		x 229
		y 101
		view 8017
		loop 2
		cel 1
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 221)
			(= y 103)
		)
		(super init: &rest)
	)
)

(instance zone3 of View
	(properties
		x 212
		y 120
		view 8017
		loop 2
		cel 2
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 207)
			(= y 121)
		)
		(super init: &rest)
	)
)

(instance zone4 of View
	(properties
		x 271
		y 103
		view 8017
		loop 2
		cel 3
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 265)
			(= y 103)
		)
		(super init: &rest)
	)
)

(instance zone5 of View
	(properties
		x 236
		y 167
		view 8017
		loop 2
		cel 4
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 226)
			(= y 168)
		)
		(super init: &rest)
	)
)

(instance zone6 of View
	(properties
		x 204
		y 88
		view 8017
		loop 2
		cel 5
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 196)
			(= y 89)
		)
		(super init: &rest)
	)
)

(instance zone7 of View
	(properties
		x 198
		y 106
		view 8017
		loop 2
		cel 6
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 188)
			(= y 108)
		)
		(super init: &rest)
	)
)

(instance zone8 of View
	(properties
		x 102
		y 91
		view 8017
		loop 2
		cel 7
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 109)
			(= y 96)
		)
		(super init: &rest)
	)
)

(instance zone9 of View
	(properties
		x 129
		y 55
		view 8017
		loop 2
		cel 8
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 126)
			(= y 57)
		)
		(super init: &rest)
	)
)

(instance zone10 of View
	(properties
		x 66
		y 57
		view 8017
		loop 2
		cel 9
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 67)
			(= y 59)
		)
		(super init: &rest)
	)
)

(instance zone11 of View
	(properties
		x 251
		y 89
		view 8017
		loop 2
		cel 10
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 238)
			(= y 88)
		)
		(super init: &rest)
	)
)

(instance zone12 of View
	(properties
		x 217
		y 134
		view 8017
		loop 2
		cel 11
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 212)
			(= y 135)
		)
		(super init: &rest)
	)
)

(instance zone13 of View
	(properties
		x 240
		y 126
		view 8017
		loop 2
		cel 12
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 236)
			(= y 127)
		)
		(super init: &rest)
	)
)

(instance zone14 of View
	(properties
		x 159
		y 142
		view 8017
		loop 2
		cel 13
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 156)
			(= y 145)
		)
		(super init: &rest)
	)
)

(instance zone15 of View
	(properties
		x 169
		y 62
		view 8017
		loop 2
		cel 14
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 165)
			(= y 62)
		)
		(super init: &rest)
	)
)

(instance zone16 of View
	(properties
		x 170
		y 30
		view 8017
		loop 2
		cel 15
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= x 175)
			(= y 31)
		)
		(super init: &rest)
	)
)

(instance zone17 of View
	(properties
		x 76
		y 27
		view 8017
		loop 3
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= loop 2)
			(= cel 16)
			(= x 76)
			(= y 30)
		)
		(super init: &rest)
	)
)

(instance zone18 of View
	(properties
		x 233
		y 150
		view 8017
		loop 2
		cel 17
	)

	(method (init)
		(if (IsHiRes)
			(= view 8018)
			(= loop 2)
			(= cel 17)
			(= x 229)
			(= y 152)
		)
		(super init: &rest)
	)
)

(instance onMeForward of Fwd
	(properties)

	(method (doit &tmp temp0 temp1)
		(if (client onMe: gMouseX gMouseY)
			(if (!= local11 (client yStep:))
				(= local11 (client yStep:))
			)
			(if (> (= temp0 (self nextCel:)) (client lastCel:))
				(self cycleDone:)
			else
				(client cel: temp0)
			)
		else
			(client cel: 0)
		)
		(return 0)
	)
)

(instance PushPin of Prop
	(properties
		priority 3
		fixPriority 1
	)

	(method (new param1 &tmp temp0)
		(|= signal $6000)
		(if (gPqFlags test: (local9 at: param1))
			(= temp0 (super new:))
			(temp0
				yStep: param1
				signal: signal
				x: (local6 at: param1)
				y: (local7 at: param1)
				noun: (local10 at: param1)
			)
			(return temp0)
		else
			(return 0)
		)
	)

	(method (init)
		(self
			view: 8017
			loop: 1
			cel: 0
			cycleSpeed: 3
			setCycle: (onMeForward new:)
		)
		(super init:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if (and (<= nsLeft temp0 nsRight) (<= nsTop temp1 nsBottom))
			(= local0 (local8 at: yStep))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance scaleDown of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGlobalSound0 number: 0 stop:)
				(gGlobalSound1 number: 0 stop:)
				(map init:)
				(gCurRoom drawPic: 0 9)
				(= local13 (Collect new:))
				(zoneFeature1 init:)
				(zoneFeature2 init:)
				(zoneFeature3 init:)
				(zoneFeature4 init:)
				(zoneFeature5 init:)
				(zoneFeature6 init:)
				(zoneFeature7 init:)
				(zoneFeature8 init:)
				(zoneFeature9 init:)
				(zoneFeature10 init:)
				(zoneFeature11 init:)
				(zoneFeature12 init:)
				(zoneFeature13 init:)
				(zoneFeature14 init:)
				(zoneFeature15 init:)
				(zoneFeature16 init:)
				(zoneFeature17 init:)
				(zoneFeature18 init:)
				(= cycles 2)
			)
			(2
				(mapMusic
					init:
					number: 17
					setPri: 0
					setVol: 0
					play:
					setLoop: -1
					fade: 127 4 2 0
				)
				(= local1 (map maxScale:))
				(map
					view: (if (IsHiRes) 8018 else 8017)
					x: (if (IsHiRes) 140 else 159)
					y: (if (IsHiRes) 93 else 100)
					scaleSignal: 0
					scaleX: local1
					scaleY: local1
				)
				(= cycles 2)
			)
			(3
				(for ((= temp0 0)) (< temp0 16) ((++ temp0))
					(if (= temp1 (PushPin new: temp0))
						(local3 add: temp1)
						(temp1 init:)
						(= temp1 0)
					)
				)
				(= local12 (gGame setCursor: gTheArrowCursor 1))
			)
			(4
				(local3 eachElementDo: #dispose release: dispose:)
				(local13 eachElementDo: #dispose release: dispose:)
				(= local13 0)
				(= local3 0)
				(gGame handsOff:)
				(= temp0
					(Max
						1
						(/ (GetDistance (map x:) (map y:) local1 local2) 10)
					)
				)
				(map origStep: (| (<< temp0 $0008) temp0))
				(map setMotion: mapMover local1 local2 1 self)
				(if (signpost dialog:)
					((signpost dialog:) dispose:)
				)
				(if (zonepost dialog:)
					((zonepost dialog:) dispose:)
				)
				(mapMusic fade: 0 4 2 1)
			)
			(5
				(= cycles 3)
			)
			(6
				(cond
					(
						(and
							(>= gDay 3)
							(or (gPqFlags test: 29) (gPqFlags test: 25))
							(or (== local0 170) (== local0 100))
						)
						(gPqFlags clear: 29)
						(gPqFlags clear: 25)
						(gPqFlags set: 26)
						(= local0 140)
					)
					((== local0 170)
						(gPqFlags clear: 29)
						(gPqFlags clear: 25)
						(gPqFlags set: 26)
					)
				)
				(gCurRoom newRoom: local0)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((!= state 3)
				(super handleEvent: event)
			)
			(
				(and
					(= temp1 (local3 firstTrue: #onMe (event x:) (event y:)))
					(& (event type:) evMOUSE)
				)
				(= local1 (temp1 x:))
				(= local2 (temp1 y:))
				(= temp0
					(Max
						(/ (GetDistance local1 local2 (map x:) (map y:)) 11)
						1
					)
				)
				(map origStep: (| (<< temp0 $0008) temp0))
				(self cue:)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)
)

(instance zonepost of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance signpost of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

