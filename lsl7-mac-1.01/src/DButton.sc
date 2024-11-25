;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64911)
(include sci.sh)
(use Interface)
(use DText)
(use System)

(class DButton of DText
	(properties
		state 3
		mode 1
		fore 255
		back 0
		font 0
		borderColor 0
	)

	(method (init)
		(if (!= view -1)
			(= borderColor -1)
			(= back skip)
		)
		(super init: &rest)
	)

	(method (hilite bool)
		(if (and argc bool)
			(|= state $0008)
			(cond
				((!= view -1)
					(= cel 1)
				)
				((!= borderColor -1)
					(= borderColor fore)
				)
			)
		else
			(&= state $fff7)
			(cond
				((!= view -1)
					(= cel 0)
				)
				((!= borderColor -1)
					(= borderColor 0)
				)
			)
		)
		(self draw:)
		(UpdateScreenItem self)
	)

	(method (setSize &tmp [temp0 6])
		(super setSize: &rest)
	)

	(method (draw)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)

	(method (track event &tmp in lastIn)
		(if (== 1 (event type:))
			(= lastIn 0)
			(repeat
				(= event (Event new: evPEEK))
				(event localize: plane)
				(if (!= (= in (self onMe: event)) lastIn)
					(if in
						(= cel 2)
						(++ textTop)
						(++ textBottom)
					else
						(= cel 0)
						(-- textTop)
						(-- textBottom)
					)
					(self draw:)
					(UpdateScreenItem self)
					(FrameOut)
					(= lastIn in)
				)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(if in
				(-- textTop)
				(-- textBottom)
			)
			(self hilite: (& state $0008))
			(return (if in self else 0))
		else
			(return self)
		)
	)
)

