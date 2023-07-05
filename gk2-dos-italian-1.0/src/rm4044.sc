;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4044)
(include sci.sh)
(use northExit)
(use Cursor)
(use Motion)
(use Actor)

(public
	rm4044 0
)

(instance rm4044 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4044
		south 4002 ; rm4002
	)

	(method (init)
		(super init: &rest)
		(pFountain init: setCycle: Fwd)
		(GKHotCursor delete: pFountain)
	)
)

(instance pFountain of Prop
	(properties
		y 325
		view 20404
	)

	(method (onMe)
		(return 0)
	)
)

