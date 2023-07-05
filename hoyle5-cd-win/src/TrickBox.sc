;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use System)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((trickBoxWindow casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
)

(class TrickBox of Obj
	(properties
		underBits 0
		view 704
		loop 0
		cel 0
		x 0
		y 0
		priority 14
		active 0
		saveBits 0
	)

	(method (init param1 param2)
		(trickBoxWindow init:)
		(proc0_10 view loop cel 0 0 priority trickBoxWindow {trickBox})
		(= active 1)
		(self increment: 0 param1 param2)
		(self increment: 1 param1 param2)
		(= global433 0)
		(cond
			((== gCardGameScriptNumber 700)
				(= global434 (/ (+ global427 4) 5))
				(proc0_10
					view
					5
					global434
					3
					6
					priority
					trickBoxWindow
					{trickBox}
				)
				(proc0_10
					view
					7
					(if (>= (gTrick trump:) 0)
						(gTrick trump:)
					else
						4
					)
					21
					6
					priority
					trickBoxWindow
					{trickBox}
				)
				(if (>= global424 50)
					(proc0_10
						view
						4
						(if (== global424 50) 0 else 1)
						38
						6
						priority
						trickBoxWindow
						{trickBox}
					)
				)
				(proc0_10
					view
					3
					(global429 location:)
					89
					6
					priority
					trickBoxWindow
					{trickbox}
				)
			)
			((== gCardGameScriptNumber 800)
				(proc0_10
					view
					2
					(if (>= (gTrick trump:) 0)
						(gTrick trump:)
					else
						4
					)
					(+ x 12)
					(+ y 6)
					priority
					trickBoxWindow
					{euchre}
				)
				(proc0_10
					view
					3
					(global429 location:)
					(+ x 70)
					(+ y 4)
					priority
					trickBoxWindow
					{euchre}
				)
			)
		)
	)

	(method (save)
		(if underBits
			(= underBits 0)
		)
	)

	(method (restore)
		(= saveBits 0)
	)

	(method (erase)
		(trickBoxWindow dispose:)
		(if underBits
			(= active (= underBits 0))
		)
	)

	(method (increment param1 param2 param3)
		(cond
			((or (== (global429 location:) 1) (== (global429 location:) 3))
				(if (== param1 0)
					(++ global433)
					(localproc_0 {weTrickBox})
					(proc0_10
						view
						1
						param2
						22
						43
						priority
						trickBoxWindow
						{weTrickBox}
					)
				else
					(localproc_0 {theyTrickBox})
					(proc0_10
						view
						1
						param3
						75
						43
						priority
						trickBoxWindow
						{theyTrickBox}
					)
				)
			)
			((== param1 0)
				(localproc_0 {weTrickBox})
				(proc0_10
					view
					1
					param2
					75
					43
					priority
					trickBoxWindow
					{weTrickBox}
				)
			)
			(else
				(++ global433)
				(localproc_0 {theyTrickBox})
				(proc0_10
					view
					1
					param3
					22
					43
					priority
					trickBoxWindow
					{theyTrickBox}
				)
			)
		)
	)
)

(instance trickBoxWindow of Plane
	(properties)

	(method (init &tmp [temp0 2])
		(= top 0)
		(= left 438)
		(= bottom (+ top 77))
		(= right (+ left 120))
		(= priority 9)
		(= picture -2)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
	)

	(method (dispose)
		(if (self casts:)
			(super dispose:)
		)
	)
)

