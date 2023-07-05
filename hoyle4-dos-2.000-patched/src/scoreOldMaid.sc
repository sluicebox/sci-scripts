;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreOldMaid 0
)

(local
	local0
	[local1 18] = [8 4 2 3 1 5 6 7 0 13 15 9 16 12 10 14 11 17]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(proc0_3)
	((= gGameControls oldMaidScore)
		window: oldMaidScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 90 (iconOK nsLeft:)) y: (+ 51 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreOldMaid of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance oldMaidScoreWindow of InvisibleWindow
	(properties
		top 38
		left 70
		bottom 189
		right 246
	)

	(method (open &tmp temp0 temp1 [temp2 4])
		(super open:)
		(DrawCel 280 0 0 0 0 15)
		(= temp1 (((global117 at: 1) owner:) view:))
		(DrawCel 280 (if (>= temp1 9) 2 else 1) (mod temp1 9) 19 22 15)
		(drawMaids doit: temp1 1 22)
		(= temp1 (((global117 at: 2) owner:) view:))
		(DrawCel 280 (if (>= temp1 9) 2 else 1) (mod temp1 9) 19 47 15)
		(drawMaids doit: temp1 2 47)
		(= temp1 (((global117 at: 3) owner:) view:))
		(DrawCel 280 (if (>= temp1 9) 2 else 1) (mod temp1 9) 19 72 15)
		(drawMaids doit: temp1 3 72)
		(DrawCel 280 3 0 19 99 15)
		(drawMaids doit: 99 0 99)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance drawMaids of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1)
		(= temp1 25)
		(for
			((= temp0 0))
			(< temp0 ((global117 at: param2) total:))
			((++ temp0))
			
			(if (> temp1 115)
				(break)
			)
			(if (< param1 99)
				(DrawCel
					280
					4
					0
					(+
						(CelWide 280 (if (>= param1 9) 2 else 1) (mod param1 9))
						temp1
					)
					(- param3 11)
					15
				)
			else
				(DrawCel 280 4 0 (+ (CelWide 280 3 0) temp1) (- param3 11) 15)
			)
			(+= temp1 15)
		)
	)
)

(instance oldMaidScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 280
		loop 5
		cel 0
		nsLeft 98
		nsTop 115
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

