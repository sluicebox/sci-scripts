;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 699)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Flags)
(use Motion)
(use Game)
(use System)

(public
	Bats 0
	batFlags 1
)

(class Fcycler of Cycle
	(properties
		head 0
		tail 10
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(self head: param2)
		(if (> param3 (client lastCel:))
			(self tail: (client lastCel:))
		else
			(self tail: param3)
		)
	)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) (self tail:))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: head)
	)
)

(class Ocycler of Cycle
	(properties
		lowerEnd 5
		upperEnd 6
		waitCycles 0
		start 0
		end 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(if (>= argc 2)
			(= client param1)
			(if (>= argc 3)
				(= cycleDir param3)
				(if (>= argc 4)
					(= lowerEnd param4)
					(if (>= argc 5)
						(= upperEnd param5)
					)
					(if (>= argc 6)
						(= start param6)
					)
					(if (>= argc 7)
						(= end param7)
					)
				)
			)
		)
		(= completed (= cycleCnt 0))
		(self cycleDone:)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(cond
			(waitCycles
				(-- waitCycles)
			)
			((or (> temp0 end) (< temp0 start))
				(self cycleDone:)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(= waitCycles (Random lowerEnd upperEnd))
		(client cel: (if (= cycleDir 1) start else end))
		(= cycleCnt (GetTime))
	)
)

(class STimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(class Bats of Rgn
	(properties
		keep 1
	)

	(method (init)
		(super init:)
		((ScriptID 93 0) init:) ; loadCode4
		((ScriptID 94 0) init:) ; loadCode5
		((ScriptID 95 0) init:) ; loadCode6
		((ScriptID 96 0) init:) ; loadCode7
		(gInventory
			add:
				truthStone
				tentPass
				punkPass
				freeTailPass
				fishPass
				fruitPass
				adamBatPass
		)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		((ScriptID 99 1) init:) ; invBitCode
		(= gCurrentRegionFlags batFlags)
	)

	(method (points param1 param2 &tmp [temp0 30] [temp30 30])
		(if (and (> argc 1) (gCurrentRegionFlags test: param2))
			(return)
		)
		(if param1
			(gGame changeScore: param1)
			(if (> argc 1)
				(gCurrentRegionFlags set: param2)
			)
			(if (and (> param1 0) (gGame pointSound:))
				((gGame pointSound:) play:)
				(if (not (OneOf gCurRoomNum 10 40)) ; speedRoom, intro
					(Message msgGET 999 19 0 0 1 @temp0) ; "Lost Secret of the Rainforest Score: %d of 1000"
					(Message msgGET 999 19 0 0 2 @temp30)
					(Format @temp30 @temp0 gScore)
					(DrawStatus @temp30 67 0)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 600 630 640 680))
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			((ScriptID 93 0) dispose:) ; loadCode4
			((ScriptID 94 0) dispose:) ; loadCode5
			((ScriptID 95 0) dispose:) ; loadCode6
			((ScriptID 96 0) dispose:) ; loadCode7
			(gInventory
				delete:
					truthStone
					tentPass
					punkPass
					freeTailPass
					fishPass
					fruitPass
					adamBatPass
			)
			(batFlags dispose:)
		)
	)

	(method (dispose)
		(gEgo normalize: 0)
		(super dispose:)
	)
)

(instance truthStone of EcoInvI
	(properties
		loop 4
		cel 10
		message 43
		noun 42
	)
)

(instance tentPass of EcoInvI
	(properties
		loop 4
		cel 9
		message 42
		noun 9
	)
)

(instance punkPass of EcoInvI
	(properties
		loop 4
		cel 7
		message 58
		noun 25
	)
)

(instance freeTailPass of EcoInvI
	(properties
		loop 4
		cel 6
		message 59
		noun 29
	)
)

(instance fishPass of EcoInvI
	(properties
		loop 4
		cel 8
		message 60
		noun 31
	)
)

(instance fruitPass of EcoInvI
	(properties
		loop 6
		cel 6
		message 61
		noun 39
	)
)

(instance adamBatPass of EcoInvI
	(properties
		loop 6
		cel 7
		message 62
		noun 46
	)
)

(instance batFlags of Flags
	(properties
		size 36
	)
)

