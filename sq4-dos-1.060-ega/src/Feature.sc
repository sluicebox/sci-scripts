;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(class Class_950_0
	(properties
		client 0
		theVerb 0
		userCI 0
		userCC 0
	)

	(method (cue)
		(client doVerb: theVerb)
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
		actions 26505
		onMeCheck 26505
		lookStr 0
	)

	(method (init theInitializer)
		(cond
			((and argc theInitializer)
				(self perform: theInitializer)
			)
			(gFastCast
				(self perform: gFastCast)
			)
		)
		(if (self respondsTo: #underBits)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)

	(method (handleEvent event &tmp useMsg)
		(cond
			((event claimed:)
				(return 1)
			)
			((not description)
				(return 0)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(if (and gNarrator (== (event message:) JOY_RIGHT) gInventory)
					(if (gNarrator curInvIcon:)
						(self
							doVerb:
								(event message:)
								(gInventory indexOf: (gNarrator curInvIcon:))
						)
					)
				else
					(self doVerb: (event message:))
				)
				(event claimed: 1)
			)
		)
		(event claimed:)
	)

	(method (notFacing &tmp event)
		(Class_950_0 client: self theVerb: 1)
		(gEgo
			setMotion: 0
			setHeading: (GetAngle (gEgo x:) (gEgo y:) x y) Class_950_0
		)
	)

	(method (doVerb theVerb)
		((if gInputFont gInputFont else dftDoVerb) doit: theVerb self &rest)
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
				((and (<= nsLeft oX nsRight) (<= nsTop oY nsBottom))
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
		(gFeatures delete: self)
		(super dispose:)
	)
)

(instance dftDoVerb of Code
	(properties)

	(method (doit theVerb theObj invNo &tmp temp0)
		(= temp0 (theObj description:))
		(switch theVerb
			(1
				(if (theObj lookStr:)
					(Print (theObj lookStr:))
				else
					(Printf 950 0 temp0 temp0) ; "The %s looks like any other %s."
				)
			)
			(3
				(Printf 950 1 ((gInventory at: invNo) description:) temp0) ; "You clicked inv item %s on %s."
			)
			(4
				(Printf 950 2 temp0) ; "The %s has nothing to say."
			)
		)
	)
)

