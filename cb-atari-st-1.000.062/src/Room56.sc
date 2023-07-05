;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use HighLite)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	Room56 0
)

(synonyms
	(stair upstair)
)

(instance glow of HighLite
	(properties)
)

(instance Room56 of Rm
	(properties
		picture 56
	)

	(method (init)
		(= horizon 0)
		(= south (= east 55))
		(= global189 52)
		(super init:)
		(self setRegions: 242) ; tunnelReg
		(gEgo view: 7 init:)
		(if (== gPrevRoomNum 55)
			(gEgo loop: 1 posn: 307 188)
		else
			(self setScript: GoingDown)
		)
		(glow deltaX: 8 deltaY: 8 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 56 0) ; "You have come upon some stairs leading upward. You wonder where they might lead."
		)
		(if (and (& (gEgo onControl:) $0002) (== script 0))
			(self setScript: GoingUp)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 214)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look[<around,at][/room]')
					(Print 56 0) ; "You have come upon some stairs leading upward. You wonder where they might lead."
				)
				((Said 'look/passage')
					(Print 56 1) ; "The passage leads off into total darkness."
				)
				((or (Said 'look/stair,stair') (Said 'look<up'))
					(Print 56 2) ; "Stone steps lead upward."
				)
			)
		)
	)
)

(instance GoingUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 1
					setMotion: MoveTo 177 122 self
				)
			)
			(1
				(if (& [global148 3] $0200)
					(gEgo loop: 2)
					(= state 3)
					(= cycles 2)
				else
					(gEgo
						view: 26
						loop: 0
						cel: 0
						setMotion: MoveTo 173 116 self
					)
				)
			)
			(2
				(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(HandsOn)
				(gEgo setLoop: -1 cycleSpeed: -1 illegalBits: -32768)
				(client setScript: 0)
				(gCurRoom newRoom: 57)
			)
		)
	)
)

(instance GoingDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 178 116
					illegalBits: 0
					setLoop: 0
					setMotion: MoveTo 238 185 self
				)
			)
			(1
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(client setScript: 0)
			)
		)
	)
)

