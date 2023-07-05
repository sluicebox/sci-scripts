;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6020)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use ManualSort)
(use TrackingView)
(use h5Messager)
(use sHand)
(use acesup)
(use Str)
(use Print)
(use IconBar)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	bowling 0
	proc6020_1 1
	optionCode 2
	roomScript 3
	proc6020_4 4
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22 = 1
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
)

(procedure (proc6020_1)
	(if local42
		((ScriptID 6081 0) doit: global928 local46 local47 local48 local49) ; scoreBowling
	else
		((ScriptID 6081 0) doit: global928) ; scoreBowling
	)
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(if
			(and
				((gTheHands at: temp0) size:)
				(== local11 (((gTheHands at: temp0) at: 0) rank:))
			)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if (== param1 10)
		(if (< ((gTheHands at: 10) size:) ((gTheHands at: 10) cardLimit:))
			(return 1)
		else
			(return 0)
		)
	)
	(if (== param1 11)
		(if
			(and
				(== ((gTheHands at: 10) size:) ((gTheHands at: 10) cardLimit:))
				(< ((gTheHands at: 11) size:) ((gTheHands at: 11) cardLimit:))
			)
			(return 1)
		else
			(return 0)
		)
	)
	(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
		(if ((gTheHands at: temp0) size:)
			(if (> local11 (((gTheHands at: temp0) at: 0) rank:))
			else
				(return 0)
			)
		)
	)
	(for ((= temp0 (+ param1 1))) (< temp0 10) ((++ temp0))
		(if ((gTheHands at: temp0) size:)
			(if (< local11 (((gTheHands at: temp0) at: 0) rank:))
			else
				(return 0)
			)
		)
	)
	(return 1)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp1 0)
	(= temp4 0)
	(= temp5 0)
	(switch local22
		(1
			(= temp0 (playersList at: 0))
			(= local16 local17)
		)
		(2
			(= temp0 (playersList at: 1))
			(= local16 local18)
		)
		(3
			(= temp0 (playersList at: 2))
			(= local16 local19)
		)
		(4
			(= temp0 (playersList at: 3))
			(= local16 local20)
		)
	)
	(cond
		((== local13 9)
			(= temp1 (temp0 at: 9))
			(= temp2 (temp0 at: 8))
			(= temp3 (temp0 at: 7))
		)
		((== local13 0)
			(= temp1 (temp0 at: 0))
			(= temp2 0)
			(= temp3 0)
		)
		((== local13 1)
			(= temp1 (temp0 at: 1))
			(= temp2 (temp0 at: 0))
			(= temp3 0)
		)
		(else
			(= temp1 (temp0 at: local13))
			(= temp2 (temp0 at: (- local13 1)))
			(= temp3 (temp0 at: (- local13 2)))
		)
	)
	(if (!= (param1 whatType:) 1)
		(if (== local12 1)
			(temp1 b1Score: (++ local14))
		else
			(temp1 b2Score: (++ local15))
		)
	)
	(if (== local14 10)
		(localproc_3 0 local22 local13 0 0 -1 11)
		(if (== local16 3)
			(temp1 bscore: (+ (temp2 bscore:) 30))
			(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
			(temp1 done: 1)
			(if (and (!= local21 1) (!= local22 local21))
				(flipButton loop: 13)
				(flipButton show:)
				(handleEventList add: flipButton)
			else
				(flipButton loop: 11)
				(flipButton show:)
			)
		else
			(if (and (== local16 2) (temp1 spare:))
				(temp1 bscore: (+ (temp2 bscore:) 20))
				(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
				(temp1 done: 1)
				(++ local16)
				(if (and (!= local21 1) (!= local22 local21))
					(flipButton loop: 13)
					(flipButton show:)
					(handleEventList add: flipButton)
				else
					(flipButton loop: 11)
					(flipButton show:)
				)
			)
			(if (and (== local16 2) (temp2 strike:))
				(temp2 bscore: (+ (temp2 bscore:) 10) strike: 0)
				(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
				(temp1 bscore: (+ (temp2 bscore:) 20) strike: 1)
			else
				(if (and temp3 (temp3 strike:))
					(temp3 bscore: (+ (temp3 bscore:) 10) strike: 0)
					(temp2 bscore: (+ (temp3 bscore:) 10))
					(localproc_3 0 local22 (- local13 2) 0 0 (temp3 bscore:) 0)
				)
				(if (and temp2 (temp2 strike:))
					(temp2 bscore: (+ (temp2 bscore:) 10))
					(temp1 bscore: (+ (temp2 bscore:) 10) strike: 1)
				)
			)
		)
		(if (and temp2 (temp2 spare:) (!= local16 2))
			(temp2 bscore: (+ (temp2 bscore:) 10) spare: 0)
			(temp1 strike: 1)
			(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
		)
		(if (and temp2 (not (temp2 strike:)) (!= local16 3))
			(temp1 bscore: (+ (temp2 bscore:) 10) strike: 1)
		)
		(if (not temp2)
			(temp1 bscore: 10 strike: 1)
		)
		(if (and local16 (== local13 9))
			(++ local16)
		)
		(if (!= local16 4)
			(cond
				((!= local21 1)
					(if (and (== local13 9) (not (temp1 done:)))
						(flipButton view: 974 loop: 1)
						(flipButton show:)
						(handleEventList add: flipButton)
					else
						(flipButton loop: 13)
						(flipButton show:)
						(handleEventList add: flipButton)
					)
				)
				((== local13 9)
					(flipButton view: 974 loop: 1)
					(flipButton show:)
					(handleEventList add: flipButton)
				)
				(else
					(flipButton loop: 12)
					(flipButton show:)
					(handleEventList add: flipButton)
				)
			)
		)
		(handleEventList delete: global419)
		(handleEventList delete: undoButton)
	)
	(if (and (!= local14 10) (== (+ local14 local15) 10))
		(localproc_3 0 local22 local13 0 0 -1 10)
		(cond
			((== local16 2)
				(temp1 bscore: (+ (temp2 bscore:) 20))
				(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
				(temp1 done: 1)
				(if (and (!= local21 1) (!= local22 local21))
					(flipButton loop: 13)
					(flipButton show:)
					(handleEventList add: flipButton)
				else
					(flipButton loop: 11)
					(flipButton show:)
				)
			)
			((and temp2 (temp2 strike:))
				(temp2 bscore: (+ (temp2 bscore:) 10) strike: 0)
				(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
				(temp1 bscore: (+ (temp2 bscore:) 10) spare: 1)
			)
			((and temp2 (not (temp2 strike:)))
				(temp1 bscore: (+ (temp2 bscore:) 10) spare: 1)
			)
		)
		(if (not temp2)
			(temp1 bscore: 10 spare: 1)
		)
		(if (and local16 (== local13 9))
			(temp2 spare: 0)
			(++ local16)
		)
		(if (<= local16 2)
			(cond
				((!= local21 1)
					(if (and (== local13 9) (not (temp1 done:)))
						(flipButton view: 974 loop: 1)
						(flipButton show:)
						(handleEventList add: flipButton)
					else
						(flipButton loop: 13)
						(flipButton show:)
						(handleEventList add: flipButton)
					)
				)
				((== local13 9)
					(flipButton view: 974 loop: 1)
					(flipButton show:)
					(handleEventList add: flipButton)
				)
				(else
					(flipButton loop: 12)
					(flipButton show:)
					(handleEventList add: flipButton)
				)
			)
		)
		(handleEventList delete: global419)
		(handleEventList delete: undoButton)
	)
	(if
		(and
			(== local12 1)
			(== ((gTheHands at: 10) size:) ((gTheHands at: 10) cardLimit:))
		)
		(localproc_3 0 local22 local13 1 local14 -1 0)
		(if (and temp3 (temp3 strike:))
			(temp3 bscore: (+ (temp3 bscore:) local14) strike: 0)
			(temp2 bscore: (+ (temp3 bscore:) 10))
			(localproc_3 0 local22 (- local13 2) 0 0 (temp3 bscore:) 0)
		)
		(if (and temp2 (temp2 spare:))
			(temp2 bscore: (+ (temp2 bscore:) local14) spare: 0)
			(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
		)
		(= local12 2)
		(if (and (== local16 2) (temp2 strike:))
			(temp2 bscore: (+ (temp2 bscore:) local14) strike: 0)
			(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
		)
		(if (and (== local16 2) (temp1 spare:))
			(temp1 bscore: (+ (temp2 bscore:) 10 local14))
			(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
			(handleEventList delete: global419)
			(temp1 done: 1)
			(if (and (!= local21 1) (!= local22 local21))
				(flipButton loop: 13)
				(flipButton show:)
				(handleEventList add: flipButton)
			else
				(flipButton loop: 11)
				(flipButton show:)
			)
		)
		(if (== local16 3)
			(temp1 bscore: (+ (temp2 bscore:) 20 local14))
			(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
			(handleEventList delete: global419)
			(temp1 done: 1)
			(if (and (!= local21 1) (!= local22 local21))
				(flipButton loop: 13)
				(flipButton show:)
				(handleEventList add: flipButton)
			else
				(flipButton loop: 11)
				(flipButton show:)
			)
		)
	)
	(if (== ((gTheHands at: 11) size:) ((gTheHands at: 11) cardLimit:))
		(localproc_3 0 local22 local13 2 local15 -1 0)
		(if (== local16 2)
			(temp1 bscore: (+ (temp2 bscore:) 10 local14 local15))
			(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
			(temp1 done: 1)
			(if (and (!= local21 1) (!= local22 local21))
				(flipButton loop: 13)
				(flipButton show:)
				(handleEventList add: flipButton)
			else
				(flipButton loop: 11)
				(flipButton show:)
			)
		else
			(if (and temp2 (temp2 strike:))
				(temp2 bscore: (+ (temp2 bscore:) local14 local15) strike: 0)
				(localproc_3 0 local22 (- local13 1) 0 0 (temp2 bscore:) 0)
			)
			(if (and temp2 (not (temp2 strike:)))
				(temp1 bscore: (+ (temp2 bscore:) local14 local15))
				(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
				(if (== local16 1)
					(temp1 done: 1)
					(if (and (!= local21 1) (!= local22 local21))
						(flipButton loop: 13)
						(flipButton show:)
						(handleEventList add: flipButton)
					else
						(flipButton loop: 11)
						(flipButton show:)
					)
				)
			)
		)
		(if (not temp2)
			(temp1 bscore: (+ local14 local15))
			(localproc_3 0 local22 local13 0 0 (temp1 bscore:) 0)
		)
		(if (< local16 1)
			(if (!= local21 1)
				(!= local21 local22)
				(flipButton loop: 13)
				(flipButton show:)
				(handleEventList add: flipButton)
			else
				(flipButton loop: 12)
				(flipButton show:)
				(handleEventList add: flipButton)
			)
		)
		(handleEventList delete: global419)
	)
	(if (temp1 done:)
		(switch local22
			(1
				(= local28 global234)
				(= local32 global230)
				(++ global238)
				(= local46 (temp1 bscore:))
				(= global230 (/ (+= global234 (temp1 bscore:)) global238))
				(for
					((= local26 (/ (* (mod global234 global238) 100) global238)))
					(> local26 99)
					((/= local26 10))
				)
				(if (>= local26 50)
					(++ global230)
				)
				(if (> (temp1 bscore:) local38)
					(= local38 (temp1 bscore:))
				)
			)
			(2
				(= local29 global235)
				(= local33 global231)
				(++ global239)
				(= local47 (temp1 bscore:))
				(= global231 (/ (+= global235 (temp1 bscore:)) global239))
				(for
					((= local26 (/ (* (mod global235 global239) 100) global239)))
					(> local26 99)
					((/= local26 10))
				)
				(if (>= local26 50)
					(++ global231)
				)
				(if (> (temp1 bscore:) local38)
					(= local38 (temp1 bscore:))
				)
			)
			(3
				(= local30 global236)
				(= local34 global232)
				(++ global240)
				(= local48 (temp1 bscore:))
				(= global232 (/ (+= global236 (temp1 bscore:)) global240))
				(for
					((= local26 (/ (* (mod global236 global240) 100) global240)))
					(> local26 99)
					((/= local26 10))
				)
				(if (>= local26 50)
					(++ global232)
				)
				(if (> (temp1 bscore:) local38)
					(= local38 (temp1 bscore:))
				)
			)
			(4
				(= local31 global237)
				(= local35 global233)
				(++ global241)
				(= local49 (temp1 bscore:))
				(= global233 (/ (+= global237 (temp1 bscore:)) global241))
				(for
					((= local26 (/ (* (mod global237 global241) 100) global241)))
					(> local26 99)
					((/= local26 10))
				)
				(if (>= local26 50)
					(++ global233)
				)
				(if (> (temp1 bscore:) local38)
					(= local38 (temp1 bscore:))
				)
			)
		)
		(if (>= (temp1 bscore:) 200)
			(= local40 1)
		)
	)
	(if (((playersList at: (- local21 1)) at: 9) done:)
		(flipButton loop: 11)
		(flipButton show:)
		(if (> local38 local39)
			(Print
				ticks: 200
				fore: 0
				mode: 1
				addBitmap: 917 4 0
				font: gUserFont
				addText: {\n*******NEW HIGH SCORE!*******} 25 20
				init:
			)
			(= local39 local38)
			(global929 doit: 3)
			(localproc_7 {high} highScoreWindow)
			(proc6022_6 local38 73 11 1 {high} highScoreWindow)
		)
		(= local27 1)
	)
	(return 1)
)

(procedure (proc6020_4 param1) ; UNUSED
	(if argc
		(= local10 param1)
	else
		(return local10)
	)
)

(procedure (localproc_3 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2)
	(if param1
		(switch param1
			(1
				(bowlingScoreWindow init: 245)
			)
			(2
				(bowlingScoreWindow init: 275)
			)
			(3
				(bowlingScoreWindow init: 305)
			)
			(4
				(bowlingScoreWindow init: 335)
			)
		)
	)
	(if param2
		(cond
			((== param3 9)
				(if (!= local25 param2)
					(= local24 1)
					(= local25 param2)
				else
					(++ local24)
				)
				(cond
					(param7
						(= temp0 (+ 19 (* 23 param3) (* 11 (- local24 1))))
						(= temp1 (+ 18 (* 30 (- param2 1))))
						(proc0_10
							980
							0
							param7
							temp0
							temp1
							16
							bowlingScoreWindow
						)
					)
					(param4
						(= temp0 (+ 19 (* 23 param3) (* 12 (- local24 1))))
						(= temp1 (+ 19 (* 30 (- param2 1))))
						(proc0_10
							980
							0
							param5
							temp0
							temp1
							16
							bowlingScoreWindow
						)
					)
				)
			)
			(param7
				(= temp0 (+ 29 (* 23 param3)))
				(= temp1 (+ 18 (* 30 (- param2 1))))
				(proc0_10 980 0 param7 temp0 temp1 16 bowlingScoreWindow)
			)
			(else
				(if (== param4 1)
					(= temp0 (+ 19 (* 23 param3)))
					(= temp1 (+ 19 (* 30 (- param2 1))))
					(proc0_10 980 0 param5 temp0 temp1 16 bowlingScoreWindow)
				)
				(if (== param4 2)
					(= temp0 (+ 30 (* 23 param3)))
					(= temp1 (+ 19 (* 30 (- param2 1))))
					(proc0_10 980 0 param5 temp0 temp1 16 bowlingScoreWindow)
				)
			)
		)
		(if (>= param6 0)
			(= temp0 (+ 31 (* 23 param3)))
			(= temp1 (+ 34 (* 30 (- param2 1))))
			(= temp2 (mod param6 10))
			(if (== param3 9)
				(proc0_10 980 0 temp2 (+ temp0 8) temp1 16 bowlingScoreWindow)
			else
				(proc0_10 980 0 temp2 temp0 temp1 16 bowlingScoreWindow)
			)
			(if (= temp2 (- param6 temp2))
				(= param6 (mod (/= temp2 10) 10))
				(-= temp0 7)
				(if (== param3 9)
					(proc0_10
						980
						0
						param6
						(+ temp0 8)
						temp1
						16
						bowlingScoreWindow
					)
				else
					(proc0_10 980 0 param6 temp0 temp1 16 bowlingScoreWindow)
				)
				(if (-= temp2 param6)
					(/= temp2 10)
					(-= temp0 6)
					(if (== param3 9)
						(proc0_10
							980
							0
							temp2
							(+ temp0 7)
							temp1
							16
							bowlingScoreWindow
						)
					else
						(proc0_10 980 0 temp2 temp0 temp1 16 bowlingScoreWindow)
					)
				)
			)
		)
	)
)

(procedure (localproc_4)
	(-- global238)
	(= global234 local28)
	(= global230 local32)
	(if (> local21 1)
		(-- global239)
		(= global235 local29)
		(= global231 local33)
		(if (> local21 2)
			(-- global240)
			(= global236 local30)
			(= global232 local34)
			(if (== local21 4)
				(-- global241)
				(= global237 local31)
				(= global233 local35)
			)
		)
	)
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
	(= temp10 0)
	(if (not param2)
		(return 1)
	)
	(if (and (param2 respondsTo: #scaleSignal) (& (param2 scaleSignal:) $0004))
		(= temp2 (+ (param2 x:) (param2 nsLeft:)))
		(= temp3 (+ (param2 x:) (param2 nsRight:)))
		(= temp0 (+ (param2 y:) (param2 nsTop:)))
		(= temp1 (+ (param2 y:) (param2 nsBottom:)))
	else
		(= temp2 (param2 nsLeft:))
		(= temp3 (param2 nsRight:))
		(= temp0 (param2 nsTop:))
		(= temp1 (param2 nsBottom:))
	)
	(if (and (param1 respondsTo: #scaleSignal) (& (param1 scaleSignal:) $0004))
		(= temp6 (+ (param1 x:) (param1 nsLeft:)))
		(= temp7 (+ (param1 x:) (param1 nsRight:)))
		(= temp8 (+ (param1 y:) (param1 nsTop:)))
		(= temp9 (+ (param1 y:) (param1 nsBottom:)))
	else
		(= temp6 (param1 nsLeft:))
		(= temp7 (param1 nsRight:))
		(= temp8 (param1 nsTop:))
		(= temp9 (param1 nsBottom:))
	)
	(= temp4 (+ temp2 (/ (- temp3 temp2) 2)))
	(= temp5 (+ temp0 (/ (- temp1 temp0) 2)))
	(return
		(if
			(or
				(and
					(<= temp0 temp8)
					(>= temp1 temp8)
					(<= temp2 temp6)
					(>= temp3 temp6)
					(= temp10 1)
				)
				(and
					(<= temp0 temp8)
					(>= temp1 temp8)
					(<= temp2 temp7)
					(>= temp3 temp7)
					(= temp10 2)
				)
				(and
					(<= temp0 temp9)
					(>= temp1 temp9)
					(<= temp2 temp6)
					(>= temp3 temp6)
					(= temp10 3)
				)
				(and
					(<= temp0 temp9)
					(>= temp1 temp9)
					(<= temp2 temp7)
					(>= temp3 temp7)
					(= temp10 4)
				)
				(and
					(>= temp0 temp8)
					(<= temp1 temp9)
					(or
						(and (<= temp2 temp6) (>= temp3 temp6) (= temp10 5))
						(and (<= temp2 temp7) (>= temp3 temp7) (= temp10 6))
						(and (>= temp2 temp6) (<= temp3 temp7) (= temp10 7))
					)
				)
				(and
					(>= temp2 temp6)
					(<= temp3 temp7)
					(or
						(and (<= temp0 temp8) (>= temp1 temp8) (= temp10 8))
						(and (<= temp0 temp9) (>= temp1 temp9) (= temp10 9))
						(and (>= temp0 temp8) (<= temp1 temp9))
					)
				)
				(and (<= temp6 temp4 temp7) (<= temp8 temp5 temp9))
			)
			(switch temp10
				(1
					(= temp11 (- temp3 temp6))
					(= temp12 (- temp1 temp8))
					(= temp13 (* temp11 temp12))
				)
				(2
					(= temp11 (- temp7 temp2))
					(= temp12 (- temp1 temp8))
					(= temp13 (* temp11 temp12))
				)
				(3
					(= temp11 (- temp3 temp6))
					(= temp12 (- temp9 temp0))
					(= temp13 (* temp11 temp12))
				)
				(4
					(= temp11 (- temp7 temp2))
					(= temp12 (- temp9 temp0))
					(= temp13 (* temp11 temp12))
				)
				(5
					(= temp11 (- temp3 temp6))
					(= temp12 (- temp1 temp0))
					(= temp13 (* temp11 temp12))
				)
				(6
					(= temp11 (- temp7 temp2))
					(= temp12 (- temp1 temp8))
					(= temp13 (* temp11 temp12))
				)
				(7
					(= temp11 (- temp3 temp2))
					(= temp12 (- temp1 temp0))
					(= temp13 (* temp11 temp12))
				)
				(8
					(= temp11 (- temp3 temp2))
					(= temp12 (- temp1 temp8))
					(= temp13 (* temp11 temp12))
				)
				(9
					(= temp11 (- temp3 temp2))
					(= temp12 (- temp9 temp0))
					(= temp13 (* temp11 temp12))
				)
			)
			(if temp10
				(onTop add: temp13 param1 param2 param3)
			)
		)
	)
)

(procedure (localproc_6)
	(highScoreWindow init:)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((param2 casts:) at: 0))
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

(instance bowling of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(DisableCursor)
		(if global921
			(= global896 0)
			(= global916 1)
		)
		(if (and (== gPrevRoomNum 975) (not global527)) ; chooseGame
			(gSound2 play: 804)
		)
		(= local9 0)
		(= gCardGameScriptNumber 6020)
		(= local10 0)
		(gChar1 active: 1)
		(gChar2 active: 0)
		(gChar3 active: 0)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(gTheKeyMouseList release:)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		((= global929 bowling_opt) doit:)
		(= picture (+ global877 global385))
		(= local44 global385)
		(super init:)
		(gChar1 view: 0 active: 1 setLoop: 2)
		(if global921
			((gChar1 face:) view: 0 loop: 4 cel: 0)
			(gChar1 x: -50 y: -50)
		else
			((gChar1 face:) view: 0)
			(gChar1 posn: -50 -50)
		)
		(if global921
			(gChar1 view: 0 loop: 4 cel: 0)
		)
		(gChar1 show: init:)
		(Characters init:)
		(= global394 0)
		(= global265 0)
		(hand1 add: owner: 0)
		(hand2 add: owner: 0)
		(hand3 add: owner: 0)
		(hand4 add: owner: 0)
		(hand5 add: owner: 0)
		(hand6 add: owner: 0)
		(hand7 add: owner: 0)
		(hand8 add: owner: 0)
		(hand9 add: owner: 0)
		(hand10 add: owner: 0)
		((= gTheFoundations theFoundations) add: ball1 ball2)
		((= gTheHands theHands)
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				ball1
				ball2
		)
		(= global876 0)
		((ScriptID 990 0) init: 980 3 gCurRoomNum) ; chooseBowler
		(= local21 global876)
		(if (> global876 global186)
			(= global186 global876)
		)
		(= global876 0)
		(player1List
			add:
				frame1
				frame2
				frame3
				frame4
				frame5
				frame6
				frame7
				frame8
				frame9
				frame10
		)
		(switch local21
			(1
				(playersList add: player1List)
				(localproc_3 1 0)
			)
			(2
				(player2List
					add:
						twoframe1
						twoframe2
						twoframe3
						twoframe4
						twoframe5
						twoframe6
						twoframe7
						twoframe8
						twoframe9
						twoframe10
				)
				(playersList add: player1List player2List)
				(localproc_3 2 0)
			)
			(3
				(player2List
					add:
						twoframe1
						twoframe2
						twoframe3
						twoframe4
						twoframe5
						twoframe6
						twoframe7
						twoframe8
						twoframe9
						twoframe10
				)
				(player3List
					add:
						threeframe1
						threeframe2
						threeframe3
						threeframe4
						threeframe5
						threeframe6
						threeframe7
						threeframe8
						threeframe9
						threeframe10
				)
				(playersList add: player1List player2List player3List)
				(localproc_3 3 0)
			)
			(4
				(player2List
					add:
						twoframe1
						twoframe2
						twoframe3
						twoframe4
						twoframe5
						twoframe6
						twoframe7
						twoframe8
						twoframe9
						twoframe10
				)
				(player3List
					add:
						threeframe1
						threeframe2
						threeframe3
						threeframe4
						threeframe5
						threeframe6
						threeframe7
						threeframe8
						threeframe9
						threeframe10
				)
				(player4List
					add:
						fourframe1
						fourframe2
						fourframe3
						fourframe4
						fourframe5
						fourframe6
						fourframe7
						fourframe8
						fourframe9
						fourframe10
				)
				(playersList
					add: player1List player2List player3List player4List
				)
				(localproc_3 4 0)
			)
		)
		(hand1 emptyView: hand1Empty)
		(hand1Empty setPri: 1 init: show:)
		(hand2 emptyView: hand2Empty)
		(hand2Empty setPri: 1 init: show:)
		(hand3 emptyView: hand3Empty)
		(hand3Empty setPri: 1 init: show:)
		(hand4 emptyView: hand4Empty)
		(hand4Empty setPri: 1 init: show:)
		(hand5 emptyView: hand5Empty)
		(hand5Empty setPri: 1 init: show:)
		(hand6 emptyView: hand6Empty)
		(hand6Empty setPri: 1 init: show:)
		(hand7 emptyView: hand7Empty)
		(hand7Empty setPri: 1 init: show:)
		(hand8 emptyView: hand8Empty)
		(hand8Empty setPri: 1 init: show:)
		(hand9 emptyView: hand9Empty)
		(hand9Empty setPri: 1 init: show:)
		(hand10 emptyView: hand10Empty)
		(hand10Empty setPri: 1 init: show:)
		(ball1 emptyView: ball1Empty)
		(ball1Empty setPri: 1 init: show:)
		(ball2 emptyView: ball2Empty)
		(ball2Empty setPri: 1 init: show:)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: flip1)
		(global929 doit: 3)
		(= local8 1)
		(= local5 0)
		(IconBarF init:)
		(if (not global115)
			(if (== gPrevRoomNum 6029) ; cardflick
				(= global238 global278)
				(= global239 global279)
				(= global240 global280)
				(= global241 global281)
				(= global234 global274)
				(= global235 global275)
				(= global236 global276)
				(= global237 global277)
				(= global230 global270)
				(= global231 global271)
				(= global232 global272)
				(= global233 global273)
			else
				(= global238 0)
				(= global239 0)
				(= global240 0)
				(= global241 0)
				(= global234 0)
				(= global235 0)
				(= global236 0)
				(= global237 0)
				(= global230 0)
				(= global231 0)
				(= global232 0)
				(= global233 0)
			)
		else
			(= global115 0)
		)
		(gameName init: setPri: 35)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 50 global878))
		)
		(cond
			((> 38 global878 30)
				(gSong setLoop: -1)
			)
			((not local10)
				(gSong setLoop: 1)
			)
		)
		(localproc_6)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
				local43
			)
			(event claimed: 1)
			(= local43 0)
			(tabView hide:)
		)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
			)
			(event claimed: 1)
			(tabView init: show:)
			(UpdateScreenItem tabView)
		)
		(super handleEvent: event)
		(if (handleEventList handleEvent: event)
			(event claimed: 1)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose &tmp temp0)
		(= local9 0)
		(= global419 0)
		(= global418 0)
		(gDelayCast release:)
		(= global458 0)
		(IconBarF dispose:)
		((KeyMouse objList:) release:)
		(flipButton view: 915)
		(gTheFoundations
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(gTheHands
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(flip1 release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local43
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theFoundations dispose:)
		(theHands dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(hand8Empty dispose:)
		(hand9Empty dispose:)
		(hand10Empty dispose:)
		(ball1Empty dispose:)
		(ball2Empty dispose:)
		(if (not local41)
			(bowlingScoreWindow dispose:)
		)
		(highScoreWindow dispose:)
		(handleEventList release: dispose:)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 990)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance bowling_opt of File
	(properties
		name {bowling.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0 format: {%d%d%3d} local10 global927 local38)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp1 (Str new:))
				(self readString: temp1 2)
				(= local10 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 4)
				(= local38 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local10 0)
				(= global927 0)
				(= local38 0)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 4])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local38 0)
			(= local39 0)
			(global929 doit: 3)
			(localproc_7 {high} highScoreWindow)
			(proc6022_6 local38 73 11 1 {high} highScoreWindow)
		)
		(if (!= global385 local44)
			(localproc_7 {back} highScoreWindow)
			(proc0_10 990 5 global385 0 0 1 highScoreWindow {back})
			(= local44 global385)
		)
		(if (and local9 (== state 5) (not global458))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(for
							((= temp0 0))
							(< temp0 (gTheHands size:))
							((++ temp0))
							
							(magList add: (gTheHands at: temp0))
						)
						(magList add: flip1)
						(= local1 1)
					)
					(for ((= temp0 0)) (< temp0 (magList size:)) ((++ temp0))
						(for
							((= temp1 (- ((magList at: temp0) size:) 1)))
							(> temp1 -1)
							((-- temp1))
							
							(= temp4 ((magList at: temp0) at: temp1))
							(if
								(and
									(temp4 faceUp:)
									(< (temp4 x:) gMouseX (+ (temp4 x:) 54))
									(< (temp4 y:) gMouseY (+ (temp4 y:) 77))
								)
								(magView
									init: (temp4 suit:) (- (temp4 rank:) 1)
								)
								(magView setPri: 100 show:)
								(= local0 1)
								(break)
							else
								(magView hide:)
							)
						)
						(if local0
							(= local0 0)
							(break)
						)
					)
				)
				(local1
					(UnLoad 128 985)
					(= local1 0)
					(magList release: dispose:)
					(magView hide:)
				)
			)
			(if (and (== (ball1 cardLimit:) (ball1 size:)) (not local36))
				(for ((= temp2 0)) (< temp2 (Deck size:)) ((++ temp2))
					(if ((Deck at: temp2) whenPlayed:)
						(((Deck at: temp2) whenPlayed:) release:)
						(((Deck at: temp2) whenPlayed:) dispose:)
					)
					(if ((Deck at: temp2) previousHand:)
						(((Deck at: temp2) previousHand:) release:)
						(((Deck at: temp2) previousHand:) dispose:)
					)
					(if ((Deck at: temp2) tailList:)
						(((Deck at: temp2) tailList:) release:)
					)
					((Deck at: temp2) tailList: 0)
					((Deck at: temp2) whenPlayed: 0)
					((Deck at: temp2) previousHand: 0)
				)
				(= global225 0)
				(= local36 1)
			)
			(if (and (== (ball2 cardLimit:) (ball2 size:)) (not local37))
				(for ((= temp2 0)) (< temp2 (Deck size:)) ((++ temp2))
					(if ((Deck at: temp2) whenPlayed:)
						(((Deck at: temp2) whenPlayed:) release:)
						(((Deck at: temp2) whenPlayed:) dispose:)
					)
					(if ((Deck at: temp2) previousHand:)
						(((Deck at: temp2) previousHand:) release:)
						(((Deck at: temp2) previousHand:) dispose:)
					)
					(if ((Deck at: temp2) tailList:)
						(((Deck at: temp2) tailList:) release:)
					)
					((Deck at: temp2) tailList: 0)
					((Deck at: temp2) whenPlayed: 0)
					((Deck at: temp2) previousHand: 0)
				)
				(= global225 0)
				(= local37 1)
			)
			(if (and local27 local40 (not global458))
				(endCode doit:)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local9 0)
				(= ticks (= ticks 1))
			)
			(1
				(= global440 0)
				(= global441 0)
				(= local46 0)
				(= local47 0)
				(= local48 0)
				(= local49 0)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(= global524 0)
				(IconBar show:)
			)
			(3
				(if local41
					(= local41 0)
				)
				(if global524
					(= local40 0)
					(= local27 0)
					(= local42 0)
					(= global524 0)
					(= local21 local45)
					(localproc_3 local21 0)
				)
				(gTheIconBar enable:)
				(= ticks 8)
			)
			(4
				(Deck shuffle:)
				(= local9 0)
				(= local8 0)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= local5 0)
				(= global226 1)
				(= global395 0)
				(= local2 0)
				(= global243 0)
				(= local12 1)
				(= cycles 1)
			)
			(5
				(if (== global927 1)
					(ball1 cardLimit: 2)
					(ball2 cardLimit: 2)
				else
					(ball1 cardLimit: 3)
					(ball2 cardLimit: 3)
				)
				(= local9 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(flipButton setPri: 1 init: hide:)
				(= local6 0)
				(hand1Empty setPri: 1 init: show:)
				(hand2Empty setPri: 1 init: show:)
				(hand3Empty setPri: 1 init: show:)
				(hand4Empty setPri: 1 init: show:)
				(hand5Empty setPri: 1 init: show:)
				(hand6Empty setPri: 1 init: show:)
				(hand7Empty setPri: 1 init: show:)
				(hand8Empty setPri: 1 init: show:)
				(hand9Empty setPri: 1 init: show:)
				(hand10Empty setPri: 1 init: show:)
				(ball1Empty setPri: 1 init: show:)
				(ball2Empty setPri: 1 init: show:)
				(handleEventList
					add:
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
						hand8
						hand9
						hand10
						ball1
						ball2
				)
				(global419 init: client: flip1 active: 1 size: 52 addKeyMouse:)
				(handleEventList add: global419)
				(handleEventList add: flip1)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= local36 0)
				(= local37 0)
				(= global225 0)
				(= global226 0)
				(= local5 1)
				(= local39 local38)
			)
		)
	)
)

