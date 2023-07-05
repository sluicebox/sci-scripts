;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4160)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4160 0
)

(instance s1_4160 of PQRoom
	(properties
		picture 4160
	)

	(method (init)
		(super init: &rest)
		(cond
			((global112 flashBanged:)
				(self setScript: lucysDead)
			)
			((OneOf gPrevRoomNum 4100 4110 4120) ; s1_4100, s1_4110, s1_4120
				(Load rsVIEW 41602)
				(self setScript: yourShotInNeck)
			)
			((== gPrevRoomNum 4150) ; s1_4150
				(Lock rsAUDIO 40105 0)
				(Load rsVIEW 41603)
				(Load rsVIEW 41604)
				(Load rsVIEW 41608)
				(self setScript: lucyShootsAll)
			)
			(else
				(door init:)
				(self setScript: enterBathroom)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance lucysDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40104 0)
				(guysLookLucy init:)
				(deadLucy init:)
				(= cycles 2)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40104)
				(gMessager say: 0 0 4 1 self) ; "Suspect down! Officer coming out!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(2)
			(3
				(gGame handsOff: showCloseUp: 41002 180 70 self 1)
			)
			(4
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance yourShotInNeck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoAndPacmeyer setPri: 250 init: setCycle: End self)
				(proc4_6 41601 185 95 0 0 280 1 0)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(2
				(gBackMusic loop: 1 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance lucyShootsAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic number: 40108 loop: -1 play:)
				(scout setPri: 300 init: setCycle: End)
				(shootingLucy setPri: 400 init: setCycle: CT 12 1 self)
				(player setPri: 401 init: setCycle: End)
				(UnLoad 141 40105)
			)
			(1
				(gFxSound number: 35 loop: 1 play:)
				(shootingLucy setCycle: CT 15 1 self)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(shootingLucy setCycle: CT 20 1 self)
			)
			(3
				(gBackMusic loop: 1 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance enterBathroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 41600 0 -10 0 0 -1 1)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(door dispose:)
			)
			(3
				(gCurRoom newRoom: 4200) ; s1_4200
			)
		)
	)
)

(instance deadLucy of View
	(properties
		x 147
		y 236
		view 41609
	)
)

(instance guysLookLucy of View
	(properties
		x 285
		y 285
		view 41600
	)
)

(instance egoAndPacmeyer of Prop
	(properties
		x 370
		y 210
		view 41602
	)
)

(instance shootingLucy of Prop
	(properties
		x 123
		y 286
		view 41603
	)
)

(instance player of Prop
	(properties
		y 412
		view 41604
	)
)

(instance scout of Prop
	(properties
		x 307
		y 193
		view 41608
		cel 13
	)
)

(instance door of Prop
	(properties
		x 112
		y 275
		view 41607
	)
)

