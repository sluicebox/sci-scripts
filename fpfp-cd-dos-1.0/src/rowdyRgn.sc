;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rowdyRgn 0
)

(instance rowdyRgn of Rgn
	(properties)

	(method (init)
		(cond
			((not (OneOf gPrevRoomNum 220 235 240 250 400))
				(gGameMusic2 number: 235 loop: -1 play:)
				(if (or (== gCurRoomNum 235) (== gCurRoomNum 240))
					(gGameMusic2 setVol: 127)
				else
					(gGameMusic2 setVol: 63)
				)
			)
			((OneOf gCurRoomNum 235 240)
				(gGameMusic2 setVol: 127)
			)
			(else
				(gGameMusic2 setVol: 63)
			)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 220 235 240 250 400))
		(= initialized 0)
	)

	(method (dispose)
		(gGameMusic2 fade: 0 30 12 1)
		(super dispose:)
	)
)

