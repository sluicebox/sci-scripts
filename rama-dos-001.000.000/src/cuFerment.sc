;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1203)
(include sci.sh)
(use Main)
(use SpinProp)
(use n1111)
(use Sound)

(public
	cuFerment 0
)

(instance cuFerment of SpinProp
	(properties)

	(method (init)
		(= view (if (IsFlag 15) 20213 else 20212))
		(super init: &rest)
		(self setPri: 200 setHotspot: 2 11)
		(Load rsAUDIO (click number:))
		(Load rsVIEW 20213)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
				(gTheCursor hilite:)
			)
			(2
				(if (== view 20212)
					(= view 20213)
					(myInvObj cel: 2)
					(SetFlag 15)
				else
					(= view 20212)
					(myInvObj cel: 0)
					(ClearFlag 15)
				)
				(click play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance click of Sound
	(properties
		number 20009
		flags 5
	)
)

