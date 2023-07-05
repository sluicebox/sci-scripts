;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use HighLite)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room55 0
)

(synonyms
	(room room passage)
)

(local
	[local0 80] = [2 35 131 5 3 72 128 5 1 80 132 5 2 87 129 5 3 140 130 5 1 187 130 5 2 242 131 5 1 270 132 5 0 80 132 4 0 254 132 4 1 42 130 4 3 83 131 5 2 89 131 5 2 143 130 5 1 175 132 5 3 208 129 5 2 270 132 5 0 56 132 4 0 160 132 4 0 255 132 4]
	local80 = 1
	[local81 2]
)

(instance Room55 of Rm
	(properties
		picture 55
	)

	(method (init &tmp [temp0 10] temp10 temp11)
		(= horizon 0)
		(if (== global189 51)
			(= east 51)
			(= west 52)
		else
			(= east 52)
			(= west 56)
		)
		(super init:)
		(self setRegions: 242) ; tunnelReg
		(moodMusic play:)
		(if (or (and (== gPrevRoomNum 52) (== global189 51)) (== gPrevRoomNum 56))
			(gEgo x: 1 setPri: -1)
		else
			(gEgo x: 310)
		)
		(gEgo y: 136 view: 15 xStep: 2 init:)
		(eyes
			illegalBits: 0
			ignoreActors: 1
			setScript: ShowEyes
			setPri: 15
			setCycle: Fwd
			init:
			hide:
		)
		(glow deltaX: 6 deltaY: 2 eyesID: eyes init:)
		(= [temp0 0] rock1)
		(= [temp0 1] rock2)
		(= [temp0 2] rock3)
		(= [temp0 3] rock4)
		(= [temp0 4] rock5)
		(= [temp0 5] rock6)
		(= [temp0 6] rock7)
		(= [temp0 7] timber1)
		(= [temp0 8] timber2)
		(= [temp0 9] rockTim)
		(if (== global189 51)
			(= temp11 -1)
		else
			(= temp11 39)
		)
		(for ((= temp10 0)) (< temp10 10) ((++ temp10))
			([temp0 temp10]
				view: 155
				loop: [local0 (++ temp11)]
				posn: [local0 (++ temp11)] [local0 (++ temp11)]
				setPri: [local0 (++ temp11)]
				init:
				stopUpd:
				hide:
			)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 55 0) ; "This looks like an underground passage of some sort. Boy, it sure is dark down here! The sudden sound of scurrying rats causes your heart to begin beating wildly."
		)
		(if
			(eyes
				inRect:
					(glow nsLeft:)
					(glow nsTop:)
					(glow nsRight:)
					(glow nsBottom:)
			)
			(eyes hide:)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 214)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gEgo xStep: 3)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (and (== (event type:) evSAID) (Said 'look[<around,at][/room]'))
			(Print 55 0) ; "This looks like an underground passage of some sort. Boy, it sure is dark down here! The sudden sound of scurrying rats causes your heart to begin beating wildly."
		)
	)
)

(instance ShowEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local80
					(eyes
						loop: (Random 4 6)
						cel: 0
						posn: (Random 10 310) (Random 95 134)
					)
					(if
						(not
							(eyes
								inRect:
									(glow nsLeft:)
									(glow nsTop:)
									(glow nsRight:)
									(glow nsBottom:)
							)
						)
						(eyes show:)
						(^= local80 $0001)
						(= seconds (Random 2 3))
					else
						(= cycles 1)
					)
				else
					(eyes hide:)
					(^= local80 $0001)
					(= seconds (Random 1 2))
				)
				(= state -1)
			)
		)
	)
)

(instance glow of HighLite
	(properties)
)

(instance rock1 of Prop
	(properties)
)

(instance rock2 of Prop
	(properties)
)

(instance rock3 of Prop
	(properties)
)

(instance rock4 of Prop
	(properties)
)

(instance rock5 of Prop
	(properties)
)

(instance rock6 of Prop
	(properties)
)

(instance rock7 of Prop
	(properties)
)

(instance timber1 of Prop
	(properties)
)

(instance timber2 of Prop
	(properties)
)

(instance rockTim of Prop
	(properties)
)

(instance moodMusic of Sound
	(properties
		number 61
		loop -1
	)
)

(instance eyes of Act
	(properties
		view 155
		cycleSpeed 2
	)

	(method (handleEvent event)
		(cond
			((Said '/mouse>')
				(cond
					((Said 'look')
						(Print 55 1) ; "Your skin crawls each time you see one of the small furry shapes scurry across the floor!"
					)
					((Said 'get,capture')
						(Print 55 2) ; "What a revolting thought!"
					)
					((Said 'kill')
						(Print 55 3) ; "Don't worry about the rats."
					)
				)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {eye})
			)
		)
	)
)

