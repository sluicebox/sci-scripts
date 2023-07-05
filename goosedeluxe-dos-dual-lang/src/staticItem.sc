;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use ActorBody)
(use Motion)

(public
	staticItem 0
)

(instance staticItem of SActor
	(properties
		signal 16641
		cycleSpeed 2
		illegalBits 0
	)

	(method (init)
		(self
			view: (if (> argc 0) [global200 gCurRoomNum] else global130)
			posn: (gPlace x:) (gPlace y:)
		)
		(if (== view 55)
			(self signal: 16385 setCycle: Fwd)
		)
		(super init:)
		(if (not argc)
			(self hide:)
		)
	)

	(method (put &tmp temp0)
		(= [global200 gCurRoomNum] view)
		((gGoals at: (- view 43)) egoHas: 0)
		(self show: ignoreActors: 1)
		(= temp0 signal)
		(self signal: 2 posn: (gPlace x:) (gPlace y:) signal: temp0)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(self hide:)
	)

	(method (delete)
		(if (== global130 view)
			(= global129 0)
		else
			(= global150 0)
		)
		(super delete:)
	)

	(method (onMe)
		(return 0)
	)
)

