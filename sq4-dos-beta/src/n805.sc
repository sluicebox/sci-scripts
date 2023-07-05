;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 805)
(include sci.sh)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(class Wind of Code
	(properties
		onCon 0
		cnt 0
		currentRoom 0
		endType 0
		heading 0
		yDir 0
	)

	(method (init)
		(self savedOldStuff:)
	)

	(method (savedOldStuff)
		(= currentRoom (Random 10 20))
		(if (== onCon cnt)
			(= cnt -1)
		else
			(= cnt (Random 0 (* endType 10)))
			(if (< cnt (* endType 3))
				(= cnt 0)
			else
				(/= cnt 10)
			)
			(if (not onCon)
				(= onCon cnt)
				(= cnt -1)
			)
			(= yDir 10)
		)
	)

	(method (doit)
		(cond
			((== cnt -1) 0)
			((> onCon cnt)
				(-- yDir)
				(if (not yDir)
					(-- onCon)
					(= yDir 10)
				)
			)
			((< onCon cnt)
				(-- yDir)
				(if (not yDir)
					(++ onCon)
					(= yDir 10)
				)
			)
			((== onCon cnt)
				(self savedOldStuff:)
			)
		)
		(if (not (-- currentRoom))
			(self savedOldStuff:)
		)
	)
)

(class WindSlave of Actor
	(properties
		theRegion 0
		theOldBits 0
		theOldSignal 0
		nextRoom 0
		inertia 0
		maxInertia 0
		oldDir 0
	)

	(method (init)
		(super init:)
		(= maxInertia x)
		(= oldDir y)
		(= inertia (Random 2 70))
	)

	(method (doit)
		(if (!= nextRoom (theRegion onCon:))
			(self swimCnt: (theRegion onCon:))
		)
		(if (== (-- inertia) 1)
			(= inertia 0)
			(self oldSpeed:)
		)
		(super doit:)
	)

	(method (oldSpeed)
		(self setHeading: (theRegion heading:) setMotion: MoveFwd 330 self)
	)

	(method (swimCnt param1)
		(if (<= param1 theOldBits)
			(if (not param1)
				(self setMotion: 0)
			)
			(= nextRoom param1)
			(self setStep: nextRoom)
		)
		(if (and cycler (<= xStep theOldSignal))
			(self setCycle: 0)
		)
		(if (and (not cycler) (> xStep theOldSignal))
			(self setCycle: Fwd)
		)
	)

	(method (cue)
		(super cue:)
		(self x: maxInertia y: oldDir init:)
	)
)

