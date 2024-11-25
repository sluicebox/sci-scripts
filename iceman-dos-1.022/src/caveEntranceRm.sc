;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Interface)
(use scubaRg)
(use n823)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	caveEntranceRm 0
)

(local
	local0 = 1
)

(instance caveEntranceRm of Rm
	(properties
		picture 56
		north 999
		east 55
		south 51
		west 57
	)

	(method (init)
		(super init:)
		(self setRegions: 305 setFeatures: caveEntranceFeat) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(59 ; inCave1Rm
				(gEgo posn: 80 80 loop: 0 setMotion: MoveTo 100 70 self)
				(= local0 0)
			)
			(55 ; shore2Rm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(57 ; westDeadEndRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(else
				(gEgo posn: 133 176 loop: 3 setMotion: MoveTo 133 -5)
			)
		)
		(proc305_2 5 88 118 8)
		(proc305_2 6 26 119 8)
		(proc305_2 6 74 91 5)
		(proc305_2 7 271 126 8)
		(proc305_2 5 309 124 8)
		(proc305_2 5 285 85 5)
		(proc305_2 6 210 83 4)
		(proc305_1 0 0 31 120 8)
		(proc305_1 0 0 60 92)
		(proc305_1 0 1 24 97)
		(proc305_1 0 2 87 117)
		(proc305_1 0 1 304 123)
		(proc305_1 4 1 270 124)
		(gAddToPics doit:)
		(if (and (not (gEgo has: 4)) (not ((gInventory at: 4) ownedBy: 55))) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
			(bottle init: cel: (if (< global140 7) 2 else 1))
		)
	)

	(method (doit)
		(if (and local0 (== (gEgo onControl: 1) 16))
			(gEgo setScript: goInCaveScript)
		)
		(super doit:)
	)

	(method (cue)
		(= local0 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,for,around][/room,cave]')
				(Print 56 0) ; "You peer under the overhang of the rocks and see what appears to be the entrance to a cave."
			)
		)
	)
)

(instance caveEntranceFeat of Feature
	(properties
		y 74
		x 48
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/cave')
				(Print 56 1) ; "You see a cave behind the rocks."
			)
		)
	)
)

(instance goInCaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreControl: -32768 setMotion: MoveTo 50 83 self)
			)
			(1
				(HandsOn)
				(proc823_0)
				(gCurRoom newRoom: 59) ; inCave1Rm
			)
		)
	)
)

(instance bottle of View
	(properties
		y 95
		x 262
		view 54
		loop 5
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]>')
				(if
					(or
						(Said '/bottle,object,thing')
						(InRect 200 85 300 125 gEgo)
					)
					(event claimed: 1)
					(Print 56 2) ; "You see what appears to be an old discarded bottle."
				)
			)
			((Said 'get/bottle')
				(if (InRect 160 85 300 125 gEgo)
					(gEgo setScript: getBottle)
				else
					(Print 56 3) ; "Get closer."
				)
			)
		)
	)
)

(instance getBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(cond
					((InRect 160 85 263 102 gEgo)
						(gEgo setMotion: MoveTo 200 94 self)
					)
					((InRect 263 85 300 102 gEgo)
						(gEgo setMotion: MoveTo 275 94 self)
					)
					((InRect 160 102 263 125 gEgo)
						(gEgo setMotion: MoveTo 200 110 self)
					)
					(else
						(gEgo setMotion: MoveTo 275 110 self)
					)
				)
			)
			(1
				(if (< 102 (gEgo y:))
					(gEgo setMotion: MoveTo 263 110 self)
				else
					(gEgo setMotion: MoveTo 263 94 self)
				)
			)
			(2
				(gEgo get: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
				(if (< 102 (gEgo y:))
					(gEgo setMotion: MoveTo 263 94 self)
				else
					(gEgo setMotion: MoveTo 263 110 self)
				)
			)
			(3
				(bottle dispose:)
				(gEgo
					illegalBits: $8000
					setMotion: MoveTo 155 (gEgo y:) self
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

