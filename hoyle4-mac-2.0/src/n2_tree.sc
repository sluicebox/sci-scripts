;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 713)
(include sci.sh)
(use Main)
(use n709)
(use Bid)
(use System)

(public
	n2_tree 0
)

(instance n2_tree of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 3] [temp15 5] temp20 temp21 [temp22 6] temp28 temp29 [temp30 3] temp33 [temp34 8] temp42)
		(= temp42 (param1 partner:))
		(= temp2 (param1 points:))
		(= temp3 (param1 hcp:))
		(= temp4 (param1 playingTricks:))
		(= temp5 (param1 quickTricks:))
		(= temp6 (param1 singletons:))
		(= temp7 (param1 voids:))
		(= temp8 (param1 shape:))
		(= temp9 (param1 longSuit:))
		(= temp28 (param1 combinedHCP:))
		(= temp29 (param1 combinedPts:))
		(= temp33 (param1 agreedSuit:))
		(= [temp15 0] 0)
		(= [temp15 2] (param1 diamonds:))
		(= [temp15 1] (param1 clubs:))
		(= [temp15 3] (param1 hearts:))
		(= [temp15 4] (param1 spades:))
		(= temp10 (+ 1 (mod (- param3 1) 5)))
		(= temp11 (+ (/ (- param3 1) 5) 1))
		(= temp20 (+ 1 (mod (- param2 1) 5)))
		(= temp21 (+ (/ (- param2 1) 5) 1))
		(= temp0 0)
		(cond
			((== (BidBox openingBidder:) param1)
				(= temp28 (+ temp3 (temp42 hcp:)))
				(cond
					((not (OneOf param2 20 25))
						(= temp0 0)
					)
					((>= temp28 37)
						(= temp0 35)
					)
					((or (>= temp28 33) (== param2 25))
						(= temp0 30)
					)
					(else
						(= temp0 0)
					)
				)
				(param1 bidTree: 0)
				(temp42 bidTree: 0)
			)
			((>= temp28 37)
				(= temp0 35)
				(proc709_4 param1 15 18 2 5 2 5 2 5 2 5)
			)
			(
				(not
					(or
						(< temp2 5)
						(== temp8 17203)
						(u> temp8 24576)
						(and (< [temp15 3] 4) (< [temp15 4] 4))
						(and
							(>= temp9 3)
							(== [temp15 temp9] 5)
							(>= (param1 calcHonors: temp9 5) 4)
						)
					)
				)
				(= temp0 11)
				(proc709_4 param1 5 14 0 5 0 5 0 6 0 6)
				(param1 bidTree: 721 forcing: 1)
				(temp42 bidTree: 721)
				(= global439 1)
			)
			((and (or (>= temp4 14) (>= temp2 15)) (proc709_1 param1 temp9))
				(if
					(or
						(and
							(== [temp15 temp1] 6)
							(>= (param1 calcHonors: temp1 4) 3) ; UNINIT
						)
						(and
							(>= [temp15 temp1] 7)
							(>= (param1 calcHonors: temp1 3) 2) ; UNINIT
						)
					)
					(= temp0 722)
				else
					(= temp0 30)
				)
			)
			((>= temp28 35)
				(= temp0 25)
				(proc709_4 param1 13 14 0 7 0 7 0 7 0 7)
			)
			((>= temp28 33)
				(= temp0 30)
				(proc709_4 param1 11 14 0 7 0 7 0 7 0 7)
			)
			((>= temp29 34)
				(= temp0 (proc709_0 temp9 6))
			)
			((>= temp28 31)
				(= temp0 20)
				(proc709_4 param1 9 10 0 7 0 7 0 7 0 7)
			)
			((and (u>= temp8 24576) (>= temp9 2) (< temp2 4))
				(= temp0 (proc709_0 temp9 3))
			)
			((>= temp28 26)
				(= temp0 15)
				(proc709_4 param1 3 8 0 7 0 7 0 7 0 7)
			)
			(
				(and
					(>= temp3 2)
					(or
						(>= [temp15 temp9] 7)
						(and
							(>= temp9 3)
							(>= [temp15 temp9] 5)
							(or
								(>= [temp15 temp9] 6)
								(>= (param1 calcHonors: temp9 5) 4)
							)
						)
					)
				)
				(= temp0 (proc709_0 temp9 (param1 findGameLevel: temp9)))
				(switch temp9
					(1
						(proc709_4 param1 2 8 7 11 0 5 0 5 0 5)
					)
					(2
						(proc709_4 param1 2 8 0 5 7 11 0 5 0 5)
					)
					(3
						(proc709_4 param1 2 8 0 5 0 5 6 11 0 5)
					)
					(4
						(proc709_4 param1 2 8 0 5 0 5 0 5 6 11)
					)
				)
			)
			(else
				(= temp0 0)
				(proc709_4 param1 0 3 2 5 2 5 2 4 2 4)
			)
		)
		(return temp0)
	)
)

