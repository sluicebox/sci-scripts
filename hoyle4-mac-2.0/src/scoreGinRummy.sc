;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreGinRummy 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 18] = [8 4 2 3 1 5 6 7 0 13 15 9 16 12 10 14 11 17]
	[local28 9]
	[local37 9]
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 100)
		(DrawCel 480 local8 (mod (/ param1 100) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 480 local8 (mod (/ param1 10) 10) (+ param2 27) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 480 local8 (mod param1 10) (+ param2 36) param3 15)
	)
)

(procedure (localproc_1)
	(if (or global111 global244)
		(scoreCode doit:)
	)
	(= local0 gGameControls)
	((= gGameControls ginRummyScore)
		window: ginRummyScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGame setCursor: 999)
	(gGameControls show:)
	(HandsOn)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 75 (iconOK nsLeft:)) y: (+ 48 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreGinRummy of Code
	(properties)

	(method (doit param1)
		(= local9 param1)
		(localproc_1)
	)
)

(instance ginRummyScoreWindow of InvisibleWindow
	(properties
		top 35
		left 55
		bottom 172
		right 305
	)

	(method (open &tmp temp0 temp1 temp2 temp3)
		(super open:)
		(DrawCel 480 0 0 0 0 15)
		(= temp0 0)
		(cond
			(global111
				(DrawCel 480 3 0 34 7)
				(if
					(or
						(== (gChar1 view:) 1)
						(== (gChar1 view:) 5)
						(== (gChar1 view:) 10)
						(== (gChar1 view:) 12)
						(== (gChar1 view:) 16)
					)
					(DrawCel 480 1 3 178 8)
				else
					(DrawCel 480 1 4 178 8)
				)
				(= local8 4)
				(= temp1 (* 25 (- local2 local1)))
				(if local3
					(= temp2 100)
					(= temp3 [local37 0])
					(+= temp2 [local28 0])
					(DrawCel 480 1 0 103 8)
					(if (not [local37 0])
						(*= temp2 2)
						(localproc_0 (/ temp2 2) 124 33 1)
						(localproc_0 0 160 33 1)
					)
				else
					(= temp2 [local28 0])
					(= temp3 (+ (= temp3 100) [local37 0]))
					(if
						(or
							(== (gChar1 view:) 1)
							(== (gChar1 view:) 5)
							(== (gChar1 view:) 10)
							(== (gChar1 view:) 12)
							(== (gChar1 view:) 16)
						)
						(DrawCel 480 1 1 103 8)
					else
						(DrawCel 480 1 2 103 8)
					)
					(if (not [local28 0])
						(*= temp3 2)
						(localproc_0 (/ temp3 2) 160 33 1)
						(localproc_0 0 124 33 1)
					)
				)
				(cond
					((> temp1 0)
						(localproc_0 temp1 124 45 1)
						(localproc_0 0 160 45 1)
						(+= temp2 temp1)
					)
					((< temp1 0)
						(localproc_0 (* temp1 -1) 160 45 1)
						(localproc_0 0 124 45 1)
						(+= temp3 (* temp1 -1))
					)
					(else
						(localproc_0 0 124 45 1)
						(localproc_0 0 160 45 1)
					)
				)
				(localproc_0 temp2 124 69 1)
				(localproc_0 temp3 160 69 1)
				(if local3
					(localproc_0 100 124 57 1)
					(localproc_0 0 160 57 1)
					(localproc_0 [local28 0] 124 21 1)
					(localproc_0 [local37 0] 160 21 1)
					(localproc_0 (- temp2 temp3) 124 91 1)
				else
					(localproc_0 0 124 57 1)
					(localproc_0 100 160 57 1)
					(localproc_0 [local28 0] 124 21 1)
					(localproc_0 [local37 0] 160 21 1)
					(localproc_0 (- temp3 temp2) 160 91 1)
				)
				(= local1 0)
				(= local2 0)
				(= [local28 8] 0)
				(= [local28 7] 0)
				(= [local28 6] 0)
				(= [local28 5] 0)
				(= [local28 4] 0)
				(= [local28 3] 0)
				(= [local28 2] 0)
				(= [local28 1] 0)
				(= [local28 0] 0)
				(= [local28 8] 0)
				(= [local28 7] 0)
				(= [local37 6] 0)
				(= [local37 5] 0)
				(= [local37 4] 0)
				(= [local37 3] 0)
				(= [local37 2] 0)
				(= [local37 1] 0)
				(= [local37 0] 0)
			)
			(global244
				(drawScore doit:)
				(= local8 8)
				(DrawCel 480 2 0 6 6)
				(if (and (== global242 1) local9)
					(DrawCel 480 2 3 5 28)
				)
				(cond
					(local3
						(DrawCel 480 1 0 103 8)
					)
					(
						(or
							(== (gChar1 view:) 1)
							(== (gChar1 view:) 5)
							(== (gChar1 view:) 10)
							(== (gChar1 view:) 12)
							(== (gChar1 view:) 16)
						)
						(DrawCel 480 1 1 103 8)
					)
					(else
						(DrawCel 480 1 2 103 8)
					)
				)
				(cond
					(local5
						(if (and (== global242 1) local9)
							(localproc_0 (- local6 50) 80 28 1)
							(localproc_0 50 80 42)
						else
							(localproc_0 (- local6 25) 80 28 1)
							(localproc_0 25 80 42)
						)
						(DrawCel 480 2 1 6 40)
						(localproc_0 local6 80 57 1)
					)
					((not local4)
						(if (and (== global242 1) local9)
							(localproc_0 (- local6 50) 80 28 1)
							(localproc_0 50 80 42)
						else
							(localproc_0 25 80 42)
							(localproc_0 (- local6 25) 80 28 1)
						)
						(DrawCel 480 2 2 6 40)
						(localproc_0 local6 80 57 1)
					)
					(else
						(localproc_0 local6 80 28 1)
						(localproc_0 0 80 42 1)
						(localproc_0 local6 80 57 1)
					)
				)
			)
			(else
				(drawScore doit:)
			)
		)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance ginRummyScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 480
		loop 5
		cel 0
		nsLeft 28
		nsTop 83
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance scoreCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 20])
		(= temp0 ((global117 at: 0) knockHand:))
		(= local6 0)
		(= temp1 (temp0 bestDeadWood:))
		(= temp2 ((temp0 opponent:) bestDeadWood:))
		(if (= local5 (not temp1))
			(= local6 25)
		)
		(if (or (< temp1 temp2) local5)
			(= local4 1)
			(+= local6 (- temp2 temp1))
		else
			(= local4 0)
			(= local6 (+ (= local6 25) (- temp1 temp2)))
		)
		(if (and (== global242 1) local9)
			(*= local6 2)
		)
		(if
			(or
				(and (== (temp0 type:) 0) local4)
				(and (== (temp0 type:) 1) (not local4))
			)
			(++ local2)
			(= local3 1)
			(= global547 0)
			(= [local28 8] [local28 7])
			(= [local28 7] [local28 6])
			(= [local28 6] [local28 5])
			(= [local28 5] [local28 4])
			(= [local28 4] [local28 3])
			(= [local28 3] [local28 2])
			(= [local28 2] [local28 1])
			(= [local28 1] [local28 0])
			(+= [local28 0] local6)
			(if (>= [local28 0] 100)
				(= global111 1)
				(= local7 0)
			)
		else
			(= local3 0)
			(= global547 1)
			(++ local1)
			(= [local28 8] [local28 7])
			(= [local28 7] [local28 6])
			(= [local37 6] [local37 5])
			(= [local37 5] [local37 4])
			(= [local37 4] [local37 3])
			(= [local37 3] [local37 2])
			(= [local37 2] [local37 1])
			(= [local37 1] [local37 0])
			(+= [local37 0] local6)
			(if (>= [local37 0] 100)
				(= global111 1)
				(= local7 1)
			)
		)
	)
)

(instance drawScore of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= local8 4)
		(if
			(or
				(== (gChar1 view:) 1)
				(== (gChar1 view:) 5)
				(== (gChar1 view:) 10)
				(== (gChar1 view:) 12)
				(== (gChar1 view:) 16)
			)
			(DrawCel 480 1 3 178 8)
		else
			(DrawCel 480 1 4 178 8)
		)
		(if (> (= temp0 (- local2 1)) 8)
			(= temp0 8)
		)
		(if (> (= temp1 (- local1 1)) 8)
			(= temp1 8)
		)
		(= temp3 19)
		(for ((= temp2 temp0)) (>= temp2 0) ((-- temp2))
			(localproc_0 [local28 temp2] 124 temp3)
			(+= temp3 9)
		)
		(= temp3 19)
		(for ((= temp2 temp1)) (>= temp2 0) ((-- temp2))
			(localproc_0 [local37 temp2] 160 temp3)
			(+= temp3 9)
		)
	)
)

