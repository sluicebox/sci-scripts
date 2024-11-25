;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Interface)
(use Actor)
(use System)

(class Button of View
	(properties
		state 1
	)

	(method (hilite param1)
		(cond
			((& state $0002)
				(= cel 0)
				(&= state $fff7)
				(return 1)
			)
			((and argc (not param1))
				(= cel 0)
				(&= state $fff7)
			)
			(else
				(= cel 1)
				(|= state $0008)
			)
		)
		(UpdateScreenItem self)
		(return (FrameOut))
	)

	(method (track param1 &tmp temp0 temp1)
		(if (& $0001 (param1 type:))
			(= temp1 0)
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize: plane)
				(if (!= (= temp0 (self onMe: param1)) temp1)
					(if temp0
						(= cel 2)
					else
						(= cel 0)
					)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(self hilite: (& state $0008))
				(return (if temp0 self else 0))
			)
		else
			(return self)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& state $0001)
					(& (= temp0 (event type:)) evMOUSEBUTTON)
					(self onMe: event)
				)
				(event claimed: 1)
				(self hilite:)
				(if (self track: event)
					(self doVerb: hilite: 0)
					(return 1)
				else
					(return 0)
				)
			)
		)
	)
)

