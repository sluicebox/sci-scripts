;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Timer)
(use Avoid)
(use Motion)
(use System)

(public
	DwarfStuff 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2)
	(if (gEgo has: param1)
		(gEgo put: param1)
		(gGame changeScore: (- 0 param2))
		(return 1)
	else
		(return 0)
	)
)

(instance DwarfStuff of Script
	(properties)

	(method (init)
		(super init: &rest)
		(Print 804 0) ; "There is a small dwarf right nearby. Be careful; this sly little chap is trouble."
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(Said 'look,look/dwarf,man[<little]')
					(MousedOn gMenace event 3)
				)
				(event claimed: 1)
				(if (< state 2)
					(Print 804 1) ; "This tricky little dwarf is quite interested in you! To be exact, he would like to see what items of value you may be carrying."
				else
					(Print 804 2) ; "Looks like the dwarf is running off. Did he take anything?"
				)
			)
			((Said 'talk,talk[/dwarf]')
				(Print 804 3) ; "Talking to this dwarf is a waste of breath. He's only interested in what you've got in your pockets."
			)
			((Said 'kill,capture,hit,shoot/dwarf,man[<little]')
				(Print 804 4) ; "The dwarf is too fast for you to catch."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 1) (not local0))
			(= local0 1)
			(Print 804 5) ; "The dwarf, startled by your sudden disappearance, runs away."
			(self changeState: 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= ((ScriptID 0 21) signal:) -1) ; gameSound
					((ScriptID 0 21) loop: 1 fade:) ; gameSound
				)
				((ScriptID 0 23) number: 93 loop: -1 playBed:) ; backSound
				(switch gPrevRoomNum
					((gCurRoom east:)
						(gMenace posn: 319 141)
					)
					((gCurRoom west:)
						(gMenace posn: 1 130)
					)
					(else
						(if (Random 0 1)
							(gMenace posn: 319 141)
						else
							(gMenace posn: 1 130)
						)
					)
				)
				(gMenace
					view: 135
					setCycle: Walk
					ignoreActors:
					ignoreHorizon:
					illegalBits: $8000
					init:
					setStep: 4 3
					cycleSpeed: 0
					setAvoider: Avoid 1
					setMotion: Chase gEgo 16 self
				)
			)
			(1
				(if (IsFlag 44)
					(gMenace setMotion: 0)
					(self dispose:)
				else
					(gMenace setMotion: 0)
					(Print 804 6) ; "The sneaky little dwarf caught you by surprise. Did he steal anything from you?"
					(cond
						((localproc_0 16 8))
						((localproc_0 14 8))
						((localproc_0 1 8))
						((and (IsFlag 62) (localproc_0 11 6)) 0)
						((localproc_0 11 3) 0)
						((and (IsFlag 67) (localproc_0 18 6)) 0)
						((localproc_0 15 6) 0)
						((localproc_0 12 6) 0)
					)
					(Timer setCycle: self 2)
				)
			)
			(2
				(if (< (gEgo heading:) 180)
					(gMenace setMotion: MoveTo -20 (gMenace y:) self)
				else
					(gMenace setMotion: MoveTo 330 (gMenace y:) self)
				)
			)
			(3
				((ScriptID 0 23) stop:) ; backSound
				(if global138
					0
				else
					(gMenace dispose:)
				)
				(self dispose:)
			)
		)
	)
)

