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
			((Said 'look[<at,around][/room]')
				(Print 56 0) ; "You peer under the overhang of the rocks and see what looks to be the entrance to a cave."
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

