;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use System)

(class CueObj of Script
	(properties
		theVerb 0
		theInvItem 0
	)

	(method (changeState))
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

	(method (init)
		(if (self respondsTo: #underBits)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)

	(method (approachVerbs &tmp temp0))

	(method (handleEvent event &tmp useMsg)
		(event claimed:)
	)

	(method (notFacing &tmp event))

	(method (doVerb))

	(method (facingMe &tmp [temp0 2]))

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

