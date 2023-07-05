;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room88 0
)

(local
	local0
	local1
)

(instance theMusic of Sound
	(properties)
)

(instance fallSound of Sound
	(properties
		number 52
	)
)

(instance Room88 of Rm
	(properties
		picture 88
		style 16
	)

	(method (init)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(Load rsSOUND 52)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 105 79
			setPri: 4
			init:
			addToPic:
		)
		((Prop new:)
			view: 512
			loop: 0
			posn: 107 67
			setPri: 3
			init:
			setCycle: Fwd
		)
		(= local1 0)
		(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
		(if (or (== gPrevRoomNum 93) (== gPrevRoomNum 0))
			(gEgo posn: 162 142 view: 4 looper: 0 setStep: 4 2 init:)
		)
		(if (== gPrevRoomNum 87)
			(gEgo
				posn: 91 130
				view: 4
				looper: 0
				setStep: 4 2
				illegalBits: -32760
				init:
			)
			(if global175
				((= local0 (Act new:))
					view: 141
					illegalBits: 0
					ignoreActors:
					posn: 75 129
					setStep: 6 4
					setLoop: 0
					setCycle: Walk
					init:
					setScript: henchChase88
				)
			)
		)
		(if (== gPrevRoomNum 82)
			(= local1 1)
			(gEgo
				posn: 211 62
				view: 4
				looper: myLooper
				setStep: 4 2
				illegalBits: -16384
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= (self script:) fallStairs)
				(& (gEgo onControl: 0) $0040)
			)
			(gEgo baseSetter: 0 looper: 0)
			(gCurRoom newRoom: 93)
		)
		(if
			(and
				(!= (self script:) fallStairs)
				(& (gEgo onControl: 0) $0020)
			)
			(gEgo baseSetter: 0 looper: 0)
			(gCurRoom newRoom: 82)
		)
		(if (& (gEgo onControl: 0) $0010)
			(gEgo baseSetter: 0 looper: 0)
			(gCurRoom newRoom: 87)
		)
		(if
			(and
				(not local1)
				(& (gEgo onControl: 0) $0004)
				(!= (self script:) fallStairs)
			)
			(gEgo baseSetter: 0 looper: 0)
			(self setScript: fallStairs)
		)
		(if
			(and
				local1
				(& (gEgo onControl: 0) $1000)
				(!= (self script:) fallStairs)
			)
			(gEgo baseSetter: 0 looper: 0)
			(self setScript: fallStairs)
		)
		(if (and (not local1) (& (gEgo onControl: 1) $0400))
			(gEgo illegalBits: -16384 looper: myLooper)
			(= local1 1)
		)
		(if (and local1 (& (gEgo onControl: 1) $0100))
			(gEgo illegalBits: -32760 looper: 0)
			(= local1 0)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look/room,castle,tower')
						)
						(Print 88 0) ; "These stone tower steps could be very treacherous!"
					)
					((Said 'look>')
						(cond
							((or (Said '/dirt') (Said '<down'))
								(Print 88 1) ; "There is no floor here, only stone steps."
							)
							((Said '/wall')
								(Print 88 2) ; "You see nothing of interest on the walls."
							)
							((or (Said '/sky') (Said '<up'))
								(Print 88 3) ; "You look up, but see nothing special."
							)
							((Said '/stair')
								(Print 88 4) ; "The stone stairs spiral up the dark tower."
							)
							((Said '/stair')
								(Print 88 5) ; "Watch your step on these narrow stairs!"
							)
							((Said '/door')
								(Print 88 6) ; "There is an open doorway before you."
							)
						)
					)
				)
			)
		)
	)
)

(instance myLooper of Code
	(properties)

	(method (doit param1)
		(param1
			loop:
				(cond
					((or (>= (param1 heading:) 305) (<= (param1 heading:) 45)) 2)
					((and (>= (param1 heading:) 135) (<= (param1 heading:) 225)) 3)
					((and (> (param1 heading:) 45) (< (param1 heading:) 135)) 0)
					(else 1)
				)
		)
	)
)

(instance henchChase88 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 41 play:)
				(local0
					view: 141
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
			)
			(1
				(User canControl: 0 canInput: 0)
				(gEgo moveSpeed: 0 setMotion: 0)
				(theMusic number: 42 play:)
				(= seconds 4)
			)
			(2
				(= global205 1)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

(instance fallStairs of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(= global105 16)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					view: 44
					moveSpeed: 0
					setLoop: (if (== (gEgo loop:) 1) 1 else 0)
					setCycle: End self
				)
				(fallSound play:)
			)
			(1
				(gEgo
					setStep: 10 10
					setLoop: (+ 2 (gEgo loop:))
					setCycle: Fwd
					setPri: -1
					setMotion:
						MoveTo
						(if (< (gEgo y:) 130)
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
						220
						self
				)
			)
			(2
				(gCurRoom drawPic: 93 7)
				(gCast eachElementDo: #hide)
				((View new:)
					view: 634
					loop: 1
					cel: 0
					posn: 101 75
					setPri: 4
					addToPic:
				)
				((Prop new:)
					view: 512
					loop: 0
					posn: 103 63
					setPri: 3
					init:
					setCycle: Fwd
				)
				(if global169
					((View new:)
						view: 145
						ignoreActors: 1
						loop: 4
						cel: 0
						posn: 124 128
						init:
						addToPic:
					)
				)
				(gEgo
					posn: 155 9
					show:
					setStep: 10 30
					setMotion: MoveTo 150 140 self
				)
			)
			(3
				(gEgo view: 42 loop: (if (== (gEgo loop:) 2) 0 else 1))
				(RedrawCast)
				(fallSound dispose:)
				(ShakeScreen 5)
				(= seconds 4)
			)
			(4
				(= gDeathFlag 1)
				(client setScript: 0)
			)
		)
	)
)

