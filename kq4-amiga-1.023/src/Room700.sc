;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Game)
(use User)
(use System)

(public
	Room700 0
)

(instance Room700 of Rm
	(properties)

	(method (init)
		(gCurRoom drawPic: 700 6)
		(self setScript: wait)
		(User canInput: 0)
		(= gUserFont gSmallFont)
		(super init:)
	)

	(method (dispose)
		(User canInput: 1)
		(super dispose:)
	)
)

(instance wait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Display 700 0 dsCOORD 70 170 dsCOLOR 0 dsBACKGROUND 7) ; "\04 1990 Sierra On-Line, Inc."
				(= seconds 3)
			)
			(1
				(gCurRoom newRoom: 699)
			)
		)
	)
)

