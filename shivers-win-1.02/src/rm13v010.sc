;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13010)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm13v010 0
)

(local
	local0
	local1
	[local2 7] = [6 1 9 3 4 6 4]
	[local9 9] = [11306 11315 11308 11309 11318 11305 11316 11317 11307]
	[local18 9] = [11311 11319 11313 11314 11322 11310 11320 11321 11312]
	[local27 9]
	[local36 9] = [1 0 1 0 0 0 0 0 1]
	local45
	local46
)

(procedure (localproc_0 param1 &tmp temp0)
	(PrintDebug {moved %d} param1)
	(if (== param1 local46)
		(PrintDebug {moved %d})
		(if (>= (++ local45) 7)
			(= [local9 (- param1 1)] 35133)
		)
	else
		(= local45 0)
	)
	(= local46 param1)
	(if (and (== param1 [local2 local1]) (== (++ local1) 7))
		(for
			((= temp0 0))
			(and (< temp0 9) (== [local36 temp0] ([local27 temp0] cel:)))
			((++ temp0))
		)
		(if (== temp0 9)
			(gCurRoom setScript: sDoorOpens)
		)
		(= local1 0)
	)
	(return 0)
)

(instance rm13v010 of ShiversRoom
	(properties
		picture 13110
	)

	(method (init &tmp temp0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(= local45 0)
		(= local46 -1)
		(if (IsFlag 31)
			(efExitForward init: 9)
		else
			(for ((= temp0 1)) (<= temp0 9) ((++ temp0))
				(= [local27 (- temp0 1)]
					((piece new:) loop: temp0 scratch: temp0 init: yourself:)
				)
			)
		)
		(door init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(proc951_1 8)
		(cond
			((== newRoomNumber 13012) ; rm13v012
				(gSounds fade: 21303 0 10 8 1 0)
			)
			((not (IsFlag 31))
				(for
					((= temp0 0))
					(and (< temp0 9) (not ([local27 temp0] cel:)))
					((++ temp0))
				)
				(if (< temp0 9)
					(gSounds play: 11303 0 82 0)
				)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13011
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13011
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13012
	)

	(method (init)
		(self createPoly: 76 144 76 0 189 0 189 143)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		x 73
		priority 10
		fixPriority 1
		view 13110
	)

	(method (init)
		(if (IsFlag 31)
			(= cel 4)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance piece of ShiversProp
	(properties
		priority 200
		fixPriority 1
		view 13110
	)

	(method (doVerb)
		(if (self cel:)
			(self cel: 0)
			(gSounds play: [local18 (- scratch 1)] 0 82 0)
		else
			(self cel: 1)
			(gSounds play: [local9 (- scratch 1)] 0 82 0)
		)
		(localproc_0 (self scratch:))
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(for ((= temp0 1)) (<= temp0 9) ((++ temp0))
					([local27 (- temp0 1)] dispose:)
				)
				(gSounds play: 11303 0 82 self)
			)
			(2
				(door setCycle: End self)
				(gSounds play: 11304 0 82 0)
			)
			(3
				(gGame handsOn:)
				(SetFlag 31)
				(proc951_15 6750)
				(efExitForward init: 3)
			)
		)
	)
)

