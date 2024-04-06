;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23590)
(include sci.sh)
(use Main)
(use n951)
(use Osc)
(use Motion)
(use System)

(public
	LyrePuzzleRm 0
)

(local
	[local0 8] = [50 64 77 92 105 118 130 144]
	[local8 8] = [4 4 3 3 2 2 2 2]
	[local16 8] = [22302 22303 22304 22305 22306 22307 22308 22309]
	[local24 8]
	[local32 12]
	[local44 10] = [52 62 72 82 92 101 112 122 132 142]
	[local54 10] = [132 132 132 132 132 131 131 131 131 131]
	[local64 10]
	local74 = 1
	local75
	local76
	local77
	local78
	local79
	local80
	local81
	local82
	local83
	local84
	local85
)

(procedure (localproc_0 param1) ; UNUSED
	(return (!= [local32 (- local76 1)] param1))
)

(instance LyrePuzzleRm of ShiversRoom
	(properties
		picture 23590
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(gSounds stop: 22301)
		(efExitBack init: 8)
		(= local79 (List new:))
		(Button init:)
		(= local81 gGameTime)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= temp1 (LyreString new:))
			(proc951_18 [local16 temp0])
			(temp1
				init:
					[local0 temp0]
					[local8 temp0]
					temp0
					0
					[local16 temp0]
					temp0
			)
			(= [local24 temp0] temp1)
		)
		(= local76 0)
		(= local74 0)
		(= local80 0)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(= temp1 (Tile new:))
			(temp1 init: (+ 0 [local44 temp0]) (+ 0 [local54 temp0]) 0 0)
			(= [local64 temp0] temp1)
		)
	)

	(method (newRoom &tmp temp0)
		(local79 release:)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(gSounds fade: [local16 temp0] 0 1 16 1 0)
			(proc951_19 [local16 temp0])
		)
		(super newRoom: &rest)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (not local74)
			(if (local79 size:)
				(cond
					((not local80)
						(= temp0 (local79 at: 0))
						(local79 delete: temp0)
						(if local82
							(gSounds stop: local82)
							(proc951_18 local82)
						)
						(= local82 [local16 temp0])
						([local24 temp0] play: [local24 temp0])
					)
					((> (- gGameTime local81) 50)
						(= temp0 (local79 at: 0))
						(= local81 gGameTime)
						(if local82
							(gSounds stop: local82)
							(proc951_18 local82)
						)
						(local79 delete: temp0)
						(= local82 [local16 temp0])
						([local24 temp0] play: [local24 temp0])
					)
				)
			else
				(= local82 0)
			)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23540
	)

	(method (init)
		(self createPoly: 0 0 0 143 29 143 29 0 218 0 218 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance hsBack of HotSpot
	(properties)

	(method (init)
		(self createPoly: 0 0 0 143 29 143 29 0 218 0 218 143 263 143 263 0)
		(super init: &rest)
	)

	(method (doVerb)
		(Button off:)
		(gSounds play: 12302 0 122 0)
	)
)

(class Button of ShiversProp
	(properties
		x 139
		y 80
		view 23592
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 146 97 134 91 134 82 140 75 151 75 160 81 160 89 155 95
		)
	)

	(method (doVerb &tmp temp0)
		(if (== cel 0)
			(self on:)
			(gSounds play: 12301 0 122 0)
			(local79 release:)
		else
			(self off:)
			(gSounds play: 12302 0 122 0)
		)
	)

	(method (on &tmp temp0)
		(= local74 0)
		(efExitBack dispose:)
		(hsBack init:)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(for
				((= [local32 temp0] (Random 0 7)))
				(and
					(> temp0 0)
					(or
						(== [local32 temp0] [local32 (- temp0 1)])
						(== [local32 temp0] [local32 0])
					)
				)
				((= [local32 temp0] (mod (+ [local32 temp0] 1) 8)))
			)
		)
		(= cel 1)
		(= local75 3)
		(self setScript: playSimonScript)
	)

	(method (off &tmp temp0)
		(efExitBack init: 8)
		(hsBack dispose:)
		(if local84
			([local24 local85] cue:)
		)
		(self setScript: 0)
		(= cel 0)
		(= local75 3)
		(= local76 0)
		(= local74 0)
		(local79 release:)
		(= local80 0)
		(if (- local75 3)
			(if (== (- local75 3) 1)
				(gSounds play: 12304 0 82 0)
			else
				(gSounds play: 12305 0 82 0)
			)
		)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			([local64 temp0] moveIn:)
		)
	)

	(method (isOff)
		(if (== cel 0)
			(return 1)
		else
			(return 0)
		)
	)
)

