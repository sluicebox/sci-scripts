;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use System)

(class Feature of Obj
	(properties
		x 0
		y 0
		z 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if (self respondsTo: #underBits)
			(gCast add: self)
		)
	)

	(method (initialize theInitializer)
		(cond
			((and argc theInitializer)
				(self perform: theInitializer)
			)
			(gFtrInitializer
				(self perform: gFtrInitializer)
			)
		)
	)

	(method (approachVerbs &tmp [temp0 2]))

	(method (handleEvent event &tmp useMsg)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(event claimed: 1)
				(gEgo setMotion: 0)
			)
		)
		(event claimed:)
	)

	(method (notFacing &tmp event))

	(method (doVerb &tmp [temp0 2]))

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
			(or
				(not (or nsLeft nsRight nsTop nsBottom))
				(and (<= nsLeft oX nsRight) (<= nsTop oY nsBottom))
			)
		)
	)
)

