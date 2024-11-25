;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
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
	Room85 0
)

(local
	local0
)

(instance Room85 of Rm
	(properties
		picture 85
		style 16
	)

	(method (init)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		((View new:)
			view: 634
			loop: 1
			cel: 1
			posn: 223 164
			setPri: 12
			addToPic:
		)
		((Prop new:)
			view: 512
			loop: 0
			cel: 4
			posn: 223 152
			setPri: 11
			init:
			setCycle: Fwd
		)
		(if (or (== gPrevRoomNum 90) (== gPrevRoomNum 0))
			(gEgo
				posn: 117 170
				view: 4
				baseSetter: (ScriptID 0 1) ; smallBase
				setStep: 4 1
				init:
			)
		)
		(if (== gPrevRoomNum 81)
			(gEgo
				posn: 131 36
				view: 4
				baseSetter: (ScriptID 0 1) ; smallBase
				looper: myLooper
				setLoop: -1
				setStep: 4 1
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo baseSetter: 0 looper: 0)
			(gCurRoom newRoom: 90)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gEgo baseSetter: 0 looper: 0)
			(gCurRoom newRoom: 81)
		)
		(if (and (& (gEgo onControl:) $0004) (!= (self script:) fallStairs))
			(self setScript: fallStairs)
		)
		(cond
			((& (gEgo onControl: 0) $0002)
				(gEgo looper: myLooper)
			)
			((> (gEgo y:) 110)
				(gEgo looper: 0)
			)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
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
							(Said 'look/room,tower,castle')
						)
						(Print 85 0) ; "These stone tower steps could be very treacherous!"
					)
					((Said 'look>')
						(cond
							((or (Said '/dirt') (Said '<down'))
								(Print 85 1) ; "There is no floor here; only stone steps."
							)
							((or (Said '/sky') (Said '<up'))
								(Print 85 2) ; "You look up, but see nothing special."
							)
							((Said '/stair')
								(Print 85 3) ; "The stone stairs spiral up the dark tower."
							)
							((Said '/stair')
								(Print 85 4) ; "Watch your step on these narrow stairs!"
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

(instance fallStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(= global105 16)
				(gEgo
					view: 44
					illegalBits: 0
					ignoreActors: 1
					moveSpeed: 0
					setLoop: (if (== (gEgo loop:) 1) 1 else 0)
					setCycle: End self
				)
				((= local0 (Sound new:)) number: 52 loop: 1 play:)
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
							(- (gEgo x:) 20)
						else
							(+ (gEgo x:) 10)
						)
						220
						self
				)
			)
			(2
				(gCast eachElementDo: #hide)
				(DrawPic 90)
				((View new:)
					view: 634
					loop: 1
					cel: 1
					posn: 209 78
					setPri: 4
					addToPic:
				)
				((Prop new:)
					view: 512
					loop: 0
					posn: 209 66
					setPri: 3
					init:
					setCycle: Fwd
				)
				(if gLolotteAlive
					((View new:)
						view: 145
						ignoreActors: 1
						loop: 4
						cel: 0
						posn: 188 128
						init:
						addToPic:
					)
				)
				(gEgo
					show:
					posn: 190 10
					setStep: 10 30
					setMotion: MoveTo 190 147 self
				)
			)
			(3
				(gEgo view: 42 loop: (if (== (gEgo loop:) 2) 0 else 1))
				(RedrawCast)
				(local0 dispose:)
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

