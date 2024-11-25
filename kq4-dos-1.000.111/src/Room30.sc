;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room30 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance hTheme of Sound
	(properties)
)

(instance Room30 of Rm
	(properties
		picture 30
	)

	(method (newRoom newRoomNumber)
		(if (!= (gEgo view:) 80)
			(super newRoom: newRoomNumber)
		)
	)

	(method (init)
		(= north 24)
		(= east 79)
		(= west 29)
		(= horizon 85)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(if gNight
			(= picture 130)
		)
		(super init:)
		(self setRegions: 508 511) ; Forest_Region, mountReg
		(Load rsVIEW 80)
		(Load rsVIEW 17)
		(Load rsVIEW 18)
		(Load rsVIEW 21)
		(Load rsVIEW 33)
		(Load rsVIEW 60)
		(Load rsVIEW 143)
		(Load rsVIEW 144)
		(Load rsSOUND 80)
		(switch gPrevRoomNum
			(west
				(gEgo x: 2)
			)
			(24
				(gEgo posn: 112 (+ horizon 2))
			)
			(0
				(gEgo x: 183 y: 124)
			)
			(92
				(gEgo view: 80 setCycle: Fwd setScript: henchFlyIn)
				(= horizon -1000)
				(henchFlyIn changeState: 1)
			)
			(79
				(if (== (gEgo view:) 80)
					(= horizon -1000)
					(gEgo ignoreHorizon: setScript: henchFlyIn)
					(henchFlyIn changeState: 1)
				else
					(gEgo x: 318 y: 101)
				)
			)
			(else
				(gEgo x: 183 y: 124)
			)
		)
		(if (== (gEgo script:) 0)
			(gEgo view: 2 xStep: 2 yStep: 1 init:)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= (= local0 (gEgo onControl:)) local1)
				(== (gCurRoom script:) 0)
			)
			(= local1 local0)
			(cond
				((& local0 $0010)
					(self setScript: shortFall)
				)
				((& local0 $0004)
					(self setScript: deadFall)
				)
				((& local0 $0020)
					(self setScript: deadMagenta)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'climb/boulder')
					(Print 30 0) ; "You don't have the time to climb rocks."
				)
				((Said 'look>')
					(cond
						((Said '/path')
							(Print 30 1) ; "The narrow path dangerously winds its way up the steep mountains."
						)
						((Said '/boulder')
							(Print 30 2) ; "There are rocks here and there."
						)
						((Said '/goon,man,person')
							(if (gCast contains: local2)
								(Print 30 3) ; "Lolotte's goons are not appealing at all! Besides having an unnatural pallor to their skin, the goons are creepy little creatures who fly upon wings that resemble those of bats."
							else
								(Print 30 4) ; "You don't seen one here."
							)
						)
						((Said '[<around][/room]')
							(Print 30 5) ; "A mountain range rises to the east from the forest. A narrow path winds steeply up the side of it."
						)
					)
				)
			)
		)
	)
)

(instance shortFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Sound new:) number: 51 loop: 1 play:)
				(HandsOff)
				(cond
					((< (gEgo x:) 183)
						(= local5 146)
					)
					((> (gEgo x:) 195)
						(= local5 165)
					)
					(else
						(= local5 154)
					)
				)
				(gEgo
					yStep: 6
					yStep: 6
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					view: 17
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) local5 self
				)
			)
			(1
				(gEgo xStep: 2 yStep: 1 view: 18 loop: 0 setCycle: Fwd)
				(Timer setReal: self 5)
				((Sound new:) number: 80 loop: 1 play:)
			)
			(2
				(gEgo view: 21 loop: 2 cel: 4 setCycle: Beg self)
			)
			(3
				(gEgo setCycle: Walk view: 2 illegalBits: $8000)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance deadFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Sound new:) number: 51 loop: 1 play:)
				(HandsOff)
				(gEgo
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					view: 17
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) 175 self
				)
			)
			(1
				(gEgo xStep: 2 yStep: 1 view: 33 loop: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(Timer setReal: self 3)
			)
			(2
				(Print 30 6) ; "You should be more careful, Rosella!"
				(Timer setReal: self 5)
			)
			(3
				(HandsOn)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance deadMagenta of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Sound new:) number: 51 loop: 1 play:)
				(HandsOff)
				(gEgo
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					view: 17
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) 175 self
				)
			)
			(1
				(gEgo xStep: 2 yStep: 1 view: 33 loop: 0)
				(Timer setReal: self 3)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
			)
			(2
				(Print 30 6) ; "You should be more careful, Rosella!"
				(Timer setReal: self 5)
			)
			(3
				(= gDeathFlag 1)
				(HandsOn)
			)
		)
	)
)

(instance henchFlyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(hTheme number: 29 loop: 1 play:)
				(gEgo
					view: 80
					setLoop: 4
					ignoreHorizon:
					yStep: 1
					illegalBits: 0
					setPri: 12
					setCycle: Fwd
					posn: 168 -30
					init:
					setMotion: MoveTo 160 121 self
				)
			)
			(2
				(gEgo
					view: 60
					setLoop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(= local2 (Act new:))
				(= local3 (Act new:))
				(local2
					view: 144
					posn: (- (gEgo x:) 15) (gEgo y:)
					xStep: 6
					yStep: 3
					cycleSpeed: 0
					setCycle: Fwd
					setScript: h1Actions
				)
				(local3
					view: 144
					posn: (+ (gEgo x:) 15) (gEgo y:)
					xStep: 6
					yStep: 3
					cycleSpeed: 0
					setCycle: Fwd
					setScript: h2Actions
				)
			)
			(3
				(gEgo
					view: 2
					ignoreHorizon: 0
					ignoreActors: 0
					setLoop: -1
					loop: 1
					illegalBits: $8000
					setPri: -1
					cycleSpeed: 0
					setCycle: Walk
				)
				(gEgo xStep: 2 yStep: 1)
				(HandsOn)
			)
		)
	)
)

(instance h1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local2
					init:
					ignoreHorizon:
					illegalBits: 0
					setPri: 12
					setCycle: Walk
					setMotion: MoveTo 145 40 self
				)
			)
			(1
				(local2 view: 143 setMotion: MoveTo 145 -30 self)
				(= local4 1)
			)
			(2
				(gCurRoom horizon: 85)
				(local2 dispose:)
			)
		)
	)
)

(instance h2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3
					init:
					ignoreHorizon:
					illegalBits: 0
					setPri: 12
					setCycle: Walk
					setMotion: MoveTo 175 40 self
				)
			)
			(1
				(local3 view: 143 setMotion: MoveTo 175 -30 self)
			)
			(2
				(local3 dispose:)
			)
		)
	)
)

