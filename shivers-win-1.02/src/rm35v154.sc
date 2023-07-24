;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35154)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Osc)
(use Motion)
(use Actor)
(use System)

(public
	rm35v154 0
)

(local
	local0
	local1
)

(instance rm35v154 of ShiversRoom
	(properties
		picture 35154
	)

	(method (init)
		(= local1 0)
		(spA init:)
		(spB init:)
		(spC init:)
		(sp1 init:)
		(sp2 init:)
		(sp3 init:)
		(spEnter init:)
		(spSelection init:)
		(vMask init:)
		(efExitBack init: 8)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance spA of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
	)

	(method (init)
		(if (or (== global551 13) (== global551 14) (== global551 15))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance spB of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 1
	)

	(method (init)
		(if (or (== global551 23) (== global551 24) (== global551 25))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance spC of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 2
	)

	(method (init)
		(if (or (== global551 33) (== global551 34) (== global551 35))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance sp1 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 3
	)

	(method (init)
		(if (or (== global551 13) (== global551 23) (== global551 33))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance sp2 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 4
	)

	(method (init)
		(if (or (== global551 14) (== global551 24) (== global551 34))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance sp3 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 5
	)

	(method (init)
		(if (or (== global551 15) (== global551 25) (== global551 35))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(pushButton doit: loop)
	)
)

(instance spEnter of ShiversProp
	(properties
		y 144
		priority 100
		fixPriority 1
		view 35154
		loop 6
	)

	(method (doVerb)
		(self setCycle: Osc 1)
		(gCurRoom setScript: sSelection)
	)
)

(instance spSelection of ShiversProp
	(properties
		priority 105
		fixPriority 1
		view 35154
		loop 8
	)

	(method (init)
		(switch global551
			(13
				(spSelection loop: 8 cel: (spSelection lastCel:))
			)
			(14
				(spSelection loop: 9 cel: (spSelection lastCel:))
			)
			(15
				(spSelection loop: 10 cel: (spSelection lastCel:))
			)
			(23
				(spSelection loop: 11 cel: (spSelection lastCel:))
			)
			(24
				(spSelection loop: 12 cel: (spSelection lastCel:))
			)
			(25
				(spSelection loop: 13 cel: (spSelection lastCel:))
			)
			(33
				(spSelection loop: 14 cel: (spSelection lastCel:))
			)
			(34
				(spSelection loop: 15 cel: (spSelection lastCel:))
			)
			(35
				(spSelection loop: 16 cel: (spSelection lastCel:))
			)
			(else
				(spSelection loop: 8 cel: 0)
			)
		)
		(= local1 global551)
		(super init: &rest)
	)
)

(instance vMask of View
	(properties
		priority 100
		fixPriority 1
		view 35154
		loop 7
	)
)

(instance sSelection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 43)
				(gSounds stop: 33510)
				(gSounds stop: 33511)
				(gSounds stop: 33512)
				(gSounds stop: 33513)
				(gSounds stop: 33514)
				(gSounds stop: 33515)
				(gSounds stop: 33516)
				(gSounds stop: 33517)
				(gSounds stop: 33518)
				(gGame handsOff:)
				(gSounds play: 13502 0 82 self)
				(spSelection setCycle: Beg self)
			)
			(1
				(switch local1
					(13
						(spSelection loop: 8)
					)
					(14
						(spSelection loop: 9)
					)
					(15
						(spSelection loop: 10)
					)
					(23
						(spSelection loop: 11)
					)
					(24
						(spSelection loop: 12)
					)
					(25
						(spSelection loop: 13)
					)
					(33
						(spSelection loop: 14)
					)
					(34
						(spSelection loop: 15)
					)
					(35
						(spSelection loop: 16)
					)
				)
				(if
					(or
						(== local1 13)
						(== local1 14)
						(== local1 15)
						(== local1 23)
						(== local1 24)
						(== local1 25)
						(== local1 33)
						(== local1 34)
						(== local1 35)
					)
					(spSelection setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2)
			(3
				(gGame handsOn:)
				(pushEnter doit:)
				(= cycles 1)
			)
			(4
				(if (IsFlag 39)
					(= local0 (Str format: {(Playing current selection)}))
					(gCurRoom drawText: local0 0 18)
					(local0 data: 0 dispose:)
					(= seconds 5)
				else
					(= cycles 1)
				)
			)
			(5
				(gCurRoom eraseText:)
				(self dispose:)
			)
		)
	)
)

(instance pushButton of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(gSounds stop: 13503)
		(gSounds play: 13503 0 82 0)
		(switch param1
			(0
				(= local1 (+ (mod local1 10) 10))
			)
			(1
				(= local1 (+ (mod local1 10) 20))
			)
			(2
				(= local1 (+ (mod local1 10) 30))
			)
			(3
				(= local1 (+ (* (/ local1 10) 10) param1))
			)
			(4
				(= local1 (+ (* (/ local1 10) 10) param1))
			)
			(5
				(= local1 (+ (* (/ local1 10) 10) param1))
			)
		)
		(spA cel: 0)
		(spB cel: 0)
		(spC cel: 0)
		(sp1 cel: 0)
		(sp2 cel: 0)
		(sp3 cel: 0)
		(switch (= temp0 (mod local1 10))
			(3
				(sp1 cel: 1)
			)
			(4
				(sp2 cel: 1)
			)
			(5
				(sp3 cel: 1)
			)
		)
		(switch (= temp0 (/ local1 10))
			(0)
			(1
				(spA cel: 1)
			)
			(2
				(spB cel: 1)
			)
			(3
				(spC cel: 1)
			)
		)
		(UpdateScreenItem spA)
		(UpdateScreenItem spB)
		(UpdateScreenItem spC)
		(UpdateScreenItem sp1)
		(UpdateScreenItem sp2)
		(UpdateScreenItem sp3)
	)
)

(instance pushEnter of Code
	(properties)

	(method (doit)
		(gSounds stop: 13503)
		(gSounds play: 13503 0 82 0)
		(switch local1
			(13
				(= global551 local1)
				(proc951_16 79)
				(proc951_9 33510)
				(gSounds play: 33510 0 74 0)
			)
			(14
				(= global551 local1)
				(proc951_16 170)
				(proc951_9 33511)
				(gSounds play: 33511 0 74 0)
			)
			(15
				(= global551 local1)
				(proc951_16 171)
				(proc951_9 33512)
				(gSounds play: 33512 0 74 0)
			)
			(23
				(= global551 local1)
				(proc951_16 172)
				(proc951_9 33513)
				(gSounds play: 33513 0 74 0)
			)
			(24
				(= global551 local1)
				(proc951_16 173)
				(proc951_9 33514)
				(gSounds play: 33514 0 74 0)
			)
			(25
				(= global551 local1)
				(proc951_16 174)
				(proc951_9 33515)
				(gSounds play: 33515 0 74 0)
			)
			(33
				(= global551 local1)
				(proc951_16 175)
				(proc951_9 33516)
				(gSounds play: 33516 0 74 0)
			)
			(34
				(= global551 local1)
				(proc951_16 176)
				(proc951_9 33517)
				(gSounds play: 33517 0 74 0)
			)
			(35
				(= global551 local1)
				(proc951_16 177)
				(proc951_9 33518)
				(gSounds play: 33518 0 74 0)
			)
			(else
				(= global551 0)
			)
		)
		(if (IsFlag 39)
			(if (!= global551 0)
				(= local0 (Str format: {(Playing current selection)}))
				(gCurRoom drawText: local0 0 18)
				(local0 data: 0 dispose:)
			else
				(gCurRoom eraseText:)
			)
		)
		(if (== local1 24)
			(SetFlag 66)
		else
			(ClearFlag 66)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 35150
	)

	(method (init)
		(self
			createPoly: 31 142 0 142 0 0 263 0 263 142 246 142 244 67 35 67 31 142
		)
		(super init: &rest)
	)
)

