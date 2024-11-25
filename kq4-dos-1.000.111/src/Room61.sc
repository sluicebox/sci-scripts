;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use System)

(public
	Room61 0
)

(local
	local0
)

(instance Room61 of Rm
	(properties
		picture 61
		style 16
	)

	(method (init)
		(Load rsSOUND 51)
		(Load rsVIEW 44)
		(Load rsVIEW 42)
		(Load rsPIC 66)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		(= gIndoors 1)
		(if (== gPrevRoomNum 66)
			(gEgo
				posn: 111 172
				view: 4
				loop: 0
				baseSetter: (ScriptID 0 1) ; smallBase
				xStep: 4
				yStep: 1
				setPri: 12
				illegalBits: $8000
				init:
			)
		)
		(if (== gPrevRoomNum 58)
			(gEgo
				posn: 155 45
				view: 4
				baseSetter: (ScriptID 0 1) ; smallBase
				looper: myLooper
				xStep: 4
				yStep: 1
				illegalBits: $8000
				init:
			)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 0) $0040) (== (gEgo script:) 0))
			(gEgo looper: 0)
			(gCurRoom newRoom: 66)
		)
		(if (and (& (gEgo onControl: 0) $0020) (== (gEgo script:) 0))
			(gEgo looper: 0)
			(gCurRoom newRoom: 58)
		)
		(if (and (& (gEgo onControl: 0) $0004) (== (gEgo script:) 0))
			(gEgo setScript: fallStairs)
		)
		(cond
			((& (gEgo onControl: 0) $0200)
				(gEgo looper: myLooper)
			)
			((and (> (gEgo y:) 130) (!= (gEgo script:) fallStairs))
				(gEgo looper: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (== (event type:) evSAID) (Said 'look>'))
				(cond
					((Said '/stair')
						(Print 61 0) ; "The steps in this tower are steep and narrow. Be careful!"
					)
					((Said '/dirt')
						(Print 61 1) ; "Don't look down!"
					)
					((Said '/wall')
						(Print 61 2) ; "You don't see anything of interest on the walls."
					)
					((Said '<up[/!*]')
						(Print 61 3) ; "You're almost to the top!"
					)
					((Said '<down[/!*]')
						(Print 61 1) ; "Don't look down!"
					)
					((Said '[<around][/room,tower]')
						(Print 61 4) ; "The steps spiral steeply up the stone tower of this old house."
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
					((or (>= (param1 heading:) 335) (<= (param1 heading:) 25)) 2)
					((and (>= (param1 heading:) 155) (<= (param1 heading:) 205)) 3)
					((and (> (param1 heading:) 25) (< (param1 heading:) 155)) 0)
					(else 1)
				)
		)
	)
)

(instance fallStairs of Script
	(properties)

	(method (doit)
		(if (and (== (gCurRoom picture:) 61) (> (gEgo y:) 100))
			(gEgo setPri: 14)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Print 61 5 #at -1 20 #dispose)) ; "Aaaaahhhhhhh!!"
				(User canControl: 0)
				((Sound new:) number: 51 loop: 1 play:)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(self cue:)
			)
			(1
				(gEgo view: 44 moveSpeed: 0 setPri: 13 setCycle: End self)
			)
			(2
				(gEgo
					xStep: 5
					yStep: 20
					setCycle: Fwd
					setPri: -1
					setMotion:
						MoveTo
						(if (< (gEgo y:) 130)
							(- (gEgo x:) 20)
						else
							(+ (gEgo x:) 20)
						)
						255
						self
				)
			)
			(3
				(gEgo posn: 195 10)
				(gCurRoom drawPic: 66)
				(gSounds eachElementDo: #dispose)
				((Sound new:) number: 51 loop: 1 play:)
				(gEgo setPri: -1 setMotion: MoveTo 200 137 self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo
					view: 42
					loop: (mod (gEgo loop:) 2)
					baseSetter: 0
					setPri: 3
				)
				((ScriptID 0 4) setCycle: self 1) ; timer1
			)
			(5
				(ShakeScreen 10)
				(Animate (gCast elements:) 0)
				(= seconds 4)
			)
			(6
				(= gDeathFlag 1)
			)
		)
	)
)

