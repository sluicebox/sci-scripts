;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Array)
(use Print)
(use Game)
(use System)

(public
	soundRegion 0
)

(class SoundManager of Script
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 5
		BAD_SELECTOR 10
		BAD_SELECTOR 0
	)

	(method (init))

	(method (BAD_SELECTOR param1 param2)
		(if (== param1 -1)
			(= BAD_SELECTOR 5)
			(= BAD_SELECTOR 10)
		else
			(= BAD_SELECTOR param1)
			(= BAD_SELECTOR param2)
		)
	)

	(method (BAD_SELECTOR param1 param2)
		(if (ResCheck rsAUDIO param1)
			(Lock rsAUDIO param1 param2)
		)
		(if (ResCheck 140 param1) ; WAVE
			(Lock 140 param1 param2) ; WAVE
		)
		(if (ResCheck rsSOUND param1)
			(Lock rsSOUND param1 param2)
		)
	)

	(method (play param1 &tmp temp0)
		(if (not argc)
			(Prints {WARNING: 0 args passed to SoundManager!})
			(return)
		else
			(= BAD_SELECTOR 0)
			(if BAD_SELECTOR
				(self sel_704: BAD_SELECTOR 0)
				(= BAD_SELECTOR 0)
			)
			(if BAD_SELECTOR
				(BAD_SELECTOR dispose:)
			)
			(= BAD_SELECTOR (IntArray new: 1))
			(= BAD_SELECTOR [param1 0])
			(if
				(and
					(OneOf gCurRoomNum 120 140 1403) ; srHallRoom, srGabeRoom
					(< (MemoryInfo 0) 1250)
				)
				(= temp0 1)
				(BAD_SELECTOR at: 1 991)
			else
				(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
					(BAD_SELECTOR at: (- temp0 1) [param1 temp0])
				)
			)
			(BAD_SELECTOR at: (- temp0 1) -1)
			(if BAD_SELECTOR
				(= BAD_SELECTOR BAD_SELECTOR)
				(self sel_704: BAD_SELECTOR 1)
				(gGk2Music number: BAD_SELECTOR loop: 1 play: self)
			else
				(= BAD_SELECTOR (BAD_SELECTOR at: (= BAD_SELECTOR 0)))
				(self sel_704: BAD_SELECTOR 1)
				(gGk2Music number: BAD_SELECTOR loop: 1 play: self)
			)
		)
	)

	(method (cue &tmp temp0)
		(cond
			((not BAD_SELECTOR) 0)
			(BAD_SELECTOR
				(self sel_704: BAD_SELECTOR 0)
				(BAD_SELECTOR dispose:)
				(= BAD_SELECTOR (= BAD_SELECTOR 0))
			)
			(BAD_SELECTOR
				(self sel_704: BAD_SELECTOR 0)
				(= BAD_SELECTOR 0)
				(self sel_703:)
			)
			(scratch
				(= scratch 0)
				(self sel_704: BAD_SELECTOR 0)
				(for
					((= temp0 BAD_SELECTOR))
					(== temp0 BAD_SELECTOR)
					((= temp0 (Random 0 (- (BAD_SELECTOR size:) 2))))
				)
				(= BAD_SELECTOR temp0)
				(= BAD_SELECTOR (BAD_SELECTOR at: BAD_SELECTOR))
				(self sel_704: BAD_SELECTOR 1)
				(gGk2Music number: BAD_SELECTOR loop: 1 play: self)
			)
			(else
				(self sel_703:)
			)
		)
	)

	(method (BAD_SELECTOR)
		(if (!= BAD_SELECTOR 0)
			(= seconds (Random BAD_SELECTOR BAD_SELECTOR))
			(= scratch 1)
		else
			(= scratch 1)
			(self cue:)
		)
	)

	(method (fade param1 param2 param3 param4 param5 &tmp temp0)
		(if (and (> argc 4) param5)
			(= temp0 param5)
		else
			(= temp0 0)
		)
		(cond
			((gGk2Music handle:)
				(if temp0
					(gGk2Music fade: param1 param2 param3 param4 temp0)
				else
					(gGk2Music fade: param1 param2 param3 param4)
				)
			)
			(temp0
				(temp0 cue:)
			)
		)
	)

	(method (stop)
		(gGk2Music stop:)
		(self sel_698: 1 cue:)
	)
)

(instance soundRegion of Rgn
	(properties)

	(method (init)
		(if (not script)
			(= script SoundManager)
			(script client: self)
			(= gSoundManager script)
		)
		(= keep 1)
	)

	(method (doVerb theVerb)
		(if (and (== modNum -1) (== (= modNum (gCurRoom modNum:)) -1))
			(= modNum gCurRoomNum)
		)
		(return
			(if
				(and
					(ResCheck rsMESSAGE modNum)
					(Message msgGET modNum noun theVerb case 1)
				)
				(gMessager say: noun theVerb case 0 0 modNum)
				1
			else
				0
			)
		)
	)
)

