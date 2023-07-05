;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use Interface)
(use System)

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
		sightAngle 90
		closeRangeDist 50
		longRangeDist 100
		shiftClick -32767
		contClick 7
		actions 0
		control 0
		verbChecks1 -17483
		verbChecks2 -17477
		verbChecks3 -17477
	)

	(procedure (localproc_0 param1)
		(switch param1
			(1
				(Printf 950 0 description description) ; "The %s looks like any other %s."
			)
			(2
				(Printf 950 1 description) ; "You cannot open the %s."
			)
			(3
				(Printf 950 2 description) ; "You cannot close the %s."
			)
			(4
				(Printf 950 3 description) ; "The %s has no smell."
			)
			(5
				(Printf 950 4 description) ; "You cannot move the %s."
			)
			(6
				(Printf 950 5 description) ; "You wouldn't want to eat the %s."
			)
			(7
				(Printf 950 6 description) ; "You cannot get the %s."
			)
			(8
				(Printf 950 7 description) ; "You can't climb the %s."
			)
			(9
				(Printf 950 8 description) ; "The %s has nothing to say."
			)
		)
	)

	(method (setChecks param1 param2 &tmp temp0 temp1)
		(= temp0 (<< param2 (= temp1 (* 4 (mod (- param1 1) 4)))))
		(cond
			((<= param1 4)
				(&= verbChecks1 (~ (<< $000f temp1)))
				(|= verbChecks1 temp0)
			)
			((<= param1 8)
				(&= verbChecks2 (~ (<< $000f temp1)))
				(|= verbChecks2 temp0)
			)
			(else
				(&= verbChecks3 (~ (<< $000f temp1)))
				(|= verbChecks3 temp0)
			)
		)
	)

	(method (passedChecks param1 &tmp temp0)
		(return
			(and
				(or
					(not
						(&
							(= temp0
								(&
									(>>
										(if (<= param1 4)
											verbChecks1
										else
											verbChecks2
										)
										(* 4 (mod (- param1 1) 4))
									)
									$000f
								)
							)
							$0008
						)
					)
					(self isNotHidden:)
				)
				(or (not (& temp0 $0004)) (self farCheck:))
				(or (not (& temp0 $0002)) (self nearCheck:))
				(or (not (& temp0 $0001)) (self facingMe:))
			)
		)
	)

	(method (init)
		(gFeatures add: self)
		(if (not description)
			(= description name)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(cond
					((not (Said noun)))
					((not (= temp1 (event message:)))
						(event claimed: 0)
					)
					((self passedChecks: temp1)
						(self doVerb: temp1)
					)
					((IsObject actions)
						(actions handleEvent: event self)
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((not (= temp0 (event modifiers:))))
					((not (self onMe: event)))
					((& temp0 emSHIFT)
						(if
							(or
								(& shiftClick $8000)
								(self passedChecks: shiftClick)
							)
							(self doVerb: (& $7fff shiftClick))
						)
						(event claimed: 1)
					)
					((& temp0 emCTRL)
						(if
							(or
								(& contClick $8000)
								(self passedChecks: contClick)
							)
							(self doVerb: (& $7fff contClick))
						)
						(event claimed: 1)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (notInFar)
		(Printf 950 9 description) ; "You don't see the %s"
	)

	(method (notInNear)
		(Printf 950 10 description) ; "You're not close enough."
	)

	(method (notFacing &tmp event)
		(Printf 950 11 description) ; "You're not facing the %s."
	)

	(method (doVerb theVerb)
		(localproc_0 theVerb description)
	)

	(method (nearCheck param1 &tmp temp0)
		(= temp0 (if argc param1 else gEgo))
		(if (<= (GetDistance (temp0 x:) (temp0 y:) x y) closeRangeDist)
			(return 1)
		else
			(self notInNear:)
			(return 0)
		)
	)

	(method (farCheck param1 &tmp temp0)
		(= temp0 (if argc param1 else gEgo))
		(if (<= (GetDistance (temp0 x:) (temp0 y:) x y) longRangeDist)
			(return 1)
		else
			(self notInFar:)
			(return 0)
		)
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
			(and
				(<= nsLeft oX nsRight)
				(<= nsTop oY nsBottom)
				(if control
					(& control (OnControl CONTROL oX oY))
				else
					1
				)
			)
		)
	)

	(method (dispose)
		(gFeatures delete: self)
		(super dispose:)
	)
)

