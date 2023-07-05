;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6110)
(include sci.sh)
(use Main)
(use Location)
(use KeyPadButn)
(use Sound)
(use Actor)

(public
	securityKeypad 0
)

(local
	[local0 12] = [2 2947 3 70 4 3842 5 1139 7 1231 -1 -1]
	local12
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp1 0)) (!= temp0 -1) ((+= temp1 2)) ; UNINIT
		(= temp0 [local0 temp1])
		(if (== [local0 (+ temp1 1)] global242)
			(break)
		)
	)
	(if (== temp0 -1)
		(return 1)
	else
		(return temp0)
	)
)

(instance securityKeypad of CloseupLocation
	(properties)

	(method (init)
		(super init: 6133)
		(self edgeE: 0)
		(self edgeW: 0)
		(Load rsAUDIO 6102)
		(if (== global233 2)
			(screenTrail init: global117)
		)
		(key1 init: global117)
		(key2 init: global117)
		(key3 init: global117)
		(key4 init: global117)
		(key5 init: global117)
		(key6 init: global117)
		(key7 init: global117)
		(key8 init: global117)
		(key9 init: global117)
		(key10 init: global117)
		(key11 init: global117)
		(key12 init: global117)
		(key13 init: global117)
		(key14 init: global117)
		(key15 init: global117)
		(key0 init: global117)
	)

	(method (newRoom)
		(if (== global233 2)
			(= global234 (localproc_0))
		)
		(super newRoom: &rest)
	)
)

(class SecurityKeyPadButn of KeyPadButn
	(properties
		view 6133
		downLoop 1
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (== global233 2)
					(if (not local12)
						(= global242 0)
					)
					(= global242
						(&
							(= global242 (| (<<= global242 $0004) myValue))
							$0fff
						)
					)
					(if (>= (++ local12) 3)
						(gCurRoom newRoom: 6104) ; avianSecurity4
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance key1 of SecurityKeyPadButn
	(properties
		x 291
		y 76
		myValue 1
	)
)

(instance key2 of SecurityKeyPadButn
	(properties
		x 352
		y 76
		cel 1
		myValue 2
	)
)

(instance key3 of SecurityKeyPadButn
	(properties
		x 414
		y 76
		cel 2
		myValue 3
	)
)

(instance key4 of SecurityKeyPadButn
	(properties
		x 475
		y 76
		cel 3
		myValue 4
	)
)

(instance key5 of SecurityKeyPadButn
	(properties
		x 291
		y 142
		cel 4
		myValue 5
	)
)

(instance key6 of SecurityKeyPadButn
	(properties
		x 351
		y 142
		cel 5
		myValue 6
	)
)

(instance key7 of SecurityKeyPadButn
	(properties
		x 414
		y 142
		cel 6
		myValue 7
	)
)

(instance key8 of SecurityKeyPadButn
	(properties
		x 475
		y 142
		cel 7
		myValue 8
	)
)

(instance key9 of SecurityKeyPadButn
	(properties
		x 291
		y 210
		cel 8
		myValue 9
	)
)

(instance key10 of SecurityKeyPadButn
	(properties
		x 351
		y 210
		cel 9
		myValue 10
	)
)

(instance key11 of SecurityKeyPadButn
	(properties
		x 414
		y 210
		cel 10
		myValue 11
	)
)

(instance key12 of SecurityKeyPadButn
	(properties
		x 476
		y 210
		cel 11
		myValue 12
	)
)

(instance key13 of SecurityKeyPadButn
	(properties
		x 291
		y 278
		cel 12
		myValue 13
	)
)

(instance key14 of SecurityKeyPadButn
	(properties
		x 351
		y 278
		cel 13
		myValue 14
	)
)

(instance key15 of SecurityKeyPadButn
	(properties
		x 414
		y 278
		cel 14
		myValue 15
	)
)

(instance key0 of SecurityKeyPadButn
	(properties
		x 476
		y 278
		cel 15
	)
)

(instance screenTrail of View
	(properties
		x -1
		y 183
		view 6133
		loop 2
	)
)

(instance controlSound of Sound ; UNUSED
	(properties
		flags 5
		number 6102
	)
)