(instance cleanUp of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
			(if ((Deck at: temp0) whenPlayed:)
				(((Deck at: temp0) whenPlayed:) release:)
				(((Deck at: temp0) whenPlayed:) dispose:)
			)
			(if ((Deck at: temp0) previousHand:)
				(((Deck at: temp0) previousHand:) release:)
				(((Deck at: temp0) previousHand:) dispose:)
			)
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(= local6 0)
		(gTheHands eachElementDo: #endHand)
		(flip1 endHand:)
		(flip1 release:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(flipButton view: 915)
		(flipButton dispose:)
		(proc0_9 (gCast elements:) 0)
		(= local14 0)
		(= local15 0)
		(= local12 1)
		(if local23
			(switch local22
				(1
					(= local17 local16)
				)
				(2
					(= local18 local16)
				)
				(3
					(= local19 local16)
				)
				(4
					(= local20 local16)
				)
			)
			(cond
				((> local21 1)
					(if
						(or
							(!= local13 9)
							(((playersList at: (- local22 1)) at: 9) done:)
						)
						(if (== local22 local21)
							(= local22 1)
							(if (!= local13 9)
								(++ local13)
							)
						else
							(++ local22)
						)
					)
				)
				((!= local13 9)
					(++ local13)
				)
			)
			(if (and (not local16) (== local13 9))
				(= local17 1)
				(= local18 1)
				(= local19 1)
				(= local20 1)
			)
		else
			(playersList release: dispose:)
			(= local13 0)
			(= local16 0)
			(= local17 0)
			(= local18 0)
			(= local19 0)
			(= local20 0)
			(= local22 1)
			(= local24 0)
			(= local25 0)
			(switch local21
				(1
					(player1List eachElementDo: #init)
					(player1List release: dispose:)
				)
				(2
					(player1List eachElementDo: #init)
					(player2List eachElementDo: #init)
					(player1List release: dispose:)
					(player2List release: dispose:)
				)
				(3
					(player1List eachElementDo: #init)
					(player2List eachElementDo: #init)
					(player3List eachElementDo: #init)
					(player1List release: dispose:)
					(player2List release: dispose:)
					(player3List release: dispose:)
				)
				(4
					(player1List eachElementDo: #init)
					(player2List eachElementDo: #init)
					(player3List eachElementDo: #init)
					(player4List eachElementDo: #init)
					(player1List release: dispose:)
					(player2List release: dispose:)
					(player3List release: dispose:)
					(player4List release: dispose:)
				)
			)
			(bowlingScoreWindow dispose:)
			(if (not local40)
				((ScriptID 990 0) init: 980 3 gCurRoomNum) ; chooseBowler
			)
			(= local45 local21)
			(= local21 global876)
			(if (> global876 global186)
				(= global186 global876)
			)
			(= global876 0)
			(if local40
				(= local21 local45)
			)
			(switch local21
				(1
					(player1List
						add:
							frame1
							frame2
							frame3
							frame4
							frame5
							frame6
							frame7
							frame8
							frame9
							frame10
					)
					(playersList add: player1List)
					(if (not local40)
						(localproc_3 1 0)
					)
				)
				(2
					(player1List
						add:
							frame1
							frame2
							frame3
							frame4
							frame5
							frame6
							frame7
							frame8
							frame9
							frame10
					)
					(player2List
						add:
							twoframe1
							twoframe2
							twoframe3
							twoframe4
							twoframe5
							twoframe6
							twoframe7
							twoframe8
							twoframe9
							twoframe10
					)
					(playersList add: player1List player2List)
					(if (not local40)
						(localproc_3 2 0)
					)
				)
				(3
					(player1List
						add:
							frame1
							frame2
							frame3
							frame4
							frame5
							frame6
							frame7
							frame8
							frame9
							frame10
					)
					(player2List
						add:
							twoframe1
							twoframe2
							twoframe3
							twoframe4
							twoframe5
							twoframe6
							twoframe7
							twoframe8
							twoframe9
							twoframe10
					)
					(player3List
						add:
							threeframe1
							threeframe2
							threeframe3
							threeframe4
							threeframe5
							threeframe6
							threeframe7
							threeframe8
							threeframe9
							threeframe10
					)
					(playersList add: player1List player2List player3List)
					(if (not local40)
						(localproc_3 3 0)
					)
				)
				(4
					(player1List
						add:
							frame1
							frame2
							frame3
							frame4
							frame5
							frame6
							frame7
							frame8
							frame9
							frame10
					)
					(player2List
						add:
							twoframe1
							twoframe2
							twoframe3
							twoframe4
							twoframe5
							twoframe6
							twoframe7
							twoframe8
							twoframe9
							twoframe10
					)
					(player3List
						add:
							threeframe1
							threeframe2
							threeframe3
							threeframe4
							threeframe5
							threeframe6
							threeframe7
							threeframe8
							threeframe9
							threeframe10
					)
					(player4List
						add:
							fourframe1
							fourframe2
							fourframe3
							fourframe4
							fourframe5
							fourframe6
							fourframe7
							fourframe8
							fourframe9
							fourframe10
					)
					(playersList
						add: player1List player2List player3List player4List
					)
					(if (not local40)
						(localproc_3 4 0)
					)
				)
			)
		)
		(= local23 0)
		(theHands release:)
		(theHands
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				ball1
				ball2
		)
		(= global928 0)
		(if global265
			(if local27
				(localproc_4)
			)
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if local41
			(= local40 0)
			(= local27 0)
		)
		(if (not local42)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if global458
			(global458 hide:)
		)
		(= local42 1)
		(= local41 1)
		(if (not global497)
			(++ global221)
			(= global497 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(proc6020_1 1)
		(= local46 0)
		(= local47 0)
		(= local48 0)
		(= local49 0)
		(DisableCursor)
		((ScriptID 6096 2) init:) ; aBanner
		(gSound2 play: 3000)
		((ScriptID 6096 2) setScript: (ScriptID 6096 1)) ; aBanner, sBannerOut
	)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 484)
		(= y 48)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local6 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
				)
			)
			((< 4 size 9)
				(= local6 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
				)
			)
			((< 0 size 5)
				(handleEventList delete: flipButton)
				(handleEventList add: global419)
				(= local6 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(handleEventList delete: global419)
				(handleEventList addToEnd: flipButton)
				(flipButton show:)
				(= local6 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local6 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
				)
			)
		)
	)

	(method (getCard)
		(DisableCursor)
		(if (not (flip1 size:))
			(if size
				(-= size 1)
				(if (< size 0)
					(= size 0)
				)
				((ScriptID 15 6) ; littleCard
					view: (+ 54 global384)
					posn: (+ x 18) (+ y 22)
					init:
				)
				(self adjust:)
				(= global395 1)
				((ScriptID 15 6) hide: setMotion: MoveTo 405 62 self) ; littleCard
				(= global116 0)
			else
				(EnableCursor)
			)
		else
			(EnableCursor)
		)
	)

	(method (cue)
		(self setScript: stockScript)
	)
)

(instance flipButton of TrackingView
	(properties
		x 405
		y 62
		priority 1
		view 915
		loop 12
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local23 1)
			(cleanUp doit:)
		)
	)
)

(instance resignButton of TrackingView
	(properties
		x 596
		y 346
		view 915
		loop 10
	)

	(method (handleEvent event)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(= local41 1)
				(if local43
					(= local43 0)
					(tabView hide:)
				)
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6020_1 1)
				(IconBarF lighten:)
				(cleanUp doit:)
			)
		)
	)
)

(instance undoButton of TrackingView
	(properties
		x 4
		y 346
		view 915
		loop 14
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			(if (== global225 0)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText: {Unable to undo last move.} 10 10
					init:
				)
			else
				(= global226 1)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) whenPlayed:)
							(==
								(((Deck at: temp0) whenPlayed:)
									at:
										(-
											(((Deck at: temp0) whenPlayed:)
												size:
											)
											1
										)
								)
								global225
							)
						)
						(= temp3 (Deck at: temp0))
						(if
							(==
								((temp3 previousHand:)
									at: (- ((temp3 previousHand:) size:) 1)
								)
								2
							)
							(temp3 fromStock: 0)
							((temp3 owner:) eliminateCard: temp3)
							(temp3 hide:)
							(temp3 inPlay: 0)
							(if (> ((temp3 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp3 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
							else
								((temp3 previousHand:)
									delete:
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
								)
							)
							(if (< (theStock size:) 1)
								(handleEventList add: global419)
								((ScriptID 15 7) show:) ; stockBack
							)
							(resetStock doit:)
						else
							(if
								(and
									(==
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
										flip1
									)
									(== ((temp3 owner:) whatType:) 0)
									(== ((temp3 owner:) size:) 1)
								)
								(switch local22
									(1
										(= temp5 (playersList at: 0))
									)
									(2
										(= temp5 (playersList at: 1))
									)
									(3
										(= temp5 (playersList at: 2))
									)
									(4
										(= temp5 (playersList at: 3))
									)
								)
								(= temp4 (temp5 at: local13))
								(if (== local12 1)
									(temp4 b1Score: (-- local14))
								else
									(temp4 b2Score: (-- local15))
								)
							)
							((temp3 owner:) eliminateCard: temp3)
							(temp3 inPlay: 1)
							(((temp3 previousHand:)
									at: (- ((temp3 previousHand:) size:) 1)
								)
								add: temp3
							)
							(if (> ((temp3 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp3 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
							else
								((temp3 previousHand:)
									delete:
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
								)
							)
						)
						(break)
					)
				)
				(= global226 0)
			)
		)
	)
)

(instance stockScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= temp0 (getOne doit:))
				(= global395 0)
				(= cycles 1)
			)
			(2
				(EnableCursor)
			)
		)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local3 (Deck topCard:))
		(= local4 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance getOne of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(temp0 fromStock: 1)
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
	)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local9))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 6005 15 128 0 (Random 1 2))
				else
					(gChar1 say: 6005 15 128 0 2)
				)
			else
				(= local8 0)
				(cleanUp doit:)
			)
			(return 1)
		)
		(return
			(if (and local6 (> (theStock size:) 0))
				(= local6 0)
				(theStock adjust:)
			)
		)
	)
)

