;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	winner 0
)

(local
	local0
	local1
	local2
	local3
)

(instance winner of Obj
	(properties)

	(method (init)
		(= local3 0)
		(self doit:)
	)

	(method (doit)
		(cond
			((not local3)
				(++ local3)
				(= local0 (Act new:))
				(= local1 (Act new:))
				(= local2 (Act new:))
				(local0 view: 198 posn: 120 90 setPri: 9 init:)
				(proc0_2)
				(gTheSound number: 4 play:)
				(Wait 10)
				(Wait 90)
				(local0 cel: 1)
				(local1 view: 198 setLoop: 1 posn: 180 133 setPri: 9 init:)
				(proc0_2)
				(Wait 90)
				(local1 setLoop: 2 setCycle: Fwd)
				(local2
					view: 198
					setLoop: 3
					posn: 160 70
					setCycle: Fwd
					setPri: 9
					init:
				)
			)
			((== (++ local3) 45)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(local0 dispose:)
		(local1 dispose:)
		(local2 dispose:)
		(gCurRoom script: 0)
	)
)

