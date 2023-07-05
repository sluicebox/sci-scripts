;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro6 0
)

(instance intro6 of Rm
	(properties
		picture 72
		style 10
	)

	(method (init)
		(HandsOff)
		(gGame setCursor: 5 1)
		(intro_eyes init:)
		(intro_mouth init:)
		(self setScript: sceneSixScript setRegions: 763) ; cartoonRegion
		(super init:)
	)
)

(instance sceneSixScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(= global380 1)
				(intro_mouth setCycle: Fwd)
				(PrintDC 105 0 #at 10 110 #dispose) ; "Il pronon\87a des incantations et un vent terrible se mit \85 souffler de plus en plus rapidement. Le ch\83teau fut pris dans un tourbillon et je le vis dispara\8ctre dans le lointain."
				(= seconds (LangSwitch 10 15))
			)
			(2
				(gCurRoom newRoom: 103) ; intro4
			)
		)
	)
)

(instance intro_eyes of Prop
	(properties
		x 154
		y 54
		view 98
		priority 10
		signal 2064
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(intro_eyes setCycle: End)
			)
		)
		(super doit:)
	)
)

(instance intro_mouth of Prop
	(properties
		x 156
		y 71
		view 98
		loop 1
		priority 10
		signal 2064
		cycleSpeed 1
	)
)

