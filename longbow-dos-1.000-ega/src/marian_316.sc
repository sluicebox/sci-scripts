;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 316)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use RTEyeCycle)
(use Motion)
(use Actor)
(use System)

(public
	marian 0
)

(local
	local0
	[local1 13] = [1316 4 1 2 1 2 1 2 1 2 1 2 0]
	[local14 4] = [1316 15 2 0]
	[local18 4] = [1316 16 2 0]
	[local22 4] = [1316 17 2 0]
	local26
)

(instance marian of Actor
	(properties
		view 270
		cycleSpeed 10
		moveSpeed 10
	)

	(method (init)
		(super init:)
		(if (not (Fair mY:))
			(= global198 320)
		)
		(self setCycle: Walk cue:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					((gCurRoom script:)
						(super doVerb: theVerb &rest)
					)
					((> (gEgo distanceTo: marian) 40)
						(Say 1311 0) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					(else
						(HandsOff)
						(self setLoop: -1 species 0 setMotion: 0)
						(gCurRoom setScript: sTalkMarian)
					)
				)
			)
			(3 ; Do
				(if (> (gEgo distanceTo: marian) 40)
					(Say 1311 1) ; "I must get closer to do that."
				else
					(Say 1316 3) ; "It would be most unseemly for a common yeoman to lay hands upon such a Lady."
				)
			)
			(4 ; Inventory
				(if (> (gEgo distanceTo: marian) 40)
					(Say 1311 1) ; "I must get closer to do that."
				else
					(switch invItem
						(17 ; handScroll
							(Converse @local22 999 21 0 1) ; "Sir, you are most forward. Please leave me alone."
						)
						(0 ; bucks
							(Converse @local18 999 21 0 1) ; "Sir, how dare you offer money to a Lady!"
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			(2 ; Look
				(if (not local0)
					(= local0 1)
					(Say 1316 0 1) ; "She's a lovely, shy lass."
				else
					(Say 1316 2 1) ; "'Tis Marian."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(Fair mX: x)
		(Fair mY: y)
		(super delete:)
		(DisposeScript 316)
	)

	(method (cue &tmp temp0 temp1 temp2)
		(= temp1 (Fair mX:))
		(= temp2 (Fair mY:))
		(if (or temp1 temp2)
			(= temp0 global198)
			(Fair mX: 0 mY: 0)
		else
			(= temp0 (-= global198 10))
		)
		(switch temp0
			(310
				(= local26 46)
			)
			(300
				(= local26 51)
			)
			(290
				(= local26 60)
			)
			(280
				(= local26 60)
			)
			(else
				(self dispose:)
				(return)
			)
		)
		(self
			setLoop: 1
			setCycle: Walk
			x: (if temp1 temp1 else 318)
			y: local26
			z: (if (== global198 gCurRoomNum) 0 else 1000)
			setMotion: MoveTo 3 local26 self
		)
	)
)

(instance sTalkMarian of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(Face marian gEgo)
				(Face gEgo marian)
				(= ticks 20)
			)
			(2
				(if (IsFlag 197)
					(Converse @local14 999 21 self 1) ; "Sir, I shall not speak any more with you. It isn't proper."
				else
					(Converse @local1 999 21 self 1) ; "Good day, m'Lady."
					(SetFlag 197)
				)
			)
			(3
				(HandsOn)
				(marian
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 3 local26 marian
				)
				(self dispose:)
			)
		)
	)
)

