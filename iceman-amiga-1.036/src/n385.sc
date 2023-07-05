;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Interface)
(use subMarine_314)

(public
	proc385_0 0
)

(local
	[local0 12]
)

(procedure (proc385_0 param1 param2)
	(localproc_1)
	(if (and (<= param1 ((subMarine script:) state:)) (not [local0 param2]))
		(switch (Random 0 3)
			(0
				(Print 385 0) ; "Commander," the radioman says, "I have a coded message in alpha that just came in from Naval High Command in Washington."
			)
			(1
				(Print 385 1) ; "You have a coded message from Washington."
			)
			(2
				(Print 385 2) ; "The radioman hands you a message from Naval High Command in Washington."
			)
			(3
				(Print 385 3) ; ""There's a message from Washington, Sir." the radioman replies."
			)
		)
		(Print 385 4) ; "The WASHINGTON code keys for this message are:"
		(localproc_2 param2)
		(localproc_4 (+ [local0 param2] 0))
		(localproc_4 (+ [local0 (+ param2 1)] 0))
		(switch (Random 0 3)
			(0
				(Print 385 5) ; "You have a coded message from the CIA."
			)
			(1
				(Print 385 6) ; "Also," he continues, "I'm holding a second coded message from CIA command headquarters."
			)
			(2
				(Print 385 7) ; "The radioman hands you the message from CIA Command."
			)
			(3
				(Print 385 8) ; ""There's a message from the CIA Command, Sir."  the radioman replies."
			)
		)
		(Print 385 9) ; "The CIA code keys are:"
		(localproc_2 (+ param2 2))
		(localproc_4 (+ [local0 (+ param2 2)] 16))
		(localproc_4 (+ [local0 (+ param2 3)] 16))
		(localproc_0)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_0)
	(subMarine
		msg12:
			(^
				(^
					(^ (<< [local0 0] $000c) (<< [local0 1] $0008))
					(<< [local0 2] $0004)
				)
				[local0 3]
			)
	)
	(subMarine
		msg34:
			(^
				(^
					(^ (<< [local0 4] $000c) (<< [local0 5] $0008))
					(<< [local0 6] $0004)
				)
				[local0 7]
			)
	)
	(subMarine
		msg56:
			(^
				(^
					(^ (<< [local0 8] $000c) (<< [local0 9] $0008))
					(<< [local0 10] $0004)
				)
				[local0 11]
			)
	)
)

(procedure (localproc_1)
	(= [local0 0] (>> (subMarine msg12:) $000c))
	(= [local0 1] (& (>> (subMarine msg12:) $0008) $000f))
	(= [local0 2] (& (>> (subMarine msg12:) $0004) $000f))
	(= [local0 3] (& (subMarine msg12:) $000f))
	(= [local0 4] (>> (subMarine msg34:) $000c))
	(= [local0 5] (& (>> (subMarine msg34:) $0008) $000f))
	(= [local0 6] (& (>> (subMarine msg34:) $0004) $000f))
	(= [local0 7] (& (subMarine msg34:) $000f))
	(= [local0 8] (>> (subMarine msg56:) $000c))
	(= [local0 9] (& (>> (subMarine msg56:) $0008) $000f))
	(= [local0 10] (& (>> (subMarine msg56:) $0004) $000f))
	(= [local0 11] (& (subMarine msg56:) $000f))
)

(procedure (localproc_2 param1)
	(= [local0 param1] (localproc_3))
	(= [local0 (+ param1 1)] (localproc_3))
)

(procedure (localproc_3 &tmp temp0 temp1)
	(for
		((= temp0 (Random 1 15)))
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(breakif (== temp0 [local0 temp1]))
		)
		((= temp0 (Random 1 15)))
	)
	(return temp0)
)

(procedure (localproc_4 param1)
	(switch param1
		(1
			(Print 385 10) ; "H-G-E"
		)
		(2
			(Print 385 11) ; "H-H-D"
		)
		(3
			(Print 385 12) ; "H-B-G"
		)
		(4
			(Print 385 13) ; "I-C-H"
		)
		(5
			(Print 385 14) ; "I-I-I"
		)
		(6
			(Print 385 15) ; "J-G-F"
		)
		(7
			(Print 385 16) ; "J-C-D"
		)
		(8
			(Print 385 17) ; "FF-F-C"
		)
		(9
			(Print 385 18) ; "FF-E-H"
		)
		(10
			(Print 385 19) ; "FD-E-E"
		)
		(11
			(Print 385 20) ; "FD-D-B"
		)
		(12
			(Print 385 21) ; "FH-E-D"
		)
		(13
			(Print 385 22) ; "FH-I-C"
		)
		(14
			(Print 385 23) ; "FI-F-D"
		)
		(15
			(Print 385 24) ; "FI-D-B"
		)
		(17
			(Print 385 25) ; "E-A-J"
		)
		(18
			(Print 385 26) ; "E-E-F"
		)
		(19
			(Print 385 27) ; "E-H-A"
		)
		(20
			(Print 385 28) ; "D-G-E"
		)
		(21
			(Print 385 29) ; "D-D-D"
		)
		(22
			(Print 385 30) ; "C-A-B"
		)
		(23
			(Print 385 31) ; "C-G-F"
		)
		(24
			(Print 385 32) ; "BB-B-G"
		)
		(25
			(Print 385 33) ; "BB-J-E"
		)
		(26
			(Print 385 34) ; "BF-J-J"
		)
		(27
			(Print 385 35) ; "BF-F-H"
		)
		(28
			(Print 385 36) ; "BE-J-F"
		)
		(29
			(Print 385 37) ; "BE-D-G"
		)
		(30
			(Print 385 38) ; "BD-B-F"
		)
		(31
			(Print 385 39) ; "BD-F-H"
		)
	)
)

