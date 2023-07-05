;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	credits 0
)

(local
	local0
)

(procedure (localproc_0)
	(oneCredit dispose:)
	(RedrawCast)
)

(procedure (localproc_1 param1)
	(oneCredit view: param1 loop: 0 cel: 0 posn: 320 240 show: init:)
	(oneCredit setCycle: End (gCurRoom script:))
	(RedrawCast)
)

(instance oneCredit of Prop
	(properties)
)

(instance credits of Room
	(properties
		picture 900
		style 0
	)

	(method (init &tmp temp0)
		(super init:)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
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
				(localproc_1 (+ local0 951))
				(++ local0)
			)
			(2
				(if (< local0 4)
					(= ticks 180)
				else
					(= ticks 400)
				)
				(if (< local0 6)
					(-= state 3)
				)
			)
			(3
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)
)

