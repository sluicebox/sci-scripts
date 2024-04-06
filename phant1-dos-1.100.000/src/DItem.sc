;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64916)
(include sci.sh)
(use Actor)
(use System)

(class DItem of View
	(properties
		signal 0
		type 0
		key 0
		value 0
		object 0
		selector 0
	)

	(method (updatePlane))

	(method (enable bool)
		(if bool
			(|= state $0001)
		else
			(&= state $fffe)
		)
	)

	(method (hilite bool)
		(if bool
			(|= state $0008)
			(= cel 1)
			(UpdateScreenItem self)
		else
			(&= state $fff7)
			(= cel 0)
			(UpdateScreenItem self)
		)
	)

	(method (handleEvent event &tmp ret evtType evt)
		(if (event claimed:)
			(return 0)
		)
		(= ret 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= evtType (event type:)) evKEYBOARD)
						(== (event message:) key)
					)
					(and (== evtType evMOUSEBUTTON) (self onMe: event))
				)
			)
			(event claimed: 1)
			(= ret (self track: event))
		)
		(return ret)
	)

	(method (onMe event)
		(return
			(and
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
		)
	)

	(method (track))

	(method (isType theType)
		(return (== type theType))
	)

	(method (checkState bit)
		(return (& state bit))
	)

	(method (doit)
		(if object
			(Eval object selector)
		)
		(return value)
	)

	(method (setSize))

	(method (move h v)
		(+= x h)
		(+= y v)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsRight h)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (cycle)
		(if (& -info- $0008)
			(UpdateScreenItem self)
		)
	)

	(method (show)
		(if (and bitmap (not (self isNotHidden:)))
			(AddScreenItem bitmap)
		)
	)

	(method (hide)
		(if (and bitmap (self isNotHidden:))
			(DeleteScreenItem bitmap)
		)
	)
)

