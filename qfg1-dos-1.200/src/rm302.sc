;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use n007)
(use Game)
(use System)

(public
	rm302 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(repeat
		(= temp0 (Event new: evMOUSEKEYBOARD))
		(breakif (temp0 type:))
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(instance rm302 of Rm
	(properties
		picture 400
		style 9
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(HandsOff)
		(super init:)
		(SL enable:)
		(gEgo view: 301 loop: 5 cel: 6 posn: 160 75 init:)
		(self setScript: rm302Script)
	)
)

(instance rm302Script of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(EgoSleeps 6 0)
				(= temp0
					{Asleep at the Hero's Tale Inn.\nThe sleep heals and refreshes you.}
				)
				(= temp1 (if (< global211 16) 15 else 13))
				(Display temp0 dsFONT 300 dsWIDTH 200 dsCOORD 80 133 dsCOLOR temp1)
				(localproc_0)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 301)
			)
		)
	)
)

