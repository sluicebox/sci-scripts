;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use servent)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
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
)

(procedure (localproc_0)
	(Gloria stopUpd:)
	(Wilbur loop: 2 setCycle: Fwd)
	(Print &rest #at 80 15 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_1)
	(Wilbur stopUpd:)
	(Gloria setCycle: Fwd)
	(Print &rest #at 160 15 #font 4 #width 125 #mode 1 #dispose)
)

(instance Jeeves of servent
	(properties)
)

(instance wilbRead of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsFONT 4 41)
		(LoadMany rsVIEW 642 907)
		(LoadMany rsSOUND 29 94 95 96)
		(LoadMany rsMESSAGE 243 219 406)
		(= global208 128)
		(= [global377 7] 219)
		(Wilbur init: stopUpd: setScript: reading)
		(cond
			((and (> [gCycleTimers 2] 1) (== global199 1))
				(= [gCycleTimers 2] 0)
				(Load rsVIEW 361)
				(if (== gPrevRoomNum 33)
					(gEgo posn: (gEgo x:) 145)
					(Gloria posn: 290 151)
				)
				(Gloria init: setScript: wilbGlor)
				(= global199 2)
			)
			((not (& global194 $0008))
				(|= global194 $0008)
				(Jeeves
					view: 444
					posn: 320 150
					setCycle: Walk
					guest1: Wilbur
					exitX: 340
					exitY: 150
					itemX: 197
					itemY: 149
					setAvoider: ((Avoid new:) offScreenOK: 1)
					init:
				)
				(= global167 1)
			)
		)
		(gEgo observeBlocks: WilburBlock)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/c>')
					(cond
						((Said 'listen')
							(Print 220 0) ; "He's not talking."
						)
						((Said 'talk')
							(= global213 8)
							(switch local0
								(0
									(Say 1 220 1) ; "Ah, so you're Lillian's friend...Laura, is it? You look very nice, Laura; very nice, indeed."
									(= global213 12)
									(Say 0 220 2) ; "Dirty old man!"
								)
								(1
									(Say 1 220 3) ; "Ah, my dear. Come a little closer; I don't hear well."
									(= global213 12)
									(Say 0 220 4) ; "Not on your life!"
								)
								(2
									(Say 1 220 5) ; "You're very pretty, my dear. Now, don't be afraid."
									(= global213 12)
									(Say 0 220 6) ; "Afraid, you're not. Leery, yes."
								)
								(3
									(Print 220 7) ; "Giving up on you, Wilbur goes back to his reading."
								)
								(else
									(Print 220 8) ; "Wilbur's reading his magazine."
								)
							)
							(++ local0)
						)
					)
				)
				((Said '/magazine>')
					(cond
						((Said 'get,rob')
							(Print 220 9) ; "Wilbur's reading it right now!"
						)
						((Said 'look,read')
							(if (< (gEgo distanceTo: Wilbur) 20)
								(SetFlag 17)
								(Print 220 10) ; "You look over Wilbur's shoulder at the magazine and see pictures of racehorses."
							else
								(Print 220 11) ; "Wilbur is reading a magazine, but you're not close enough to see it."
							)
						)
					)
				)
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Wilbur loop: (if local1 5 else 0) setCycle: End self)
			)
			(1
				(= temp0 (Random 1 100))
				(cond
					(local1
						(cond
							((< temp0 43)
								(= state 2)
							)
							((> temp0 56)
								(= state 5)
							)
							(else
								(= state -1)
							)
						)
					)
					((< temp0 51)
						(= state -1)
					)
				)
				(= seconds (Random 5 10))
			)
			(2
				(= local1 1)
				(Wilbur loop: 4 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
				(= state 0)
			)
			(3
				(Wilbur loop: 6 cel: 0 setCycle: End self)
			)
			(4
				(Wilbur loop: 7 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(Wilbur loop: 6 cel: 3 setCycle: Beg self)
				(= state 0)
			)
			(6
				(= local1 0)
				(Wilbur loop: 4 cel: 4 setCycle: End self)
				(= state 0)
			)
		)
	)
)

(instance wilbGlor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 24)
				(Gloria setCycle: Walk setMotion: MoveTo 218 142 self)
			)
			(1
				(Wilbur loop: 1 cel: 0 setCycle: End)
				(Gloria view: 361 loop: 2)
				(localproc_1 220 12) ; "I want to warn you, Wilbur! Don't you dare go spilling the beans on me!"
				(= seconds 7)
			)
			(2
				(cls)
				(localproc_0 220 13) ; "I wouldn't do a thing like that, sweetie pie."
				(= seconds 7)
			)
			(3
				(cls)
				(localproc_1 220 14) ; "My little medical problem was my own business and nobody ELSE'S! See to it you keep quiet!"
				(= seconds 7)
			)
			(4
				(cls)
				(localproc_0 220 15) ; "Sure thing. Whatever you say."
				(= seconds 5)
			)
			(5
				(cls)
				(localproc_1 220 16) ; "Fine!"
				(= seconds 2)
			)
			(6
				(cls)
				(Gloria view: 360 setMotion: MoveTo 340 152 self)
				(Wilbur loop: 1 cel: 1 setCycle: Beg)
			)
			(7
				(HandsOn)
				(Wilbur setScript: reading)
				(Gloria dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance Wilbur of Act
	(properties
		y 142
		x 196
		view 424
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
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
				(Print 220 17) ; "Wilbur seems to be very interested in that magazine!"
			)
		)
	)
)

(instance WilburBlock of Blk
	(properties
		top 138
		left 196
		bottom 142
		right 204
	)
)

(instance Gloria of Act
	(properties
		y 150
		x 310
		view 360
		loop 1
	)
)