(class Tile of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 23592
	)

	(method (init param1 param2 param3 param4)
		(= x param1)
		(= y param2)
		(= loop param3)
		(= cel param4)
		(super init: &rest)
	)

	(method (moveOut)
		(= cel 1)
	)

	(method (moveIn)
		(= cel 0)
	)
)

(class LyreString of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 23591
		soundNum 0
		stringNum 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= x param1)
		(= y param2)
		(= loop param3)
		(= cel param4)
		(= soundNum param5)
		(= stringNum param6)
		(super init: &rest)
		(switch stringNum
			(0
				(self createPoly: 61 89 43 1 57 1 69 89)
			)
			(1
				(self createPoly: 69 89 57 1 69 0 77 89)
			)
			(2
				(self createPoly: 77 89 69 0 84 0 86 90)
			)
			(3
				(self createPoly: 86 90 84 0 101 0 93 90)
			)
			(4
				(self createPoly: 93 90 101 0 112 0 100 89)
			)
			(5
				(self createPoly: 100 89 112 0 125 0 107 90)
			)
			(6
				(self createPoly: 107 90 125 0 137 0 113 90)
			)
			(7
				(self createPoly: 113 90 137 0 148 0 150 3 119 90)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(if (< (local79 size:) 10)
				(local79 addToEnd: stringNum)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (play param1)
		(= local80 1)
		(gSounds stop: soundNum)
		(proc951_18 soundNum)
		(gSounds play: soundNum 0 122 param1)
		(if local74
			(PrintDebug {you play: %d} (+ stringNum 1))
			(if (!= [local32 local76] stringNum)
				(PrintDebug
					{note %d was %d}
					(+ local76 1)
					(+ [local32 local76] 1)
				)
				(gCurRoom setScript: wrongNoteScript)
			else
				(self vibrate: 1 5)
			)
			(++ local76)
		else
			(PrintDebug {comp play: %d} (+ stringNum 1))
			(self vibrate: 1 5)
		)
	)

	(method (vibrate param1 param2)
		(self cycleSpeed: param1)
		(self setCycle: Osc param2)
	)

	(method (cue)
		(= local80 0)
		(self setCycle: 0 cel: 0)
		(PrintDebug {cue me})
		(if (and local74 (>= local76 local75))
			(= local76 0)
			(= local74 0)
			(= local77 1)
			(if (> (++ local75) 12)
				(= local78 1)
				(gGame handsOff:)
				(gCurRoom setScript: solvedScript)
			)
		)
	)
)

(instance playSimonScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
				(= local77 0)
				(local79 release:)
				(= local83 0)
				(= local82 0)
			)
			(1
				(if (< local76 local75)
					(= temp1 [local32 local76])
					([local24 [local32 local76]] play: 0)
					(++ local76)
					(-- state)
					(= local83 local82)
					(= local85 local84)
					(if local83
						(gSounds stop: local83)
						(proc951_18 local83)
						([local24 local85] cue:)
					)
					(if local82
						([local24 local85] setCycle: 0 cel: 0)
					)
					(= local82 [local16 temp1])
					(= local84 temp1)
					(= ticks 75)
				else
					(= local76 0)
					(= local74 1)
					(= cycles 1)
				)
			)
			(2
				(if (not local78)
					(if local77
						(gSounds play: 12303 0 82 0)
						([local64 (- local75 4)] moveOut:)
						(= local82 0)
						(= local83 0)
						(= state -1)
						(= seconds 1)
					else
						(if (local79 size:)
							(= temp1 (local79 at: 0))
							(local79 delete: temp1)
							(= local83 local82)
							(= local85 local84)
							(if local83
								(gSounds stop: local83)
								(proc951_18 local83)
								([local24 local85] cue:)
							)
							(= local84 temp1)
							(= local82 [local16 temp1])
							([local24 temp1] play: [local24 temp1])
						)
						(gGame handsOn:)
						(= local80 0)
						(-- state)
						(= ticks 45)
					)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance wrongNoteScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local74 0)
				(= seconds 2)
			)
			(1
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					([local24 temp0] setCycle: Osc -1)
				)
				(gSounds play: 22312 0 114 self)
			)
			(2
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					([local24 temp0] setCycle: Beg)
				)
				(Button off:)
				(gGame handsOn:)
			)
		)
	)
)

(instance solvedScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local74 0)
				(= local78 1)
				(gSounds play: 12303 0 82 0)
				([local64 (- local75 4)] moveOut:)
				(= seconds 2)
			)
			(1
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					([local24 temp0] vibrate: 1 15)
				)
				(gSounds stop: 12303)
				(gSounds play: 22311 0 106 self)
			)
			(2
				(SetFlag 23)
				(proc951_15 6750)
				(gCurRoom newRoom: 23550) ; rm23v550
			)
		)
	)
)

