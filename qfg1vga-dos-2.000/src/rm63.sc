;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
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
	rm63 0
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
		(= global451 164)
		(PalVary pvCHANGE_TARGET 164)
		(AssertPalette 64)
		(super init:)
	)
)

(instance tumbler of Actor
	(properties)

	(method (init)
		(= global451 164)
		(PalVary pvCHANGE_TARGET 164)
		(AssertPalette 64)
		(super init:)
	)
)

(instance swimmer1 of Actor
	(properties)

	(method (init)
		(= global451 164)
		(PalVary pvCHANGE_TARGET 164)
		(AssertPalette 64)
		(super init:)
	)
)

(instance swimmer2 of Actor
	(properties)

	(method (init)
		(= global451 164)
		(PalVary pvCHANGE_TARGET 164)
		(AssertPalette 64)
		(super init:)
	)
)

(instance rm63 of EncRoom
	(properties
		picture 701
		style 8
		horizon 58
	)

	(method (dispose)
		(= global451 0)
		(twister setCycle: 0)
		(SetFlag 53)
		(super dispose:)
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
						(twister view: 64 init: setScript: twistIt)
					)
					(2
						(tumbler view: 64 init: setScript: spinAcross)
					)
				)
			else
				(switch (Random 1 3)
					(1
						(twister view: 64 init: setScript: twistIt)
					)
					(2
						(tumbler view: 64 init: setScript: spinAcross)
					)
					(3
						(swimmer1 view: 64 init: hide: setScript: swimLeft)
						(swimmer2 view: 64 init: hide: setScript: swimRight)
					)
				)
			)
		else
			(self encChance: 15)
		)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
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
					posn: 8 124
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
				(swimmer1 setMotion: MoveTo 8 98 self)
			)
			(1
				(= ticks (Random 20 60))
			)
			(2
				(swimmer1 setMotion: MoveTo 8 124 self)
			)
			(3
				(= ticks (Random 20 60))
			)
			(4
				(swimmer1 setMotion: MoveTo 8 98 self)
			)
			(5
				(= ticks (Random 20 60))
			)
			(6
				(swimmer1 setMotion: MoveTo 8 124 self)
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
					posn: 240 124
					setPri: 9
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
				(swimmer2 setMotion: MoveTo 240 144 self)
			)
			(1
				(= ticks (Random 20 60))
			)
			(2
				(swimmer2 setMotion: MoveTo 240 124 self)
			)
			(3
				(= ticks (Random 20 60))
			)
			(4
				(swimmer2 setMotion: MoveTo 240 144 self)
			)
			(5
				(= ticks (Random 20 60))
			)
			(6
				(swimmer2 setMotion: MoveTo 240 124 self)
			)
			(7
				(= ticks (Random 20 60))
			)
			(8
				(swimmer2 setMotion: MoveTo 240 144 self)
			)
			(9
				(-- global272)
				(swimmer2 hide: stopUpd: setScript: 0)
			)
		)
	)
)

