;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Print)
(use Game)

(public
	rm101 0
)

(procedure (localproc_0 &tmp temp0 [temp1 5])
	(= temp1 0)
	(= temp0
		(Print
			addText: 1 0 1 1 0 12 ; "Where to, Hero?"
			addEdit: @temp1 5 120 12
			addButton: 200 1 0 0 1 0 26 ; "Tarna"
			addButton: 320 1 0 0 2 120 26 ; "Upper Tarna"
			addButton: 410 1 0 0 3 0 40 ; "Simbani Overlook"
			addButton: 490 1 0 0 4 120 40 ; "Awari Game"
			addButton: 720 1 0 0 5 0 54 ; "Monkeyville"
			addButton: 999 1 0 0 6 120 54 ; "Continue Normally"
			init:
		)
	)
	(if temp1
		(gCurRoom newRoom: (ReadNumber @temp1))
	else
		(switch temp0
			(200
				(gCurRoom newRoom: 200)
			)
			(320
				(gCurRoom newRoom: 320)
			)
			(410
				(gCurRoom newRoom: 410)
			)
			(490
				(gCurRoom newRoom: 490)
			)
			(720
				(gCurRoom newRoom: 720)
			)
			(999
				(gCurRoom newRoom: 130)
			)
			(else
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance rm101 of Rm
	(properties)

	(method (init)
		(DrawPic 0)
		(Animate (gCast elements:) 0)
		(super init:)
		(localproc_0)
	)
)

