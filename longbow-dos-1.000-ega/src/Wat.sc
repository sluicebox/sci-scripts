;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	Wat 0
	merryMenEntrance 1
	proc125_2 2
	putStuff 3
)

(procedure (proc125_2)
	(Wat
		weMeetAgain: 0
		charFirstTalk: 0
		whichChar: 0
		charObj: 0
		travelDir: 0
		travelSect: 0
		setScript: 0
	)
)

(class Wat of Rgn
	(properties
		keep 1
		weMeetAgain 0
		offRoad 0
		secondSearch 0
		charFirstTalk 0
		qFight 0
		gaveManBucks 0
		offeredEmerald 0
		hurry 0
		blewHorn 0
		womanStatus 0
		poachStatus 0
		section 4
		whichChar 0
		charObj 0
		travelDir 0
		travelSect 4
		theTimer 0
		enterDir 0
	)

	(method (init)
		(= theTimer travelTimer)
		(if (== gPrevRoomNum 220) ; forest
			(= section (/ (& gForestRoomNum $00f0) 16))
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 110 120 100))
			(self keep: 0)
		)
	)

	(method (dispose)
		(if
			(and
				(== gDay 1)
				(IsFlag 44)
				(not (IsFlag 75))
				(not (IsFlag 173))
			)
			(SetFlag 103)
		)
		(if
			(and
				(== gDay 4)
				(IsFlag 47)
				(not (IsFlag 153))
				(not (IsFlag 174))
			)
			(SetFlag 184)
		)
		(if (and (== gDay 8) (IsFlag 135) (not (IsFlag 57)))
			(SetFlag 191)
		)
		(super dispose:)
	)
)

(instance putStuff of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 (gInventory indexOf: param1))
		(if
			(and
				(param1 isKindOf: InvI)
				(== (param1 owner:) gEgo)
				(or
					(and (== gDisguiseNum 1) (not (OneOf temp0 0 3 15))) ; beggar
					(and
						(== gDisguiseNum 2) ; jewler (no rouge)
						(not (OneOf temp0 0 2 14 10 18 8 7))
					)
					(and (== gDisguiseNum 4) (not (OneOf temp0 0 17))) ; yeoman
					(and
						(== gDisguiseNum 5) ; abbey monk
						(not (OneOf temp0 0 2 11 14 12 10 13 18))
					)
					(and
						(== gDisguiseNum 6) ; fens monk
						(not (OneOf temp0 0 2 14 10 5 6 17 16 18))
					)
				)
			)
			(gEgo put: temp0 140)
		)
	)
)

(instance travelTimer of Script
	(properties)

	(method (init)
		(= seconds (if (Wat hurry:) 5 else 10))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Wat
					travelSect:
						(if (== (Wat travelDir:) 1)
							(- (Wat travelSect:) 1)
						else
							(+ (Wat travelSect:) 1)
						)
				)
				(= seconds (if (Wat hurry:) 5 else 10))
			)
			(2
				(if (or (<= (Wat travelSect:) 1) (>= (Wat travelSect:) 9))
					(proc125_2)
					(switch gDay
						(1
							(if (and (IsFlag 46) (IsFlag 45))
								(gCurRoom newRoom: 160)
							)
						)
						(4
							(if (IsFlag 48)
								(gCurRoom newRoom: 160)
							)
						)
					)
					(self dispose:)
				else
					(-= state 2)
					(self cue:)
				)
			)
		)
	)
)

(instance merryMenEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ScriptID 20) ; Will
				(ScriptID 19) ; John
				(ScriptID 23) ; Tuck
				(LoadMany rsVIEW 160 161 162 151 152 153 154 155 156)
				((ScriptID 20) ; Will
					ignoreHorizon: 1
					posn: 265 -2
					init:
					setCycle: StopWalk 161
					setMotion: MoveTo 185 30 self
				)
				((ScriptID 19) ; John
					posn: -10 75
					init:
					setCycle: StopWalk 152
					setMotion: MoveTo 95 70
				)
				((ScriptID 23) ; Tuck
					posn: 330 125
					init:
					setCycle: StopWalk 155
					setMotion: MoveTo 240 125
				)
			)
			(1
				((ScriptID 20) setMotion: MoveTo 185 50 self) ; Will
			)
			(2
				((ScriptID 19) stopUpd:) ; John
				((ScriptID 23) stopUpd:) ; Tuck
				((ScriptID 20) stopUpd:) ; Will
				(self dispose:)
			)
		)
	)
)

