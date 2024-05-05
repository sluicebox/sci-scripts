;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use System)

(public
	FindStreetName 0
)

(local
	[streetNames 50] = [0 {Khanjar Tarik} {Marrib Darb} {Kasir Tarik} {Tarik of Kattas} {Sharki Darb} {Junub Tarik} {Rani Tarik} {Tarik of Stars} {Kital Darb} {Dambi Darb} {Naufara Darb} {Dinar Tarik} {Centime Tarik} {Mwai Tarik} {Harik Darb} {Wahir Darb} {Dahab Tarik} {Sultan Darb} {Effendi Darb} {Sahib Tarik} {Saif Darb} {Askeri Darb} {Tarik of Rafir} {Shmali Tarik} {Jamal Darb} {Hawa Darb} {Nisr Darb} {Trab Darb} {Khalsa Darb} {Zrir Darb} {Akrab Darb} {Kudra Darb} {Sahir Tarik} {Rules must be obeyed.__Follow the system} {An order from a guard is a rule} {Ignorance of the law is no excuse} {Suicide is punishable by death} {Red Sauruses may be watered on Tuesdays and Thursdays; Green Sauruses may be watered every other Wednesday} {Some men are more equal than others} {Everything not mandatory is forbidden} {All men are equal} {Women shall remain indoors and veiled at all times} {It is forbidden to be on the streets at night} {You must carry your Visa at all times} {You are being watched} {Overtime is mandatory for everyone} {This street closed by order of Khaveen} {The smuggling of water is a capital crime} {All Fed-Ex packages must by out by 2:30}]
)

(procedure (FindStreetName index)
	(return [streetNames index])
)

(class Alley of Obj
	(properties
		streetIndex 0
		topX 0
		botX 0
		topY 0
		botY 0
		topType 0
		botType 0
		topLoc 0
		botLoc 0
		atLoc 0
		atType 0
	)

	(method (at x y &tmp ones theWord)
		(cond
			((and (== x topX) (== y topY))
				(= atType topType)
			)
			((and (== x botX) (== y botY))
				(= atType botType)
			)
			(else
				(= atType 0)
			)
		)
		(if
			(and
				(not (and (>= x (- topX 1)) (>= y (- topY 1))))
				(not (and (<= x (+ botX 1)) (<= y (+ botY 1))))
			)
			(= ones (mod (+ x y) 10))
			(cond
				((OneOf ones 1 4 7)
					(|= atType $0401)
				)
				((OneOf ones 2 3 9)
					(|= atType $0402)
				)
				((OneOf ones 5 6)
					(|= atType $0403)
				)
			)
		)
		(cond
			((OneOf ones 4 7)
				(|= atType $0008)
			)
			((OneOf ones 3 9)
				(|= atType $0004)
			)
		)
		(= atLoc 0)
		(cond
			((and (== x topX) (== y topY))
				(= atLoc topLoc)
			)
			((and (== x botX) (== y botY))
				(= atLoc botLoc)
			)
		)
		(return atType)
	)

	(method (streetName)
		(FindStreetName streetIndex)
	)
)

