;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 261)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TargActor)
(use rm260)
(use Motion)
(use Actor)
(use System)

(public
	getUpS 1
	hideInCornerS 2
	initRugs 3
	getOutS 4
	hideInWardrobeS 5
)

(local
	doorL
)

(procedure (initRugs)
	(InitAddToPics smallRug bigRug)
	(if (not (IsFlag 57)) ; fStoleTeapot
		(teapot init: stopUpd:)
	)
	(doorR init: stopUpd:)
	((= doorL (doorR new:)) loop: 1 posn: 141 103 init: stopUpd:)
)

(instance oilHingesS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (+ (gEgo x:) 10) 113 self)
			)
			(1
				(gEgo setMotion: MoveTo 189 110 self)
			)
			(2
				(gEgo view: 47 loop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(3
				(= cycles 14)
			)
			(4
				(NormalEgo)
				(gEgo setMotion: MoveTo 135 110 self)
			)
			(5
				(gEgo view: 47 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(6
				(= cycles 14)
			)
			(7
				(SetFlag 60) ; fHingesOiled
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance getUpS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontMove 0)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gEgo setMotion: MoveTo 280 176 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance hideInCornerS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 305 180 self)
				(gCurRoom notify: 1)
			)
			(1
				(gCurRoom notify: 2)
				(gEgo view: 47 cel: 0 setCycle: End self)
			)
			(2
				(DontMove 1)
				(self dispose:)
			)
		)
	)
)

(instance getTeapotS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 0 134 84 290)
					(gEgo setMotion: MoveTo 85 133 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 99 114 self)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(SolvePuzzle 702 3 2)
				(SkillUsed 14 -50) ; honor
				(gEgo get: 53) ; Teapot
				(SetFlag 57) ; fStoleTeapot
				(SetFlag 13) ; fMoneyDone
				(teapot dispose:)
				(HighPrint 261 0) ; "You take the tea service and stash it away."
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance smallRug of PicView
	(properties
		x 31
		y 178
		noun '[<at]/carpet[<little,blue]'
		description {the small rug}
		lookStr {The small rug has an interesting pattern but not enough value to be worth lugging around.}
		view 260
		priority 2
		signal 16400
	)
)

(instance bigRug of PicView
	(properties
		x 213
		y 150
		view 260
		loop 2
		priority 1
		signal 16400
	)
)

(instance hideInWardrobeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 162 111 self)
			)
			(1
				(gCurRoom notify: 4)
				(if (doorL cel:)
					(self changeState: 3)
				else
					(gEgo view: 261 setLoop: 2 cel: 0 setCycle: CT 2 1)
					(doorL setCycle: CT 1 1)
					(doorR setCycle: CT 1 1)
					(= cycles 4)
				)
			)
			(2
				(if (not (IsFlag 60)) ; fHingesOiled
					(HighPrint 261 1) ; "The doors are difficult to open. The hinges make a loud squeaking sound."
					(HighPrint 261 2) ; "Fortunately, nobody seems to have heard it."
				)
				(doorL setCycle: End)
				(doorR setCycle: End self)
			)
			(3
				(gEgo
					view: 261
					cel: 2
					setLoop: 2
					setCycle: End
					setStep: 2 4
					setMotion: MoveTo 162 103
				)
				(= cycles 6)
			)
			(4
				(gEgo setPri: 3)
				(doorL setCycle: Beg)
				(doorR setCycle: Beg self)
			)
			(5
				(doorL stopUpd:)
				(doorR stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance openWardrobeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 162 109 self)
			)
			(1
				(gEgo view: 261 setLoop: 2 cel: 0 setCycle: CT 1 1)
				(doorL setCycle: CT 1 1)
				(doorR setCycle: CT 1 1)
				(= cycles 4)
			)
			(2
				(if (not (IsFlag 60)) ; fHingesOiled
					(HighPrint 261 3) ; "The doors open slowly. The hinges make a loud squeaking sound."
					(HighPrint 261 2) ; "Fortunately, nobody seems to have heard it."
				)
				(doorL cycleSpeed: 2 setCycle: End)
				(doorR cycleSpeed: 2 setCycle: End self)
			)
			(3
				(NormalEgo)
				(gEgo heading: 0 loop: 3)
				(doorL stopUpd:)
				(doorR stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance spellWardrobeS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 1)
				(doorL setCycle: CT 1 1)
				(doorR setCycle: CT 1 1)
				(= cycles 4)
			)
			(1
				(if (not (IsFlag 60)) ; fHingesOiled
					(HighPrint 261 3) ; "The doors open slowly. The hinges make a loud squeaking sound."
					(HighPrint 261 2) ; "Fortunately, nobody seems to have heard it."
				)
				(doorL cycleSpeed: 2 setCycle: End)
				(doorR cycleSpeed: 2 setCycle: End self)
			)
			(2
				(doorL stopUpd:)
				(doorR stopUpd:)
				(DontTalk 0)
				(self dispose:)
			)
		)
	)
)

