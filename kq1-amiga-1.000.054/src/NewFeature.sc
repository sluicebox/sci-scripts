;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(procedure (localproc_0 param1 param2)
	(param1 param2: &rest)
)

(class NewFeature of Obj
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
		getableDist 50
		seeableDist 100
		shiftClick 0
		contClick 0
		lookStr 0
	)

	(method (init)
		(gFeatures add: self)
		(if (not shiftClick)
			(= shiftClick 367)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(if (Said noun)
					(event claimed: 0)
					(cond
						(
							(or
								(>
									(Abs
										(-
											(GetAngle
												(gEgo x:)
												(gEgo y:)
												x
												y
											)
											(gEgo heading:)
										)
									)
									sightAngle
								)
								(>
									(GetDistance (gEgo x:) (gEgo y:) x y)
									seeableDist
								)
							)
							(self dontSee:)
							(event claimed: 1)
						)
						((Said 'look,look')
							(self doLook:)
						)
						(
							(>
								(GetDistance (gEgo x:) (gEgo y:) x y)
								getableDist
							)
							(self notClose:)
							(event claimed: 1)
						)
						((Said 'move,pull')
							(self doMove:)
						)
						((Said 'get,get')
							(if contClick
								(self doGet:)
							else
								(event claimed: 0)
							)
						)
					)
					(return)
				)
			)
			(evMOUSEBUTTON
				(cond
					((not (= temp0 (event modifiers:))))
					(
						(not
							(and
								(<= nsLeft (event x:) nsRight)
								(<= nsTop (event y:) nsBottom)
							)
						))
					((& temp0 emSHIFT)
						(localproc_0 self shiftClick)
						(event claimed: 1)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (dontSee)
		(Printf 899 0 description) ; "You don't see the %s"
	)

	(method (notClose)
		(Printf 899 1 description) ; "You're not close enough."
	)

	(method (doLook)
		(if lookStr
			(Print lookStr)
		else
			(Printf 899 2 description description) ; "The %s looks like any other %s."
		)
	)

	(method (doMove)
		(Printf 899 3 description) ; "The %s will not move."
	)

	(method (doGet)
		(Printf 899 4 description) ; "You cannot get the %s."
	)
)

