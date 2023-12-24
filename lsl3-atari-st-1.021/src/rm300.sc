;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	seenMsg
	[unused 301]
)

(instance rm300 of Rm
	(properties
		picture 300
		east 220
	)

	(method (init)
		(super init:)
		(gAddToPics add: atpSign doit:)
		(aSpout init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(if (== gPrevRoomNum 360)
			(gEgo posn: 155 190 setPri: 4 setLoop: 2)
			(RoomScript changeState: 1)
			(if (and gEgoIsHunk (not (TestFlag 10)) (not (TestFlag 8)))
				(SetFlag 53) ; missedBambi
			)
		else
			(gEgo posn: 318 184 loop: 1)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $4000)
			(cond
				((== gEgoState 0)
					(= gEgoState 300)
					(self changeState: 4)
				)
				((== gEgoState 301))
				((not seenMsg)
					(= seenMsg 1)
					(Print 300 0) ; "You can't enter "Fat City" dressed like that!"
				)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(cond
				((Said '/fish')
					(Print 300 1) ; "Fat City has an entrance ramp disguised as a whale. Doesn't it remind you of "The Louvre?""
				)
				((Said '/awning')
					(Print 300 2) ; "It says "Fat City!""
				)
				((Said '/panties')
					(Print 300 3) ; "This is no fish tale!"
				)
				((Said '/eye')
					(Print 300 4) ; "Are those cleverly disguised television cameras?"
				)
				((Said '/lip')
					(Print 300 5) ; "What a clever doorway! Fat City's entrance ramp leads down to its lower-level lobby."
				)
				((Said '/dicklicker')
					(Print 300 6) ; "Perhaps you should get closer..."
				)
				((Said '/spout')
					(Print 300 7) ; "That's some spout!"
				)
				((Said '[/area]')
					(Print 300 8) ; "Ahead of you lies "Fat City," the island's famous health spa. Is that symbolism, or what?"
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(= gEgoState 301)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 160 self)
			)
			(2
				(gEgo setMotion: MoveTo 155 164 self)
			)
			(3
				(= gEgoState 0)
				(NormalEgo)
			)
			(4
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri: 4
					setLoop: 3
					setMotion: MoveTo (gEgo x:) 200 self
				)
			)
			(5
				(= gEgoState 0)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 110
		x 62
		view 300
		priority 7
		signal 16384
	)
)

(instance aSpout of Prop
	(properties
		y 56
		x 157
		view 300
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)

