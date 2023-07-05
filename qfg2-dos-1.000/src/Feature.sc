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
		sightAngle 26505
		closeRangeDist 26505
		longRangeDist 26505
		shiftClick 26505
		contClick 26505
		actions 26505
		control 26505
		verbChecks1 26505
		verbChecks2 26505
		verbChecks3 26505
		lookStr 0
	)

	(procedure (PrintVerbMsg theVerb)
		(switch theVerb
			(1
				(if lookStr
					(Print lookStr)
				else
					(Printf 950 0 description description) ; "The %s looks like any other %s."
				)
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

	(method (setChecks theVerb theChecks &tmp theVal theShift)
		(= theVal (<< theChecks (= theShift (* 4 (mod (- theVerb 1) 4)))))
		(cond
			((<= theVerb 4)
				(&= verbChecks1 (~ (<< $000f theShift)))
				(|= verbChecks1 theVal)
			)
			((<= theVerb 8)
				(&= verbChecks2 (~ (<< $000f theShift)))
				(|= verbChecks2 theVal)
			)
			(else
				(&= verbChecks3 (~ (<< $000f theShift)))
				(|= verbChecks3 theVal)
			)
		)
	)

	(method (passedChecks theVerb &tmp theChecks)
		(return
			(and
				(or
					(not
						(&
							(= theChecks
								(&
									(>>
										(if (<= theVerb 4)
											verbChecks1
										else
											verbChecks2
										)
										(* 4 (mod (- theVerb 1) 4))
									)
									$000f
								)
							)
							$0008
						)
					)
					(self isNotHidden:)
				)
				(or (not (& theChecks $0004)) (self farCheck:))
				(or (not (& theChecks $0002)) (self nearCheck:))
				(or (not (& theChecks $0001)) (self facingMe:))
			)
		)
	)

	(method (init theInitializer)
		(cond
			((and argc theInitializer)
				(self perform: theInitializer)
			)
			(gFtrInitCode
				(self perform: gFtrInitCode)
			)
			(else
				(self perform: dftFtrInit)
			)
		)
		(if (self respondsTo: #underBits)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)

	(method (handleEvent event &tmp theMods theVerb)
		(cond
			((event claimed:)
				(return 1)
			)
			((not description)
				(return 0)
			)
			((not (self isNotHidden:))
				(return 1)
			)
		)
		(switch (event type:)
			(evSAID
				(cond
					((not (Said noun)))
					((not (= theVerb (event message:)))
						(event claimed: 0)
					)
					((self passedChecks: theVerb)
						(self doVerb: theVerb)
					)
					((IsObject actions)
						(actions handleEvent: event self)
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((not (& (= theMods (event modifiers:)) $0007))) ; emCTRL | emSHIFT
					((not (self onMe: event)))
					((& theMods emSHIFT)
						(if
							(or
								(& shiftClick $8000)
								(self passedChecks: shiftClick)
							)
							(self doVerb: (& $7fff shiftClick))
						)
						(event claimed: 1)
					)
					((& theMods emCTRL)
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
		(if gHQVerbCode
			(self perform: gHQVerbCode theVerb)
		else
			(PrintVerbMsg theVerb description)
		)
	)

	(method (nearCheck obj &tmp theObj)
		(= theObj (if argc obj else gEgo))
		(if (<= (GetDistance (theObj x:) (theObj y:) x y) closeRangeDist)
			(return 1)
		else
			(self notInNear:)
			(return 0)
		)
	)

	(method (farCheck obj &tmp theObj)
		(= theObj (if argc obj else gEgo))
		(if (<= (GetDistance (theObj x:) (theObj y:) x y) longRangeDist)
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

(instance dftFtrInit of Code
	(properties)

	(method (doit theObj)
		(if (== (theObj sightAngle:) 26505)
			(theObj sightAngle: 90)
		)
		(if (== (theObj closeRangeDist:) 26505)
			(theObj closeRangeDist: 50)
		)
		(if (== (theObj longRangeDist:) 26505)
			(theObj longRangeDist: 100)
		)
		(if (== (theObj shiftClick:) 26505)
			(theObj shiftClick: -32767)
		)
		(if (== (theObj contClick:) 26505)
			(theObj contClick: 7)
		)
		(if (== (theObj actions:) 26505)
			(theObj actions: 0)
		)
		(if (== (theObj control:) 26505)
			(theObj control: 0)
		)
		(if (== (theObj verbChecks1:) 26505)
			(theObj verbChecks1: -17483)
		)
		(if (== (theObj verbChecks2:) 26505)
			(theObj verbChecks2: -17477)
		)
		(if (== (theObj verbChecks3:) 26505)
			(theObj verbChecks3: -17477)
		)
	)
)

