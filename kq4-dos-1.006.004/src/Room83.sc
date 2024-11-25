;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room83 0
)

(synonyms
	(room cell)
)

(local
	local0
	local1
	local2
)

(instance Room83 of Rm
	(properties
		picture 83
		style 16
	)

	(method (init)
		(Load rsVIEW 649)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 55 78
			setPri: 4
			init:
			addToPic:
		)
		((View new:)
			view: 634
			loop: 1
			cel: 1
			posn: 267 78
			setPri: 4
			init:
			addToPic:
		)
		(if gNight
			((Prop new:)
				view: 512
				loop: 0
				posn: 57 66
				setPri: 3
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 512
				loop: 0
				posn: 267 66
				setPri: 3
				init:
				setCycle: Fwd
			)
		)
		(= gIndoors 1)
		(if gNight
			((= local1 (View new:))
				view: 649
				loop: 0
				cel: 0
				posn: 162 64
				init:
				stopUpd:
			)
		)
		(if (or (== gPrevRoomNum 86) (== gPrevRoomNum 0))
			(gEgo
				posn: 156 159
				view: 4
				illegalBits: $8000
				loop: 3
				xStep: 4
				yStep: 2
				init:
			)
			(if (== gAct 0)
				(Load rsVIEW 141)
				(self setScript: takeBack)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== gAct 99) (& (gEgo onControl: 0) $0040))
			(gCurRoom newRoom: 86)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room,castle'))
						(Print 83 0) ; "You have found yourself in a HORRIBLE cell! It looks as if others have found their way here, too. Hopefully, you won't end up like them!"
					)
					((Said 'look>')
						(cond
							((Said '/skeleton,bone')
								(Print 83 1) ; "At least two unfortunate individuals have met their end here."
							)
							((Said '/machine')
								(Print 83 2) ; "An ominous machine lurks in the corner of this cell. As to its purpose; you don't want to know!"
							)
							((Said '/whip')
								(Print 83 3) ; "A whip hangs on the wall."
							)
							((Said '/chain')
								(Print 83 4) ; "The chains are securely attached to the wall."
							)
							((Said '/window')
								(Print 83 5) ; "The window is too high."
							)
							((Said '/wall')
								(Print 83 6) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 83 7) ; "There is nothing of interest on the floor."
							)
						)
					)
					((or (Said 'use,(turn<on)/machine') (Said 'turn/wheel'))
						(Print 83 8) ; "You don't know how to use this machine, and you don't EVER want to know!"
					)
					((Said 'get/whip')
						(Print 83 9) ; "The whip is securely attached to the wall. Besides, you wouldn't want it."
					)
					((Said 'get/chain')
						(Print 83 4) ; "The chains are securely attached to the wall."
					)
					((Said 'open/window')
						(Print 83 10) ; "The windows do not open."
					)
					((Said 'break/window')
						(Print 83 11) ; "That would not accomplish anything."
					)
					((Said 'open/door')
						(if (< gAct 5)
							(Print 83 12) ; "You can't. It's locked."
						else
							(Print 83 13) ; "Try just walking through the doorway."
						)
					)
					((Said 'unlatch/door')
						(if (< gAct 5)
							(Print 83 14) ; "You can't. You don't have the key."
						else
							(Print 83 15) ; "It's not locked. In fact, it's still open!"
						)
					)
					((Said 'yell,help,save')
						(Print 83 16) ; "No one is going to save you."
					)
				)
			)
		)
	)
)

(instance takeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: 0)
				(Print 83 17) ; "You hear the henchmen returning. Perhaps, they are setting you free!"
				(if (gEgo inRect: 123 142 193 180)
					(gEgo setMotion: MoveTo 150 130 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo loop: 2)
				((= local0 (Act new:))
					view: 141
					posn: 150 194
					illegalBits: 0
					ignoreActors: 1
					init:
					setCycle: Walk
					setMotion: MoveTo 150 160 self
				)
			)
			(3
				(= local2 (Print 83 18 #at -1 10 #font gSmallFont #dispose)) ; "The henchman motions you to follow him out of the cell..."
				(User canControl: 0 canInput: 0)
				(gEgo illegalBits: 0 setMotion: MoveTo 160 (gEgo y:) self)
			)
			(4
				(gEgo illegalBits: 0 setLoop: 2 setMotion: Follow local0 5)
				(self cue:)
			)
			(5
				(local0 setMotion: MoveTo 150 225 self)
			)
			(6
				(cls)
				(gEgo setLoop: -1 setAvoider: 0)
				(gCurRoom newRoom: 86)
			)
		)
	)
)

