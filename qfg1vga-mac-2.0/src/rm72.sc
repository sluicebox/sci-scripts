;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Rev)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm72 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance twister of Actor
	(properties)

	(method (init)
		(super init:)
	)
)

(instance tumbler of Actor
	(properties)

	(method (init)
		(super init:)
	)
)

(instance swimmer1 of Actor
	(properties)

	(method (init)
		(super init:)
	)
)

(instance swimmer2 of Actor
	(properties)

	(method (init)
		(super init:)
	)
)

(instance rm72 of EncRoom
	(properties
		picture 700
		style 8
		horizon 62
		encChance 15
	)

	(method (dispose)
		(twister setCycle: 0)
		(SetFlag 62)
		(super dispose:)
	)

	(method (doVerb)
		(return 0)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init: &rest)
		(SL enable:)
		(NormalEgo)
		(if gNight
			(if (IsFlag 164)
				(switch (Random 1 2)
					(1
						(twister init: modNum: 63 setScript: twistIt)
					)
					(2
						(tumbler init: modNum: 63 setScript: spinAcross)
					)
				)
			else
				(switch (Random 1 3)
					(1
						(twister view: 64 init: modNum: 63 setScript: twistIt)
					)
					(2
						(tumbler
							view: 64
							init:
							modNum: 63
							setScript: spinAcross
						)
					)
					(3
						(swimmer1
							view: 64
							init:
							hide:
							modNum: 63
							setScript: swimLeft
						)
						(swimmer2
							view: 64
							init:
							hide:
							modNum: 63
							setScript: swimRight
						)
					)
				)
			)
		else
			(self encChance: 15)
		)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance twistIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(twister
					view: 64
					setLoop: 6
					setPri: 12
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 155 -10
					cycleSpeed: 6
					setCycle: Fwd
					startUpd:
					noun: 3
					setMotion: MoveTo 200 120 self
				)
				(= local0 (twister x:))
				(= local1 (twister y:))
			)
			(1
				(= local2 local0)
				(= local3 local1)
				(= local0 (Random 20 300))
				(= local1 (Random 10 130))
				(twister setCycle: (if (> local0 local2) Fwd else Rev))
				(if (IsFlag 164)
					(twister setMotion: Follow gEgo 30)
				else
					(twister setMotion: MoveTo local0 local1 self)
				)
			)
			(2
				(if
					(or
						(< (twister x:) 30)
						(> (twister x:) 290)
						(< (twister y:) 20)
					)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(twister
					setMotion:
						MoveTo
						(cond
							((< (twister y:) 20)
								(twister x:)
							)
							((< (twister x:) 30) -30)
							((> (twister x:) 290) 350)
						)
						(if (< (twister y:) 20)
							-30
						else
							(twister y:)
						)
						self
				)
			)
			(4
				(-- global272)
				(twister stopUpd: setScript: 0)
			)
		)
	)
)

(instance spinAcross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					view: 64
					setLoop: 4
					setPri: 7
					setStep: 5 3
					cycleSpeed: 6
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: -15 (Random 40 110)
					setCycle: Fwd
					noun: 2
					startUpd:
				)
				(if (IsFlag 164)
					(tumbler setMotion: Follow gEgo 30)
				else
					(tumbler setMotion: MoveTo 345 (Random 20 100) self)
				)
			)
			(1
				(-- global272)
				(tumbler stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer1
					view: 64
					setLoop: 7
					posn: 7 125
					show:
					setStep: 3 2
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					cycleSpeed: 6
					setCycle: Fwd
					noun: 1
					startUpd:
				)
				(swimmer1 setMotion: MoveTo 7 98 self)
			)
			(1
				(= ticks (Random 20 80))
			)
			(2
				(swimmer1 setMotion: MoveTo 7 125 self)
			)
			(3
				(= ticks (Random 20 80))
			)
			(4
				(swimmer1 setMotion: MoveTo 7 98 self)
			)
			(5
				(= ticks (Random 20 80))
			)
			(6
				(swimmer1 setMotion: MoveTo 7 125 self)
			)
			(7
				(-- global272)
				(swimmer1 hide: stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer2
					view: 64
					setLoop: 7
					posn: 260 141
					show:
					setStep: 3 2
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					cycleSpeed: 6
					setCycle: Fwd
					noun: 1
					startUpd:
				)
				(swimmer2 setMotion: MoveTo 260 165 self)
			)
			(1
				(= ticks (Random 20 60))
			)
			(2
				(swimmer2 setMotion: MoveTo 260 141 self)
			)
			(3
				(= ticks (Random 20 60))
			)
			(4
				(swimmer2 setMotion: MoveTo 260 165 self)
			)
			(5
				(= ticks (Random 20 60))
			)
			(6
				(swimmer2 setMotion: MoveTo 260 141 self)
			)
			(7
				(= ticks (Random 20 60))
			)
			(8
				(swimmer2 setMotion: MoveTo 260 165 self)
			)
			(9
				(-- global272)
				(swimmer2 hide: stopUpd: setScript: 0)
			)
		)
	)
)