(class bowlHand of sHand
	(properties)

	(method (legalPlay param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= local11 (param1 rank:))
		(= temp7 0)
		(= temp6 0)
		(= temp3 0)
		(for ((= temp2 0)) (< temp2 (gTheHands size:)) ((++ temp2))
			(if (== (param1 owner:) (gTheHands at: temp2))
			else
				(= temp5 (gTheHands at: temp2))
				(= temp0 (temp5 lastCrd:))
				(localproc_5 temp0 param1 temp2)
			)
		)
		(if (onTop size:)
			(= temp7 1)
			(for ((= temp2 0)) (< temp2 (onTop size:)) ((+= temp2 4))
				(if
					(or
						(> (onTop at: temp2) temp6)
						(and (== (onTop size:) 4) (not temp6))
					)
					(= temp6 (onTop at: temp2))
					(= temp0 (onTop at: (+ temp2 1)))
					(= param1 (onTop at: (+ temp2 2)))
					(= temp3 (onTop at: (+ temp2 3)))
				)
			)
			(= temp5 (gTheHands at: temp3))
			(= temp4 (temp5 size:))
			(onTop release:)
		)
		(if
			(and
				temp7
				(or
					(== ((gTheHands at: temp3) whatType:) 1)
					(< temp4 ((gTheHands at: temp3) cardLimit:))
				)
				(localproc_1 temp3)
			)
			(cond
				((and temp4 (== (temp5 whatType:) 0) (== local11 (temp0 rank:)))
					((gTheHands at: temp3) add: param1)
					(gSound play: 907)
					(return 1)
				)
				((and temp4 (== (temp5 whatType:) 0))
					(return 0)
				)
				(else
					((gTheHands at: temp3) add: param1)
					(gSound play: 907)
					(localproc_2 (gTheHands at: temp3))
					(return 1)
				)
			)
		)
		(return 0)
	)
)

