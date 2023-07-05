;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6091)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	peaScript 0
)

(instance pCock of Prop
	(properties)
)

(instance peaScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(pCock
					view: 981
					loop: 0
					cel: 0
					x: 0
					y: 0
					setPri: 14
					cycleSpeed: 15
					init:
				)
				(= seconds 2)
			)
			(1
				(pCock loop: 0 cel: 0)
				(pCock setCycle: End self)
			)
			(2
				(pCock loop: 1 cel: 0)
				(pCock setCycle: End self)
			)
			(3
				(pCock loop: 2 cel: 0)
				(pCock setCycle: End self)
			)
			(4
				(pCock loop: 3 cel: 0)
				(pCock setCycle: End self)
			)
			(5
				(pCock loop: 4 cel: 0)
				(pCock setCycle: End self)
			)
			(6
				(pCock loop: 5 cel: 0)
				(pCock setCycle: End self)
			)
			(7
				(EnableCursor)
				(while (!= evMOUSEBUTTON ((= temp0 (Event new:)) type:))
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(= cycles 1)
			)
			(8
				(pCock hide: dispose:)
				(peaScript dispose:)
			)
		)
	)
)

