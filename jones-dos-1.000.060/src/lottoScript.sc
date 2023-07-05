;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	lottoScript 0
)

(local
	local0
	[local1 4]
	[local5 50]
	local55
)

(instance lottoScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= global524 global372)
				(= local55 0)
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck1
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck1 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
				(gASong stop:)
				(gASoundEffect loop: -1 play: 25)
			)
			(1
				(= cycles (Random 1 2))
			)
			(2
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck2
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck2 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
			)
			(3
				(= cycles (Random 1 2))
			)
			(4
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck3
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck3 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
			)
			(5
				(= cycles (Random 1 2))
			)
			(6
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck4
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck4 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
			)
			(7
				(= cycles (Random 1 2))
			)
			(8
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck5
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck5 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
			)
			(9
				(= cycles (Random 1 2))
			)
			(10
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck6
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck6 setMotion: MoveTo temp1 temp2)
				(= cycles (Random 1 2))
			)
			(11
				(= cycles (Random 1 2))
			)
			(12
				(= temp1 (Random 100 230))
				(= temp2 (Random 20 35))
				(= temp3 (Random 250 300))
				(lottobuck7
					posn: temp1 temp2
					setCycle: Fwd
					setLoop: 0
					setStep: 0 7
					init:
				)
				(+= temp2 temp3)
				(lottobuck7 setMotion: MoveTo temp1 temp2 self)
			)
			(13
				(lottobuck1 stopUpd:)
				(lottobuck2 stopUpd:)
				(lottobuck3 stopUpd:)
				(lottobuck4 stopUpd:)
				(lottobuck5 stopUpd:)
				(lottobuck6 stopUpd:)
				(lottobuck7 stopUpd:)
				(= cycles 1)
			)
			(14
				(lottonote
					setLoop: 1
					posn: 29 80
					init:
					setMotion: MoveTo 159 143 self
				)
			)
			(15
				(= cycles 1)
			)
			(16
				(lottonote stopUpd:)
				(= cycles 1)
			)
			(17
				(if register
					(= temp0 0)
					(= local0 (Format @local5 116 0 (global302 actualName:))) ; "%s"
					(= temp0 1)
				)
				(if temp0
					(TextSize @[local1 0] local0 4 0)
					(Display
						local0
						dsCOORD
						(- 158 (/ [local1 3] 2))
						64
						dsCOLOR
						0
						dsBACKGROUND
						-1
						dsFONT
						4
					)
				)
				(= local0 (Format @global100 116 1 register2)) ; "%d"
				(TextSize @[local1 0] local0 4 0)
				(Display
					local0
					dsCOORD
					(- 160 (/ [local1 3] 2))
					125
					dsCOLOR
					0
					dsBACKGROUND
					-1
					dsFONT
					4
				)
				(= cycles 1)
			)
			(18
				(proc0_3 240)
				(self cue:)
			)
			(19
				(lottobuck1 dispose:)
				(lottobuck2 dispose:)
				(lottobuck3 dispose:)
				(lottobuck4 dispose:)
				(lottobuck5 dispose:)
				(lottobuck6 dispose:)
				(lottobuck7 dispose:)
				(lottonote dispose:)
				(= cycles 2)
			)
			(20
				(proc0_1)
				(client script: 0 cue:)
				(gASoundEffect loop: 1)
				(= local55 1)
			)
		)
		(if local55
			(DisposeScript 116)
		)
	)
)

(instance lottonote of Act
	(properties
		view 340
		priority 5
	)

	(method (init)
		(self setPri: priority setStep: 12 12)
		(super init:)
	)
)

(instance lottobuck1 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck2 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck3 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck4 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck5 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck6 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

(instance lottobuck7 of Act
	(properties
		view 340
		priority 5
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(self setPri: priority)
		(super init:)
	)
)

