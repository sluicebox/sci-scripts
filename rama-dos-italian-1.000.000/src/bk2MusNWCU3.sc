;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4130)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Actor)

(public
	bk2MusNWCU3 0
)

(instance bk2MusNWCU3 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4160)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit26Butn init: global117)
		(if (== (proc70_9 80) 4130)
			(cuttingTool init:)
			(TOOL_315 init:)
		else
			(nothingThere init: global117)
		)
	)
)

(instance cuttingTool of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 160 247 167 246 187 281 200 300 200 324 213 359 204 361 201 326 176 313 179 258 162
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(nothingThere init: global117)
				(proc70_1 80)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exhibit26Butn of ExhibitButton
	(properties
		x 259
		y 202
		view 4154
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 235 282 202 300 202 318 236 310 247 272 245 269 236
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nothingThere of View
	(properties
		x 230
		y 149
		loop 1
		view 4154
	)
)

(instance TOOL_315 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 182 256 155 367 197 353 220 240 184
					yourself:
				)
		)
	)
)

