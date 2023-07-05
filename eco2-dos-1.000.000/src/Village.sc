;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 399)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Flags)
(use Game)
(use System)

(public
	Village 0
	villageFlags 1
)

(class Village of Rgn
	(properties
		keep 1
		fHLevel 0
	)

	(method (init)
		(super init:)
		((ScriptID 91 0) init:) ; loadCode2
		((ScriptID 92 0) init:) ; loadCode3
		((ScriptID 93 0) init:) ; loadCode4
		(gInventory
			add:
				drum
				bough
				barkCup
				pods
				charm
				machete
				clayCup
				berries
				roots
				sweetDrink
		)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		((ScriptID 99 1) init:) ; invBitCode
		(= gCurrentRegionFlags villageFlags)
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
		(if (not (OneOf newRoomNumber 300 330 360 380 390 400 420 430 440 16)) ; ceremony
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			((ScriptID 91 0) dispose:) ; loadCode2
			((ScriptID 92 0) dispose:) ; loadCode3
			((ScriptID 93 0) dispose:) ; loadCode4
			(gInventory
				delete:
					drum
					bough
					barkCup
					pods
					charm
					machete
					clayCup
					berries
					roots
					sweetDrink
			)
			(villageFlags dispose:)
		)
	)
)

(instance drum of EcoInvI
	(properties
		cel 10
		message 17
		noun 17
		flag 10
	)
)

(instance bough of EcoInvI
	(properties
		cel 11
		message 18
		noun 18
		flag 13
	)
)

(instance barkCup of EcoInvI
	(properties
		cel 12
		message 19
		noun 19
		flag 14
	)
)

(instance pods of EcoInvI
	(properties
		loop 6
		cel 9
		message 20
		noun 10
		flag 16
	)
)

(instance machete of EcoInvI
	(properties
		loop 2
		cel 1
		message 23
		noun 22
		flag 18
	)
)

(instance charm of EcoInvI
	(properties
		loop 2
		message 21
		noun 52
		flag 17
	)
)

(instance clayCup of EcoInvI
	(properties
		loop 2
		cel 2
		message 24
		noun 23
		flag 19
	)
)

(instance berries of EcoInvI
	(properties
		loop 2
		cel 4
		message 25
		noun 24
		flag 20
	)
)

(instance roots of EcoInvI
	(properties
		loop 2
		cel 13
		message 63
		noun 61
		flag 12
	)
)

(instance sweetDrink of EcoInvI
	(properties
		cel 7
		message 72
		noun 67
		flag 15
	)
)

(instance villageFlags of Flags
	(properties
		size 80
	)
)

