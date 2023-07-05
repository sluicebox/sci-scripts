;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	Room76 0
)

(local
	local0
	local1
)

(instance fallSound of Sound
	(properties)
)

(instance Room76 of Rm
	(properties
		picture 76
		style 16
		horizon 99
		north 73
	)

	(method (init)
		(Load rsVIEW 44)
		(self setRegions: 605) ; regTroll
		(super init:)
		(= gIndoors 1)
		(= west 75)
		(gEgo view: 4 xStep: 4 yStep: 1)
		(if (== gPrevRoomNum 73)
			(gEgo posn: 189 119 init:)
		else
			(gEgo posn: 20 162 init:)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(= gNewRoomNum 73)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(not local0)
				(!= (gCurRoom script:) fallChasm)
			)
			(self setScript: fallChasm)
		)
	)

	(method (dispose)
		(fallSound dispose:)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look[<around][/room]')
					(Print 76 0) ; "This is the darkest cave you've ever seen!"
					(Print 76 1) ; "You see an opening in the distance."
				)
				((Said 'find,look/abyss')
					(if (& (gEgo onControl: 0) $1000)
						(Print 76 2) ; "It's too dark to see it."
					else
						(Print 76 3) ; "Where is it?!"
					)
				)
				((Said 'look/exit,hole')
					(Print 76 4) ; "It seems far away."
				)
				((Said '(place,lay)[<down]/board')
					(cond
						((not (gEgo has: 22)) ; Board
							(Print 76 5 #at -1 20 #time 5) ; "You don't have the board."
						)
						((or local0 (not (& (gEgo onControl: 0) $1000)))
							(NotClose) ; "You're not close enough."
						)
						(else
							(self setScript: layBoard)
						)
					)
				)
			)
		)
	)
)

(instance fallChasm of Script
	(properties)

	(method (init param1)
		(HandsOff)
		(Notify 605 4)
		(gEgo view: 44 setPri: 10 setCycle: Fwd)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					yStep: 10
					setMotion: MoveTo (+ (gEgo x:) 5) 300 self
				)
				(= cycles 2)
			)
			(1
				(fallSound number: 52 loop: 1 play: self)
			)
			(2
				((gInventory at: 3) loop: 0) ; Lantern__unlit
				(Print 76 6 #draw #mode 1 #dispose) ; "Oh, my goodness!!"
				(= seconds 3)
			)
			(3
				(cls)
				(Print 76 7 #draw #mode 1 #dispose) ; "A CHASM!!!"
			)
			(4
				(cls)
				(ShakeScreen 10)
				(= seconds 2)
			)
			(5
				(= gDeathFlag 1)
			)
		)
	)
)

(instance layBoard of Script
	(properties)

	(method (init param1)
		(= local1 (gEgo y:))
		(if (< (/ global192 10) 2)
			(gGame changeScore: 2)
			(+= global192 10)
		)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 76 8) ; "Feeling in the dark, you manage to place the board across the crevice. Now, can you cross it safely?"
				(= local0 1)
				((gInventory at: 22) moveTo: 76) ; Board
			)
			(1
				(gCurRoom setScript: 0)
				(Print 76 9 #draw) ; "Feeling in the dark again, you manage to pick up the board without dropping it into the crevice."
				(gEgo get: 22) ; Board
			)
		)
	)

	(method (doit)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(or (> (gEgo y:) (+ local1 3)) (< (gEgo y:) (- local1 3)))
			)
			(= local0 0)
			(client setScript: fallChasm)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(== local0 1)
				(== global132 0)
			)
			(= global132 1)
		)
		(if
			(and
				(& (gEgo onControl: 1) $1000)
				(== global132 1)
				(== local0 1)
			)
			(= global132 0)
			(= local0 0)
			(self changeState: 1)
		)
	)
)

