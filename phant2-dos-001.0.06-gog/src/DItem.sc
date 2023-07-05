;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64916)
(include sci.sh)
(use Main)
(use PolyEdit)
(use System)

(class DItem of View
	(properties
		state 3841
		value -1
		client 0
		signal 4105
		selectTime 0
	)

	(method (dispose)
		(if (not (not (& state $0004)))
			(self doHelp: 0)
		)
		(super dispose: &rest)
	)

	(method (action)
		(if client
			(Cue new: client value self)
		)
		(if (and (not (not (& state $0008))) (plane respondsTo: #done))
			(plane done: self)
		)
		(return value)
	)

	(method (doHelp param1)
		(if (or (not argc) param1)
			(|= state $0004)
		else
			(&= state $fffb)
		)
	)

	(method (doit)
		(if
			(and
				(not (not (& state $0002)))
				(not (not (not (& state $0004))))
				(> (- gGameTime selectTime) gCuees)
			)
			(self doHelp: 1)
		)
		(super doit: &rest)
	)

	(method (doSound))

	(method (enable bool)
		(if (and argc (^ bool (not (not (& state $0001)))))
			(if bool
				(|= state $0001)
			else
				(&= state $fffe)
			)
			(self update:)
		)
		(return (not (not (& state $0001))))
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
						(if (not (not (& state $0002)))
							(self action:)
						)
					)
					(FrameOut)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (hilite bool)
		(if (and argc (^ bool (not (not (& state $0002)))))
			(if bool
				(|= state $0002)
				(= selectTime gGameTime)
			else
				(&= state $fffd)
				(self doHelp: 0)
			)
			(self update:)
		)
		(return (not (not (& state $0002))))
	)

	(method (isExit param1)
		(if argc
			(if param1
				(|= state $0008)
			else
				(&= state $fff7)
			)
		)
		(return (not (not (& state $0008))))
	)

	(method (press param1)
		(if (and argc (^ param1 (not (not (& state $0020)))))
			(if param1
				(|= state $0020)
			else
				(&= state $ffdf)
			)
			(self doSound:)
			(self update:)
		)
		(return (not (not (& state $0020))))
	)

	(method (track param1 &tmp temp0)
		(if
			(and
				(gUser mouseMoved:)
				(^ (= temp0 (self onMe: param1)) (not (not (& state $0002))))
			)
			(self hilite: temp0)
		)
	)
)

