;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5012)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NYAvian12 0
)

(instance NYAvian12 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5011 ; NYAvian11
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5013 ; NYAvian13
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5029 ; NYAvianTetra
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5048
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (>= global413 2)
			(= picture 5105)
		else
			(= picture 5048)
		)
		(super init: &rest)
		(if (IsFlag 221)
			(avianStatue_0 case: 0 init:)
		else
			(avianStatue_0 case: 2 init:)
		)
		(statue init:)
		(avianRing init:)
		(avianDoors_0 init:)
		(sign_0 init:)
		(lowWall_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5135
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit
			nextRoom: 5013
			exitStyle: 0
			init:
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 200 223 295 12 394 223 yourself:)
		)
		(if (and (IsFlag 221) (IsFlag 223))
			(= picture 5140)
			(defaultExit nextRoom: 5029 exitStyle: 13)
		)
		(if (IsFlag 222)
			(stool init: global117)
		else
			(stoolFeat init:)
		)
		(doorKnob init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(tetDoor_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5050
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(pylons_180 init:)
		(redPlatform_180 init:)
		(lowWall_180 init:)
		(MyrmStatue_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5049
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5949)
		else
			(= picture 5049)
		)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(redPlatform_270 init:)
		(pylons_270 init:)
		(sign_270 init:)
		(gate_270 init:)
		(avianDoors_270 init:)
	)
)

(instance stoolFeat of Feature
	(properties
		nsBottom 222
		nsLeft 158
		nsRight 444
		nsTop 166
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 114)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114
				(SetFlag 222)
				(stool init: global117)
				(proc70_3 111)
				(proc70_10 111 gCurRoomNum)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stool of View
	(properties
		x 205
		y 232
		loop 4
		view 5002
	)

	(method (init)
		(if (IsFlag 223)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: &rest)
		(self signal: (& signal $efff) setHotspot: 2)
		(doorKnob init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 111)
				(ClearFlag 222)
				(doorKnob deleteHotspot:)
				(stoolFeat init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorKnob of View
	(properties
		noun 32
		x 224
		y 43
		loop 4
		view 5002
	)

	(method (init)
		(if (IsFlag 221)
			(if (IsFlag 223)
				(= cel 3)
			else
				(= cel 2)
			)
			(super init: global117)
			(self setHotspot: 2 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 222)
					(gCurRoom newRoom: 5014) ; NYAvian14
				else
					(proc1111_31 2 2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianRing of View
	(properties
		x 288
		y 157
		loop 6
		view 5002
	)

	(method (init)
		(if (IsFlag 221)
			(super init: global117)
		)
	)
)

(instance statue of Feature
	(properties
		nsBottom 158
		nsLeft 287
		nsRight 328
		nsTop 138
	)

	(method (init)
		(super init:)
		(self setHotspot: 48)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(SetFlag 221)
				(proc70_3 1)
				(avianRing init:)
				(gCurRoom setScript: soundScript)
				(avianStatue_0 case: 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(avianRingSnd setVol: 127 play: self)
			)
			(1
				(knobRevealSnd setVol: 127 play:)
				(self dispose:)
			)
		)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(== (gCurRoom heading:) 90)
				(IsFlag 222)
				(stool onMe: param1)
			)
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsBottom 202
		nsLeft 244
		nsRight 343
		nsTop 129
		nextRoom 5002
	)
)

(instance avianRingSnd of Sound
	(properties
		number 5106
		flags 5
	)
)

(instance knobRevealSnd of Sound
	(properties
		number 5101
		flags 5
	)
)

(instance tetDoor_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 294 -1 175 209 411 209 yourself:)
		)
	)
)

(instance avianStatue_0 of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 57 242 170 281 159 283 125 271 100 290 69 291 6 313 3 320 67 339 95 325 135 327 158 365 178 408 48 459 134 462 210 427 287 173 289 136 202 194 54 239 171 276 156 272 98 288 69
					yourself:
				)
		)
	)
)

(instance sign_0 of Feature
	(properties
		noun 3
		x 497
		y 61
		nsBottom 89
		nsLeft 471
		nsRight 523
		nsTop 33
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance avianDoors_0 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 119 15 120 17 139 -5 138
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 75 127 104 131 103 155 69 156
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 170 7 171 10 185 1 197
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 126 120 136 122 142 146 126 144
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 121 182 137 183 140 205 119 204
					yourself:
				)
		)
	)
)

(instance lowWall_0 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 207 13 201 145 203 144 217 150 232 1 234
					yourself:
				)
		)
	)
)

(instance pylons_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 149 48 140 63 140 68 153 77 194 44 197 32 194
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 142 161 145 150 154 159 162 191 135 188
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 394 162 401 157 409 163 415 187 391 190
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 454 171 457 162 464 170 466 188 447 189
					yourself:
				)
		)
	)
)

(instance redPlatform_270 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 195 134 184 240 185 341 184 406 187 457 185 569 193 461 214 244 214 98 211 5 201
					yourself:
				)
		)
	)
)

(instance sign_270 of Feature
	(properties
		noun 3
		x 238
		y 78
		nsBottom 97
		nsLeft 226
		nsRight 250
		nsTop 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gate_270 of Feature
	(properties
		noun 39
		x 296
		y 173
		nsBottom 180
		nsLeft 286
		nsRight 306
		nsTop 167
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance avianDoors_270 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 411 92 427 93 431 119 412 120
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 368 108 383 108 383 134 371 132
					yourself:
				)
		)
	)
)

(instance MyrmStatue_180 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 54 278 20 295 10 321 22 317 42 318 177 325 200 377 208 389 290 217 291 211 208 274 195 276 47
					yourself:
				)
		)
	)
)

(instance pylons_180 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 161 192 155 197 160 203 182 170 186
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 264 156 270 149 278 154 284 189 261 189
					yourself:
				)
		)
	)
)

(instance redPlatform_180 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 19 186 176 184 263 188 291 190 177 198 29 209 15 207
					yourself:
				)
		)
	)
)

(instance lowWall_180 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 311 170 591 166 589 202 309 191 311 175
					yourself:
				)
		)
	)
)

