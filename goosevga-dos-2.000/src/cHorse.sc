;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 606)
(include sci.sh)
(use Main)
(use Actor)

(public
	cHorse 0
)

(instance cHorse of SActor
	(properties
		view 60
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(self posn: (gPlace x:) (gPlace y:))
		(super init:)
		(if (> argc 0)
			(self stopUpd:)
		else
			(self hide:)
		)
	)

	(method (put &tmp temp0)
		(= [global200 gCurRoomNum] view)
		((gGoals at: 17) egoHas: 0)
		(self show: ignoreActors: 0)
		(-= global114 300)
		(gEgo view: global114)
		(= temp0 signal)
		(self signal: 2 posn: (gPlace x:) (gPlace y:) signal: temp0)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: 17) egoHas: 1 egoSeen: 1)
		(self hide:)
		(+= global114 300)
		(gEgo view: global114)
		(Load rsVIEW global114)
	)

	(method (delete)
		(if (== global130 view)
			(= global129 0)
		else
			(= global150 0)
		)
		(super delete:)
		(DisposeScript 606)
	)
)

