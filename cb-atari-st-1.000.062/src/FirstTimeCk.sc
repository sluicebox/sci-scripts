;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 409)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Motion)
(use Menu)
(use System)

(public
	FirstTimeCk 0
)

(instance FirstTimeCk of Script
	(properties)

	(method (doit &tmp [temp0 500])
		(super doit:)
		(DrawPic 992 7)
		(gCast eachElementDo: #hide)
		(= global221 999)
		(gGame setCursor: 999 1)
		(SetCursor 999 (HaveMouse) 160 115)
		(gConMusic number: 17 loop: 1 play:)
		(if
			(Print ; "Have you previously attended a performance of "The Colonel's Bequest?""
				409
				0
				#icon
				myIcon
				0
				1
				#mode
				1
				#font
				0
				#button
				{      Yes      }
				0
				#button
				{       No       }
				1
			)
			(gConMusic fade:)
			(SetCursor 997 1 320 190)
			(gCurRoom newRoom: 777) ; myWill
		else
			(gConMusic fade:)
			(TheMenuBar state: 1)
			(gCurRoom newRoom: 44)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 409)
	)
)

(instance myIcon of DCIcon
	(properties
		view 899
		cel 1
		cycleSpeed 24
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

