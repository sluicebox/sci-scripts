;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use n007)
(use Motion)
(use Game)
(use Actor)
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
		style -32768
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(HandsOff)
		(super init:)
		(SL enable:)
		(gEgo view: 350 loop: 0 cel: 0 posn: 86 42 init:)
		(candle init: setCycle: Fwd)
		(lightoffshirt init: setCycle: Fwd)
		(lightoffcape init: setCycle: Fwd)
		(lightoffdonob init: setCycle: Fwd)
		(lightoffcurtain init: setCycle: Fwd)
		(lightoffbody init: setCycle: Fwd)
		(self setScript: rm302Script)
	)
)

(instance candle of Actor
	(properties
		x 141
		y 107
		view 350
		loop 1
	)
)

(instance lightoffshirt of Actor
	(properties
		x 161
		y 93
		view 350
		loop 2
		cel 1
	)
)

(instance lightoffcape of Actor
	(properties
		x 169
		y 92
		view 350
		loop 3
		cel 2
	)
)

(instance lightoffdonob of Actor
	(properties
		x 215
		y 113
		view 350
		loop 4
		cel 3
	)
)

(instance lightoffcurtain of Actor
	(properties
		x 98
		y 79
		view 350
		loop 5
	)
)

(instance lightoffbody of Actor
	(properties
		x 111
		y 105
		view 350
		loop 6
		cel 1
	)
)

(instance rm302Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(EgoSleeps 5 0)
				(gMessager say: 1) ; "The sleep heals and refreshes you."
				(localproc_0)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 301)
			)
		)
	)
)

