;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Plane)
(use IconBar)
(use Actor)
(use System)

(public
	xMeterPanel 0
	xLeftSpell 1
	xRightSpell 2
	xStaminaPart 3
	xMagicPart 4
	xHealthPart 5
	xMonsterPart 6
	xRunButton 7
	xZapButton 8
	xFlameButton 9
	xLitButton 10
	xForceButton 11
	xFrostButton 12
	xFuzzyPanel 13
	xModeButton 14
)

(local
	local0
)

(instance xMeterPanel of SView
	(properties
		y 166
		view 810
	)
)

(instance xLeftSpell of SView
	(properties
		x 159
		y 189
		view 810
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self setInsetRect: 0 0 0 0)
		(UpdateScreenItem self)
	)
)

(instance xRightSpell of SView
	(properties
		x 119
		y 189
		view 810
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self setInsetRect: 0 0 0 -1)
		(UpdateScreenItem self)
	)
)

(instance xStaminaPart of SView
	(properties
		x -46
		y 173
		view 810
		loop 2
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (proc810_1 18))
		(+= x temp0)
		(self setInsetRect: (- 80 temp0) 0 80 2)
		(UpdateScreenItem self)
	)
)

(instance xMagicPart of SView
	(properties
		x -46
		y 181
		view 810
		loop 2
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (proc810_1 19))
		(+= x temp0)
		(self setInsetRect: (- 80 temp0) 0 80 2)
		(UpdateScreenItem self)
	)
)

(instance xHealthPart of SView
	(properties
		x -94
		y 189
		view 810
		loop 9
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(if (IsFlag 14)
			(= cel 1)
		)
		(= temp0 (proc810_1 17))
		(+= x temp0)
		(self setInsetRect: (- 104 temp0) 0 104 2)
		(UpdateScreenItem self)
	)
)

(instance xMonsterPart of SView
	(properties
		x 100
		y 189
		view 810
		loop 9
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (proc810_1 -1))
		(+= x temp0)
		(self setInsetRect: (- 104 temp0) 0 104 2)
		(UpdateScreenItem self)
	)
)

