;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Timer)
(use Avoid)
(use Motion)
(use System)

(public
	OgreStuff 0
)

(local
	local0
	local1
)

(instance OgreStuff of Script
	(properties)

	(method (init)
		(super init: &rest)
		(Print 803 0) ; "Suddenly you hear the heavy footfalls of an Ogre! He stomps into the clearing, spots you, and decides to crush the life out of you."
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			(
				(or
					(Said 'look,look/ogre,man[<green]')
					(MousedOn gMenace event 3)
				)
				(Print 803 1) ; "The ogre is itching to take you in his powerful arms and crush your bones!"
				(event claimed: 1)
			)
			((Said 'talk,talk[/ogre]')
				(Print 803 2) ; "Talking to this ogre is like talking to a brick wall. An ANGRY brick wall."
			)
			((Said 'hit,kill/ogre')
				(Print 803 3) ; "This Ogre is one tough character. Trying to bring harm to him would be a very bad mistake. He's got a very thick skin, and a very short temper."
			)
			((Said 'use,throw/dagger')
				(if (not (gEgo has: 0)) ; Dagger
					(Print 803 4) ; "You don't have anything to try that with."
				else
					(Print 803 5) ; "Attempting to bring harm to the ogre will do no good. He has a very thick skin, and a very short temper."
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (IsFlag 1))
		(cond
			((and (not local0) temp0)
				(= local0 1)
				(Print 803 6) ; "The ogre is confused by your sudden disappearance. Sneak away now, while you've got the chance!"
				(gMenace setMotion: 0)
			)
			((and local0 (not local1) (< (gEgo distanceTo: gMenace) 12))
				(= local1 1)
				(Print 803 7) ; "Unfortunately, you were too close to the ogre. He could sense you nearby, despite your invisibility!"
				(self changeState: 2)
			)
			((and local0 (not temp0))
				(= local0 0)
				(Print 803 8) ; "The ogre sees you again!"
				(self changeState: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= ((ScriptID 0 21) signal:) -1) ; gameSound
					((ScriptID 0 21) loop: 1 fade:) ; gameSound
				)
				((ScriptID 0 23) number: 35 loop: -1 playBed:) ; backSound
				(gMenace
					view: 130
					setAvoider: Avoid
					illegalBits: -28672
					setCycle: Walk
					cycleSpeed: 0
					init:
				)
				(switch gPrevRoomNum
					((gCurRoom west:)
						(gMenace posn: 320 155 setMotion: MoveTo 314 155 self)
					)
					((gCurRoom east:)
						(gMenace posn: -10 146 setMotion: MoveTo 10 146 self)
					)
					(else
						(if (Random 0 1)
							(gMenace
								posn: 320 160
								setMotion: MoveTo 314 155 self
							)
						else
							(gMenace
								posn: -10 146
								setMotion: MoveTo 12 146 self
							)
						)
					)
				)
			)
			(1
				(gMenace setStep: 5 3 setMotion: Chase gEgo 20 self)
			)
			(2
				(if (and (not (IsFlag 44)) (== gNewRoomNum gCurRoomNum))
					(HandsOff)
					(gMenace hide:)
					(gEgo view: 20 setMotion: 0 loop: 0 cel: 0 setCycle: Fwd)
					(if (== (gCurRoom script:) (ScriptID 782 0)) ; fiddler
						((ScriptID 782 1) stop:) ; fiddleSound
					)
					((ScriptID 0 23) stop:) ; backSound
					((ScriptID 0 21) number: 46 loop: 1 init: play: self) ; gameSound
				else
					(self changeState: 5)
				)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End)
				(gMenace
					posn: (gEgo x:) (gEgo y:)
					loop: 4
					show:
					stopUpd:
				)
				(Timer set: self 3)
			)
			(4
				((ScriptID 0 23) fade:) ; backSound
				(EgoDead {You were warned ogre and ogre again...})
			)
			(5
				(gMenace setMotion: 0)
			)
		)
	)
)

