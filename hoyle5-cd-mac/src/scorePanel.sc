;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 762)
(include sci.sh)
(use Main)
(use TrackingView)
(use h5Messager)
(use BScore)
(use Str)
(use IconBar)
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
		(proc0_10 781 4 (/ param1 10000) param2 param3 15)
	)
	(if (>= param1 1000)
		(proc0_10 781 4 (mod (/ param1 1000) 10) (+ param2 8) param3 15)
	)
	(if (>= param1 100)
		(proc0_10 781 4 (mod (/ param1 100) 10) (+ param2 16) param3 15)
	)
	(if (>= param1 10)
		(proc0_10 781 4 (mod (/ param1 10) 10) (+ param2 24) param3 15)
	)
	(if (>= param1 0)
		(proc0_10 781 4 (mod param1 10) (+ param2 32) param3 15)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp1 (Str format: {drawCel}))
	(for ((= temp0 (- (gCast size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((gCast at: temp0) name:)
				(temp1 compare: ((gCast at: temp0) name:))
			)
			((gCast at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
)

(instance scorePanel of Code
	(properties)

	(method (init &tmp [temp0 3])
		(= global404 1)
		(if (not global405)
			(proc0_8 97)
		)
		(IconBarF isUp: 0)
		(IconBarF darken:)
		(RedrawCast)
		(= local0 110)
		(= local1 175)
		(= local2 (+ local0 (CelHigh 781 0 0)))
		(= local3 (+ local1 (CelWide 781 0 0)))
		(proc0_10 781 0 0 local1 local0 15)
		(proc0_10
			781
			2
			(if (or (BScore weRubberBonus:) (BScore theyRubberBonus:)) 1 else 0)
			(+ local1 142)
			(+ local0 240)
			15
		)
		(proc0_10 781 3 0 (+ local1 142) (+ local0 152) 15)
		(proc0_10
			781
			1
			(if (or (BScore weUndertricks:) (BScore theyUndertricks:)) 0 else 1)
			(+ local1 143)
			(+ local0 130)
			15
		)
		(localproc_0 (BScore weRubberBonus:) (+ local1 169) (+ local0 32))
		(localproc_0 (BScore weSlamBonus:) (+ local1 169) (+ local0 54))
		(localproc_0 (BScore weMadeDoubled:) (+ local1 169) (+ local0 76))
		(localproc_0 (BScore weHonors:) (+ local1 169) (+ local0 98))
		(localproc_0 (BScore weOvertricks:) (+ local1 169) (+ local0 120))
		(localproc_0 (BScore weUndertricks:) (+ local1 169) (+ local0 120))
		(localproc_0 (BScore wePrevOverLine:) (+ local1 169) (+ local0 143))
		(localproc_0 (BScore weGame1:) (+ local1 169) (+ local0 164))
		(localproc_0 (BScore weGame2:) (+ local1 169) (+ local0 186))
		(localproc_0 (BScore weGame3:) (+ local1 169) (+ local0 208))
		(localproc_0 (BScore weTotal:) (+ local1 169) (+ local0 230))
		(localproc_0 (BScore theyRubberBonus:) (+ local1 234) (+ local0 32))
		(localproc_0 (BScore theySlamBonus:) (+ local1 234) (+ local0 54))
		(localproc_0 (BScore theyMadeDoubled:) (+ local1 234) (+ local0 76))
		(localproc_0 (BScore theyHonors:) (+ local1 234) (+ local0 98))
		(localproc_0 (BScore theyOvertricks:) (+ local1 234) (+ local0 120))
		(localproc_0 (BScore theyUndertricks:) (+ local1 234) (+ local0 120))
		(localproc_0 (BScore theyPrevOverLine:) (+ local1 234) (+ local0 143))
		(localproc_0 (BScore theyGame1:) (+ local1 234) (+ local0 164))
		(localproc_0 (BScore theyGame2:) (+ local1 234) (+ local0 186))
		(localproc_0 (BScore theyGame3:) (+ local1 234) (+ local0 208))
		(localproc_0 (BScore theyTotal:) (+ local1 234) (+ local0 230))
		(scoreOKButton
			posn: (+ local1 159) (+ local0 249)
			setPri: 15
			ignoreActors:
			show:
			init:
			addKeyMouse:
		)
		(RedrawCast)
		(if
			(and
				(> gAttitudeSetting 1)
				(BScore rubberOver:)
				(> (BScore weTotal:) (BScore theyTotal:))
			)
			((Characters at: 0) say: 15 15 179 0 (Random 1 7))
		)
		((ScriptID 700 10) add: scoreOKButton) ; handleEventList
		(EnableCursor)
		(proc0_7)
	)

	(method (dispose)
		(= global404 0)
		(localproc_1)
		(scoreOKButton deleteKeyMouse: dispose:)
		(= global406 0)
		((ScriptID 700 10) delete: scoreOKButton) ; handleEventList
		(UnLoad 128 781)
		(RedrawCast)
		(IconBarF isUp: 1)
		(IconBarF lighten:)
		(PlaySong play: 0)
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

