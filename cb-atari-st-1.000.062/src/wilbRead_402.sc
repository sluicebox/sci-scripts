;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	wilbRead 0
)

(synonyms
	(c person man)
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(gCast eachElementDo: #hide)
	(DrawPic 992 6 1 0)
)

(procedure (localproc_1)
	(DrawPic 32 7 1 0)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
)

(instance wilbRead of Rgn
	(properties)

	(method (init)
		(super init:)
		(= local3 0)
		(cond
			((>= gClarenceWilburState 4)
				(if (not (& gMustDos $0008))
					(LoadMany rsSOUND 29 94 95 96)
					(Load rsSCRIPT 406)
					(Load rsFONT 41)
				)
				(LoadMany rsVIEW 420 642 907)
				(LoadMany rsMESSAGE 243 247)
				(= global208 128)
				(= [global377 7] 247)
				(Wilbur posn: 196 139 init: stopUpd:)
				(self setScript: reading)
				(gEgo observeBlocks: WilburBlock)
			)
			((== gClarenceWilburState 2)
				(LoadMany rsVIEW 400 420)
				(Wilbur view: 420 posn: 190 148 init: setScript: walkThru)
				(Clarence view: 400 init:)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/c>')
					(cond
						((Said 'listen')
							(Print 402 0) ; "He's not talking."
						)
						((Said 'talk')
							(= global213 8)
							(switch local0
								(0
									(Say 1 402 1) ; "Ah, so you're Lillian's friend...Laura, is it? You look very nice, Laura; very nice, indeed."
									(= global213 12)
									(Say 0 402 2) ; "Dirty old man!"
								)
								(1
									(Say 1 402 3) ; "Ah, my dear. Come a little closer; I don't hear well."
									(= global213 12)
									(Say 0 402 4) ; "Not on your life!"
								)
								(2
									(Say 1 402 5) ; "You're very pretty, my dear. Now, don't be afraid."
									(= global213 12)
									(Say 0 402 6) ; "Afraid, you're not. Leery, yes."
								)
								(3
									(Print 402 7) ; "Giving up on you, Wilbur goes back to his reading."
								)
								(else
									(Print 402 8) ; "Wilbur's reading his magazine."
								)
							)
							(++ local0)
						)
					)
				)
				((Said '/magazine>')
					(cond
						((Said 'read')
							(Print 402 9) ; "You can't read it. Wilbur's in the way."
						)
						((Said 'get,rob')
							(Print 402 10) ; "Wilbur's reading it right now!"
						)
						((Said 'look')
							(if (< (gEgo distanceTo: Wilbur) 40)
								(SetFlag 17)
								(Print 402 11) ; "You look over Wilbur's shoulder at the magazine and see pictures of racehorses."
							else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
			)
		)
	)
)

(instance walkThru of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gClarenceWilburState 3)
				(= cycles 2)
			)
			(1
				(HandsOff)
				(User canControl: 1)
				(Print 402 12 #dispose) ; "Come on. Let's go to the dining room."
				(= local1 1)
				(Clarence setCycle: Walk setMotion: MoveTo 380 149)
				(Wilbur setCycle: Walk setMotion: MoveTo 360 148 self)
			)
			(2
				(cls)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (doit)
		(if (== local3 5)
			(client setScript: 0)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Wilbur loop: (if local2 5 else 0) setCycle: End self)
			)
			(2
				(= temp0 (Random 1 100))
				(cond
					(local2
						(cond
							((< temp0 43)
								(= state 3)
							)
							((> temp0 56)
								(= state 6)
							)
							(else
								(= state 0)
							)
						)
					)
					((< temp0 51)
						(= state 0)
					)
				)
				(= seconds (Random 5 10))
			)
			(3
				(= local2 1)
				(Wilbur loop: 4 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
				(= state 1)
			)
			(4
				(Wilbur loop: 6 cel: 0 setCycle: End self)
			)
			(5
				(Wilbur loop: 7 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(Wilbur loop: 6 cel: 3 setCycle: Beg self)
				(= state 1)
			)
			(7
				(= local2 0)
				(Wilbur loop: 4 cel: 4 setCycle: End self)
				(= state 1)
			)
		)
	)
)

(instance Wilbur of Act
	(properties
		view 424
		illegalBits 0
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and (IsFlag 51) (Said 'tell[/c]/gertie<about'))
				(if (>= gClarenceWilburState 4)
					(= global213 8)
					(if (& gCorpseFlags $0001) ; Gertie
						(cond
							((& global145 $0004)
								(Say 1 402 13) ; "Come now! You tricked me once, you'll not do it again!"
							)
							((& (gEgo onControl: 1) $0028)
								(Print 402 14) ; "Wilbur must not have heard you. Move closer and try again."
							)
							(else
								(HandsOff)
								(|= global145 $0004)
								(Wilbur setScript: 0)
								(= local3 5)
								(wilbRead setScript: goSee)
							)
						)
					else
						(Say 1 402 15) ; "I'm really not interested in what Gertie's doing."
					)
				else
					(Print 402 16) ; "Wilbur and Clarence seem to just want to get away from you."
				)
			)
			((and (MousedOn self event 3) (not (& global207 $0080)))
				(event claimed: 1)
				(DoLook {wilbur})
			)
			(
				(and
					(& global207 $0080)
					(or (MousedOn self event 3) (Said 'look/c'))
				)
				(event claimed: 1)
				(Print 402 17) ; "Wilbur seems to be very interested in that magazine!"
			)
		)
	)
)