(instance hand1 of sHand
	(properties
		x 200
		y 270
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand1Empty of View
	(properties
		x 200
		y 270
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 165
		y 186
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 165
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand2Empty of View
	(properties
		x 165
		y 186
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 235
		y 186
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 235
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand3Empty of View
	(properties
		x 235
		y 186
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 131
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 131
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand4Empty of View
	(properties
		x 131
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 201
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 201
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand5Empty of View
	(properties
		x 201
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 271
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 271
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand6Empty of View
	(properties
		x 271
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 98
		y 19
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 98
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand7Empty of View
	(properties
		x 98
		y 19
		priority 1
		view 915
		loop 8
	)
)

(instance hand8 of sHand
	(properties
		x 168
		y 19
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 168
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand8Empty of View
	(properties
		x 168
		y 19
		priority 1
		view 915
		loop 8
	)
)

(instance hand9 of sHand
	(properties
		x 238
		y 19
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 238
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand9Empty of View
	(properties
		x 238
		y 19
		priority 1
		view 915
		loop 8
	)
)

(instance hand10 of sHand
	(properties
		x 308
		y 19
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 308
		cardShow 1
		cardLimit 4
		startRank 3
		whereTo 2
	)
)

(instance hand10Empty of View
	(properties
		x 308
		y 19
		priority 1
		view 915
		loop 8
	)
)

(instance flip1 of bowlHand
	(properties
		x 405
		y 62
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 405
		whatType 2
		cardShow 1
		cardLimit 1
		canPlay 1
	)

	(method (add param1)
		(super add: param1 &rest)
		(param1 flip: 1 show: init:)
	)
)

(instance ball1 of sHand
	(properties
		x 41
		y 135
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 41
		whatType 1
		cardLimit 3
		buildOrder 10
		startRank 3
		whereTo 2
	)

	(method (add param1)
		(super add: param1 &rest)
		(localproc_2 self)
		(= global928 0)
	)
)

(instance ball1Empty of View
	(properties
		x 41
		y 135
		priority 1
		view 915
		loop 8
	)
)

(instance ball2 of sHand
	(properties
		x 41
		y 243
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 41
		whatType 1
		cardLimit 3
		buildOrder 10
		startRank 3
		whereTo 2
	)

	(method (add param1)
		(super add: param1 &rest)
		(localproc_2 self)
		(= global928 0)
	)
)

(instance ball2Empty of View
	(properties
		x 41
		y 243
		priority 1
		view 915
		loop 8
	)
)

(class Frame of Obj
	(properties
		b1Score 0
		b2Score 0
		strike 0
		spare 0
		bscore 0
		done 0
	)

	(method (init)
		(= done (= bscore (= spare (= strike (= b2Score (= b1Score 0))))))
	)
)

(instance frame1 of Frame
	(properties)
)

(instance frame2 of Frame
	(properties)
)

(instance frame3 of Frame
	(properties)
)

(instance frame4 of Frame
	(properties)
)

(instance frame5 of Frame
	(properties)
)

(instance frame6 of Frame
	(properties)
)

(instance frame7 of Frame
	(properties)
)

(instance frame8 of Frame
	(properties)
)

(instance frame9 of Frame
	(properties)
)

(instance frame10 of Frame
	(properties)
)

(instance twoframe1 of Frame
	(properties)
)

(instance twoframe2 of Frame
	(properties)
)

(instance twoframe3 of Frame
	(properties)
)

(instance twoframe4 of Frame
	(properties)
)

(instance twoframe5 of Frame
	(properties)
)

(instance twoframe6 of Frame
	(properties)
)

(instance twoframe7 of Frame
	(properties)
)

(instance twoframe8 of Frame
	(properties)
)

(instance twoframe9 of Frame
	(properties)
)

(instance twoframe10 of Frame
	(properties)
)

(instance threeframe1 of Frame
	(properties)
)

(instance threeframe2 of Frame
	(properties)
)

(instance threeframe3 of Frame
	(properties)
)

(instance threeframe4 of Frame
	(properties)
)

(instance threeframe5 of Frame
	(properties)
)

(instance threeframe6 of Frame
	(properties)
)

(instance threeframe7 of Frame
	(properties)
)

(instance threeframe8 of Frame
	(properties)
)

(instance threeframe9 of Frame
	(properties)
)

(instance threeframe10 of Frame
	(properties)
)

(instance fourframe1 of Frame
	(properties)
)

(instance fourframe2 of Frame
	(properties)
)

(instance fourframe3 of Frame
	(properties)
)

(instance fourframe4 of Frame
	(properties)
)

(instance fourframe5 of Frame
	(properties)
)

(instance fourframe6 of Frame
	(properties)
)

(instance fourframe7 of Frame
	(properties)
)

(instance fourframe8 of Frame
	(properties)
)

(instance fourframe9 of Frame
	(properties)
)

(instance fourframe10 of Frame
	(properties)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance magList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance playersList of List
	(properties)
)

(instance player1List of List
	(properties)
)

(instance player2List of List
	(properties)
)

(instance player3List of List
	(properties)
)

(instance player4List of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance bowlingScoreWindow of InvisibleWindow
	(properties
		left 355
		top 200
		right 613
		bottom 341
	)

	(method (init param1 &tmp [temp0 2])
		(= bottom param1)
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 980 1 0 0 0 15 self)
		(switch param1
			(275
				(proc0_10 980 2 0 0 30 15 self)
			)
			(305
				(proc0_10 980 2 0 0 30 15 self)
				(proc0_10 980 3 0 0 60 15 self)
			)
			(335
				(proc0_10 980 2 0 0 30 15 self)
				(proc0_10 980 3 0 0 60 15 self)
				(proc0_10 980 4 0 0 90 15 self)
			)
		)
	)
)

(instance magView of View
	(properties)

	(method (init param1 param2)
		(= view 985)
		(= loop param1)
		(= cel param2)
		(= x 99)
		(= y 448)
		(super init: &rest)
	)
)

(instance gameName of View
	(properties
		x 220
		y 446
		priority 35
		view 977
		loop 3
	)
)

(instance onTop of List
	(properties)
)

(instance highScoreWindow of InvisibleWindow
	(properties
		left 421
		top 446
		right 577
		bottom 477
	)

	(method (init &tmp [temp0 2])
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 3 0 0 0 5 self)
		(proc6022_6 local38 73 11 1 {high} highScoreWindow)
	)
)

(instance tabView of View
	(properties
		view 713
	)

	(method (init)
		(self setPri: 255)
		(= local43 1)
		(super init: &rest)
	)
)