(instance xRunButton of CombatIcon
	(properties
		nsLeft 135
		nsTop 171
		x 135
		y 171
		view 810
		loop 15
	)

	(method (select)
		(= gCombatResult 3)
		(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
	)
)

(instance xZapButton of CombatIcon
	(properties
		nsLeft 175
		nsTop 171
		x 175
		y 171
		view 810
		loop 10
	)

	(method (init)
		(super init: &rest)
		(if global142
			(= cel 0)
		)
		(UpdateScreenItem self)
	)

	(method (select &tmp temp0)
		(if (and (> [gEgoStats 19] 0) (> [gEgoStats 18] 0) (not global142)) ; mana, stamina
			(= global142 (+ 5 (/ [gEgoStats 24] 10))) ; zapSpell
			(-= [gEgoStats 19] 3) ; mana
			(-= [gEgoStats 18] (Random 2 8)) ; stamina
			(= temp0 (proc810_1 19))
			(UpdateScreenItem
				(xMagicPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				(xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
			(= cel 0)
			(UpdateScreenItem self)
			(++ global166)
		)
		(return 0)
	)
)

(instance xFlameButton of CombatIcon
	(properties
		nsLeft 197
		nsTop 171
		x 197
		y 171
		view 810
		loop 11
	)

	(method (select)
		(if
			(and
				(> [gEgoStats 19] 0) ; mana
				(> [gEgoStats 18] 0) ; stamina
				(not (gEgoSpell active:))
				(not (gCombatEgoActor script:))
			)
			(= global367 10)
			(= global165 20)
			(++ global172)
			(gEgoSpell type: 26)
			(gCombatEgoActor setScript: (ScriptID 41 0) 0 self) ; xToCastSpell
		)
		(return 0)
	)
)

(instance xLitButton of CombatIcon
	(properties
		nsLeft 219
		nsTop 171
		x 219
		y 171
		view 810
		loop 12
	)

	(method (select)
		(if
			(and
				(> [gEgoStats 19] 0) ; mana
				(> [gEgoStats 18] 0) ; stamina
				(not (gEgoSpell active:))
				(not (gCombatEgoActor script:))
			)
			(= global367 8)
			(= global165 16)
			(++ global174)
			(gEgoSpell type: 33)
			(gCombatEgoActor setScript: (ScriptID 41 0) 0 self) ; xToCastSpell
		)
		(return 0)
	)
)

(instance xForceButton of CombatIcon
	(properties
		nsLeft 241
		nsTop 171
		x 241
		y 171
		view 810
		loop 13
	)

	(method (select)
		(if
			(and
				(> [gEgoStats 19] 0) ; mana
				(> [gEgoStats 18] 0) ; stamina
				(not (gEgoSpell active:))
				(not (gCombatEgoActor script:))
			)
			(= global367 12)
			(= global165 30)
			(++ global173)
			(gEgoSpell type: 28)
			(gCombatEgoActor setScript: (ScriptID 41 0) 0 self) ; xToCastSpell
		)
		(return 0)
	)
)

(instance xFrostButton of CombatIcon
	(properties
		nsLeft 263
		nsTop 171
		x 263
		y 171
		view 810
		loop 14
	)

	(method (select)
		(if
			(and
				(> [gEgoStats 19] 0) ; mana
				(> [gEgoStats 18] 0) ; stamina
				(not (gEgoSpell active:))
				(not (gCombatEgoActor script:))
			)
			(= global367 8)
			(= global165 16)
			(++ global175)
			(gEgoSpell type: 34)
			(gCombatEgoActor setScript: (ScriptID 41 0) 0 self) ; xToCastSpell
		)
		(return 0)
	)
)

(instance xModeButton of CombatIcon
	(properties
		nsLeft 285
		nsTop 171
		x 285
		y 171
		view 810
		loop 8
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 374)
			(self hide:)
		else
			(self show:)
		)
	)

	(method (show)
		(if (& signal $0008)
			(&= signal $fff7)
			(AddScreenItem self)
			(|= -info- $0010)
		)
	)

	(method (select)
		(SetFlag 376)
		(if (not (gCombatEgoActor script:))
			(gCombatEgoActor cue:)
			(if (IsFlag 374)
				(self hide:)
			else
				(self show:)
			)
		)
		(return 0)
	)
)

(class FSView of View
	(properties)

	(method (init param1)
		(&= signal $fff7)
		(= plane (param1 plane:))
		(AddScreenItem self)
		(|= -info- $0010)
		(SetNowSeen self)
	)

	(method (select &tmp temp0)
		(while
			(not
				(OneOf
					((= temp0 ((gUser curEvent:) new:)) type:)
					2
					8
					64
				)
			)
			(temp0 localize: plane)
			(cond
				((< (temp0 x:) 125)
					(= x 125)
				)
				((> (temp0 x:) 196)
					(= x 196)
				)
				(else
					(= x (temp0 x:))
				)
			)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(temp0 localize: plane)
		(cond
			((< (temp0 x:) 125)
				(= x 125)
			)
			((> (temp0 x:) 196)
				(= x 196)
			)
			(else
				(= x (temp0 x:))
			)
		)
		(UpdateScreenItem self)
	)

	(method (onMe param1 param2)
		(return (and (< nsLeft param1 nsRight) (< nsTop param2 nsBottom)))
	)
)

(instance xFuzzyPanel of IconBar
	(properties)

	(method (init)
		(gGlory setCursor: (IconBarCursor view: 994 loop: 0 cel: 0 yourself:))
		(= plane (Plane new:))
		(self add: aggSlider magicSlider defenseSlider spSlider)
		(plane
			bitmap: 0
			picture: -2
			priority: (+ (GetHighPlanePri) 1)
			init: 59 62 261 137
			setBitmap: 810 1 0
			addCast: (= local0 (Cast new:))
		)
		(if (< [gEgoStats 19] 1) ; mana
			(magicSlider loop: 4 x: 20 y: 23 state: 4)
		)
		(if (and (!= gHeroType 2) (< [gEgoStats 19] 1)) ; Thief, mana
			(spSlider x: 16 y: 46 loop: 4 state: 4)
		)
		(self eachElementDo: #init self)
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(|= state $0020)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(self doit: hide:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(FrameOut)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(= temp3 (event claimed:))
		(= temp2 (self firstTrue: #onMe (event x:) (event y:)))
		(cond
			((== temp0 evMOUSEBUTTON)
				(if temp2
					(self select: temp2 1)
				else
					(= temp3 1)
					(&= state $ffdf)
				)
			)
			((and (== temp0 evKEYBOARD) (== temp1 KEY_ESCAPE))
				(= temp3 1)
				(&= state $ffdf)
			)
		)
		(return temp3)
	)

	(method (highlight))

	(method (dispose)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(DisposeList elements)
		)
		(= highlightedIcon (= curIcon (= size (= elements 0))))
		(gGlory setCursor: (IconBarCursor view: 997 loop: 0 cel: 0 yourself:))
		(DisposeClone self)
	)
)

(instance aggSlider of FSView
	(properties
		x 125
		y 15
		view 810
		loop 5
	)

	(method (init)
		(super init: &rest)
		(= nsLeft 105)
		(= nsTop 8)
		(= nsRight 201)
		(= nsBottom 19)
		(= x (+ 125 (/ (* global176 71) 10)))
		(UpdateScreenItem self)
	)

	(method (select)
		(super select:)
		(= global176 (/ (* (- x 125) 10) 71))
	)
)

(instance magicSlider of FSView
	(properties
		x 125
		y 26
		view 810
		loop 5
	)

	(method (init)
		(super init: &rest)
		(= nsLeft 105)
		(= nsTop 19)
		(= nsRight 201)
		(= nsBottom 31)
		(if (not (& state $0004))
			(= x (+ 125 (/ (* global177 71) 10)))
			(UpdateScreenItem self)
		)
	)

	(method (onMe)
		(if (& state $0004)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (select)
		(super select:)
		(= global177 (/ (* (- x 125) 10) 71))
	)
)

(instance defenseSlider of FSView
	(properties
		x 125
		y 38
		view 810
		loop 5
	)

	(method (init)
		(super init: &rest)
		(= nsLeft 105)
		(= nsTop 31)
		(= nsRight 201)
		(= nsBottom 40)
		(= x (+ 125 (/ (* global178 71) 10)))
		(UpdateScreenItem self)
	)

	(method (select)
		(super select:)
		(= global178 (/ (* (- x 125) 10) 71))
	)
)

(instance spSlider of FSView
	(properties
		x 175
		y 49
		view 810
		loop 5
	)

	(method (init)
		(super init: &rest)
		(= nsLeft 105)
		(= nsTop 42)
		(= nsRight 201)
		(= nsBottom 52)
		(if (not (& state $0004))
			(= x (+ 125 (/ (* global179 71) 10)))
			(UpdateScreenItem self)
		)
	)

	(method (onMe)
		(if (& state $0004)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (select)
		(super select:)
		(= global179 (/ (* (- x 125) 10) 71))
	)
)

