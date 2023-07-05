;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 762)
(include sci.sh)
(use Main)
(use TrackingView)
(use BScore)
(use System)

(public
	scorePanel 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 10000)
		(DrawCel 781 4 (/ param1 10000) param2 param3 15)
	)
	(if (>= param1 1000)
		(DrawCel 781 4 (mod (/ param1 1000) 10) (+ param2 6) param3 15)
	)
	(if (>= param1 100)
		(DrawCel 781 4 (mod (/ param1 100) 10) (+ param2 12) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 781 4 (mod (/ param1 10) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 781 4 (mod param1 10) (+ param2 24) param3 15)
	)
)

(instance scorePanel of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= global404 1)
		(if (not global405)
			(proc0_8 1097)
		)
		(gTheIconBar disable:)
		(gChar3 hide:)
		((gChar3 face:) hide:)
		(proc0_1)
		(= local0 63)
		(= local1 118)
		(= local2 (+ local0 (CelHigh 781 0 0)))
		(= local3 (+ local1 (CelWide 781 0 0)))
		(= global406 (Graph grSAVE_BOX local0 local1 local2 local3 3))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(DrawCel 781 0 0 local1 local0 15)
		(DrawCel
			781
			2
			(if (or (BScore weRubberBonus:) (BScore theyRubberBonus:)) 1 else 0)
			(+ local1 7)
			(+ local0 113)
			15
		)
		(DrawCel 781 3 0 (+ local1 7) (+ local0 60) 15)
		(DrawCel
			781
			1
			(if (or (BScore weUndertricks:) (BScore theyUndertricks:)) 0 else 1)
			(+ local1 10)
			(+ local0 49)
			15
		)
		(localproc_0 (BScore weRubberBonus:) (+ local1 100) (+ local0 8))
		(localproc_0 (BScore weSlamBonus:) (+ local1 100) (+ local0 19))
		(localproc_0 (BScore weMadeDoubled:) (+ local1 100) (+ local0 30))
		(localproc_0 (BScore weHonors:) (+ local1 100) (+ local0 41))
		(localproc_0 (BScore weOvertricks:) (+ local1 100) (+ local0 52))
		(localproc_0 (BScore weUndertricks:) (+ local1 100) (+ local0 52))
		(localproc_0 (BScore wePrevOverLine:) (+ local1 100) (+ local0 64))
		(localproc_0 (BScore weGame1:) (+ local1 100) (+ local0 80))
		(localproc_0 (BScore weGame2:) (+ local1 100) (+ local0 91))
		(localproc_0 (BScore weGame3:) (+ local1 100) (+ local0 102))
		(localproc_0 (BScore weTotal:) (+ local1 100) (+ local0 116))
		(localproc_0 (BScore theyRubberBonus:) (+ local1 151) (+ local0 8))
		(localproc_0 (BScore theySlamBonus:) (+ local1 151) (+ local0 19))
		(localproc_0 (BScore theyMadeDoubled:) (+ local1 151) (+ local0 30))
		(localproc_0 (BScore theyHonors:) (+ local1 151) (+ local0 41))
		(localproc_0 (BScore theyOvertricks:) (+ local1 151) (+ local0 52))
		(localproc_0 (BScore theyUndertricks:) (+ local1 151) (+ local0 52))
		(localproc_0 (BScore theyPrevOverLine:) (+ local1 151) (+ local0 64))
		(localproc_0 (BScore theyGame1:) (+ local1 151) (+ local0 80))
		(localproc_0 (BScore theyGame2:) (+ local1 151) (+ local0 91))
		(localproc_0 (BScore theyGame3:) (+ local1 151) (+ local0 102))
		(localproc_0 (BScore theyTotal:) (+ local1 151) (+ local0 116))
		(scoreOKButton
			posn: (+ local1 9) (+ local0 85)
			setPri: 15
			ignoreActors:
			show:
			init:
			stopUpd:
			addKeyMouse:
		)
		(proc0_1)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX local0 local1 local2 local3 1)
		((ScriptID 700 10) add: scoreOKButton) ; handleEventList
		(proc0_3)
		(proc0_7)
	)

	(method (dispose)
		(= global404 0)
		(proc0_8 0)
		(scoreOKButton deleteKeyMouse: dispose: delete:)
		(Graph grRESTORE_BOX global406)
		(Graph grUPDATE_BOX local0 local1 local2 local3 1)
		(= global406 0)
		((ScriptID 700 10) delete: scoreOKButton) ; handleEventList
		(UnLoad 128 781)
		(gChar3 show:)
		(proc0_1)
		(gTheIconBar enable:)
		((gCurRoom script:) cue:)
		(DisposeScript 762)
	)
)

(instance scoreOKButton of TrackingView
	(properties
		view 781
		loop 5
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (super handleEvent: event)
			(event claimed: 1)
			(scorePanel dispose:)
		)
	)
)

