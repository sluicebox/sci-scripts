;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use System)

(public
	inCave3Rm 0
)

(instance inCave3Rm of Rm
	(properties
		picture 63
	)

	(method (init)
		(super init:)
		(self setRegions: 304) ; cavesRg
		(gEgo init:)
		(if (== south 67)
			(gEgo setScript: containEgo)
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
			((< (gEgo y:) 10)
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5))
			)
			((< 185 (gEgo y:))
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5))
			)
		)
	)
)

