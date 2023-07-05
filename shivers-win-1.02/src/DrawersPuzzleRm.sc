;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50700)
(include sci.sh)
(use Main)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	DrawersPuzzleRm 0
)

(local
	[local0 15]
	[local15 3] = [2 45 88]
	[local18 5] = [3 16 29 42 55]
	[local23 15] = [0 0 3 0 3 3 0 3 0 3 0 3 3 3 3]
	local38
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(if (!= [local23 temp0] ([local0 temp0] cel:))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(if (== ([local0 temp0] cel:) 3)
			([local0 temp0] cel: 0)
		)
	)
	(gSounds play: 800 0 122 0)
)

(instance DrawersPuzzleRm of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(Chest init:)
		(Cupboard init:)
		(Key init:)
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			(= temp1 (Drawer new:))
			(temp1
				loop: (+ temp0 1)
				posn:
					(+ 50 [local15 (mod temp0 3)])
					(+ 10 [local18 (/ temp0 3)])
				init:
			)
			(= [local0 temp0] temp1)
		)
	)

	(method (doit)
		(if (localproc_0)
			(= local38 1)
			(Key cel: 1)
		else
			(= local38 0)
			(Key cel: 0)
		)
		(super doit: &rest)
	)
)

(instance Chest of View
	(properties
		x 50
		y 10
		priority 1
		fixPriority 1
		view 50700
	)
)

(instance Drawer of ShiversProp
	(properties
		priority 2
		fixPriority 1
		view 50700
		loop 1
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(event claimed: 1)
			(gSounds play: 800 0 122 0)
			(if (== cel 3)
				(self setCycle: Beg)
			else
				(self setCycle: End)
			)
		)
	)
)

(instance Key of ShiversProp
	(properties
		x 107
		y 98
		priority 3
		fixPriority 1
		view 50700
		loop 17
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(event claimed: 1)
			(if local38
				(Cupboard setScript: OpenCupboardScript)
				(gSounds play: 800 0 122 0)
			else
				(Prints {Can't open! (This message to be removed)})
				(gSounds play: 800 0 122 0)
			)
		)
	)
)

(instance Cupboard of ShiversProp
	(properties
		x 52
		y 78
		priority 2
		fixPriority 1
		view 50700
		loop 16
	)

	(method (handleEvent))
)

(instance OpenCupboardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(localproc_1)
				(Key hide:)
				(Cupboard setCycle: End)
				(= seconds 2)
			)
		)
	)
)