(instance closeWardrobeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 162 109 self)
			)
			(1
				(gEgo view: 261 setLoop: 2 cel: 0)
				(doorL setCycle: Beg)
				(doorR setCycle: Beg self)
			)
			(2
				(if (not (IsFlag 60)) ; fHingesOiled
					(HighPrint 261 4) ; "Someone really should oil those hinges."
				)
				(doorL stopUpd:)
				(doorR stopUpd:)
				(NormalEgo)
				(gEgo heading: 0 loop: 3 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance getOutS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorL setCycle: End self)
				(doorR setCycle: End)
			)
			(1
				(gEgo
					view: 261
					setPri: -1
					cel: 5
					setLoop: 2
					setCycle: CT 1 1 self
					setMotion: MoveTo 162 111
				)
			)
			(2
				(gCurRoom notify: 0)
				(gEgo posn: 162 111 cycleSpeed: 2 setCycle: Beg)
				(doorL setCycle: Beg self)
				(doorR setCycle: Beg)
			)
			(3
				(NormalEgo)
				(gEgo loop: 3 heading: 0 setMotion: MoveTo 159 116 self)
			)
			(4
				(if (not (IsFlag 60)) ; fHingesOiled
					(HighPrint 261 4) ; "Someone really should oil those hinges."
				)
				(doorL stopUpd:)
				(doorR stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance doorR of TargActor
	(properties
		x 185
		y 103
		noun '/armoire,(door[<armoire])'
		description {the wardrobe doors}
		lookStr {The wardrobe doors are beautifully carved, but the hinges look a bit rusty.}
		view 261
		signal 16384
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'grease/hinge,door,armoire') (Said 'use/grease'))
				(if (not [gInvNum 42]) ; Oil
					(HighPrint 261 5) ; "You don't have any oil."
				else
					(doorR
						lookStr:
							{The wardrobe doors are beautifully carved, but well-worn.}
					)
					(doorL
						lookStr:
							{The wardrobe doors are beautifully carved, but well-worn.}
					)
					(SolvePuzzle 706 3 2)
					(ChainScripts oilHingesS)
				)
			)
			((Said 'look,look/hinge')
				(gEgo setMotion: 0)
				(cond
					((not (and (< 131 (gEgo x:) 196) (< 124 (gEgo x:))))
						(HighPrint 261 6) ; "Get closer to the wardrobe."
					)
					((IsFlag 60) ; fHingesOiled
						(gEgo loop: 3)
						(RedrawCast)
						(HighPrint 261 7) ; "The hinges look well oiled."
					)
					(else
						(gEgo loop: 3)
						(RedrawCast)
						(HighPrint 261 8) ; "The hinges look very rusty. Someone should oil them."
					)
				)
			)
			((Said 'search/armoire')
				(cond
					(
						(or
							(== (gCurRoom notify:) 4)
							(and
								(< 150 (gEgo x:) 176)
								(< 124 (gEgo x:))
								cel
							)
						)
						(if (IsFlag 58) ; fStoleBowl
							(HighPrint 261 9) ; "You find nothing of value."
						else
							(HighPrint 261 10) ; "You find an emerald-studded silver bowl and stash it away."
							(SolvePuzzle 703 3 2)
							(SetFlag 58) ; fStoleBowl
							(SetFlag 13) ; fMoneyDone
							(SkillUsed 14 -50) ; honor
							(gEgo get: 57) ; Bowl
						)
					)
					((and (< 150 (gEgo x:) 176) (< 124 (gEgo x:)))
						(HighPrint 261 11) ; "The wardrobe's door isn't open."
					)
					(else
						(NotClose)
					)
				)
			)
			(
				(and
					(< 150 (gEgo x:) 176)
					(< 124 (gEgo x:))
					(Said 'close,close[/armoire]')
				)
				(cond
					((== cel 0)
						(HighPrint 261 12) ; "The wardrobe's doors are already closed."
					)
					((gEgo script:)
						(HighPrint 261 13) ; "You're too busy right now."
					)
					(else
						(gEgo setScript: closeWardrobeS)
					)
				)
			)
		)
	)

	(method (openMe)
		(if cel
			(AlreadyDone)
		else
			(self setScript: spellWardrobeS)
		)
	)

	(method (hurtMe)
		(EgoDead 1 261 14 #title {No Stealing Aloud!}) ; "The sound of your exploding spell alerts the old man. He calls out for his sons."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (or (== cel 0) (== (gCurRoom notify:) 4))
					(HighPrint 261 12) ; "The wardrobe's doors are already closed."
				else
					(gEgo setScript: closeWardrobeS)
				)
			)
			(2
				(cond
					((== (gCurRoom notify:) 4)
						(gEgo setScript: getOutS)
					)
					(cel
						(AlreadyDone)
					)
					((gEgo script:)
						(HighPrint 261 13) ; "You're too busy right now."
					)
					(else
						(gEgo setScript: openWardrobeS)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance teapot of TargActor
	(properties
		x 79
		y 77
		noun '/samovar,service,(pan<tea)'
		description {the silver tea service}
		lookStr {The tea service is made of silver and looks very valuable.}
		view 260
		loop 3
		priority 8
		signal 6160
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(if (IsFlag 57) ; fStoleTeapot
				(AlreadyDone)
			else
				(gEgo setScript: getTeapotS)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (fetchMe)
		(SolvePuzzle 702 3 2)
		(SkillUsed 14 -50) ; honor
		(gEgo get: 53) ; Teapot
		(SetFlag 57) ; fStoleTeapot
		(SetFlag 13) ; fMoneyDone
		(return 1)
	)
)

