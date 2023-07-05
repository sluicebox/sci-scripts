;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use HighLite)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room51 0
)

(synonyms
	(stair upstair)
	(room room passage)
)

(local
	local0
)

(instance glow of HighLite
	(properties)
)

(instance Room51 of Rm
	(properties
		picture 51
	)

	(method (init)
		(= horizon 0)
		(= west 55)
		(= global189 51)
		(super init:)
		(self setRegions: 242 setFeatures: trapdoor) ; tunnelReg
		(gAddToPics add: trapdoor eachElementDo: #init doit:)
		(if global137
			(if (== gPrevRoomNum 65)
				(= local0 0)
				(HandsOff)
				(gEgo
					loop: 1
					posn: 222 91
					illegalBits: 0
					setMotion: MoveTo 116 170 self
				)
			else
				(= local0 1)
				(gEgo loop: 0 y: 170)
			)
			(gEgo view: 7 xStep: 3 init:)
			(glow deltaX: 8 deltaY: 8 ignoreCast: 1 init:)
			(rat
				view: 151
				setLoop: 3
				setStep: 5 5
				illegalBits: 0
				ignoreActors: 1
				posn: 139 171
				setCycle: Walk
				init:
				setScript: Scurry
			)
		else
			(HandsOff)
			(gEgo
				view: 49
				loop: 1
				posn: 222 91
				illegalBits: 0
				init:
				setScript: tumble
			)
		)
	)

	(method (doit)
		(if (and (IsFirstTimeInRoom) global137)
			(Print 51 0) ; "This looks like an underground passage of some sort. Boy, it sure is dark down here! The sudden sound of scurrying rats causes your heart to begin beating wildly."
		)
		(if (and (not local0) (< (gEgo x:) 117))
			(= local0 1)
		)
		(if (and local0 (& (gEgo onControl: 1) $0008))
			(HandsOff)
			(gEgo illegalBits: 0 setMotion: MoveTo 244 80)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gEgo illegalBits: -32768)
			(gCurRoom newRoom: 65)
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

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '*/dinosaur')
					(Print 51 1) ; "What dinosaur? You don't see a dinosaur!"
				)
				((Said '*/bone')
					(Print 51 2) ; "What bones? You don't see any bones!"
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 51 0) ; "This looks like an underground passage of some sort. Boy, it sure is dark down here! The sudden sound of scurrying rats causes your heart to begin beating wildly."
						)
						((Said '/stair')
							(Print 51 3) ; "The steep stairs lead upward to a trapdoor."
						)
						((Said '/boulder')
							(Print 51 4) ; "The slime-coated rocks glisten in the lantern's glow."
						)
					)
				)
				((Said 'open/trapdoor')
					(Print 51 5) ; "The trapdoor is already open."
				)
				((Said 'close/trapdoor')
					(Print 51 6) ; "It would be better not to."
				)
				((Said 'climb/stair')
					(Print 51 7) ; "Just do that yourself."
				)
			)
		)
	)

	(method (cue)
		(HandsOn)
		(gEgo illegalBits: -32768)
	)
)

(instance tumble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Falling priority: 5 play:)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo
					setLoop: 3
					setCycle: Fwd
					xStep: 8
					yStep: 8
					setMotion: MoveTo 100 158 self
				)
			)
			(2
				(gEgo posn: 103 171 setLoop: 5 cel: 0 setCycle: End self)
				(ShakeScreen 5 5) ; ssUPDOWN | $0004
			)
			(3
				(= global128 49)
				(= global129 5)
				(= global130 4)
				(EgoDead 51 8) ; "It's too dark! You can't see!!"
			)
		)
	)
)

(instance Scurry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 5))
			)
			(1
				(rat setMotion: MoveTo -10 169 self)
				(ratNoise play:)
			)
			(2
				(rat dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance rat of Act
	(properties)

	(method (handleEvent event)
		(cond
			((Said '/mouse>')
				(cond
					((Said 'look')
						(if (rat mover:)
							(Print 51 9) ; "Your skin crawls each time you see one of the small furry shapes scurry across the floor!"
						else
							(NotHere) ; "You don't see it here."
						)
					)
					((Said 'get,capture')
						(if (rat mover:)
							(Print 51 10) ; "What a revolting thought!"
						else
							(NotHere) ; "You don't see it here."
						)
					)
					((Said 'kill')
						(if (rat mover:)
							(Print 51 11) ; "Don't worry about the rats."
						else
							(NotHere) ; "You don't see it here."
						)
					)
				)
			)
			((and (rat mover:) (MousedOn self event 3))
				(event claimed: 1)
				(Print 51 9) ; "Your skin crawls each time you see one of the small furry shapes scurry across the floor!"
			)
		)
	)
)

(instance Falling of Sound
	(properties
		number 70
	)
)

(instance ratNoise of Sound
	(properties
		number 58
	)
)

(instance trapdoor of RPicView
	(properties
		y 55
		x 239
		view 151
		priority 3
	)

	(method (handleEvent event)
		(if
			(or
				(MousedOn self event 3)
				(Said 'look/trapdoor')
				(Said 'look<up')
			)
			(event claimed: 1)
			(Print 51 12) ; "The trapdoor leads into the hedge garden."
		)
	)
)

