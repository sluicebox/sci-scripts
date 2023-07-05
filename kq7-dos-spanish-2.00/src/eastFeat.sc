;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use ExitButton)
(use PolyPath)
(use Feature)
(use System)

(public
	eastFeat 0
	westFeat 1
	northFeat 2
	southFeat 3
)

(class ExitFeature of Feature
	(properties
		code 0
		exitDir 0
	)

	(method (init)
		(= code 0)
		(super init: &rest)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(event type:)
					(!= (event type:) evMOUSERELEASE)
					(not global308)
					(self onMe: event)
				)
				(if code
					(if (== gCurRoomNum 1250)
						(if (code doit:)
							(event claimed: 1)
							(return)
						)
					else
						(code doit:)
						(event claimed: 1)
						(return)
					)
				)
				(CueObj
					state: -1
					cycles: 0
					client: 0
					theVerb: (event message:)
				)
				(if scratch
					(CueObj
						state: 2
						cycles: 0
						client: self
						theVerb: (event message:)
					)
				)
				(switch exitDir
					(1
						(gEgo
							setMotion:
								PolyPath
								(event x:)
								0
								(if scratch 0 else CueObj)
						)
					)
					(3
						(gEgo
							setMotion:
								PolyPath
								(event x:)
								150
								(if scratch 0 else CueObj)
						)
					)
					(2
						(if
							(OneOf
								gCurRoomNum
								1100
								111
								2600
								1250
								3150
								5300
								4550
							)
							(if (IsFlag 97)
								(gEgo
									setMotion:
										PolyPath
										(+ (gCurRoom eastSide:) 35)
										(event y:)
										(if scratch 0 else CueObj)
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(+ (event x:) 35)
										(event y:)
										(if scratch 0 else CueObj)
								)
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(gCurRoom eastSide:)
									(event y:)
									(if scratch 0 else CueObj)
							)
						)
					)
					(4
						(if
							(OneOf
								gCurRoomNum
								1100
								111
								2600
								1250
								3150
								5300
								4550
							)
							(if (IsFlag 97)
								(gEgo
									setMotion:
										PolyPath
										50
										(event y:)
										(if scratch 0 else CueObj)
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(- (event x:) 35)
										(event y:)
										(if scratch 0 else CueObj)
								)
							)
						else
							(gEgo
								setMotion:
									PolyPath
									-10
									(event y:)
									(if scratch 0 else CueObj)
							)
						)
					)
					(6
						(gEgo
							setMotion:
								PolyPath
								gMouseX
								gMouseY
								(if scratch 0 else CueObj)
						)
					)
					(5
						(gEgo
							setMotion:
								PolyPath
								gMouseX
								gMouseY
								(if scratch 0 else CueObj)
						)
					)
					(7
						(gEgo
							setMotion:
								PolyPath
								gMouseX
								gMouseY
								(if scratch 0 else CueObj)
						)
					)
					(8
						(gEgo
							setMotion:
								PolyPath
								gMouseX
								gMouseY
								(if scratch 0 else CueObj)
						)
					)
				)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (doVerb)
		(gUser need_update: 1)
		(return 1)
	)
)

(instance eastFeat of ExitFeature
	(properties
		nsBottom 140
		exitDir 2
	)

	(method (init)
		(= nsLeft 300)
		(= nsRight 320)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)
)

(instance westFeat of ExitFeature
	(properties
		nsBottom 140
		exitDir 4
	)

	(method (init)
		(= nsLeft 0)
		(= nsRight 20)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)
)

(instance northFeat of ExitFeature
	(properties
		nsLeft 21
		nsRight 289
		nsBottom 20
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)
)

(instance southFeat of ExitFeature
	(properties
		nsLeft 21
		nsTop 130
		nsRight 289
		nsBottom 135
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)
)

