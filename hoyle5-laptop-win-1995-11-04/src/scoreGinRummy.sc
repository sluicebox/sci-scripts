;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
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
	local46
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 100)
		(proc0_10
			480
			local8
			(mod (/ param1 100) 10)
			(+ param2 22)
			param3
			15
			ginRummyScoreWindow
		)
	)
	(if (>= param1 10)
		(proc0_10
			480
			local8
			(mod (/ param1 10) 10)
			(+ param2 33)
			param3
			15
			ginRummyScoreWindow
		)
	)
	(if (>= param1 0)
		(proc0_10
			480
			local8
			(mod param1 10)
			(+ param2 44)
			param3
			15
			ginRummyScoreWindow
		)
	)
)

(procedure (localproc_1)
	(if (or global111 global244)
		(scoreCode doit:)
	)
	(= local0 gGameControls)
	((= gGameControls ginRummyScore)
		plane: ginRummyScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGame setCursor: 999)
	(if (and local46 (not global111))
		(cond
			((== global547 0)
				(if (> gAttitudeSetting 1)
					(gChar1 sayPN: 1000 2 83 0 (Random 1 5) 718 1)
				)
			)
			((> gAttitudeSetting 1)
				(gChar1 sayPN: 1000 2 82 0 (Random 1 5) 718 1)
			)
		)
	)
	(gGameControls show:)
	(EnableCursor)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 145 (iconOK nsLeft:)) y: (+ 61 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreGinRummy of Code
	(properties)

	(method (doit param1 param2)
		(= local9 param1)
		(if (== param2 2)
			(= local46 1)
		else
			(= local46 0)
		)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(localproc_1)
		(PlaySong play: 0)
		(proc64996_0)
	)
)

(instance ginRummyScoreWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(if global111
			(= top 48)
			(= left 105)
			(= bottom 370)
			(= right 519)
		else
			(= top 48)
			(= left 125)
			(= bottom 370)
			(= right 519)
		)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(= temp0 0)
		(cond
			(global111
				(proc0_10 480 0 1 0 0 15 self)
				(= temp4 (((global117 at: 1) owner:) view:))
				(if global916
					(-= temp4 1400)
				)
				(proc0_10
					480
					(if global916 10 else 9)
					temp4
					313
					40
					15
					ginRummyScoreWindow
				)
				(= local8 4)
				(= temp1 (* 25 (- local2 local1)))
				(if local3
					(= temp2 100)
					(= temp3 [local37 0])
					(+= temp2 [local28 0])
					(proc0_10 480 1 0 125 28 15 ginRummyScoreWindow)
					(if (not [local37 0])
						(*= temp2 2)
						(localproc_0 (/ temp2 2) 200 78 1)
						(localproc_0 0 280 78 1)
					)
				else
					(= temp2 [local28 0])
					(= temp3 (+ (= temp3 100) [local37 0]))
					(= temp4 (((global117 at: 1) owner:) view:))
					(if global916
						(-= temp4 1400)
					)
					(proc0_10
						480
						(if global916 10 else 9)
						temp4
						145
						40
						15
						ginRummyScoreWindow
					)
					(if (not [local28 0])
						(*= temp3 2)
						(localproc_0 (/ temp3 2) 280 78 1)
						(localproc_0 0 200 78 1)
					)
				)
				(cond
					((> temp1 0)
						(localproc_0 temp1 200 102 1)
						(localproc_0 0 280 102 1)
						(+= temp2 temp1)
					)
					((< temp1 0)
						(localproc_0 (* temp1 -1) 280 102 1)
						(localproc_0 0 200 102 1)
						(+= temp3 (* temp1 -1))
					)
					(else
						(localproc_0 0 200 102 1)
						(localproc_0 0 280 102 1)
					)
				)
				(localproc_0 temp2 200 150 1)
				(localproc_0 temp3 280 150 1)
				(if local3
					(localproc_0 100 200 126 1)
					(localproc_0 0 280 126 1)
					(localproc_0 [local28 0] 200 54 1)
					(localproc_0 [local37 0] 280 54 1)
					(localproc_0 (- temp2 temp3) 200 174 1)
				else
					(localproc_0 0 200 126 1)
					(localproc_0 100 280 126 1)
					(localproc_0 [local28 0] 200 54 1)
					(localproc_0 [local37 0] 280 54 1)
					(localproc_0 (- temp3 temp2) 280 174 1)
				)
				(proc0_10 480 7 0 205 143 15 ginRummyScoreWindow)
				(proc0_10 480 7 0 283 143 15 ginRummyScoreWindow)
				(proc0_10 480 7 0 205 171 15 ginRummyScoreWindow)
				(proc0_10 480 7 0 283 171 15 ginRummyScoreWindow)
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
				(proc0_10 480 0 0 0 0 15 self)
				(drawScore doit:)
				(= local8 8)
				(proc0_10 480 2 0 0 0 15 ginRummyScoreWindow)
				(if (and (== gGinRummyOptionIsVariant 1) local9)
					(proc0_10 480 2 3 53 99 25 ginRummyScoreWindow)
				)
				(if local3
					(proc0_10 480 1 0 190 68 15 ginRummyScoreWindow)
				else
					(proc0_10 480 1 1 190 68 15 ginRummyScoreWindow)
				)
				(cond
					(local5
						(if (and (== gGinRummyOptionIsVariant 1) local9)
							(localproc_0 (- local6 50) 170 99 1)
							(localproc_0 50 170 129)
						else
							(localproc_0 (- local6 25) 170 99 1)
							(localproc_0 25 170 129)
						)
						(proc0_10 480 2 1 106 128 15 ginRummyScoreWindow)
						(localproc_0 local6 170 169 1)
					)
					((not local4)
						(if (and (== gGinRummyOptionIsVariant 1) local9)
							(localproc_0 (- local6 50) 170 99 1)
							(localproc_0 50 170 129)
						else
							(localproc_0 25 170 129)
							(localproc_0 (- local6 25) 170 99 1)
						)
						(proc0_10 480 2 2 110 128 15 ginRummyScoreWindow)
						(localproc_0 local6 170 169 1)
					)
					(else
						(localproc_0 local6 170 99 1)
						(localproc_0 0 170 129 1)
						(localproc_0 local6 170 169 1)
					)
				)
			)
			(else
				(proc0_10 480 0 2 0 0 15 self)
				(drawScore doit:)
			)
		)
	)
)

(instance ginRummyScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 229
		nsTop 196
		x 229
		y 196
		signal 387
		mainView 480
		mainLoop 5
		highlightColor -1
	)

	(method (init)
		(if global111
			(= x 196)
			(= y 199)
		else
			(= x 229)
			(= y 196)
		)
		(self setPri: 200)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
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
		(if (and (== gGinRummyOptionIsVariant 1) local9)
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

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= local8 4)
		(= temp4 (((global117 at: 1) owner:) view:))
		(if global916
			(-= temp4 1400)
		)
		(proc0_10
			480
			(if global916 10 else 9)
			temp4
			347
			51
			15
			ginRummyScoreWindow
		)
		(if (> (= temp0 (- local2 1)) 8)
			(= temp0 8)
		)
		(if (> (= temp1 (- local1 1)) 8)
			(= temp1 8)
		)
		(= temp3 68)
		(localproc_0 [local28 0] 230 temp3)
		(= temp3 68)
		(localproc_0 [local37 0] 310 temp3)
	)
)

