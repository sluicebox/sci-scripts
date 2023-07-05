;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Actor)
(use System)

(public
	hookBar 0
)

(local
	local0
)

(instance hookBar of PuzzleBar
	(properties)

	(method (resetPuzzle &tmp temp0 temp1)
		((ScriptID 34 3) setCel: 2) ; pExit
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(self
				add:
					((diamond new:)
						value: temp0
						nsLeft: (= temp1 (+ 30 (* temp0 35)))
						x: temp1
						init: self
						yourself:
					)
			)
		)
		(self eachElementDo: #show)
	)

	(method (init &tmp temp0)
		(self changeCursor: 999)
		(super init: &rest)
		(hook1 init: puzzleCast)
		(hook2 init: puzzleCast)
		(hook3 init: puzzleCast)
		(hook4 init: puzzleCast)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 155
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (helpYou)
		(switch (++ local0)
			(1
				(gMessager say: 6 9 0 1) ; "You need to rotate the hooks into some set position to unlock a secret passage."
			)
			(2
				(gMessager say: 6 9 0 2) ; "Look around the room. Someone's sure to have left a note somewhere on how to solve this."
			)
			(3
				(gMessager say: 6 9 0 3) ; "Turning each of the hooks affects a different number of other hooks. Try starting with the ones that change the most other hooks and working your way down to the hook that moves independently."
			)
			(4
				(gMessager say: 6 9 0 4) ; "The Thief marks under the desk suggest the best order to rotate the hooks and where to go next. (Hint: There's nowhere to go from here but up!)"
			)
			(5
				(gMessager say: 6 9 0 5) ; "You fiddle with the hooks for a while. Finally you are rewarded by a distant "Click" as if you have unlocked a door somewhere else in the room."
				(self setScript: doAnimate 0 1)
			)
		)
	)

	(method (giveYou))
)

(instance diamond of TextIcon
	(properties
		nsTop 80
		y 80
		view 353
		loop 4
	)

	(method (select)
		(if (super select: &rest)
			(switch value
				(0
					(if (< (- (hook1 cel:) 1) 0)
						(hook1 cel: 3)
					else
						(hook1 cel: (- (hook1 cel:) 1))
					)
					(UpdateScreenItem hook1)
				)
				(1
					(if (> (+ (hook1 cel:) 1) 3)
						(hook1 cel: 0)
					else
						(hook1 cel: (+ (hook1 cel:) 1))
					)
					(if (> (+ (hook2 cel:) 1) 3)
						(hook2 cel: 0)
					else
						(hook2 cel: (+ (hook2 cel:) 1))
					)
					(if (> (+ (hook4 cel:) 1) 3)
						(hook4 cel: 0)
					else
						(hook4 cel: (+ (hook4 cel:) 1))
					)
					(UpdateScreenItem hook1)
					(UpdateScreenItem hook2)
					(UpdateScreenItem hook4)
				)
				(2
					(if (< (- (hook1 cel:) 1) 0)
						(hook1 cel: 3)
					else
						(hook1 cel: (- (hook1 cel:) 1))
					)
					(if (< (- (hook2 cel:) 1) 0)
						(hook2 cel: 3)
					else
						(hook2 cel: (- (hook2 cel:) 1))
					)
					(if (< (- (hook3 cel:) 1) 0)
						(hook3 cel: 3)
					else
						(hook3 cel: (- (hook3 cel:) 1))
					)
					(if (< (- (hook4 cel:) 1) 0)
						(hook4 cel: 3)
					else
						(hook4 cel: (- (hook4 cel:) 1))
					)
					(UpdateScreenItem hook1)
					(UpdateScreenItem hook2)
					(UpdateScreenItem hook3)
					(UpdateScreenItem hook4)
				)
				(3
					(if (> (+ (hook1 cel:) 1) 3)
						(hook1 cel: 0)
					else
						(hook1 cel: (+ (hook1 cel:) 1))
					)
					(if (> (+ (hook4 cel:) 1) 3)
						(hook4 cel: 0)
					else
						(hook4 cel: (+ (hook4 cel:) 1))
					)
					(UpdateScreenItem hook1)
					(UpdateScreenItem hook4)
				)
			)
			(hookBar setScript: doAnimate)
		)
	)
)

(instance doAnimate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hookBar noHands: 1)
				(= cycles 2)
			)
			(1
				(cond
					(
						(and
							(== (hook1 cel:) 3)
							(== (hook2 cel:) 0)
							(== (hook3 cel:) 2)
							(== (hook4 cel:) 1)
						)
						(self cue:)
					)
					(register
						(hook1 setCel: 3)
						(hook2 setCel: 0)
						(hook3 setCel: 2)
						(hook4 setCel: 1)
						(self cue:)
					)
					(else
						(hookBar noHands: 0)
						(self dispose:)
					)
				)
			)
			(2
				(SetFlag 181)
				(= seconds 3)
			)
			(3
				(hookBar state: (& (hookBar state:) $ffdf))
				(self dispose:)
			)
		)
	)
)

(instance hook1 of View
	(properties
		x 32
		y 49
		priority 15
		view 353
	)

	(method (show param1)
		(= cel param1)
		(super show:)
	)
)

(instance hook2 of View
	(properties
		x 65
		y 49
		priority 15
		view 353
	)

	(method (show param1)
		(= cel param1)
		(super show:)
	)
)

(instance hook3 of View
	(properties
		x 98
		y 49
		priority 15
		view 353
	)

	(method (show param1)
		(= cel param1)
		(super show:)
	)
)

(instance hook4 of View
	(properties
		x 131
		y 49
		priority 15
		view 353
	)

	(method (show param1)
		(= cel param1)
		(super show:)
	)
)

