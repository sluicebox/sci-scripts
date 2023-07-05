;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1206)
(include sci.sh)
(use Main)
(use SpinProp)
(use n1111)
(use Sound)

(public
	cuCigCase 0
)

(instance cuCigCase of SpinProp
	(properties)

	(method (init)
		(= view (if (IsFlag 16) 20057 else 20056))
		(super init: &rest)
		(self setPri: 200 setHotspot: 2 11)
		(Load rsAUDIO (click number:))
		(Load rsVIEW 20057)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
				(gTheCursor hilite:)
			)
			(2
				(if (== view 20056)
					(= view 20057)
					(myInvObj cel: 2)
					(SetFlag 16)
				else
					(= view 20056)
					(myInvObj cel: 0)
					(ClearFlag 16)
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
		number 20008
		flags 5
	)
)

