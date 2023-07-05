;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Feature)
(use Rev)
(use Flags)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	Jungle 0
	jungleFlags 1
	birdMove 2
	egoActions 3
)

(class Jungle of Rgn
	(properties
		keep 1
		climbers 0
		nestBurn 0
		climbColor 0
	)

	(method (doVerb)
		(return 0)
	)

	(method (notify)
		(gCurrentRegionFlags set: 6)
		(self setScript: distantDrums)
	)

	(method (init)
		(super init:)
		(gEgo actions: egoActions)
		(gInventory add: flowers)
		((ScriptID 91 0) init:) ; loadCode2
		((ScriptID 92 0) init:) ; loadCode3
		((ScriptID 99 0) doit: 118) ; invSetupCode
		(gGameSound1 number: 200 loop: -1 play: 0 fade: 127 10 4 0)
		((ScriptID 99 1) init:) ; invBitCode
		(= gCurrentRegionFlags jungleFlags)
	)

	(method (newRoom newRoomNumber &tmp [temp0 2])
		(if (not (OneOf newRoomNumber 200 220 240 280 260 290))
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			(gInventory delete: flowers)
			((ScriptID 91 0) dispose:) ; loadCode2
			((ScriptID 92 0) dispose:) ; loadCode3
			(jungleFlags dispose:)
			(gGameSound1 fade:)
		else
			(gGameSound1
				fade:
					(cond
						((== newRoomNumber 260) 85)
						((OneOf newRoomNumber 240 280 290) 105)
						(else 127)
					)
					5
					1
					0
			)
			(cond
				((and (not (gCurrentRegionFlags test: 5)) (OneOf newRoomNumber 220 260 280))
					(self setScript: maBirdSquawker)
					(maBirdSquawker setScript: paBirdSquawker)
				)
				(
					(and
						(gCurrentRegionFlags test: 6)
						(not (gCurrentRegionFlags test: 7))
						(!= newRoomNumber 290)
					)
					(self setScript: distantDrums)
				)
				(else
					(self setScript: 0)
				)
			)
		)
	)
)

(instance flowers of EcoInvI
	(properties
		cel 9
		message 16
		noun 16
		flag 6
	)
)

(instance jungleFlags of Flags
	(properties
		size 40
	)
)

(instance birdMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client
						cycleSpeed: (Random 4 12)
						setCycle: (if (Random 0 1) Fwd else Rev)
					)
				)
				(= ticks (Random 30 60))
			)
			(1
				(client setCycle: 0 stopUpd:)
				(= seconds (Random 2 6))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance maBirdSquawk of Sound
	(properties
		number 241
		loop 3
	)
)

(instance paBirdSquawk of Sound
	(properties
		number 240
		loop 2
	)
)

(instance maBirdSquawker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(if (Random 0 3)
					(DoSound sndSET_VOLUME maBirdSquawk 32)
					(maBirdSquawk play: 75)
				)
				(= seconds (Random 4 6))
			)
			(2
				(maBirdSquawk stop:)
				(self changeState: 0)
			)
		)
	)
)

(instance paBirdSquawker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 6))
			)
			(1
				(if (Random 0 3)
					(paBirdSquawk play: 75)
				)
				(= seconds (Random 3 5))
			)
			(2
				(paBirdSquawk stop:)
				(self changeState: 0)
			)
		)
	)
)

(instance distantDrums of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(maBirdSquawk number: 260 loop: -1)
				(= register
					(switch gCurRoomNum
						(200 70)
						(220 70)
						(240 100)
						(260 80)
						(280 115)
						(290 127)
					)
				)
				(= cycles 1)
			)
			(1
				(maBirdSquawk play: register)
				(= seconds (Random 5 12))
			)
			(2
				(maBirdSquawk stop:)
				(= seconds (Random 3 6))
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (and (== theVerb 15) (not (gCurrentRegionFlags test: 0)) (not (gEgo view:))) ; leaf
			(Load rsMESSAGE 4)
			(if (gCurrentRegionFlags test: 20)
				(gGame setScript: (ScriptID 298)) ; leafScript
			else
				(gMessager say: 1 15 2 1 0 4) ; "It's not time to use that."
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(class Orchid of Feature
	(properties
		noun 3
		modNum 14
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(super doVerb: theVerb)
		)
	)
)

(class Epiphyte of Feature
	(properties
		noun 2
		modNum 14
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 7))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 7))
			(super doVerb: theVerb)
		)
	)
)

