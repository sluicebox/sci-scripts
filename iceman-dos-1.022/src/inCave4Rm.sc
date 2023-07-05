;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	inCave4Rm 0
)

(instance inCave4Rm of Rm
	(properties
		picture 64
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
		(switch south
			(65
				(if (< (gEgo x:) 10)
					(gEgo setMotion: MoveTo 300 (gEgo y:))
				else
					(gEgo setMotion: MoveTo 20 (gEgo y:))
				)
			)
		)
	)
)

