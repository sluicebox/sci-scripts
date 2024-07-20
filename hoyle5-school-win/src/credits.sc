;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Str)
(use Game)
(use System)

(public
	credits 0
)

(local
	local0
)

(procedure (localproc_0)
	(localproc_2)
	(RedrawCast)
)

(procedure (localproc_1 param1)
	(proc0_10
		param1
		0
		0
		(- 160 (/ (CelWide param1 0 0) 2))
		(- 100 (/ (CelHigh param1 0 0) 2))
		15
	)
	(gGame setCursor: 996 1)
	(RedrawCast)
)

(procedure (localproc_2 &tmp temp0 temp1)
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

(instance credits of Room
	(properties
		picture 951
		style 0
	)

	(method (init &tmp temp0)
		(super init:)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(gGame setCursor: 996 1)
		(self setScript: creditsScript)
		(gTheIconBar enable:)
		(= local0 0)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return)
		)
		(if (and (not (event claimed:)) (event type:))
			(event claimed: 1)
			(if
				(and
					(or (& (event type:) evMOUSEBUTTON) (& (event type:) evKEYBOARD))
					(> (event y:) 0)
				)
				(RedrawCast)
				(gSound play: 901)
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)

	(method (dispose)
		(gGame setCursor: 997 1)
		(super dispose:)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(localproc_0)
				(= ticks 60)
			)
			(1
				(localproc_1 (+ local0 701))
				(if (< (++ local0) 3)
					(-= state 2)
				)
				(= ticks 180)
			)
			(2
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)
)

