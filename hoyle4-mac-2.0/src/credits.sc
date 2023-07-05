;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	credits 0
)

(instance credits of Rm
	(properties
		picture 950
		style 10
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
				(= ticks 60)
			)
			(1
				(gCurRoom overlay: 701 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 180)
			)
			(2
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(3
				(gCurRoom overlay: 702 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 180)
			)
			(4
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(5
				(gCurRoom overlay: 703 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(6
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(7
				(gCurRoom overlay: 704 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(8
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(9
				(gCurRoom overlay: 706 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(10
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(11
				(gCurRoom overlay: 997 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(12
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(13
				(gCurRoom overlay: 998 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(14
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(15
				(gCurRoom overlay: 705 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(16
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(17
				(gCurRoom overlay: 711 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(18
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(19
				(gCurRoom overlay: 707 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(20
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(21
				(gCurRoom overlay: 708 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(22
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(23
				(gCurRoom overlay: 709 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(24
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(25
				(gCurRoom overlay: 710 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(26
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(27
				(gCurRoom overlay: 712 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(28
				(gCurRoom drawPic: 950 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 60)
			)
			(29
				(gCurRoom overlay: 713 9)
				(gGame setCursor: 996 1)
				(proc0_1)
				(= ticks 250)
			)
			(30
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)
)

