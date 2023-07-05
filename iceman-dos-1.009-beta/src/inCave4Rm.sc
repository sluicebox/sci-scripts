;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use System)

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
				(gEgo setScript: containEgo)
			)
		)
	)
)

(instance containEgo of Script
	(properties)

	(method (doit)
		(cond
			((< (gEgo x:) 10)
				(gEgo setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:))
			)
			((< 310 (gEgo x:))
				(gEgo setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:))
			)
		)
	)
)

