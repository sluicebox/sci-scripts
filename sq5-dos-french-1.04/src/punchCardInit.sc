;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2000)
(include sci.sh)
(use Main)
(use Inset)
(use Actor)
(use System)

(public
	punchCardInit 0
)

(local
	local0
	local1
	local2 = 10
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if (> 0 (= temp0 (- gMouseX (+ 5 (punchCard x:)))))
		(return -1)
	)
	(if (> (/ temp0 20) 2)
		(return -1)
	)
	(= temp1 (/ temp0 20))
	(if (> 0 (= temp0 (- gMouseY (+ 5 (punchCard y:)))))
		(return -1)
	)
	(if (> (/ temp0 15) 2)
		(return -1)
	)
	(return (+ (* (/= temp0 15) 3) temp1))
)

(procedure (localproc_1 param1)
	(= local1 (mod param1 3))
	(return (+ 5 (punchCard x:) (* (mod param1 3) 20)))
)

(procedure (localproc_2 param1)
	(= local0 (/ param1 3))
	(return (+ 5 (punchCard y:) (* (/ param1 3) 15)))
)

(procedure (localproc_3) ; UNUSED
	(hl
		x: (+ 5 (punchCard x:) (* local1 20))
		y: (+ 5 (punchCard y:) (* local0 15))
	)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if (& global129 (<< $0001 temp0))
			(DrawCel 616 1 1 (localproc_1 temp0) (localproc_2 temp0) 15)
		)
	)
	(Graph
		grUPDATE_BOX
		(+ 5 (punchCard y:))
		(+ 5 (punchCard x:))
		(+ 5 (punchCard y:) 45)
		(+ 5 (punchCard x:) 60)
		1
	)
)

(procedure (localproc_5 param1)
	(|= global129 (<< $0001 param1))
	(localproc_4)
)

(procedure (localproc_6 param1) ; UNUSED
	(cond
		((and (== local1 2) (== param1 1))
			(= local1 0)
		)
		((and (== local1 0) (== param1 -1))
			(= local1 2)
		)
		(else
			(+= local1 param1)
		)
	)
)

(procedure (localproc_7 param1) ; UNUSED
	(cond
		((and (== local0 2) (== param1 1))
			(= local0 0)
		)
		((and (== local0 0) (== param1 -1))
			(= local0 2)
		)
		(else
			(+= local0 param1)
		)
	)
)

(instance punchCardInit of Code
	(properties)

	(method (doit)
		(if (not (gCurRoom inset:))
			(gCurRoom setInset: punchCard hl)
		)
	)
)

(instance punchCard of Inset
	(properties
		view 616
		x 110
		y 55
		priority 13
	)

	(method (init)
		(gUser canControl: 0 canInput: 0)
		(super init: &rest)
		(SetScore 238 5)
		(hl init:)
		(theExit init:)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_4)
			(if oldCast
				(oldCast eachElementDo: #forceUpd)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(33 ; Hole_Punch
				(if (!= (= temp0 (localproc_0)) -1)
					(localproc_5 temp0)
				)
			)
		)
	)

	(method (dispose)
		(gUser canControl: 1 canInput: 1)
		(super dispose: &rest)
	)
)

(instance hl of Prop
	(properties
		x 110
		y 55
		view 616
		loop 2
		priority 14
		signal 16400
	)

	(method (cue)
		(UnLoad 128 616)
		(DisposeScript 2000)
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(if (< local2 1)
			(if (not local2)
				(= local2 -1)
				(localproc_4)
				(gUser canControl: 1 canInput: 1)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		else
			(-- local2)
		)
		(if (!= (= temp0 (localproc_0)) -1)
			(self x: (localproc_1 temp0) y: (localproc_2 temp0))
			(if (& global129 (<< $0001 temp0))
				(self cel: 1)
			else
				(self cel: 0)
			)
		)
		(super doit: &rest)
	)
)

(instance theExit of View
	(properties
		x 146
		y 108
		view 616
		loop 3
		priority 14
		signal 16401
	)

	(method (doVerb &tmp temp0)
		(punchCard dispose:)
	)
)