(instance WilburBlock of Blk
	(properties
		top 135
		left 196
		bottom 139
		right 204
	)
)

(instance Clarence of Act
	(properties
		y 149
		x 216
		view 402
	)
)

(instance Book of Prop
	(properties
		y 116
		x 176
		view 132
		loop 1
		cel 5
		priority 11
		signal 16
	)
)

(instance Chair of Prop
	(properties
		y 139
		x 196
		view 132
		loop 1
		cel 2
	)
)

(instance goSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global190 1)
				(Say 1 402 18) ; "Oh, no! I'd better go check on that!"
				(Wilbur loop: 8 cel: 0 setCycle: End self)
				(if (gEgo inRect: 176 140 213 150)
					(gEgo setMotion: MoveTo 185 155)
				)
			)
			(1
				(Book init:)
				(Wilbur loop: 9 cel: 0 setCycle: End self)
			)
			(2
				(Chair init: stopUpd:)
				(Wilbur
					posn: 196 141
					view: 420
					illegalBits: -32768
					loop: 2
					cel: 0
					cycleSpeed: 0
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 340 150 self
				)
				(gEgo loop: 0)
			)
			(3
				(= global190 1)
				(= seconds 5)
				(localproc_0)
				(Chair ignoreActors: 1)
			)
			(4
				(localproc_1)
				(Print 402 19 #dispose) ; "A short time later..."
				(Chair startUpd:)
				(Wilbur setMotion: MoveTo 196 140 self)
				(= global190 0)
			)
			(5
				(cls)
				(Chair dispose:)
				(= global213 8)
				(Say 1 402 20) ; "You're crazy, girl! Gertie's not there!"
				(Wilbur
					view: 424
					illegalBits: 0
					posn: 196 139
					loop: 9
					cel: 4
					setAvoider: 0
				)
				(if (== (gEgo x:) 185)
					(gEgo loop: 3)
				)
				(= cycles 1)
			)
			(6
				(Wilbur setCycle: Beg self)
			)
			(7
				(DisposeScript 985)
				(Book dispose:)
				(Wilbur loop: 8 cel: 5 setCycle: Beg self)
			)
			(8
				(= global190 0)
				(= local3 0)
				(HandsOn)
				(wilbRead setScript: reading)
			)
		)
	)
)

