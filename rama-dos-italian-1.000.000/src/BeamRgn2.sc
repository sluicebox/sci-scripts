;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2041)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	BeamRgn2 0
)

(instance BeamRgn2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2040 ; BeamRgn1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2042 ; BeamRgn3
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2043 ; BeamRgn4
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(2045 ; BeamRgn6
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		((ScriptID 200 0) addMigrant: 85) ; cplainRegion
	)

	(method (dispose)
		(if (or (== picObj faceN) (== picObj faceS))
			(ClearFlag 67)
			(ClearFlag 64)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2103
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sixExit_0 init:)
		(super init: &rest)
		(beam_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2106
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 64)
			(= picture 2146)
			(if
				(or
					(IsFlag 67)
					(and
						(== (proc70_9 21) -1)
						(not (proc55_5 22))
						(not (IsFlag 121))
					)
				)
				(lilReggie init: global117 setScript: reggieAtTrashScript)
			)
		else
			(gCurRoom setScript: 0)
		)
		(threeExit_90 init:)
		(super init: &rest)
		(sea_90 init:)
		(lights_90 init:)
		(if (IsFlag 64)
			(trashBiot_90 init:)
		else
			(trashDown_90 init:)
		)
	)
)

(instance reggieAtTrashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance lilReggie of Prop
	(properties
		x 305
		y 195
		view 2048
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2105
		edgeS 0
		edgeN 0
	)

	(method (init)
		(oneExit_180 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2104
		edgeS 0
		edgeN 0
	)

	(method (init)
		(fourExit_270 init:)
		(if (IsFlag 58)
			(if (== (proc70_9 55) 2043)
				(= picture 2139)
			else
				(= picture 2140)
			)
		)
		(super init: &rest)
		(NYMapPiece_3 init: global117)
		(CPMapPiece_2Cube init: global117)
		(lights_270 init:)
		(sea_270 init:)
		(if (not (IsFlag 58))
			(waxCube_270 init:)
		)
		(if
			(and
				(IsFlag 64)
				(not (IsFlag 67))
				(or (!= (proc70_9 21) -1) (proc55_5 22) (IsFlag 121))
			)
			(gCurRoom setScript: lowerTheBiot)
		)
	)
)

(instance NYMapPiece_3 of MigratingView
	(properties
		x 141
		y 269
		cel 2
		view 2021
		invItemID 85
	)
)

(instance CPMapPiece_2Cube of View
	(properties
		x 261
		y 186
		view 2021
	)

	(method (init)
		(if (!= (proc70_9 11) 2043)
			(return)
		)
		(super init: &rest)
	)
)

(instance beam_0 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 47 139 516 -1 589 0 589 90 451 97 282 128 212 186 53 188
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_0 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 0 197 0 189 42 203 93 157 106 97 61
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 393 0 518 -1 400 32 yourself:)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 2 391 1 396 34 204 93 190 53
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 7
		x 300
		y 24
		nsBottom 31
		nsLeft 129
		nsRight 471
		nsTop 18
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_270 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 467 1 587 1 590 83 511 56
					yourself:
				)
		)
	)
)

(instance waxCube_270 of Feature
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
					init: 278 125 316 126 319 155 313 179 277 180 274 155
					yourself:
				)
		)
	)
)

(instance sea_90 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 1 126 1 100 40 52 69 1 36
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 7
		x 292
		y 25
		nsBottom 30
		nsLeft 121
		nsRight 463
		nsTop 20
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance trashBiot_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
		(if (IsFlag 64)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 276 183 274 152 256 138 311 98 364 138 342 151 354 182
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PBarredAccess
						init: 278 187 281 171 298 161 316 161 333 166 341 181 367 181 367 187
						yourself:
					)
			)
		)
	)
)

(instance trashDown_90 of Feature
	(properties
		noun 9
		x 309
		y 173
		nsBottom 186
		nsLeft 279
		nsRight 340
		nsTop 161
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sixExit_0 of ExitFeature
	(properties
		x 273
		y 162
		nsBottom 236
		nsLeft 97
		nsRight 449
		nsTop 88
		nextRoom 2045
	)
)

(instance fourExit_270 of ExitFeature
	(properties
		x 297
		y 154
		nsBottom 229
		nsLeft 127
		nsRight 467
		nsTop 79
		nextRoom 2043
	)
)

(instance oneExit_180 of ExitFeature
	(properties
		x 315
		y 161
		nsBottom 238
		nsLeft 137
		nsRight 493
		nsTop 85
		nextRoom 2040
	)
)

(instance threeExit_90 of ExitFeature
	(properties
		x 311
		y 161
		nsBottom 228
		nsLeft 147
		nsRight 476
		nsTop 94
		nextRoom 2042
	)
)

(instance lowerTheBiot of Script
	(properties)

	(method (dispose)
		(biotLowering number: 2231 loop: 1 play:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 64)
				(biotLowering number: 2229 loop: 1 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance biotLowering of Sound
	(properties
		number 2229
		flags 5
	)
)

