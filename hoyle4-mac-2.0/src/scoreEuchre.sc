;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use EScore)
(use GameControls)
(use System)

(public
	scoreEuchre 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(switch param2
		(0
			(DrawCel (+ 881 global384) 0 0 (+ 0 param3) 27 15)
			(DrawCel (+ 881 global384) 0 1 (+ 11 param3) 27 15)
		)
		(1
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel (+ 881 global384) 0 1 (+ 11 param3) 27 15)
		)
		(2
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel (+ 881 global384) 0 0 (+ 20 param3) 27 15)
		)
		(3
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel (+ 881 global384) 0 1 (+ 23 param3) 37 15)
		)
		(4
			(DrawCel (+ 881 global384) 0 1 (+ 12 param3) 27 15)
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
		)
		(5
			(DrawCel 880 (+ param1 1) 0 (+ 0 param3) 27 15)
			(DrawCel 880 param1 1 (+ 10 param3) 29 15)
		)
		(6
			(DrawCel (+ 881 global384) 0 1 (+ 12 param3) 27 15)
			(DrawCel 880 (+ param1 1) 0 (+ 0 param3) 27 15)
		)
		(7
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel 880 (+ param1 1) 1 (+ 11 param3) 29 15)
		)
		(8
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel 880 (+ param1 1) 0 (+ 20 param3) 27 15)
		)
		(9
			(DrawCel 880 param1 0 (+ 0 param3) 27 15)
			(DrawCel 880 (+ param1 1) 1 (+ 27 param3) 30 15)
		)
		(10
			(DrawCel 880 param1 0 (+ -10 param3) 27 15)
			(DrawCel 880 (+ param1 1) 0 (+ 30 param3) 27 15)
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(HandsOn)
	((= gGameControls euchreScore)
		window: euchreScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 80 (iconOK nsLeft:)) y: (+ 58 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreEuchre of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance euchreScoreWindow of InvisibleWindow
	(properties
		top 45
		left 60
		bottom 155
		right 260
	)

	(method (open &tmp [temp0 3])
		(super open:)
		(DrawCel 880 0 0 0 0 15)
		(DrawCel (+ 881 global384) 1 0 0 15)
		(localproc_0 3 (EScore wePoints:) 10)
		(localproc_0 1 (EScore theyPoints:) 110)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance euchreScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 880
		loop 5
		cel 0
		nsLeft 89
		nsTop 77
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

