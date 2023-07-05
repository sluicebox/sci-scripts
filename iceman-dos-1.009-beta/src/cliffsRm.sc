;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	cliffsRm 0
)

(instance cliffsRm of Rm
	(properties
		picture 73
		west 74
	)

	(method (init)
		(super init:)
		(self setRegions: 310 311) ; tunisia, guardfReg
		(gEgo init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 73 0) ; "You see cliffs for right now!"
			)
		)
	)
)

