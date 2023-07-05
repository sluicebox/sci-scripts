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
				(PrintDC 105 0 #at 10 110 #dispose) ; "\81u\82\a0\82\a2\82\c2\82\cd\81A\96\82\96@\82\c5\97\b3\8a\aa\82\f0\8c\c4\82\d1\8bN\82\b1\82\b5\82\bd\82\f1\82\c5\82\b7\81B\82\bb\82\cc\97\b3\8a\aa\82\cd\82\a8\8f\e9\82\f0\88\f9\82\dd\8d\9e\82\f1\82\c5\82\be\82\f1\82\be\82\f1\91\ac\82\ad\82\c8\82\e8\81A\82\a0\82\a2\82\c2\82\cd\82\dc\82\bd\95\ca\82\cc\8e\f4\95\b6\82\c5\82\bb\82\cc\97\b3\8a\aa\82\c6\8b\a4\82\c9\82\a8\8f\e9\82\f0\8b\f3\82\c9\95\91\82\a2\8f\e3\82\b0\82\c4\8f\c1\82\b5\82\c4\82\b5\82\dc\82\c1\82\bd\82\cc\82\c5\82\b7\81B\82\e0\82\cc\82\b7\82\b2\82\a9\82\c1\82\bd\82\c5\82\b7\82\e6\81I\81v"
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

