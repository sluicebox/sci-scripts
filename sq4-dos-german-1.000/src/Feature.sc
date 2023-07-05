;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use System)

(class CueObj of Script
	(properties
		theVerb 0
		theInvItem 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(client x:)
							(client y:)
						)
						self
				)
				(gTheDoits add: self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gTheDoits delete: self)
				(if
					(not
						(and
							client
							(IsObject (client actions:))
							((client actions:) doVerb: theVerb theInvItem)
						)
					)
					(client doVerb: theVerb theInvItem)
				)
				(= state 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 26505
		actions 0
		onMeCheck 26505
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
	)

	(method (init theInitializer)
		(cond
			((and argc theInitializer)
				(self perform: theInitializer)
			)
			(gFtrInitializer
				(self perform: gFtrInitializer)
			)
		)
		(if (self respondsTo: #underBits)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)

	(method (approachVerbs args &tmp i)
		(for ((= i (= _approachVerbs 0))) (< i argc) ((++ i))
			(if args
				(self
					_approachVerbs:
						(|
							(self _approachVerbs:)
							(<< $0001 (- [args i] 1))
						)
				)
			)
		)
	)

	(method (handleEvent event &tmp useMsg)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
					theInvItem:
						(and
							gTheIconBar
							(== (event message:) JOY_DOWNRIGHT)
							gInventory
							(gInventory indexOf: (gTheIconBar curInvIcon:))
						)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(!= _approachVerbs 26505)
						(& _approachVerbs (<< $0001 (- (event message:) 1)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				else
					(if (gUser canControl:)
						(gEgo setMotion: 0)
					)
					(CueObj changeState: 3)
				)
			)
		)
		(event claimed:)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb)
		((if gDoVerbCode gDoVerbCode else dftDoVerb) doit: theVerb self &rest)
	)

	(method (facingMe act &tmp theActor theAngle)
		(= theActor (if argc act else gEgo))
		(if
			(>
				(= theAngle
					(Abs
						(-
							(GetAngle (theActor x:) (theActor y:) x y)
							(theActor heading:)
						)
					)
				)
				180
			)
			(= theAngle (- 360 theAngle))
		)
		(if (<= theAngle sightAngle)
			(return 1)
		else
			(self notFacing:)
			(return 0)
		)
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (IsObject theObjOrX)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(cond
				((IsObject onMeCheck)
					(AvoidPath oX oY onMeCheck)
				)
				(
					(or
						(not (or nsLeft nsRight nsTop nsBottom))
						(and
							(<= nsLeft oX nsRight)
							(<= nsTop oY nsBottom)
						)
					)
					(if (!= onMeCheck 26505)
						(& onMeCheck (OnControl CONTROL oX oY))
					else
						1
					)
				)
			)
		)
	)

	(method (dispose)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if (IsObject onMeCheck)
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(super dispose:)
	)
)

(instance dftDoVerb of Code
	(properties)

	(method (doit theVerb theObj invNo &tmp objDesc iItem)
		(= objDesc (theObj description:))
		(switch theVerb
			(2
				(if (theObj lookStr:)
					(Print (theObj lookStr:))
				else
					(Printf 950 0 objDesc objDesc objDesc objDesc) ; "The %s looks like any other %s."
				)
			)
			(4
				(if (= iItem (gInventory at: invNo))
					(Printf ; "You clicked inv item %s on %s."
						950
						1
						(iItem description:)
						objDesc
						(iItem description:)
						objDesc
					)
				)
			)
			(5
				(Printf 950 2 objDesc objDesc) ; "The %s has nothing to say."
			)
		)
	)
)

